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
    private final int nyA;
    private final a nyx;
    private final Runnable nyy = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dVJ();
        }
    };
    private final Runnable nyz = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dVI();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState nyB = JobState.IDLE;
    @GuardedBy("this")
    long nyC = 0;
    @GuardedBy("this")
    long nyD = 0;

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
        private static ScheduledExecutorService nyG;

        static ScheduledExecutorService dVM() {
            if (nyG == null) {
                nyG = Executors.newSingleThreadScheduledExecutor();
            }
            return nyG;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.nyx = aVar;
        this.nyA = i;
    }

    public void dVG() {
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

    public boolean dVH() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.nyB) {
                    case IDLE:
                        j = Math.max(this.nyD + this.nyA, uptimeMillis);
                        this.nyC = uptimeMillis;
                        this.nyB = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.nyB = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    gw(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void gw(long j) {
        if (j > 0) {
            b.dVM().schedule(this.nyz, j, TimeUnit.MILLISECONDS);
        } else {
            this.nyz.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVI() {
        this.mExecutor.execute(this.nyy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVJ() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.nyB = JobState.RUNNING;
            this.nyD = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.nyx.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dVK();
        }
    }

    private void dVK() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.nyB == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.nyD + this.nyA, uptimeMillis);
                z = true;
                this.nyC = uptimeMillis;
                this.nyB = JobState.QUEUED;
            } else {
                this.nyB = JobState.IDLE;
            }
        }
        if (z) {
            gw(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Ml(i) || com.facebook.imagepipeline.producers.b.dJ(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dVL() {
        return this.nyD - this.nyC;
    }
}
