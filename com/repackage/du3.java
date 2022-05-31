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
import com.repackage.wv3;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class du3 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public vt3 c;
    @NonNull
    public eu3 d;
    public w64<g84> e;

    /* loaded from: classes5.dex */
    public class a extends t64<g84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du3 a;

        public a(du3 du3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(g84 g84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g84Var)) == null) ? wv3.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(g84 g84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, g84Var, z74Var) == null) {
                super.e(g84Var, z74Var);
                if (du3.f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + z74Var.toString());
                }
                this.a.c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g84Var) == null) {
                super.i(g84Var);
                if (du3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + g84Var.toString());
                }
                if (!uc3.a(new File(g84Var.a), g84Var.m)) {
                    if (du3.f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.c.a(false);
                    return;
                }
                File a = this.a.d.a();
                if (a.exists()) {
                    kf4.j(a);
                } else {
                    kf4.l(a);
                }
                boolean U = kf4.U(g84Var.a, a.getAbsolutePath());
                if (U) {
                    this.a.d.b(g84Var.j, g84Var.i);
                }
                kf4.k(g84Var.a);
                this.a.c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void c(g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, g84Var) == null) {
                super.c(g84Var);
                if (du3.f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + g84Var.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void f(g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, g84Var) == null) {
                super.f(g84Var);
                if (du3.f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755754961, "Lcom/repackage/du3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755754961, "Lcom/repackage/du3;");
                return;
            }
        }
        f = rf1.a;
    }

    public du3(@NonNull eu3 eu3Var, @NonNull vt3 vt3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eu3Var, vt3Var};
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
        this.c = vt3Var;
        this.d = eu3Var;
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z74Var) == null) {
            super.D(z74Var);
            if (f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + z74Var.toString());
            }
            this.c.a(false);
        }
    }

    @Override // com.repackage.a74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // com.repackage.a74
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

    @Override // com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nc4Var) == null) {
            super.H(nc4Var);
            if (f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // com.repackage.a74
    public w64<g84> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (w64) invokeV.objValue;
    }
}
