package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a ijc;
    private final int ijf;
    private final Executor mExecutor;
    private final Runnable ijd = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bXe();
        }
    };
    private final Runnable ije = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.bXd();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d ijg = null;
    @GuardedBy("this")
    boolean ijh = false;
    @GuardedBy("this")
    JobState iji = JobState.IDLE;
    @GuardedBy("this")
    long ijj = 0;
    @GuardedBy("this")
    long ijk = 0;

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
        private static ScheduledExecutorService ijn;

        static ScheduledExecutorService bXh() {
            if (ijn == null) {
                ijn = Executors.newSingleThreadScheduledExecutor();
            }
            return ijn;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.ijc = aVar;
        this.ijf = i;
    }

    public void bXb() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.ijg;
            this.ijg = null;
            this.ijh = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.ijg;
            this.ijg = com.facebook.imagepipeline.f.d.b(dVar);
            this.ijh = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean bXc() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.ijg, this.ijh)) {
                switch (this.iji) {
                    case IDLE:
                        j = Math.max(this.ijk + this.ijf, uptimeMillis);
                        this.ijj = uptimeMillis;
                        this.iji = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.iji = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    dp(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void dp(long j) {
        if (j > 0) {
            b.bXh().schedule(this.ije, j, TimeUnit.MILLISECONDS);
        } else {
            this.ije.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXd() {
        this.mExecutor.execute(this.ijd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXe() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.ijg;
            z = this.ijh;
            this.ijg = null;
            this.ijh = false;
            this.iji = JobState.RUNNING;
            this.ijk = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.ijc.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            bXf();
        }
    }

    private void bXf() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.iji == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.ijk + this.ijf, uptimeMillis);
                z = true;
                this.ijj = uptimeMillis;
                this.iji = JobState.QUEUED;
            } else {
                this.iji = JobState.IDLE;
            }
        }
        if (z) {
            dp(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long bXg() {
        return this.ijk - this.ijj;
    }
}
