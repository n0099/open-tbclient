package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by0 a;
        public final /* synthetic */ zn0 b;

        public a(by0 by0Var, zn0 zn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by0Var, zn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = by0Var;
            this.b = zn0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vx0.e(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull by0 by0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, by0Var) == null) && nz0.a && (by0Var instanceof ClogBuilder)) {
            ClogBuilder clogBuilder = (ClogBuilder) by0Var;
            oz0 oz0Var = (oz0) mz0.a().a(oz0.class);
            if (oz0Var != null) {
                oz0Var.a(clogBuilder.f());
            }
            pz0 pz0Var = (pz0) mz0.a().a(pz0.class);
            if (pz0Var != null) {
                pz0Var.a(clogBuilder.f());
            }
            rz0 rz0Var = (rz0) mz0.a().a(rz0.class);
            if (rz0Var != null) {
                rz0Var.a(clogBuilder.f());
            }
        }
    }

    public static void c(@NonNull by0 by0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, by0Var) == null) {
            d(by0Var, null);
        }
    }

    public static <T> void d(@NonNull by0 by0Var, @Nullable zn0<T> zn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, by0Var, zn0Var) == null) {
            b(by0Var);
            ty0.c(new a(by0Var, zn0Var), "als_async_executor", 2);
        }
    }

    public static <T> void e(by0 by0Var, @Nullable zn0<T> zn0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, by0Var, zn0Var) == null) && by0Var != null && by0Var.isValid()) {
            String by0Var2 = by0Var.toString();
            if (by0Var instanceof ClogBuilder) {
                str = se0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (by0Var instanceof cy0) {
                str = se0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : TbConfig.REPORT_PLOG;
            } else if (!(by0Var instanceof zx0)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            go0 go0Var = new go0();
            go0Var.h(by0Var2);
            go0Var.k(BodyStyle.STRING);
            go0Var.i("application/x-www-form-urlencoded");
            ho0 ho0Var = new ho0();
            ho0Var.k(str);
            ho0Var.f(go0Var);
            pn0.b().a().a(ho0Var, zn0Var);
        }
    }
}
