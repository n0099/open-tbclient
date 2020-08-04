package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a neI;
    private final int neL;
    private final Runnable neJ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dJK();
        }
    };
    private final Runnable neK = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dJJ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState neM = JobState.IDLE;
    @GuardedBy("this")
    long neN = 0;
    @GuardedBy("this")
    long neO = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes4.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b {
        private static ScheduledExecutorService neR;

        static ScheduledExecutorService dJN() {
            if (neR == null) {
                neR = Executors.newSingleThreadScheduledExecutor();
            }
            return neR;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.neI = aVar;
        this.neL = i;
    }

    public void dJH() {
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

    public boolean dJI() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.neM) {
                    case IDLE:
                        j = Math.max(this.neO + this.neL, uptimeMillis);
                        this.neN = uptimeMillis;
                        this.neM = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.neM = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    gj(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void gj(long j) {
        if (j > 0) {
            b.dJN().schedule(this.neK, j, TimeUnit.MILLISECONDS);
        } else {
            this.neK.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJJ() {
        this.mExecutor.execute(this.neJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJK() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.neM = JobState.RUNNING;
            this.neO = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.neI.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dJL();
        }
    }

    private void dJL() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.neM == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.neO + this.neL, uptimeMillis);
                z = true;
                this.neN = uptimeMillis;
                this.neM = JobState.QUEUED;
            } else {
                this.neM = JobState.IDLE;
            }
        }
        if (z) {
            gj(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.JH(i) || com.facebook.imagepipeline.producers.b.dB(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dJM() {
        return this.neO - this.neN;
    }
}
