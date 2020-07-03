package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a mWB;
    private final int mWE;
    private final Runnable mWC = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dGt();
        }
    };
    private final Runnable mWD = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dGs();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState mWF = JobState.IDLE;
    @GuardedBy("this")
    long mWG = 0;
    @GuardedBy("this")
    long mWH = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes12.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class b {
        private static ScheduledExecutorService mWK;

        static ScheduledExecutorService dGw() {
            if (mWK == null) {
                mWK = Executors.newSingleThreadScheduledExecutor();
            }
            return mWK;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.mWB = aVar;
        this.mWE = i;
    }

    public void dGq() {
        com.facebook.imagepipeline.g.e eVar;
        synchronized (this) {
            eVar = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        com.facebook.imagepipeline.g.e.e(eVar);
    }

    public boolean e(com.facebook.imagepipeline.g.e eVar, int i) {
        com.facebook.imagepipeline.g.e eVar2;
        if (!f(eVar, i)) {
            return false;
        }
        synchronized (this) {
            eVar2 = this.mEncodedImage;
            this.mEncodedImage = com.facebook.imagepipeline.g.e.b(eVar);
            this.mStatus = i;
        }
        com.facebook.imagepipeline.g.e.e(eVar2);
        return true;
    }

    public boolean dGr() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.mWF) {
                    case IDLE:
                        j = Math.max(this.mWH + this.mWE, uptimeMillis);
                        this.mWG = uptimeMillis;
                        this.mWF = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.mWF = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    fW(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void fW(long j) {
        if (j > 0) {
            b.dGw().schedule(this.mWD, j, TimeUnit.MILLISECONDS);
        } else {
            this.mWD.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGs() {
        this.mExecutor.execute(this.mWC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGt() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mWF = JobState.RUNNING;
            this.mWH = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.mWB.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dGu();
        }
    }

    private void dGu() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.mWF == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mWH + this.mWE, uptimeMillis);
                z = true;
                this.mWG = uptimeMillis;
                this.mWF = JobState.QUEUED;
            } else {
                this.mWF = JobState.IDLE;
            }
        }
        if (z) {
            fW(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Jm(i) || com.facebook.imagepipeline.producers.b.dz(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dGv() {
        return this.mWH - this.mWG;
    }
}
