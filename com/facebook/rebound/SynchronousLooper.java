package com.facebook.rebound;
/* loaded from: classes17.dex */
public class SynchronousLooper extends SpringLooper {
    public static double SIXTY_FPS = 16.6667d;
    private boolean mRunning;
    private double mTimeStep = SIXTY_FPS;

    public double getTimeStep() {
        return this.mTimeStep;
    }

    public void setTimeStep(double d) {
        this.mTimeStep = d;
    }

    @Override // com.facebook.rebound.SpringLooper
    public void start() {
        this.mRunning = true;
        while (!this.mSpringSystem.getIsIdle() && this.mRunning) {
            this.mSpringSystem.loop(this.mTimeStep);
        }
    }

    @Override // com.facebook.rebound.SpringLooper
    public void stop() {
        this.mRunning = false;
    }
}
