package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes8.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a nyP;
    private final int nyS;
    private final Runnable nyQ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dVS();
        }
    };
    private final Runnable nyR = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dVR();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState nyT = JobState.IDLE;
    @GuardedBy("this")
    long nyU = 0;
    @GuardedBy("this")
    long nyV = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes8.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class b {
        private static ScheduledExecutorService nyY;

        static ScheduledExecutorService dVV() {
            if (nyY == null) {
                nyY = Executors.newSingleThreadScheduledExecutor();
            }
            return nyY;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.nyP = aVar;
        this.nyS = i;
    }

    public void dVP() {
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

    public boolean dVQ() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.nyT) {
                    case IDLE:
                        j = Math.max(this.nyV + this.nyS, uptimeMillis);
                        this.nyU = uptimeMillis;
                        this.nyT = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.nyT = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    gy(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void gy(long j) {
        if (j > 0) {
            b.dVV().schedule(this.nyR, j, TimeUnit.MILLISECONDS);
        } else {
            this.nyR.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVR() {
        this.mExecutor.execute(this.nyQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVS() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.nyT = JobState.RUNNING;
            this.nyV = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.nyP.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dVT();
        }
    }

    private void dVT() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.nyT == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.nyV + this.nyS, uptimeMillis);
                z = true;
                this.nyU = uptimeMillis;
                this.nyT = JobState.QUEUED;
            } else {
                this.nyT = JobState.IDLE;
            }
        }
        if (z) {
            gy(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Ml(i) || com.facebook.imagepipeline.producers.b.dJ(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dVU() {
        return this.nyV - this.nyU;
    }
}
