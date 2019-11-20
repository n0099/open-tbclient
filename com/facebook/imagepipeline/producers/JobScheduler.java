package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a kkQ;
    private final int kkT;
    private final Executor mExecutor;
    private final Runnable kkR = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cIY();
        }
    };
    private final Runnable kkS = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.cIX();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d kkU = null;
    @GuardedBy("this")
    boolean kkV = false;
    @GuardedBy("this")
    JobState kkW = JobState.IDLE;
    @GuardedBy("this")
    long kkX = 0;
    @GuardedBy("this")
    long kkY = 0;

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
        private static ScheduledExecutorService klb;

        static ScheduledExecutorService cJb() {
            if (klb == null) {
                klb = Executors.newSingleThreadScheduledExecutor();
            }
            return klb;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.kkQ = aVar;
        this.kkT = i;
    }

    public void cIV() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.kkU;
            this.kkU = null;
            this.kkV = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.kkU;
            this.kkU = com.facebook.imagepipeline.f.d.b(dVar);
            this.kkV = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean cIW() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.kkU, this.kkV)) {
                switch (this.kkW) {
                    case IDLE:
                        j = Math.max(this.kkY + this.kkT, uptimeMillis);
                        this.kkX = uptimeMillis;
                        this.kkW = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.kkW = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    ei(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void ei(long j) {
        if (j > 0) {
            b.cJb().schedule(this.kkS, j, TimeUnit.MILLISECONDS);
        } else {
            this.kkS.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIX() {
        this.mExecutor.execute(this.kkR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIY() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.kkU;
            z = this.kkV;
            this.kkU = null;
            this.kkV = false;
            this.kkW = JobState.RUNNING;
            this.kkY = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.kkQ.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            cIZ();
        }
    }

    private void cIZ() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.kkW == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.kkY + this.kkT, uptimeMillis);
                z = true;
                this.kkX = uptimeMillis;
                this.kkW = JobState.QUEUED;
            } else {
                this.kkW = JobState.IDLE;
            }
        }
        if (z) {
            ei(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long cJa() {
        return this.kkY - this.kkX;
    }
}
