package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a kcH;
    private final int kcK;
    private final Executor mExecutor;
    private final Runnable kcI = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cHP();
        }
    };
    private final Runnable kcJ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cHO();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d kcL = null;
    @GuardedBy("this")
    boolean kcM = false;
    @GuardedBy("this")
    JobState kcN = JobState.IDLE;
    @GuardedBy("this")
    long kcO = 0;
    @GuardedBy("this")
    long kcP = 0;

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
        private static ScheduledExecutorService kcS;

        static ScheduledExecutorService cHS() {
            if (kcS == null) {
                kcS = Executors.newSingleThreadScheduledExecutor();
            }
            return kcS;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.kcH = aVar;
        this.kcK = i;
    }

    public void cHM() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.kcL;
            this.kcL = null;
            this.kcM = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.kcL;
            this.kcL = com.facebook.imagepipeline.f.d.b(dVar);
            this.kcM = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cHN() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.kcL, this.kcM)) {
                switch (this.kcN) {
                    case IDLE:
                        j = Math.max(this.kcP + this.kcK, uptimeMillis);
                        this.kcO = uptimeMillis;
                        this.kcN = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.kcN = JobState.RUNNING_AND_PENDING;
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
            b.cHS().schedule(this.kcJ, j, TimeUnit.MILLISECONDS);
        } else {
            this.kcJ.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHO() {
        this.mExecutor.execute(this.kcI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHP() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.kcL;
            z = this.kcM;
            this.kcL = null;
            this.kcM = false;
            this.kcN = JobState.RUNNING;
            this.kcP = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.kcH.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cHQ();
        }
    }

    private void cHQ() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.kcN == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.kcP + this.kcK, uptimeMillis);
                z = true;
                this.kcO = uptimeMillis;
                this.kcN = JobState.QUEUED;
            } else {
                this.kcN = JobState.IDLE;
            }
        }
        if (z) {
            eE(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cHR() {
        return this.kcP - this.kcO;
    }
}
