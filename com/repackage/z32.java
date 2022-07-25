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
import com.repackage.e32;
import com.repackage.ej2;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class z32 extends m32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public d32 c;
    public String d;
    public String e;
    public x74<g94> f;

    /* loaded from: classes7.dex */
    public class a extends u74<g94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public a(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x74
        /* renamed from: l */
        public String d(g94 g94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, g94Var)) == null) ? b42.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.repackage.z74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: o */
        public void e(g94 g94Var, a94 a94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, g94Var, a94Var) == null) {
                super.e(g94Var, a94Var);
                if (z32.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + a94Var.toString());
                }
                bc3 bc3Var = new bc3();
                bc3Var.k(12L);
                bc3Var.i(a94Var.a);
                bc3Var.d("分包下载失败");
                bc3Var.f(a94Var.toString());
                this.a.S(3, bc3Var);
                e32.c().a(g94Var, PMSDownloadType.ALONE_SUB, bc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: p */
        public void i(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, g94Var) == null) {
                super.i(g94Var);
                if (z32.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + g94Var.toString());
                }
                this.a.U(g94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u74, com.repackage.x74
        /* renamed from: q */
        public void f(g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g94Var) == null) {
                super.f(g94Var);
                if (z32.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(g94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z32 a;

        public b(z32 z32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z32Var;
        }

        @Override // com.repackage.e32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.T();
            }
        }

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                this.a.S(0, bc3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755163016, "Lcom/repackage/z32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755163016, "Lcom/repackage/z32;");
                return;
            }
        }
        g = sg1.a;
    }

    public z32(String str, String str2, d32 d32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, d32Var};
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
        this.c = d32Var;
        this.e = ej2.e.i(str, str2).getPath();
    }

    @Override // com.repackage.b84
    public x74<g94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (x74) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public void C(a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a94Var) == null) {
            super.C(a94Var);
            bc3 bc3Var = new bc3();
            bc3Var.k(12L);
            bc3Var.c(a94Var);
            S(1, bc3Var);
        }
    }

    @Override // com.repackage.b84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            bc3 bc3Var = new bc3();
            bc3Var.k(12L);
            bc3Var.i(2901L);
            bc3Var.d("Server无包");
            S(2, bc3Var);
        }
    }

    public final void S(int i, bc3 bc3Var) {
        d32 d32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, bc3Var) == null) || (d32Var = this.c) == null) {
            return;
        }
        d32Var.b(i, bc3Var);
    }

    public final void T() {
        d32 d32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (d32Var = this.c) == null) {
            return;
        }
        d32Var.a();
    }

    public final void U(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g94Var) == null) {
            if (!vd3.a(new File(g94Var.a), g94Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                bc3 bc3Var = new bc3();
                bc3Var.k(12L);
                bc3Var.i(2300L);
                bc3Var.d("分包签名校验");
                S(4, bc3Var);
                e32.c().a(g94Var, PMSDownloadType.ALONE_SUB, bc3Var);
            } else if (b42.h(new File(g94Var.a), new File(this.e, g94Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                g94Var.o = this.d;
                d84.i().m(g94Var);
                T();
                e32.c().b(g94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                bc3 bc3Var2 = new bc3();
                bc3Var2.k(12L);
                bc3Var2.i(2320L);
                bc3Var2.d("分包解压失败");
                S(5, bc3Var2);
                e32.c().a(g94Var, PMSDownloadType.ALONE_SUB, bc3Var2);
            }
        }
    }

    public final void V(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, g94Var) == null) {
            e32.c().d(g94Var, new b(this));
        }
    }
}
