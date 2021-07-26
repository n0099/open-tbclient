package d.a.o0.a.h0.m;

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
import d.a.o0.a.a1.e;
import d.a.o0.a.v2.j0;
import d.a.o0.a.v2.q;
import d.a.o0.n.i.l.a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.n.o.f f45457g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.a.h0.m.a f45458h;

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.o0.n.h.g> f45459i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public d.a.o0.n.f.a<a.C1155a> m;
    public d.a.o0.n.f.c<d.a.o0.n.h.g> n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f45460e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45460e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = d.a.o0.n.g.a.h().b(null, this.f45460e.f45459i, null, null, null);
                if (b2) {
                    for (d.a.o0.n.h.g gVar : this.f45460e.f45459i) {
                        if (this.f45460e.f45458h != null) {
                            this.f45460e.f45458h.f(gVar);
                        }
                        this.f45460e.W();
                    }
                }
                if (d.o) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + this.f45460e.f45459i);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.o0.n.f.a<a.C1155a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f45461e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1155a f45462e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f45463f;

            public a(b bVar, a.C1155a c1155a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, c1155a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45463f = bVar;
                this.f45462e = c1155a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f45463f.f45461e.V(this.f45462e)) {
                        this.f45463f.f45461e.W();
                        if (this.f45463f.f45461e.f45458h != null) {
                            this.f45463f.f45461e.f45458h.c(this.f45462e);
                        }
                        d.a.o0.a.h0.m.p.a.c(this.f45462e.f51214f.appId);
                    }
                    d.a.o0.a.n0.h.b.f(this.f45462e.f51210b);
                }
            }
        }

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45461e = dVar;
        }

        @Override // d.a.o0.n.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                d.a.o0.a.c2.f.g0.a.h(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // d.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f45461e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // d.a.o0.n.f.a
        public void o(a.C1155a c1155a, PMSAppInfo pMSAppInfo, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1155a, pMSAppInfo, aVar) == null) {
                d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f51130a + ",msg: " + aVar.f51131b);
                if (this.f45461e.f45458h != null) {
                    this.f45461e.f45458h.e(aVar);
                }
                if (aVar.f51130a != 1010) {
                    this.f45461e.k = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = c1155a == null ? null : c1155a.f51214f;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.f45461e.X(pMSAppInfo2, pMSAppInfo);
                if (!d.a.o0.a.h0.m.p.a.m(aVar) || pMSAppInfo2 == null) {
                    return;
                }
                d.a.o0.a.h0.m.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // d.a.o0.n.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    d.a.o0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.f45461e.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.c
        /* renamed from: q */
        public String d(a.C1155a c1155a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, c1155a)) == null) {
                if (c1155a == null) {
                    return null;
                }
                int i2 = c1155a.f51211c;
                if (i2 == 0) {
                    return d.a.o0.a.h0.m.r.a.g();
                }
                if (i2 == 1) {
                    return d.a.o0.a.h0.m.r.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: r */
        public void e(a.C1155a c1155a, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, c1155a, aVar) == null) {
                super.e(c1155a, aVar);
                d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
                d.a.o0.a.n0.h.b.f(c1155a.f51210b);
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f51130a);
                aVar2.c("批量下载，主包下载失败：" + c1155a.f51210b);
                aVar2.e(aVar.toString());
                if (c1155a.f51209a != 0) {
                    if (d.o) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                    }
                } else if (c1155a.f51212d == null) {
                } else {
                    this.f45461e.f45457g.j(c1155a.f51212d);
                    d.a.o0.a.h0.m.c.c().a(c1155a.f51212d, PMSDownloadType.BATCH, aVar2);
                    d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c1155a.f51212d.f51134a);
                    d.a.o0.t.d.j(c1155a.f51212d.f51134a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: s */
        public void i(a.C1155a c1155a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, c1155a) == null) {
                super.i(c1155a);
                d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1155a.f51212d.f51142i);
                this.f45461e.l.add(c1155a.f51210b);
                a aVar = new a(this, c1155a);
                String str = c1155a.f51212d.f51140g + " 下载完成，执行签名校验-重命名-解压-DB";
                if (d.p) {
                    ExecutorUtilsExt.postOnSerial(aVar, str);
                } else {
                    q.j(aVar, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: t */
        public void a(a.C1155a c1155a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, c1155a) == null) {
                super.a(c1155a);
                if (d.o) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1155a.f51212d.f51135b + "/" + c1155a.f51212d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: u */
        public void c(a.C1155a c1155a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, c1155a) == null) {
                super.c(c1155a);
                d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1155a.f51210b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: v */
        public void f(a.C1155a c1155a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, c1155a) == null) {
                if (d.o) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1155a.f51210b);
                }
                d.a.o0.a.n0.h.b.f(c1155a.f51210b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f45464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f45465f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f45466g;

        public c(d dVar, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45466g = dVar;
            this.f45464e = pMSAppInfo;
            this.f45465f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.f45464e;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f45466g.I());
                    this.f45465f.copyLocalAppInfoData(this.f45464e);
                } else {
                    this.f45465f.updateInstallSrc(this.f45466g.I());
                }
                this.f45465f.initMaxAgeInfo();
                if (d.a.o0.n.g.a.h().k(this.f45465f)) {
                    d.a.o0.a.h0.m.r.a.n(this.f45465f);
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0754d extends k<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f45467g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0754d(d dVar, d dVar2) {
            super(dVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45467g = dVar;
        }

        @Override // d.a.o0.a.h0.m.k
        public void p(@NonNull d.a.o0.n.h.g gVar, @Nullable d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                if (aVar == null) {
                    this.f45467g.f45459i.add(gVar);
                } else if (d.o) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
                }
                d.a.o0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: q */
        public void e(d.a.o0.n.h.g gVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                d.a.o0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: u */
        public void f(d.a.o0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
                super.f(gVar);
                d.a.o0.a.n0.h.b.f(gVar.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447430601, "Ld/a/o0/a/h0/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447430601, "Ld/a/o0/a/h0/m/d;");
                return;
            }
        }
        o = d.a.o0.a.k.f46335a;
        d.a.o0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_task_serial", false);
        p = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((d.a.o0.a.h0.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.n.f.g
    public void B(d.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
            d.a.o0.a.h0.m.a aVar2 = this.f45458h;
            if (aVar2 != null) {
                aVar2.b(aVar.f51130a);
            }
        }
    }

    @Override // d.a.o0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C();
            d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // d.a.o0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // d.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onNoPackage");
            d.a.o0.a.h0.m.a aVar = this.f45458h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // d.a.o0.n.f.g
    public void F(d.a.o0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            super.F(fVar);
            this.f45457g = fVar;
            d.a.o0.a.n0.h.b.e(fVar);
            d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
        }
    }

    @Override // d.a.o0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(a.C1155a c1155a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c1155a)) == null) {
            if (c1155a == null || c1155a.f51212d == null || c1155a.f51214f == null) {
                return false;
            }
            if (!j0.a(new File(c1155a.f51212d.f51134a), c1155a.f51212d.m)) {
                d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            d.a.o0.a.q2.a l = d.a.o0.a.h0.m.r.a.l(c1155a.f51212d, this);
            if (l != null) {
                d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
                return false;
            }
            c1155a.f51214f.initMaxAgeInfo();
            d.a.o0.a.h0.m.r.a.j(c1155a.f51214f, c1155a.f51212d);
            c1155a.f51214f.updateInstallSrc(I());
            if (!d.a.o0.n.g.a.h().a(c1155a.f51212d, c1155a.f51214f)) {
                d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f45457g.k(c1155a.f51212d);
            if (!c1155a.f51215g) {
                d.a.o0.a.h0.m.r.a.n(c1155a.f51214f);
            }
            d.a.o0.a.h0.m.r.a.b(c1155a.f51212d);
            d.a.o0.n.h.f fVar = c1155a.f51212d;
            if (fVar != null) {
                d.a.o0.a.a2.n.d.c(e.C0638e.i(fVar.f51140g, String.valueOf(fVar.f51142i)).getAbsolutePath(), true);
            }
            d.a.o0.n.h.f fVar2 = c1155a.f51212d;
            if (fVar2 != null && fVar2.f51141h == 0) {
                d.a.o0.a.h0.l.g.n.a i2 = d.a.o0.a.h0.l.g.n.a.i();
                d.a.o0.n.h.f fVar3 = c1155a.f51212d;
                i2.f(fVar3.f51140g, fVar3.f51142i);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        d.a.o0.a.h0.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int incrementAndGet = this.j.incrementAndGet();
            int l = this.f45457g.l();
            if (o) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + l + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != l || this.k || (aVar = this.f45458h) == null) {
                return;
            }
            aVar.a();
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        q.j(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // d.a.o0.n.f.g, d.a.o0.n.f.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.b();
            d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (o) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.f45459i.isEmpty()) {
                q.j(new a(this), "SwanAppBatchDownloadCallback");
            }
            d.a.o0.a.h0.m.a aVar = this.f45458h;
            if (aVar != null) {
                aVar.g();
            }
            if (d.a.o0.a.n0.h.c.a()) {
                return;
            }
            d.a.o0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
            d.a.o0.a.n0.d d2 = d.a.o0.a.n0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
            d.a.o0.a.n0.l.c l = d.a.o0.a.n0.l.c.l();
            l.i(7);
            d2.t(copyOnWriteArraySet, false, l.k());
        }
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.a<a.C1155a> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (d.a.o0.n.f.a) invokeV.objValue;
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.c<d.a.o0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (d.a.o0.n.f.c) invokeV.objValue;
    }

    public d(d.a.o0.a.h0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = new b(this);
        this.n = new C0754d(this, this);
        this.f45458h = aVar;
        this.f45459i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
