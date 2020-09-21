package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
/* loaded from: classes17.dex */
abstract class AndroidSpringLooperFactory {
    AndroidSpringLooperFactory() {
    }

    public static SpringLooper createSpringLooper() {
        return Build.VERSION.SDK_INT >= 16 ? ChoreographerAndroidSpringLooper.create() : LegacyAndroidSpringLooper.create();
    }

    /* loaded from: classes17.dex */
    private static class LegacyAndroidSpringLooper extends SpringLooper {
        private final Handler mHandler;
        private long mLastTime;
        private final Runnable mLooperRunnable = new Runnable() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1
            @Override // java.lang.Runnable
            public void run() {
                if (LegacyAndroidSpringLooper.this.mStarted && LegacyAndroidSpringLooper.this.mSpringSystem != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    LegacyAndroidSpringLooper.this.mSpringSystem.loop(uptimeMillis - LegacyAndroidSpringLooper.this.mLastTime);
                    LegacyAndroidSpringLooper.this.mLastTime = uptimeMillis;
                    LegacyAndroidSpringLooper.this.mHandler.post(LegacyAndroidSpringLooper.this.mLooperRunnable);
                }
            }
        };
        private boolean mStarted;

        public static SpringLooper create() {
            return new LegacyAndroidSpringLooper(new Handler());
        }

        public LegacyAndroidSpringLooper(Handler handler) {
            this.mHandler = handler;
        }

        @Override // com.facebook.rebound.SpringLooper
        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                this.mLastTime = SystemClock.uptimeMillis();
                this.mHandler.removeCallbacks(this.mLooperRunnable);
                this.mHandler.post(this.mLooperRunnable);
            }
        }

        @Override // com.facebook.rebound.SpringLooper
        public void stop() {
            this.mStarted = false;
            this.mHandler.removeCallbacks(this.mLooperRunnable);
        }
    }

    @TargetApi(16)
    /* loaded from: classes17.dex */
    private static class ChoreographerAndroidSpringLooper extends SpringLooper {
        private final Choreographer mChoreographer;
        private final Choreographer.FrameCallback mFrameCallback = new Choreographer.FrameCallback() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (ChoreographerAndroidSpringLooper.this.mStarted && ChoreographerAndroidSpringLooper.this.mSpringSystem != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ChoreographerAndroidSpringLooper.this.mSpringSystem.loop(uptimeMillis - ChoreographerAndroidSpringLooper.this.mLastTime);
                    ChoreographerAndroidSpringLooper.this.mLastTime = uptimeMillis;
                    ChoreographerAndroidSpringLooper.this.mChoreographer.postFrameCallback(ChoreographerAndroidSpringLooper.this.mFrameCallback);
                }
            }
        };
        private long mLastTime;
        private boolean mStarted;

        public static ChoreographerAndroidSpringLooper create() {
            return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        }

        public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
            this.mChoreographer = choreographer;
        }

        @Override // com.facebook.rebound.SpringLooper
        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                this.mLastTime = SystemClock.uptimeMillis();
                this.mChoreographer.removeFrameCallback(this.mFrameCallback);
                this.mChoreographer.postFrameCallback(this.mFrameCallback);
            }
        }

        @Override // com.facebook.rebound.SpringLooper
        public void stop() {
            this.mStarted = false;
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
        }
    }
}
