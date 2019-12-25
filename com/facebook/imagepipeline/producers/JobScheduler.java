package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class JobScheduler {
    private final a lRl;
    private final int lRo;
    private final Executor mExecutor;
    private final Runnable lRm = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dps();
        }
    };
    private final Runnable lRn = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dpr();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState lRp = JobState.IDLE;
    @GuardedBy("this")
    long lRq = 0;
    @GuardedBy("this")
    long lRr = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes9.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b {
        private static ScheduledExecutorService lRu;

        static ScheduledExecutorService dpv() {
            if (lRu == null) {
                lRu = Executors.newSingleThreadScheduledExecutor();
            }
            return lRu;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.lRl = aVar;
        this.lRo = i;
    }

    public void dpp() {
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

    public boolean dpq() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.lRp) {
                    case IDLE:
                        j = Math.max(this.lRr + this.lRo, uptimeMillis);
                        this.lRq = uptimeMillis;
                        this.lRp = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.lRp = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    fh(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void fh(long j) {
        if (j > 0) {
            b.dpv().schedule(this.lRn, j, TimeUnit.MILLISECONDS);
        } else {
            this.lRn.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpr() {
        this.mExecutor.execute(this.lRm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dps() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.lRp = JobState.RUNNING;
            this.lRr = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.lRl.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dpt();
        }
    }

    private void dpt() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.lRp == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.lRr + this.lRo, uptimeMillis);
                z = true;
                this.lRq = uptimeMillis;
                this.lRp = JobState.QUEUED;
            } else {
                this.lRp = JobState.IDLE;
            }
        }
        if (z) {
            fh(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Iv(i) || com.facebook.imagepipeline.producers.b.dz(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dpu() {
        return this.lRr - this.lRq;
    }
}
