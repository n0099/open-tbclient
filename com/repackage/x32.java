package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class x32 extends d42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public fe4 d;
    public sc3 e;
    public final o84<y94> f;

    /* loaded from: classes7.dex */
    public class a extends e42<x32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x32 x32Var, x32 x32Var2) {
            super(x32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, x32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((d42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x32Var;
        }

        @Override // com.repackage.e42
        public void r(@NonNull y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y94Var) == null) {
                if (x32.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + y94Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.repackage.e42
        public void u(y94 y94Var, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y94Var, sc3Var) == null) {
                zx1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + y94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + sc3Var);
                if (this.b.e == null) {
                    this.b.e = sc3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755222598, "Lcom/repackage/x32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755222598, "Lcom/repackage/x32;");
                return;
            }
        }
        g = jh1.a;
    }

    public x32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new AtomicInteger(0);
        this.f = new a(this, this);
    }

    @Override // com.repackage.s84
    public void C(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r94Var) == null) {
            super.C(r94Var);
            zx1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + r94Var.toString());
            sc3 sc3Var = new sc3();
            sc3Var.k(17L);
            sc3Var.c(r94Var);
            Q(sc3Var);
        }
    }

    @Override // com.repackage.s84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            zx1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            sc3 sc3Var = new sc3();
            sc3Var.k(17L);
            sc3Var.i(2901L);
            sc3Var.d("Server无包");
            Q(sc3Var);
        }
    }

    @Override // com.repackage.s84
    public void G(fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fe4Var) == null) {
            super.G(fe4Var);
            this.d = fe4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(fe4Var == null ? 0 : fe4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void Q(@NonNull sc3 sc3Var);

    public abstract void R();

    @Override // com.repackage.s84, com.repackage.p84
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            zx1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            fe4 fe4Var = this.d;
            if (fe4Var == null) {
                sc3 sc3Var = new sc3();
                sc3Var.k(17L);
                sc3Var.i(2900L);
                sc3Var.d("unknown error.");
                Q(sc3Var);
                return;
            }
            int n = fe4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                sc3 sc3Var2 = new sc3();
                sc3Var2.k(17L);
                sc3Var2.i(2900L);
                sc3Var2.d("unknown error.");
                this.e = sc3Var2;
            }
            sc3 sc3Var3 = this.e;
            sc3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }

    @Override // com.repackage.s84
    public o84<y94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (o84) invokeV.objValue;
    }
}
