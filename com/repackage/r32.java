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
import com.repackage.mb4;
import com.repackage.mz1;
import com.repackage.qj2;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class r32 extends y32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public ae4 c;
    public o32 d;
    public final List<s94> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public f84<mb4.a> i;
    public j84<s94> j;
    public final j84<t94> k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 a;

        public a(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = p84.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (s94 s94Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(s94Var);
                        }
                        this.a.X();
                    }
                }
                if (r32.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends f84<mb4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mb4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, mb4.a aVar) {
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
                        k42.c(this.a.g.appId);
                    }
                    j92.f(this.a.b);
                }
            }
        }

        public b(r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r32Var;
        }

        @Override // com.repackage.f84
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                e33.K(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // com.repackage.l84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // com.repackage.f84
        public void o(mb4.a aVar, PMSAppInfo pMSAppInfo, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, m94Var) == null) {
                ux1.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + m94Var.a + " errorMsg=" + m94Var.b + " errorDetails=" + m94Var.d);
                if (this.a.d != null) {
                    this.a.d.f(m94Var);
                }
                if (m94Var.a != 1010) {
                    this.a.g = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.a.Y(pMSAppInfo2, pMSAppInfo);
                if (!k42.m(m94Var) || pMSAppInfo2 == null) {
                    return;
                }
                k42.c(pMSAppInfo2.appId);
            }
        }

        @Override // com.repackage.f84
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    e33.K(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.Y(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.j84
        /* renamed from: q */
        public String d(mb4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return m42.g();
                }
                if (i == 1) {
                    return m42.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: r */
        public void e(mb4.a aVar, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, m94Var) == null) {
                super.e(aVar, m94Var);
                ux1.k("SwanAppBatchDownloadCallback", "onDownloadError：" + m94Var.toString());
                j92.f(aVar.b);
                nc3 nc3Var = new nc3();
                nc3Var.k(11L);
                nc3Var.i(m94Var.a);
                nc3Var.d("批量下载，主包下载失败：" + aVar.b);
                nc3Var.f(m94Var.toString());
                if (aVar.a != 0) {
                    if (r32.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + nc3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    q32.c().a(aVar.d, PMSDownloadType.BATCH, nc3Var);
                    ux1.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    xg4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: s */
        public void i(mb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                ux1.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: t */
        public void a(mb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (r32.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: u */
        public void c(mb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                ux1.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: v */
        public void f(mb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (r32.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                j92.f(aVar.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ r32 c;

        public c(r32 r32Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r32Var;
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
                if (p84.i().l(this.b)) {
                    m42.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends b42<r32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(r32 r32Var, r32 r32Var2) {
            super(r32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, r32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((y32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r32Var;
        }

        @Override // com.repackage.b42
        public void p(@NonNull s94 s94Var, @Nullable nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, s94Var, nc3Var) == null) {
                super.p(s94Var, nc3Var);
                if (nc3Var == null) {
                    this.c.e.add(s94Var);
                } else if (r32.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + s94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + nc3Var);
                }
                j92.f(s94Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: q */
        public void e(s94 s94Var, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, s94Var, m94Var) == null) {
                super.q(s94Var, m94Var);
                j92.f(s94Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g84, com.repackage.j84
        /* renamed from: u */
        public void f(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, s94Var) == null) {
                super.f(s94Var);
                j92.f(s94Var.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends z32<r32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(r32 r32Var, r32 r32Var2) {
            super(r32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r32Var, r32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((y32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r32Var;
        }

        @Override // com.repackage.z32
        public void r(@NonNull t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t94Var) == null) {
                if (r32.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + t94Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(t94Var);
                }
                this.b.X();
            }
        }

        @Override // com.repackage.z32
        public void u(t94 t94Var, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t94Var, nc3Var) == null) {
                ux1.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + t94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + nc3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755401344, "Lcom/repackage/r32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755401344, "Lcom/repackage/r32;");
                return;
            }
        }
        l = eh1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r32() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((o32) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.n84
    public j84<s94> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (j84) invokeV.objValue;
    }

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m94Var) == null) {
            super.D(m94Var);
            ux1.k("SwanAppBatchDownloadCallback", "onFetchError: " + m94Var.toString());
            o32 o32Var = this.d;
            if (o32Var != null) {
                o32Var.b(m94Var.a);
            }
        }
    }

    @Override // com.repackage.n84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            ux1.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.repackage.n84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            ux1.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.G();
            ux1.k("SwanAppBatchDownloadCallback", "onNoPackage");
            o32 o32Var = this.d;
            if (o32Var != null) {
                o32Var.d();
            }
        }
    }

    @Override // com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ae4Var) == null) {
            super.H(ae4Var);
            this.c = ae4Var;
            j92.e(ae4Var);
            ux1.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + ae4Var.n());
        }
    }

    @Override // com.repackage.y32
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean W(mb4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!he3.a(new File(aVar.d.a), aVar.d.m)) {
                ux1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            nc3 m = m42.m(aVar.d, this);
            if (m != null) {
                ux1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            m42.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(K());
            if (!p84.i().a(aVar.d, aVar.g)) {
                ux1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                m42.o(aVar.g);
            }
            m42.b(aVar.d);
            r94 r94Var = aVar.d;
            if (r94Var != null) {
                g13.c(qj2.e.i(r94Var.g, String.valueOf(r94Var.i)).getAbsolutePath(), true);
            }
            r94 r94Var2 = aVar.d;
            if (r94Var2 == null || r94Var2.h != 0 || ((c2 = mz1.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            j32 i2 = j32.i();
            r94 r94Var3 = aVar.d;
            i2.f(r94Var3.g, r94Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void X() {
        o32 o32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != n || this.g || (o32Var = this.d) == null) {
                return;
            }
            o32Var.a();
        }
    }

    public final void Y(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        od3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.repackage.n84, com.repackage.k84
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            ux1.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                od3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            o32 o32Var = this.d;
            if (o32Var != null) {
                o32Var.h();
            }
            if (k92.a()) {
                return;
            }
            ux1.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
            e92 d2 = g92.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
            pa2 l2 = pa2.l();
            l2.i(7);
            d2.t(copyOnWriteArraySet, false, l2.k());
        }
    }

    @Override // com.repackage.n84
    public j84<t94> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (j84) invokeV.objValue;
    }

    @Override // com.repackage.n84
    public f84<mb4.a> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (f84) invokeV.objValue;
    }

    public r32(o32 o32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o32Var};
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
        this.d = o32Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }
}
