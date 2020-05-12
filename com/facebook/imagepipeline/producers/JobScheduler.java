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
    private final a mft;
    private final int mfw;
    private final Runnable mfu = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dum();
        }
    };
    private final Runnable mfv = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dul();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState mfx = JobState.IDLE;
    @GuardedBy("this")
    long mfy = 0;
    @GuardedBy("this")
    long mfz = 0;

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
        private static ScheduledExecutorService mfC;

        static ScheduledExecutorService dup() {
            if (mfC == null) {
                mfC = Executors.newSingleThreadScheduledExecutor();
            }
            return mfC;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.mft = aVar;
        this.mfw = i;
    }

    public void duj() {
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

    public boolean duk() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.mfx) {
                    case IDLE:
                        j = Math.max(this.mfz + this.mfw, uptimeMillis);
                        this.mfy = uptimeMillis;
                        this.mfx = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.mfx = JobState.RUNNING_AND_PENDING;
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
            b.dup().schedule(this.mfv, j, TimeUnit.MILLISECONDS);
        } else {
            this.mfv.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dul() {
        this.mExecutor.execute(this.mfu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dum() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mfx = JobState.RUNNING;
            this.mfz = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.mft.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dun();
        }
    }

    private void dun() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.mfx == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mfz + this.mfw, uptimeMillis);
                z = true;
                this.mfy = uptimeMillis;
                this.mfx = JobState.QUEUED;
            } else {
                this.mfx = JobState.IDLE;
            }
        }
        if (z) {
            fR(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Hr(i) || com.facebook.imagepipeline.producers.b.dl(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long duo() {
        return this.mfz - this.mfy;
    }
}
