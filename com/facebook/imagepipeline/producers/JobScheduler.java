package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a pOG;
    private final int pOJ;
    private final Runnable pOH = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ezT();
        }
    };
    private final Runnable pOI = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ezS();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState pOK = JobState.IDLE;
    @GuardedBy("this")
    long pOL = 0;
    @GuardedBy("this")
    long pOM = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes5.dex */
    public interface a {
        void d(com.facebook.imagepipeline.f.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {
        private static ScheduledExecutorService pOP;

        static ScheduledExecutorService ezW() {
            if (pOP == null) {
                pOP = Executors.newSingleThreadScheduledExecutor();
            }
            return pOP;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pOG = aVar;
        this.pOJ = i;
    }

    public void ezQ() {
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

    public boolean ezR() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.pOK) {
                    case IDLE:
                        j = Math.max(this.pOM + this.pOJ, uptimeMillis);
                        this.pOL = uptimeMillis;
                        this.pOK = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.pOK = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    iP(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void iP(long j) {
        if (j > 0) {
            b.ezW().schedule(this.pOI, j, TimeUnit.MILLISECONDS);
        } else {
            this.pOI.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ezS() {
        this.mExecutor.execute(this.pOH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ezT() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.pOK = JobState.RUNNING;
            this.pOM = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pOG.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            ezU();
        }
    }

    private void ezU() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.pOK == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.pOM + this.pOJ, uptimeMillis);
                z = true;
                this.pOL = uptimeMillis;
                this.pOK = JobState.QUEUED;
            } else {
                this.pOK = JobState.IDLE;
            }
        }
        if (z) {
            iP(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Qo(i) || com.facebook.imagepipeline.producers.b.ed(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long ezV() {
        return this.pOM - this.pOL;
    }
}
