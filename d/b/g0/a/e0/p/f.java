package d.b.g0.a.e0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.b2.f.a;
import d.b.g0.a.e0.p.c;
import d.b.g0.a.i2.q0;
import d.b.g0.a.r1.i;
import h.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okio.BufferedSource;
/* loaded from: classes2.dex */
public abstract class f extends d.b.g0.a.e0.p.j {
    public static final boolean F = d.b.g0.a.k.f45443a;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.b.g0.l.k.f> f44545h;
    public h.j<? super d.b.g0.l.k.g> i;
    public h.j<? super d.b.g0.l.k.d> j;
    public h.j<? super d.b.g0.l.k.b> k;
    public d.b.g0.l.r.f l;
    public d.b.g0.l.k.f m;
    public List<d.b.g0.l.k.g> n;
    public d.b.g0.l.k.d o;
    public d.b.g0.l.k.b p;
    public PMSAppInfo q;
    public String r;
    public d.b.g0.l.k.g u;

    /* renamed from: g  reason: collision with root package name */
    public String f44544g = "";
    public String t = "0";
    public long v = -1;
    public final Set<d.b.g0.a.e0.p.m.a> w = new HashSet();
    public final Set<d.b.g0.a.i2.u0.b<PMSAppInfo>> x = new HashSet();
    public final q0 y = new q0();
    public d.b.g0.l.h.c<d.b.g0.l.k.f> z = new a();
    public d.b.g0.l.h.c<d.b.g0.l.k.g> A = new n(this);
    public d.b.g0.l.h.c<d.b.g0.l.k.d> B = new o();
    public d.b.g0.l.h.c<d.b.g0.l.k.b> C = new p();
    public d.b.g0.l.h.f D = new q();
    public h.j<d.b.g0.l.k.e> E = new i();
    public List<UbcFlowEvent> s = new ArrayList();

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.l.h.b<d.b.g0.l.k.f> {

        /* renamed from: d.b.g0.a.e0.p.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0682a implements d.b.g0.a.i2.u0.b<i.a> {
            public C0682a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if ("installer_on_pump_finish".equals(aVar.f46137g)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    d.b.g0.l.h.h.a(f.this, bundle, "event_performance_ubc");
                }
            }
        }

        public a() {
        }

        @Override // d.b.g0.l.h.b
        public int e() {
            return f.this.g0();
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return f.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(d.b.g0.l.k.f fVar) {
            int i = fVar.f49316h;
            if (i == 0) {
                return d.b.g0.a.e0.p.r.a.g();
            }
            if (i == 1) {
                return d.b.g0.a.e0.p.r.a.j();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(d.b.g0.l.k.f fVar, d.b.g0.l.k.a aVar) {
            super.l(fVar, aVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.l.i(fVar);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f49306a);
            aVar2.c("主包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f44545h != null) {
                f.this.f44545h.onError(new PkgDownloadError(fVar, aVar2));
            }
            d.b.g0.a.e0.p.c.c().a(fVar, f.this.h0(), aVar2);
            d.b.g0.p.d.g(fVar.f49309a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(d.b.g0.l.k.f fVar) {
            String i0 = f.this.i0();
            if (f.F) {
                d.b.g0.a.y0.g.a.d(i0).e().d(1);
            }
            super.b(fVar);
            f.this.s.add(new UbcFlowEvent("na_pms_end_download"));
            d.b.g0.a.f2.a w0 = f.this.w0(fVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.i);
            if (w0 == null) {
                f fVar2 = f.this;
                fVar2.m = fVar;
                fVar2.l.j(fVar);
                if (f.this.f44545h != null) {
                    f.this.f44545h.onNext(fVar);
                    if (f.F) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.f0() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.f44545h.onCompleted();
                }
                d.b.g0.a.e0.p.c.c().b(fVar, f.this.h0());
                return;
            }
            f.this.l.i(fVar);
            if (f.this.f44545h != null) {
                f.this.f44545h.onError(new PkgDownloadError(fVar, w0));
            }
            d.b.g0.a.e0.p.c.c().a(fVar, f.this.h0(), w0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(d.b.g0.l.k.f fVar) {
            String i0 = f.this.i0();
            if (f.F) {
                d.b.g0.a.y0.g.a.d(i0).e().d(1);
            }
            super.i(fVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void n(d.b.g0.l.k.f fVar) {
            String i0 = f.this.i0();
            if (f.F) {
                d.b.g0.a.y0.g.a.d(i0).e().d(1);
            }
            super.n(fVar);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": main onDownloading");
            }
            f.this.A0(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: s */
        public d.b.g0.l.k.a f(d.b.g0.l.k.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String i0 = f.this.i0();
            if (f.F) {
                d.b.g0.a.y0.g.a.d(i0).f(fVar.toString()).d(1);
            }
            C0682a c0682a = new C0682a();
            Bundle bundle = new Bundle();
            bundle.putLong("length", j);
            bundle.putFloat("progress_granularity", 0.1f);
            d.b.g0.a.u0.f fVar2 = new d.b.g0.a.u0.f();
            fVar2.i(c0682a);
            fVar2.f(bundle);
            fVar2.e(new d.b.g0.a.u0.e(fVar, f.this));
            fVar2.e(new d.b.g0.a.u0.c(fVar.m, f.this));
            fVar2.y(bufferedSource);
            boolean z = fVar2.z();
            fVar2.p(c0682a);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": onProcessStream: installOk=" + z);
            }
            if (z) {
                d.b.g0.p.d.f(file);
            }
            return z ? new d.b.g0.l.k.a(2300, "业务层处理下载流成功") : new d.b.g0.l.k.a(2301, "业务层处理下载流失败");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<d.b.g0.a.e0.p.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f44548e;

