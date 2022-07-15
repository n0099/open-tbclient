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
public abstract class f32 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public nd4 d;
    public ac3 e;
    public final w74<g94> f;

    /* loaded from: classes6.dex */
    public class a extends m32<f32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f32 f32Var, f32 f32Var2) {
            super(f32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f32Var, f32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f32Var;
        }

        @Override // com.repackage.m32
        public void r(@NonNull g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g94Var) == null) {
                if (f32.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + g94Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.repackage.m32
        public void u(g94 g94Var, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g94Var, ac3Var) == null) {
                hx1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + g94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ac3Var);
                if (this.b.e == null) {
                    this.b.e = ac3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755758836, "Lcom/repackage/f32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755758836, "Lcom/repackage/f32;");
                return;
            }
        }
        g = rg1.a;
    }

    public f32() {
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

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z84Var) == null) {
            super.C(z84Var);
            hx1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + z84Var.toString());
            ac3 ac3Var = new ac3();
            ac3Var.k(17L);
            ac3Var.c(z84Var);
            Q(ac3Var);
        }
    }

    @Override // com.repackage.a84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            hx1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            ac3 ac3Var = new ac3();
            ac3Var.k(17L);
            ac3Var.i(2901L);
            ac3Var.d("Server无包");
            Q(ac3Var);
        }
    }

    @Override // com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nd4Var) == null) {
            super.G(nd4Var);
            this.d = nd4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(nd4Var == null ? 0 : nd4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void Q(@NonNull ac3 ac3Var);

    public abstract void R();

    @Override // com.repackage.a84, com.repackage.x74
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            hx1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            nd4 nd4Var = this.d;
            if (nd4Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(17L);
                ac3Var.i(2900L);
                ac3Var.d("unknown error.");
                Q(ac3Var);
                return;
            }
            int n = nd4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(17L);
                ac3Var2.i(2900L);
                ac3Var2.d("unknown error.");
                this.e = ac3Var2;
            }
            ac3 ac3Var3 = this.e;
            ac3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }

    @Override // com.repackage.a84
    public w74<g94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (w74) invokeV.objValue;
    }
}
