package com.star.playvideobestpractice;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;


public class MainActivity extends ActionBarActivity {

    private VideoView mVideoView;
    private Button mPlayButton;
    private Button mPauseButton;
    private Button mReplayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView) findViewById(R.id.video_view);
        mPlayButton = (Button) findViewById(R.id.play);
        mPauseButton = (Button) findViewById(R.id.pause);
        mReplayButton = (Button) findViewById(R.id.replay);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mVideoView.isPlaying()) {
                    mVideoView.start();
                }
            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                }
            }
        });

        mReplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoView.isPlaying()) {
                    mVideoView.resume();
                }
            }
        });

        initVideoPath();
    }

    private void initVideoPath() {
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "Taylor Swift-Safe And Sound.mp4");

        mVideoView.setVideoPath(file.getPath());
    }

    @Override
    protected void onDestroy() {

        if (mVideoView != null) {
            mVideoView.suspend();
        }

        super.onDestroy();
    }
}
