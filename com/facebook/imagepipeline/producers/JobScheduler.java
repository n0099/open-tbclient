package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final int itB;
    private final a ity;
    private final Executor mExecutor;
    private final Runnable itz = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.caa();
        }
    };
    private final Runnable itA = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bZZ();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d itC = null;
    @GuardedBy("this")
    boolean itD = false;
    @GuardedBy("this")
    JobState itE = JobState.IDLE;
    @GuardedBy("this")
    long itF = 0;
    @GuardedBy("this")
    long itG = 0;

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
        private static ScheduledExecutorService itJ;

        static ScheduledExecutorService cad() {
            if (itJ == null) {
                itJ = Executors.newSingleThreadScheduledExecutor();
            }
            return itJ;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.ity = aVar;
        this.itB = i;
    }

    public void bZX() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.itC;
            this.itC = null;
            this.itD = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.itC;
            this.itC = com.facebook.imagepipeline.f.d.b(dVar);
            this.itD = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean bZY() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.itC, this.itD)) {
                switch (this.itE) {
                    case IDLE:
                        j = Math.max(this.itG + this.itB, uptimeMillis);
                        this.itF = uptimeMillis;
                        this.itE = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.itE = JobState.RUNNING_AND_PENDING;
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
            b.cad().schedule(this.itA, j, TimeUnit.MILLISECONDS);
        } else {
            this.itA.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZZ() {
        this.mExecutor.execute(this.itz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caa() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.itC;
            z = this.itD;
            this.itC = null;
            this.itD = false;
            this.itE = JobState.RUNNING;
            this.itG = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.ity.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cab();
        }
    }

    private void cab() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.itE == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.itG + this.itB, uptimeMillis);
                z = true;
                this.itF = uptimeMillis;
                this.itE = JobState.QUEUED;
            } else {
                this.itE = JobState.IDLE;
            }
        }
        if (z) {
            dB(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cac() {
        return this.itG - this.itF;
    }
}
