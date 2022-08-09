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
import com.repackage.v32;
import com.repackage.vj2;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class q42 extends d42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public u32 c;
    public String d;
    public String e;
    public o84<x94> f;

    /* loaded from: classes7.dex */
    public class a extends l84<x94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q42 a;

        public a(q42 q42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.o84
        /* renamed from: l */
        public String d(x94 x94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, x94Var)) == null) ? s42.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.repackage.q84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: o */
        public void e(x94 x94Var, r94 r94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, x94Var, r94Var) == null) {
                super.e(x94Var, r94Var);
                if (q42.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + r94Var.toString());
                }
                sc3 sc3Var = new sc3();
                sc3Var.k(12L);
                sc3Var.i(r94Var.a);
                sc3Var.d("分包下载失败");
                sc3Var.f(r94Var.toString());
                this.a.S(3, sc3Var);
                v32.c().a(x94Var, PMSDownloadType.ALONE_SUB, sc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: p */
        public void i(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, x94Var) == null) {
                super.i(x94Var);
                if (q42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + x94Var.toString());
                }
                this.a.U(x94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l84, com.repackage.o84
        /* renamed from: q */
        public void f(x94 x94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x94Var) == null) {
                super.f(x94Var);
                if (q42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(x94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q42 a;

        public b(q42 q42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q42Var;
        }

        @Override // com.repackage.v32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.T();
            }
        }

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                this.a.S(0, sc3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755430174, "Lcom/repackage/q42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755430174, "Lcom/repackage/q42;");
                return;
            }
        }
        g = jh1.a;
    }

    public q42(String str, String str2, u32 u32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, u32Var};
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
        this.c = u32Var;
        this.e = vj2.e.i(str, str2).getPath();
    }

    @Override // com.repackage.s84
    public o84<x94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (o84) invokeV.objValue;
    }

    @Override // com.repackage.s84
    public void C(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r94Var) == null) {
            super.C(r94Var);
            sc3 sc3Var = new sc3();
            sc3Var.k(12L);
            sc3Var.c(r94Var);
            S(1, sc3Var);
        }
    }

    @Override // com.repackage.s84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            sc3 sc3Var = new sc3();
            sc3Var.k(12L);
            sc3Var.i(2901L);
            sc3Var.d("Server无包");
            S(2, sc3Var);
        }
    }

    public final void S(int i, sc3 sc3Var) {
        u32 u32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, sc3Var) == null) || (u32Var = this.c) == null) {
            return;
        }
        u32Var.b(i, sc3Var);
    }

    public final void T() {
        u32 u32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (u32Var = this.c) == null) {
            return;
        }
        u32Var.a();
    }

    public final void U(x94 x94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, x94Var) == null) {
            if (!me3.a(new File(x94Var.a), x94Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                sc3 sc3Var = new sc3();
                sc3Var.k(12L);
                sc3Var.i(2300L);
                sc3Var.d("分包签名校验");
                S(4, sc3Var);
                v32.c().a(x94Var, PMSDownloadType.ALONE_SUB, sc3Var);
            } else if (s42.h(new File(x94Var.a), new File(this.e, x94Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                x94Var.o = this.d;
                u84.i().m(x94Var);
                T();
                v32.c().b(x94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                sc3 sc3Var2 = new sc3();
                sc3Var2.k(12L);
                sc3Var2.i(2320L);
                sc3Var2.d("分包解压失败");
                S(5, sc3Var2);
                v32.c().a(x94Var, PMSDownloadType.ALONE_SUB, sc3Var2);
            }
        }
    }

    public final void V(x94 x94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, x94Var) == null) {
            v32.c().d(x94Var, new b(this));
        }
    }
}
