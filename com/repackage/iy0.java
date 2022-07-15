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
public class iy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy0 a;
        public final /* synthetic */ mo0 b;

        public a(oy0 oy0Var, mo0 mo0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy0Var, mo0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy0Var;
            this.b = mo0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iy0.d(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull oy0 oy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, oy0Var) == null) {
            c(oy0Var, null);
        }
    }

    public static <T> void c(@NonNull oy0 oy0Var, @Nullable mo0<T> mo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, oy0Var, mo0Var) == null) {
            oy0Var.a();
            gz0.c(new a(oy0Var, mo0Var), "als_async_executor", 2);
        }
    }

    public static <T> void d(oy0 oy0Var, @Nullable mo0<T> mo0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, oy0Var, mo0Var) == null) && oy0Var != null && oy0Var.isValid()) {
            String oy0Var2 = oy0Var.toString();
            if (oy0Var instanceof ClogBuilder) {
                str = xe0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (oy0Var instanceof py0) {
                str = xe0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : TbConfig.REPORT_PLOG;
            } else if (!(oy0Var instanceof my0)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            to0 to0Var = new to0();
            to0Var.h(oy0Var2);
            to0Var.k(BodyStyle.STRING);
            to0Var.i("application/x-www-form-urlencoded");
            uo0 uo0Var = new uo0();
            uo0Var.k(str);
            uo0Var.f(to0Var);
            co0.b().a().a(uo0Var, mo0Var);
        }
    }
}
