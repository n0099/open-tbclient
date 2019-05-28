package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a kcI;
    private final int kcL;
    private final Executor mExecutor;
    private final Runnable kcJ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cHR();
        }
    };
    private final Runnable kcK = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cHQ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d kcM = null;
    @GuardedBy("this")
    boolean kcN = false;
    @GuardedBy("this")
    JobState kcO = JobState.IDLE;
    @GuardedBy("this")
    long kcP = 0;
    @GuardedBy("this")
    long kcQ = 0;

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
        private static ScheduledExecutorService kcT;

        static ScheduledExecutorService cHU() {
            if (kcT == null) {
                kcT = Executors.newSingleThreadScheduledExecutor();
            }
            return kcT;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.kcI = aVar;
        this.kcL = i;
    }

    public void cHO() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.kcM;
            this.kcM = null;
            this.kcN = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.kcM;
            this.kcM = com.facebook.imagepipeline.f.d.b(dVar);
            this.kcN = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cHP() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.kcM, this.kcN)) {
                switch (this.kcO) {
                    case IDLE:
                        j = Math.max(this.kcQ + this.kcL, uptimeMillis);
                        this.kcP = uptimeMillis;
                        this.kcO = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.kcO = JobState.RUNNING_AND_PENDING;
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
            b.cHU().schedule(this.kcK, j, TimeUnit.MILLISECONDS);
        } else {
            this.kcK.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHQ() {
        this.mExecutor.execute(this.kcJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHR() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.kcM;
            z = this.kcN;
            this.kcM = null;
            this.kcN = false;
            this.kcO = JobState.RUNNING;
            this.kcQ = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.kcI.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cHS();
        }
    }

    private void cHS() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.kcO == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.kcQ + this.kcL, uptimeMillis);
                z = true;
                this.kcP = uptimeMillis;
                this.kcO = JobState.QUEUED;
            } else {
                this.kcO = JobState.IDLE;
            }
        }
        if (z) {
            eE(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cHT() {
        return this.kcQ - this.kcP;
    }
}
