package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class JobScheduler {
    private final a lXE;
    private final int lXH;
    private final Executor mExecutor;
    private final Runnable lXF = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dsq();
        }
    };
    private final Runnable lXG = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dsp();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState lXI = JobState.IDLE;
    @GuardedBy("this")
    long lXJ = 0;
    @GuardedBy("this")
    long lXK = 0;

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
        private static ScheduledExecutorService lXN;

        static ScheduledExecutorService dst() {
            if (lXN == null) {
                lXN = Executors.newSingleThreadScheduledExecutor();
            }
            return lXN;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.lXE = aVar;
        this.lXH = i;
    }

    public void dsn() {
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

    public boolean dso() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.lXI) {
                    case IDLE:
                        j = Math.max(this.lXK + this.lXH, uptimeMillis);
                        this.lXJ = uptimeMillis;
                        this.lXI = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.lXI = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    fl(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void fl(long j) {
        if (j > 0) {
            b.dst().schedule(this.lXG, j, TimeUnit.MILLISECONDS);
        } else {
            this.lXG.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsp() {
        this.mExecutor.execute(this.lXF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsq() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.lXI = JobState.RUNNING;
            this.lXK = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.lXE.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dsr();
        }
    }

    private void dsr() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.lXI == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.lXK + this.lXH, uptimeMillis);
                z = true;
                this.lXJ = uptimeMillis;
                this.lXI = JobState.QUEUED;
            } else {
                this.lXI = JobState.IDLE;
            }
        }
        if (z) {
            fl(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.IP(i) || com.facebook.imagepipeline.producers.b.dB(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dss() {
        return this.lXK - this.lXJ;
    }
}
