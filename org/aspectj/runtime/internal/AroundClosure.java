package org.aspectj.runtime.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.ProceedingJoinPoint;
/* loaded from: classes8.dex */
public abstract class AroundClosure {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitflags;
    public Object[] preInitializationState;
    public Object[] state;

    public abstract Object run(Object[] objArr) throws Throwable;

    public AroundClosure() {
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
        this.bitflags = 1048576;
    }

    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bitflags;
        }
        return invokeV.intValue;
    }

    public Object[] getPreInitializationState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.preInitializationState;
        }
        return (Object[]) invokeV.objValue;
    }

    public Object[] getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.state;
        }
        return (Object[]) invokeV.objValue;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object[] objArr = this.state;
            ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) objArr[objArr.length - 1];
            proceedingJoinPoint.set$AroundClosure(this);
            return proceedingJoinPoint;
        }
        return (ProceedingJoinPoint) invokeV.objValue;
    }

    public AroundClosure(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {objArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bitflags = 1048576;
        this.state = objArr;
    }

    public ProceedingJoinPoint linkClosureAndJoinPoint(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Object[] objArr = this.state;
            ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) objArr[objArr.length - 1];
            proceedingJoinPoint.set$AroundClosure(this);
            this.bitflags = i;
            return proceedingJoinPoint;
        }
        return (ProceedingJoinPoint) invokeI.objValue;
    }
}
