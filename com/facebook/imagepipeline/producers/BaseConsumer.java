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

    public BaseConsumer() {
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
        this.mIsFinished = false;
    }

    public static boolean isLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? (i2 & 1) == 1 : invokeI.booleanValue;
    }

    public static boolean isNotLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? !isLast(i2) : invokeI.booleanValue;
    }

    public static int simpleStatusForIsLast(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) ? z ? 1 : 0 : invokeZ.intValue;
    }

    public static boolean statusHasAnyFlag(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? (i2 & i3) != 0 : invokeII.booleanValue;
    }

    public static boolean statusHasFlag(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i2, i3)) == null) ? (i2 & i3) == i3 : invokeII.booleanValue;
    }

    public static int turnOffStatusFlag(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i2, i3)) == null) ? i2 & (~i3) : invokeII.intValue;
    }

    public static int turnOnStatusFlag(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) ? i2 | i3 : invokeII.intValue;
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
                } catch (Exception e2) {
                    onUnhandledException(e2);
                }
            }
        }
    }

    public abstract void onCancellationImpl();

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
                } catch (Exception e2) {
                    onUnhandledException(e2);
                }
            }
        }
    }

    public abstract void onFailureImpl(Throwable th);

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onNewResult(@Nullable T t, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, t, i2) == null) {
            synchronized (this) {
                if (this.mIsFinished) {
                    return;
                }
                this.mIsFinished = isLast(i2);
                try {
                    onNewResultImpl(t, i2);
                } catch (Exception e2) {
                    onUnhandledException(e2);
                }
            }
        }
    }

    public abstract void onNewResultImpl(T t, int i2);

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onProgressUpdate(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            synchronized (this) {
                if (this.mIsFinished) {
                    return;
                }
                try {
                    onProgressUpdateImpl(f2);
                } catch (Exception e2) {
                    onUnhandledException(e2);
                }
            }
        }
    }

    public void onProgressUpdateImpl(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
        }
    }

    public void onUnhandledException(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
            FLog.wtf(getClass(), "unhandled exception", exc);
        }
    }
}
