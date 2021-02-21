package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a pMB;
    private final int pME;
    private final Runnable pMC = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ezK();
        }
    };
    private final Runnable pMD = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ezJ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState pMF = JobState.IDLE;
    @GuardedBy("this")
    long pMG = 0;
    @GuardedBy("this")
    long pMH = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes5.dex */
    public interface a {
        void d(com.facebook.imagepipeline.f.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {
        private static ScheduledExecutorService pMK;

        static ScheduledExecutorService ezN() {
            if (pMK == null) {
                pMK = Executors.newSingleThreadScheduledExecutor();
            }
            return pMK;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pMB = aVar;
        this.pME = i;
    }

    public void ezH() {
        com.facebook.imagepipeline.f.e eVar;
        synchronized (this) {
            eVar = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        com.facebook.imagepipeline.f.e.e(eVar);
    }

    public boolean e(com.facebook.imagepipeline.f.e eVar, int i) {
        com.facebook.imagepipeline.f.e eVar2;
        if (!f(eVar, i)) {
            return false;
        }
        synchronized (this) {
            eVar2 = this.mEncodedImage;
            this.mEncodedImage = com.facebook.imagepipeline.f.e.b(eVar);
            this.mStatus = i;
        }
        com.facebook.imagepipeline.f.e.e(eVar2);
        return true;
    }

    public boolean ezI() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.pMF) {
                    case IDLE:
                        j = Math.max(this.pMH + this.pME, uptimeMillis);
                        this.pMG = uptimeMillis;
                        this.pMF = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.pMF = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    iP(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void iP(long j) {
        if (j > 0) {
            b.ezN().schedule(this.pMD, j, TimeUnit.MILLISECONDS);
        } else {
            this.pMD.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ezJ() {
        this.mExecutor.execute(this.pMC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ezK() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.pMF = JobState.RUNNING;
            this.pMH = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pMB.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            ezL();
        }
    }

    private void ezL() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.pMF == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.pMH + this.pME, uptimeMillis);
                z = true;
                this.pMG = uptimeMillis;
                this.pMF = JobState.QUEUED;
            } else {
                this.pMF = JobState.IDLE;
            }
        }
        if (z) {
            iP(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Qk(i) || com.facebook.imagepipeline.producers.b.ed(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long ezM() {
        return this.pMH - this.pMG;
    }
}
