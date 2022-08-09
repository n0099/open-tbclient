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
import com.repackage.ox3;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class vv3 extends d42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public nv3 c;
    @NonNull
    public wv3 d;
    public o84<y94> e;

    /* loaded from: classes7.dex */
    public class a extends l84<y94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv3 a;

        public a(vv3 vv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(y94 y94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, y94Var)) == null) ? ox3.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(y94 y94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, y94Var, r94Var) == null) {
                super.e(y94Var, r94Var);
                if (vv3.f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + r94Var.toString());
                }
                this.a.c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, y94Var) == null) {
                super.i(y94Var);
                if (vv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + y94Var.toString());
                }
                if (!me3.a(new File(y94Var.a), y94Var.m)) {
                    if (vv3.f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.c.a(false);
                    return;
                }
                File a = this.a.d.a();
                if (a.exists()) {
                    bh4.j(a);
                } else {
                    bh4.l(a);
                }
                boolean U = bh4.U(y94Var.a, a.getAbsolutePath());
                if (U) {
                    this.a.d.b(y94Var.j, y94Var.i);
                }
                bh4.k(y94Var.a);
                this.a.c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void c(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, y94Var) == null) {
                super.c(y94Var);
                if (vv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + y94Var.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: r */
        public void f(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, y94Var) == null) {
                super.f(y94Var);
                if (vv3.f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755217762, "Lcom/repackage/vv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755217762, "Lcom/repackage/vv3;");
                return;
            }
        }
        f = jh1.a;
    }

    public vv3(@NonNull wv3 wv3Var, @NonNull nv3 nv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wv3Var, nv3Var};
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
        this.c = nv3Var;
        this.d = wv3Var;
    }

    @Override // com.repackage.s84
    public void C(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r94Var) == null) {
            super.C(r94Var);
            if (f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + r94Var.toString());
            }
            this.c.a(false);
        }
    }

    @Override // com.repackage.s84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // com.repackage.s84
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

    @Override // com.repackage.s84
    public void G(fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fe4Var) == null) {
            super.G(fe4Var);
            if (f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // com.repackage.s84
    public o84<y94> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (o84) invokeV.objValue;
    }
}
