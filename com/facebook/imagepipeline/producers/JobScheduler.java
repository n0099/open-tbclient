package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class JobScheduler {
    private final a jKo;
    private final int jKr;
    private final Executor mExecutor;
    private final Runnable jKp = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czN();
        }
    };
    private final Runnable jKq = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.czM();
        }
    };
    @GuardedBy("this")
    com.facebook.imagepipeline.f.d jKs = null;
    @GuardedBy("this")
    boolean jKt = false;
    @GuardedBy("this")
    JobState jKu = JobState.IDLE;
    @GuardedBy("this")
    long jKv = 0;
    @GuardedBy("this")
    long jKw = 0;

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
        private static ScheduledExecutorService jKz;

        static ScheduledExecutorService czQ() {
            if (jKz == null) {
                jKz = Executors.newSingleThreadScheduledExecutor();
            }
            return jKz;
        }
    }

    public JobScheduler(Executor executor, a aVar, int i) {
        this.mExecutor = executor;
        this.jKo = aVar;
        this.jKr = i;
    }

    public void czK() {
        com.facebook.imagepipeline.f.d dVar;
        synchronized (this) {
            dVar = this.jKs;
            this.jKs = null;
            this.jKt = false;
        }
        com.facebook.imagepipeline.f.d.e(dVar);
    }

    public boolean e(com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.f.d dVar2;
        if (!f(dVar, z)) {
            return false;
        }
        synchronized (this) {
            dVar2 = this.jKs;
            this.jKs = com.facebook.imagepipeline.f.d.b(dVar);
            this.jKt = z;
        }
        com.facebook.imagepipeline.f.d.e(dVar2);
        return true;
    }

    public boolean czL() {
        boolean z = false;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        synchronized (this) {
            if (f(this.jKs, this.jKt)) {
                switch (this.jKu) {
                    case IDLE:
                        j = Math.max(this.jKw + this.jKr, uptimeMillis);
                        this.jKv = uptimeMillis;
                        this.jKu = JobState.QUEUED;
                        z = true;
                        break;
                    case RUNNING:
                        this.jKu = JobState.RUNNING_AND_PENDING;
                        break;
                }
                if (z) {
                    eg(j - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    private void eg(long j) {
        if (j > 0) {
            b.czQ().schedule(this.jKq, j, TimeUnit.MILLISECONDS);
        } else {
            this.jKq.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czM() {
        this.mExecutor.execute(this.jKp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czN() {
        com.facebook.imagepipeline.f.d dVar;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.jKs;
            z = this.jKt;
            this.jKs = null;
            this.jKt = false;
            this.jKu = JobState.RUNNING;
            this.jKw = uptimeMillis;
        }
        try {
            if (f(dVar, z)) {
                this.jKo.d(dVar, z);
            }
        } finally {
            com.facebook.imagepipeline.f.d.e(dVar);
            czO();
        }
    }

    private void czO() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 0;
        boolean z = false;
        synchronized (this) {
            if (this.jKu == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.jKw + this.jKr, uptimeMillis);
                z = true;
                this.jKv = uptimeMillis;
                this.jKu = JobState.QUEUED;
            } else {
                this.jKu = JobState.IDLE;
            }
        }
        if (z) {
            eg(j - uptimeMillis);
        }
    }

    private static boolean f(com.facebook.imagepipeline.f.d dVar, boolean z) {
        return z || com.facebook.imagepipeline.f.d.f(dVar);
    }

    public synchronized long czP() {
        return this.jKw - this.jKv;
    }
}
