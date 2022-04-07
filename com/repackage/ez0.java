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
public class ez0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz0 a;
        public final /* synthetic */ ip0 b;

        public a(kz0 kz0Var, ip0 ip0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz0Var, ip0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz0Var;
            this.b = ip0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ez0.d(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull kz0 kz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, kz0Var) == null) {
            c(kz0Var, null);
        }
    }

    public static <T> void c(@NonNull kz0 kz0Var, @Nullable ip0<T> ip0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, kz0Var, ip0Var) == null) {
            if (yf0.a && (kz0Var instanceof ClogBuilder)) {
                ClogBuilder clogBuilder = (ClogBuilder) kz0Var;
                bj0 bj0Var = (bj0) aj0.a().a(bj0.class);
                if (bj0Var != null) {
                    bj0Var.a(clogBuilder.f());
                }
            }
            b01.c(new a(kz0Var, ip0Var), "als_async_executor", 2);
        }
    }

    public static <T> void d(kz0 kz0Var, @Nullable ip0<T> ip0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, kz0Var, ip0Var) == null) && kz0Var != null && kz0Var.isValid()) {
            String kz0Var2 = kz0Var.toString();
            if (kz0Var instanceof ClogBuilder) {
                str = yf0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (kz0Var instanceof lz0) {
                str = yf0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : TbConfig.REPORT_PLOG;
            } else if (!(kz0Var instanceof iz0)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            pp0 pp0Var = new pp0();
            pp0Var.h(kz0Var2);
            pp0Var.k(BodyStyle.STRING);
            pp0Var.i("application/x-www-form-urlencoded");
            qp0 qp0Var = new qp0();
            qp0Var.k(str);
            qp0Var.f(pp0Var);
            yo0.b().a().a(qp0Var, ip0Var);
        }
    }
}
