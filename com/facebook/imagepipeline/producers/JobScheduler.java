package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a ihr;
    private final int ihu;
    private final Executor mExecutor;
    private final Runnable ihs = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bXJ();
        }
    };
    private final Runnable iht = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bXI();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d ihv = null;
    @GuardedBy("this")
    boolean ihw = false;
    @GuardedBy("this")
    JobState ihx = JobState.IDLE;
    @GuardedBy("this")
    long ihy = 0;
    @GuardedBy("this")
    long ihz = 0;

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
        private static ScheduledExecutorService ihC;

        static ScheduledExecutorService bXM() {
            if (ihC == null) {
                ihC = Executors.newSingleThreadScheduledExecutor();
            }
            return ihC;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.ihr = aVar;
        this.ihu = i;
    }

    public void bXG() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.ihv;
            this.ihv = null;
            this.ihw = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.ihv;
            this.ihv = com.facebook.imagepipeline.f.d.b(dVar);
            this.ihw = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean bXH() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.ihv, this.ihw)) {
                switch (this.ihx) {
                    case IDLE:
                        j = Math.max(this.ihz + this.ihu, uptimeMillis);
                        this.ihy = uptimeMillis;
                        this.ihx = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.ihx = JobState.RUNNING_AND_PENDING;
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
            b.bXM().schedule(this.iht, j, TimeUnit.MILLISECONDS);
        } else {
            this.iht.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXI() {
        this.mExecutor.execute(this.ihs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXJ() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.ihv;
            z = this.ihw;
            this.ihv = null;
            this.ihw = false;
            this.ihx = JobState.RUNNING;
            this.ihz = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.ihr.d(dVar, z);
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
            if (this.ihx == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.ihz + this.ihu, uptimeMillis);
                z = true;
                this.ihy = uptimeMillis;
                this.ihx = JobState.QUEUED;
            } else {
                this.ihx = JobState.IDLE;
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
        return this.ihz - this.ihy;
    }
}
