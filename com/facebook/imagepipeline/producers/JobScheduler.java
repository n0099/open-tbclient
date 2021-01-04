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
    private final a pEM;
    private final int pEP;
    private final Runnable pEN = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.eAy();
        }
    };
    private final Runnable pEO = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.eAx();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState pEQ = JobState.IDLE;
    @GuardedBy("this")
    long pER = 0;
    @GuardedBy("this")
    long pES = 0;

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
        private static ScheduledExecutorService pEV;

        static ScheduledExecutorService eAB() {
            if (pEV == null) {
                pEV = Executors.newSingleThreadScheduledExecutor();
            }
            return pEV;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pEM = aVar;
        this.pEP = i;
    }

    public void eAv() {
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

    public boolean eAw() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.pEQ) {
                    case IDLE:
                        j = Math.max(this.pES + this.pEP, uptimeMillis);
                        this.pER = uptimeMillis;
                        this.pEQ = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.pEQ = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    iJ(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void iJ(long j) {
        if (j > 0) {
            b.eAB().schedule(this.pEO, j, TimeUnit.MILLISECONDS);
        } else {
            this.pEO.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eAx() {
        this.mExecutor.execute(this.pEN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eAy() {
        com.facebook.imagepipeline.f.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.pEQ = JobState.RUNNING;
            this.pES = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pEM.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.f.e.e(eVar);
            eAz();
        }
    }

    private void eAz() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.pEQ == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.pES + this.pEP, uptimeMillis);
                z = true;
                this.pER = uptimeMillis;
                this.pEQ = JobState.QUEUED;
            } else {
                this.pEQ = JobState.IDLE;
            }
        }
        if (z) {
            iJ(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Rf(i) || com.facebook.imagepipeline.producers.b.ed(i, 4) || com.facebook.imagepipeline.f.e.f(eVar);
    }

    public synchronized long eAA() {
        return this.pES - this.pER;
    }
}
