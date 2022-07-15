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
import com.repackage.dj2;
import com.repackage.za4;
import com.repackage.zy1;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class e32 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public nd4 c;
    public b32 d;
    public final List<f94> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public s74<za4.a> i;
    public w74<f94> j;
    public final w74<g94> k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e32 a;

        public a(e32 e32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = c84.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (f94 f94Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(f94Var);
                        }
                        this.a.W();
                    }
                }
                if (e32.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends s74<za4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e32 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ za4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, za4.a aVar) {
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
                    if (this.b.a.V(this.a)) {
                        this.b.a.W();
                        if (this.b.a.d != null) {
                            this.b.a.d.c(this.a);
                        }
                        x32.c(this.a.g.appId);
                    }
                    w82.f(this.a.b);
                }
            }
        }

        public b(e32 e32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e32Var;
        }

        @Override // com.repackage.s74
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                r23.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // com.repackage.y74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // com.repackage.s74
        public void o(za4.a aVar, PMSAppInfo pMSAppInfo, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, z84Var) == null) {
                hx1.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + z84Var.a + " errorMsg=" + z84Var.b + " errorDetails=" + z84Var.d);
                if (this.a.d != null) {
                    this.a.d.f(z84Var);
                }
                if (z84Var.a != 1010) {
                    this.a.g = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.a.X(pMSAppInfo2, pMSAppInfo);
                if (!x32.m(z84Var) || pMSAppInfo2 == null) {
                    return;
                }
                x32.c(pMSAppInfo2.appId);
            }
        }

        @Override // com.repackage.s74
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    r23.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.w74
        /* renamed from: q */
        public String d(za4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return z32.g();
                }
                if (i == 1) {
                    return z32.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: r */
        public void e(za4.a aVar, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, z84Var) == null) {
                super.e(aVar, z84Var);
                hx1.k("SwanAppBatchDownloadCallback", "onDownloadError：" + z84Var.toString());
                w82.f(aVar.b);
                ac3 ac3Var = new ac3();
                ac3Var.k(11L);
                ac3Var.i(z84Var.a);
                ac3Var.d("批量下载，主包下载失败：" + aVar.b);
                ac3Var.f(z84Var.toString());
                if (aVar.a != 0) {
                    if (e32.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + ac3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    d32.c().a(aVar.d, PMSDownloadType.BATCH, ac3Var);
                    hx1.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    jg4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: s */
        public void i(za4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                hx1.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: t */
        public void a(za4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (e32.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: u */
        public void c(za4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                hx1.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: v */
        public void f(za4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (e32.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                w82.f(aVar.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ e32 c;

        public c(e32 e32Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e32Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e32Var;
            this.a = pMSAppInfo;
            this.b = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.a;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.c.J());
                    this.b.copyLocalAppInfoData(this.a);
                } else {
                    this.b.updateInstallSrc(this.c.J());
                }
                this.b.initMaxAgeInfo();
                if (c84.i().l(this.b)) {
                    z32.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends o32<e32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e32 e32Var, e32 e32Var2) {
            super(e32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e32Var, e32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e32Var;
        }

        @Override // com.repackage.o32
        public void p(@NonNull f94 f94Var, @Nullable ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, f94Var, ac3Var) == null) {
                super.p(f94Var, ac3Var);
                if (ac3Var == null) {
                    this.c.e.add(f94Var);
                } else if (e32.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + f94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ac3Var);
                }
                w82.f(f94Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: q */
        public void e(f94 f94Var, z84 z84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, f94Var, z84Var) == null) {
                super.q(f94Var, z84Var);
                w82.f(f94Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t74, com.repackage.w74
        /* renamed from: u */
        public void f(f94 f94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, f94Var) == null) {
                super.f(f94Var);
                w82.f(f94Var.o);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends m32<e32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(e32 e32Var, e32 e32Var2) {
            super(e32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e32Var, e32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e32Var;
        }

        @Override // com.repackage.m32
        public void r(@NonNull g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g94Var) == null) {
                if (e32.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + g94Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(g94Var);
                }
                this.b.W();
            }
        }

        @Override // com.repackage.m32
        public void u(g94 g94Var, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g94Var, ac3Var) == null) {
                hx1.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + g94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ac3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755788627, "Lcom/repackage/e32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755788627, "Lcom/repackage/e32;");
                return;
            }
        }
        l = rg1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e32() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((b32) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.a84
    public w74<f94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (w74) invokeV.objValue;
    }

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z84Var) == null) {
            super.C(z84Var);
            hx1.k("SwanAppBatchDownloadCallback", "onFetchError: " + z84Var.toString());
            b32 b32Var = this.d;
            if (b32Var != null) {
                b32Var.b(z84Var.a);
            }
        }
    }

    @Override // com.repackage.a84
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            hx1.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.repackage.a84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            hx1.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.repackage.a84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            hx1.k("SwanAppBatchDownloadCallback", "onNoPackage");
            b32 b32Var = this.d;
            if (b32Var != null) {
                b32Var.d();
            }
        }
    }

    @Override // com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nd4Var) == null) {
            super.G(nd4Var);
            this.c = nd4Var;
            w82.e(nd4Var);
            hx1.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + nd4Var.n());
        }
    }

    @Override // com.repackage.l32
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(za4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!ud3.a(new File(aVar.d.a), aVar.d.m)) {
                hx1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            ac3 m = z32.m(aVar.d, this);
            if (m != null) {
                hx1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            z32.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!c84.i().a(aVar.d, aVar.g)) {
                hx1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                z32.o(aVar.g);
            }
            z32.b(aVar.d);
            e94 e94Var = aVar.d;
            if (e94Var != null) {
                t03.c(dj2.e.i(e94Var.g, String.valueOf(e94Var.i)).getAbsolutePath(), true);
            }
            e94 e94Var2 = aVar.d;
            if (e94Var2 == null || e94Var2.h != 0 || ((c2 = zy1.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            w22 i2 = w22.i();
            e94 e94Var3 = aVar.d;
            i2.f(e94Var3.g, e94Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        b32 b32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != n || this.g || (b32Var = this.d) == null) {
                return;
            }
            b32Var.a();
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        bd3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.repackage.a84, com.repackage.x74
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            hx1.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                bd3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            b32 b32Var = this.d;
            if (b32Var != null) {
                b32Var.h();
            }
            if (x82.a()) {
                return;
            }
            hx1.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
            r82 d2 = t82.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
            ca2 l2 = ca2.l();
            l2.i(7);
            d2.t(copyOnWriteArraySet, false, l2.k());
        }
    }

    @Override // com.repackage.a84
    public w74<g94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (w74) invokeV.objValue;
    }

    @Override // com.repackage.a84
    public s74<za4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (s74) invokeV.objValue;
    }

    public e32(b32 b32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b32Var};
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
        this.d = b32Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }
}
