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
import com.repackage.x14;
import com.repackage.yw3;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class a24 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public x14.a c;
    public String d;
    public String e;
    public String f;
    public z74<i94> g;

    /* loaded from: classes5.dex */
    public class a extends w74<i94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a24 a;

        public a(a24 a24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a24Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.z74
        /* renamed from: l */
        public String d(i94 i94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, i94Var)) == null) ? c42.c(this.a.f) : (String) invokeL.objValue;
        }

        @Override // com.repackage.b84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: o */
        public void e(i94 i94Var, c94 c94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, i94Var, c94Var) == null) {
                super.e(i94Var, c94Var);
                if (a24.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + c94Var.toString());
                }
                this.a.U(2103);
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.i(c94Var.a);
                cc3Var.d("分包下载失败");
                cc3Var.f(c94Var.toString());
                f32.c().a(i94Var, PMSDownloadType.ALONE_SUB, cc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: p */
        public void i(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i94Var) == null) {
                super.i(i94Var);
                if (a24.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + i94Var.toString());
                }
                this.a.X(i94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: q */
        public void a(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, i94Var) == null) {
                super.a(i94Var);
                if (a24.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + i94Var.k + ":" + i94Var.b);
                }
                this.a.V(i94Var.b, i94Var.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74, com.repackage.z74
        /* renamed from: r */
        public void f(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, i94Var) == null) {
                super.f(i94Var);
                if (a24.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.Y(i94Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a24 a;

        public b(a24 a24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a24Var;
        }

        @Override // com.repackage.f32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.W();
            }
        }

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.a.U(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755908690, "Lcom/repackage/a24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755908690, "Lcom/repackage/a24;");
                return;
            }
        }
        h = tg1.a;
    }

    public a24(String str, String str2, String str3, x14.a aVar) {
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
        this.f = yw3.d.h(str, str2).getPath();
    }

    @Override // com.repackage.d84
    public z74<i94> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (z74) invokeV.objValue;
    }

    @Override // com.repackage.d84
    public void D(c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c94Var) == null) {
            super.D(c94Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + c94Var.toString());
            }
            U(2103);
        }
    }

    @Override // com.repackage.d84
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
        x14.a aVar;
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
        x14.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.c) == null) {
            return;
        }
        aVar.success();
    }

    public final void X(i94 i94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i94Var) == null) {
            if (!wd3.a(new File(i94Var.a), i94Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                U(2104);
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.i(2300L);
                cc3Var.d("分包签名校验");
                f32.c().a(i94Var, PMSDownloadType.ALONE_SUB, cc3Var);
            } else if (c42.h(new File(i94Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                W();
                i94Var.o = this.d;
                f84.i().m(i94Var);
                f32.c().b(i94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                U(2105);
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(12L);
                cc3Var2.i(2320L);
                cc3Var2.d("分包解压失败");
                f32.c().a(i94Var, PMSDownloadType.ALONE_SUB, cc3Var2);
            }
        }
    }

    public final void Y(i94 i94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, i94Var) == null) {
            f32.c().d(i94Var, new b(this));
        }
    }
}
