package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a klH;
    private final int klK;
    private final Executor mExecutor;
    private final Runnable klI = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cJa();
        }
    };
    private final Runnable klJ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cIZ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d klL = null;
    @GuardedBy("this")
    boolean klM = false;
    @GuardedBy("this")
    JobState klN = JobState.IDLE;
    @GuardedBy("this")
    long klO = 0;
    @GuardedBy("this")
    long klP = 0;

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
        private static ScheduledExecutorService klS;

        static ScheduledExecutorService cJd() {
            if (klS == null) {
                klS = Executors.newSingleThreadScheduledExecutor();
            }
            return klS;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.klH = aVar;
        this.klK = i;
    }

    public void cIX() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.klL;
            this.klL = null;
            this.klM = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.klL;
            this.klL = com.facebook.imagepipeline.f.d.b(dVar);
            this.klM = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cIY() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.klL, this.klM)) {
                switch (this.klN) {
                    case IDLE:
                        j = Math.max(this.klP + this.klK, uptimeMillis);
                        this.klO = uptimeMillis;
                        this.klN = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.klN = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    ej(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void ej(long j) {
        if (j > 0) {
            b.cJd().schedule(this.klJ, j, TimeUnit.MILLISECONDS);
        } else {
            this.klJ.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIZ() {
        this.mExecutor.execute(this.klI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJa() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.klL;
            z = this.klM;
            this.klL = null;
            this.klM = false;
            this.klN = JobState.RUNNING;
            this.klP = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.klH.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cJb();
        }
    }

    private void cJb() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.klN == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.klP + this.klK, uptimeMillis);
                z = true;
                this.klO = uptimeMillis;
                this.klN = JobState.QUEUED;
            } else {
                this.klN = JobState.IDLE;
            }
        }
        if (z) {
            ej(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cJc() {
        return this.klP - this.klO;
    }
}
