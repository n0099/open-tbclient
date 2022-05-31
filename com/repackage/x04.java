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
import com.repackage.u04;
import com.repackage.wv3;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class x04 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public u04.a c;
    public String d;
    public String e;
    public String f;
    public w64<f84> g;

    /* loaded from: classes7.dex */
    public class a extends t64<f84> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x04 a;

        public a(x04 x04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x04Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: l */
        public String d(f84 f84Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f84Var)) == null) ? a32.c(this.a.f) : (String) invokeL.objValue;
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
        public void e(f84 f84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, f84Var, z74Var) == null) {
                super.e(f84Var, z74Var);
                if (x04.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + z74Var.toString());
                }
                this.a.U(2103);
                ab3 ab3Var = new ab3();
                ab3Var.k(12L);
                ab3Var.i(z74Var.a);
                ab3Var.d("分包下载失败");
                ab3Var.f(z74Var.toString());
                d22.c().a(f84Var, PMSDownloadType.ALONE_SUB, ab3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: p */
        public void i(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f84Var) == null) {
                super.i(f84Var);
                if (x04.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + f84Var.toString());
                }
                this.a.X(f84Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void a(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, f84Var) == null) {
                super.a(f84Var);
                if (x04.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + f84Var.k + ":" + f84Var.b);
                }
                this.a.V(f84Var.b, f84Var.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void f(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, f84Var) == null) {
                super.f(f84Var);
                if (x04.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.Y(f84Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x04 a;

        public b(x04 x04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x04Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.W();
            }
        }

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.a.U(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755225419, "Lcom/repackage/x04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755225419, "Lcom/repackage/x04;");
                return;
            }
        }
        h = rf1.a;
    }

    public x04(String str, String str2, String str3, u04.a aVar) {
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
        this.f = wv3.d.h(str, str2).getPath();
    }

    @Override // com.repackage.a74
    public w64<f84> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (w64) invokeV.objValue;
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z74Var) == null) {
            super.D(z74Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + z74Var.toString());
            }
            U(2103);
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            if (h) {
                Log.i("SwanGameSubPkgDownload", "onNoPackage");
            }
            U(2102);
        }
    }

    public final void U(int i) {
        u04.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (aVar = this.c) == null) {
            return;
        }
        aVar.b(i);
    }

    public final void V(long j, long j2) {
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
        U(2114);
    }

    public final void W() {
        u04.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.c) == null) {
            return;
        }
        aVar.success();
    }

    public final void X(f84 f84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f84Var) == null) {
            if (!uc3.a(new File(f84Var.a), f84Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                U(2104);
                ab3 ab3Var = new ab3();
                ab3Var.k(12L);
                ab3Var.i(2300L);
                ab3Var.d("分包签名校验");
                d22.c().a(f84Var, PMSDownloadType.ALONE_SUB, ab3Var);
            } else if (a32.h(new File(f84Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                W();
                f84Var.o = this.d;
                c74.i().m(f84Var);
                d22.c().b(f84Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                U(2105);
                ab3 ab3Var2 = new ab3();
                ab3Var2.k(12L);
                ab3Var2.i(2320L);
                ab3Var2.d("分包解压失败");
                d22.c().a(f84Var, PMSDownloadType.ALONE_SUB, ab3Var2);
            }
        }
    }

    public final void Y(f84 f84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, f84Var) == null) {
            d22.c().d(f84Var, new b(this));
        }
    }
}
