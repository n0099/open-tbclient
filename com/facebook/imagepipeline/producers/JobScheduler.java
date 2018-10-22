package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a ihs;
    private final int ihv;
    private final Executor mExecutor;
    private final Runnable iht = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bXJ();
        }
    };
    private final Runnable ihu = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bXI();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d ihw = null;
    @GuardedBy("this")
    boolean ihx = false;
    @GuardedBy("this")
    JobState ihy = JobState.IDLE;
    @GuardedBy("this")
    long ihz = 0;
    @GuardedBy("this")
    long ihA = 0;

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
        private static ScheduledExecutorService ihD;

        static ScheduledExecutorService bXM() {
            if (ihD == null) {
                ihD = Executors.newSingleThreadScheduledExecutor();
            }
            return ihD;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.ihs = aVar;
        this.ihv = i;
    }

    public void bXG() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.ihw;
            this.ihw = null;
            this.ihx = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.ihw;
            this.ihw = com.facebook.imagepipeline.f.d.b(dVar);
            this.ihx = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean bXH() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.ihw, this.ihx)) {
                switch (this.ihy) {
                    case IDLE:
                        j = Math.max(this.ihA + this.ihv, uptimeMillis);
                        this.ihz = uptimeMillis;
                        this.ihy = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.ihy = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    du(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void du(long j) {
        if (j > 0) {
            b.bXM().schedule(this.ihu, j, TimeUnit.MILLISECONDS);
        } else {
            this.ihu.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXI() {
        this.mExecutor.execute(this.iht);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXJ() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.ihw;
            z = this.ihx;
            this.ihw = null;
            this.ihx = false;
            this.ihy = JobState.RUNNING;
            this.ihA = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.ihs.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            bXK();
        }
    }

    private void bXK() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.ihy == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.ihA + this.ihv, uptimeMillis);
                z = true;
                this.ihz = uptimeMillis;
                this.ihy = JobState.QUEUED;
            } else {
                this.ihy = JobState.IDLE;
            }
        }
        if (z) {
            du(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long bXL() {
        return this.ihA - this.ihz;
    }
}
