package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a kcL;
    private final int kcO;
    private final Executor mExecutor;
    private final Runnable kcM = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cHQ();
        }
    };
    private final Runnable kcN = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cHP();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d kcP = null;
    @GuardedBy("this")
    boolean kcQ = false;
    @GuardedBy("this")
    JobState kcR = JobState.IDLE;
    @GuardedBy("this")
    long kcS = 0;
    @GuardedBy("this")
    long kcT = 0;

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
        private static ScheduledExecutorService kcW;

        static ScheduledExecutorService cHT() {
            if (kcW == null) {
                kcW = Executors.newSingleThreadScheduledExecutor();
            }
            return kcW;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.kcL = aVar;
        this.kcO = i;
    }

    public void cHN() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.kcP;
            this.kcP = null;
            this.kcQ = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.kcP;
            this.kcP = com.facebook.imagepipeline.f.d.b(dVar);
            this.kcQ = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cHO() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.kcP, this.kcQ)) {
                switch (this.kcR) {
                    case IDLE:
                        j = Math.max(this.kcT + this.kcO, uptimeMillis);
                        this.kcS = uptimeMillis;
                        this.kcR = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.kcR = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    eE(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void eE(long j) {
        if (j > 0) {
            b.cHT().schedule(this.kcN, j, TimeUnit.MILLISECONDS);
        } else {
            this.kcN.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHP() {
        this.mExecutor.execute(this.kcM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHQ() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.kcP;
            z = this.kcQ;
            this.kcP = null;
            this.kcQ = false;
            this.kcR = JobState.RUNNING;
            this.kcT = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.kcL.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cHR();
        }
    }

    private void cHR() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.kcR == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.kcT + this.kcO, uptimeMillis);
                z = true;
                this.kcS = uptimeMillis;
                this.kcR = JobState.QUEUED;
            } else {
                this.kcR = JobState.IDLE;
            }
        }
        if (z) {
            eE(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cHS() {
        return this.kcT - this.kcS;
    }
}
