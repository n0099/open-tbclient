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
    private final a oPv;
    private final int oPy;
    private final Runnable oPw = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.enA();
        }
    };
    private final Runnable oPx = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.enz();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState oPz = JobState.IDLE;
    @GuardedBy("this")
    long oPA = 0;
    @GuardedBy("this")
    long oPB = 0;

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
        private static ScheduledExecutorService oPE;

        static ScheduledExecutorService enD() {
            if (oPE == null) {
                oPE = Executors.newSingleThreadScheduledExecutor();
            }
            return oPE;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.oPv = aVar;
        this.oPy = i;
    }

    public void enx() {
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

    public boolean eny() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.oPz) {
                    case IDLE:
                        j = Math.max(this.oPB + this.oPy, uptimeMillis);
                        this.oPA = uptimeMillis;
                        this.oPz = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.oPz = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    hu(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void hu(long j) {
        if (j > 0) {
            b.enD().schedule(this.oPx, j, TimeUnit.MILLISECONDS);
        } else {
            this.oPx.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enz() {
        this.mExecutor.execute(this.oPw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enA() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.oPz = JobState.RUNNING;
            this.oPB = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.oPv.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            enB();
        }
    }

    private void enB() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.oPz == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.oPB + this.oPy, uptimeMillis);
                z = true;
                this.oPA = uptimeMillis;
                this.oPz = JobState.QUEUED;
            } else {
                this.oPz = JobState.IDLE;
            }
        }
        if (z) {
            hu(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Pn(i) || com.facebook.imagepipeline.producers.b.dW(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long enC() {
        return this.oPB - this.oPA;
    }
}
