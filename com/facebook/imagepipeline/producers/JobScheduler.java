package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a jKH;
    private final int jKK;
    private final Executor mExecutor;
    private final Runnable jKI = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czX();
        }
    };
    private final Runnable jKJ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czW();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d jKL = null;
    @GuardedBy("this")
    boolean jKM = false;
    @GuardedBy("this")
    JobState jKN = JobState.IDLE;
    @GuardedBy("this")
    long jKO = 0;
    @GuardedBy("this")
    long jKP = 0;

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
        private static ScheduledExecutorService jKS;

        static ScheduledExecutorService cAa() {
            if (jKS == null) {
                jKS = Executors.newSingleThreadScheduledExecutor();
            }
            return jKS;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.jKH = aVar;
        this.jKK = i;
    }

    public void czU() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.jKL;
            this.jKL = null;
            this.jKM = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.jKL;
            this.jKL = com.facebook.imagepipeline.f.d.b(dVar);
            this.jKM = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean czV() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.jKL, this.jKM)) {
                switch (this.jKN) {
                    case IDLE:
                        j = Math.max(this.jKP + this.jKK, uptimeMillis);
                        this.jKO = uptimeMillis;
                        this.jKN = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.jKN = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    eg(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void eg(long j) {
        if (j > 0) {
            b.cAa().schedule(this.jKJ, j, TimeUnit.MILLISECONDS);
        } else {
            this.jKJ.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czW() {
        this.mExecutor.execute(this.jKI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czX() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.jKL;
            z = this.jKM;
            this.jKL = null;
            this.jKM = false;
            this.jKN = JobState.RUNNING;
            this.jKP = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.jKH.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            czY();
        }
    }

    private void czY() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.jKN == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.jKP + this.jKK, uptimeMillis);
                z = true;
                this.jKO = uptimeMillis;
                this.jKN = JobState.QUEUED;
            } else {
                this.jKN = JobState.IDLE;
            }
        }
        if (z) {
            eg(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long czZ() {
        return this.jKP - this.jKO;
    }
}
