package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a knv;
    private final int kny;
    private final Executor mExecutor;
    private final Runnable knw = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cMd();
        }
    };
    private final Runnable knx = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cMc();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d knz = null;
    @GuardedBy("this")
    boolean knA = false;
    @GuardedBy("this")
    JobState knB = JobState.IDLE;
    @GuardedBy("this")
    long knC = 0;
    @GuardedBy("this")
    long knD = 0;

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
        private static ScheduledExecutorService knG;

        static ScheduledExecutorService cMg() {
            if (knG == null) {
                knG = Executors.newSingleThreadScheduledExecutor();
            }
            return knG;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.knv = aVar;
        this.kny = i;
    }

    public void cMa() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.knz;
            this.knz = null;
            this.knA = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.knz;
            this.knz = com.facebook.imagepipeline.f.d.b(dVar);
            this.knA = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cMb() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.knz, this.knA)) {
                switch (this.knB) {
                    case IDLE:
                        j = Math.max(this.knD + this.kny, uptimeMillis);
                        this.knC = uptimeMillis;
                        this.knB = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.knB = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    eP(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void eP(long j) {
        if (j > 0) {
            b.cMg().schedule(this.knx, j, TimeUnit.MILLISECONDS);
        } else {
            this.knx.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMc() {
        this.mExecutor.execute(this.knw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMd() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.knz;
            z = this.knA;
            this.knz = null;
            this.knA = false;
            this.knB = JobState.RUNNING;
            this.knD = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.knv.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cMe();
        }
    }

    private void cMe() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.knB == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.knD + this.kny, uptimeMillis);
                z = true;
                this.knC = uptimeMillis;
                this.knB = JobState.QUEUED;
            } else {
                this.knB = JobState.IDLE;
            }
        }
        if (z) {
            eP(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cMf() {
        return this.knD - this.knC;
    }
}
