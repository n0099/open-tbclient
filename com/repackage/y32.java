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
import com.repackage.d32;
import com.repackage.dj2;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class y32 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public c32 c;
    public String d;
    public String e;
    public w74<f94> f;

    /* loaded from: classes7.dex */
    public class a extends t74<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y32 a;

        public a(y32 y32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(f94 f94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f94Var)) == null) ? a42.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(f94 f94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, f94Var, z84Var) == null) {
                super.e(f94Var, z84Var);
                if (y32.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + z84Var.toString());
                }
                ac3 ac3Var = new ac3();
                ac3Var.k(12L);
                ac3Var.i(z84Var.a);
                ac3Var.d("分包下载失败");
                ac3Var.f(z84Var.toString());
                this.a.S(3, ac3Var);
                d32.c().a(f94Var, PMSDownloadType.ALONE_SUB, ac3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, f94Var) == null) {
                super.i(f94Var);
                if (y32.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + f94Var.toString());
                }
                this.a.U(f94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void f(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f94Var) == null) {
                super.f(f94Var);
                if (y32.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(f94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y32 a;

        public b(y32 y32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y32Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.T();
            }
        }

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.a.S(0, ac3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755192807, "Lcom/repackage/y32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755192807, "Lcom/repackage/y32;");
                return;
            }
        }
        g = rg1.a;
    }

    public y32(String str, String str2, c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, c32Var};
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
        this.c = c32Var;
        this.e = dj2.e.i(str, str2).getPath();
    }

    @Override // com.repackage.a84
    public w74<f94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (w74) invokeV.objValue;
    }

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z84Var) == null) {
            super.C(z84Var);
            ac3 ac3Var = new ac3();
            ac3Var.k(12L);
            ac3Var.c(z84Var);
            S(1, ac3Var);
        }
    }

    @Override // com.repackage.a84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ac3 ac3Var = new ac3();
            ac3Var.k(12L);
            ac3Var.i(2901L);
            ac3Var.d("Server无包");
            S(2, ac3Var);
        }
    }

    public final void S(int i, ac3 ac3Var) {
        c32 c32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, ac3Var) == null) || (c32Var = this.c) == null) {
            return;
        }
        c32Var.b(i, ac3Var);
    }

    public final void T() {
        c32 c32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (c32Var = this.c) == null) {
            return;
        }
        c32Var.a();
    }

    public final void U(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f94Var) == null) {
            if (!ud3.a(new File(f94Var.a), f94Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                ac3 ac3Var = new ac3();
                ac3Var.k(12L);
                ac3Var.i(2300L);
                ac3Var.d("分包签名校验");
                S(4, ac3Var);
                d32.c().a(f94Var, PMSDownloadType.ALONE_SUB, ac3Var);
            } else if (a42.h(new File(f94Var.a), new File(this.e, f94Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                f94Var.o = this.d;
                c84.i().m(f94Var);
                T();
                d32.c().b(f94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(12L);
                ac3Var2.i(2320L);
                ac3Var2.d("分包解压失败");
                S(5, ac3Var2);
                d32.c().a(f94Var, PMSDownloadType.ALONE_SUB, ac3Var2);
            }
        }
    }

    public final void V(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f94Var) == null) {
            d32.c().d(f94Var, new b(this));
        }
    }
}
