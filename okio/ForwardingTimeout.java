package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class ForwardingTimeout extends Timeout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timeout delegate;

    public ForwardingTimeout(Timeout timeout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timeout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (timeout != null) {
            this.delegate = timeout;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.Timeout
    public Timeout clearDeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.delegate.clearDeadline();
        }
        return (Timeout) invokeV.objValue;
    }

    @Override // okio.Timeout
    public Timeout clearTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.delegate.clearTimeout();
        }
        return (Timeout) invokeV.objValue;
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.delegate.deadlineNanoTime();
        }
        return invokeV.longValue;
    }

    public final Timeout delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.delegate;
        }
        return (Timeout) invokeV.objValue;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.delegate.hasDeadline();
        }
        return invokeV.booleanValue;
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.delegate.throwIfReached();
        }
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.delegate.timeoutNanos();
        }
        return invokeV.longValue;
    }

    @Override // okio.Timeout
    public Timeout deadlineNanoTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            return this.delegate.deadlineNanoTime(j);
        }
        return (Timeout) invokeJ.objValue;
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, timeout)) == null) {
            if (timeout != null) {
                this.delegate = timeout;
                return this;
            }
            throw new IllegalArgumentException("delegate == null");
        }
        return (ForwardingTimeout) invokeL.objValue;
    }

    @Override // okio.Timeout
    public Timeout timeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, timeUnit)) == null) {
            return this.delegate.timeout(j, timeUnit);
        }
        return (Timeout) invokeJL.objValue;
    }
}
