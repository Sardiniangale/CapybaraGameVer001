package com.example.capybaragamever001;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.MainThread;

import java.util.concurrent.ExecutionException;

public class GamePannel extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;

    public GamePannel(Context context){
        super(context);

        getHolder().addCallback(this);

        //Come Back to this needs fixing
        thread= new MainThread();

                setFocusable(true);


    }

    @Override

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int hight) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread-new MainThread(getHolder(),this);
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

// IF there are problems detected this will kill the program
        boolean retry=true;
        while (true){
            try {
                    thread.setRunning(false);
                    thread.join();


                  } catch(Exception e)  {e.printStackTrace(); }
            retry=false;

        }
    }
    @Override
    //Will Proccess User imputs not finished
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);

    }
// Will update our game frame by frame
    public void update(){

    }

    @Override
//Will allow imputs to be visualised
    public void Draw(Canvas canvas){
        super.draw(canvas);


    }

}
