package com.example.capybaragamever001;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread {

    //Frame Rates
    public final static int MAX_FPS=28;
    //Average FPS=MAX FPS so the FPS during runtime is always 28
    private double averageFPS;
    private surfaceHolder surfaceHolder;
    private GamePannel gamePannel;
    private Boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolderurfaceHolder surfaceHolder, GamePannel gamePannel){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePannel = gamePannel;

    }

    @Override
    public void run(){

        //Uses intergers
        long startTime;
        long timeMills = 1000/MAX_FPS; //More FPS Code
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;

        while (running){
            // Only use Nano time for precise mesurments.
            startTime = System.nanoTime();
            canvas = null;

            try{
                canvas = surfaceHolder.lockCanvas;
                // MAIN Movement update system here

                synchronized (surfaceHolder){

                this.gamePannel.update();
                this.gamePannel.draw(canvas);

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }



    }

    }






}