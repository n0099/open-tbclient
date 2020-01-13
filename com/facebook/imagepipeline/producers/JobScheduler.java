package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class JobScheduler {
    private final a lUZ;
    private final int lVc;
    private final Executor mExecutor;
    private final Runnable lVa = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dqC();
        }
    };
    private final Runnable lVb = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dqB();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState lVd = JobState.IDLE;
    @GuardedBy("this")
    long lVe = 0;
    @GuardedBy("this")
    long lVf = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes10.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class b {
        private static ScheduledExecutorService lVi;

        static ScheduledExecutorService dqF() {
            if (lVi == null) {
                lVi = Executors.newSingleThreadScheduledExecutor();
            }
            return lVi;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.lUZ = aVar;
        this.lVc = i;
    }

    public void dqz() {
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

    public boolean dqA() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.lVd) {
                    case IDLE:
                        j = Math.max(this.lVf + this.lVc, uptimeMillis);
                        this.lVe = uptimeMillis;
                        this.lVd = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.lVd = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    fm(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void fm(long j) {
        if (j > 0) {
            b.dqF().schedule(this.lVb, j, TimeUnit.MILLISECONDS);
        } else {
            this.lVb.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqB() {
        this.mExecutor.execute(this.lVa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqC() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.lVd = JobState.RUNNING;
            this.lVf = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.lUZ.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dqD();
        }
    }

    private void dqD() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.lVd == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.lVf + this.lVc, uptimeMillis);
                z = true;
                this.lVe = uptimeMillis;
                this.lVd = JobState.QUEUED;
            } else {
                this.lVd = JobState.IDLE;
            }
        }
        if (z) {
            fm(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.IE(i) || com.facebook.imagepipeline.producers.b.dx(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dqE() {
        return this.lVf - this.lVe;
    }
}
