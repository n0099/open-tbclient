package org.apache.commons.lang3.concurrent;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public class ThresholdCircuitBreaker extends AbstractCircuitBreaker<Long> {
    public static /* synthetic */ Interceptable $ic;
    public static final long INITIAL_COUNT = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final long threshold;
    public final AtomicLong used;

    public ThresholdCircuitBreaker(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.used = new AtomicLong(0L);
        this.threshold = j2;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() throws CircuitBreakingException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? isOpen() : invokeV.booleanValue;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.close();
            this.used.set(0L);
        }
    }

    public long getThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.threshold : invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean incrementAndCheckState(Long l) throws CircuitBreakingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l)) == null) {
            if (this.threshold == 0) {
                open();
            }
            if (this.used.addAndGet(l.longValue()) > this.threshold) {
                open();
            }
            return checkState();
        }
        return invokeL.booleanValue;
    }
}
