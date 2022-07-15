package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes7.dex */
public abstract class x70<V> extends FutureTask<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdAsyncTask<?, ?, ?> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x70(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable, bdAsyncTask};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Callable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = bdAsyncTask;
    }

    public abstract void a();

    public BdAsyncTask<?, ?, ?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (BdAsyncTask) invokeV.objValue;
    }
}
