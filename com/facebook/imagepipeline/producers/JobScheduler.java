package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class JobScheduler {
    private final a mAu;
    private final int mAx;
    private final Executor mExecutor;
    private final Runnable mAv = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dBR();
        }
    };
    private final Runnable mAw = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dBQ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState mAy = JobState.IDLE;
    @GuardedBy("this")
    long mAz = 0;
    @GuardedBy("this")
    long mAA = 0;

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
        private static ScheduledExecutorService mAD;

        static ScheduledExecutorService dBU() {
            if (mAD == null) {
                mAD = Executors.newSingleThreadScheduledExecutor();
            }
            return mAD;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.mAu = aVar;
        this.mAx = i;
    }

    public void dBO() {
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

    public boolean dBP() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.mAy) {
                    case IDLE:
                        j = Math.max(this.mAA + this.mAx, uptimeMillis);
                        this.mAz = uptimeMillis;
                        this.mAy = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.mAy = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    fR(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void fR(long j) {
        if (j > 0) {
            b.dBU().schedule(this.mAw, j, TimeUnit.MILLISECONDS);
        } else {
            this.mAw.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBQ() {
        this.mExecutor.execute(this.mAv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBR() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mAy = JobState.RUNNING;
            this.mAA = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.mAu.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dBS();
        }
    }

    private void dBS() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.mAy == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mAA + this.mAx, uptimeMillis);
                z = true;
                this.mAz = uptimeMillis;
                this.mAy = JobState.QUEUED;
            } else {
                this.mAy = JobState.IDLE;
            }
        }
        if (z) {
            fR(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.If(i) || com.facebook.imagepipeline.producers.b.dq(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dBT() {
        return this.mAA - this.mAz;
    }
}
