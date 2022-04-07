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
public abstract class h32 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public qd4 d;
    public cc3 e;
    public final z74<j94> f;

    /* loaded from: classes6.dex */
    public class a extends o32<h32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h32 h32Var, h32 h32Var2) {
            super(h32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, h32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h32Var;
        }

        @Override // com.repackage.o32
        public void r(@NonNull j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j94Var) == null) {
                if (h32.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + j94Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.repackage.o32
        public void u(j94 j94Var, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j94Var, cc3Var) == null) {
                jx1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + j94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + cc3Var);
                if (this.b.e == null) {
                    this.b.e = cc3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755699254, "Lcom/repackage/h32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755699254, "Lcom/repackage/h32;");
                return;
            }
        }
        g = tg1.a;
    }

    public h32() {
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

    @Override // com.repackage.d84
    public void D(c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c94Var) == null) {
            super.D(c94Var);
            jx1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + c94Var.toString());
            cc3 cc3Var = new cc3();
            cc3Var.k(17L);
            cc3Var.c(c94Var);
            R(cc3Var);
        }
    }

    @Override // com.repackage.d84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            jx1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            cc3 cc3Var = new cc3();
            cc3Var.k(17L);
            cc3Var.i(2901L);
            cc3Var.d("Server无包");
            R(cc3Var);
        }
    }

    @Override // com.repackage.d84
    public void H(qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qd4Var) == null) {
            super.H(qd4Var);
            this.d = qd4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(qd4Var == null ? 0 : qd4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void R(@NonNull cc3 cc3Var);

    public abstract void S();

    @Override // com.repackage.d84, com.repackage.a84
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            jx1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            qd4 qd4Var = this.d;
            if (qd4Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(17L);
                cc3Var.i(2900L);
                cc3Var.d("unknown error.");
                R(cc3Var);
                return;
            }
            int n = qd4Var.n() - this.c.get();
            if (n == 0) {
                S();
                return;
            }
            if (this.e == null) {
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(17L);
                cc3Var2.i(2900L);
                cc3Var2.d("unknown error.");
                this.e = cc3Var2;
            }
            cc3 cc3Var3 = this.e;
            cc3Var3.f("failCount:" + n);
            R(this.e);
        }
    }

    @Override // com.repackage.d84
    public z74<j94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (z74) invokeV.objValue;
    }
}
