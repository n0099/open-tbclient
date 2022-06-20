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
import com.repackage.ka4;
import com.repackage.ky1;
import com.repackage.oi2;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class p22 extends w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public yc4 c;
    public m22 d;
    public final List<q84> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public d74<ka4.a> i;
    public h74<q84> j;
    public final h74<r84> k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 a;

        public a(p22 p22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = n74.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (q84 q84Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(q84Var);
                        }
                        this.a.W();
                    }
                }
                if (p22.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends d74<ka4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ka4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, ka4.a aVar) {
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
                        i32.c(this.a.g.appId);
                    }
                    h82.f(this.a.b);
                }
            }
        }

        public b(p22 p22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p22Var;
        }

        @Override // com.repackage.d74
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                c23.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // com.repackage.j74
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // com.repackage.d74
        public void o(ka4.a aVar, PMSAppInfo pMSAppInfo, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, k84Var) == null) {
                sw1.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + k84Var.a + " errorMsg=" + k84Var.b + " errorDetails=" + k84Var.d);
                if (this.a.d != null) {
                    this.a.d.f(k84Var);
                }
                if (k84Var.a != 1010) {
                    this.a.g = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.a.X(pMSAppInfo2, pMSAppInfo);
                if (!i32.m(k84Var) || pMSAppInfo2 == null) {
                    return;
                }
                i32.c(pMSAppInfo2.appId);
            }
        }

        @Override // com.repackage.d74
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    c23.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.h74
        /* renamed from: q */
        public String d(ka4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return k32.g();
                }
                if (i == 1) {
                    return k32.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: r */
        public void e(ka4.a aVar, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, k84Var) == null) {
                super.e(aVar, k84Var);
                sw1.k("SwanAppBatchDownloadCallback", "onDownloadError：" + k84Var.toString());
                h82.f(aVar.b);
                lb3 lb3Var = new lb3();
                lb3Var.k(11L);
                lb3Var.i(k84Var.a);
                lb3Var.d("批量下载，主包下载失败：" + aVar.b);
                lb3Var.f(k84Var.toString());
                if (aVar.a != 0) {
                    if (p22.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + lb3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    o22.c().a(aVar.d, PMSDownloadType.BATCH, lb3Var);
                    sw1.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    uf4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: s */
        public void i(ka4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                sw1.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: t */
        public void a(ka4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (p22.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: u */
        public void c(ka4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                sw1.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: v */
        public void f(ka4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (p22.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                h82.f(aVar.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ p22 c;

        public c(p22 p22Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p22Var;
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
                if (n74.i().l(this.b)) {
                    k32.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends z22<p22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(p22 p22Var, p22 p22Var2) {
            super(p22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var, p22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((w22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p22Var;
        }

        @Override // com.repackage.z22
        public void p(@NonNull q84 q84Var, @Nullable lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, q84Var, lb3Var) == null) {
                super.p(q84Var, lb3Var);
                if (lb3Var == null) {
                    this.c.e.add(q84Var);
                } else if (p22.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + q84Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + lb3Var);
                }
                h82.f(q84Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: q */
        public void e(q84 q84Var, k84 k84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, q84Var, k84Var) == null) {
                super.q(q84Var, k84Var);
                h82.f(q84Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e74, com.repackage.h74
        /* renamed from: u */
        public void f(q84 q84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, q84Var) == null) {
                super.f(q84Var);
                h82.f(q84Var.o);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends x22<p22> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p22 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(p22 p22Var, p22 p22Var2) {
            super(p22Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p22Var, p22Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((w22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p22Var;
        }

        @Override // com.repackage.x22
        public void r(@NonNull r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r84Var) == null) {
                if (p22.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + r84Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(r84Var);
                }
                this.b.W();
            }
        }

        @Override // com.repackage.x22
        public void u(r84 r84Var, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r84Var, lb3Var) == null) {
                sw1.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + r84Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + lb3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755461887, "Lcom/repackage/p22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755461887, "Lcom/repackage/p22;");
                return;
            }
        }
        l = cg1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p22() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((m22) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.l74
    public h74<q84> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (h74) invokeV.objValue;
    }

    @Override // com.repackage.l74
    public void C(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k84Var) == null) {
            super.C(k84Var);
            sw1.k("SwanAppBatchDownloadCallback", "onFetchError: " + k84Var.toString());
            m22 m22Var = this.d;
            if (m22Var != null) {
                m22Var.b(k84Var.a);
            }
        }
    }

    @Override // com.repackage.l74
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            sw1.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.repackage.l74
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            sw1.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.repackage.l74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            sw1.k("SwanAppBatchDownloadCallback", "onNoPackage");
            m22 m22Var = this.d;
            if (m22Var != null) {
                m22Var.d();
            }
        }
    }

    @Override // com.repackage.l74
    public void G(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yc4Var) == null) {
            super.G(yc4Var);
            this.c = yc4Var;
            h82.e(yc4Var);
            sw1.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + yc4Var.n());
        }
    }

    @Override // com.repackage.w22
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(ka4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!fd3.a(new File(aVar.d.a), aVar.d.m)) {
                sw1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            lb3 m = k32.m(aVar.d, this);
            if (m != null) {
                sw1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            k32.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!n74.i().a(aVar.d, aVar.g)) {
                sw1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                k32.o(aVar.g);
            }
            k32.b(aVar.d);
            p84 p84Var = aVar.d;
            if (p84Var != null) {
                e03.c(oi2.e.i(p84Var.g, String.valueOf(p84Var.i)).getAbsolutePath(), true);
            }
            p84 p84Var2 = aVar.d;
            if (p84Var2 == null || p84Var2.h != 0 || ((c2 = ky1.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            h22 i2 = h22.i();
            p84 p84Var3 = aVar.d;
            i2.f(p84Var3.g, p84Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        m22 m22Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != n || this.g || (m22Var = this.d) == null) {
                return;
            }
            m22Var.a();
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        mc3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.repackage.l74, com.repackage.i74
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            sw1.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                mc3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            m22 m22Var = this.d;
            if (m22Var != null) {
                m22Var.h();
            }
            if (i82.a()) {
                return;
            }
            sw1.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
            c82 d2 = e82.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
            n92 l2 = n92.l();
            l2.i(7);
            d2.t(copyOnWriteArraySet, false, l2.k());
        }
    }

    @Override // com.repackage.l74
    public h74<r84> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (h74) invokeV.objValue;
    }

    @Override // com.repackage.l74
    public d74<ka4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (d74) invokeV.objValue;
    }

    public p22(m22 m22Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m22Var};
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
        this.d = m22Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }
}
