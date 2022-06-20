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
import com.repackage.o22;
import com.repackage.oi2;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class j32 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public n22 c;
    public String d;
    public String e;
    public h74<q84> f;

    /* loaded from: classes6.dex */
    public class a extends e74<q84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public a(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: l */
        public String d(q84 q84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, q84Var)) == null) ? l32.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: o */
        public void e(q84 q84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, q84Var, k84Var) == null) {
                super.e(q84Var, k84Var);
                if (j32.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + k84Var.toString());
                }
                lb3 lb3Var = new lb3();
                lb3Var.k(12L);
                lb3Var.i(k84Var.a);
                lb3Var.d("分包下载失败");
                lb3Var.f(k84Var.toString());
                this.a.S(3, lb3Var);
                o22.c().a(q84Var, PMSDownloadType.ALONE_SUB, lb3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: p */
        public void i(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, q84Var) == null) {
                super.i(q84Var);
                if (j32.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + q84Var.toString());
                }
                this.a.U(q84Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void f(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q84Var) == null) {
                super.f(q84Var);
                if (j32.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(q84Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public b(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        @Override // com.repackage.o22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.T();
            }
        }

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                this.a.S(0, lb3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755639672, "Lcom/repackage/j32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755639672, "Lcom/repackage/j32;");
                return;
            }
        }
        g = cg1.a;
    }

    public j32(String str, String str2, n22 n22Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, n22Var};
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
        this.c = n22Var;
        this.e = oi2.e.i(str, str2).getPath();
    }

    @Override // com.repackage.l74
    public h74<q84> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (h74) invokeV.objValue;
    }

    @Override // com.repackage.l74
    public void C(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k84Var) == null) {
            super.C(k84Var);
            lb3 lb3Var = new lb3();
            lb3Var.k(12L);
            lb3Var.c(k84Var);
            S(1, lb3Var);
        }
    }

    @Override // com.repackage.l74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            lb3 lb3Var = new lb3();
            lb3Var.k(12L);
            lb3Var.i(2901L);
            lb3Var.d("Server无包");
            S(2, lb3Var);
        }
    }

    public final void S(int i, lb3 lb3Var) {
        n22 n22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, lb3Var) == null) || (n22Var = this.c) == null) {
            return;
        }
        n22Var.b(i, lb3Var);
    }

    public final void T() {
        n22 n22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (n22Var = this.c) == null) {
            return;
        }
        n22Var.a();
    }

    public final void U(q84 q84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, q84Var) == null) {
            if (!fd3.a(new File(q84Var.a), q84Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                lb3 lb3Var = new lb3();
                lb3Var.k(12L);
                lb3Var.i(2300L);
                lb3Var.d("分包签名校验");
                S(4, lb3Var);
                o22.c().a(q84Var, PMSDownloadType.ALONE_SUB, lb3Var);
            } else if (l32.h(new File(q84Var.a), new File(this.e, q84Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                q84Var.o = this.d;
                n74.i().m(q84Var);
                T();
                o22.c().b(q84Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                lb3 lb3Var2 = new lb3();
                lb3Var2.k(12L);
                lb3Var2.i(2320L);
                lb3Var2.d("分包解压失败");
                S(5, lb3Var2);
                o22.c().a(q84Var, PMSDownloadType.ALONE_SUB, lb3Var2);
            }
        }
    }

    public final void V(q84 q84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, q84Var) == null) {
            o22.c().d(q84Var, new b(this));
        }
    }
}
