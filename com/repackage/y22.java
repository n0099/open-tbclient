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
import com.repackage.d22;
import com.repackage.di2;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class y22 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public c22 c;
    public String d;
    public String e;
    public w64<f84> f;

    /* loaded from: classes7.dex */
    public class a extends t64<f84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y22 a;

        public a(y22 y22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(f84 f84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f84Var)) == null) ? a32.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: o */
        public void e(f84 f84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, f84Var, z74Var) == null) {
                super.e(f84Var, z74Var);
                if (y22.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + z74Var.toString());
                }
                ab3 ab3Var = new ab3();
                ab3Var.k(12L);
                ab3Var.i(z74Var.a);
                ab3Var.d("分包下载失败");
                ab3Var.f(z74Var.toString());
                this.a.T(3, ab3Var);
                d22.c().a(f84Var, PMSDownloadType.ALONE_SUB, ab3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, f84Var) == null) {
                super.i(f84Var);
                if (y22.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + f84Var.toString());
                }
                this.a.V(f84Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void f(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f84Var) == null) {
                super.f(f84Var);
                if (y22.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.W(f84Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y22 a;

        public b(y22 y22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y22Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.U();
            }
        }

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.a.T(0, ab3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755193768, "Lcom/repackage/y22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755193768, "Lcom/repackage/y22;");
                return;
            }
        }
        g = rf1.a;
    }

    public y22(String str, String str2, c22 c22Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, c22Var};
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
        this.c = c22Var;
        this.e = di2.e.i(str, str2).getPath();
    }

    @Override // com.repackage.a74
    public w64<f84> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (w64) invokeV.objValue;
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z74Var) == null) {
            super.D(z74Var);
            ab3 ab3Var = new ab3();
            ab3Var.k(12L);
            ab3Var.c(z74Var);
            T(1, ab3Var);
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            ab3 ab3Var = new ab3();
            ab3Var.k(12L);
            ab3Var.i(2901L);
            ab3Var.d("Server无包");
            T(2, ab3Var);
        }
    }

    public final void T(int i, ab3 ab3Var) {
        c22 c22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, ab3Var) == null) || (c22Var = this.c) == null) {
            return;
        }
        c22Var.b(i, ab3Var);
    }

    public final void U() {
        c22 c22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (c22Var = this.c) == null) {
            return;
        }
        c22Var.a();
    }

    public final void V(f84 f84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f84Var) == null) {
            if (!uc3.a(new File(f84Var.a), f84Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                ab3 ab3Var = new ab3();
                ab3Var.k(12L);
                ab3Var.i(2300L);
                ab3Var.d("分包签名校验");
                T(4, ab3Var);
                d22.c().a(f84Var, PMSDownloadType.ALONE_SUB, ab3Var);
            } else if (a32.h(new File(f84Var.a), new File(this.e, f84Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                f84Var.o = this.d;
                c74.i().m(f84Var);
                U();
                d22.c().b(f84Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                ab3 ab3Var2 = new ab3();
                ab3Var2.k(12L);
                ab3Var2.i(2320L);
                ab3Var2.d("分包解压失败");
                T(5, ab3Var2);
                d22.c().a(f84Var, PMSDownloadType.ALONE_SUB, ab3Var2);
            }
        }
    }

    public final void W(f84 f84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f84Var) == null) {
            d22.c().d(f84Var, new b(this));
        }
    }
}
