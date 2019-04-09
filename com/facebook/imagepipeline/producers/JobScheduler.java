package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a jJU;
    private final int jJX;
    private final Executor mExecutor;
    private final Runnable jJV = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czT();
        }
    };
    private final Runnable jJW = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czS();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d jJY = null;
    @GuardedBy("this")
    boolean jJZ = false;
    @GuardedBy("this")
    JobState jKa = JobState.IDLE;
    @GuardedBy("this")
    long jKb = 0;
    @GuardedBy("this")
    long jKc = 0;

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
        private static ScheduledExecutorService jKf;

        static ScheduledExecutorService czW() {
            if (jKf == null) {
                jKf = Executors.newSingleThreadScheduledExecutor();
            }
            return jKf;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.jJU = aVar;
        this.jJX = i;
    }

    public void czQ() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.jJY;
            this.jJY = null;
            this.jJZ = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.jJY;
            this.jJY = com.facebook.imagepipeline.f.d.b(dVar);
            this.jJZ = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean czR() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.jJY, this.jJZ)) {
                switch (this.jKa) {
                    case IDLE:
                        j = Math.max(this.jKc + this.jJX, uptimeMillis);
                        this.jKb = uptimeMillis;
                        this.jKa = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.jKa = JobState.RUNNING_AND_PENDING;
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
            b.czW().schedule(this.jJW, j, TimeUnit.MILLISECONDS);
        } else {
            this.jJW.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czS() {
        this.mExecutor.execute(this.jJV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czT() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.jJY;
            z = this.jJZ;
            this.jJY = null;
            this.jJZ = false;
            this.jKa = JobState.RUNNING;
            this.jKc = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.jJU.d(dVar, z);
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
            if (this.jKa == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.jKc + this.jJX, uptimeMillis);
                z = true;
                this.jKb = uptimeMillis;
                this.jKa = JobState.QUEUED;
            } else {
                this.jKa = JobState.IDLE;
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
        return this.jKc - this.jKb;
    }
}
