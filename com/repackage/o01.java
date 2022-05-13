package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.thread.executor.BaseExecutorCell;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class o01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseExecutorCell a;
    @NonNull
    public BaseExecutorCell b;
    @NonNull
    public BaseExecutorCell c;

    public o01() {
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
        this.a = BaseExecutorCell.b(b01.d, BaseExecutorCell.ExecutorType.ARTERY);
        this.b = BaseExecutorCell.b(b01.e, BaseExecutorCell.ExecutorType.ARTERY);
        this.c = BaseExecutorCell.b(b01.f, BaseExecutorCell.ExecutorType.ARTERY);
    }

    public boolean a(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, elasticTask)) == null) {
            int b = elasticTask.b();
            if (b == 0 || b == 1) {
                if (this.a.c(elasticTask) || this.b.c(elasticTask)) {
                    return true;
                }
                return this.c.c(elasticTask);
            } else if (b == 2) {
                if (this.b.c(elasticTask)) {
                    return true;
                }
                return this.c.c(elasticTask);
            } else if (b == 3) {
                return this.c.c(elasticTask);
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
