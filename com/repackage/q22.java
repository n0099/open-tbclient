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
/* loaded from: classes6.dex */
public abstract class q22 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public yc4 d;
    public lb3 e;
    public final h74<r84> f;

    /* loaded from: classes6.dex */
    public class a extends x22<q22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q22 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q22 q22Var, q22 q22Var2) {
            super(q22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q22Var, q22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((w22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q22Var;
        }

        @Override // com.repackage.x22
        public void r(@NonNull r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r84Var) == null) {
                if (q22.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + r84Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.repackage.x22
        public void u(r84 r84Var, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r84Var, lb3Var) == null) {
                sw1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + r84Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + lb3Var);
                if (this.b.e == null) {
                    this.b.e = lb3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755432096, "Lcom/repackage/q22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755432096, "Lcom/repackage/q22;");
                return;
            }
        }
        g = cg1.a;
    }

    public q22() {
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

    @Override // com.repackage.l74
    public void C(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k84Var) == null) {
            super.C(k84Var);
            sw1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + k84Var.toString());
            lb3 lb3Var = new lb3();
            lb3Var.k(17L);
            lb3Var.c(k84Var);
            Q(lb3Var);
        }
    }

    @Override // com.repackage.l74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            sw1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            lb3 lb3Var = new lb3();
            lb3Var.k(17L);
            lb3Var.i(2901L);
            lb3Var.d("Server无包");
            Q(lb3Var);
        }
    }

    @Override // com.repackage.l74
    public void G(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yc4Var) == null) {
            super.G(yc4Var);
            this.d = yc4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(yc4Var == null ? 0 : yc4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void Q(@NonNull lb3 lb3Var);

    public abstract void R();

    @Override // com.repackage.l74, com.repackage.i74
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            sw1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            yc4 yc4Var = this.d;
            if (yc4Var == null) {
                lb3 lb3Var = new lb3();
                lb3Var.k(17L);
                lb3Var.i(2900L);
                lb3Var.d("unknown error.");
                Q(lb3Var);
                return;
            }
            int n = yc4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                lb3 lb3Var2 = new lb3();
                lb3Var2.k(17L);
                lb3Var2.i(2900L);
                lb3Var2.d("unknown error.");
                this.e = lb3Var2;
            }
            lb3 lb3Var3 = this.e;
            lb3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }

    @Override // com.repackage.l74
    public h74<r84> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (h74) invokeV.objValue;
    }
}
