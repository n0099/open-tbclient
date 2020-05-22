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
    private final a mzk;
    private final int mzn;
    private final Runnable mzl = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dBD();
        }
    };
    private final Runnable mzm = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dBC();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState mzo = JobState.IDLE;
    @GuardedBy("this")
    long mzp = 0;
    @GuardedBy("this")
    long mzq = 0;

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
        private static ScheduledExecutorService mzt;

        static ScheduledExecutorService dBG() {
            if (mzt == null) {
                mzt = Executors.newSingleThreadScheduledExecutor();
            }
            return mzt;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.mzk = aVar;
        this.mzn = i;
    }

    public void dBA() {
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

    public boolean dBB() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.mzo) {
                    case IDLE:
                        j = Math.max(this.mzq + this.mzn, uptimeMillis);
                        this.mzp = uptimeMillis;
                        this.mzo = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.mzo = JobState.RUNNING_AND_PENDING;
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
            b.dBG().schedule(this.mzm, j, TimeUnit.MILLISECONDS);
        } else {
            this.mzm.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBC() {
        this.mExecutor.execute(this.mzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBD() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mzo = JobState.RUNNING;
            this.mzq = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.mzk.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dBE();
        }
    }

    private void dBE() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.mzo == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mzq + this.mzn, uptimeMillis);
                z = true;
                this.mzp = uptimeMillis;
                this.mzo = JobState.QUEUED;
            } else {
                this.mzo = JobState.IDLE;
            }
        }
        if (z) {
            fR(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Id(i) || com.facebook.imagepipeline.producers.b.dq(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dBF() {
        return this.mzq - this.mzp;
    }
}
