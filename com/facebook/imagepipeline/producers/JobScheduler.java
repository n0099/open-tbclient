package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class JobScheduler {
    private final a lVY;
    private final int lWb;
    private final Executor mExecutor;
    private final Runnable lVZ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.drT();
        }
    };
    private final Runnable lWa = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.drS();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState lWc = JobState.IDLE;
    @GuardedBy("this")
    long lWd = 0;
    @GuardedBy("this")
    long lWe = 0;

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
        private static ScheduledExecutorService lWh;

        static ScheduledExecutorService drW() {
            if (lWh == null) {
                lWh = Executors.newSingleThreadScheduledExecutor();
            }
            return lWh;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.lVY = aVar;
        this.lWb = i;
    }

    public void drQ() {
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

    public boolean drR() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.lWc) {
                    case IDLE:
                        j = Math.max(this.lWe + this.lWb, uptimeMillis);
                        this.lWd = uptimeMillis;
                        this.lWc = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.lWc = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    fk(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void fk(long j) {
        if (j > 0) {
            b.drW().schedule(this.lWa, j, TimeUnit.MILLISECONDS);
        } else {
            this.lWa.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drS() {
        this.mExecutor.execute(this.lVZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drT() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.lWc = JobState.RUNNING;
            this.lWe = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.lVY.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            drU();
        }
    }

    private void drU() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.lWc == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.lWe + this.lWb, uptimeMillis);
                z = true;
                this.lWd = uptimeMillis;
                this.lWc = JobState.QUEUED;
            } else {
                this.lWc = JobState.IDLE;
            }
        }
        if (z) {
            fk(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.IJ(i) || com.facebook.imagepipeline.producers.b.dA(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long drV() {
        return this.lWe - this.lWd;
    }
}
