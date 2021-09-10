package com.facebook.datasource;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public abstract class AbstractDataSource<T> implements DataSource<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public DataSourceStatus mDataSourceStatus;
    @GuardedBy("this")
    public Throwable mFailureThrowable;
    @GuardedBy("this")
    public boolean mIsClosed;
    @GuardedBy("this")
    public float mProgress;
    @GuardedBy("this")
    @Nullable
    public T mResult;
    public final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class DataSourceStatus {
        public static final /* synthetic */ DataSourceStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DataSourceStatus FAILURE;
        public static final DataSourceStatus IN_PROGRESS;
        public static final DataSourceStatus SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1197963646, "Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1197963646, "Lcom/facebook/datasource/AbstractDataSource$DataSourceStatus;");
                    return;
                }
            }
            IN_PROGRESS = new DataSourceStatus("IN_PROGRESS", 0);
            SUCCESS = new DataSourceStatus(c.f36199g, 1);
            DataSourceStatus dataSourceStatus = new DataSourceStatus("FAILURE", 2);
            FAILURE = dataSourceStatus;
            $VALUES = new DataSourceStatus[]{IN_PROGRESS, SUCCESS, dataSourceStatus};
        }

        public DataSourceStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DataSourceStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DataSourceStatus) Enum.valueOf(DataSourceStatus.class, str) : (DataSourceStatus) invokeL.objValue;
        }

        public static DataSourceStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DataSourceStatus[]) $VALUES.clone() : (DataSourceStatus[]) invokeV.objValue;
        }
    }

    public AbstractDataSource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResult = null;
        this.mFailureThrowable = null;
        this.mProgress = 0.0f;
        this.mIsClosed = false;
        this.mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
        this.mSubscribers = new ConcurrentLinkedQueue<>();
    }

    private void notifyDataSubscriber(DataSubscriber<T> dataSubscriber, Executor executor, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{dataSubscriber, executor, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            executor.execute(new Runnable(this, z, dataSubscriber, z2) { // from class: com.facebook.datasource.AbstractDataSource.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractDataSource this$0;
                public final /* synthetic */ DataSubscriber val$dataSubscriber;
                public final /* synthetic */ boolean val$isCancellation;
                public final /* synthetic */ boolean val$isFailure;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), dataSubscriber, Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isFailure = z;
                    this.val$dataSubscriber = dataSubscriber;
                    this.val$isCancellation = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$isFailure) {
                            this.val$dataSubscriber.onFailure(this.this$0);
                        } else if (this.val$isCancellation) {
                            this.val$dataSubscriber.onCancellation(this.this$0);
                        } else {
                            this.val$dataSubscriber.onNewResult(this.this$0);
                        }
                    }
                }
            });
        }
    }

    private void notifyDataSubscribers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            boolean hasFailed = hasFailed();
            boolean wasCancelled = wasCancelled();
            Iterator<Pair<DataSubscriber<T>, Executor>> it = this.mSubscribers.iterator();
            while (it.hasNext()) {
                Pair<DataSubscriber<T>, Executor> next = it.next();
                notifyDataSubscriber((DataSubscriber) next.first, (Executor) next.second, hasFailed, wasCancelled);
            }
        }
    }

    private synchronized boolean setFailureInternal(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, th)) == null) {
            synchronized (this) {
                if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                    this.mDataSourceStatus = DataSourceStatus.FAILURE;
                    this.mFailureThrowable = th;
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private synchronized boolean setProgressInternal(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, this, f2)) == null) {
            synchronized (this) {
                if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                    if (f2 < this.mProgress) {
                        return false;
                    }
                    this.mProgress = f2;
                    return true;
                }
                return false;
            }
        }
        return invokeF.booleanValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x003d -> B:34:0x003e). Please submit an issue!!! */
    private boolean setResultInternal(@Nullable T t, boolean z) {
        InterceptResult invokeLZ;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, this, t, z)) != null) {
            return invokeLZ.booleanValue;
        }
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    try {
                        if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                            if (z) {
                                this.mDataSourceStatus = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.mResult != t) {
                                T t4 = this.mResult;
                                try {
                                    this.mResult = t;
                                    t2 = t4;
                                } catch (Throwable th) {
                                    th = th;
                                    t3 = t4;
                                    throw th;
                                }
                            } else {
                                t2 = null;
                            }
                            return true;
                        }
                        if (t != null) {
                            closeResult(t);
                        }
                        return false;
                    } catch (Throwable th2) {
                        t3 = t;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } finally {
            if (t3 != null) {
                closeResult(t3);
            }
        }
    }

    private synchronized boolean wasCancelled() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            synchronized (this) {
                if (isClosed()) {
                    z = isFinished() ? false : true;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                this.mIsClosed = true;
                T t = this.mResult;
                this.mResult = null;
                if (t != null) {
                    closeResult(t);
                }
                if (!isFinished()) {
                    notifyDataSubscribers();
                }
                synchronized (this) {
                    this.mSubscribers.clear();
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void closeResult(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
        }
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized Throwable getFailureCause() {
        InterceptResult invokeV;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                th = this.mFailureThrowable;
            }
            return th;
        }
        return (Throwable) invokeV.objValue;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        InterceptResult invokeV;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                f2 = this.mProgress;
            }
            return f2;
        }
        return invokeV.floatValue;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized T getResult() {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                t = this.mResult;
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasFailed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                z = this.mDataSourceStatus == DataSourceStatus.FAILURE;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasMultipleResults() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                z = this.mResult != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                z = this.mIsClosed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isFinished() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                z = this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void notifyProgressUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Iterator<Pair<DataSubscriber<T>, Executor>> it = this.mSubscribers.iterator();
            while (it.hasNext()) {
                Pair<DataSubscriber<T>, Executor> next = it.next();
                ((Executor) next.second).execute(new Runnable(this, (DataSubscriber) next.first) { // from class: com.facebook.datasource.AbstractDataSource.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AbstractDataSource this$0;
                    public final /* synthetic */ DataSubscriber val$subscriber;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$subscriber = r7;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$subscriber.onProgressUpdate(this.this$0);
                        }
                    }
                });
            }
        }
    }

    public boolean setFailure(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, th)) == null) {
            boolean failureInternal = setFailureInternal(th);
            if (failureInternal) {
                notifyDataSubscribers();
            }
            return failureInternal;
        }
        return invokeL.booleanValue;
    }

    public boolean setProgress(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            boolean progressInternal = setProgressInternal(f2);
            if (progressInternal) {
                notifyProgressUpdate();
            }
            return progressInternal;
        }
        return invokeF.booleanValue;
    }

    public boolean setResult(@Nullable T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, t, z)) == null) {
            boolean resultInternal = setResultInternal(t, z);
            if (resultInternal) {
                notifyDataSubscribers();
            }
            return resultInternal;
        }
        return invokeLZ.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.datasource.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void subscribe(DataSubscriber<T> dataSubscriber, Executor executor) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048590, this, dataSubscriber, executor) != null) {
            return;
        }
        Preconditions.checkNotNull(dataSubscriber);
        Preconditions.checkNotNull(executor);
        synchronized (this) {
            if (this.mIsClosed) {
                return;
            }
            if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                this.mSubscribers.add(Pair.create(dataSubscriber, executor));
            }
            if (!hasResult() && !isFinished() && !wasCancelled()) {
                z = false;
                if (z) {
                    return;
                }
                notifyDataSubscriber(dataSubscriber, executor, hasFailed(), wasCancelled());
                return;
            }
            z = true;
            if (z) {
            }
        }
    }
}
