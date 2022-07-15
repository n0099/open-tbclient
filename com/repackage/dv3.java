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
import com.repackage.ww3;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class dv3 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public vu3 c;
    @NonNull
    public ev3 d;
    public w74<g94> e;

    /* loaded from: classes5.dex */
    public class a extends t74<g94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv3 a;

        public a(dv3 dv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(g94 g94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g94Var)) == null) ? ww3.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(g94 g94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, g94Var, z84Var) == null) {
                super.e(g94Var, z84Var);
                if (dv3.f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + z84Var.toString());
                }
                this.a.c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g94Var) == null) {
                super.i(g94Var);
                if (dv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + g94Var.toString());
                }
                if (!ud3.a(new File(g94Var.a), g94Var.m)) {
                    if (dv3.f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.c.a(false);
                    return;
                }
                File a = this.a.d.a();
                if (a.exists()) {
                    jg4.j(a);
                } else {
                    jg4.l(a);
                }
                boolean U = jg4.U(g94Var.a, a.getAbsolutePath());
                if (U) {
                    this.a.d.b(g94Var.j, g94Var.i);
                }
                jg4.k(g94Var.a);
                this.a.c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void c(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, g94Var) == null) {
                super.c(g94Var);
                if (dv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + g94Var.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void f(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, g94Var) == null) {
                super.f(g94Var);
                if (dv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755754000, "Lcom/repackage/dv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755754000, "Lcom/repackage/dv3;");
                return;
            }
        }
        f = rg1.a;
    }

    public dv3(@NonNull ev3 ev3Var, @NonNull vu3 vu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ev3Var, vu3Var};
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
        this.c = vu3Var;
        this.d = ev3Var;
    }

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z84Var) == null) {
            super.C(z84Var);
            if (f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + z84Var.toString());
            }
            this.c.a(false);
        }
    }

    @Override // com.repackage.a84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // com.repackage.a84
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

    @Override // com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nd4Var) == null) {
            super.G(nd4Var);
            if (f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // com.repackage.a84
    public w74<g94> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (w74) invokeV.objValue;
    }
}
