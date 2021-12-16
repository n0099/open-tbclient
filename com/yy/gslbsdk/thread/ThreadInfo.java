package com.yy.gslbsdk.thread;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ThreadInfo implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadEndOper threadEndOper;
    public ThreadMainOper threadMainOper;
    public String threadName;

    /* loaded from: classes4.dex */
    public interface ThreadEndOper {
        void handleOper(String str);
    }

    /* loaded from: classes4.dex */
    public interface ThreadMainOper {
        void handleOper(String str);
    }

    public ThreadInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.threadName = null;
        this.threadMainOper = null;
        this.threadEndOper = null;
        this.threadName = str;
    }

    public ThreadEndOper getThreadEndOper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.threadEndOper : (ThreadEndOper) invokeV.objValue;
    }

    public ThreadMainOper getThreadMainOper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.threadMainOper : (ThreadMainOper) invokeV.objValue;
    }

    public String getThreadName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.threadName : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ThreadMainOper threadMainOper = this.threadMainOper;
            if (threadMainOper != null) {
                threadMainOper.handleOper(this.threadName);
            }
            ThreadEndOper threadEndOper = this.threadEndOper;
            if (threadEndOper != null) {
                threadEndOper.handleOper(this.threadName);
            }
        }
    }

    public void setThreadEndOper(ThreadEndOper threadEndOper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadEndOper) == null) {
            this.threadEndOper = threadEndOper;
        }
    }

    public void setThreadMainOper(ThreadMainOper threadMainOper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadMainOper) == null) {
            this.threadMainOper = threadMainOper;
        }
    }

    public void setThreadName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.threadName = str;
        }
    }
}
