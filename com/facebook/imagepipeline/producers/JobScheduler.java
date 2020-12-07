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
    private final a ppl;
    private final int ppo;
    private final Runnable ppm = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ewQ();
        }
    };
    private final Runnable ppn = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ewP();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState ppp = JobState.IDLE;
    @GuardedBy("this")
    long ppq = 0;
    @GuardedBy("this")
    long ppr = 0;

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
        private static ScheduledExecutorService ppu;

        static ScheduledExecutorService ewT() {
            if (ppu == null) {
                ppu = Executors.newSingleThreadScheduledExecutor();
            }
            return ppu;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.ppl = aVar;
        this.ppo = i;
    }

    public void ewN() {
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

    public boolean ewO() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.ppp) {
                    case IDLE:
                        j = Math.max(this.ppr + this.ppo, uptimeMillis);
                        this.ppq = uptimeMillis;
                        this.ppp = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.ppp = JobState.RUNNING_AND_PENDING;
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
            b.ewT().schedule(this.ppn, j, TimeUnit.MILLISECONDS);
        } else {
            this.ppn.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ewP() {
        this.mExecutor.execute(this.ppm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ewQ() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.ppp = JobState.RUNNING;
            this.ppr = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.ppl.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            ewR();
        }
    }

    private void ewR() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.ppp == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.ppr + this.ppo, uptimeMillis);
                z = true;
                this.ppq = uptimeMillis;
                this.ppp = JobState.QUEUED;
            } else {
                this.ppp = JobState.IDLE;
            }
        }
        if (z) {
            iy(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Rh(i) || com.facebook.imagepipeline.producers.b.ef(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long ewS() {
        return this.ppr - this.ppq;
    }
}