        public b(d.b.g0.a.i2.u0.b bVar) {
            this.f44548e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.e0.p.m.a aVar) {
            this.f44548e.onCallback(aVar);
            f fVar = f.this;
            fVar.e0(fVar.w, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.i2.u0.b<d.b.g0.a.e0.p.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.f2.a f44550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44551f;

        public c(f fVar, d.b.g0.a.f2.a aVar, boolean z) {
            this.f44550e = aVar;
            this.f44551f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.e0.p.m.a aVar) {
            aVar.a(this.f44550e, this.f44551f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.i2.u0.b<d.b.g0.a.e0.p.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44552e;

        public d(f fVar, PMSAppInfo pMSAppInfo) {
            this.f44552e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.e0.p.m.a aVar) {
            aVar.b(this.f44552e);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.InterfaceC0680c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.l.k.f f44553a;

        public e(d.b.g0.l.k.f fVar) {
            this.f44553a = fVar;
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.b.g0.l.k.f fVar2 = this.f44553a;
            fVar.m = fVar2;
            fVar.l.j(fVar2);
            if (f.this.f44545h != null) {
                f.this.f44545h.onNext(this.f44553a);
                f.this.f44545h.onCompleted();
            }
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            f.this.l.i(this.f44553a);
            if (f.this.f44545h != null) {
                f.this.f44545h.onError(new PkgDownloadError(this.f44553a, aVar));
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.p.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0683f implements c.InterfaceC0680c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.l.k.g f44555a;

        public C0683f(d.b.g0.l.k.g gVar) {
            this.f44555a = gVar;
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            d.b.g0.l.k.g gVar = this.f44555a;
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            fVar2.n.add(gVar);
            f.this.l.j(this.f44555a);
            if (f.this.i != null) {
                f.this.i.onNext(this.f44555a);
                if (f.this.l.g()) {
                    return;
                }
                f.this.i.onCompleted();
            }
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            f.this.l.i(this.f44555a);
            if (f.this.i != null) {
                f.this.i.onError(new PkgDownloadError(this.f44555a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.InterfaceC0680c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.l.k.d f44557a;

        public g(d.b.g0.l.k.d dVar) {
            this.f44557a = dVar;
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.b.g0.l.k.d dVar = this.f44557a;
            fVar.o = dVar;
            fVar.l.j(dVar);
            if (f.this.j != null) {
                f.this.j.onNext(this.f44557a);
                f.this.j.onCompleted();
            }
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            f.this.l.i(this.f44557a);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(this.f44557a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.InterfaceC0680c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.l.k.b f44559a;

        public h(d.b.g0.l.k.b bVar) {
            this.f44559a = bVar;
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void a(PMSDownloadType pMSDownloadType) {
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
            f fVar = f.this;
            d.b.g0.l.k.b bVar = this.f44559a;
            fVar.p = bVar;
            fVar.l.j(bVar);
            f.this.n0(this.f44559a);
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
            f.this.l.i(this.f44559a);
            f.this.n0(this.f44559a);
        }
    }

    /* loaded from: classes2.dex */
    public class i extends h.j<d.b.g0.l.k.e> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.b.g0.l.k.e eVar) {
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 单个包下载、业务层处理完成：" + eVar.i);
        }

        @Override // h.e
        public void onCompleted() {
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载onCompleted");
            f.this.s0();
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.b.g0.a.c0.c.i("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载OnError", th);
            f.this.t0(th);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements d.a<d.b.g0.l.k.f> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.b.g0.l.k.f> jVar) {
            f.this.f44545h = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements d.a<d.b.g0.l.k.g> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.b.g0.l.k.g> jVar) {
            f.this.i = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class l implements d.a<d.b.g0.l.k.d> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.b.g0.l.k.d> jVar) {
            f.this.j = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class m implements d.a<d.b.g0.l.k.b> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.b.g0.l.k.b> jVar) {
            f.this.k = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class n extends d.b.g0.a.e0.p.k<f> {
        public n(f fVar) {
            super(fVar);
        }

        @Override // d.b.g0.a.e0.p.k, d.b.g0.l.h.b
        public int e() {
            return f.this.g0();
        }

        @Override // d.b.g0.a.e0.p.k
        public String m() {
            return f.this.r;
        }

        @Override // d.b.g0.a.e0.p.k
        public void p(@NonNull d.b.g0.l.k.g gVar, @Nullable d.b.g0.a.f2.a aVar) {
            super.p(gVar, aVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.i);
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            if (aVar == null) {
                fVar2.n.add(gVar);
                f.this.l.j(gVar);
                d.b.g0.a.e0.p.c.c().b(gVar, f.this.h0());
            } else {
                fVar2.l.i(gVar);
                d.b.g0.a.e0.p.c.c().a(gVar, f.this.h0(), aVar);
            }
            if (f.this.i != null) {
                f.this.i.onNext(gVar);
                if (f.this.l.g()) {
                    return;
                }
                f.this.i.onCompleted();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.e0.p.k, d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void l(d.b.g0.l.k.g gVar, d.b.g0.l.k.a aVar) {
            super.l(gVar, aVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.l.i(gVar);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f49306a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.i != null) {
                f.this.i.onError(new PkgDownloadError(gVar, aVar2));
            }
            d.b.g0.a.e0.p.c.c().a(gVar, f.this.h0(), aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.e0.p.k, d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: s */
        public void i(d.b.g0.l.k.g gVar) {
            super.i(gVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: u */
        public void n(d.b.g0.l.k.g gVar) {
            super.n(gVar);
            f.this.B0(gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class o extends d.b.g0.l.h.b<d.b.g0.l.k.d> {
        public o() {
        }

        @Override // d.b.g0.l.h.b
        public int e() {
            return f.this.g0();
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return f.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(d.b.g0.l.k.d dVar) {
            int i = dVar.f49316h;
            if (i == 0) {
                return d.b.g0.a.e0.p.r.a.h();
            }
            if (i == 1) {
                return d.b.g0.a.e0.p.r.a.e();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(d.b.g0.l.k.d dVar, d.b.g0.l.k.a aVar) {
            super.l(dVar, aVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.l.i(dVar);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f49306a);
            aVar2.c("Framework包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, aVar2));
            }
            d.b.g0.a.e0.p.c.c().a(dVar, f.this.h0(), aVar2);
            d.b.g0.p.d.g(dVar.f49309a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(d.b.g0.l.k.d dVar) {
            super.b(dVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.i);
            d.b.g0.a.f2.a v0 = f.this.v0(dVar);
            if (v0 == null) {
                f fVar = f.this;
                fVar.o = dVar;
                fVar.l.j(dVar);
                if (f.this.j != null) {
                    f.this.j.onNext(dVar);
                    f.this.j.onCompleted();
                }
                d.b.g0.a.e0.p.c.c().b(dVar, f.this.h0());
                return;
            }
            f.this.l.i(dVar);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, v0));
            }
            d.b.g0.a.e0.p.c.c().a(dVar, f.this.h0(), v0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(d.b.g0.l.k.d dVar) {
            super.i(dVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void n(d.b.g0.l.k.d dVar) {
            super.n(dVar);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": framework onDownloading");
            }
            f.this.z0(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class p extends d.b.g0.l.h.b<d.b.g0.l.k.b> {
        public p() {
        }

        @Override // d.b.g0.l.h.b
        public int e() {
            return f.this.g0();
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return f.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(d.b.g0.l.k.b bVar) {
            int i = bVar.f49316h;
            if (i == 0) {
                return d.b.g0.a.e0.p.r.a.d();
            }
            if (i == 1) {
                return d.b.g0.a.e0.p.r.a.f();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(d.b.g0.l.k.b bVar, d.b.g0.l.k.a aVar) {
            super.l(bVar, aVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.l.i(bVar);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(14L);
            aVar2.h(aVar.f49306a);
            aVar2.c("Extension下载失败");
            aVar2.e(aVar.toString());
            if (f.F) {
                Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
            }
            f.this.n0(bVar);
            d.b.g0.a.e0.p.c.c().a(bVar, f.this.h0(), aVar2);
            d.b.g0.p.d.g(bVar.f49309a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(d.b.g0.l.k.b bVar) {
            super.b(bVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.i);
            d.b.g0.a.f2.a u0 = f.this.u0(bVar);
            if (u0 != null) {
                if (f.F) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.l.i(bVar);
                f.this.n0(bVar);
                d.b.g0.a.e0.p.c.c().a(bVar, f.this.h0(), u0);
                return;
            }
            f fVar = f.this;
            fVar.p = bVar;
            fVar.l.j(bVar);
            f.this.n0(bVar);
            d.b.g0.a.e0.p.c.c().b(bVar, f.this.h0());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(d.b.g0.l.k.b bVar) {
            super.i(bVar);
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void n(d.b.g0.l.k.b bVar) {
            super.n(bVar);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": extension onDownloading");
            }
            f.this.y0(bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class q implements d.b.g0.l.h.f {
        public q() {
        }

        @Override // d.b.g0.l.h.f
        public void a(PMSAppInfo pMSAppInfo) {
            if (f.F) {
                Log.e("SwanAppPkgDownloadCallback", f.this.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f fVar = f.this;
            fVar.q = pMSAppInfo;
            if (pMSAppInfo != null) {
                fVar.l0(pMSAppInfo);
                d.b.g0.a.l1.g.b.j(f.this.q.pluginInfo, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class r implements d.b.g0.a.i2.u0.b<d.b.g0.a.i2.u0.b<PMSAppInfo>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44570e;

        public r(f fVar, PMSAppInfo pMSAppInfo) {
            this.f44570e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.i2.u0.b<PMSAppInfo> bVar) {
            bVar.onCallback(this.f44570e);
        }
    }

    /* loaded from: classes2.dex */
    public class s implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f44571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f44572f;

        public s(f fVar, Collection collection, Object obj) {
            this.f44571e = collection;
            this.f44572f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44571e.add(this.f44572f);
        }
    }

    /* loaded from: classes2.dex */
    public class t implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f44573e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f44574f;

        public t(f fVar, Collection collection, Object obj) {
            this.f44573e = collection;
            this.f44574f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44573e.remove(this.f44574f);
        }
    }

    /* loaded from: classes2.dex */
    public class u implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f44575e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f44576f;

        public u(f fVar, Collection collection, d.b.g0.a.i2.u0.b bVar) {
            this.f44575e = collection;
            this.f44576f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Object obj : this.f44575e) {
                this.f44576f.onCallback(obj);
            }
        }
    }

    public f(String str) {
        this.r = str;
    }

    public final void A0(d.b.g0.l.k.f fVar) {
        d.b.g0.a.e0.p.c.c().d(fVar, new e(fVar));
    }

    @Override // d.b.g0.l.h.g
    public void B(d.b.g0.l.k.a aVar) {
        d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.f49306a == 1010) {
            D0();
        }
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void B0(d.b.g0.l.k.g gVar) {
        d.b.g0.a.e0.p.c.c().d(gVar, new C0683f(gVar));
    }

    @Override // d.b.g0.l.h.g
    public void C() {
        this.s.add(new UbcFlowEvent("na_pms_start_req"));
    }

    public d.b.g0.a.f2.a C0() {
        PMSAppInfo pMSAppInfo = this.q;
        if (pMSAppInfo == null) {
            if (this.m == null) {
                d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                aVar.j(10L);
                aVar.h(2903L);
                aVar.c("Server未返回主包&AppInfo");
                return aVar;
            }
            PMSAppInfo r2 = d.b.g0.l.i.a.h().r(this.r);
            if (r2 == null) {
                d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
                aVar2.j(10L);
                aVar2.h(2904L);
                aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                return aVar2;
            }
            this.q = r2;
            d.b.g0.a.e0.p.r.a.k(r2, this.m);
            this.q.k();
            this.q.n(I());
            if (d.b.g0.l.i.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                return null;
            }
            d.b.g0.a.f2.a aVar3 = new d.b.g0.a.f2.a();
            aVar3.j(10L);
            aVar3.h(2906L);
            aVar3.c("更新DB失败");
            return aVar3;
        }
        d.b.g0.l.k.f fVar = this.m;
        if (fVar != null) {
            d.b.g0.a.e0.p.r.a.k(pMSAppInfo, fVar);
        } else if (d.b.g0.a.e0.p.r.b.f(this.n)) {
            d.b.g0.l.k.g gVar = this.n.get(0);
            this.u = gVar;
            gVar.o = this.r;
            d.b.g0.a.e0.p.r.a.l(this.q, gVar);
        } else {
            PMSAppInfo r3 = d.b.g0.l.i.a.h().r(this.r);
            if (r3 == null) {
                d.b.g0.a.f2.a aVar4 = new d.b.g0.a.f2.a();
                aVar4.j(10L);
                aVar4.h(2905L);
                aVar4.c("Server未返回包数据，本地也没有数据");
                return aVar4;
            }
            PMSAppInfo pMSAppInfo2 = this.q;
            pMSAppInfo2.appId = this.r;
            pMSAppInfo2.b(r3);
        }
        this.q.k();
        this.q.n(I());
        if (d.b.g0.l.i.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
            d.b.g0.a.e0.p.r.a.o(this.q);
            return null;
        }
        d.b.g0.a.f2.a aVar5 = new d.b.g0.a.f2.a();
        aVar5.j(10L);
        aVar5.h(2906L);
        aVar5.c("更新DB失败");
        return aVar5;
    }

    @Override // d.b.g0.l.h.g
    public void D() {
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void D0() {
        PMSAppInfo r2 = d.b.g0.l.i.a.h().r(this.r);
        d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + r2.createTime + " lastLaunchTime=" + r2.g() + " maxAge=" + r2.maxAge);
        if (r2 != null) {
            r2.k();
            r2.n(I());
            d.b.g0.l.k.f fVar = this.m;
            if (fVar != null) {
                fVar.f49311c = r2.createTime;
            }
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo != null) {
                pMSAppInfo.createTime = r2.createTime;
                pMSAppInfo.n(I());
            }
            d.b.g0.l.i.a.h().k(r2);
        }
    }

    @Override // d.b.g0.l.h.g
    public void F(d.b.g0.l.r.f fVar) {
        super.F(fVar);
        this.v = System.currentTimeMillis();
        if (F) {
            Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.v);
        }
        if (fVar == null) {
            return;
        }
        if (F) {
            Log.i("SwanAppPkgDownloadCallback", f0() + ": onPrepareDownload: countSet=" + fVar.k());
        }
        this.s.add(new UbcFlowEvent("na_pms_start_download"));
        this.l = fVar;
        if (fVar.h()) {
            return;
        }
        k0();
    }

    public f b0(d.b.g0.a.i2.u0.b<PMSAppInfo> bVar) {
        c0(this.x, bVar);
        return this;
    }

    public final synchronized <CallbackT> f c0(Collection<CallbackT> collection, CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.y.e(new s(this, collection, callbackt));
        }
        return this;
    }

    public synchronized f d0(d.b.g0.a.e0.p.m.a aVar) {
        c0(this.w, aVar);
        return this;
    }

    public final synchronized <CallbackT> f e0(Collection<CallbackT> collection, CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.y.e(new t(this, collection, callbackt));
        }
        return this;
    }

    public String f0() {
        if (TextUtils.isEmpty(this.f44544g)) {
            this.f44544g = getClass().toString();
        }
        return this.f44544g;
    }

    public int g0() {
        return 100;
    }

    public abstract PMSDownloadType h0();

    public final String i0() {
        return d.b.g0.l.h.h.b(this, "get_launch_id").getString("launch_id", "");
    }

    public void j0(int i2) {
        if (i2 == 1013) {
            d.b.g0.l.i.a.h().v(this.r, i2);
        } else {
            d.b.g0.l.i.a.h().v(this.r, 0);
        }
    }

    public final void k0() {
        ArrayList arrayList = new ArrayList();
        if (this.l.d()) {
            arrayList.add(h.d.c(new j()));
        }
        if (this.l.f()) {
            arrayList.add(h.d.c(new k()));
        }
        if (this.l.c()) {
            arrayList.add(h.d.c(new l()));
        }
        if (this.l.b()) {
            arrayList.add(h.d.c(new m()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.d.m(arrayList).B(this.E);
    }

    public f l0(PMSAppInfo pMSAppInfo) {
        m0(this.x, new r(this, pMSAppInfo));
        return this;
    }

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull d.b.g0.a.i2.u0.b<CallbackT> bVar) {
        this.y.e(new u(this, collection, bVar));
        return this;
    }

    public final void n0(d.b.g0.l.k.b bVar) {
        h.j<? super d.b.g0.l.k.b> jVar = this.k;
        if (jVar != null) {
            jVar.onNext(bVar);
            this.k.onCompleted();
        }
    }

    public f o0(@NonNull d.b.g0.a.i2.u0.b<d.b.g0.a.e0.p.m.a> bVar) {
        m0(this.w, new b(bVar));
        return this;
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.f p() {
        return this.D;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        o0(new d(this, pMSAppInfo));
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.b> q() {
        return this.C;
    }

    public void q0(d.b.g0.a.f2.a aVar, boolean z) {
        o0(new c(this, aVar, z));
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.d> r() {
        return this.B;
    }

    public void r0() {
        if (this.q == null) {
            return;
        }
        PMSAppInfo r2 = d.b.g0.l.i.a.h().r(this.r);
        if (r2 == null) {
            d.b.g0.a.c0.c.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        r2.n(I());
        this.q.b(r2);
        this.q.k();
        if (d.b.g0.l.i.a.h().k(this.q)) {
            d.b.g0.a.e0.p.r.a.o(this.q);
        }
    }

    public void s0() {
        long currentTimeMillis = System.currentTimeMillis() - this.v;
        d.b.g0.a.c0.c.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.f> t() {
        return this.z;
    }

    public abstract void t0(Throwable th);

    public d.b.g0.a.f2.a u0(d.b.g0.l.k.b bVar) {
        d.b.g0.a.l0.h.a aVar = new d.b.g0.a.l0.h.a();
        aVar.f45546a = bVar.j;
        aVar.f45547b = bVar.f49309a;
        aVar.f45548c = bVar.m;
        if (d.b.g0.a.l0.b.a(bVar.f49316h, aVar) == null) {
            return null;
        }
        d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
        aVar2.j(14L);
        aVar2.b(2908L);
        aVar2.c("Extension包更新失败");
        return aVar2;
    }

    public d.b.g0.a.f2.a v0(d.b.g0.l.k.d dVar) {
        a.b c2 = d.b.g0.a.b2.f.a.c(dVar.j, dVar.f49309a, dVar.m, dVar.f49316h);
        if (!TextUtils.isEmpty(dVar.f49309a)) {
            d.b.g0.p.d.g(dVar.f49309a);
        }
        if (c2.c()) {
            return null;
        }
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(13L);
        aVar.b(2907L);
        aVar.c("Core包更新失败");
        return aVar;
    }

    public d.b.g0.a.f2.a w0(d.b.g0.l.k.f fVar) {
        if (fVar == null) {
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(11L);
            aVar.h(2310L);
            aVar.e("pkg info is empty");
            d.b.g0.a.f2.e.a().f(aVar);
            return aVar;
        }
        return null;
    }

    public void x0(String str, String str2) {
        d.b.g0.a.j1.q.a.a(this.r, str, this.s, str2);
        this.s.clear();
    }

    public final void y0(d.b.g0.l.k.b bVar) {
        d.b.g0.a.e0.p.c.c().d(bVar, new h(bVar));
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.g> z() {
        return this.A;
    }

    public final void z0(d.b.g0.l.k.d dVar) {
        d.b.g0.a.e0.p.c.c().d(dVar, new g(dVar));
    }
}
