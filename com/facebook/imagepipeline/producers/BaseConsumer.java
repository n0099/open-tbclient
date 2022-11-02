package com.facebook.imagepipeline.producers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public abstract class BaseConsumer<T> implements Consumer<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsFinished;

    public static boolean isLast(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (i & 1) == 1 : invokeI.booleanValue;
    }

    public static int simpleStatusForIsLast(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) ? z ? 1 : 0 : invokeZ.intValue;
    }

    public static boolean statusHasAnyFlag(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) ? (i & i2) != 0 : invokeII.booleanValue;
    }

    public static boolean statusHasFlag(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) ? (i & i2) == i2 : invokeII.booleanValue;
    }

    public static int turnOffStatusFlag(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) ? i & (~i2) : invokeII.intValue;
    }

    public static int turnOnStatusFlag(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i, i2)) == null) ? i | i2 : invokeII.intValue;
    }

    public abstract void onCancellationImpl();

    public abstract void onFailureImpl(Throwable th);

    public abstract void onNewResultImpl(T t, int i);

    public void onProgressUpdateImpl(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
        }
    }

    public BaseConsumer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsFinished = false;
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onCancellation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.mIsFinished) {
                    return;
                }
                this.mIsFinished = true;
                try {
                    onCancellationImpl();
                } catch (Exception e) {
                    onUnhandledException(e);
                }
            }
        }
    }

    public static boolean isNotLast(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return !isLast(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onFailure(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            synchronized (this) {
                if (this.mIsFinished) {
                    return;
                }
                this.mIsFinished = true;
                try {
                    onFailureImpl(th);
                } catch (Exception e) {
                    onUnhandledException(e);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onProgressUpdate(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            synchronized (this) {
                if (this.mIsFinished) {
                    return;
                }
                try {
                    onProgressUpdateImpl(f);
                } catch (Exception e) {
                    onUnhandledException(e);
                }
            }
        }
    }

    public void onUnhandledException(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            FLog.wtf(getClass(), "unhandled exception", exc);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onNewResult(@Nullable T t, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, t, i) == null) {
            synchronized (this) {
                if (this.mIsFinished) {
                    return;
                }
                this.mIsFinished = isLast(i);
                try {
                    onNewResultImpl(t, i);
                } catch (Exception e) {
                    onUnhandledException(e);
                }
            }
        }
    }
}
