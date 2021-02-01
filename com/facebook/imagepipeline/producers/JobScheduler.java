package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a pMb;
    private final int pMe;
    private final Runnable pMc = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ezC();
        }
    };
    private final Runnable pMd = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ezB();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState pMf = JobState.IDLE;
    @GuardedBy("this")
    long pMg = 0;
    @GuardedBy("this")
    long pMh = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes5.dex */
    public interface a {
        void d(com.facebook.imagepipeline.f.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {
        private static ScheduledExecutorService pMk;

        static ScheduledExecutorService ezF() {
            if (pMk == null) {
                pMk = Executors.newSingleThreadScheduledExecutor();
            }
            return pMk;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pMb = aVar;
        this.pMe = i;
    }

    public void ezz() {
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

    public boolean ezA() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.pMf) {
                    case IDLE:
                        j = Math.max(this.pMh + this.pMe, uptimeMillis);
                        this.pMg = uptimeMillis;
                        this.pMf = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.pMf = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    iP(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void iP(long j) {
        if (j > 0) {
            b.ezF().schedule(this.pMd, j, TimeUnit.MILLISECONDS);
        } else {
            this.pMd.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ezB() {
        this.mExecutor.execute(this.pMc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ezC() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.pMf = JobState.RUNNING;
            this.pMh = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pMb.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            ezD();
        }
    }

    private void ezD() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.pMf == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.pMh + this.pMe, uptimeMillis);
                z = true;
                this.pMg = uptimeMillis;
                this.pMf = JobState.QUEUED;
            } else {
                this.pMf = JobState.IDLE;
            }
        }
        if (z) {
            iP(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Qj(i) || com.facebook.imagepipeline.producers.b.ec(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long ezE() {
        return this.pMh - this.pMg;
    }
}
