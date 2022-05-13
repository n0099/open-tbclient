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
public abstract class s32 extends y32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public ae4 d;
    public nc3 e;
    public final j84<t94> f;

    /* loaded from: classes7.dex */
    public class a extends z32<s32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s32 s32Var, s32 s32Var2) {
            super(s32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s32Var, s32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((y32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s32Var;
        }

        @Override // com.repackage.z32
        public void r(@NonNull t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t94Var) == null) {
                if (s32.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + t94Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.repackage.z32
        public void u(t94 t94Var, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t94Var, nc3Var) == null) {
                ux1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + t94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + nc3Var);
                if (this.b.e == null) {
                    this.b.e = nc3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755371553, "Lcom/repackage/s32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755371553, "Lcom/repackage/s32;");
                return;
            }
        }
        g = eh1.a;
    }

    public s32() {
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

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m94Var) == null) {
            super.D(m94Var);
            ux1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + m94Var.toString());
            nc3 nc3Var = new nc3();
            nc3Var.k(17L);
            nc3Var.c(m94Var);
            R(nc3Var);
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            ux1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            nc3 nc3Var = new nc3();
            nc3Var.k(17L);
            nc3Var.i(2901L);
            nc3Var.d("Server无包");
            R(nc3Var);
        }
    }

    @Override // com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ae4Var) == null) {
            super.H(ae4Var);
            this.d = ae4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(ae4Var == null ? 0 : ae4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void R(@NonNull nc3 nc3Var);

    public abstract void S();

    @Override // com.repackage.n84, com.repackage.k84
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            ux1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            ae4 ae4Var = this.d;
            if (ae4Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(17L);
                nc3Var.i(2900L);
                nc3Var.d("unknown error.");
                R(nc3Var);
                return;
            }
            int n = ae4Var.n() - this.c.get();
            if (n == 0) {
                S();
                return;
            }
            if (this.e == null) {
                nc3 nc3Var2 = new nc3();
                nc3Var2.k(17L);
                nc3Var2.i(2900L);
                nc3Var2.d("unknown error.");
                this.e = nc3Var2;
            }
            nc3 nc3Var3 = this.e;
            nc3Var3.f("failCount:" + n);
            R(this.e);
        }
    }

    @Override // com.repackage.n84
    public j84<t94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (j84) invokeV.objValue;
    }
}
