package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a nYd;
    private final int nYg;
    private final Runnable nYe = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.edB();
        }
    };
    private final Runnable nYf = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.edA();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState nYh = JobState.IDLE;
    @GuardedBy("this")
    long nYi = 0;
    @GuardedBy("this")
    long nYj = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes18.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class b {
        private static ScheduledExecutorService nYm;

        static ScheduledExecutorService edE() {
            if (nYm == null) {
                nYm = Executors.newSingleThreadScheduledExecutor();
            }
            return nYm;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.nYd = aVar;
        this.nYg = i;
    }

    public void edy() {
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

    public boolean edz() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.nYh) {
                    case IDLE:
                        j = Math.max(this.nYj + this.nYg, uptimeMillis);
                        this.nYi = uptimeMillis;
                        this.nYh = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.nYh = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    he(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void he(long j) {
        if (j > 0) {
            b.edE().schedule(this.nYf, j, TimeUnit.MILLISECONDS);
        } else {
            this.nYf.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edA() {
        this.mExecutor.execute(this.nYe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edB() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.nYh = JobState.RUNNING;
            this.nYj = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.nYd.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            edC();
        }
    }

    private void edC() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.nYh == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.nYj + this.nYg, uptimeMillis);
                z = true;
                this.nYi = uptimeMillis;
                this.nYh = JobState.QUEUED;
            } else {
                this.nYh = JobState.IDLE;
            }
        }
        if (z) {
            he(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Nw(i) || com.facebook.imagepipeline.producers.b.dN(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long edD() {
        return this.nYj - this.nYi;
    }
}
