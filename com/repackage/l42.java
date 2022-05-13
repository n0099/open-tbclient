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
import com.repackage.q32;
import com.repackage.qj2;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class l42 extends y32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public p32 c;
    public String d;
    public String e;
    public j84<s94> f;

    /* loaded from: classes6.dex */
    public class a extends g84<s94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l42 a;

        public a(l42 l42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: l */
        public String d(s94 s94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, s94Var)) == null) ? n42.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: o */
        public void e(s94 s94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, s94Var, m94Var) == null) {
                super.e(s94Var, m94Var);
                if (l42.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + m94Var.toString());
                }
                nc3 nc3Var = new nc3();
                nc3Var.k(12L);
                nc3Var.i(m94Var.a);
                nc3Var.d("分包下载失败");
                nc3Var.f(m94Var.toString());
                this.a.T(3, nc3Var);
                q32.c().a(s94Var, PMSDownloadType.ALONE_SUB, nc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: p */
        public void i(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, s94Var) == null) {
                super.i(s94Var);
                if (l42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + s94Var.toString());
                }
                this.a.V(s94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void f(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s94Var) == null) {
                super.f(s94Var);
                if (l42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.W(s94Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l42 a;

        public b(l42 l42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l42Var;
        }

        @Override // com.repackage.q32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.U();
            }
        }

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                this.a.T(0, nc3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755579129, "Lcom/repackage/l42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755579129, "Lcom/repackage/l42;");
                return;
            }
        }
        g = eh1.a;
    }

    public l42(String str, String str2, p32 p32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, p32Var};
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
        this.c = p32Var;
        this.e = qj2.e.i(str, str2).getPath();
    }

    @Override // com.repackage.n84
    public j84<s94> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (j84) invokeV.objValue;
    }

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m94Var) == null) {
            super.D(m94Var);
            nc3 nc3Var = new nc3();
            nc3Var.k(12L);
            nc3Var.c(m94Var);
            T(1, nc3Var);
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            nc3 nc3Var = new nc3();
            nc3Var.k(12L);
            nc3Var.i(2901L);
            nc3Var.d("Server无包");
            T(2, nc3Var);
        }
    }

    public final void T(int i, nc3 nc3Var) {
        p32 p32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, nc3Var) == null) || (p32Var = this.c) == null) {
            return;
        }
        p32Var.b(i, nc3Var);
    }

    public final void U() {
        p32 p32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (p32Var = this.c) == null) {
            return;
        }
        p32Var.a();
    }

    public final void V(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, s94Var) == null) {
            if (!he3.a(new File(s94Var.a), s94Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                nc3 nc3Var = new nc3();
                nc3Var.k(12L);
                nc3Var.i(2300L);
                nc3Var.d("分包签名校验");
                T(4, nc3Var);
                q32.c().a(s94Var, PMSDownloadType.ALONE_SUB, nc3Var);
            } else if (n42.h(new File(s94Var.a), new File(this.e, s94Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                s94Var.o = this.d;
                p84.i().m(s94Var);
                U();
                q32.c().b(s94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                nc3 nc3Var2 = new nc3();
                nc3Var2.k(12L);
                nc3Var2.i(2320L);
                nc3Var2.d("分包解压失败");
                T(5, nc3Var2);
                q32.c().a(s94Var, PMSDownloadType.ALONE_SUB, nc3Var2);
            }
        }
    }

    public final void W(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s94Var) == null) {
            q32.c().d(s94Var, new b(this));
        }
    }
}
