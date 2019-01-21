package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a iuG;
    private final int iuJ;
    private final Executor mExecutor;
    private final Runnable iuH = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.caI();
        }
    };
    private final Runnable iuI = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.caH();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d iuK = null;
    @GuardedBy("this")
    boolean iuL = false;
    @GuardedBy("this")
    JobState iuM = JobState.IDLE;
    @GuardedBy("this")
    long iuN = 0;
    @GuardedBy("this")
    long iuO = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes2.dex */
    public interface a {
        void d(com.facebook.imagepipeline.f.d dVar, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        private static ScheduledExecutorService iuR;

        static ScheduledExecutorService caL() {
            if (iuR == null) {
                iuR = Executors.newSingleThreadScheduledExecutor();
            }
            return iuR;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.iuG = aVar;
        this.iuJ = i;
    }

    public void caF() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.iuK;
            this.iuK = null;
            this.iuL = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.iuK;
            this.iuK = com.facebook.imagepipeline.f.d.b(dVar);
            this.iuL = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean caG() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.iuK, this.iuL)) {
                switch (this.iuM) {
                    case IDLE:
                        j = Math.max(this.iuO + this.iuJ, uptimeMillis);
                        this.iuN = uptimeMillis;
                        this.iuM = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.iuM = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    dB(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void dB(long j) {
        if (j > 0) {
            b.caL().schedule(this.iuI, j, TimeUnit.MILLISECONDS);
        } else {
            this.iuI.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caH() {
        this.mExecutor.execute(this.iuH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caI() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.iuK;
            z = this.iuL;
            this.iuK = null;
            this.iuL = false;
            this.iuM = JobState.RUNNING;
            this.iuO = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.iuG.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            caJ();
        }
    }

    private void caJ() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.iuM == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.iuO + this.iuJ, uptimeMillis);
                z = true;
                this.iuN = uptimeMillis;
                this.iuM = JobState.QUEUED;
            } else {
                this.iuM = JobState.IDLE;
            }
        }
        if (z) {
            dB(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long caK() {
        return this.iuO - this.iuN;
    }
}
