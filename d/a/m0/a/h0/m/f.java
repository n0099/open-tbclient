package d.a.m0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.a2.i;
import d.a.m0.a.h0.m.c;
import d.a.m0.a.m2.f.a;
import d.a.m0.a.v2.y0;
import h.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class f extends d.a.m0.a.h0.m.j {
    public static final boolean E = d.a.m0.a.k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.m0.n.h.f> f46117h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super d.a.m0.n.h.g> f46118i;
    public h.j<? super d.a.m0.n.h.d> j;
    public h.j<? super d.a.m0.n.h.b> k;
    public d.a.m0.n.o.f l;
    public d.a.m0.n.h.f m;
    public List<d.a.m0.n.h.g> n;
    public d.a.m0.n.h.d o;
    public d.a.m0.n.h.b p;
    public PMSAppInfo q;
    public String r;
    public d.a.m0.n.h.g t;

    /* renamed from: g  reason: collision with root package name */
    public String f46116g = "";
    public long u = -1;
    public final Set<d.a.m0.a.h0.m.m.a> v = new HashSet();
    public final Set<d.a.m0.a.v2.e1.b<PMSAppInfo>> w = new HashSet();
    public final y0 x = new y0();
    public d.a.m0.n.f.c<d.a.m0.n.h.f> y = new a();
    public d.a.m0.n.f.c<d.a.m0.n.h.g> z = new n(this);
    public d.a.m0.n.f.c<d.a.m0.n.h.d> A = new o();
    public d.a.m0.n.f.c<d.a.m0.n.h.b> B = new p();
    public d.a.m0.n.f.f C = new q();
    public h.j<d.a.m0.n.h.e> D = new i();
    public List<UbcFlowEvent> s = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.a.m0.n.f.b<d.a.m0.n.h.f> {

        /* renamed from: d.a.m0.a.h0.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0737a implements d.a.m0.a.v2.e1.b<i.a> {
            public C0737a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if ("installer_on_pump_finish".equals(aVar.f44539f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    d.a.m0.n.f.h.a(f.this, bundle, "event_performance_ubc");
                }
            }
        }

        public a() {
        }

        @Override // d.a.m0.n.f.b
        public int g() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(d.a.m0.n.h.f fVar) {
            int i2 = fVar.f51795h;
            if (i2 == 0) {
                return d.a.m0.a.h0.m.r.a.g();
            }
            if (i2 == 1) {
                return d.a.m0.a.h0.m.r.a.i();
            }
            return null;
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: o */
        public void e(d.a.m0.n.h.f fVar, d.a.m0.n.h.a aVar) {
            super.e(fVar, aVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.l.j(fVar);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f51784a);
            aVar2.c("主包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f46117h != null) {
                f.this.f46117h.onError(new PkgDownloadError(fVar, aVar2));
            }
            d.a.m0.a.h0.m.c.c().a(fVar, f.this.h0(), aVar2);
            d.a.m0.t.d.j(fVar.f51788a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(d.a.m0.n.h.f fVar) {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.m0.a.f1.g.a.d(i0).e().d(1);
            }
            super.i(fVar);
            f.this.s.add(new UbcFlowEvent("na_pms_end_download"));
            d.a.m0.a.q2.a w0 = f.this.w0(fVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f51796i);
            if (w0 == null) {
                f fVar2 = f.this;
                fVar2.m = fVar;
                fVar2.l.k(fVar);
                if (f.this.f46117h != null) {
                    f.this.f46117h.onNext(fVar);
                    if (f.E) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.f0() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.f46117h.onCompleted();
                }
                d.a.m0.a.h0.m.c.c().b(fVar, f.this.h0());
                return;
            }
            f.this.l.j(fVar);
            if (f.this.f46117h != null) {
                f.this.f46117h.onError(new PkgDownloadError(fVar, w0));
            }
            d.a.m0.a.h0.m.c.c().a(fVar, f.this.h0(), w0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void c(d.a.m0.n.h.f fVar) {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.m0.a.f1.g.a.d(i0).e().d(1);
            }
            super.c(fVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void f(d.a.m0.n.h.f fVar) {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.m0.a.f1.g.a.d(i0).e().d(1);
            }
            super.f(fVar);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": main onDownloading");
            }
            f.this.A0(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: s */
        public d.a.m0.n.h.a h(d.a.m0.n.h.f fVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.m0.a.f1.g.a.d(i0).f(fVar.toString()).d(1);
            }
            C0737a c0737a = new C0737a();
            Bundle bundle = new Bundle();
            bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
            bundle.putFloat("progress_granularity", 0.1f);
            d.a.m0.a.a1.g gVar = new d.a.m0.a.a1.g();
            gVar.v(c0737a);
            gVar.g(bundle);
            gVar.f(new d.a.m0.a.a1.f(fVar, f.this));
            gVar.f(new d.a.m0.a.a1.d(fVar.m, f.this));
            gVar.i(readableByteChannel);
            boolean j2 = gVar.j();
            gVar.p(c0737a);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": onProcessStream: installOk=" + j2);
            }
            if (j2) {
                d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                d.a.m0.t.d.K(file);
            }
            return j2 ? new d.a.m0.n.h.a(2300, "业务层处理下载流成功") : new d.a.m0.n.h.a(2301, "业务层处理下载流失败");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<d.a.m0.a.h0.m.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f46121e;

        public b(d.a.m0.a.v2.e1.b bVar) {
            this.f46121e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.h0.m.m.a aVar) {
            this.f46121e.onCallback(aVar);
            f fVar = f.this;
            fVar.e0(fVar.v, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.v2.e1.b<d.a.m0.a.h0.m.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.q2.a f46123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46124f;

        public c(f fVar, d.a.m0.a.q2.a aVar, boolean z) {
            this.f46123e = aVar;
            this.f46124f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.h0.m.m.a aVar) {
            aVar.a(this.f46123e, this.f46124f);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.v2.e1.b<d.a.m0.a.h0.m.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f46125e;

        public d(f fVar, PMSAppInfo pMSAppInfo) {
            this.f46125e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.h0.m.m.a aVar) {
            aVar.b(this.f46125e);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.InterfaceC0735c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.n.h.f f46126a;

        public e(d.a.m0.n.h.f fVar) {
            this.f46126a = fVar;
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.a.m0.n.h.f fVar2 = this.f46126a;
            fVar.m = fVar2;
            fVar.l.k(fVar2);
            if (f.this.f46117h != null) {
                f.this.f46117h.onNext(this.f46126a);
                f.this.f46117h.onCompleted();
            }
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            f.this.l.j(this.f46126a);
            if (f.this.f46117h != null) {
                f.this.f46117h.onError(new PkgDownloadError(this.f46126a, aVar));
            }
        }
    }

    /* renamed from: d.a.m0.a.h0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0738f implements c.InterfaceC0735c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.n.h.g f46128a;

        public C0738f(d.a.m0.n.h.g gVar) {
            this.f46128a = gVar;
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            d.a.m0.n.h.g gVar = this.f46128a;
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            fVar2.n.add(gVar);
            f.this.l.k(this.f46128a);
            if (f.this.f46118i != null) {
                f.this.f46118i.onNext(this.f46128a);
                if (f.this.l.g()) {
                    return;
                }
                f.this.f46118i.onCompleted();
            }
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            f.this.l.j(this.f46128a);
            if (f.this.f46118i != null) {
                f.this.f46118i.onError(new PkgDownloadError(this.f46128a, aVar));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.InterfaceC0735c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.n.h.d f46130a;

        public g(d.a.m0.n.h.d dVar) {
            this.f46130a = dVar;
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.a.m0.n.h.d dVar = this.f46130a;
            fVar.o = dVar;
            fVar.l.k(dVar);
            if (f.this.j != null) {
                f.this.j.onNext(this.f46130a);
                f.this.j.onCompleted();
            }
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            f.this.l.j(this.f46130a);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(this.f46130a, aVar));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements c.InterfaceC0735c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.n.h.b f46132a;

        public h(d.a.m0.n.h.b bVar) {
            this.f46132a = bVar;
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
            f fVar = f.this;
            d.a.m0.n.h.b bVar = this.f46132a;
            fVar.p = bVar;
            fVar.l.k(bVar);
            f.this.n0(this.f46132a);
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
            f.this.l.j(this.f46132a);
            f.this.n0(this.f46132a);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends h.j<d.a.m0.n.h.e> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.m0.n.h.e eVar) {
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 单个包下载、业务层处理完成：" + eVar.f51796i);
        }

        @Override // h.e
        public void onCompleted() {
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载onCompleted");
            f.this.s0();
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.a.m0.a.e0.d.i("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载OnError", th);
            f.this.t0(th);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements d.a<d.a.m0.n.h.f> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.m0.n.h.f> jVar) {
            f.this.f46117h = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements d.a<d.a.m0.n.h.g> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.m0.n.h.g> jVar) {
            f.this.f46118i = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements d.a<d.a.m0.n.h.d> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.m0.n.h.d> jVar) {
            f.this.j = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements d.a<d.a.m0.n.h.b> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.m0.n.h.b> jVar) {
            f.this.k = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public class n extends d.a.m0.a.h0.m.k<f> {
        public n(f fVar) {
            super(fVar);
        }

        @Override // d.a.m0.a.h0.m.k, d.a.m0.n.f.b
        public int g() {
            return f.this.g0();
        }

        @Override // d.a.m0.a.h0.m.k
        public String l() {
            return f.this.r;
        }

        @Override // d.a.m0.a.h0.m.k
        public void p(@NonNull d.a.m0.n.h.g gVar, @Nullable d.a.m0.a.q2.a aVar) {
            super.p(gVar, aVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f51796i);
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            if (aVar == null) {
                fVar2.n.add(gVar);
                f.this.l.k(gVar);
                d.a.m0.a.h0.m.c.c().b(gVar, f.this.h0());
            } else {
                fVar2.l.j(gVar);
                d.a.m0.a.h0.m.c.c().a(gVar, f.this.h0(), aVar);
            }
            if (f.this.f46118i != null) {
                f.this.f46118i.onNext(gVar);
                if (f.this.l.g()) {
                    return;
                }
                f.this.f46118i.onCompleted();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void e(d.a.m0.n.h.g gVar, d.a.m0.n.h.a aVar) {
            super.q(gVar, aVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.l.j(gVar);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f51784a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f46118i != null) {
                f.this.f46118i.onError(new PkgDownloadError(gVar, aVar2));
            }
            d.a.m0.a.h0.m.c.c().a(gVar, f.this.h0(), aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.h0.m.k, d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: s */
        public void c(d.a.m0.n.h.g gVar) {
            super.c(gVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: u */
        public void f(d.a.m0.n.h.g gVar) {
            super.f(gVar);
            f.this.B0(gVar);
        }
    }

    /* loaded from: classes3.dex */
    public class o extends d.a.m0.n.f.b<d.a.m0.n.h.d> {
        public o() {
        }

        @Override // d.a.m0.n.f.b
        public int g() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(d.a.m0.n.h.d dVar) {
            int i2 = dVar.f51795h;
            if (i2 == 0) {
                return d.a.m0.a.h0.m.r.a.h();
            }
            if (i2 == 1) {
                return d.a.m0.a.h0.m.r.a.e();
            }
            return null;
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: o */
        public void e(d.a.m0.n.h.d dVar, d.a.m0.n.h.a aVar) {
            super.e(dVar, aVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.l.j(dVar);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f51784a);
            aVar2.c("Framework包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, aVar2));
            }
            d.a.m0.a.h0.m.c.c().a(dVar, f.this.h0(), aVar2);
            d.a.m0.t.d.j(dVar.f51788a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(d.a.m0.n.h.d dVar) {
            super.i(dVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f51796i);
            d.a.m0.a.q2.a v0 = f.this.v0(dVar);
            if (v0 == null) {
                f fVar = f.this;
                fVar.o = dVar;
                fVar.l.k(dVar);
                if (f.this.j != null) {
                    f.this.j.onNext(dVar);
                    f.this.j.onCompleted();
                }
                d.a.m0.a.h0.m.c.c().b(dVar, f.this.h0());
                return;
            }
            f.this.l.j(dVar);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, v0));
            }
            d.a.m0.a.h0.m.c.c().a(dVar, f.this.h0(), v0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void c(d.a.m0.n.h.d dVar) {
            super.c(dVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void f(d.a.m0.n.h.d dVar) {
            super.f(dVar);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": framework onDownloading");
            }
            f.this.z0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public class p extends d.a.m0.n.f.b<d.a.m0.n.h.b> {
        public p() {
        }

        @Override // d.a.m0.n.f.b
        public int g() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(d.a.m0.n.h.b bVar) {
            int i2 = bVar.f51795h;
            if (i2 == 0) {
                return d.a.m0.a.h0.m.r.a.d();
            }
            if (i2 == 1) {
                return d.a.m0.a.h0.m.r.a.f();
            }
            return null;
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: o */
        public void e(d.a.m0.n.h.b bVar, d.a.m0.n.h.a aVar) {
            super.e(bVar, aVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.l.j(bVar);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(14L);
            aVar2.h(aVar.f51784a);
            aVar2.c("Extension下载失败");
            aVar2.e(aVar.toString());
            if (f.E) {
                Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
            }
            f.this.n0(bVar);
            d.a.m0.a.h0.m.c.c().a(bVar, f.this.h0(), aVar2);
            d.a.m0.t.d.j(bVar.f51788a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(d.a.m0.n.h.b bVar) {
            super.i(bVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f51796i);
            d.a.m0.a.q2.a u0 = f.this.u0(bVar);
            if (u0 != null) {
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.l.j(bVar);
                f.this.n0(bVar);
                d.a.m0.a.h0.m.c.c().a(bVar, f.this.h0(), u0);
                return;
            }
            f fVar = f.this;
            fVar.p = bVar;
            fVar.l.k(bVar);
            f.this.n0(bVar);
            d.a.m0.a.h0.m.c.c().b(bVar, f.this.h0());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void c(d.a.m0.n.h.b bVar) {
            super.c(bVar);
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void f(d.a.m0.n.h.b bVar) {
            super.f(bVar);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": extension onDownloading");
            }
            f.this.y0(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class q implements d.a.m0.n.f.f {
        public q() {
        }

        @Override // d.a.m0.n.f.f
        public void a(PMSAppInfo pMSAppInfo) {
            if (f.E) {
                Log.e("SwanAppPkgDownloadCallback", f.this.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f fVar = f.this;
            fVar.q = pMSAppInfo;
            if (pMSAppInfo != null) {
                fVar.l0(pMSAppInfo);
                d.a.m0.a.t1.g.b.k(f.this.q.pluginInfo, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements d.a.m0.a.v2.e1.b<d.a.m0.a.v2.e1.b<PMSAppInfo>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f46143e;

        public r(f fVar, PMSAppInfo pMSAppInfo) {
            this.f46143e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.v2.e1.b<PMSAppInfo> bVar) {
            bVar.onCallback(this.f46143e);
        }
    }

    /* loaded from: classes3.dex */
    public class s implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f46144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f46145f;

        public s(f fVar, Collection collection, Object obj) {
            this.f46144e = collection;
            this.f46145f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46144e.add(this.f46145f);
        }
    }

    /* loaded from: classes3.dex */
    public class t implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f46146e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f46147f;

        public t(f fVar, Collection collection, Object obj) {
            this.f46146e = collection;
            this.f46147f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46146e.remove(this.f46147f);
        }
    }

    /* loaded from: classes3.dex */
    public class u implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f46148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f46149f;

        public u(f fVar, Collection collection, d.a.m0.a.v2.e1.b bVar) {
            this.f46148e = collection;
            this.f46149f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Object obj : this.f46148e) {
                this.f46149f.onCallback(obj);
            }
        }
    }

    public f(String str) {
        this.r = str;
    }

    public final void A0(d.a.m0.n.h.f fVar) {
        d.a.m0.a.h0.m.c.c().d(fVar, new e(fVar));
    }

    @Override // d.a.m0.n.f.g
    public void B(d.a.m0.n.h.a aVar) {
        d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.f51784a == 1010) {
            D0();
        }
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void B0(d.a.m0.n.h.g gVar) {
        d.a.m0.a.h0.m.c.c().d(gVar, new C0738f(gVar));
    }

    @Override // d.a.m0.n.f.g
    public void C() {
        this.s.add(new UbcFlowEvent("na_pms_start_req"));
    }

    public d.a.m0.a.q2.a C0() {
        PMSAppInfo pMSAppInfo = this.q;
        if (pMSAppInfo == null) {
            if (this.m == null) {
                d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                aVar.j(10L);
                aVar.h(2903L);
                aVar.c("Server未返回主包&AppInfo");
                return aVar;
            }
            PMSAppInfo s2 = d.a.m0.n.g.a.h().s(this.r);
            if (s2 == null) {
                d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
                aVar2.j(10L);
                aVar2.h(2904L);
                aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                return aVar2;
            }
            this.q = s2;
            d.a.m0.a.h0.m.r.a.j(s2, this.m);
            this.q.k();
            this.q.o(I());
            if (d.a.m0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                return null;
            }
            d.a.m0.a.q2.a aVar3 = new d.a.m0.a.q2.a();
            aVar3.j(10L);
            aVar3.h(2906L);
            aVar3.c("更新DB失败");
            return aVar3;
        }
        d.a.m0.n.h.f fVar = this.m;
        if (fVar != null) {
            d.a.m0.a.h0.m.r.a.j(pMSAppInfo, fVar);
        } else if (d.a.m0.a.h0.m.r.b.f(this.n)) {
            d.a.m0.n.h.g gVar = this.n.get(0);
            this.t = gVar;
            gVar.o = this.r;
            d.a.m0.a.h0.m.r.a.k(this.q, gVar);
        } else {
            PMSAppInfo s3 = d.a.m0.n.g.a.h().s(this.r);
            if (s3 == null) {
                d.a.m0.a.q2.a aVar4 = new d.a.m0.a.q2.a();
                aVar4.j(10L);
                aVar4.h(2905L);
                aVar4.c("Server未返回包数据，本地也没有数据");
                return aVar4;
            }
            PMSAppInfo pMSAppInfo2 = this.q;
            pMSAppInfo2.appId = this.r;
            pMSAppInfo2.b(s3);
        }
        this.q.k();
        this.q.o(I());
        if (d.a.m0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
            d.a.m0.a.h0.m.r.a.n(this.q);
            return null;
        }
        d.a.m0.a.q2.a aVar5 = new d.a.m0.a.q2.a();
        aVar5.j(10L);
        aVar5.h(2906L);
        aVar5.c("更新DB失败");
        return aVar5;
    }

    @Override // d.a.m0.n.f.g
    public void D() {
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void D0() {
        PMSAppInfo s2 = d.a.m0.n.g.a.h().s(this.r);
        d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + s2.createTime + " lastLaunchTime=" + s2.g() + " maxAge=" + s2.maxAge);
        if (s2 != null) {
            s2.k();
            s2.o(I());
            d.a.m0.n.h.f fVar = this.m;
            if (fVar != null) {
                fVar.f51790c = s2.createTime;
            }
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo != null) {
                pMSAppInfo.createTime = s2.createTime;
                pMSAppInfo.o(I());
            }
            d.a.m0.n.g.a.h().k(s2);
        }
    }

    @Override // d.a.m0.n.f.g
    public void F(d.a.m0.n.o.f fVar) {
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

    public f b0(d.a.m0.a.v2.e1.b<PMSAppInfo> bVar) {
        c0(this.w, bVar);
        return this;
    }

    public final synchronized <CallbackT> f c0(Collection<CallbackT> collection, CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.x.a(new s(this, collection, callbackt));
        }
        return this;
    }

    public synchronized f d0(d.a.m0.a.h0.m.m.a aVar) {
        c0(this.v, aVar);
        return this;
    }

    public final synchronized <CallbackT> f e0(Collection<CallbackT> collection, CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.x.a(new t(this, collection, callbackt));
        }
        return this;
    }

    public String f0() {
        if (TextUtils.isEmpty(this.f46116g)) {
            this.f46116g = getClass().toString();
        }
        return this.f46116g;
    }

    public int g0() {
        return 100;
    }

    public abstract PMSDownloadType h0();

    public final String i0() {
        return d.a.m0.n.f.h.b(this, "get_launch_id").getString("launch_id", "");
    }

    public void j0(int i2) {
        if (i2 == 1013) {
            d.a.m0.n.g.a.h().x(this.r, i2);
        } else {
            d.a.m0.n.g.a.h().x(this.r, 0);
        }
    }

    public final void k0() {
        ArrayList arrayList = new ArrayList();
        if (this.l.d()) {
            arrayList.add(h.d.b(new j()));
        }
        if (this.l.f()) {
            arrayList.add(h.d.b(new k()));
        }
        if (this.l.c()) {
            arrayList.add(h.d.b(new l()));
        }
        if (this.l.b()) {
            arrayList.add(h.d.b(new m()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.d.l(arrayList).z(this.D);
    }

    public f l0(PMSAppInfo pMSAppInfo) {
        m0(this.w, new r(this, pMSAppInfo));
        return this;
    }

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull d.a.m0.a.v2.e1.b<CallbackT> bVar) {
        this.x.a(new u(this, collection, bVar));
        return this;
    }

    public final void n0(d.a.m0.n.h.b bVar) {
        h.j<? super d.a.m0.n.h.b> jVar = this.k;
        if (jVar != null) {
            jVar.onNext(bVar);
            this.k.onCompleted();
        }
    }

    public f o0(@NonNull d.a.m0.a.v2.e1.b<d.a.m0.a.h0.m.m.a> bVar) {
        m0(this.v, new b(bVar));
        return this;
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.f p() {
        return this.C;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        o0(new d(this, pMSAppInfo));
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<d.a.m0.n.h.b> q() {
        return this.B;
    }

    public void q0(d.a.m0.a.q2.a aVar, boolean z) {
        o0(new c(this, aVar, z));
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<d.a.m0.n.h.d> r() {
        return this.A;
    }

    public void r0() {
        if (this.q == null) {
            return;
        }
        PMSAppInfo s2 = d.a.m0.n.g.a.h().s(this.r);
        if (s2 == null) {
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        s2.o(I());
        this.q.b(s2);
        this.q.k();
        if (d.a.m0.n.g.a.h().k(this.q)) {
            d.a.m0.a.h0.m.r.a.n(this.q);
        }
    }

    public void s0() {
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        d.a.m0.a.e0.d.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<d.a.m0.n.h.f> t() {
        return this.y;
    }

    public abstract void t0(Throwable th);

    public d.a.m0.a.q2.a u0(d.a.m0.n.h.b bVar) {
        d.a.m0.a.p0.g.a aVar = new d.a.m0.a.p0.g.a();
        aVar.f47871b = bVar.f51796i;
        aVar.f47870a = bVar.j;
        aVar.f47872c = bVar.f51788a;
        aVar.f47873d = bVar.m;
        if (d.a.m0.a.p0.b.b(bVar.f51795h, aVar) == null) {
            return null;
        }
        d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
        aVar2.j(14L);
        aVar2.b(2908L);
        aVar2.c("Extension包更新失败");
        return aVar2;
    }

    public d.a.m0.a.q2.a v0(d.a.m0.n.h.d dVar) {
        if (E) {
            Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + dVar);
        }
        a.b c2 = d.a.m0.a.m2.f.a.c(dVar, dVar.f51795h);
        if (!TextUtils.isEmpty(dVar.f51788a)) {
            d.a.m0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dVar.f51788a);
            d.a.m0.t.d.j(dVar.f51788a);
        }
        if (c2.c()) {
            return null;
        }
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(13L);
        aVar.b(2907L);
        aVar.c("Core包更新失败");
        return aVar;
    }

    public d.a.m0.a.q2.a w0(d.a.m0.n.h.f fVar) {
        if (fVar == null) {
            d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
            aVar.j(11L);
            aVar.h(2310L);
            aVar.e("pkg info is empty");
            d.a.m0.a.q2.e.a().f(aVar);
            return aVar;
        }
        return null;
    }

    public void x0(String str, String str2) {
        d.a.m0.a.r1.q.a.a(this.r, str, this.s, str2);
        this.s.clear();
    }

    public final void y0(d.a.m0.n.h.b bVar) {
        d.a.m0.a.h0.m.c.c().d(bVar, new h(bVar));
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<d.a.m0.n.h.g> z() {
        return this.z;
    }

    public final void z0(d.a.m0.n.h.d dVar) {
        d.a.m0.a.h0.m.c.c().d(dVar, new g(dVar));
    }
}
