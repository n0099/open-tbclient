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
/* loaded from: classes5.dex */
public abstract class f22 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public nc4 d;
    public ab3 e;
    public final w64<g84> f;

    /* loaded from: classes5.dex */
    public class a extends m22<f22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f22 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f22 f22Var, f22 f22Var2) {
            super(f22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f22Var, f22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f22Var;
        }

        @Override // com.repackage.m22
        public void r(@NonNull g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g84Var) == null) {
                if (f22.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + g84Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.repackage.m22
        public void u(g84 g84Var, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g84Var, ab3Var) == null) {
                hw1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + g84Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ab3Var);
                if (this.b.e == null) {
                    this.b.e = ab3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755759797, "Lcom/repackage/f22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755759797, "Lcom/repackage/f22;");
                return;
            }
        }
        g = rf1.a;
    }

    public f22() {
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

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z74Var) == null) {
            super.D(z74Var);
            hw1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + z74Var.toString());
            ab3 ab3Var = new ab3();
            ab3Var.k(17L);
            ab3Var.c(z74Var);
            R(ab3Var);
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            hw1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            ab3 ab3Var = new ab3();
            ab3Var.k(17L);
            ab3Var.i(2901L);
            ab3Var.d("Server无包");
            R(ab3Var);
        }
    }

    @Override // com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nc4Var) == null) {
            super.H(nc4Var);
            this.d = nc4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(nc4Var == null ? 0 : nc4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void R(@NonNull ab3 ab3Var);

    public abstract void S();

    @Override // com.repackage.a74, com.repackage.x64
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            hw1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            nc4 nc4Var = this.d;
            if (nc4Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(17L);
                ab3Var.i(2900L);
                ab3Var.d("unknown error.");
                R(ab3Var);
                return;
            }
            int n = nc4Var.n() - this.c.get();
            if (n == 0) {
                S();
                return;
            }
            if (this.e == null) {
                ab3 ab3Var2 = new ab3();
                ab3Var2.k(17L);
                ab3Var2.i(2900L);
                ab3Var2.d("unknown error.");
                this.e = ab3Var2;
            }
            ab3 ab3Var3 = this.e;
            ab3Var3.f("failCount:" + n);
            R(this.e);
        }
    }

    @Override // com.repackage.a74
    public w64<g84> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (w64) invokeV.objValue;
    }
}
