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
import com.repackage.w14;
import com.repackage.yw3;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class z14 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public w14.a c;
    public String d;
    public String e;
    public String f;
    public y74<h94> g;

    /* loaded from: classes7.dex */
    public class a extends v74<h94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z14 a;

        public a(z14 z14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z14Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.y74
        /* renamed from: l */
        public String d(h94 h94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, h94Var)) == null) ? c42.c(this.a.f) : (String) invokeL.objValue;
        }

        @Override // com.repackage.a84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: o */
        public void e(h94 h94Var, b94 b94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, h94Var, b94Var) == null) {
                super.e(h94Var, b94Var);
                if (z14.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + b94Var.toString());
                }
                this.a.U(2103);
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.i(b94Var.a);
                cc3Var.d("分包下载失败");
                cc3Var.f(b94Var.toString());
                f32.c().a(h94Var, PMSDownloadType.ALONE_SUB, cc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: p */
        public void i(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h94Var) == null) {
                super.i(h94Var);
                if (z14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + h94Var.toString());
                }
                this.a.X(h94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: q */
        public void a(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, h94Var) == null) {
                super.a(h94Var);
                if (z14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + h94Var.k + ":" + h94Var.b);
                }
                this.a.V(h94Var.b, h94Var.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.v74, com.repackage.y74
        /* renamed from: r */
        public void f(h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, h94Var) == null) {
                super.f(h94Var);
                if (z14.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.Y(h94Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z14 a;

        public b(z14 z14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z14Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755164876, "Lcom/repackage/z14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755164876, "Lcom/repackage/z14;");
                return;
            }
        }
        h = tg1.a;
    }

    public z14(String str, String str2, String str3, w14.a aVar) {
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

    @Override // com.repackage.c84
    public y74<h94> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (y74) invokeV.objValue;
    }

    @Override // com.repackage.c84
    public void D(b94 b94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b94Var) == null) {
            super.D(b94Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + b94Var.toString());
            }
            U(2103);
        }
    }

    @Override // com.repackage.c84
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
        w14.a aVar;
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
        w14.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.c) == null) {
            return;
        }
        aVar.success();
    }

    public final void X(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, h94Var) == null) {
            if (!wd3.a(new File(h94Var.a), h94Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                U(2104);
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.i(2300L);
                cc3Var.d("分包签名校验");
                f32.c().a(h94Var, PMSDownloadType.ALONE_SUB, cc3Var);
            } else if (c42.h(new File(h94Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                W();
                h94Var.o = this.d;
                e84.i().m(h94Var);
                f32.c().b(h94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                U(2105);
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(12L);
                cc3Var2.i(2320L);
                cc3Var2.d("分包解压失败");
                f32.c().a(h94Var, PMSDownloadType.ALONE_SUB, cc3Var2);
            }
        }
    }

    public final void Y(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, h94Var) == null) {
            f32.c().d(h94Var, new b(this));
        }
    }
}
