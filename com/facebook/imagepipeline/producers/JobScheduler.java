package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a iqo;
    private final int iqr;
    private final Executor mExecutor;
    private final Runnable iqp = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bZj();
        }
    };
    private final Runnable iqq = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bZi();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d iqs = null;
    @GuardedBy("this")
    boolean iqt = false;
    @GuardedBy("this")
    JobState iqu = JobState.IDLE;
    @GuardedBy("this")
    long iqv = 0;
    @GuardedBy("this")
    long iqw = 0;

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
        private static ScheduledExecutorService iqz;

        static ScheduledExecutorService bZm() {
            if (iqz == null) {
                iqz = Executors.newSingleThreadScheduledExecutor();
            }
            return iqz;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.iqo = aVar;
        this.iqr = i;
    }

    public void bZg() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.iqs;
            this.iqs = null;
            this.iqt = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.iqs;
            this.iqs = com.facebook.imagepipeline.f.d.b(dVar);
            this.iqt = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean bZh() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.iqs, this.iqt)) {
                switch (this.iqu) {
                    case IDLE:
                        j = Math.max(this.iqw + this.iqr, uptimeMillis);
                        this.iqv = uptimeMillis;
                        this.iqu = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.iqu = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    dw(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void dw(long j) {
        if (j > 0) {
            b.bZm().schedule(this.iqq, j, TimeUnit.MILLISECONDS);
        } else {
            this.iqq.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZi() {
        this.mExecutor.execute(this.iqp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZj() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.iqs;
            z = this.iqt;
            this.iqs = null;
            this.iqt = false;
            this.iqu = JobState.RUNNING;
            this.iqw = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.iqo.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            bZk();
        }
    }

    private void bZk() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.iqu == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.iqw + this.iqr, uptimeMillis);
                z = true;
                this.iqv = uptimeMillis;
                this.iqu = JobState.QUEUED;
            } else {
                this.iqu = JobState.IDLE;
            }
        }
        if (z) {
            dw(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long bZl() {
        return this.iqw - this.iqv;
    }
}
