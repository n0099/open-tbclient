package com.repackage;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jx3;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class qv3 extends y32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public iv3 c;
    @NonNull
    public rv3 d;
    public j84<t94> e;

    /* loaded from: classes7.dex */
    public class a extends g84<t94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qv3 a;

        public a(qv3 qv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qv3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(t94 t94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t94Var)) == null) ? jx3.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(t94 t94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, t94Var, m94Var) == null) {
                super.e(t94Var, m94Var);
                if (qv3.f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + m94Var.toString());
                }
                this.a.c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t94Var) == null) {
                super.i(t94Var);
                if (qv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + t94Var.toString());
                }
                if (!he3.a(new File(t94Var.a), t94Var.m)) {
                    if (qv3.f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.c.a(false);
                    return;
                }
                File a = this.a.d.a();
                if (a.exists()) {
                    xg4.j(a);
                } else {
                    xg4.l(a);
                }
                boolean U = xg4.U(t94Var.a, a.getAbsolutePath());
                if (U) {
                    this.a.d.b(t94Var.j, t94Var.i);
                }
                xg4.k(t94Var.a);
                this.a.c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void c(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, t94Var) == null) {
                super.c(t94Var);
                if (qv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + t94Var.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void f(t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, t94Var) == null) {
                super.f(t94Var);
                if (qv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755366717, "Lcom/repackage/qv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755366717, "Lcom/repackage/qv3;");
                return;
            }
        }
        f = eh1.a;
    }

    public qv3(@NonNull rv3 rv3Var, @NonNull iv3 iv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rv3Var, iv3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.c = iv3Var;
        this.d = rv3Var;
    }

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m94Var) == null) {
            super.D(m94Var);
            if (f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + m94Var.toString());
            }
            this.c.a(false);
        }
    }

    @Override // com.repackage.n84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            if (f) {
                Log.i("ConsoleJsDownload", "onNoPackage");
            }
            this.c.a(false);
        }
    }

    @Override // com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ae4Var) == null) {
            super.H(ae4Var);
            if (f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // com.repackage.n84
    public j84<t94> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (j84) invokeV.objValue;
    }
}
