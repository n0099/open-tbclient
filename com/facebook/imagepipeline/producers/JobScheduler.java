package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a oYO;
    private final int oYR;
    private final Runnable oYP = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.erq();
        }
    };
    private final Runnable oYQ = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.erp();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState oYS = JobState.IDLE;
    @GuardedBy("this")
    long oYT = 0;
    @GuardedBy("this")
    long oYU = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes18.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class b {
        private static ScheduledExecutorService oYX;

        static ScheduledExecutorService ert() {
            if (oYX == null) {
                oYX = Executors.newSingleThreadScheduledExecutor();
            }
            return oYX;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.oYO = aVar;
        this.oYR = i;
    }

    public void ern() {
        com.facebook.imagepipeline.g.e eVar;
        synchronized (this) {
            eVar = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        com.facebook.imagepipeline.g.e.e(eVar);
    }

    public boolean e(com.facebook.imagepipeline.g.e eVar, int i) {
        com.facebook.imagepipeline.g.e eVar2;
        if (!f(eVar, i)) {
            return false;
        }
        synchronized (this) {
            eVar2 = this.mEncodedImage;
            this.mEncodedImage = com.facebook.imagepipeline.g.e.b(eVar);
            this.mStatus = i;
        }
        com.facebook.imagepipeline.g.e.e(eVar2);
        return true;
    }

    public boolean ero() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.oYS) {
                    case IDLE:
                        j = Math.max(this.oYU + this.oYR, uptimeMillis);
                        this.oYT = uptimeMillis;
                        this.oYS = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.oYS = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    hQ(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void hQ(long j) {
        if (j > 0) {
            b.ert().schedule(this.oYQ, j, TimeUnit.MILLISECONDS);
        } else {
            this.oYQ.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erp() {
        this.mExecutor.execute(this.oYP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erq() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.oYS = JobState.RUNNING;
            this.oYU = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.oYO.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            err();
        }
    }

    private void err() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.oYS == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.oYU + this.oYR, uptimeMillis);
                z = true;
                this.oYT = uptimeMillis;
                this.oYS = JobState.QUEUED;
            } else {
                this.oYS = JobState.IDLE;
            }
        }
        if (z) {
            hQ(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.PI(i) || com.facebook.imagepipeline.producers.b.dZ(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long ers() {
        return this.oYU - this.oYT;
    }
}
