package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class JobScheduler {
    private final a lVe;
    private final int lVh;
    private final Executor mExecutor;
    private final Runnable lVf = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dqE();
        }
    };
    private final Runnable lVg = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dqD();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState lVi = JobState.IDLE;
    @GuardedBy("this")
    long lVj = 0;
    @GuardedBy("this")
    long lVk = 0;

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
        private static ScheduledExecutorService lVn;

        static ScheduledExecutorService dqH() {
            if (lVn == null) {
                lVn = Executors.newSingleThreadScheduledExecutor();
            }
            return lVn;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.lVe = aVar;
        this.lVh = i;
    }

    public void dqB() {
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

    public boolean dqC() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.lVi) {
                    case IDLE:
                        j = Math.max(this.lVk + this.lVh, uptimeMillis);
                        this.lVj = uptimeMillis;
                        this.lVi = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.lVi = JobState.RUNNING_AND_PENDING;
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
            b.dqH().schedule(this.lVg, j, TimeUnit.MILLISECONDS);
        } else {
            this.lVg.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqD() {
        this.mExecutor.execute(this.lVf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqE() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.lVi = JobState.RUNNING;
            this.lVk = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.lVe.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dqF();
        }
    }

    private void dqF() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.lVi == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.lVk + this.lVh, uptimeMillis);
                z = true;
                this.lVj = uptimeMillis;
                this.lVi = JobState.QUEUED;
            } else {
                this.lVi = JobState.IDLE;
            }
        }
        if (z) {
            fm(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.IE(i) || com.facebook.imagepipeline.producers.b.dx(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dqG() {
        return this.lVk - this.lVj;
    }
}
