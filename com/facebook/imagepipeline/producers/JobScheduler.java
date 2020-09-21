package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes25.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a nIM;
    private final int nIP;
    private final Runnable nIN = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dZQ();
        }
    };
    private final Runnable nIO = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.dZP();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState nIQ = JobState.IDLE;
    @GuardedBy("this")
    long nIR = 0;
    @GuardedBy("this")
    long nIS = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes25.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class b {
        private static ScheduledExecutorService nIV;

        static ScheduledExecutorService dZT() {
            if (nIV == null) {
                nIV = Executors.newSingleThreadScheduledExecutor();
            }
            return nIV;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.nIM = aVar;
        this.nIP = i;
    }

    public void dZN() {
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

    public boolean dZO() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.nIQ) {
                    case IDLE:
                        j = Math.max(this.nIS + this.nIP, uptimeMillis);
                        this.nIR = uptimeMillis;
                        this.nIQ = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.nIQ = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    gM(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void gM(long j) {
        if (j > 0) {
            b.dZT().schedule(this.nIO, j, TimeUnit.MILLISECONDS);
        } else {
            this.nIO.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZP() {
        this.mExecutor.execute(this.nIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZQ() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.nIQ = JobState.RUNNING;
            this.nIS = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.nIM.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            dZR();
        }
    }

    private void dZR() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.nIQ == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.nIS + this.nIP, uptimeMillis);
                z = true;
                this.nIR = uptimeMillis;
                this.nIQ = JobState.QUEUED;
            } else {
                this.nIQ = JobState.IDLE;
            }
        }
        if (z) {
            gM(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.MQ(i) || com.facebook.imagepipeline.producers.b.dN(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long dZS() {
        return this.nIS - this.nIR;
    }
}
