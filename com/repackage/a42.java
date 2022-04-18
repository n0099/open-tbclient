package com.repackage;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f32;
import com.repackage.fj2;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class a42 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public e32 c;
    public String d;
    public String e;
    public y74<h94> f;

    /* loaded from: classes5.dex */
    public class a extends v74<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public a(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.y74
        /* renamed from: l */
        public String d(h94 h94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, h94Var)) == null) ? c42.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.repackage.a84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: o */
        public void e(h94 h94Var, b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, h94Var, b94Var) == null) {
                super.e(h94Var, b94Var);
                if (a42.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + b94Var.toString());
                }
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.i(b94Var.a);
                cc3Var.d("分包下载失败");
                cc3Var.f(b94Var.toString());
                this.a.T(3, cc3Var);
                f32.c().a(h94Var, PMSDownloadType.ALONE_SUB, cc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: p */
        public void i(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, h94Var) == null) {
                super.i(h94Var);
                if (a42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + h94Var.toString());
                }
                this.a.V(h94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: q */
        public void f(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h94Var) == null) {
                super.f(h94Var);
                if (a42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.W(h94Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public b(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        @Override // com.repackage.f32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.U();
            }
        }

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.a.T(0, cc3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755906830, "Lcom/repackage/a42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755906830, "Lcom/repackage/a42;");
                return;
            }
        }
        g = tg1.a;
    }

    public a42(String str, String str2, e32 e32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, e32Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.d = str;
        this.c = e32Var;
        this.e = fj2.e.i(str, str2).getPath();
    }

    @Override // com.repackage.c84
    public y74<h94> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (y74) invokeV.objValue;
    }

    @Override // com.repackage.c84
    public void D(b94 b94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b94Var) == null) {
            super.D(b94Var);
            cc3 cc3Var = new cc3();
            cc3Var.k(12L);
            cc3Var.c(b94Var);
            T(1, cc3Var);
        }
    }

    @Override // com.repackage.c84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            cc3 cc3Var = new cc3();
            cc3Var.k(12L);
            cc3Var.i(2901L);
            cc3Var.d("Server无包");
            T(2, cc3Var);
        }
    }

    public final void T(int i, cc3 cc3Var) {
        e32 e32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, cc3Var) == null) || (e32Var = this.c) == null) {
            return;
        }
        e32Var.b(i, cc3Var);
    }

    public final void U() {
        e32 e32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (e32Var = this.c) == null) {
            return;
        }
        e32Var.a();
    }

    public final void V(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h94Var) == null) {
            if (!wd3.a(new File(h94Var.a), h94Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.i(2300L);
                cc3Var.d("分包签名校验");
                T(4, cc3Var);
                f32.c().a(h94Var, PMSDownloadType.ALONE_SUB, cc3Var);
            } else if (c42.h(new File(h94Var.a), new File(this.e, h94Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                h94Var.o = this.d;
                e84.i().m(h94Var);
                U();
                f32.c().b(h94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(12L);
                cc3Var2.i(2320L);
                cc3Var2.d("分包解压失败");
                T(5, cc3Var2);
                f32.c().a(h94Var, PMSDownloadType.ALONE_SUB, cc3Var2);
            }
        }
    }

    public final void W(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, h94Var) == null) {
            f32.c().d(h94Var, new b(this));
        }
    }
}
