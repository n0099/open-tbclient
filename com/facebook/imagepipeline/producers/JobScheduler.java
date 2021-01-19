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
    private final a pBT;
    private final int pBW;
    private final Runnable pBU = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.exk();
        }
    };
    private final Runnable pBV = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
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
    JobState pBX = JobState.IDLE;
    @GuardedBy("this")
    long pBY = 0;
    @GuardedBy("this")
    long pBZ = 0;

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
        private static ScheduledExecutorService pCc;

        static ScheduledExecutorService exn() {
            if (pCc == null) {
                pCc = Executors.newSingleThreadScheduledExecutor();
            }
            return pCc;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pBT = aVar;
        this.pBW = i;
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
                switch (this.pBX) {
                    case IDLE:
                        j = Math.max(this.pBZ + this.pBW, uptimeMillis);
                        this.pBY = uptimeMillis;
                        this.pBX = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.pBX = JobState.RUNNING_AND_PENDING;
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
            b.exn().schedule(this.pBV, j, TimeUnit.MILLISECONDS);
        } else {
            this.pBV.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exj() {
        this.mExecutor.execute(this.pBU);
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
            this.pBX = JobState.RUNNING;
            this.pBZ = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pBT.d(eVar, i);
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
            if (this.pBX == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.pBZ + this.pBW, uptimeMillis);
                z = true;
                this.pBY = uptimeMillis;
                this.pBX = JobState.QUEUED;
            } else {
                this.pBX = JobState.IDLE;
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
        return this.pBZ - this.pBY;
    }
}
