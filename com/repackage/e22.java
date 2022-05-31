package com.repackage;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di2;
import com.repackage.z94;
import com.repackage.zx1;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class e22 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public nc4 c;
    public b22 d;
    public final List<f84> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public s64<z94.a> i;
    public w64<f84> j;
    public final w64<g84> k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e22 a;

        public a(e22 e22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = c74.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (f84 f84Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(f84Var);
                        }
                        this.a.X();
                    }
                }
                if (e22.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends s64<z94.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e22 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z94.a a;
            public final /* synthetic */ b b;

            public a(b bVar, z94.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.b.a.W(this.a)) {
                        this.b.a.X();
                        if (this.b.a.d != null) {
                            this.b.a.d.c(this.a);
                        }
                        x22.c(this.a.g.appId);
                    }
                    w72.f(this.a.b);
                }
            }
        }

        public b(e22 e22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e22Var;
        }

        @Override // com.repackage.s64
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                r13.K(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // com.repackage.y64
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // com.repackage.s64
        public void o(z94.a aVar, PMSAppInfo pMSAppInfo, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, z74Var) == null) {
                hw1.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + z74Var.a + " errorMsg=" + z74Var.b + " errorDetails=" + z74Var.d);
                if (this.a.d != null) {
                    this.a.d.f(z74Var);
                }
                if (z74Var.a != 1010) {
                    this.a.g = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.a.Y(pMSAppInfo2, pMSAppInfo);
                if (!x22.m(z74Var) || pMSAppInfo2 == null) {
                    return;
                }
                x22.c(pMSAppInfo2.appId);
            }
        }

        @Override // com.repackage.s64
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    r13.K(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.Y(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w64
        /* renamed from: q */
        public String d(z94.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return z22.g();
                }
                if (i == 1) {
                    return z22.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: r */
        public void e(z94.a aVar, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, z74Var) == null) {
                super.e(aVar, z74Var);
                hw1.k("SwanAppBatchDownloadCallback", "onDownloadError：" + z74Var.toString());
                w72.f(aVar.b);
                ab3 ab3Var = new ab3();
                ab3Var.k(11L);
                ab3Var.i(z74Var.a);
                ab3Var.d("批量下载，主包下载失败：" + aVar.b);
                ab3Var.f(z74Var.toString());
                if (aVar.a != 0) {
                    if (e22.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + ab3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    d22.c().a(aVar.d, PMSDownloadType.BATCH, ab3Var);
                    hw1.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    kf4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: s */
        public void i(z94.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                hw1.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: t */
        public void a(z94.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (e22.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: u */
        public void c(z94.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                hw1.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: v */
        public void f(z94.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (e22.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                w72.f(aVar.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ e22 c;

        public c(e22 e22Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e22Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e22Var;
            this.a = pMSAppInfo;
            this.b = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.a;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.c.K());
                    this.b.copyLocalAppInfoData(this.a);
                } else {
                    this.b.updateInstallSrc(this.c.K());
                }
                this.b.initMaxAgeInfo();
                if (c74.i().l(this.b)) {
                    z22.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends o22<e22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e22 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e22 e22Var, e22 e22Var2) {
            super(e22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e22Var, e22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e22Var;
        }

        @Override // com.repackage.o22
        public void p(@NonNull f84 f84Var, @Nullable ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, f84Var, ab3Var) == null) {
                super.p(f84Var, ab3Var);
                if (ab3Var == null) {
                    this.c.e.add(f84Var);
                } else if (e22.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + f84Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ab3Var);
                }
                w72.f(f84Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: q */
        public void e(f84 f84Var, z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, f84Var, z74Var) == null) {
                super.q(f84Var, z74Var);
                w72.f(f84Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t64, com.repackage.w64
        /* renamed from: u */
        public void f(f84 f84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, f84Var) == null) {
                super.f(f84Var);
                w72.f(f84Var.o);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends m22<e22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e22 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(e22 e22Var, e22 e22Var2) {
            super(e22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e22Var, e22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e22Var;
        }

        @Override // com.repackage.m22
        public void r(@NonNull g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g84Var) == null) {
                if (e22.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + g84Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(g84Var);
                }
                this.b.X();
            }
        }

        @Override // com.repackage.m22
        public void u(g84 g84Var, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g84Var, ab3Var) == null) {
                hw1.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + g84Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ab3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755789588, "Lcom/repackage/e22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755789588, "Lcom/repackage/e22;");
                return;
            }
        }
        l = rf1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e22() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((b22) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.a74
    public w64<f84> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (w64) invokeV.objValue;
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z74Var) == null) {
            super.D(z74Var);
            hw1.k("SwanAppBatchDownloadCallback", "onFetchError: " + z74Var.toString());
            b22 b22Var = this.d;
            if (b22Var != null) {
                b22Var.b(z74Var.a);
            }
        }
    }

    @Override // com.repackage.a74
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            hw1.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.repackage.a74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            hw1.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.G();
            hw1.k("SwanAppBatchDownloadCallback", "onNoPackage");
            b22 b22Var = this.d;
            if (b22Var != null) {
                b22Var.d();
            }
        }
    }

    @Override // com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nc4Var) == null) {
            super.H(nc4Var);
            this.c = nc4Var;
            w72.e(nc4Var);
            hw1.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + nc4Var.n());
        }
    }

    @Override // com.repackage.l22
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean W(z94.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!uc3.a(new File(aVar.d.a), aVar.d.m)) {
                hw1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            ab3 m = z22.m(aVar.d, this);
            if (m != null) {
                hw1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            z22.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(K());
            if (!c74.i().a(aVar.d, aVar.g)) {
                hw1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                z22.o(aVar.g);
            }
            z22.b(aVar.d);
            e84 e84Var = aVar.d;
            if (e84Var != null) {
                tz2.c(di2.e.i(e84Var.g, String.valueOf(e84Var.i)).getAbsolutePath(), true);
            }
            e84 e84Var2 = aVar.d;
            if (e84Var2 == null || e84Var2.h != 0 || ((c2 = zx1.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            w12 i2 = w12.i();
            e84 e84Var3 = aVar.d;
            i2.f(e84Var3.g, e84Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void X() {
        b22 b22Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != n || this.g || (b22Var = this.d) == null) {
                return;
            }
            b22Var.a();
        }
    }

    public final void Y(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        bc3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.repackage.a74, com.repackage.x64
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            hw1.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                bc3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            b22 b22Var = this.d;
            if (b22Var != null) {
                b22Var.h();
            }
            if (x72.a()) {
                return;
            }
            hw1.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
            r72 d2 = t72.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
            c92 l2 = c92.l();
            l2.i(7);
            d2.t(copyOnWriteArraySet, false, l2.k());
        }
    }

    @Override // com.repackage.a74
    public w64<g84> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (w64) invokeV.objValue;
    }

    @Override // com.repackage.a74
    public s64<z94.a> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (s64) invokeV.objValue;
    }

    public e22(b22 b22Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b22Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = new b(this);
        this.j = new d(this, this);
        this.k = new e(this, this);
        this.d = b22Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }
}
