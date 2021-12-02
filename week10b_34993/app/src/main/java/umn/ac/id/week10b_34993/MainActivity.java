package umn.ac.id.week10b_34993;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Void> {
    private TextView mTextView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView1);
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setMax(100);
    }
    public void startTask(View view){
        if(!getSupportLoaderManager().hasRunningLoaders())
            getSupportLoaderManager().initLoader(0,(Bundle) null,
                    this);
    }
    @NonNull
    @Override
    public Loader<Void> onCreateLoader(int id, @Nullable Bundle args) {
        AsyncTaskLoader<Void> asyncTaskLoader =
                new ContohLoader(this,(int)(Math.random()*50)+10,this);
        asyncTaskLoader.forceLoad();
        return asyncTaskLoader;
    }
    @Override
    public void onLoadFinished(@NonNull Loader<Void> loader, Void data)
    {
        getSupportLoaderManager().destroyLoader(0);
    }