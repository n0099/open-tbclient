package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class JobScheduler {
    public static final String QUEUE_TIME_KEY = "queueTime";
    public final Executor mExecutor;
    public final JobRunnable mJobRunnable;
    public final int mMinimumJobIntervalMs;
    public final Runnable mDoJobRunnable = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.doJob();
        }
    };
    public final Runnable mSubmitJobRunnable = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.submitJob();
        }
    };
    @VisibleForTesting
    @GuardedBy("this")
    public EncodedImage mEncodedImage = null;
    @VisibleForTesting
    @GuardedBy("this")
    public int mStatus = 0;
    @VisibleForTesting
    @GuardedBy("this")
    public JobState mJobState = JobState.IDLE;
    @VisibleForTesting
    @GuardedBy("this")
    public long mJobSubmitTime = 0;
    @VisibleForTesting
    @GuardedBy("this")
    public long mJobStartTime = 0;

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState;

        static {
            int[] iArr = new int[JobState.values().length];
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = iArr;
            try {
                iArr[JobState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface JobRunnable {
        void run(EncodedImage encodedImage, int i2);
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class JobStartExecutorSupplier {
        public static ScheduledExecutorService sJobStarterExecutor;

        public static ScheduledExecutorService get() {
            if (sJobStarterExecutor == null) {
                sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i2) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJob() {
        EncodedImage encodedImage;
        int i2;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            i2 = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mJobState = JobState.RUNNING;
            this.mJobStartTime = uptimeMillis;
        }
        try {
            if (shouldProcess(encodedImage, i2)) {
                this.mJobRunnable.run(encodedImage, i2);
            }
        } finally {
            EncodedImage.closeSafely(encodedImage);
            onJobFinished();
        }
    }

    private void enqueueJob(long j) {
        if (j > 0) {
            JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, j, TimeUnit.MILLISECONDS);
        } else {
            this.mSubmitJobRunnable.run();
        }
    }

    private void onJobFinished() {
        long j;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mJobState == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, uptimeMillis);
                z = true;
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
            } else {
                this.mJobState = JobState.IDLE;
                j = 0;
                z = false;
            }
        }
        if (z) {
            enqueueJob(j - uptimeMillis);
        }
    }

    public static boolean shouldProcess(EncodedImage encodedImage, int i2) {
        return BaseConsumer.isLast(i2) || BaseConsumer.statusHasFlag(i2, 4) || EncodedImage.isValid(encodedImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitJob() {
        this.mExecutor.execute(this.mDoJobRunnable);
    }

    public void clearJob() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        EncodedImage.closeSafely(encodedImage);
    }

    public synchronized long getQueuedTime() {
        return this.mJobStartTime - this.mJobSubmitTime;
    }

    public boolean scheduleJob() {
        long max;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (shouldProcess(this.mEncodedImage, this.mStatus)) {
                int i2 = AnonymousClass3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()];
                if (i2 != 1) {
                    if (i2 == 3) {
                        this.mJobState = JobState.RUNNING_AND_PENDING;
                    }
                    max = 0;
                } else {
                    max = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, uptimeMillis);
                    this.mJobSubmitTime = uptimeMillis;
                    this.mJobState = JobState.QUEUED;
                    z = true;
                }
                if (z) {
                    enqueueJob(max - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    public boolean updateJob(EncodedImage encodedImage, int i2) {
        EncodedImage encodedImage2;
        if (shouldProcess(encodedImage, i2)) {
            synchronized (this) {
                encodedImage2 = this.mEncodedImage;
                this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
                this.mStatus = i2;
            }
            EncodedImage.closeSafely(encodedImage2);
            return true;
        }
        return false;
    }
}
