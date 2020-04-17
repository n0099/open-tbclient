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
    private final a mfp;
    private final int mfs;
    private final Runnable mfq = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.duo();
        }
    };
    private final Runnable mfr = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dun();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState mft = JobState.IDLE;
    @GuardedBy("this")
    long mfu = 0;
    @GuardedBy("this")
    long mfv = 0;

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
        private static ScheduledExecutorService mfy;

        static ScheduledExecutorService dur() {
            if (mfy == null) {
                mfy = Executors.newSingleThreadScheduledExecutor();
            }
            return mfy;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.mfp = aVar;
        this.mfs = i;
    }

    public void dul() {
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

    public boolean dum() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.mft) {
                    case IDLE:
                        j = Math.max(this.mfv + this.mfs, uptimeMillis);
                        this.mfu = uptimeMillis;
                        this.mft = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.mft = JobState.RUNNING_AND_PENDING;
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
            b.dur().schedule(this.mfr, j, TimeUnit.MILLISECONDS);
        } else {
            this.mfr.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dun() {
        this.mExecutor.execute(this.mfq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duo() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mft = JobState.RUNNING;
            this.mfv = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.mfp.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dup();
        }
    }

    private void dup() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.mft == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mfv + this.mfs, uptimeMillis);
                z = true;
                this.mfu = uptimeMillis;
                this.mft = JobState.QUEUED;
            } else {
                this.mft = JobState.IDLE;
            }
        }
        if (z) {
            fR(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Hr(i) || com.facebook.imagepipeline.producers.b.dl(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long duq() {
        return this.mfv - this.mfu;
    }
}
