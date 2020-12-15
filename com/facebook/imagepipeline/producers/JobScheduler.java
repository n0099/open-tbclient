package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a ppn;
    private final int ppq;
    private final Runnable ppo = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ewR();
        }
    };
    private final Runnable ppp = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ewQ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState ppr = JobState.IDLE;
    @GuardedBy("this")
    long pps = 0;
    @GuardedBy("this")
    long ppt = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes15.dex */
    public interface a {
        void d(com.facebook.imagepipeline.f.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class b {
        private static ScheduledExecutorService ppw;

        static ScheduledExecutorService ewU() {
            if (ppw == null) {
                ppw = Executors.newSingleThreadScheduledExecutor();
            }
            return ppw;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.ppn = aVar;
        this.ppq = i;
    }

    public void ewO() {
        com.facebook.imagepipeline.f.e eVar;
        synchronized (this) {
            eVar = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        com.facebook.imagepipeline.f.e.e(eVar);
    }

    public boolean e(com.facebook.imagepipeline.f.e eVar, int i) {
        com.facebook.imagepipeline.f.e eVar2;
        if (!f(eVar, i)) {
            return false;
        }
        synchronized (this) {
            eVar2 = this.mEncodedImage;
            this.mEncodedImage = com.facebook.imagepipeline.f.e.b(eVar);
            this.mStatus = i;
        }
        com.facebook.imagepipeline.f.e.e(eVar2);
        return true;
    }

    public boolean ewP() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.ppr) {
                    case IDLE:
                        j = Math.max(this.ppt + this.ppq, uptimeMillis);
                        this.pps = uptimeMillis;
                        this.ppr = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.ppr = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    iy(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void iy(long j) {
        if (j > 0) {
            b.ewU().schedule(this.ppp, j, TimeUnit.MILLISECONDS);
        } else {
            this.ppp.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ewQ() {
        this.mExecutor.execute(this.ppo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ewR() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.ppr = JobState.RUNNING;
            this.ppt = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.ppn.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            ewS();
        }
    }

    private void ewS() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.ppr == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.ppt + this.ppq, uptimeMillis);
                z = true;
                this.pps = uptimeMillis;
                this.ppr = JobState.QUEUED;
            } else {
                this.ppr = JobState.IDLE;
            }
        }
        if (z) {
            iy(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Rh(i) || com.facebook.imagepipeline.producers.b.ef(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long ewT() {
        return this.ppt - this.pps;
    }
}
