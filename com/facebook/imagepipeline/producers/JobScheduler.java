package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a kjS;
    private final int kjV;
    private final Executor mExecutor;
    private final Runnable kjT = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cKU();
        }
    };
    private final Runnable kjU = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cKT();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d kjW = null;
    @GuardedBy("this")
    boolean kjX = false;
    @GuardedBy("this")
    JobState kjY = JobState.IDLE;
    @GuardedBy("this")
    long kjZ = 0;
    @GuardedBy("this")
    long kka = 0;

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
        private static ScheduledExecutorService kkd;

        static ScheduledExecutorService cKX() {
            if (kkd == null) {
                kkd = Executors.newSingleThreadScheduledExecutor();
            }
            return kkd;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.kjS = aVar;
        this.kjV = i;
    }

    public void cKR() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.kjW;
            this.kjW = null;
            this.kjX = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.kjW;
            this.kjW = com.facebook.imagepipeline.f.d.b(dVar);
            this.kjX = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cKS() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.kjW, this.kjX)) {
                switch (this.kjY) {
                    case IDLE:
                        j = Math.max(this.kka + this.kjV, uptimeMillis);
                        this.kjZ = uptimeMillis;
                        this.kjY = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.kjY = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    eM(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void eM(long j) {
        if (j > 0) {
            b.cKX().schedule(this.kjU, j, TimeUnit.MILLISECONDS);
        } else {
            this.kjU.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKT() {
        this.mExecutor.execute(this.kjT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKU() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.kjW;
            z = this.kjX;
            this.kjW = null;
            this.kjX = false;
            this.kjY = JobState.RUNNING;
            this.kka = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.kjS.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cKV();
        }
    }

    private void cKV() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.kjY == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.kka + this.kjV, uptimeMillis);
                z = true;
                this.kjZ = uptimeMillis;
                this.kjY = JobState.QUEUED;
            } else {
                this.kjY = JobState.IDLE;
            }
        }
        if (z) {
            eM(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cKW() {
        return this.kka - this.kjZ;
    }
}
