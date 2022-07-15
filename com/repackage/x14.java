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
import com.repackage.u14;
import com.repackage.ww3;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class x14 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public u14.a c;
    public String d;
    public String e;
    public String f;
    public w74<f94> g;

    /* loaded from: classes7.dex */
    public class a extends t74<f94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x14 a;

        public a(x14 x14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x14Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: l */
        public String d(f94 f94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f94Var)) == null) ? a42.c(this.a.f) : (String) invokeL.objValue;
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: o */
        public void e(f94 f94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, f94Var, z84Var) == null) {
                super.e(f94Var, z84Var);
                if (x14.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + z84Var.toString());
                }
                this.a.T(2103);
                ac3 ac3Var = new ac3();
                ac3Var.k(12L);
                ac3Var.i(z84Var.a);
                ac3Var.d("分包下载失败");
                ac3Var.f(z84Var.toString());
                d32.c().a(f94Var, PMSDownloadType.ALONE_SUB, ac3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: p */
        public void i(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f94Var) == null) {
                super.i(f94Var);
                if (x14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + f94Var.toString());
                }
                this.a.W(f94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void a(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, f94Var) == null) {
                super.a(f94Var);
                if (x14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + f94Var.k + ":" + f94Var.b);
                }
                this.a.U(f94Var.b, f94Var.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void f(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, f94Var) == null) {
                super.f(f94Var);
                if (x14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(f94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x14 a;

        public b(x14 x14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x14Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.V();
            }
        }

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.a.T(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755224458, "Lcom/repackage/x14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755224458, "Lcom/repackage/x14;");
                return;
            }
        }
        h = rg1.a;
    }

    public x14(String str, String str2, String str3, u14.a aVar) {
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
        this.f = ww3.d.h(str, str2).getPath();
    }

    @Override // com.repackage.a84
    public w74<f94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (w74) invokeV.objValue;
    }

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z84Var) == null) {
            super.C(z84Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + z84Var.toString());
            }
            T(2103);
        }
    }

    @Override // com.repackage.a84
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
        u14.a aVar;
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
        u14.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.c) == null) {
            return;
        }
        aVar.success();
    }

    public final void W(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f94Var) == null) {
            if (!ud3.a(new File(f94Var.a), f94Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(2104);
                ac3 ac3Var = new ac3();
                ac3Var.k(12L);
                ac3Var.i(2300L);
                ac3Var.d("分包签名校验");
                d32.c().a(f94Var, PMSDownloadType.ALONE_SUB, ac3Var);
            } else if (a42.h(new File(f94Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                f94Var.o = this.d;
                c84.i().m(f94Var);
                d32.c().b(f94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(12L);
                ac3Var2.i(2320L);
                ac3Var2.d("分包解压失败");
                d32.c().a(f94Var, PMSDownloadType.ALONE_SUB, ac3Var2);
            }
        }
    }

    public final void X(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, f94Var) == null) {
            d32.c().d(f94Var, new b(this));
        }
    }
}
