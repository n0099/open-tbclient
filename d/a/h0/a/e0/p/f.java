package d.a.h0.a.e0.p;

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
import d.a.h0.a.b2.f.a;
import d.a.h0.a.e0.p.c;
import d.a.h0.a.i2.q0;
import d.a.h0.a.r1.i;
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
public abstract class f extends d.a.h0.a.e0.p.j {
    public static final boolean F = d.a.h0.a.k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.h0.l.k.f> f42176h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super d.a.h0.l.k.g> f42177i;
    public h.j<? super d.a.h0.l.k.d> j;
    public h.j<? super d.a.h0.l.k.b> k;
    public d.a.h0.l.r.f l;
    public d.a.h0.l.k.f m;
    public List<d.a.h0.l.k.g> n;
    public d.a.h0.l.k.d o;
    public d.a.h0.l.k.b p;
    public PMSAppInfo q;
    public String r;
    public d.a.h0.l.k.g u;

    /* renamed from: g  reason: collision with root package name */
    public String f42175g = "";
    public String t = "0";
    public long v = -1;
    public final Set<d.a.h0.a.e0.p.m.a> w = new HashSet();
    public final Set<d.a.h0.a.i2.u0.b<PMSAppInfo>> x = new HashSet();
    public final q0 y = new q0();
    public d.a.h0.l.h.c<d.a.h0.l.k.f> z = new a();
    public d.a.h0.l.h.c<d.a.h0.l.k.g> A = new n(this);
    public d.a.h0.l.h.c<d.a.h0.l.k.d> B = new o();
    public d.a.h0.l.h.c<d.a.h0.l.k.b> C = new p();
    public d.a.h0.l.h.f D = new q();
    public h.j<d.a.h0.l.k.e> E = new i();
    public List<UbcFlowEvent> s = new ArrayList();

    /* loaded from: classes2.dex */
    public class a extends d.a.h0.l.h.b<d.a.h0.l.k.f> {

        /* renamed from: d.a.h0.a.e0.p.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0641a implements d.a.h0.a.i2.u0.b<i.a> {
            public C0641a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if ("installer_on_pump_finish".equals(aVar.f43829g)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    d.a.h0.l.h.h.a(f.this, bundle, "event_performance_ubc");
                }
            }
        }

        public a() {
        }

        @Override // d.a.h0.l.h.b
        public int h() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(d.a.h0.l.k.f fVar) {
            int i2 = fVar.f47154h;
            if (i2 == 0) {
                return d.a.h0.a.e0.p.r.a.g();
            }
            if (i2 == 1) {
                return d.a.h0.a.e0.p.r.a.j();
            }
            return null;
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(d.a.h0.l.k.f fVar, d.a.h0.l.k.a aVar) {
            super.f(fVar, aVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.l.i(fVar);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f47144a);
            aVar2.c("主包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f42176h != null) {
                f.this.f42176h.onError(new PkgDownloadError(fVar, aVar2));
            }
            d.a.h0.a.e0.p.c.c().a(fVar, f.this.h0(), aVar2);
            d.a.h0.p.d.g(fVar.f47147a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(d.a.h0.l.k.f fVar) {
            String i0 = f.this.i0();
            if (f.F) {
                d.a.h0.a.y0.g.a.d(i0).e().d(1);
            }
            super.i(fVar);
            f.this.s.add(new UbcFlowEvent("na_pms_end_download"));
            d.a.h0.a.f2.a w0 = f.this.w0(fVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f47155i);
            if (w0 == null) {
                f fVar2 = f.this;
                fVar2.m = fVar;
                fVar2.l.j(fVar);
                if (f.this.f42176h != null) {
                    f.this.f42176h.onNext(fVar);
                    if (f.F) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.f0() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.f42176h.onCompleted();
                }
                d.a.h0.a.e0.p.c.c().b(fVar, f.this.h0());
                return;
            }
            f.this.l.i(fVar);
            if (f.this.f42176h != null) {
                f.this.f42176h.onError(new PkgDownloadError(fVar, w0));
            }
            d.a.h0.a.e0.p.c.c().a(fVar, f.this.h0(), w0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void d(d.a.h0.l.k.f fVar) {
            String i0 = f.this.i0();
            if (f.F) {
                d.a.h0.a.y0.g.a.d(i0).e().d(1);
            }
            super.d(fVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(d.a.h0.l.k.f fVar) {
            String i0 = f.this.i0();
            if (f.F) {
                d.a.h0.a.y0.g.a.d(i0).e().d(1);
            }
            super.g(fVar);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": main onDownloading");
            }
            f.this.A0(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: s */
        public d.a.h0.l.k.a b(d.a.h0.l.k.f fVar, BufferedSource bufferedSource, File file, long j) throws IOException {
            String i0 = f.this.i0();
            if (f.F) {
                d.a.h0.a.y0.g.a.d(i0).f(fVar.toString()).d(1);
            }
            C0641a c0641a = new C0641a();
            Bundle bundle = new Bundle();
            bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
            bundle.putFloat("progress_granularity", 0.1f);
            d.a.h0.a.u0.f fVar2 = new d.a.h0.a.u0.f();
            fVar2.t(c0641a);
            fVar2.f(bundle);
            fVar2.e(new d.a.h0.a.u0.e(fVar, f.this));
            fVar2.e(new d.a.h0.a.u0.c(fVar.m, f.this));
            fVar2.h(bufferedSource);
            boolean i2 = fVar2.i();
            fVar2.n(c0641a);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": onProcessStream: installOk=" + i2);
            }
            if (i2) {
                d.a.h0.p.d.f(file);
            }
            return i2 ? new d.a.h0.l.k.a(2300, "业务层处理下载流成功") : new d.a.h0.l.k.a(2301, "业务层处理下载流失败");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.e0.p.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f42180e;

