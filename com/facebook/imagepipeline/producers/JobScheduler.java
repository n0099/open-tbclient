package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class JobScheduler {
    private final Executor mExecutor;
    private final a pas;
    private final int pav;
    private final Runnable pat = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ero();
        }
    };
    private final Runnable pau = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.ern();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.g.e mEncodedImage = null;
    @GuardedBy("this")
    int mStatus = 0;
    @GuardedBy("this")
    JobState paw = JobState.IDLE;
    @GuardedBy("this")
    long pax = 0;
    @GuardedBy("this")
    long paz = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes15.dex */
    public interface a {
        void d(com.facebook.imagepipeline.g.e eVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class b {
        private static ScheduledExecutorService paC;

        static ScheduledExecutorService err() {
            if (paC == null) {
                paC = Executors.newSingleThreadScheduledExecutor();
            }
            return paC;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.pas = aVar;
        this.pav = i;
    }

    public void erl() {
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

    public boolean erm() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.mEncodedImage, this.mStatus)) {
                switch (this.paw) {
                    case IDLE:
                        j = Math.max(this.paz + this.pav, uptimeMillis);
                        this.pax = uptimeMillis;
                        this.paw = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.paw = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    hT(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void hT(long j) {
        if (j > 0) {
            b.err().schedule(this.pau, j, TimeUnit.MILLISECONDS);
        } else {
            this.pau.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ern() {
        this.mExecutor.execute(this.pat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ero() {
        com.facebook.imagepipeline.g.e eVar;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.paw = JobState.RUNNING;
            this.paz = uptimeMillis;
        }
        try {
            if (f(eVar, i)) {
                this.pas.d(eVar, i);
            }
        } finally {
            com.facebook.imagepipeline.g.e.e(eVar);
            erp();
        }
    }

    private void erp() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.paw == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.paz + this.pav, uptimeMillis);
                z = true;
                this.pax = uptimeMillis;
                this.paw = JobState.QUEUED;
            } else {
                this.paw = JobState.IDLE;
            }
        }
        if (z) {
            hT(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.g.e eVar, int i) {
        return com.facebook.imagepipeline.producers.b.Ql(i) || com.facebook.imagepipeline.producers.b.ea(i, 4) || com.facebook.imagepipeline.g.e.f(eVar);
    }

    public synchronized long erq() {
        return this.paz - this.pax;
    }
}
