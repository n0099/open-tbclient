package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny0 a;
        public final /* synthetic */ ko0 b;

        public a(ny0 ny0Var, ko0 ko0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny0Var, ko0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny0Var;
            this.b = ko0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hy0.d(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull ny0 ny0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ny0Var) == null) {
            c(ny0Var, null);
        }
    }

    public static <T> void c(@NonNull ny0 ny0Var, @Nullable ko0<T> ko0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ny0Var, ko0Var) == null) {
            ny0Var.a();
            fz0.c(new a(ny0Var, ko0Var), "als_async_executor", 2);
        }
    }

    public static <T> void d(ny0 ny0Var, @Nullable ko0<T> ko0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, ny0Var, ko0Var) == null) && ny0Var != null && ny0Var.isValid()) {
            String ny0Var2 = ny0Var.toString();
            if (ny0Var instanceof ClogBuilder) {
                str = te0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (ny0Var instanceof oy0) {
                str = te0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : TbConfig.REPORT_PLOG;
            } else if (!(ny0Var instanceof ly0)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            ro0 ro0Var = new ro0();
            ro0Var.h(ny0Var2);
            ro0Var.k(BodyStyle.STRING);
            ro0Var.i("application/x-www-form-urlencoded");
            so0 so0Var = new so0();
            so0Var.k(str);
            so0Var.f(ro0Var);
            zn0.b().a().a(so0Var, ko0Var);
        }
    }
}
