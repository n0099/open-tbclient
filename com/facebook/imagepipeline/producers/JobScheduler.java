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
    private final a pGt;
    private final int pGw;
    private final Runnable pGu = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.eBc();
        }
    };
    private final Runnable pGv = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.eBb();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState pGx = JobState.IDLE;
    @GuardedBy("this")
    long pGy = 0;
    @GuardedBy("this")
    long pGz = 0;

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
        private static ScheduledExecutorService pGC;

        static ScheduledExecutorService eBf() {
            if (pGC == null) {
                pGC = Executors.newSingleThreadScheduledExecutor();
            }
            return pGC;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pGt = aVar;
        this.pGw = i;
    }

    public void eAZ() {
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

    public boolean eBa() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.pGx) {
                    case IDLE:
                        j = Math.max(this.pGz + this.pGw, uptimeMillis);
                        this.pGy = uptimeMillis;
                        this.pGx = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.pGx = JobState.RUNNING_AND_PENDING;
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
            b.eBf().schedule(this.pGv, j, TimeUnit.MILLISECONDS);
        } else {
            this.pGv.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eBb() {
        this.mExecutor.execute(this.pGu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eBc() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.pGx = JobState.RUNNING;
            this.pGz = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pGt.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            eBd();
        }
    }

    private void eBd() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.pGx == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.pGz + this.pGw, uptimeMillis);
                z = true;
                this.pGy = uptimeMillis;
                this.pGx = JobState.QUEUED;
            } else {
                this.pGx = JobState.IDLE;
            }
        }
        if (z) {
            iM(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Rv(i) || com.facebook.imagepipeline.producers.b.ef(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long eBe() {
        return this.pGz - this.pGy;
    }
}
