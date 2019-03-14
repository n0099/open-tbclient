package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final int jKC;
    private final a jKz;
    private final Executor mExecutor;
    private final Runnable jKA = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cAa();
        }
    };
    private final Runnable jKB = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czZ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d jKD = null;
    @GuardedBy("this")
    boolean jKE = false;
    @GuardedBy("this")
    JobState jKF = JobState.IDLE;
    @GuardedBy("this")
    long jKG = 0;
    @GuardedBy("this")
    long jKH = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes2.dex */
    public interface a {
        void d(com.facebook.imagepipeline.f.d dVar, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        private static ScheduledExecutorService jKK;

        static ScheduledExecutorService cAd() {
            if (jKK == null) {
                jKK = Executors.newSingleThreadScheduledExecutor();
            }
            return jKK;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.jKz = aVar;
        this.jKC = i;
    }

    public void czX() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.jKD;
            this.jKD = null;
            this.jKE = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.jKD;
            this.jKD = com.facebook.imagepipeline.f.d.b(dVar);
            this.jKE = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean czY() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.jKD, this.jKE)) {
                switch (this.jKF) {
                    case IDLE:
                        j = Math.max(this.jKH + this.jKC, uptimeMillis);
                        this.jKG = uptimeMillis;
                        this.jKF = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.jKF = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    eg(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void eg(long j) {
        if (j > 0) {
            b.cAd().schedule(this.jKB, j, TimeUnit.MILLISECONDS);
        } else {
            this.jKB.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czZ() {
        this.mExecutor.execute(this.jKA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAa() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.jKD;
            z = this.jKE;
            this.jKD = null;
            this.jKE = false;
            this.jKF = JobState.RUNNING;
            this.jKH = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.jKz.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cAb();
        }
    }

    private void cAb() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.jKF == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.jKH + this.jKC, uptimeMillis);
                z = true;
                this.jKG = uptimeMillis;
                this.jKF = JobState.QUEUED;
            } else {
                this.jKF = JobState.IDLE;
            }
        }
        if (z) {
            eg(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cAc() {
        return this.jKH - this.jKG;
    }
}
