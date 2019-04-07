package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a jJT;
    private final int jJW;
    private final Executor mExecutor;
    private final Runnable jJU = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czT();
        }
    };
    private final Runnable jJV = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czS();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d jJX = null;
    @GuardedBy("this")
    boolean jJY = false;
    @GuardedBy("this")
    JobState jJZ = JobState.IDLE;
    @GuardedBy("this")
    long jKa = 0;
    @GuardedBy("this")
    long jKb = 0;

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
        private static ScheduledExecutorService jKe;

        static ScheduledExecutorService czW() {
            if (jKe == null) {
                jKe = Executors.newSingleThreadScheduledExecutor();
            }
            return jKe;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.jJT = aVar;
        this.jJW = i;
    }

    public void czQ() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.jJX;
            this.jJX = null;
            this.jJY = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.jJX;
            this.jJX = com.facebook.imagepipeline.f.d.b(dVar);
            this.jJY = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean czR() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.jJX, this.jJY)) {
                switch (this.jJZ) {
                    case IDLE:
                        j = Math.max(this.jKb + this.jJW, uptimeMillis);
                        this.jKa = uptimeMillis;
                        this.jJZ = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.jJZ = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    ef(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void ef(long j) {
        if (j > 0) {
            b.czW().schedule(this.jJV, j, TimeUnit.MILLISECONDS);
        } else {
            this.jJV.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czS() {
        this.mExecutor.execute(this.jJU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czT() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.jJX;
            z = this.jJY;
            this.jJX = null;
            this.jJY = false;
            this.jJZ = JobState.RUNNING;
            this.jKb = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.jJT.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            czU();
        }
    }

    private void czU() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.jJZ == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.jKb + this.jJW, uptimeMillis);
                z = true;
                this.jKa = uptimeMillis;
                this.jJZ = JobState.QUEUED;
            } else {
                this.jJZ = JobState.IDLE;
            }
        }
        if (z) {
            ef(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long czV() {
        return this.jKb - this.jKa;
    }
}
