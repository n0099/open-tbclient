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
public class rx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx0 a;
        public final /* synthetic */ vn0 b;

        public a(xx0 xx0Var, vn0 vn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx0Var, vn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx0Var;
            this.b = vn0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rx0.e(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull xx0 xx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, xx0Var) == null) && jz0.a && (xx0Var instanceof ClogBuilder)) {
            ClogBuilder clogBuilder = (ClogBuilder) xx0Var;
            kz0 kz0Var = (kz0) iz0.a().a(kz0.class);
            if (kz0Var != null) {
                kz0Var.a(clogBuilder.f());
            }
            lz0 lz0Var = (lz0) iz0.a().a(lz0.class);
            if (lz0Var != null) {
                lz0Var.a(clogBuilder.f());
            }
            nz0 nz0Var = (nz0) iz0.a().a(nz0.class);
            if (nz0Var != null) {
                nz0Var.a(clogBuilder.f());
            }
        }
    }

    public static void c(@NonNull xx0 xx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, xx0Var) == null) {
            d(xx0Var, null);
        }
    }

    public static <T> void d(@NonNull xx0 xx0Var, @Nullable vn0<T> vn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, xx0Var, vn0Var) == null) {
            b(xx0Var);
            py0.c(new a(xx0Var, vn0Var), "als_async_executor", 2);
        }
    }

    public static <T> void e(xx0 xx0Var, @Nullable vn0<T> vn0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xx0Var, vn0Var) == null) && xx0Var != null && xx0Var.isValid()) {
            String xx0Var2 = xx0Var.toString();
            if (xx0Var instanceof ClogBuilder) {
                str = oe0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (xx0Var instanceof yx0) {
                str = oe0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : TbConfig.REPORT_PLOG;
            } else if (!(xx0Var instanceof vx0)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            co0 co0Var = new co0();
            co0Var.h(xx0Var2);
            co0Var.k(BodyStyle.STRING);
            co0Var.i("application/x-www-form-urlencoded");
            do0 do0Var = new do0();
            do0Var.k(str);
            do0Var.f(co0Var);
            ln0.b().a().a(do0Var, vn0Var);
        }
    }
}
