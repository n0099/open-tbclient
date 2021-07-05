package com.yy.hiidostatis.inner.util;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes8.dex */
public class Counter implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final Callback NONE;
    public transient /* synthetic */ FieldHolder $fh;
    public final long INTERVAL;
    public final int STEP;
    public int counter;
    public Callback mCallback;
    public final Handler mHandler;
    public boolean mRunning;

    /* loaded from: classes8.dex */
    public interface Callback {
        void onCount(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(609119296, "Lcom/yy/hiidostatis/inner/util/Counter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(609119296, "Lcom/yy/hiidostatis/inner/util/Counter;");
                return;
            }
        }
        NONE = new Callback() { // from class: com.yy.hiidostatis.inner.util.Counter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.inner.util.Counter.Callback
            public void onCount(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                }
            }
        };
    }

    public Counter(Handler handler, int i2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i2), Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCallback = NONE;
        this.mRunning = false;
        this.mHandler = handler;
        this.counter = i2;
        this.INTERVAL = j;
        this.STEP = z ? 1 : -1;
        L.verbose(this, "create counter, from %d, interval %d, step %d", Integer.valueOf(this.counter), Long.valueOf(this.INTERVAL), Integer.valueOf(this.STEP));
    }

    public int count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.counter : invokeV.intValue;
    }

    public long getInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.INTERVAL : invokeV.longValue;
    }

    public Counter reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? setCounter(0) : (Counter) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            L.verbose(this, "counter run ,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
            if (this.mRunning) {
                this.mCallback.onCount(this.counter);
                this.counter += this.STEP;
                this.mHandler.postDelayed(this, this.INTERVAL);
            }
        }
    }

    public boolean running() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRunning : invokeV.booleanValue;
    }

    public void setCallback(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, callback) == null) {
            if (callback == null) {
                callback = NONE;
            }
            this.mCallback = callback;
        }
    }

    public Counter setCounter(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.counter = i2;
            L.verbose(this, "set to %d", Integer.valueOf(i2));
            return this;
        }
        return (Counter) invokeI.objValue;
    }

    public Counter start(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            this.mHandler.removeCallbacks(this);
            this.mRunning = true;
            this.mHandler.postDelayed(this, j);
            L.verbose(this, "counter start,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
            return this;
        }
        return (Counter) invokeJ.objValue;
    }

    public Counter stop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.mHandler.removeCallbacks(this);
            this.mRunning = false;
            L.verbose(this, "counter stop ,hashCode =[%d],mRunning = %b", Integer.valueOf(hashCode()), Boolean.valueOf(this.mRunning));
            return this;
        }
        return (Counter) invokeV.objValue;
    }

    public Counter toggle(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) ? z ? start(0L) : stop() : (Counter) invokeZ.objValue;
    }
}
