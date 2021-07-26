package d.a.o0.a.h0.m;

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
import d.a.o0.a.a2.i;
import d.a.o0.a.h0.m.c;
import d.a.o0.a.m2.f.a;
import d.a.o0.a.v2.y0;
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
public abstract class f extends d.a.o0.a.h0.m.j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.o0.n.f.c<d.a.o0.n.h.d> A;
    public d.a.o0.n.f.c<d.a.o0.n.h.b> B;
    public d.a.o0.n.f.f C;
    public h.j<d.a.o0.n.h.e> D;

    /* renamed from: g  reason: collision with root package name */
    public String f45468g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.o0.n.h.f> f45469h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super d.a.o0.n.h.g> f45470i;
    public h.j<? super d.a.o0.n.h.d> j;
    public h.j<? super d.a.o0.n.h.b> k;
    public d.a.o0.n.o.f l;
    public d.a.o0.n.h.f m;
    public List<d.a.o0.n.h.g> n;
    public d.a.o0.n.h.d o;
    public d.a.o0.n.h.b p;
    public PMSAppInfo q;
    public String r;
    public List<UbcFlowEvent> s;
    public d.a.o0.n.h.g t;
    public long u;
    public final Set<d.a.o0.a.h0.m.m.a> v;
    public final Set<d.a.o0.a.v2.e1.b<PMSAppInfo>> w;
    public final y0 x;
    public d.a.o0.n.f.c<d.a.o0.n.h.f> y;
    public d.a.o0.n.f.c<d.a.o0.n.h.g> z;

    /* loaded from: classes7.dex */
    public class a extends d.a.o0.n.f.b<d.a.o0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45471e;

        /* renamed from: d.a.o0.a.h0.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0755a implements d.a.o0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f45472e;

            public C0755a(a aVar) {
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
                this.f45472e = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.f43891f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    d.a.o0.n.f.h.a(this.f45472e.f45471e, bundle, "event_performance_ubc");
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
            this.f45471e = fVar;
        }

        @Override // d.a.o0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45471e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.c
        /* renamed from: l */
        public String d(d.a.o0.n.h.f fVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
                int i2 = fVar.f51141h;
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

        @Override // d.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.f45471e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: o */
        public void e(d.a.o0.n.h.f fVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, fVar, aVar) == null) {
                super.e(fVar, aVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
                this.f45471e.l.j(fVar);
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(11L);
                aVar2.h(aVar.f51130a);
                aVar2.c("主包下载失败");
                aVar2.e(aVar.toString());
                if (this.f45471e.f45469h != null) {
                    this.f45471e.f45469h.onError(new PkgDownloadError(fVar, aVar2));
                }
                d.a.o0.a.h0.m.c.c().a(fVar, this.f45471e.h0(), aVar2);
                d.a.o0.t.d.j(fVar.f51134a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: p */
        public void i(d.a.o0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
                String i0 = this.f45471e.i0();
                if (f.E) {
                    d.a.o0.a.f1.g.a.d(i0).e().d(1);
                }
                super.i(fVar);
                this.f45471e.s.add(new UbcFlowEvent("na_pms_end_download"));
                d.a.o0.a.q2.a w0 = this.f45471e.w0(fVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f51142i);
                if (w0 == null) {
                    f fVar2 = this.f45471e;
                    fVar2.m = fVar;
                    fVar2.l.k(fVar);
                    if (this.f45471e.f45469h != null) {
                        this.f45471e.f45469h.onNext(fVar);
                        if (f.E) {
                            Log.d("SwanAppPkgDownloadCallback", this.f45471e.f0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.f45471e.f45469h.onCompleted();
                    }
                    d.a.o0.a.h0.m.c.c().b(fVar, this.f45471e.h0());
                    return;
                }
                this.f45471e.l.j(fVar);
                if (this.f45471e.f45469h != null) {
                    this.f45471e.f45469h.onError(new PkgDownloadError(fVar, w0));
                }
                d.a.o0.a.h0.m.c.c().a(fVar, this.f45471e.h0(), w0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: q */
        public void c(d.a.o0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
                String i0 = this.f45471e.i0();
                if (f.E) {
                    d.a.o0.a.f1.g.a.d(i0).e().d(1);
                }
                super.c(fVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: r */
        public void f(d.a.o0.n.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
                String i0 = this.f45471e.i0();
                if (f.E) {
                    d.a.o0.a.f1.g.a.d(i0).e().d(1);
                }
                super.f(fVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f45471e.f0() + ": main onDownloading");
                }
                this.f45471e.A0(fVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: s */
        public d.a.o0.n.h.a h(d.a.o0.n.h.f fVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fVar, file, Long.valueOf(j), readableByteChannel})) == null) {
                String i0 = this.f45471e.i0();
                if (f.E) {
                    d.a.o0.a.f1.g.a.d(i0).f(fVar.toString()).d(1);
                }
                C0755a c0755a = new C0755a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                d.a.o0.a.a1.g gVar = new d.a.o0.a.a1.g();
                gVar.v(c0755a);
                gVar.g(bundle);
                gVar.f(new d.a.o0.a.a1.f(fVar, this.f45471e));
                gVar.f(new d.a.o0.a.a1.d(fVar.m, this.f45471e));
                gVar.i(readableByteChannel);
                boolean j2 = gVar.j();
                gVar.p(c0755a);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f45471e.f0() + ": onProcessStream: installOk=" + j2);
                }
                if (j2) {
                    d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    d.a.o0.t.d.K(file);
                }
                return j2 ? new d.a.o0.n.h.a(2300, "业务层处理下载流成功") : new d.a.o0.n.h.a(2301, "业务层处理下载流失败");
            }
            return (d.a.o0.n.h.a) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.v2.e1.b<d.a.o0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f45473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f45474f;

        public b(f fVar, d.a.o0.a.v2.e1.b bVar) {
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
            this.f45474f = fVar;
            this.f45473e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f45473e.onCallback(aVar);
                f fVar = this.f45474f;
                fVar.e0(fVar.v, aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.v2.e1.b<d.a.o0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.q2.a f45475e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45476f;

        public c(f fVar, d.a.o0.a.q2.a aVar, boolean z) {
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
            this.f45475e = aVar;
            this.f45476f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.a(this.f45475e, this.f45476f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.a.v2.e1.b<d.a.o0.a.h0.m.m.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f45477e;

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
            this.f45477e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.h0.m.m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.b(this.f45477e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.InterfaceC0753c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.n.h.f f45478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f45479b;

        public e(f fVar, d.a.o0.n.h.f fVar2) {
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
            this.f45479b = fVar;
            this.f45478a = fVar2;
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f45479b;
                d.a.o0.n.h.f fVar2 = this.f45478a;
                fVar.m = fVar2;
                fVar.l.k(fVar2);
                if (this.f45479b.f45469h != null) {
                    this.f45479b.f45469h.onNext(this.f45478a);
                    this.f45479b.f45469h.onCompleted();
                }
            }
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void b(PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f45479b.l.j(this.f45478a);
                if (this.f45479b.f45469h != null) {
                    this.f45479b.f45469h.onError(new PkgDownloadError(this.f45478a, aVar));
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.h0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0756f implements c.InterfaceC0753c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.n.h.g f45480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f45481b;

        public C0756f(f fVar, d.a.o0.n.h.g gVar) {
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
            this.f45481b = fVar;
            this.f45480a = gVar;
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f45481b;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                d.a.o0.n.h.g gVar = this.f45480a;
                f fVar2 = this.f45481b;
                gVar.o = fVar2.r;
                fVar2.n.add(gVar);
                this.f45481b.l.k(this.f45480a);
                if (this.f45481b.f45470i != null) {
                    this.f45481b.f45470i.onNext(this.f45480a);
                    if (this.f45481b.l.g()) {
                        return;
                    }
                    this.f45481b.f45470i.onCompleted();
                }
            }
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void b(PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f45481b.l.j(this.f45480a);
                if (this.f45481b.f45470i != null) {
                    this.f45481b.f45470i.onError(new PkgDownloadError(this.f45480a, aVar));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements c.InterfaceC0753c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.n.h.d f45482a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f45483b;

        public g(f fVar, d.a.o0.n.h.d dVar) {
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
            this.f45483b = fVar;
            this.f45482a = dVar;
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                f fVar = this.f45483b;
                d.a.o0.n.h.d dVar = this.f45482a;
                fVar.o = dVar;
                fVar.l.k(dVar);
                if (this.f45483b.j != null) {
                    this.f45483b.j.onNext(this.f45482a);
                    this.f45483b.j.onCompleted();
                }
            }
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void b(PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f45483b.l.j(this.f45482a);
                if (this.f45483b.j != null) {
                    this.f45483b.j.onError(new PkgDownloadError(this.f45482a, aVar));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements c.InterfaceC0753c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.n.h.b f45484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f45485b;

        public h(f fVar, d.a.o0.n.h.b bVar) {
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
            this.f45485b = fVar;
            this.f45484a = bVar;
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                f fVar = this.f45485b;
                d.a.o0.n.h.b bVar = this.f45484a;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f45485b.n0(this.f45484a);
            }
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void b(PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
                this.f45485b.l.j(this.f45484a);
                this.f45485b.n0(this.f45484a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends h.j<d.a.o0.n.h.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45486e;

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
            this.f45486e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.o0.n.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f45486e.h0() + " : 单个包下载、业务层处理完成：" + eVar.f51142i);
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", this.f45486e.h0() + " : 包下载onCompleted");
                this.f45486e.s0();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                d.a.o0.a.e0.d.i("SwanAppPkgDownloadCallback", this.f45486e.h0() + " : 包下载OnError", th);
                this.f45486e.t0(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements d.a<d.a.o0.n.h.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45487e;

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
            this.f45487e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.o0.n.h.f> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f45487e.f45469h = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements d.a<d.a.o0.n.h.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45488e;

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
            this.f45488e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.o0.n.h.g> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f45488e.f45470i = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements d.a<d.a.o0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45489e;

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
            this.f45489e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.o0.n.h.d> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f45489e.j = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements d.a<d.a.o0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45490e;

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
            this.f45490e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.o0.n.h.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f45490e.k = jVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends d.a.o0.a.h0.m.k<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f45491g;

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
                    super((d.a.o0.a.h0.m.j) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45491g = fVar;
        }

        @Override // d.a.o0.a.h0.m.k, d.a.o0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45491g.g0() : invokeV.intValue;
        }

        @Override // d.a.o0.a.h0.m.k
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45491g.r : (String) invokeV.objValue;
        }

        @Override // d.a.o0.a.h0.m.k
        public void p(@NonNull d.a.o0.n.h.g gVar, @Nullable d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, aVar) == null) {
                super.p(gVar, aVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f51142i);
                f fVar = this.f45491g;
                if (fVar.n == null) {
                    fVar.n = new ArrayList();
                }
                f fVar2 = this.f45491g;
                gVar.o = fVar2.r;
                if (aVar == null) {
                    fVar2.n.add(gVar);
                    this.f45491g.l.k(gVar);
                    d.a.o0.a.h0.m.c.c().b(gVar, this.f45491g.h0());
                } else {
                    fVar2.l.j(gVar);
                    d.a.o0.a.h0.m.c.c().a(gVar, this.f45491g.h0(), aVar);
                }
                if (this.f45491g.f45470i != null) {
                    this.f45491g.f45470i.onNext(gVar);
                    if (this.f45491g.l.g()) {
                        return;
                    }
                    this.f45491g.f45470i.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: q */
        public void e(d.a.o0.n.h.g gVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, aVar) == null) {
                super.q(gVar, aVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
                this.f45491g.l.j(gVar);
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f51130a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                if (this.f45491g.f45470i != null) {
                    this.f45491g.f45470i.onError(new PkgDownloadError(gVar, aVar2));
                }
                d.a.o0.a.h0.m.c.c().a(gVar, this.f45491g.h0(), aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.h0.m.k, d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: s */
        public void c(d.a.o0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
                super.c(gVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: u */
        public void f(d.a.o0.n.h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.f(gVar);
                this.f45491g.B0(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends d.a.o0.n.f.b<d.a.o0.n.h.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45492e;

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
            this.f45492e = fVar;
        }

        @Override // d.a.o0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45492e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.c
        /* renamed from: l */
        public String d(d.a.o0.n.h.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
                int i2 = dVar.f51141h;
                if (i2 == 0) {
                    return d.a.o0.a.h0.m.r.a.h();
                }
                if (i2 == 1) {
                    return d.a.o0.a.h0.m.r.a.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f45492e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: o */
        public void e(d.a.o0.n.h.d dVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar, aVar) == null) {
                super.e(dVar, aVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
                this.f45492e.l.j(dVar);
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(13L);
                aVar2.h(aVar.f51130a);
                aVar2.c("Framework包下载失败");
                aVar2.e(aVar.toString());
                if (this.f45492e.j != null) {
                    this.f45492e.j.onError(new PkgDownloadError(dVar, aVar2));
                }
                d.a.o0.a.h0.m.c.c().a(dVar, this.f45492e.h0(), aVar2);
                d.a.o0.t.d.j(dVar.f51134a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: p */
        public void i(d.a.o0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
                super.i(dVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f51142i);
                d.a.o0.a.q2.a v0 = this.f45492e.v0(dVar);
                if (v0 == null) {
                    f fVar = this.f45492e;
                    fVar.o = dVar;
                    fVar.l.k(dVar);
                    if (this.f45492e.j != null) {
                        this.f45492e.j.onNext(dVar);
                        this.f45492e.j.onCompleted();
                    }
                    d.a.o0.a.h0.m.c.c().b(dVar, this.f45492e.h0());
                    return;
                }
                this.f45492e.l.j(dVar);
                if (this.f45492e.j != null) {
                    this.f45492e.j.onError(new PkgDownloadError(dVar, v0));
                }
                d.a.o0.a.h0.m.c.c().a(dVar, this.f45492e.h0(), v0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: q */
        public void c(d.a.o0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
                super.c(dVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: r */
        public void f(d.a.o0.n.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
                super.f(dVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f45492e.f0() + ": framework onDownloading");
                }
                this.f45492e.z0(dVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends d.a.o0.n.f.b<d.a.o0.n.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45493e;

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
            this.f45493e = fVar;
        }

        @Override // d.a.o0.n.f.b
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45493e.g0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.c
        /* renamed from: l */
        public String d(d.a.o0.n.h.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
                int i2 = bVar.f51141h;
                if (i2 == 0) {
                    return d.a.o0.a.h0.m.r.a.d();
                }
                if (i2 == 1) {
                    return d.a.o0.a.h0.m.r.a.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.f45493e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: o */
        public void e(d.a.o0.n.h.b bVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, aVar) == null) {
                super.e(bVar, aVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
                this.f45493e.l.j(bVar);
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(14L);
                aVar2.h(aVar.f51130a);
                aVar2.c("Extension下载失败");
                aVar2.e(aVar.toString());
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
                }
                this.f45493e.n0(bVar);
                d.a.o0.a.h0.m.c.c().a(bVar, this.f45493e.h0(), aVar2);
                d.a.o0.t.d.j(bVar.f51134a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: p */
        public void i(d.a.o0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                super.i(bVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f51142i);
                d.a.o0.a.q2.a u0 = this.f45493e.u0(bVar);
                if (u0 != null) {
                    if (f.E) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                    }
                    this.f45493e.l.j(bVar);
                    this.f45493e.n0(bVar);
                    d.a.o0.a.h0.m.c.c().a(bVar, this.f45493e.h0(), u0);
                    return;
                }
                f fVar = this.f45493e;
                fVar.p = bVar;
                fVar.l.k(bVar);
                this.f45493e.n0(bVar);
                d.a.o0.a.h0.m.c.c().b(bVar, this.f45493e.h0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: q */
        public void c(d.a.o0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                super.c(bVar);
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: r */
        public void f(d.a.o0.n.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
                super.f(bVar);
                if (f.E) {
                    Log.i("SwanAppPkgDownloadCallback", this.f45493e.f0() + ": extension onDownloading");
                }
                this.f45493e.y0(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements d.a.o0.n.f.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f45494a;

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
            this.f45494a = fVar;
        }

        @Override // d.a.o0.n.f.f
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", this.f45494a.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                f fVar = this.f45494a;
                fVar.q = pMSAppInfo;
                if (pMSAppInfo != null) {
                    fVar.l0(pMSAppInfo);
                    d.a.o0.a.t1.g.b.k(this.f45494a.q.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements d.a.o0.a.v2.e1.b<d.a.o0.a.v2.e1.b<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f45495e;

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
            this.f45495e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.v2.e1.b<PMSAppInfo> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                bVar.onCallback(this.f45495e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f45496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f45497f;

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
            this.f45496e = collection;
            this.f45497f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45496e.add(this.f45497f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f45498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f45499f;

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
            this.f45498e = collection;
            this.f45499f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45498e.remove(this.f45499f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f45500e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f45501f;

        public u(f fVar, Collection collection, d.a.o0.a.v2.e1.b bVar) {
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
            this.f45500e = collection;
            this.f45501f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.f45500e) {
                    this.f45501f.onCallback(obj);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447430663, "Ld/a/o0/a/h0/m/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447430663, "Ld/a/o0/a/h0/m/f;");
                return;
            }
        }
        E = d.a.o0.a.k.f46335a;
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
        this.f45468g = "";
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

    public final void A0(d.a.o0.n.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            d.a.o0.a.h0.m.c.c().d(fVar, new e(this, fVar));
        }
    }

    @Override // d.a.o0.n.f.g
    public void B(d.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
            if (aVar != null && aVar.f51130a == 1010) {
                D0();
            }
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void B0(d.a.o0.n.h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            d.a.o0.a.h0.m.c.c().d(gVar, new C0756f(this, gVar));
        }
    }

    @Override // d.a.o0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public d.a.o0.a.q2.a C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo == null) {
                if (this.m == null) {
                    d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                    aVar.j(10L);
                    aVar.h(2903L);
                    aVar.c("Server未返回主包&AppInfo");
                    return aVar;
                }
                PMSAppInfo s2 = d.a.o0.n.g.a.h().s(this.r);
                if (s2 == null) {
                    d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                    aVar2.j(10L);
                    aVar2.h(2904L);
                    aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                    return aVar2;
                }
                this.q = s2;
                d.a.o0.a.h0.m.r.a.j(s2, this.m);
                this.q.initMaxAgeInfo();
                this.q.updateInstallSrc(I());
                if (d.a.o0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                    return null;
                }
                d.a.o0.a.q2.a aVar3 = new d.a.o0.a.q2.a();
                aVar3.j(10L);
                aVar3.h(2906L);
                aVar3.c("更新DB失败");
                return aVar3;
            }
            d.a.o0.n.h.f fVar = this.m;
            if (fVar != null) {
                d.a.o0.a.h0.m.r.a.j(pMSAppInfo, fVar);
            } else if (d.a.o0.a.h0.m.r.b.f(this.n)) {
                d.a.o0.n.h.g gVar = this.n.get(0);
                this.t = gVar;
                gVar.o = this.r;
                d.a.o0.a.h0.m.r.a.k(this.q, gVar);
            } else {
                PMSAppInfo s3 = d.a.o0.n.g.a.h().s(this.r);
                if (s3 == null) {
                    d.a.o0.a.q2.a aVar4 = new d.a.o0.a.q2.a();
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
            if (d.a.o0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                d.a.o0.a.h0.m.r.a.n(this.q);
                return null;
            }
            d.a.o0.a.q2.a aVar5 = new d.a.o0.a.q2.a();
            aVar5.j(10L);
            aVar5.h(2906L);
            aVar5.c("更新DB失败");
            return aVar5;
        }
        return (d.a.o0.a.q2.a) invokeV.objValue;
    }

    @Override // d.a.o0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.s.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PMSAppInfo s2 = d.a.o0.n.g.a.h().s(this.r);
            d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + s2.createTime + " lastLaunchTime=" + s2.getLastLaunchTime() + " maxAge=" + s2.maxAge);
            if (s2 != null) {
                s2.initMaxAgeInfo();
                s2.updateInstallSrc(I());
                d.a.o0.n.h.f fVar = this.m;
                if (fVar != null) {
                    fVar.f51136c = s2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.q;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = s2.createTime;
                    pMSAppInfo.updateInstallSrc(I());
                }
                d.a.o0.n.g.a.h().k(s2);
            }
        }
    }

    @Override // d.a.o0.n.f.g
    public void F(d.a.o0.n.o.f fVar) {
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

    public f b0(d.a.o0.a.v2.e1.b<PMSAppInfo> bVar) {
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

    public synchronized f d0(d.a.o0.a.h0.m.m.a aVar) {
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
            if (TextUtils.isEmpty(this.f45468g)) {
                this.f45468g = getClass().toString();
            }
            return this.f45468g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? d.a.o0.n.f.h.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 1013) {
                d.a.o0.n.g.a.h().x(this.r, i2);
            } else {
                d.a.o0.n.g.a.h().x(this.r, 0);
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

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull d.a.o0.a.v2.e1.b<CallbackT> bVar) {
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

    public final void n0(d.a.o0.n.h.b bVar) {
        h.j<? super d.a.o0.n.h.b> jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.onNext(bVar);
        this.k.onCompleted();
    }

    public f o0(@NonNull d.a.o0.a.v2.e1.b<d.a.o0.a.h0.m.m.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            m0(this.v, new b(this, bVar));
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.f p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C : (d.a.o0.n.f.f) invokeV.objValue;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pMSAppInfo) == null) {
            o0(new d(this, pMSAppInfo));
        }
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.c<d.a.o0.n.h.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.B : (d.a.o0.n.f.c) invokeV.objValue;
    }

    public void q0(d.a.o0.a.q2.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, aVar, z) == null) {
            o0(new c(this, aVar, z));
        }
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.c<d.a.o0.n.h.d> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.A : (d.a.o0.n.f.c) invokeV.objValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.q == null) {
            return;
        }
        PMSAppInfo s2 = d.a.o0.n.g.a.h().s(this.r);
        if (s2 == null) {
            d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        s2.updateInstallSrc(I());
        this.q.copyLocalAppInfoData(s2);
        this.q.initMaxAgeInfo();
        if (d.a.o0.n.g.a.h().k(this.q)) {
            d.a.o0.a.h0.m.r.a.n(this.q);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            d.a.o0.a.e0.d.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.c<d.a.o0.n.h.f> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (d.a.o0.n.f.c) invokeV.objValue;
    }

    public abstract void t0(Throwable th);

    public d.a.o0.a.q2.a u0(d.a.o0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bVar)) == null) {
            d.a.o0.a.p0.g.a aVar = new d.a.o0.a.p0.g.a();
            aVar.f47219b = bVar.f51142i;
            aVar.f47218a = bVar.j;
            aVar.f47220c = bVar.f51134a;
            aVar.f47221d = bVar.m;
            if (d.a.o0.a.p0.b.b(bVar.f51141h, aVar) == null) {
                return null;
            }
            d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
            aVar2.j(14L);
            aVar2.b(2908L);
            aVar2.c("Extension包更新失败");
            return aVar2;
        }
        return (d.a.o0.a.q2.a) invokeL.objValue;
    }

    public d.a.o0.a.q2.a v0(d.a.o0.n.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, dVar)) == null) {
            if (E) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + dVar);
            }
            a.b c2 = d.a.o0.a.m2.f.a.c(dVar, dVar.f51141h);
            if (!TextUtils.isEmpty(dVar.f51134a)) {
                d.a.o0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dVar.f51134a);
                d.a.o0.t.d.j(dVar.f51134a);
            }
            if (c2.c()) {
                return null;
            }
            d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
            aVar.j(13L);
            aVar.b(2907L);
            aVar.c("Core包更新失败");
            return aVar;
        }
        return (d.a.o0.a.q2.a) invokeL.objValue;
    }

    public d.a.o0.a.q2.a w0(d.a.o0.n.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fVar)) == null) {
            if (fVar == null) {
                d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                aVar.j(11L);
                aVar.h(2310L);
                aVar.e("pkg info is empty");
                d.a.o0.a.q2.e.a().f(aVar);
                return aVar;
            }
            return null;
        }
        return (d.a.o0.a.q2.a) invokeL.objValue;
    }

    public void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) {
            d.a.o0.a.r1.q.a.a(this.r, str, this.s, str2);
            this.s.clear();
        }
    }

    public final void y0(d.a.o0.n.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) {
            d.a.o0.a.h0.m.c.c().d(bVar, new h(this, bVar));
        }
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.c<d.a.o0.n.h.g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.z : (d.a.o0.n.f.c) invokeV.objValue;
    }

    public final void z0(d.a.o0.n.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, dVar) == null) {
            d.a.o0.a.h0.m.c.c().d(dVar, new g(this, dVar));
        }
    }
}
