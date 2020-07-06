package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a mWE;
    private final int mWH;
    private final Runnable mWF = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dGx();
        }
    };
    private final Runnable mWG = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dGw();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState mWI = JobState.IDLE;
    @GuardedBy("this")
    long mWJ = 0;
    @GuardedBy("this")
    long mWK = 0;

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
        private static ScheduledExecutorService mWO;

        static ScheduledExecutorService dGA() {
            if (mWO == null) {
                mWO = Executors.newSingleThreadScheduledExecutor();
            }
            return mWO;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.mWE = aVar;
        this.mWH = i;
    }

    public void dGu() {
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

    public boolean dGv() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.mWI) {
                    case IDLE:
                        j = Math.max(this.mWK + this.mWH, uptimeMillis);
                        this.mWJ = uptimeMillis;
                        this.mWI = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.mWI = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    fW(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void fW(long j) {
        if (j > 0) {
            b.dGA().schedule(this.mWG, j, TimeUnit.MILLISECONDS);
        } else {
            this.mWG.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGw() {
        this.mExecutor.execute(this.mWF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGx() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mWI = JobState.RUNNING;
            this.mWK = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.mWE.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dGy();
        }
    }

    private void dGy() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.mWI == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mWK + this.mWH, uptimeMillis);
                z = true;
                this.mWJ = uptimeMillis;
                this.mWI = JobState.QUEUED;
            } else {
                this.mWI = JobState.IDLE;
            }
        }
        if (z) {
            fW(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Jm(i) || com.facebook.imagepipeline.producers.b.dz(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dGz() {
        return this.mWK - this.mWJ;
    }
}
