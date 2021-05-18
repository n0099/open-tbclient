package d.a.i0.a.h0.m;

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
import d.a.i0.a.a2.i;
import d.a.i0.a.h0.m.c;
import d.a.i0.a.m2.f.a;
import d.a.i0.a.v2.y0;
import h.d;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class f extends d.a.i0.a.h0.m.j {
    public static final boolean E = d.a.i0.a.k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.i0.n.h.f> f42159h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<? super d.a.i0.n.h.g> f42160i;
    public h.j<? super d.a.i0.n.h.d> j;
    public h.j<? super d.a.i0.n.h.b> k;
    public d.a.i0.n.o.f l;
    public d.a.i0.n.h.f m;
    public List<d.a.i0.n.h.g> n;
    public d.a.i0.n.h.d o;
    public d.a.i0.n.h.b p;
    public PMSAppInfo q;
    public String r;
    public d.a.i0.n.h.g t;

    /* renamed from: g  reason: collision with root package name */
    public String f42158g = "";
    public long u = -1;
    public final Set<d.a.i0.a.h0.m.m.a> v = new HashSet();
    public final Set<d.a.i0.a.v2.e1.b<PMSAppInfo>> w = new HashSet();
    public final y0 x = new y0();
    public d.a.i0.n.f.c<d.a.i0.n.h.f> y = new a();
    public d.a.i0.n.f.c<d.a.i0.n.h.g> z = new n(this);
    public d.a.i0.n.f.c<d.a.i0.n.h.d> A = new o();
    public d.a.i0.n.f.c<d.a.i0.n.h.b> B = new p();
    public d.a.i0.n.f.f C = new q();
    public h.j<d.a.i0.n.h.e> D = new i();
    public List<UbcFlowEvent> s = new ArrayList();

    /* loaded from: classes2.dex */
    public class a extends d.a.i0.n.f.b<d.a.i0.n.h.f> {

        /* renamed from: d.a.i0.a.h0.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0667a implements d.a.i0.a.v2.e1.b<i.a> {
            public C0667a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if ("installer_on_pump_finish".equals(aVar.f40581f)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    d.a.i0.n.f.h.a(f.this, bundle, "event_performance_ubc");
                }
            }
        }

        public a() {
        }

        @Override // d.a.i0.n.f.b
        public int g() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.c
        /* renamed from: l */
        public String d(d.a.i0.n.h.f fVar) {
            int i2 = fVar.f47837h;
            if (i2 == 0) {
                return d.a.i0.a.h0.m.r.a.g();
            }
            if (i2 == 1) {
                return d.a.i0.a.h0.m.r.a.i();
            }
            return null;
        }

        @Override // d.a.i0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: o */
        public void e(d.a.i0.n.h.f fVar, d.a.i0.n.h.a aVar) {
            super.e(fVar, aVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "onDownloadError：" + aVar.toString());
            f.this.l.j(fVar);
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f47826a);
            aVar2.c("主包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f42159h != null) {
                f.this.f42159h.onError(new PkgDownloadError(fVar, aVar2));
            }
            d.a.i0.a.h0.m.c.c().a(fVar, f.this.h0(), aVar2);
            d.a.i0.t.d.j(fVar.f47830a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: p */
        public void i(d.a.i0.n.h.f fVar) {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.i0.a.f1.g.a.d(i0).e().d(1);
            }
            super.i(fVar);
            f.this.s.add(new UbcFlowEvent("na_pms_end_download"));
            d.a.i0.a.q2.a w0 = f.this.w0(fVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + fVar.f47838i);
            if (w0 == null) {
                f fVar2 = f.this;
                fVar2.m = fVar;
                fVar2.l.k(fVar);
                if (f.this.f42159h != null) {
                    f.this.f42159h.onNext(fVar);
                    if (f.E) {
                        Log.d("SwanAppPkgDownloadCallback", f.this.f0() + ": main onFileDownloaded: onCompleted");
                    }
                    f.this.f42159h.onCompleted();
                }
                d.a.i0.a.h0.m.c.c().b(fVar, f.this.h0());
                return;
            }
            f.this.l.j(fVar);
            if (f.this.f42159h != null) {
                f.this.f42159h.onError(new PkgDownloadError(fVar, w0));
            }
            d.a.i0.a.h0.m.c.c().a(fVar, f.this.h0(), w0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void c(d.a.i0.n.h.f fVar) {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.i0.a.f1.g.a.d(i0).e().d(1);
            }
            super.c(fVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: r */
        public void f(d.a.i0.n.h.f fVar) {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.i0.a.f1.g.a.d(i0).e().d(1);
            }
            super.f(fVar);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": main onDownloading");
            }
            f.this.A0(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: s */
        public d.a.i0.n.h.a h(d.a.i0.n.h.f fVar, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            String i0 = f.this.i0();
            if (f.E) {
                d.a.i0.a.f1.g.a.d(i0).f(fVar.toString()).d(1);
            }
            C0667a c0667a = new C0667a();
            Bundle bundle = new Bundle();
            bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
            bundle.putFloat("progress_granularity", 0.1f);
            d.a.i0.a.a1.g gVar = new d.a.i0.a.a1.g();
            gVar.v(c0667a);
            gVar.g(bundle);
            gVar.f(new d.a.i0.a.a1.f(fVar, f.this));
            gVar.f(new d.a.i0.a.a1.d(fVar.m, f.this));
            gVar.i(readableByteChannel);
            boolean j2 = gVar.j();
            gVar.p(c0667a);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": onProcessStream: installOk=" + j2);
            }
            if (j2) {
                d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                d.a.i0.t.d.K(file);
            }
            return j2 ? new d.a.i0.n.h.a(2300, "业务层处理下载流成功") : new d.a.i0.n.h.a(2301, "业务层处理下载流失败");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.v2.e1.b<d.a.i0.a.h0.m.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f42163e;

        public b(d.a.i0.a.v2.e1.b bVar) {
            this.f42163e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.h0.m.m.a aVar) {
            this.f42163e.onCallback(aVar);
            f fVar = f.this;
            fVar.e0(fVar.v, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.i0.a.v2.e1.b<d.a.i0.a.h0.m.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.q2.a f42165e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f42166f;

        public c(f fVar, d.a.i0.a.q2.a aVar, boolean z) {
            this.f42165e = aVar;
            this.f42166f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.h0.m.m.a aVar) {
            aVar.a(this.f42165e, this.f42166f);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.i0.a.v2.e1.b<d.a.i0.a.h0.m.m.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42167e;

        public d(f fVar, PMSAppInfo pMSAppInfo) {
            this.f42167e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.h0.m.m.a aVar) {
            aVar.b(this.f42167e);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.InterfaceC0665c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.n.h.f f42168a;

        public e(d.a.i0.n.h.f fVar) {
            this.f42168a = fVar;
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.a.i0.n.h.f fVar2 = this.f42168a;
            fVar.m = fVar2;
            fVar.l.k(fVar2);
            if (f.this.f42159h != null) {
                f.this.f42159h.onNext(this.f42168a);
                f.this.f42159h.onCompleted();
            }
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void b(PMSDownloadType pMSDownloadType, d.a.i0.a.q2.a aVar) {
            f.this.l.j(this.f42168a);
            if (f.this.f42159h != null) {
                f.this.f42159h.onError(new PkgDownloadError(this.f42168a, aVar));
            }
        }
    }

    /* renamed from: d.a.i0.a.h0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0668f implements c.InterfaceC0665c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.n.h.g f42170a;

        public C0668f(d.a.i0.n.h.g gVar) {
            this.f42170a = gVar;
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            d.a.i0.n.h.g gVar = this.f42170a;
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            fVar2.n.add(gVar);
            f.this.l.k(this.f42170a);
            if (f.this.f42160i != null) {
                f.this.f42160i.onNext(this.f42170a);
                if (f.this.l.g()) {
                    return;
                }
                f.this.f42160i.onCompleted();
            }
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void b(PMSDownloadType pMSDownloadType, d.a.i0.a.q2.a aVar) {
            f.this.l.j(this.f42170a);
            if (f.this.f42160i != null) {
                f.this.f42160i.onError(new PkgDownloadError(this.f42170a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.InterfaceC0665c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.n.h.d f42172a;

        public g(d.a.i0.n.h.d dVar) {
            this.f42172a = dVar;
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void a(PMSDownloadType pMSDownloadType) {
            f fVar = f.this;
            d.a.i0.n.h.d dVar = this.f42172a;
            fVar.o = dVar;
            fVar.l.k(dVar);
            if (f.this.j != null) {
                f.this.j.onNext(this.f42172a);
                f.this.j.onCompleted();
            }
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void b(PMSDownloadType pMSDownloadType, d.a.i0.a.q2.a aVar) {
            f.this.l.j(this.f42172a);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(this.f42172a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.InterfaceC0665c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.n.h.b f42174a;

        public h(d.a.i0.n.h.b bVar) {
            this.f42174a = bVar;
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void a(PMSDownloadType pMSDownloadType) {
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
            f fVar = f.this;
            d.a.i0.n.h.b bVar = this.f42174a;
            fVar.p = bVar;
            fVar.l.k(bVar);
            f.this.n0(this.f42174a);
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void b(PMSDownloadType pMSDownloadType, d.a.i0.a.q2.a aVar) {
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + aVar.toString());
            f.this.l.j(this.f42174a);
            f.this.n0(this.f42174a);
        }
    }

    /* loaded from: classes2.dex */
    public class i extends h.j<d.a.i0.n.h.e> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.i0.n.h.e eVar) {
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 单个包下载、业务层处理完成：" + eVar.f47838i);
        }

        @Override // h.e
        public void onCompleted() {
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载onCompleted");
            f.this.s0();
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.a.i0.a.e0.d.i("SwanAppPkgDownloadCallback", f.this.h0() + " : 包下载OnError", th);
            f.this.t0(th);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements d.a<d.a.i0.n.h.f> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.i0.n.h.f> jVar) {
            f.this.f42159h = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class k implements d.a<d.a.i0.n.h.g> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.i0.n.h.g> jVar) {
            f.this.f42160i = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class l implements d.a<d.a.i0.n.h.d> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.i0.n.h.d> jVar) {
            f.this.j = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class m implements d.a<d.a.i0.n.h.b> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.i0.n.h.b> jVar) {
            f.this.k = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class n extends d.a.i0.a.h0.m.k<f> {
        public n(f fVar) {
            super(fVar);
        }

        @Override // d.a.i0.a.h0.m.k, d.a.i0.n.f.b
        public int g() {
            return f.this.g0();
        }

        @Override // d.a.i0.a.h0.m.k
        public String l() {
            return f.this.r;
        }

        @Override // d.a.i0.a.h0.m.k
        public void p(@NonNull d.a.i0.n.h.g gVar, @Nullable d.a.i0.a.q2.a aVar) {
            super.p(gVar, aVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + gVar.f47838i);
            f fVar = f.this;
            if (fVar.n == null) {
                fVar.n = new ArrayList();
            }
            f fVar2 = f.this;
            gVar.o = fVar2.r;
            if (aVar == null) {
                fVar2.n.add(gVar);
                f.this.l.k(gVar);
                d.a.i0.a.h0.m.c.c().b(gVar, f.this.h0());
            } else {
                fVar2.l.j(gVar);
                d.a.i0.a.h0.m.c.c().a(gVar, f.this.h0(), aVar);
            }
            if (f.this.f42160i != null) {
                f.this.f42160i.onNext(gVar);
                if (f.this.l.g()) {
                    return;
                }
                f.this.f42160i.onCompleted();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void e(d.a.i0.n.h.g gVar, d.a.i0.n.h.a aVar) {
            super.q(gVar, aVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadError：" + aVar.toString());
            f.this.l.j(gVar);
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f47826a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f42160i != null) {
                f.this.f42160i.onError(new PkgDownloadError(gVar, aVar2));
            }
            d.a.i0.a.h0.m.c.c().a(gVar, f.this.h0(), aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.h0.m.k, d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: s */
        public void c(d.a.i0.n.h.g gVar) {
            super.c(gVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "sub onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: u */
        public void f(d.a.i0.n.h.g gVar) {
            super.f(gVar);
            f.this.B0(gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class o extends d.a.i0.n.f.b<d.a.i0.n.h.d> {
        public o() {
        }

        @Override // d.a.i0.n.f.b
        public int g() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.c
        /* renamed from: l */
        public String d(d.a.i0.n.h.d dVar) {
            int i2 = dVar.f47837h;
            if (i2 == 0) {
                return d.a.i0.a.h0.m.r.a.h();
            }
            if (i2 == 1) {
                return d.a.i0.a.h0.m.r.a.e();
            }
            return null;
        }

        @Override // d.a.i0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: o */
        public void e(d.a.i0.n.h.d dVar, d.a.i0.n.h.a aVar) {
            super.e(dVar, aVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadError：" + aVar.toString());
            f.this.l.j(dVar);
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f47826a);
            aVar2.c("Framework包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, aVar2));
            }
            d.a.i0.a.h0.m.c.c().a(dVar, f.this.h0(), aVar2);
            d.a.i0.t.d.j(dVar.f47830a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: p */
        public void i(d.a.i0.n.h.d dVar) {
            super.i(dVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + dVar.f47838i);
            d.a.i0.a.q2.a v0 = f.this.v0(dVar);
            if (v0 == null) {
                f fVar = f.this;
                fVar.o = dVar;
                fVar.l.k(dVar);
                if (f.this.j != null) {
                    f.this.j.onNext(dVar);
                    f.this.j.onCompleted();
                }
                d.a.i0.a.h0.m.c.c().b(dVar, f.this.h0());
                return;
            }
            f.this.l.j(dVar);
            if (f.this.j != null) {
                f.this.j.onError(new PkgDownloadError(dVar, v0));
            }
            d.a.i0.a.h0.m.c.c().a(dVar, f.this.h0(), v0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void c(d.a.i0.n.h.d dVar) {
            super.c(dVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "framework onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: r */
        public void f(d.a.i0.n.h.d dVar) {
            super.f(dVar);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": framework onDownloading");
            }
            f.this.z0(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class p extends d.a.i0.n.f.b<d.a.i0.n.h.b> {
        public p() {
        }

        @Override // d.a.i0.n.f.b
        public int g() {
            return f.this.g0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.c
        /* renamed from: l */
        public String d(d.a.i0.n.h.b bVar) {
            int i2 = bVar.f47837h;
            if (i2 == 0) {
                return d.a.i0.a.h0.m.r.a.d();
            }
            if (i2 == 1) {
                return d.a.i0.a.h0.m.r.a.f();
            }
            return null;
        }

        @Override // d.a.i0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: o */
        public void e(d.a.i0.n.h.b bVar, d.a.i0.n.h.a aVar) {
            super.e(bVar, aVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadError：" + aVar.toString());
            f.this.l.j(bVar);
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(14L);
            aVar2.h(aVar.f47826a);
            aVar2.c("Extension下载失败");
            aVar2.e(aVar.toString());
            if (f.E) {
                Log.e("SwanAppPkgDownloadCallback", aVar2.toString());
            }
            f.this.n0(bVar);
            d.a.i0.a.h0.m.c.c().a(bVar, f.this.h0(), aVar2);
            d.a.i0.t.d.j(bVar.f47830a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: p */
        public void i(d.a.i0.n.h.b bVar) {
            super.i(bVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + bVar.f47838i);
            d.a.i0.a.q2.a u0 = f.this.u0(bVar);
            if (u0 != null) {
                if (f.E) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + bVar.toString());
                }
                f.this.l.j(bVar);
                f.this.n0(bVar);
                d.a.i0.a.h0.m.c.c().a(bVar, f.this.h0(), u0);
                return;
            }
            f fVar = f.this;
            fVar.p = bVar;
            fVar.l.k(bVar);
            f.this.n0(bVar);
            d.a.i0.a.h0.m.c.c().b(bVar, f.this.h0());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void c(d.a.i0.n.h.b bVar) {
            super.c(bVar);
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "extension onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: r */
        public void f(d.a.i0.n.h.b bVar) {
            super.f(bVar);
            if (f.E) {
                Log.i("SwanAppPkgDownloadCallback", f.this.f0() + ": extension onDownloading");
            }
            f.this.y0(bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class q implements d.a.i0.n.f.f {
        public q() {
        }

        @Override // d.a.i0.n.f.f
        public void a(PMSAppInfo pMSAppInfo) {
            if (f.E) {
                Log.e("SwanAppPkgDownloadCallback", f.this.f0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
            }
            f fVar = f.this;
            fVar.q = pMSAppInfo;
            if (pMSAppInfo != null) {
                fVar.l0(pMSAppInfo);
                d.a.i0.a.t1.g.b.k(f.this.q.pluginInfo, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class r implements d.a.i0.a.v2.e1.b<d.a.i0.a.v2.e1.b<PMSAppInfo>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42185e;

        public r(f fVar, PMSAppInfo pMSAppInfo) {
            this.f42185e = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.v2.e1.b<PMSAppInfo> bVar) {
            bVar.onCallback(this.f42185e);
        }
    }

    /* loaded from: classes2.dex */
    public class s implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f42186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42187f;

        public s(f fVar, Collection collection, Object obj) {
            this.f42186e = collection;
            this.f42187f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42186e.add(this.f42187f);
        }
    }

    /* loaded from: classes2.dex */
    public class t implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f42188e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42189f;

        public t(f fVar, Collection collection, Object obj) {
            this.f42188e = collection;
            this.f42189f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42188e.remove(this.f42189f);
        }
    }

    /* loaded from: classes2.dex */
    public class u implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Collection f42190e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f42191f;

        public u(f fVar, Collection collection, d.a.i0.a.v2.e1.b bVar) {
            this.f42190e = collection;
            this.f42191f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Object obj : this.f42190e) {
                this.f42191f.onCallback(obj);
            }
        }
    }

    public f(String str) {
        this.r = str;
    }

    public final void A0(d.a.i0.n.h.f fVar) {
        d.a.i0.a.h0.m.c.c().d(fVar, new e(fVar));
    }

    @Override // d.a.i0.n.f.g
    public void B(d.a.i0.n.h.a aVar) {
        d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "onFetchError: error=" + aVar);
        if (aVar != null && aVar.f47826a == 1010) {
            D0();
        }
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void B0(d.a.i0.n.h.g gVar) {
        d.a.i0.a.h0.m.c.c().d(gVar, new C0668f(gVar));
    }

    @Override // d.a.i0.n.f.g
    public void C() {
        this.s.add(new UbcFlowEvent("na_pms_start_req"));
    }

    public d.a.i0.a.q2.a C0() {
        PMSAppInfo pMSAppInfo = this.q;
        if (pMSAppInfo == null) {
            if (this.m == null) {
                d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
                aVar.j(10L);
                aVar.h(2903L);
                aVar.c("Server未返回主包&AppInfo");
                return aVar;
            }
            PMSAppInfo s2 = d.a.i0.n.g.a.h().s(this.r);
            if (s2 == null) {
                d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
                aVar2.j(10L);
                aVar2.h(2904L);
                aVar2.c("Server未返回AppInfo数据，本地也没有数据");
                return aVar2;
            }
            this.q = s2;
            d.a.i0.a.h0.m.r.a.j(s2, this.m);
            this.q.k();
            this.q.o(I());
            if (d.a.i0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
                return null;
            }
            d.a.i0.a.q2.a aVar3 = new d.a.i0.a.q2.a();
            aVar3.j(10L);
            aVar3.h(2906L);
            aVar3.c("更新DB失败");
            return aVar3;
        }
        d.a.i0.n.h.f fVar = this.m;
        if (fVar != null) {
            d.a.i0.a.h0.m.r.a.j(pMSAppInfo, fVar);
        } else if (d.a.i0.a.h0.m.r.b.f(this.n)) {
            d.a.i0.n.h.g gVar = this.n.get(0);
            this.t = gVar;
            gVar.o = this.r;
            d.a.i0.a.h0.m.r.a.k(this.q, gVar);
        } else {
            PMSAppInfo s3 = d.a.i0.n.g.a.h().s(this.r);
            if (s3 == null) {
                d.a.i0.a.q2.a aVar4 = new d.a.i0.a.q2.a();
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
        if (d.a.i0.n.g.a.h().b(this.m, this.n, this.o, this.p, this.q)) {
            d.a.i0.a.h0.m.r.a.n(this.q);
            return null;
        }
        d.a.i0.a.q2.a aVar5 = new d.a.i0.a.q2.a();
        aVar5.j(10L);
        aVar5.h(2906L);
        aVar5.c("更新DB失败");
        return aVar5;
    }

    @Override // d.a.i0.n.f.g
    public void D() {
        this.s.add(new UbcFlowEvent("na_pms_end_req"));
    }

    public final void D0() {
        PMSAppInfo s2 = d.a.i0.n.g.a.h().s(this.r);
        d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + s2.createTime + " lastLaunchTime=" + s2.g() + " maxAge=" + s2.maxAge);
        if (s2 != null) {
            s2.k();
            s2.o(I());
            d.a.i0.n.h.f fVar = this.m;
            if (fVar != null) {
                fVar.f47832c = s2.createTime;
            }
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo != null) {
                pMSAppInfo.createTime = s2.createTime;
                pMSAppInfo.o(I());
            }
            d.a.i0.n.g.a.h().k(s2);
        }
    }

    @Override // d.a.i0.n.f.g
    public void F(d.a.i0.n.o.f fVar) {
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

    public f b0(d.a.i0.a.v2.e1.b<PMSAppInfo> bVar) {
        c0(this.w, bVar);
        return this;
    }

    public final synchronized <CallbackT> f c0(Collection<CallbackT> collection, CallbackT callbackt) {
        if (collection != null && callbackt != null) {
            this.x.a(new s(this, collection, callbackt));
        }
        return this;
    }

    public synchronized f d0(d.a.i0.a.h0.m.m.a aVar) {
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
        if (TextUtils.isEmpty(this.f42158g)) {
            this.f42158g = getClass().toString();
        }
        return this.f42158g;
    }

    public int g0() {
        return 100;
    }

    public abstract PMSDownloadType h0();

    public final String i0() {
        return d.a.i0.n.f.h.b(this, "get_launch_id").getString("launch_id", "");
    }

    public void j0(int i2) {
        if (i2 == 1013) {
            d.a.i0.n.g.a.h().x(this.r, i2);
        } else {
            d.a.i0.n.g.a.h().x(this.r, 0);
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

    public final synchronized <CallbackT> f m0(@NonNull Collection<CallbackT> collection, @NonNull d.a.i0.a.v2.e1.b<CallbackT> bVar) {
        this.x.a(new u(this, collection, bVar));
        return this;
    }

    public final void n0(d.a.i0.n.h.b bVar) {
        h.j<? super d.a.i0.n.h.b> jVar = this.k;
        if (jVar != null) {
            jVar.onNext(bVar);
            this.k.onCompleted();
        }
    }

    public f o0(@NonNull d.a.i0.a.v2.e1.b<d.a.i0.a.h0.m.m.a> bVar) {
        m0(this.v, new b(bVar));
        return this;
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.f p() {
        return this.C;
    }

    public void p0(PMSAppInfo pMSAppInfo) {
        o0(new d(this, pMSAppInfo));
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.c<d.a.i0.n.h.b> q() {
        return this.B;
    }

    public void q0(d.a.i0.a.q2.a aVar, boolean z) {
        o0(new c(this, aVar, z));
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.c<d.a.i0.n.h.d> r() {
        return this.A;
    }

    public void r0() {
        if (this.q == null) {
            return;
        }
        PMSAppInfo s2 = d.a.i0.n.g.a.h().s(this.r);
        if (s2 == null) {
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.q.appId = this.r;
        s2.o(I());
        this.q.b(s2);
        this.q.k();
        if (d.a.i0.n.g.a.h().k(this.q)) {
            d.a.i0.a.h0.m.r.a.n(this.q);
        }
    }

    public void s0() {
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        d.a.i0.a.e0.d.g("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.c<d.a.i0.n.h.f> t() {
        return this.y;
    }

    public abstract void t0(Throwable th);

    public d.a.i0.a.q2.a u0(d.a.i0.n.h.b bVar) {
        d.a.i0.a.p0.g.a aVar = new d.a.i0.a.p0.g.a();
        aVar.f43913b = bVar.f47838i;
        aVar.f43912a = bVar.j;
        aVar.f43914c = bVar.f47830a;
        aVar.f43915d = bVar.m;
        if (d.a.i0.a.p0.b.b(bVar.f47837h, aVar) == null) {
            return null;
        }
        d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
        aVar2.j(14L);
        aVar2.b(2908L);
        aVar2.c("Extension包更新失败");
        return aVar2;
    }

    public d.a.i0.a.q2.a v0(d.a.i0.n.h.d dVar) {
        if (E) {
            Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + dVar);
        }
        a.b c2 = d.a.i0.a.m2.f.a.c(dVar, dVar.f47837h);
        if (!TextUtils.isEmpty(dVar.f47830a)) {
            d.a.i0.a.e0.d.h("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + dVar.f47830a);
            d.a.i0.t.d.j(dVar.f47830a);
        }
        if (c2.c()) {
            return null;
        }
        d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
        aVar.j(13L);
        aVar.b(2907L);
        aVar.c("Core包更新失败");
        return aVar;
    }

    public d.a.i0.a.q2.a w0(d.a.i0.n.h.f fVar) {
        if (fVar == null) {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(11L);
            aVar.h(2310L);
            aVar.e("pkg info is empty");
            d.a.i0.a.q2.e.a().f(aVar);
            return aVar;
        }
        return null;
    }

    public void x0(String str, String str2) {
        d.a.i0.a.r1.q.a.a(this.r, str, this.s, str2);
        this.s.clear();
    }

    public final void y0(d.a.i0.n.h.b bVar) {
        d.a.i0.a.h0.m.c.c().d(bVar, new h(bVar));
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.c<d.a.i0.n.h.g> z() {
        return this.z;
    }

    public final void z0(d.a.i0.n.h.d dVar) {
        d.a.i0.a.h0.m.c.c().d(dVar, new g(dVar));
    }
}
