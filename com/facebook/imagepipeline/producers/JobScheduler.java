package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a iuF;
    private final int iuI;
    private final Executor mExecutor;
    private final Runnable iuG = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.caI();
        }
    };
    private final Runnable iuH = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.caH();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d iuJ = null;
    @GuardedBy("this")
    boolean iuK = false;
    @GuardedBy("this")
    JobState iuL = JobState.IDLE;
    @GuardedBy("this")
    long iuM = 0;
    @GuardedBy("this")
    long iuN = 0;

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
        private static ScheduledExecutorService iuQ;

        static ScheduledExecutorService caL() {
            if (iuQ == null) {
                iuQ = Executors.newSingleThreadScheduledExecutor();
            }
            return iuQ;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.iuF = aVar;
        this.iuI = i;
    }

    public void caF() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.iuJ;
            this.iuJ = null;
            this.iuK = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.iuJ;
            this.iuJ = com.facebook.imagepipeline.f.d.b(dVar);
            this.iuK = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean caG() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.iuJ, this.iuK)) {
                switch (this.iuL) {
                    case IDLE:
                        j = Math.max(this.iuN + this.iuI, uptimeMillis);
                        this.iuM = uptimeMillis;
                        this.iuL = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.iuL = JobState.RUNNING_AND_PENDING;
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
            b.caL().schedule(this.iuH, j, TimeUnit.MILLISECONDS);
        } else {
            this.iuH.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caH() {
        this.mExecutor.execute(this.iuG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caI() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.iuJ;
            z = this.iuK;
            this.iuJ = null;
            this.iuK = false;
            this.iuL = JobState.RUNNING;
            this.iuN = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.iuF.d(dVar, z);
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
            if (this.iuL == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.iuN + this.iuI, uptimeMillis);
                z = true;
                this.iuM = uptimeMillis;
                this.iuL = JobState.QUEUED;
            } else {
                this.iuL = JobState.IDLE;
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
        return this.iuN - this.iuM;
    }
}
