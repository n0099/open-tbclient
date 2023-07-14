package com.huawei.hms.common.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dqb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskApiCall<? extends AnyClient, TResult> mTaskApiCall;
    public final dqb<TResult> mTaskCompletionSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, dqb<TResult> dqbVar) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskApiCall, dqbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTaskApiCall = taskApiCall;
        this.mTaskCompletionSource = dqbVar;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mTaskApiCall;
        }
        return (TaskApiCall) invokeV.objValue;
    }

    public dqb<TResult> getTaskCompletionSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mTaskCompletionSource;
        }
        return (dqb) invokeV.objValue;
    }
}
