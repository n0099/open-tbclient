package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class Timeout {
    public static /* synthetic */ Interceptable $ic;
    public static final Timeout NONE;
    public transient /* synthetic */ FieldHolder $fh;
    public long deadlineNanoTime;
    public boolean hasDeadline;
    public long timeoutNanos;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1848790459, "Lokio/Timeout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1848790459, "Lokio/Timeout;");
                return;
            }
        }
        NONE = new Timeout() { // from class: okio.Timeout.1
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

            @Override // okio.Timeout
            public Timeout deadlineNanoTime(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j)) == null) ? this : (Timeout) invokeJ.objValue;
            }

            @Override // okio.Timeout
            public void throwIfReached() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // okio.Timeout
            public Timeout timeout(long j, TimeUnit timeUnit) {
                InterceptResult invokeJL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeJL = interceptable2.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, timeUnit)) == null) ? this : (Timeout) invokeJL.objValue;
            }
        };
    }

    public Timeout() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public Timeout clearDeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.hasDeadline = false;
            return this;
        }
        return (Timeout) invokeV.objValue;
    }

    public Timeout clearTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.timeoutNanos = 0L;
            return this;
        }
        return (Timeout) invokeV.objValue;
    }

    public final Timeout deadline(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, timeUnit)) == null) {
            if (j > 0) {
                if (timeUnit != null) {
                    return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
                }
                throw new IllegalArgumentException("unit == null");
            }
            throw new IllegalArgumentException("duration <= 0: " + j);
        }
        return (Timeout) invokeJL.objValue;
    }

    public long deadlineNanoTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.hasDeadline) {
                return this.deadlineNanoTime;
            }
            throw new IllegalStateException("No deadline");
        }
        return invokeV.longValue;
    }

    public boolean hasDeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hasDeadline : invokeV.booleanValue;
    }

    public void throwIfReached() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!Thread.interrupted()) {
                if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
                    throw new InterruptedIOException("deadline reached");
                }
                return;
            }
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048583, this, j, timeUnit)) == null) {
            if (j >= 0) {
                if (timeUnit != null) {
                    this.timeoutNanos = timeUnit.toNanos(j);
                    return this;
                }
                throw new IllegalArgumentException("unit == null");
            }
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        return (Timeout) invokeJL.objValue;
    }

    public long timeoutNanos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.timeoutNanos : invokeV.longValue;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
            try {
                boolean hasDeadline = hasDeadline();
                long timeoutNanos = timeoutNanos();
                long j = 0;
                if (!hasDeadline && timeoutNanos == 0) {
                    obj.wait();
                    return;
                }
                long nanoTime = System.nanoTime();
                if (hasDeadline && timeoutNanos != 0) {
                    timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline) {
                    timeoutNanos = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos > 0) {
                    long j2 = timeoutNanos / 1000000;
                    Long.signum(j2);
                    obj.wait(j2, (int) (timeoutNanos - (1000000 * j2)));
                    j = System.nanoTime() - nanoTime;
                }
                if (j >= timeoutNanos) {
                    throw new InterruptedIOException("timeout");
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }

    public Timeout deadlineNanoTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            this.hasDeadline = true;
            this.deadlineNanoTime = j;
            return this;
        }
        return (Timeout) invokeJ.objValue;
    }
}