        public b(d.a.h0.a.i2.u0.b bVar) {
            this.f42180e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.e0.p.m.a aVar) {
            this.f42180e.onCallback(aVar);
            f fVar = f.this;
            fVar.e0(fVar.w, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.i2.u0.b<d.a.h0.a.e0.p.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.f2.a f42182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f42183f;

        public c(f fVar, d.a.h0.a.f2.a aVar, boolean z) {
            this.f42182e = aVar;
            this.f42183f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.e0.p.m.a aVar) {
            aVar.a(this.f42182e, this.f42183f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.h0.a.i2.u0.b<d.a.h0.a.e0.p.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42184e;

        public d(f fVar, PMSAppInfo pMSAppInfo) {
            this.f42184e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.e0.p.m.a aVar) {
            aVar.b(this.f42184e);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.InterfaceC0639c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.l.k.f f42185a;

        public e(d.a.h0.l.k.f fVar) {
            this.f42185a = fVar;
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.a.h0.l.k.f fVar2 = this.f42185a;
            fVar.m = fVar2;
            fVar.l.j(fVar2);
            if (f.this.f42176h != null) {
                f.this.f42176h.onNext(this.f42185a);
                f.this.f42176h.onCompleted();
            }
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            f.this.l.i(this.f42185a);
            if (f.this.f42176h != null) {
                f.this.f42176h.onError(new PkgDownloadError(this.f42185a, aVar));
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.p.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0642f implements c.InterfaceC0639c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.l.k.g f42187a;

        public C0642f(d.a.h0.l.k.g gVar) {
            this.f42187a = gVar;
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            d.a.h0.l.k.g gVar = this.f42187a;
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            fVar2.n.add(gVar);
            f.this.l.j(this.f42187a);
            if (f.this.f42177i != null) {
                f.this.f42177i.onNext(this.f42187a);
                if (f.this.l.g()) {
                    return;
                }
                f.this.f42177i.onCompleted();
            }
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            f.this.l.i(this.f42187a);
            if (f.this.f42177i != null) {
                f.this.f42177i.onError(new PkgDownloadError(this.f42187a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.InterfaceC0639c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.l.k.d f42189a;

        public g(d.a.h0.l.k.d dVar) {
            this.f42189a = dVar;
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.a.h0.l.k.d dVar = this.f42189a;
            fVar.o = dVar;
            fVar.l.j(dVar);
            if (f.this.j != null) {
                f.this.j.onNext(this.f42189a);
                f.this.j.onCompleted();
            }
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            f.this.l.i(this.f42189a);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(this.f42189a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.InterfaceC0639c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.l.k.b f42191a;

        public h(d.a.h0.l.k.b bVar) {
            this.f42191a = bVar;
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
            f fVar = f.this;
            d.a.h0.l.k.b bVar = this.f42191a;
            fVar.p = bVar;
            fVar.l.j(bVar);
            f.this.n0(this.f42191a);
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
            f.this.l.i(this.f42191a);
            f.this.n0(this.f42191a);
        }
    }

    /* loaded from: classes2.dex */
    public class i extends h.j<d.a.h0.l.k.e> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.h0.l.k.e eVar) {
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 单个包下载、业务层处理完成：" + eVar.f47155i);
        }

        @Override // h.e
        public void onCompleted() {
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载onCompleted");
            f.this.s0();
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.a.h0.a.c0.c.i("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载OnError", th);
            f.this.t0(th);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements d.a<d.a.h0.l.k.f> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.h0.l.k.f> jVar) {
            f.this.f42176h = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements d.a<d.a.h0.l.k.g> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.h0.l.k.g> jVar) {
            f.this.f42177i = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class l implements d.a<d.a.h0.l.k.d> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.h0.l.k.d> jVar) {
            f.this.j = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class m implements d.a<d.a.h0.l.k.b> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.h0.l.k.b> jVar) {
            f.this.k = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class n extends d.a.h0.a.e0.p.k<f> {
        public n(f fVar) {
            super(fVar);
        }

        @Override // d.a.h0.a.e0.p.k, d.a.h0.l.h.b
        public int h() {
            return f.this.g0();
        }

        @Override // d.a.h0.a.e0.p.k
        public String l() {
            return f.this.r;
        }

        @Override // d.a.h0.a.e0.p.k
        public void p(@NonNull d.a.h0.l.k.g gVar, @Nullable d.a.h0.a.f2.a aVar) {
            super.p(gVar, aVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f47155i);
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            if (aVar == null) {
                fVar2.n.add(gVar);
                f.this.l.j(gVar);
                d.a.h0.a.e0.p.c.c().b(gVar, f.this.h0());
            } else {
                fVar2.l.i(gVar);
                d.a.h0.a.e0.p.c.c().a(gVar, f.this.h0(), aVar);
            }
            if (f.this.f42177i != null) {
                f.this.f42177i.onNext(gVar);
                if (f.this.l.g()) {
                    return;
                }
                f.this.f42177i.onCompleted();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.e0.p.k, d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void f(d.a.h0.l.k.g gVar, d.a.h0.l.k.a aVar) {
            super.f(gVar, aVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.l.i(gVar);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f47144a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f42177i != null) {
                f.this.f42177i.onError(new PkgDownloadError(gVar, aVar2));
            }
            d.a.h0.a.e0.p.c.c().a(gVar, f.this.h0(), aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.e0.p.k, d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: s */
        public void d(d.a.h0.l.k.g gVar) {
            super.d(gVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: u */
        public void g(d.a.h0.l.k.g gVar) {
            super.g(gVar);
            f.this.B0(gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class o extends d.a.h0.l.h.b<d.a.h0.l.k.d> {
        public o() {
        }

        @Override // d.a.h0.l.h.b
        public int h() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(d.a.h0.l.k.d dVar) {
            int i2 = dVar.f47154h;
            if (i2 == 0) {
                return d.a.h0.a.e0.p.r.a.h();
            }
            if (i2 == 1) {
                return d.a.h0.a.e0.p.r.a.e();
            }
            return null;
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(d.a.h0.l.k.d dVar, d.a.h0.l.k.a aVar) {
            super.f(dVar, aVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.l.i(dVar);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f47144a);
            aVar2.c("Framework包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, aVar2));
            }
            d.a.h0.a.e0.p.c.c().a(dVar, f.this.h0(), aVar2);
            d.a.h0.p.d.g(dVar.f47147a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(d.a.h0.l.k.d dVar) {
            super.i(dVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f47155i);
            d.a.h0.a.f2.a v0 = f.this.v0(dVar);
            if (v0 == null) {
                f fVar = f.this;
                fVar.o = dVar;
                fVar.l.j(dVar);
                if (f.this.j != null) {
                    f.this.j.onNext(dVar);
                    f.this.j.onCompleted();
                }
                d.a.h0.a.e0.p.c.c().b(dVar, f.this.h0());
                return;
            }
            f.this.l.i(dVar);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, v0));
            }
            d.a.h0.a.e0.p.c.c().a(dVar, f.this.h0(), v0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void d(d.a.h0.l.k.d dVar) {
            super.d(dVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(d.a.h0.l.k.d dVar) {
            super.g(dVar);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": framework onDownloading");
            }
            f.this.z0(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class p extends d.a.h0.l.h.b<d.a.h0.l.k.b> {
        public p() {
        }

        @Override // d.a.h0.l.h.b
        public int h() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(d.a.h0.l.k.b bVar) {
            int i2 = bVar.f47154h;
            if (i2 == 0) {
                return d.a.h0.a.e0.p.r.a.d();
            }
            if (i2 == 1) {
                return d.a.h0.a.e0.p.r.a.f();
            }
            return null;
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(d.a.h0.l.k.b bVar, d.a.h0.l.k.a aVar) {
            super.f(bVar, aVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.l.i(bVar);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(14L);
            aVar2.h(aVar.f47144a);
            aVar2.c("Extension下载失败");
            aVar2.e(aVar.toString());
            if (f.F) {
                Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
            }
            f.this.n0(bVar);
            d.a.h0.a.e0.p.c.c().a(bVar, f.this.h0(), aVar2);
            d.a.h0.p.d.g(bVar.f47147a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(d.a.h0.l.k.b bVar) {
            super.i(bVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f47155i);
            d.a.h0.a.f2.a u0 = f.this.u0(bVar);
            if (u0 != null) {
                if (f.F) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.l.i(bVar);
                f.this.n0(bVar);
                d.a.h0.a.e0.p.c.c().a(bVar, f.this.h0(), u0);
                return;
            }
            f fVar = f.this;
            fVar.p = bVar;
            fVar.l.j(bVar);
            f.this.n0(bVar);
            d.a.h0.a.e0.p.c.c().b(bVar, f.this.h0());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void d(d.a.h0.l.k.b bVar) {
            super.d(bVar);
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(d.a.h0.l.k.b bVar) {
            super.g(bVar);
            if (f.F) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": extension onDownloading");
            }
            f.this.y0(bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class q implements d.a.h0.l.h.f {
        public q() {
        }

        @Override // d.a.h0.l.h.f
        public void a(PMSAppInfo pMSAppInfo) {
            if (f.F) {
                Log.e("SwanAppPkgDownloadCallback", f.this.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f fVar = f.this;
            fVar.q = pMSAppInfo;
            if (pMSAppInfo != null) {
                fVar.l0(pMSAppInfo);
                d.a.h0.a.l1.g.b.j(f.this.q.pluginInfo, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class r implements d.a.h0.a.i2.u0.b<d.a.h0.a.i2.u0.b<PMSAppInfo>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42202e;

        public r(f fVar, PMSAppInfo pMSAppInfo) {
            this.f42202e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.i2.u0.b<PMSAppInfo> bVar) {
            bVar.onCallback(this.f42202e);
        }
    }

    /* loaded from: classes2.dex */
    public class s implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f42203e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42204f;

        public s(f fVar, Collection collection, Object obj) {
            this.f42203e = collection;
            this.f42204f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42203e.add(this.f42204f);
        }
    }

    /* loaded from: classes2.dex */
    public class t implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f42205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42206f;

        public t(f fVar, Collection collection, Object obj) {
            this.f42205e = collection;
            this.f42206f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42205e.remove(this.f42206f);
        }
    }

    /* loaded from: classes2.dex */
    public class u implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f42207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f42208f;

        public u(f fVar, Collection collection, d.a.h0.a.i2.u0.b bVar) {
            this.f42207e = collection;
            this.f42208f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Object obj : this.f42207e) {
                this.f42208f.onCallback(obj);
            }
        }
    }

    public f(String str) {
        this.r = str;
    }

    public final void A0(d.a.h0.l.k.f fVar) {
        d.a.h0.a.e0.p.c.c().d(fVar, new e(fVar));
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.f47144a == 1010) {
            D0();
        }
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void B0(d.a.h0.l.k.g gVar) {
        d.a.h0.a.e0.p.c.c().d(gVar, new C0642f(gVar));
    }

    @Override // d.a.h0.l.h.g
    public void C() {
        this.s.add(new UbcFlowEvent("na_pms_start_req"));
    }

    public d.a.h0.a.f2.a C0() {
        PMSAppInfo pMSAppInfo = this.q;
        if (pMSAppInfo == null) {
            if (this.m == null) {
                d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
                aVar.j(10L);
                aVar.h(2903L);
                aVar.c("Server未返回主包&AppInfo");
                return aVar;
            }
            PMSAppInfo r2 = d.a.h0.l.i.a.h().r(this.r);
            if (r2 == null) {
                d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
                aVar2.j(10L);
                aVar2.h(2904L);
                aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                return aVar2;
            }
            this.q = r2;
            d.a.h0.a.e0.p.r.a.k(r2, this.m);
            this.q.k();
            this.q.n(I());
            if (d.a.h0.l.i.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                return null;
            }
            d.a.h0.a.f2.a aVar3 = new d.a.h0.a.f2.a();
            aVar3.j(10L);
            aVar3.h(2906L);
            aVar3.c("更新DB失败");
            return aVar3;
        }
        d.a.h0.l.k.f fVar = this.m;
        if (fVar != null) {
            d.a.h0.a.e0.p.r.a.k(pMSAppInfo, fVar);
        } else if (d.a.h0.a.e0.p.r.b.f(this.n)) {
            d.a.h0.l.k.g gVar = this.n.get(0);
            this.u = gVar;
            gVar.o = this.r;
            d.a.h0.a.e0.p.r.a.l(this.q, gVar);
        } else {
            PMSAppInfo r3 = d.a.h0.l.i.a.h().r(this.r);
            if (r3 == null) {
                d.a.h0.a.f2.a aVar4 = new d.a.h0.a.f2.a();
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
        if (d.a.h0.l.i.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
            d.a.h0.a.e0.p.r.a.o(this.q);
            return null;
        }
        d.a.h0.a.f2.a aVar5 = new d.a.h0.a.f2.a();
        aVar5.j(10L);
        aVar5.h(2906L);
        aVar5.c("更新DB失败");
        return aVar5;
    }

    @Override // d.a.h0.l.h.g
    public void D() {
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void D0() {
        PMSAppInfo r2 = d.a.h0.l.i.a.h().r(this.r);
        d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + r2.createTime + " lastLaunchTime=" + r2.g() + " maxAge=" + r2.maxAge);
        if (r2 != null) {
            r2.k();
            r2.n(I());
            d.a.h0.l.k.f fVar = this.m;
            if (fVar != null) {
                fVar.f47149c = r2.createTime;
            }
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo != null) {
                pMSAppInfo.createTime = r2.createTime;
                pMSAppInfo.n(I());
            }
            d.a.h0.l.i.a.h().k(r2);
        }
    }

    @Override // d.a.h0.l.h.g
    public void F(d.a.h0.l.r.f fVar) {
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

    public f b0(d.a.h0.a.i2.u0.b<PMSAppInfo> bVar) {
        c0(this.x, bVar);
        return this;
    }

    public final synchronized <CallbackT> f c0(Collection<CallbackT> collection, CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.y.e(new s(this, collection, callbackt));
        }
        return this;
    }

    public synchronized f d0(d.a.h0.a.e0.p.m.a aVar) {
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
        if (TextUtils.isEmpty(this.f42175g)) {
            this.f42175g = getClass().toString();
        }
        return this.f42175g;
    }

    public int g0() {
        return 100;
    }

    public abstract PMSDownloadType h0();

    public final String i0() {
        return d.a.h0.l.h.h.b(this, "get_launch_id").getString("launch_id", "");
    }

    public void j0(int i2) {
        if (i2 == 1013) {
            d.a.h0.l.i.a.h().v(this.r, i2);
        } else {
            d.a.h0.l.i.a.h().v(this.r, 0);
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
        h.d.l(arrayList).z(this.E);
    }

    public f l0(PMSAppInfo pMSAppInfo) {
        m0(this.x, new r(this, pMSAppInfo));
        return this;
    }

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull d.a.h0.a.i2.u0.b<CallbackT> bVar) {
        this.y.e(new u(this, collection, bVar));
        return this;
    }

    public final void n0(d.a.h0.l.k.b bVar) {
        h.j<? super d.a.h0.l.k.b> jVar = this.k;
        if (jVar != null) {
            jVar.onNext(bVar);
            this.k.onCompleted();
        }
    }

    public f o0(@NonNull d.a.h0.a.i2.u0.b<d.a.h0.a.e0.p.m.a> bVar) {
        m0(this.w, new b(bVar));
        return this;
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.f p() {
        return this.D;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        o0(new d(this, pMSAppInfo));
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<d.a.h0.l.k.b> q() {
        return this.C;
    }

    public void q0(d.a.h0.a.f2.a aVar, boolean z) {
        o0(new c(this, aVar, z));
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<d.a.h0.l.k.d> r() {
        return this.B;
    }

    public void r0() {
        if (this.q == null) {
            return;
        }
        PMSAppInfo r2 = d.a.h0.l.i.a.h().r(this.r);
        if (r2 == null) {
            d.a.h0.a.c0.c.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        r2.n(I());
        this.q.b(r2);
        this.q.k();
        if (d.a.h0.l.i.a.h().k(this.q)) {
            d.a.h0.a.e0.p.r.a.o(this.q);
        }
    }

    public void s0() {
        long currentTimeMillis = System.currentTimeMillis() - this.v;
        d.a.h0.a.c0.c.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<d.a.h0.l.k.f> t() {
        return this.z;
    }

    public abstract void t0(Throwable th);

    public d.a.h0.a.f2.a u0(d.a.h0.l.k.b bVar) {
        d.a.h0.a.l0.h.a aVar = new d.a.h0.a.l0.h.a();
        aVar.f43209a = bVar.j;
        aVar.f43210b = bVar.f47147a;
        aVar.f43211c = bVar.m;
        if (d.a.h0.a.l0.b.a(bVar.f47154h, aVar) == null) {
            return null;
        }
        d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
        aVar2.j(14L);
        aVar2.b(2908L);
        aVar2.c("Extension包更新失败");
        return aVar2;
    }

    public d.a.h0.a.f2.a v0(d.a.h0.l.k.d dVar) {
        a.b c2 = d.a.h0.a.b2.f.a.c(dVar.j, dVar.f47147a, dVar.m, dVar.f47154h);
        if (!TextUtils.isEmpty(dVar.f47147a)) {
            d.a.h0.p.d.g(dVar.f47147a);
        }
        if (c2.c()) {
            return null;
        }
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(13L);
        aVar.b(2907L);
        aVar.c("Core包更新失败");
        return aVar;
    }

    public d.a.h0.a.f2.a w0(d.a.h0.l.k.f fVar) {
        if (fVar == null) {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(11L);
            aVar.h(2310L);
            aVar.e("pkg info is empty");
            d.a.h0.a.f2.e.a().f(aVar);
            return aVar;
        }
        return null;
    }

    public void x0(String str, String str2) {
        d.a.h0.a.j1.q.a.a(this.r, str, this.s, str2);
        this.s.clear();
    }

    public final void y0(d.a.h0.l.k.b bVar) {
        d.a.h0.a.e0.p.c.c().d(bVar, new h(bVar));
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<d.a.h0.l.k.g> z() {
        return this.A;
    }

    public final void z0(d.a.h0.l.k.d dVar) {
        d.a.h0.a.e0.p.c.c().d(dVar, new g(dVar));
    }
}
