package d.a.n0.a.h0.m;

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
import d.a.n0.a.a1.e;
import d.a.n0.a.v2.j0;
import d.a.n0.a.v2.q;
import d.a.n0.n.i.l.a;
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
    public d.a.n0.n.o.f f44953g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.a.h0.m.a f44954h;

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.n0.n.h.g> f44955i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public d.a.n0.n.f.a<a.C1146a> m;
    public d.a.n0.n.f.c<d.a.n0.n.h.g> n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f44956e;

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
            this.f44956e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b2 = d.a.n0.n.g.a.h().b(null, this.f44956e.f44955i, null, null, null);
                if (b2) {
                    for (d.a.n0.n.h.g gVar : this.f44956e.f44955i) {
                        if (this.f44956e.f44954h != null) {
                            this.f44956e.f44954h.f(gVar);
                        }
                        this.f44956e.W();
                    }
                }
                if (d.o) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + this.f44956e.f44955i);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.n0.n.f.a<a.C1146a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f44957e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1146a f44958e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f44959f;

            public a(b bVar, a.C1146a c1146a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, c1146a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44959f = bVar;
                this.f44958e = c1146a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f44959f.f44957e.V(this.f44958e)) {
                        this.f44959f.f44957e.W();
                        if (this.f44959f.f44957e.f44954h != null) {
                            this.f44959f.f44957e.f44954h.c(this.f44958e);
                        }
                        d.a.n0.a.h0.m.p.a.c(this.f44958e.f50710f.appId);
                    }
                    d.a.n0.a.n0.h.b.f(this.f44958e.f50706b);
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
            this.f44957e = dVar;
        }

        @Override // d.a.n0.n.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                d.a.n0.a.c2.f.g0.a.h(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // d.a.n0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f44957e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // d.a.n0.n.f.a
        public void o(a.C1146a c1146a, PMSAppInfo pMSAppInfo, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1146a, pMSAppInfo, aVar) == null) {
                d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f50626a + ",msg: " + aVar.f50627b);
                if (this.f44957e.f44954h != null) {
                    this.f44957e.f44954h.e(aVar);
                }
                if (aVar.f50626a != 1010) {
                    this.f44957e.k = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = c1146a == null ? null : c1146a.f50710f;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.f44957e.X(pMSAppInfo2, pMSAppInfo);
                if (!d.a.n0.a.h0.m.p.a.m(aVar) || pMSAppInfo2 == null) {
                    return;
                }
                d.a.n0.a.h0.m.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // d.a.n0.n.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    d.a.n0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.f44957e.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.c
        /* renamed from: q */
        public String d(a.C1146a c1146a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, c1146a)) == null) {
                if (c1146a == null) {
                    return null;
                }
                int i2 = c1146a.f50707c;
                if (i2 == 0) {
                    return d.a.n0.a.h0.m.r.a.g();
                }
                if (i2 == 1) {
                    return d.a.n0.a.h0.m.r.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: r */
        public void e(a.C1146a c1146a, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, c1146a, aVar) == null) {
                super.e(c1146a, aVar);
                d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
                d.a.n0.a.n0.h.b.f(c1146a.f50706b);
                d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f50626a);
                aVar2.c("批量下载，主包下载失败：" + c1146a.f50706b);
                aVar2.e(aVar.toString());
                if (c1146a.f50705a != 0) {
                    if (d.o) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                    }
                } else if (c1146a.f50708d == null) {
                } else {
                    this.f44957e.f44953g.j(c1146a.f50708d);
                    d.a.n0.a.h0.m.c.c().a(c1146a.f50708d, PMSDownloadType.BATCH, aVar2);
                    d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c1146a.f50708d.f50630a);
                    d.a.n0.t.d.j(c1146a.f50708d.f50630a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: s */
        public void i(a.C1146a c1146a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, c1146a) == null) {
                super.i(c1146a);
                d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1146a.f50708d.f50638i);
                this.f44957e.l.add(c1146a.f50706b);
                a aVar = new a(this, c1146a);
                String str = c1146a.f50708d.f50636g + " 下载完成，执行签名校验-重命名-解压-DB";
                if (d.p) {
                    ExecutorUtilsExt.postOnSerial(aVar, str);
                } else {
                    q.j(aVar, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: t */
        public void a(a.C1146a c1146a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, c1146a) == null) {
                super.a(c1146a);
                if (d.o) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1146a.f50708d.f50631b + "/" + c1146a.f50708d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: u */
        public void c(a.C1146a c1146a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, c1146a) == null) {
                super.c(c1146a);
                d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1146a.f50706b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: v */
        public void f(a.C1146a c1146a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, c1146a) == null) {
                if (d.o) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1146a.f50706b);
                }
                d.a.n0.a.n0.h.b.f(c1146a.f50706b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f44962g;

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
            this.f44962g = dVar;
            this.f44960e = pMSAppInfo;
            this.f44961f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.f44960e;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.f44962g.I());
                    this.f44961f.copyLocalAppInfoData(this.f44960e);
                } else {
                    this.f44961f.updateInstallSrc(this.f44962g.I());
                }
                this.f44961f.initMaxAgeInfo();
                if (d.a.n0.n.g.a.h().k(this.f44961f)) {
                    d.a.n0.a.h0.m.r.a.n(this.f44961f);
                }
            }
        }
    }

    /* renamed from: d.a.n0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0745d extends k<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f44963g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0745d(d dVar, d dVar2) {
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
            this.f44963g = dVar;
        }

        @Override // d.a.n0.a.h0.m.k
        public void p(@NonNull d.a.n0.n.h.g gVar, @Nullable d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                if (aVar == null) {
                    this.f44963g.f44955i.add(gVar);
                } else if (d.o) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
                }
                d.a.n0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: q */
        public void e(d.a.n0.n.h.g gVar, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                d.a.n0.a.n0.h.b.f(gVar.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: u */
        public void f(d.a.n0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
                super.f(gVar);
                d.a.n0.a.n0.h.b.f(gVar.o);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318347882, "Ld/a/n0/a/h0/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318347882, "Ld/a/n0/a/h0/m/d;");
                return;
            }
        }
        o = d.a.n0.a.k.f45831a;
        d.a.n0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_task_serial", false);
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
                this((d.a.n0.a.h0.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.n0.n.f.g
    public void B(d.a.n0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
            d.a.n0.a.h0.m.a aVar2 = this.f44954h;
            if (aVar2 != null) {
                aVar2.b(aVar.f50626a);
            }
        }
    }

    @Override // d.a.n0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C();
            d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // d.a.n0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // d.a.n0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onNoPackage");
            d.a.n0.a.h0.m.a aVar = this.f44954h;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // d.a.n0.n.f.g
    public void F(d.a.n0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            super.F(fVar);
            this.f44953g = fVar;
            d.a.n0.a.n0.h.b.e(fVar);
            d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
        }
    }

    @Override // d.a.n0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(a.C1146a c1146a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c1146a)) == null) {
            if (c1146a == null || c1146a.f50708d == null || c1146a.f50710f == null) {
                return false;
            }
            if (!j0.a(new File(c1146a.f50708d.f50630a), c1146a.f50708d.m)) {
                d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            d.a.n0.a.q2.a l = d.a.n0.a.h0.m.r.a.l(c1146a.f50708d, this);
            if (l != null) {
                d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
                return false;
            }
            c1146a.f50710f.initMaxAgeInfo();
            d.a.n0.a.h0.m.r.a.j(c1146a.f50710f, c1146a.f50708d);
            c1146a.f50710f.updateInstallSrc(I());
            if (!d.a.n0.n.g.a.h().a(c1146a.f50708d, c1146a.f50710f)) {
                d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.f44953g.k(c1146a.f50708d);
            if (!c1146a.f50711g) {
                d.a.n0.a.h0.m.r.a.n(c1146a.f50710f);
            }
            d.a.n0.a.h0.m.r.a.b(c1146a.f50708d);
            d.a.n0.n.h.f fVar = c1146a.f50708d;
            if (fVar != null) {
                d.a.n0.a.a2.n.d.c(e.C0629e.i(fVar.f50636g, String.valueOf(fVar.f50638i)).getAbsolutePath(), true);
            }
            d.a.n0.n.h.f fVar2 = c1146a.f50708d;
            if (fVar2 != null && fVar2.f50637h == 0) {
                d.a.n0.a.h0.l.g.n.a i2 = d.a.n0.a.h0.l.g.n.a.i();
                d.a.n0.n.h.f fVar3 = c1146a.f50708d;
                i2.f(fVar3.f50636g, fVar3.f50638i);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        d.a.n0.a.h0.m.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int incrementAndGet = this.j.incrementAndGet();
            int l = this.f44953g.l();
            if (o) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + l + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != l || this.k || (aVar = this.f44954h) == null) {
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

    @Override // d.a.n0.n.f.g, d.a.n0.n.f.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.b();
            d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (o) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.f44955i.isEmpty()) {
                q.j(new a(this), "SwanAppBatchDownloadCallback");
            }
            d.a.n0.a.h0.m.a aVar = this.f44954h;
            if (aVar != null) {
                aVar.g();
            }
            if (d.a.n0.a.n0.h.c.a()) {
                return;
            }
            d.a.n0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
            d.a.n0.a.n0.d d2 = d.a.n0.a.n0.f.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
            d.a.n0.a.n0.l.c l = d.a.n0.a.n0.l.c.l();
            l.i(7);
            d2.t(copyOnWriteArraySet, false, l.k());
        }
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.a<a.C1146a> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (d.a.n0.n.f.a) invokeV.objValue;
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.c<d.a.n0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (d.a.n0.n.f.c) invokeV.objValue;
    }

    public d(d.a.n0.a.h0.m.a aVar) {
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
        this.n = new C0745d(this, this);
        this.f44954h = aVar;
        this.f44955i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
