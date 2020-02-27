package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class JobScheduler {
    private final a lVL;
    private final int lVO;
    private final Executor mExecutor;
    private final Runnable lVM = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.drQ();
        }
    };
    private final Runnable lVN = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.drP();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState lVP = JobState.IDLE;
    @GuardedBy("this")
    long lVQ = 0;
    @GuardedBy("this")
    long lVR = 0;

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
        private static ScheduledExecutorService lVU;

        static ScheduledExecutorService drT() {
            if (lVU == null) {
                lVU = Executors.newSingleThreadScheduledExecutor();
            }
            return lVU;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.lVL = aVar;
        this.lVO = i;
    }

    public void drN() {
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

    public boolean drO() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.lVP) {
                    case IDLE:
                        j = Math.max(this.lVR + this.lVO, uptimeMillis);
                        this.lVQ = uptimeMillis;
                        this.lVP = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.lVP = JobState.RUNNING_AND_PENDING;
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
            b.drT().schedule(this.lVN, j, TimeUnit.MILLISECONDS);
        } else {
            this.lVN.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drP() {
        this.mExecutor.execute(this.lVM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drQ() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.lVP = JobState.RUNNING;
            this.lVR = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.lVL.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            drR();
        }
    }

    private void drR() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.lVP == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.lVR + this.lVO, uptimeMillis);
                z = true;
                this.lVQ = uptimeMillis;
                this.lVP = JobState.QUEUED;
            } else {
                this.lVP = JobState.IDLE;
            }
        }
        if (z) {
            fk(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.IJ(i) || com.facebook.imagepipeline.producers.b.dA(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long drS() {
        return this.lVR - this.lVQ;
    }
}
