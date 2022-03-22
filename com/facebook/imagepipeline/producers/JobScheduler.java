package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class JobScheduler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String QUEUE_TIME_KEY = "queueTime";
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable mDoJobRunnable;
    @VisibleForTesting
    @GuardedBy("this")
    public EncodedImage mEncodedImage;
    public final Executor mExecutor;
    public final JobRunnable mJobRunnable;
    @VisibleForTesting
    @GuardedBy("this")
    public long mJobStartTime;
    @VisibleForTesting
    @GuardedBy("this")
    public JobState mJobState;
    @VisibleForTesting
    @GuardedBy("this")
    public long mJobSubmitTime;
    public final int mMinimumJobIntervalMs;
    @VisibleForTesting
    @GuardedBy("this")
    public int mStatus;
    public final Runnable mSubmitJobRunnable;

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2144681087, "Lcom/facebook/imagepipeline/producers/JobScheduler$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2144681087, "Lcom/facebook/imagepipeline/producers/JobScheduler$3;");
                    return;
                }
            }
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
        void run(EncodedImage encodedImage, int i);
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class JobStartExecutorSupplier {
        public static /* synthetic */ Interceptable $ic;
        public static ScheduledExecutorService sJobStarterExecutor;
        public transient /* synthetic */ FieldHolder $fh;

        public JobStartExecutorSupplier() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static ScheduledExecutorService get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (sJobStarterExecutor == null) {
                    sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
                }
                return sJobStarterExecutor;
            }
            return (ScheduledExecutorService) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class JobState {
        public static final /* synthetic */ JobState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final JobState IDLE;
        public static final JobState QUEUED;
        public static final JobState RUNNING;
        public static final JobState RUNNING_AND_PENDING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2047015472, "Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2047015472, "Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;");
                    return;
                }
            }
            IDLE = new JobState("IDLE", 0);
            QUEUED = new JobState("QUEUED", 1);
            RUNNING = new JobState(TornadoLiteRuntime.STATE_RUNNING, 2);
            JobState jobState = new JobState("RUNNING_AND_PENDING", 3);
            RUNNING_AND_PENDING = jobState;
            $VALUES = new JobState[]{IDLE, QUEUED, RUNNING, jobState};
        }

        public JobState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static JobState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (JobState) Enum.valueOf(JobState.class, str) : (JobState) invokeL.objValue;
        }

        public static JobState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (JobState[]) $VALUES.clone() : (JobState[]) invokeV.objValue;
        }
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, jobRunnable, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i;
        this.mDoJobRunnable = new Runnable(this) { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JobScheduler this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.doJob();
                }
            }
        };
        this.mSubmitJobRunnable = new Runnable(this) { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JobScheduler this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.submitJob();
                }
            }
        };
        this.mEncodedImage = null;
        this.mStatus = 0;
        this.mJobState = JobState.IDLE;
        this.mJobSubmitTime = 0L;
        this.mJobStartTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJob() {
        EncodedImage encodedImage;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            synchronized (this) {
                encodedImage = this.mEncodedImage;
                i = this.mStatus;
                this.mEncodedImage = null;
                this.mStatus = 0;
                this.mJobState = JobState.RUNNING;
                this.mJobStartTime = uptimeMillis;
            }
            try {
                if (shouldProcess(encodedImage, i)) {
                    this.mJobRunnable.run(encodedImage, i);
                }
            } finally {
                EncodedImage.closeSafely(encodedImage);
                onJobFinished();
            }
        }
    }

    private void enqueueJob(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j) == null) {
            if (j > 0) {
                JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, j, TimeUnit.MILLISECONDS);
            } else {
                this.mSubmitJobRunnable.run();
            }
        }
    }

    private void onJobFinished() {
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
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
    }

    public static boolean shouldProcess(EncodedImage encodedImage, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, encodedImage, i)) == null) ? BaseConsumer.isLast(i) || BaseConsumer.statusHasFlag(i, 4) || EncodedImage.isValid(encodedImage) : invokeLI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitJob() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mExecutor.execute(this.mDoJobRunnable);
        }
    }

    public void clearJob() {
        EncodedImage encodedImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                encodedImage = this.mEncodedImage;
                this.mEncodedImage = null;
                this.mStatus = 0;
            }
            EncodedImage.closeSafely(encodedImage);
        }
    }

    public synchronized long getQueuedTime() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                j = this.mJobStartTime - this.mJobSubmitTime;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public boolean scheduleJob() {
        InterceptResult invokeV;
        long max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            synchronized (this) {
                boolean z = false;
                if (shouldProcess(this.mEncodedImage, this.mStatus)) {
                    int i = AnonymousClass3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()];
                    if (i != 1) {
                        if (i == 3) {
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
        return invokeV.booleanValue;
    }

    public boolean updateJob(EncodedImage encodedImage, int i) {
        InterceptResult invokeLI;
        EncodedImage encodedImage2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, encodedImage, i)) == null) {
            if (shouldProcess(encodedImage, i)) {
                synchronized (this) {
                    encodedImage2 = this.mEncodedImage;
                    this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
                    this.mStatus = i;
                }
                EncodedImage.closeSafely(encodedImage2);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
