package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a kkY;
    private final int klb;
    private final Executor mExecutor;
    private final Runnable kkZ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cLp();
        }
    };
    private final Runnable kla = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cLo();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d klc = null;
    @GuardedBy("this")
    boolean kld = false;
    @GuardedBy("this")
    JobState kle = JobState.IDLE;
    @GuardedBy("this")
    long klf = 0;
    @GuardedBy("this")
    long klg = 0;

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
        private static ScheduledExecutorService klj;

        static ScheduledExecutorService cLs() {
            if (klj == null) {
                klj = Executors.newSingleThreadScheduledExecutor();
            }
            return klj;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.kkY = aVar;
        this.klb = i;
    }

    public void cLm() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.klc;
            this.klc = null;
            this.kld = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.klc;
            this.klc = com.facebook.imagepipeline.f.d.b(dVar);
            this.kld = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cLn() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.klc, this.kld)) {
                switch (this.kle) {
                    case IDLE:
                        j = Math.max(this.klg + this.klb, uptimeMillis);
                        this.klf = uptimeMillis;
                        this.kle = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.kle = JobState.RUNNING_AND_PENDING;
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
            b.cLs().schedule(this.kla, j, TimeUnit.MILLISECONDS);
        } else {
            this.kla.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLo() {
        this.mExecutor.execute(this.kkZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLp() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.klc;
            z = this.kld;
            this.klc = null;
            this.kld = false;
            this.kle = JobState.RUNNING;
            this.klg = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.kkY.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cLq();
        }
    }

    private void cLq() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.kle == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.klg + this.klb, uptimeMillis);
                z = true;
                this.klf = uptimeMillis;
                this.kle = JobState.QUEUED;
            } else {
                this.kle = JobState.IDLE;
            }
        }
        if (z) {
            eM(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cLr() {
        return this.klg - this.klf;
    }
}
