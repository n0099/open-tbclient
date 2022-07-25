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
public abstract class g32 extends m32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public od4 d;
    public bc3 e;
    public final x74<h94> f;

    /* loaded from: classes6.dex */
    public class a extends n32<g32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g32 g32Var, g32 g32Var2) {
            super(g32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g32Var, g32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((m32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g32Var;
        }

        @Override // com.repackage.n32
        public void r(@NonNull h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h94Var) == null) {
                if (g32.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + h94Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.repackage.n32
        public void u(h94 h94Var, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h94Var, bc3Var) == null) {
                ix1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + h94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + bc3Var);
                if (this.b.e == null) {
                    this.b.e = bc3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755729045, "Lcom/repackage/g32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755729045, "Lcom/repackage/g32;");
                return;
            }
        }
        g = sg1.a;
    }

    public g32() {
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

    @Override // com.repackage.b84
    public void C(a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a94Var) == null) {
            super.C(a94Var);
            ix1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + a94Var.toString());
            bc3 bc3Var = new bc3();
            bc3Var.k(17L);
            bc3Var.c(a94Var);
            Q(bc3Var);
        }
    }

    @Override // com.repackage.b84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            ix1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            bc3 bc3Var = new bc3();
            bc3Var.k(17L);
            bc3Var.i(2901L);
            bc3Var.d("Server无包");
            Q(bc3Var);
        }
    }

    @Override // com.repackage.b84
    public void G(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, od4Var) == null) {
            super.G(od4Var);
            this.d = od4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(od4Var == null ? 0 : od4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void Q(@NonNull bc3 bc3Var);

    public abstract void R();

    @Override // com.repackage.b84, com.repackage.y74
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            ix1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            od4 od4Var = this.d;
            if (od4Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(17L);
                bc3Var.i(2900L);
                bc3Var.d("unknown error.");
                Q(bc3Var);
                return;
            }
            int n = od4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                bc3 bc3Var2 = new bc3();
                bc3Var2.k(17L);
                bc3Var2.i(2900L);
                bc3Var2.d("unknown error.");
                this.e = bc3Var2;
            }
            bc3 bc3Var3 = this.e;
            bc3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }

    @Override // com.repackage.b84
    public x74<h94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (x74) invokeV.objValue;
    }
}
