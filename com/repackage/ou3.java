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
import com.repackage.hw3;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class ou3 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public gu3 c;
    @NonNull
    public pu3 d;
    public h74<r84> e;

    /* loaded from: classes6.dex */
    public class a extends e74<r84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ou3 a;

        public a(ou3 ou3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ou3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ou3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: l */
        public String d(r84 r84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, r84Var)) == null) ? hw3.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: o */
        public void e(r84 r84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, r84Var, k84Var) == null) {
                super.e(r84Var, k84Var);
                if (ou3.f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + k84Var.toString());
                }
                this.a.c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: p */
        public void i(r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, r84Var) == null) {
                super.i(r84Var);
                if (ou3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + r84Var.toString());
                }
                if (!fd3.a(new File(r84Var.a), r84Var.m)) {
                    if (ou3.f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.c.a(false);
                    return;
                }
                File a = this.a.d.a();
                if (a.exists()) {
                    uf4.j(a);
                } else {
                    uf4.l(a);
                }
                boolean U = uf4.U(r84Var.a, a.getAbsolutePath());
                if (U) {
                    this.a.d.b(r84Var.j, r84Var.i);
                }
                uf4.k(r84Var.a);
                this.a.c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void c(r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, r84Var) == null) {
                super.c(r84Var);
                if (ou3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + r84Var.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: r */
        public void f(r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, r84Var) == null) {
                super.f(r84Var);
                if (ou3.f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755427260, "Lcom/repackage/ou3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755427260, "Lcom/repackage/ou3;");
                return;
            }
        }
        f = cg1.a;
    }

    public ou3(@NonNull pu3 pu3Var, @NonNull gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pu3Var, gu3Var};
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
        this.c = gu3Var;
        this.d = pu3Var;
    }

    @Override // com.repackage.l74
    public void C(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k84Var) == null) {
            super.C(k84Var);
            if (f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + k84Var.toString());
            }
            this.c.a(false);
        }
    }

    @Override // com.repackage.l74
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // com.repackage.l74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (f) {
                Log.i("ConsoleJsDownload", "onNoPackage");
            }
            this.c.a(false);
        }
    }

    @Override // com.repackage.l74
    public void G(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yc4Var) == null) {
            super.G(yc4Var);
            if (f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // com.repackage.l74
    public h74<r84> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (h74) invokeV.objValue;
    }
}
