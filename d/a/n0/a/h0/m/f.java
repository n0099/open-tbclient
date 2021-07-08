package d.a.n0.a.h0.m;

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
import d.a.n0.a.a2.i;
import d.a.n0.a.h0.m.c;
import d.a.n0.a.m2.f.a;
import d.a.n0.a.v2.y0;
import h.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class f extends d.a.n0.a.h0.m.j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.n0.n.f.c<d.a.n0.n.h.d> A;
    public d.a.n0.n.f.c<d.a.n0.n.h.b> B;
    public d.a.n0.n.f.f C;
    public h.j<d.a.n0.n.h.e> D;

    /* renamed from: g  reason: collision with root package name */
    public String f44964g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.n0.n.h.f> f44965h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super d.a.n0.n.h.g> f44966i;
    public h.j<? super d.a.n0.n.h.d> j;
    public h.j<? super d.a.n0.n.h.b> k;
    public d.a.n0.n.o.f l;
    public d.a.n0.n.h.f m;
    public List<d.a.n0.n.h.g> n;
    public d.a.n0.n.h.d o;
    public d.a.n0.n.h.b p;
    public PMSAppInfo q;
    public String r;
    public List<UbcFlowEvent> s;
    public d.a.n0.n.h.g t;
    public long u;
    public final Set<d.a.n0.a.h0.m.m.a> v;
    public final Set<d.a.n0.a.v2.e1.b<PMSAppInfo>> w;
    public final y0 x;
    public d.a.n0.n.f.c<d.a.n0.n.h.f> y;
    public d.a.n0.n.f.c<d.a.n0.n.h.g> z;

    /* loaded from: classes7.dex */
    public class a extends d.a.n0.n.f.b<d.a.n0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44967e;

        /* renamed from: d.a.n0.a.h0.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0746a implements d.a.n0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f44968e;

            public C0746a(a aVar) {
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
                this.f44968e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.n0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f43387f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    d.a.n0.n.f.h.a(this.f44968e.f44967e, bundle, "event_performance_ubc");
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
            this.f44967e = fVar;
        }

        @Override // d.a.n0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44967e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.c
        /* renamed from: l */
        public String d(d.a.n0.n.h.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
                int i2 = fVar.f50637h;
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

        @Override // d.a.n0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.f44967e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: o */
        public void e(d.a.n0.n.h.f fVar, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, fVar, aVar) == null) {
                super.e(fVar, aVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
                this.f44967e.l.j(fVar);
                d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f50626a);
                aVar2.c("主包下载失败");
                aVar2.e(aVar.toString());
                if (this.f44967e.f44965h != null) {
                    this.f44967e.f44965h.onError(new PkgDownloadError(fVar, aVar2));
                }
                d.a.n0.a.h0.m.c.c().a(fVar, this.f44967e.h0(), aVar2);
                d.a.n0.t.d.j(fVar.f50630a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: p */
        public void i(d.a.n0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
                String i0 = this.f44967e.i0();
                if (f.E) {
                    d.a.n0.a.f1.g.a.d(i0).e().d(1);
                }
                super.i(fVar);
                this.f44967e.s.add(new UbcFlowEvent("na_pms_end_download"));
                d.a.n0.a.q2.a w0 = this.f44967e.w0(fVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f50638i);
                if (w0 == null) {
                    f fVar2 = this.f44967e;
                    fVar2.m = fVar;
                    fVar2.l.k(fVar);
                    if (this.f44967e.f44965h != null) {
                        this.f44967e.f44965h.onNext(fVar);
                        if (f.E) {
                            Log.d("SwanAppPkgDownloadCallback", this.f44967e.f0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.f44967e.f44965h.onCompleted();
                    }
                    d.a.n0.a.h0.m.c.c().b(fVar, this.f44967e.h0());
                    return;
                }
                this.f44967e.l.j(fVar);
                if (this.f44967e.f44965h != null) {
                    this.f44967e.f44965h.onError(new PkgDownloadError(fVar, w0));
                }
                d.a.n0.a.h0.m.c.c().a(fVar, this.f44967e.h0(), w0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: q */
        public void c(d.a.n0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
                String i0 = this.f44967e.i0();
                if (f.E) {
                    d.a.n0.a.f1.g.a.d(i0).e().d(1);
                }
                super.c(fVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: r */
        public void f(d.a.n0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
                String i0 = this.f44967e.i0();
                if (f.E) {
                    d.a.n0.a.f1.g.a.d(i0).e().d(1);
                }
                super.f(fVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f44967e.f0() + ": main onDownloading");
                }
                this.f44967e.A0(fVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: s */
        public d.a.n0.n.h.a h(d.a.n0.n.h.f fVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fVar, file, Long.valueOf(j), readableByteChannel})) == null) {
                String i0 = this.f44967e.i0();
                if (f.E) {
                    d.a.n0.a.f1.g.a.d(i0).f(fVar.toString()).d(1);
                }
                C0746a c0746a = new C0746a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                d.a.n0.a.a1.g gVar = new d.a.n0.a.a1.g();
                gVar.v(c0746a);
                gVar.g(bundle);
                gVar.f(new d.a.n0.a.a1.f(fVar, this.f44967e));
                gVar.f(new d.a.n0.a.a1.d(fVar.m, this.f44967e));
                gVar.i(readableByteChannel);
                boolean j2 = gVar.j();
                gVar.p(c0746a);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f44967e.f0() + ": onProcessStream: installOk=" + j2);
                }
                if (j2) {
                    d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    d.a.n0.t.d.K(file);
                }
                return j2 ? new d.a.n0.n.h.a(2300, "业务层处理下载流成功") : new d.a.n0.n.h.a(2301, "业务层处理下载流失败");
            }
            return (d.a.n0.n.h.a) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.v2.e1.b<d.a.n0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f44969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f44970f;

        public b(f fVar, d.a.n0.a.v2.e1.b bVar) {
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
            this.f44970f = fVar;
            this.f44969e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f44969e.onCallback(aVar);
                f fVar = this.f44970f;
                fVar.e0(fVar.v, aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.a.v2.e1.b<d.a.n0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.q2.a f44971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44972f;

        public c(f fVar, d.a.n0.a.q2.a aVar, boolean z) {
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
            this.f44971e = aVar;
            this.f44972f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.f44971e, this.f44972f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.n0.a.v2.e1.b<d.a.n0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44973e;

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
            this.f44973e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.f44973e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.InterfaceC0744c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.n.h.f f44974a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f44975b;

        public e(f fVar, d.a.n0.n.h.f fVar2) {
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
            this.f44975b = fVar;
            this.f44974a = fVar2;
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f44975b;
                d.a.n0.n.h.f fVar2 = this.f44974a;
                fVar.m = fVar2;
                fVar.l.k(fVar2);
                if (this.f44975b.f44965h != null) {
                    this.f44975b.f44965h.onNext(this.f44974a);
                    this.f44975b.f44965h.onCompleted();
                }
            }
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void b(PMSDownloadType pMSDownloadType, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f44975b.l.j(this.f44974a);
                if (this.f44975b.f44965h != null) {
                    this.f44975b.f44965h.onError(new PkgDownloadError(this.f44974a, aVar));
                }
            }
        }
    }

    /* renamed from: d.a.n0.a.h0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0747f implements c.InterfaceC0744c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.n.h.g f44976a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f44977b;

        public C0747f(f fVar, d.a.n0.n.h.g gVar) {
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
            this.f44977b = fVar;
            this.f44976a = gVar;
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f44977b;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                d.a.n0.n.h.g gVar = this.f44976a;
                f fVar2 = this.f44977b;
                gVar.o = fVar2.r;
                fVar2.n.add(gVar);
                this.f44977b.l.k(this.f44976a);
                if (this.f44977b.f44966i != null) {
                    this.f44977b.f44966i.onNext(this.f44976a);
                    if (this.f44977b.l.g()) {
                        return;
                    }
                    this.f44977b.f44966i.onCompleted();
                }
            }
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void b(PMSDownloadType pMSDownloadType, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f44977b.l.j(this.f44976a);
                if (this.f44977b.f44966i != null) {
                    this.f44977b.f44966i.onError(new PkgDownloadError(this.f44976a, aVar));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements c.InterfaceC0744c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.n.h.d f44978a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f44979b;

        public g(f fVar, d.a.n0.n.h.d dVar) {
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
            this.f44979b = fVar;
            this.f44978a = dVar;
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f44979b;
                d.a.n0.n.h.d dVar = this.f44978a;
                fVar.o = dVar;
                fVar.l.k(dVar);
                if (this.f44979b.j != null) {
                    this.f44979b.j.onNext(this.f44978a);
                    this.f44979b.j.onCompleted();
                }
            }
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void b(PMSDownloadType pMSDownloadType, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f44979b.l.j(this.f44978a);
                if (this.f44979b.j != null) {
                    this.f44979b.j.onError(new PkgDownloadError(this.f44978a, aVar));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements c.InterfaceC0744c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.n.h.b f44980a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f44981b;

        public h(f fVar, d.a.n0.n.h.b bVar) {
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
            this.f44981b = fVar;
            this.f44980a = bVar;
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f fVar = this.f44981b;
                d.a.n0.n.h.b bVar = this.f44980a;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f44981b.n0(this.f44980a);
            }
        }

        @Override // d.a.n0.a.h0.m.c.InterfaceC0744c
        public void b(PMSDownloadType pMSDownloadType, d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f44981b.l.j(this.f44980a);
                this.f44981b.n0(this.f44980a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends h.j<d.a.n0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44982e;

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
            this.f44982e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.n0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f44982e.h0() + " : 单个包下载、业务层处理完成：" + eVar.f50638i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f44982e.h0() + " : 包下载onCompleted");
                this.f44982e.s0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                d.a.n0.a.e0.d.i("SwanAppPkgDownloadCallback", this.f44982e.h0() + " : 包下载OnError", th);
                this.f44982e.t0(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements d.a<d.a.n0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44983e;

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
            this.f44983e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.n0.n.h.f> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f44983e.f44965h = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements d.a<d.a.n0.n.h.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44984e;

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
            this.f44984e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.n0.n.h.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f44984e.f44966i = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements d.a<d.a.n0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44985e;

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
            this.f44985e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.n0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f44985e.j = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements d.a<d.a.n0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44986e;

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
            this.f44986e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.n0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f44986e.k = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends d.a.n0.a.h0.m.k<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f44987g;

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
                    super((d.a.n0.a.h0.m.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44987g = fVar;
        }

        @Override // d.a.n0.a.h0.m.k, d.a.n0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44987g.g0() : invokeV.intValue;
        }

        @Override // d.a.n0.a.h0.m.k
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44987g.r : (String) invokeV.objValue;
        }

        @Override // d.a.n0.a.h0.m.k
        public void p(@NonNull d.a.n0.n.h.g gVar, @Nullable d.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f50638i);
                f fVar = this.f44987g;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                f fVar2 = this.f44987g;
                gVar.o = fVar2.r;
                if (aVar == null) {
                    fVar2.n.add(gVar);
                    this.f44987g.l.k(gVar);
                    d.a.n0.a.h0.m.c.c().b(gVar, this.f44987g.h0());
                } else {
                    fVar2.l.j(gVar);
                    d.a.n0.a.h0.m.c.c().a(gVar, this.f44987g.h0(), aVar);
                }
                if (this.f44987g.f44966i != null) {
                    this.f44987g.f44966i.onNext(gVar);
                    if (this.f44987g.l.g()) {
                        return;
                    }
                    this.f44987g.f44966i.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: q */
        public void e(d.a.n0.n.h.g gVar, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
                this.f44987g.l.j(gVar);
                d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f50626a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                if (this.f44987g.f44966i != null) {
                    this.f44987g.f44966i.onError(new PkgDownloadError(gVar, aVar2));
                }
                d.a.n0.a.h0.m.c.c().a(gVar, this.f44987g.h0(), aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.h0.m.k, d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: s */
        public void c(d.a.n0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
                super.c(gVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: u */
        public void f(d.a.n0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.f(gVar);
                this.f44987g.B0(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends d.a.n0.n.f.b<d.a.n0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44988e;

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
            this.f44988e = fVar;
        }

        @Override // d.a.n0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44988e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.c
        /* renamed from: l */
        public String d(d.a.n0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
                int i2 = dVar.f50637h;
                if (i2 == 0) {
                    return d.a.n0.a.h0.m.r.a.h();
                }
                if (i2 == 1) {
                    return d.a.n0.a.h0.m.r.a.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.n0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f44988e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: o */
        public void e(d.a.n0.n.h.d dVar, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
                this.f44988e.l.j(dVar);
                d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f50626a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f44988e.j != null) {
                    this.f44988e.j.onError(new PkgDownloadError(dVar, aVar2));
                }
                d.a.n0.a.h0.m.c.c().a(dVar, this.f44988e.h0(), aVar2);
                d.a.n0.t.d.j(dVar.f50630a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: p */
        public void i(d.a.n0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.i(dVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f50638i);
                d.a.n0.a.q2.a v0 = this.f44988e.v0(dVar);
                if (v0 == null) {
                    f fVar = this.f44988e;
                    fVar.o = dVar;
                    fVar.l.k(dVar);
                    if (this.f44988e.j != null) {
                        this.f44988e.j.onNext(dVar);
                        this.f44988e.j.onCompleted();
                    }
                    d.a.n0.a.h0.m.c.c().b(dVar, this.f44988e.h0());
                    return;
                }
                this.f44988e.l.j(dVar);
                if (this.f44988e.j != null) {
                    this.f44988e.j.onError(new PkgDownloadError(dVar, v0));
                }
                d.a.n0.a.h0.m.c.c().a(dVar, this.f44988e.h0(), v0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: q */
        public void c(d.a.n0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.c(dVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: r */
        public void f(d.a.n0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
                super.f(dVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f44988e.f0() + ": framework onDownloading");
                }
                this.f44988e.z0(dVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends d.a.n0.n.f.b<d.a.n0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44989e;

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
            this.f44989e = fVar;
        }

        @Override // d.a.n0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f44989e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.c
        /* renamed from: l */
        public String d(d.a.n0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                int i2 = bVar.f50637h;
                if (i2 == 0) {
                    return d.a.n0.a.h0.m.r.a.d();
                }
                if (i2 == 1) {
                    return d.a.n0.a.h0.m.r.a.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.n0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f44989e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: o */
        public void e(d.a.n0.n.h.b bVar, d.a.n0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
                this.f44989e.l.j(bVar);
                d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f50626a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
                }
                this.f44989e.n0(bVar);
                d.a.n0.a.h0.m.c.c().a(bVar, this.f44989e.h0(), aVar2);
                d.a.n0.t.d.j(bVar.f50630a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: p */
        public void i(d.a.n0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.i(bVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f50638i);
                d.a.n0.a.q2.a u0 = this.f44989e.u0(bVar);
                if (u0 != null) {
                    if (f.E) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                    }
                    this.f44989e.l.j(bVar);
                    this.f44989e.n0(bVar);
                    d.a.n0.a.h0.m.c.c().a(bVar, this.f44989e.h0(), u0);
                    return;
                }
                f fVar = this.f44989e;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f44989e.n0(bVar);
                d.a.n0.a.h0.m.c.c().b(bVar, this.f44989e.h0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: q */
        public void c(d.a.n0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.c(bVar);
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.n.f.b, d.a.n0.n.f.c
        /* renamed from: r */
        public void f(d.a.n0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
                super.f(bVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f44989e.f0() + ": extension onDownloading");
                }
                this.f44989e.y0(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements d.a.n0.n.f.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f44990a;

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
            this.f44990a = fVar;
        }

        @Override // d.a.n0.n.f.f
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", this.f44990a.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                f fVar = this.f44990a;
                fVar.q = pMSAppInfo;
                if (pMSAppInfo != null) {
                    fVar.l0(pMSAppInfo);
                    d.a.n0.a.t1.g.b.k(this.f44990a.q.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements d.a.n0.a.v2.e1.b<d.a.n0.a.v2.e1.b<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44991e;

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
            this.f44991e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.v2.e1.b<PMSAppInfo> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                bVar.onCallback(this.f44991e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f44992e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f44993f;

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
            this.f44992e = collection;
            this.f44993f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44992e.add(this.f44993f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f44994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f44995f;

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
            this.f44994e = collection;
            this.f44995f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44994e.remove(this.f44995f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f44996e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f44997f;

        public u(f fVar, Collection collection, d.a.n0.a.v2.e1.b bVar) {
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
            this.f44996e = collection;
            this.f44997f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.f44996e) {
                    this.f44997f.onCallback(obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318347944, "Ld/a/n0/a/h0/m/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318347944, "Ld/a/n0/a/h0/m/f;");
                return;
            }
        }
        E = d.a.n0.a.k.f45831a;
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
        this.f44964g = "";
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

    public final void A0(d.a.n0.n.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            d.a.n0.a.h0.m.c.c().d(fVar, new e(this, fVar));
        }
    }

    @Override // d.a.n0.n.f.g
    public void B(d.a.n0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
            if (aVar != null && aVar.f50626a == 1010) {
                D0();
            }
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void B0(d.a.n0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            d.a.n0.a.h0.m.c.c().d(gVar, new C0747f(this, gVar));
        }
    }

    @Override // d.a.n0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public d.a.n0.a.q2.a C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo == null) {
                if (this.m == null) {
                    d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                    aVar.j(10L);
                    aVar.h(2903L);
                    aVar.c("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo s2 = d.a.n0.n.g.a.h().s(this.r);
                if (s2 == null) {
                    d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                    aVar2.j(10L);
                    aVar2.h(2904L);
                    aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.q = s2;
                d.a.n0.a.h0.m.r.a.j(s2, this.m);
                this.q.initMaxAgeInfo();
                this.q.updateInstallSrc(I());
                if (d.a.n0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                    return null;
                }
                d.a.n0.a.q2.a aVar3 = new d.a.n0.a.q2.a();
                aVar3.j(10L);
                aVar3.h(2906L);
                aVar3.c("更新DB失败");
                return aVar3;
            }
            d.a.n0.n.h.f fVar = this.m;
            if (fVar != null) {
                d.a.n0.a.h0.m.r.a.j(pMSAppInfo, fVar);
            } else if (d.a.n0.a.h0.m.r.b.f(this.n)) {
                d.a.n0.n.h.g gVar = this.n.get(0);
                this.t = gVar;
                gVar.o = this.r;
                d.a.n0.a.h0.m.r.a.k(this.q, gVar);
            } else {
                PMSAppInfo s3 = d.a.n0.n.g.a.h().s(this.r);
                if (s3 == null) {
                    d.a.n0.a.q2.a aVar4 = new d.a.n0.a.q2.a();
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
            if (d.a.n0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                d.a.n0.a.h0.m.r.a.n(this.q);
                return null;
            }
            d.a.n0.a.q2.a aVar5 = new d.a.n0.a.q2.a();
            aVar5.j(10L);
            aVar5.h(2906L);
            aVar5.c("更新DB失败");
            return aVar5;
        }
        return (d.a.n0.a.q2.a) invokeV.objValue;
    }

    @Override // d.a.n0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PMSAppInfo s2 = d.a.n0.n.g.a.h().s(this.r);
            d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + s2.createTime + " lastLaunchTime=" + s2.getLastLaunchTime() + " maxAge=" + s2.maxAge);
            if (s2 != null) {
                s2.initMaxAgeInfo();
                s2.updateInstallSrc(I());
                d.a.n0.n.h.f fVar = this.m;
                if (fVar != null) {
                    fVar.f50632c = s2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.q;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = s2.createTime;
                    pMSAppInfo.updateInstallSrc(I());
                }
                d.a.n0.n.g.a.h().k(s2);
            }
        }
    }

    @Override // d.a.n0.n.f.g
    public void F(d.a.n0.n.o.f fVar) {
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

    public f b0(d.a.n0.a.v2.e1.b<PMSAppInfo> bVar) {
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

    public synchronized f d0(d.a.n0.a.h0.m.m.a aVar) {
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
            if (TextUtils.isEmpty(this.f44964g)) {
                this.f44964g = getClass().toString();
            }
            return this.f44964g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? d.a.n0.n.f.h.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 1013) {
                d.a.n0.n.g.a.h().x(this.r, i2);
            } else {
                d.a.n0.n.g.a.h().x(this.r, 0);
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

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull d.a.n0.a.v2.e1.b<CallbackT> bVar) {
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

    public final void n0(d.a.n0.n.h.b bVar) {
        h.j<? super d.a.n0.n.h.b> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.onNext(bVar);
        this.k.onCompleted();
    }

    public f o0(@NonNull d.a.n0.a.v2.e1.b<d.a.n0.a.h0.m.m.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            m0(this.v, new b(this, bVar));
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.f p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C : (d.a.n0.n.f.f) invokeV.objValue;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pMSAppInfo) == null) {
            o0(new d(this, pMSAppInfo));
        }
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.c<d.a.n0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.B : (d.a.n0.n.f.c) invokeV.objValue;
    }

    public void q0(d.a.n0.a.q2.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, aVar, z) == null) {
            o0(new c(this, aVar, z));
        }
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.c<d.a.n0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.A : (d.a.n0.n.f.c) invokeV.objValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.q == null) {
            return;
        }
        PMSAppInfo s2 = d.a.n0.n.g.a.h().s(this.r);
        if (s2 == null) {
            d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        s2.updateInstallSrc(I());
        this.q.copyLocalAppInfoData(s2);
        this.q.initMaxAgeInfo();
        if (d.a.n0.n.g.a.h().k(this.q)) {
            d.a.n0.a.h0.m.r.a.n(this.q);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            d.a.n0.a.e0.d.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.c<d.a.n0.n.h.f> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (d.a.n0.n.f.c) invokeV.objValue;
    }

    public abstract void t0(Throwable th);

    public d.a.n0.a.q2.a u0(d.a.n0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bVar)) == null) {
            d.a.n0.a.p0.g.a aVar = new d.a.n0.a.p0.g.a();
            aVar.f46715b = bVar.f50638i;
            aVar.f46714a = bVar.j;
            aVar.f46716c = bVar.f50630a;
            aVar.f46717d = bVar.m;
            if (d.a.n0.a.p0.b.b(bVar.f50637h, aVar) == null) {
                return null;
            }
            d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
            aVar2.j(14L);
            aVar2.b(2908L);
            aVar2.c("Extension包更新失败");
            return aVar2;
        }
        return (d.a.n0.a.q2.a) invokeL.objValue;
    }

    public d.a.n0.a.q2.a v0(d.a.n0.n.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, dVar)) == null) {
            if (E) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + dVar);
            }
            a.b c2 = d.a.n0.a.m2.f.a.c(dVar, dVar.f50637h);
            if (!TextUtils.isEmpty(dVar.f50630a)) {
                d.a.n0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dVar.f50630a);
                d.a.n0.t.d.j(dVar.f50630a);
            }
            if (c2.c()) {
                return null;
            }
            d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("Core包更新失败");
            return aVar;
        }
        return (d.a.n0.a.q2.a) invokeL.objValue;
    }

    public d.a.n0.a.q2.a w0(d.a.n0.n.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fVar)) == null) {
            if (fVar == null) {
                d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                aVar.j(11L);
                aVar.h(2310L);
                aVar.e("pkg info is empty");
                d.a.n0.a.q2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (d.a.n0.a.q2.a) invokeL.objValue;
    }

    public void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            d.a.n0.a.r1.q.a.a(this.r, str, this.s, str2);
            this.s.clear();
        }
    }

    public final void y0(d.a.n0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) {
            d.a.n0.a.h0.m.c.c().d(bVar, new h(this, bVar));
        }
    }

    @Override // d.a.n0.n.f.g
    public d.a.n0.n.f.c<d.a.n0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.z : (d.a.n0.n.f.c) invokeV.objValue;
    }

    public final void z0(d.a.n0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, dVar) == null) {
            d.a.n0.a.h0.m.c.c().d(dVar, new g(this, dVar));
        }
    }
}
