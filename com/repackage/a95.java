package com.repackage;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a95 extends f95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z85 b;
    public boolean c;
    public boolean d;

    public a95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            z85 z85Var = this.b;
            if (z85Var != null) {
                return z85Var.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void c() {
        z85 z85Var;
        k95 k95Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.d || (z85Var = this.b) == null || z85Var.b() < 0 || (k95Var = (k95) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) == null) {
            return;
        }
        k95Var.e(this);
        this.d = true;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.c && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            this.c = true;
            if (Build.VERSION.SDK_INT >= 16) {
                if (this.b == null) {
                    this.b = new z85();
                }
                this.b.c();
            }
        }
    }

    public void e() {
        z85 z85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 16 || (z85Var = this.b) == null) {
            return;
        }
        z85Var.d();
    }
}
