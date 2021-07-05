package d.a.q0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.i;
import d.a.q0.a.h0.m.c;
import d.a.q0.a.m2.f.a;
import d.a.q0.a.v2.y0;
import h.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class f extends d.a.q0.a.h0.m.j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.n.f.c<d.a.q0.n.h.d> A;
    public d.a.q0.n.f.c<d.a.q0.n.h.b> B;
    public d.a.q0.n.f.f C;
    public h.j<d.a.q0.n.h.e> D;

    /* renamed from: g  reason: collision with root package name */
    public String f48266g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.q0.n.h.f> f48267h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super d.a.q0.n.h.g> f48268i;
    public h.j<? super d.a.q0.n.h.d> j;
    public h.j<? super d.a.q0.n.h.b> k;
    public d.a.q0.n.o.f l;
    public d.a.q0.n.h.f m;
    public List<d.a.q0.n.h.g> n;
    public d.a.q0.n.h.d o;
    public d.a.q0.n.h.b p;
    public PMSAppInfo q;
    public String r;
    public List<UbcFlowEvent> s;
    public d.a.q0.n.h.g t;
    public long u;
    public final Set<d.a.q0.a.h0.m.m.a> v;
    public final Set<d.a.q0.a.v2.e1.b<PMSAppInfo>> w;
    public final y0 x;
    public d.a.q0.n.f.c<d.a.q0.n.h.f> y;
    public d.a.q0.n.f.c<d.a.q0.n.h.g> z;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.n.f.b<d.a.q0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48269e;

        /* renamed from: d.a.q0.a.h0.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0797a implements d.a.q0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f48270e;

            public C0797a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48270e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f46689f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    d.a.q0.n.f.h.a(this.f48270e.f48269e, bundle, "event_performance_ubc");
                }
            }
        }

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48269e = fVar;
        }

        @Override // d.a.q0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48269e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.c
        /* renamed from: l */
        public String d(d.a.q0.n.h.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
                int i2 = fVar.f53939h;
                if (i2 == 0) {
                    return d.a.q0.a.h0.m.r.a.g();
                }
                if (i2 == 1) {
                    return d.a.q0.a.h0.m.r.a.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.q0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.f48269e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: o */
        public void e(d.a.q0.n.h.f fVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, fVar, aVar) == null) {
                super.e(fVar, aVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
                this.f48269e.l.j(fVar);
                d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f53928a);
                aVar2.c("主包下载失败");
                aVar2.e(aVar.toString());
                if (this.f48269e.f48267h != null) {
                    this.f48269e.f48267h.onError(new PkgDownloadError(fVar, aVar2));
                }
                d.a.q0.a.h0.m.c.c().a(fVar, this.f48269e.h0(), aVar2);
                d.a.q0.t.d.j(fVar.f53932a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: p */
        public void i(d.a.q0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
                String i0 = this.f48269e.i0();
                if (f.E) {
                    d.a.q0.a.f1.g.a.d(i0).e().d(1);
                }
                super.i(fVar);
                this.f48269e.s.add(new UbcFlowEvent("na_pms_end_download"));
                d.a.q0.a.q2.a w0 = this.f48269e.w0(fVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f53940i);
                if (w0 == null) {
                    f fVar2 = this.f48269e;
                    fVar2.m = fVar;
                    fVar2.l.k(fVar);
                    if (this.f48269e.f48267h != null) {
                        this.f48269e.f48267h.onNext(fVar);
                        if (f.E) {
                            Log.d("SwanAppPkgDownloadCallback", this.f48269e.f0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.f48269e.f48267h.onCompleted();
                    }
                    d.a.q0.a.h0.m.c.c().b(fVar, this.f48269e.h0());
                    return;
                }
                this.f48269e.l.j(fVar);
                if (this.f48269e.f48267h != null) {
                    this.f48269e.f48267h.onError(new PkgDownloadError(fVar, w0));
                }
                d.a.q0.a.h0.m.c.c().a(fVar, this.f48269e.h0(), w0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void c(d.a.q0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
                String i0 = this.f48269e.i0();
                if (f.E) {
                    d.a.q0.a.f1.g.a.d(i0).e().d(1);
                }
                super.c(fVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: r */
        public void f(d.a.q0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
                String i0 = this.f48269e.i0();
                if (f.E) {
                    d.a.q0.a.f1.g.a.d(i0).e().d(1);
                }
                super.f(fVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f48269e.f0() + ": main onDownloading");
                }
                this.f48269e.A0(fVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: s */
        public d.a.q0.n.h.a h(d.a.q0.n.h.f fVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fVar, file, Long.valueOf(j), readableByteChannel})) == null) {
                String i0 = this.f48269e.i0();
                if (f.E) {
                    d.a.q0.a.f1.g.a.d(i0).f(fVar.toString()).d(1);
                }
                C0797a c0797a = new C0797a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                d.a.q0.a.a1.g gVar = new d.a.q0.a.a1.g();
                gVar.v(c0797a);
                gVar.g(bundle);
                gVar.f(new d.a.q0.a.a1.f(fVar, this.f48269e));
                gVar.f(new d.a.q0.a.a1.d(fVar.m, this.f48269e));
                gVar.i(readableByteChannel);
                boolean j2 = gVar.j();
                gVar.p(c0797a);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f48269e.f0() + ": onProcessStream: installOk=" + j2);
                }
                if (j2) {
                    d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    d.a.q0.t.d.K(file);
                }
                return j2 ? new d.a.q0.n.h.a(2300, "业务层处理下载流成功") : new d.a.q0.n.h.a(2301, "业务层处理下载流失败");
            }
            return (d.a.q0.n.h.a) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<d.a.q0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f48271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f48272f;

        public b(f fVar, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48272f = fVar;
            this.f48271e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48271e.onCallback(aVar);
                f fVar = this.f48272f;
                fVar.e0(fVar.v, aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.v2.e1.b<d.a.q0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.q2.a f48273e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48274f;

        public c(f fVar, d.a.q0.a.q2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48273e = aVar;
            this.f48274f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.f48273e, this.f48274f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.a.v2.e1.b<d.a.q0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f48275e;

        public d(f fVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48275e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.f48275e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements c.InterfaceC0795c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n.h.f f48276a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f48277b;

        public e(f fVar, d.a.q0.n.h.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48277b = fVar;
            this.f48276a = fVar2;
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f48277b;
                d.a.q0.n.h.f fVar2 = this.f48276a;
                fVar.m = fVar2;
                fVar.l.k(fVar2);
                if (this.f48277b.f48267h != null) {
                    this.f48277b.f48267h.onNext(this.f48276a);
                    this.f48277b.f48267h.onCompleted();
                }
            }
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void b(PMSDownloadType pMSDownloadType, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f48277b.l.j(this.f48276a);
                if (this.f48277b.f48267h != null) {
                    this.f48277b.f48267h.onError(new PkgDownloadError(this.f48276a, aVar));
                }
            }
        }
    }

    /* renamed from: d.a.q0.a.h0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0798f implements c.InterfaceC0795c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n.h.g f48278a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f48279b;

        public C0798f(f fVar, d.a.q0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48279b = fVar;
            this.f48278a = gVar;
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f48279b;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                d.a.q0.n.h.g gVar = this.f48278a;
                f fVar2 = this.f48279b;
                gVar.o = fVar2.r;
                fVar2.n.add(gVar);
                this.f48279b.l.k(this.f48278a);
                if (this.f48279b.f48268i != null) {
                    this.f48279b.f48268i.onNext(this.f48278a);
                    if (this.f48279b.l.g()) {
                        return;
                    }
                    this.f48279b.f48268i.onCompleted();
                }
            }
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void b(PMSDownloadType pMSDownloadType, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f48279b.l.j(this.f48278a);
                if (this.f48279b.f48268i != null) {
                    this.f48279b.f48268i.onError(new PkgDownloadError(this.f48278a, aVar));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements c.InterfaceC0795c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n.h.d f48280a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f48281b;

        public g(f fVar, d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48281b = fVar;
            this.f48280a = dVar;
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f48281b;
                d.a.q0.n.h.d dVar = this.f48280a;
                fVar.o = dVar;
                fVar.l.k(dVar);
                if (this.f48281b.j != null) {
                    this.f48281b.j.onNext(this.f48280a);
                    this.f48281b.j.onCompleted();
                }
            }
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void b(PMSDownloadType pMSDownloadType, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f48281b.l.j(this.f48280a);
                if (this.f48281b.j != null) {
                    this.f48281b.j.onError(new PkgDownloadError(this.f48280a, aVar));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements c.InterfaceC0795c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n.h.b f48282a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f48283b;

        public h(f fVar, d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48283b = fVar;
            this.f48282a = bVar;
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f fVar = this.f48283b;
                d.a.q0.n.h.b bVar = this.f48282a;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f48283b.n0(this.f48282a);
            }
        }

        @Override // d.a.q0.a.h0.m.c.InterfaceC0795c
        public void b(PMSDownloadType pMSDownloadType, d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f48283b.l.j(this.f48282a);
                this.f48283b.n0(this.f48282a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends h.j<d.a.q0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48284e;

        public i(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48284e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.q0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f48284e.h0() + " : 单个包下载、业务层处理完成：" + eVar.f53940i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f48284e.h0() + " : 包下载onCompleted");
                this.f48284e.s0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                d.a.q0.a.e0.d.i("SwanAppPkgDownloadCallback", this.f48284e.h0() + " : 包下载OnError", th);
                this.f48284e.t0(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements d.a<d.a.q0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48285e;

        public j(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48285e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.q0.n.h.f> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f48285e.f48267h = jVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements d.a<d.a.q0.n.h.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48286e;

        public k(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48286e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.q0.n.h.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f48286e.f48268i = jVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements d.a<d.a.q0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48287e;

        public l(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48287e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.q0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f48287e.j = jVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements d.a<d.a.q0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48288e;

        public m(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48288e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.q0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f48288e.k = jVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends d.a.q0.a.h0.m.k<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f48289g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(f fVar, f fVar2) {
            super(fVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d.a.q0.a.h0.m.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48289g = fVar;
        }

        @Override // d.a.q0.a.h0.m.k, d.a.q0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48289g.g0() : invokeV.intValue;
        }

        @Override // d.a.q0.a.h0.m.k
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48289g.r : (String) invokeV.objValue;
        }

        @Override // d.a.q0.a.h0.m.k
        public void p(@NonNull d.a.q0.n.h.g gVar, @Nullable d.a.q0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f53940i);
                f fVar = this.f48289g;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                f fVar2 = this.f48289g;
                gVar.o = fVar2.r;
                if (aVar == null) {
                    fVar2.n.add(gVar);
                    this.f48289g.l.k(gVar);
                    d.a.q0.a.h0.m.c.c().b(gVar, this.f48289g.h0());
                } else {
                    fVar2.l.j(gVar);
                    d.a.q0.a.h0.m.c.c().a(gVar, this.f48289g.h0(), aVar);
                }
                if (this.f48289g.f48268i != null) {
                    this.f48289g.f48268i.onNext(gVar);
                    if (this.f48289g.l.g()) {
                        return;
                    }
                    this.f48289g.f48268i.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void e(d.a.q0.n.h.g gVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
                this.f48289g.l.j(gVar);
                d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f53928a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                if (this.f48289g.f48268i != null) {
                    this.f48289g.f48268i.onError(new PkgDownloadError(gVar, aVar2));
                }
                d.a.q0.a.h0.m.c.c().a(gVar, this.f48289g.h0(), aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.h0.m.k, d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: s */
        public void c(d.a.q0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
                super.c(gVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: u */
        public void f(d.a.q0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.f(gVar);
                this.f48289g.B0(gVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends d.a.q0.n.f.b<d.a.q0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48290e;

        public o(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48290e = fVar;
        }

        @Override // d.a.q0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48290e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.c
        /* renamed from: l */
        public String d(d.a.q0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
                int i2 = dVar.f53939h;
                if (i2 == 0) {
                    return d.a.q0.a.h0.m.r.a.h();
                }
                if (i2 == 1) {
                    return d.a.q0.a.h0.m.r.a.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.q0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f48290e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: o */
        public void e(d.a.q0.n.h.d dVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
                this.f48290e.l.j(dVar);
                d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f53928a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f48290e.j != null) {
                    this.f48290e.j.onError(new PkgDownloadError(dVar, aVar2));
                }
                d.a.q0.a.h0.m.c.c().a(dVar, this.f48290e.h0(), aVar2);
                d.a.q0.t.d.j(dVar.f53932a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: p */
        public void i(d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.i(dVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f53940i);
                d.a.q0.a.q2.a v0 = this.f48290e.v0(dVar);
                if (v0 == null) {
                    f fVar = this.f48290e;
                    fVar.o = dVar;
                    fVar.l.k(dVar);
                    if (this.f48290e.j != null) {
                        this.f48290e.j.onNext(dVar);
                        this.f48290e.j.onCompleted();
                    }
                    d.a.q0.a.h0.m.c.c().b(dVar, this.f48290e.h0());
                    return;
                }
                this.f48290e.l.j(dVar);
                if (this.f48290e.j != null) {
                    this.f48290e.j.onError(new PkgDownloadError(dVar, v0));
                }
                d.a.q0.a.h0.m.c.c().a(dVar, this.f48290e.h0(), v0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void c(d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.c(dVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: r */
        public void f(d.a.q0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
                super.f(dVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f48290e.f0() + ": framework onDownloading");
                }
                this.f48290e.z0(dVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends d.a.q0.n.f.b<d.a.q0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48291e;

        public p(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48291e = fVar;
        }

        @Override // d.a.q0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48291e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.c
        /* renamed from: l */
        public String d(d.a.q0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                int i2 = bVar.f53939h;
                if (i2 == 0) {
                    return d.a.q0.a.h0.m.r.a.d();
                }
                if (i2 == 1) {
                    return d.a.q0.a.h0.m.r.a.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.q0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f48291e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: o */
        public void e(d.a.q0.n.h.b bVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
                this.f48291e.l.j(bVar);
                d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f53928a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
                }
                this.f48291e.n0(bVar);
                d.a.q0.a.h0.m.c.c().a(bVar, this.f48291e.h0(), aVar2);
                d.a.q0.t.d.j(bVar.f53932a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: p */
        public void i(d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.i(bVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f53940i);
                d.a.q0.a.q2.a u0 = this.f48291e.u0(bVar);
                if (u0 != null) {
                    if (f.E) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                    }
                    this.f48291e.l.j(bVar);
                    this.f48291e.n0(bVar);
                    d.a.q0.a.h0.m.c.c().a(bVar, this.f48291e.h0(), u0);
                    return;
                }
                f fVar = this.f48291e;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f48291e.n0(bVar);
                d.a.q0.a.h0.m.c.c().b(bVar, this.f48291e.h0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void c(d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.c(bVar);
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: r */
        public void f(d.a.q0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
                super.f(bVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f48291e.f0() + ": extension onDownloading");
                }
                this.f48291e.y0(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements d.a.q0.n.f.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f48292a;

        public q(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48292a = fVar;
        }

        @Override // d.a.q0.n.f.f
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", this.f48292a.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                f fVar = this.f48292a;
                fVar.q = pMSAppInfo;
                if (pMSAppInfo != null) {
                    fVar.l0(pMSAppInfo);
                    d.a.q0.a.t1.g.b.k(this.f48292a.q.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements d.a.q0.a.v2.e1.b<d.a.q0.a.v2.e1.b<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f48293e;

        public r(f fVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48293e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.v2.e1.b<PMSAppInfo> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                bVar.onCallback(this.f48293e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f48294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f48295f;

        public s(f fVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48294e = collection;
            this.f48295f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48294e.add(this.f48295f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f48296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f48297f;

        public t(f fVar, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48296e = collection;
            this.f48297f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48296e.remove(this.f48297f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f48298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f48299f;

        public u(f fVar, Collection collection, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, collection, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48298e = collection;
            this.f48299f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.f48298e) {
                    this.f48299f.onCallback(obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705596101, "Ld/a/q0/a/h0/m/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705596101, "Ld/a/q0/a/h0/m/f;");
                return;
            }
        }
        E = d.a.q0.a.k.f49133a;
    }

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48266g = "";
        this.u = -1L;
        this.v = new HashSet();
        this.w = new HashSet();
        this.x = new y0();
        this.y = new a(this);
        this.z = new n(this, this);
        this.A = new o(this);
        this.B = new p(this);
        this.C = new q(this);
        this.D = new i(this);
        this.r = str;
        this.s = new ArrayList();
    }

    public final void A0(d.a.q0.n.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            d.a.q0.a.h0.m.c.c().d(fVar, new e(this, fVar));
        }
    }

    @Override // d.a.q0.n.f.g
    public void B(d.a.q0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
            if (aVar != null && aVar.f53928a == 1010) {
                D0();
            }
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void B0(d.a.q0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            d.a.q0.a.h0.m.c.c().d(gVar, new C0798f(this, gVar));
        }
    }

    @Override // d.a.q0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public d.a.q0.a.q2.a C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo == null) {
                if (this.m == null) {
                    d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
                    aVar.j(10L);
                    aVar.h(2903L);
                    aVar.c("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo s2 = d.a.q0.n.g.a.h().s(this.r);
                if (s2 == null) {
                    d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
                    aVar2.j(10L);
                    aVar2.h(2904L);
                    aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.q = s2;
                d.a.q0.a.h0.m.r.a.j(s2, this.m);
                this.q.initMaxAgeInfo();
                this.q.updateInstallSrc(I());
                if (d.a.q0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                    return null;
                }
                d.a.q0.a.q2.a aVar3 = new d.a.q0.a.q2.a();
                aVar3.j(10L);
                aVar3.h(2906L);
                aVar3.c("更新DB失败");
                return aVar3;
            }
            d.a.q0.n.h.f fVar = this.m;
            if (fVar != null) {
                d.a.q0.a.h0.m.r.a.j(pMSAppInfo, fVar);
            } else if (d.a.q0.a.h0.m.r.b.f(this.n)) {
                d.a.q0.n.h.g gVar = this.n.get(0);
                this.t = gVar;
                gVar.o = this.r;
                d.a.q0.a.h0.m.r.a.k(this.q, gVar);
            } else {
                PMSAppInfo s3 = d.a.q0.n.g.a.h().s(this.r);
                if (s3 == null) {
                    d.a.q0.a.q2.a aVar4 = new d.a.q0.a.q2.a();
                    aVar4.j(10L);
                    aVar4.h(2905L);
                    aVar4.c("Server未返回包数据，本地也没有数据");
                    return aVar4;
                }
                PMSAppInfo pMSAppInfo2 = this.q;
                pMSAppInfo2.appId = this.r;
                pMSAppInfo2.copyLocalAppInfoData(s3);
            }
            this.q.initMaxAgeInfo();
            this.q.updateInstallSrc(I());
            if (d.a.q0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                d.a.q0.a.h0.m.r.a.n(this.q);
                return null;
            }
            d.a.q0.a.q2.a aVar5 = new d.a.q0.a.q2.a();
            aVar5.j(10L);
            aVar5.h(2906L);
            aVar5.c("更新DB失败");
            return aVar5;
        }
        return (d.a.q0.a.q2.a) invokeV.objValue;
    }

    @Override // d.a.q0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PMSAppInfo s2 = d.a.q0.n.g.a.h().s(this.r);
            d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + s2.createTime + " lastLaunchTime=" + s2.getLastLaunchTime() + " maxAge=" + s2.maxAge);
            if (s2 != null) {
                s2.initMaxAgeInfo();
                s2.updateInstallSrc(I());
                d.a.q0.n.h.f fVar = this.m;
                if (fVar != null) {
                    fVar.f53934c = s2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.q;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = s2.createTime;
                    pMSAppInfo.updateInstallSrc(I());
                }
                d.a.q0.n.g.a.h().k(s2);
            }
        }
    }

    @Override // d.a.q0.n.f.g
    public void F(d.a.q0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            super.F(fVar);
            this.u = System.currentTimeMillis();
            if (E) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.u);
            }
            if (fVar == null) {
                return;
            }
            if (E) {
                Log.i("SwanAppPkgDownloadCallback", f0() + ": onPrepareDownload: countSet=" + fVar.l());
            }
            this.s.add(new UbcFlowEvent("na_pms_start_download"));
            this.l = fVar;
            if (fVar.i()) {
                return;
            }
            k0();
        }
    }

    public f b0(d.a.q0.a.v2.e1.b<PMSAppInfo> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            c0(this.w, bVar);
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final synchronized <CallbackT> f c0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.x.a(new s(this, collection, callbackt));
                }
            }
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public synchronized f d0(d.a.q0.a.h0.m.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
            synchronized (this) {
                c0(this.v, aVar);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final synchronized <CallbackT> f e0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.x.a(new t(this, collection, callbackt));
                }
            }
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (TextUtils.isEmpty(this.f48266g)) {
                this.f48266g = getClass().toString();
            }
            return this.f48266g;
        }
        return (String) invokeV.objValue;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType h0();

    public final String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? d.a.q0.n.f.h.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 1013) {
                d.a.q0.n.g.a.h().x(this.r, i2);
            } else {
                d.a.q0.n.g.a.h().x(this.r, 0);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.l.d()) {
                arrayList.add(h.d.b(new j(this)));
            }
            if (this.l.f()) {
                arrayList.add(h.d.b(new k(this)));
            }
            if (this.l.c()) {
                arrayList.add(h.d.b(new l(this)));
            }
            if (this.l.b()) {
                arrayList.add(h.d.b(new m(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            h.d.l(arrayList).z(this.D);
        }
    }

    public f l0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            m0(this.w, new r(this, pMSAppInfo));
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull d.a.q0.a.v2.e1.b<CallbackT> bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, collection, bVar)) == null) {
            synchronized (this) {
                this.x.a(new u(this, collection, bVar));
            }
            return this;
        }
        return (f) invokeLL.objValue;
    }

    public final void n0(d.a.q0.n.h.b bVar) {
        h.j<? super d.a.q0.n.h.b> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.onNext(bVar);
        this.k.onCompleted();
    }

    public f o0(@NonNull d.a.q0.a.v2.e1.b<d.a.q0.a.h0.m.m.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            m0(this.v, new b(this, bVar));
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.f p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C : (d.a.q0.n.f.f) invokeV.objValue;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pMSAppInfo) == null) {
            o0(new d(this, pMSAppInfo));
        }
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.c<d.a.q0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.B : (d.a.q0.n.f.c) invokeV.objValue;
    }

    public void q0(d.a.q0.a.q2.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, aVar, z) == null) {
            o0(new c(this, aVar, z));
        }
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.c<d.a.q0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.A : (d.a.q0.n.f.c) invokeV.objValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.q == null) {
            return;
        }
        PMSAppInfo s2 = d.a.q0.n.g.a.h().s(this.r);
        if (s2 == null) {
            d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        s2.updateInstallSrc(I());
        this.q.copyLocalAppInfoData(s2);
        this.q.initMaxAgeInfo();
        if (d.a.q0.n.g.a.h().k(this.q)) {
            d.a.q0.a.h0.m.r.a.n(this.q);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            d.a.q0.a.e0.d.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.c<d.a.q0.n.h.f> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (d.a.q0.n.f.c) invokeV.objValue;
    }

    public abstract void t0(Throwable th);

    public d.a.q0.a.q2.a u0(d.a.q0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bVar)) == null) {
            d.a.q0.a.p0.g.a aVar = new d.a.q0.a.p0.g.a();
            aVar.f50017b = bVar.f53940i;
            aVar.f50016a = bVar.j;
            aVar.f50018c = bVar.f53932a;
            aVar.f50019d = bVar.m;
            if (d.a.q0.a.p0.b.b(bVar.f53939h, aVar) == null) {
                return null;
            }
            d.a.q0.a.q2.a aVar2 = new d.a.q0.a.q2.a();
            aVar2.j(14L);
            aVar2.b(2908L);
            aVar2.c("Extension包更新失败");
            return aVar2;
        }
        return (d.a.q0.a.q2.a) invokeL.objValue;
    }

    public d.a.q0.a.q2.a v0(d.a.q0.n.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, dVar)) == null) {
            if (E) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + dVar);
            }
            a.b c2 = d.a.q0.a.m2.f.a.c(dVar, dVar.f53939h);
            if (!TextUtils.isEmpty(dVar.f53932a)) {
                d.a.q0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dVar.f53932a);
                d.a.q0.t.d.j(dVar.f53932a);
            }
            if (c2.c()) {
                return null;
            }
            d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("Core包更新失败");
            return aVar;
        }
        return (d.a.q0.a.q2.a) invokeL.objValue;
    }

    public d.a.q0.a.q2.a w0(d.a.q0.n.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fVar)) == null) {
            if (fVar == null) {
                d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
                aVar.j(11L);
                aVar.h(2310L);
                aVar.e("pkg info is empty");
                d.a.q0.a.q2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (d.a.q0.a.q2.a) invokeL.objValue;
    }

    public void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            d.a.q0.a.r1.q.a.a(this.r, str, this.s, str2);
            this.s.clear();
        }
    }

    public final void y0(d.a.q0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) {
            d.a.q0.a.h0.m.c.c().d(bVar, new h(this, bVar));
        }
    }

    @Override // d.a.q0.n.f.g
    public d.a.q0.n.f.c<d.a.q0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.z : (d.a.q0.n.f.c) invokeV.objValue;
    }

    public final void z0(d.a.q0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, dVar) == null) {
            d.a.q0.a.h0.m.c.c().d(dVar, new g(this, dVar));
        }
    }
}
