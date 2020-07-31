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
    private final a neG;
    private final int neJ;
    private final Runnable neH = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dJJ();
        }
    };
    private final Runnable neI = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dJI();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState neK = JobState.IDLE;
    @GuardedBy("this")
    long neL = 0;
    @GuardedBy("this")
    long neM = 0;

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
        private static ScheduledExecutorService neP;

        static ScheduledExecutorService dJM() {
            if (neP == null) {
                neP = Executors.newSingleThreadScheduledExecutor();
            }
            return neP;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.neG = aVar;
        this.neJ = i;
    }

    public void dJG() {
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

    public boolean dJH() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.neK) {
                    case IDLE:
                        j = Math.max(this.neM + this.neJ, uptimeMillis);
                        this.neL = uptimeMillis;
                        this.neK = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.neK = JobState.RUNNING_AND_PENDING;
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
            b.dJM().schedule(this.neI, j, TimeUnit.MILLISECONDS);
        } else {
            this.neI.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJI() {
        this.mExecutor.execute(this.neH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJJ() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.neK = JobState.RUNNING;
            this.neM = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.neG.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dJK();
        }
    }

    private void dJK() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.neK == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.neM + this.neJ, uptimeMillis);
                z = true;
                this.neL = uptimeMillis;
                this.neK = JobState.QUEUED;
            } else {
                this.neK = JobState.IDLE;
            }
        }
        if (z) {
            gj(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.JH(i) || com.facebook.imagepipeline.producers.b.dB(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dJL() {
        return this.neM - this.neL;
    }
}
