package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a pBS;
    private final int pBV;
    private final Runnable pBT = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.exk();
        }
    };
    private final Runnable pBU = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.exj();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState pBW = JobState.IDLE;
    @GuardedBy("this")
    long pBX = 0;
    @GuardedBy("this")
    long pBY = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes3.dex */
    public interface a {
        void d(com.facebook.imagepipeline.f.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b {
        private static ScheduledExecutorService pCb;

        static ScheduledExecutorService exn() {
            if (pCb == null) {
                pCb = Executors.newSingleThreadScheduledExecutor();
            }
            return pCb;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pBS = aVar;
        this.pBV = i;
    }

    public void exh() {
        com.facebook.imagepipeline.f.e eVar;
        synchronized (this) {
            eVar = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        com.facebook.imagepipeline.f.e.e(eVar);
    }

    public boolean e(com.facebook.imagepipeline.f.e eVar, int i) {
        com.facebook.imagepipeline.f.e eVar2;
        if (!f(eVar, i)) {
            return false;
        }
        synchronized (this) {
            eVar2 = this.mEncodedImage;
            this.mEncodedImage = com.facebook.imagepipeline.f.e.b(eVar);
            this.mStatus = i;
        }
        com.facebook.imagepipeline.f.e.e(eVar2);
        return true;
    }

    public boolean exi() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.pBW) {
                    case IDLE:
                        j = Math.max(this.pBY + this.pBV, uptimeMillis);
                        this.pBX = uptimeMillis;
                        this.pBW = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.pBW = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    iM(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void iM(long j) {
        if (j > 0) {
            b.exn().schedule(this.pBU, j, TimeUnit.MILLISECONDS);
        } else {
            this.pBU.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exj() {
        this.mExecutor.execute(this.pBT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exk() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.pBW = JobState.RUNNING;
            this.pBY = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pBS.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            exl();
        }
    }

    private void exl() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.pBW == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.pBY + this.pBV, uptimeMillis);
                z = true;
                this.pBX = uptimeMillis;
                this.pBW = JobState.QUEUED;
            } else {
                this.pBW = JobState.IDLE;
            }
        }
        if (z) {
            iM(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.PO(i) || com.facebook.imagepipeline.producers.b.ef(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long exm() {
        return this.pBY - this.pBX;
    }
}
