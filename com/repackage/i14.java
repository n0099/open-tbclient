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
import com.repackage.f14;
import com.repackage.hw3;
import com.repackage.o22;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class i14 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public f14.a c;
    public String d;
    public String e;
    public String f;
    public h74<q84> g;

    /* loaded from: classes6.dex */
    public class a extends e74<q84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i14 a;

        public a(i14 i14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i14Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: l */
        public String d(q84 q84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, q84Var)) == null) ? l32.c(this.a.f) : (String) invokeL.objValue;
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: o */
        public void e(q84 q84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, q84Var, k84Var) == null) {
                super.e(q84Var, k84Var);
                if (i14.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + k84Var.toString());
                }
                this.a.T(2103);
                lb3 lb3Var = new lb3();
                lb3Var.k(12L);
                lb3Var.i(k84Var.a);
                lb3Var.d("分包下载失败");
                lb3Var.f(k84Var.toString());
                o22.c().a(q84Var, PMSDownloadType.ALONE_SUB, lb3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: p */
        public void i(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q84Var) == null) {
                super.i(q84Var);
                if (i14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + q84Var.toString());
                }
                this.a.W(q84Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void a(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, q84Var) == null) {
                super.a(q84Var);
                if (i14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + q84Var.k + ":" + q84Var.b);
                }
                this.a.U(q84Var.b, q84Var.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: r */
        public void f(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, q84Var) == null) {
                super.f(q84Var);
                if (i14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(q84Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i14 a;

        public b(i14 i14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i14Var;
        }

        @Override // com.repackage.o22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.V();
            }
        }

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                this.a.T(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755671323, "Lcom/repackage/i14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755671323, "Lcom/repackage/i14;");
                return;
            }
        }
        h = cg1.a;
    }

    public i14(String str, String str2, String str3, f14.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.d = str;
        this.e = str3;
        this.c = aVar;
        this.f = hw3.d.h(str, str2).getPath();
    }

    @Override // com.repackage.l74
    public h74<q84> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (h74) invokeV.objValue;
    }

    @Override // com.repackage.l74
    public void C(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k84Var) == null) {
            super.C(k84Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + k84Var.toString());
            }
            T(2103);
        }
    }

    @Override // com.repackage.l74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (h) {
                Log.i("SwanGameSubPkgDownload", "onNoPackage");
            }
            T(2102);
        }
    }

    public final void T(int i) {
        f14.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (aVar = this.c) == null) {
            return;
        }
        aVar.b(i);
    }

    public final void U(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.c == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.c.a(floor, j, j2);
                return;
            }
            return;
        }
        T(2114);
    }

    public final void V() {
        f14.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.c) == null) {
            return;
        }
        aVar.success();
    }

    public final void W(q84 q84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, q84Var) == null) {
            if (!fd3.a(new File(q84Var.a), q84Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(2104);
                lb3 lb3Var = new lb3();
                lb3Var.k(12L);
                lb3Var.i(2300L);
                lb3Var.d("分包签名校验");
                o22.c().a(q84Var, PMSDownloadType.ALONE_SUB, lb3Var);
            } else if (l32.h(new File(q84Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                q84Var.o = this.d;
                n74.i().m(q84Var);
                o22.c().b(q84Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                lb3 lb3Var2 = new lb3();
                lb3Var2.k(12L);
                lb3Var2.i(2320L);
                lb3Var2.d("分包解压失败");
                o22.c().a(q84Var, PMSDownloadType.ALONE_SUB, lb3Var2);
            }
        }
    }

    public final void X(q84 q84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, q84Var) == null) {
            o22.c().d(q84Var, new b(this));
        }
    }
}
