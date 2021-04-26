package d.a.h0.a.v1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.k;
import d.a.h0.a.t.c.a.b;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.a.v1.c.i.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends d.a.h0.a.r1.f {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44791g = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.a2.g.g f44792a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44793b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44794c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f44795d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.h0.a.v1.c.i.b> f44796e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.h0.a.i2.t0.c f44797f;

    /* renamed from: d.a.h0.a.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0825a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f44798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44799f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44800g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44801h;

        /* renamed from: d.a.h0.a.v1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0826a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {
            public C0826a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
                C0825a c0825a = C0825a.this;
                a.this.t(c0825a.f44798e, hVar);
            }
        }

        public C0825a(d.a.h0.a.i2.u0.b bVar, boolean z, Context context, String str) {
            this.f44798e = bVar;
            this.f44799f = z;
            this.f44800g = context;
            this.f44801h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [ResultDataT, d.a.h0.a.v1.c.i.b$e] */
        /* JADX WARN: Type inference failed for: r8v6, types: [ResultDataT, d.a.h0.a.v1.c.i.b$e] */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.e eVar) {
            d.a.h0.a.v1.c.h hVar = new d.a.h0.a.v1.c.h();
            if (a.f44791g && d.a.h0.a.m1.a.a.k()) {
                hVar.e();
                hVar.f44952a = new b.e(true, null);
                a.this.t(this.f44798e, hVar);
                return;
            }
            boolean z = false;
            boolean z2 = eVar == null;
            d.a.h0.a.c0.c.h("SwanAppSetting", "isResultNull = " + z2);
            if (!z2 && !eVar.f44913d) {
                if (!this.f44799f ? eVar.j == 0 : eVar.j <= 0) {
                    z = true;
                }
                if (z) {
                    a.this.c(this.f44800g, this.f44801h, this.f44799f, new C0826a());
                    return;
                }
                if (eVar.j > 0) {
                    hVar.e();
                    hVar.f44952a = new b.e(true, null);
                } else {
                    hVar.d(new OAuthException(10003));
                }
                a.this.t(this.f44798e, hVar);
                return;
            }
            hVar.d(new OAuthException(10005));
            a.this.t(this.f44798e, hVar);
            d.a.h0.a.z1.h.q(10005, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f44804e;

        public b(d.a.h0.a.i2.u0.b bVar) {
            this.f44804e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.e eVar) {
            a.this.t(this.f44804e, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44806e;

        public c(String str) {
            this.f44806e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            a.this.f44796e.remove(this.f44806e);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.h0.a.i2.t0.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.c.i.b f44808f;

        /* renamed from: d.a.h0.a.v1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0827a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {
            public C0827a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
                d.this.a();
            }
        }

        public d(a aVar, d.a.h0.a.v1.c.i.b bVar) {
            this.f44808f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44808f.p(new C0827a());
            this.f44808f.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends i<d.a.h0.a.i2.u0.b<ResulT>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f44810a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, Object obj) {
            super(aVar, null);
            this.f44810a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.v1.a.i
        /* renamed from: b */
        public void a(d.a.h0.a.i2.u0.b<ResulT> bVar) {
            bVar.onCallback(this.f44810a);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f44811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f44812f;

        public f(a aVar, i iVar, Object obj) {
            this.f44811e = iVar;
            this.f44812f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44811e.a(this.f44812f);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends i<j> {
        public g(a aVar) {
            super(aVar, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.v1.a.i
        /* renamed from: b */
        public void a(j jVar) {
            jVar.a();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends d.a.h0.a.i2.t0.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44813f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.c f44814g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f44815h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f44816i;

        /* renamed from: d.a.h0.a.v1.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0828a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<f.d>> {
            public C0828a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.a.h0.a.v1.c.h<f.d> hVar) {
                h.this.a();
            }
        }

        public h(a aVar, Activity activity, b.c cVar, Bundle bundle, d.a.h0.a.i2.u0.b bVar) {
            this.f44813f = activity;
            this.f44814g = cVar;
            this.f44815h = bundle;
            this.f44816i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.v1.c.i.f b2 = d.a.h0.a.r1.d.e().w().a().b().b(this.f44813f, this.f44814g, this.f44815h);
            b2.p(this.f44816i);
            b2.p(new C0828a());
            b2.a();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class i<CallBackT> {
        public i(a aVar) {
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(a aVar, C0825a c0825a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    public a(d.a.h0.a.r1.e eVar) {
        super(eVar);
        this.f44795d = new HashSet();
        this.f44796e = new HashMap();
        this.f44797f = new d.a.h0.a.i2.t0.c();
        this.f44793b = d.a.h0.a.a2.b.d(eVar);
        this.f44794c = "aiapp_setting_" + this.f44793b;
    }

    public static void w(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void A(String str, String str2) {
        o().putString(str, str2);
    }

    public synchronized void B(j jVar) {
        this.f44795d.add(jVar);
    }

    public void C(String str) {
        this.f44792a.remove(str);
    }

    public boolean D() {
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.q1.b.f.d.e(AppRuntime.getAppContext(), d.a.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return false;
        }
        f.b i2 = W.i("navigateTo");
        i2.n(d.a.h0.a.e0.l.f.f42031g, d.a.h0.a.e0.l.f.f42033i);
        i2.k("authority", null).a();
        return true;
    }

    public synchronized void E(j jVar) {
        this.f44795d.remove(jVar);
    }

    public void c(Context context, String str, boolean z, d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> bVar) {
        d(context, str, z, true, false, bVar);
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> bVar) {
        x(context, str, z, z2, z3, bVar);
    }

    public void e(String str, d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.e> bVar) {
        if (TextUtils.isEmpty(str)) {
            t(bVar, null);
        } else {
            d.a.h0.a.g1.o.c.a.i(str, new b(bVar));
        }
    }

    public boolean f(String str) {
        if (f44791g && d.a.h0.a.m1.a.a.k()) {
            return true;
        }
        d.a.h0.a.v1.c.e k = d.a.h0.a.g1.o.c.a.k(str);
        return (k == null || k.f44913d || !k.a()) ? false : true;
    }

    public void g(Context context, String str, d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> bVar) {
        h(context, str, false, bVar);
    }

    public void h(Context context, String str, boolean z, d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> bVar) {
        e(str, new C0825a(bVar, z, context, str));
    }

    public void i() {
        o().edit().clear().apply();
    }

    public synchronized void j() {
        this.f44796e.clear();
        this.f44797f.c();
        k();
    }

    public synchronized void k() {
        this.f44795d.clear();
    }

    public void l() {
        o().edit().clear().commit();
    }

    public boolean m(String str, boolean z) {
        return o().getBoolean(str, z);
    }

    public long n(String str, long j2) {
        return o().getLong(str, j2);
    }

    public final d.a.h0.a.a2.g.g o() {
        if (this.f44792a == null) {
            this.f44792a = new d.a.h0.a.a2.g.g(this.f44794c, false);
        }
        return this.f44792a;
    }

    public String p(String str, String str2) {
        return o().getString(str, str2);
    }

    public void q(Activity activity, b.c cVar, Bundle bundle, d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<f.d>> bVar) {
        this.f44797f.d(new h(this, activity, cVar, bundle, bVar));
    }

    public synchronized <CallBackT> void r(CallBackT callbackt, i<CallBackT> iVar) {
        w(new f(this, iVar, callbackt));
    }

    public synchronized <CallBackT> void s(Collection<CallBackT> collection, i<CallBackT> iVar) {
        for (CallBackT callbackt : collection) {
            r(callbackt, iVar);
        }
    }

    public final <ResulT> void t(d.a.h0.a.i2.u0.b<ResulT> bVar, ResulT result) {
        r(bVar, new e(this, result));
    }

    public void u() {
        s(this.f44795d, new g(this));
    }

    public void v(Activity activity) {
    }

    public final void x(Context context, String str, boolean z, boolean z2, boolean z3, d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> bVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        d.a.h0.a.v1.c.i.b bVar2 = this.f44796e.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
            bVar2.p(bVar);
            return;
        }
        d.a.h0.a.v1.c.i.b d2 = d.a.h0.a.r1.d.e().w().a().b().d(context, z, z2, new String[]{str}, null, z3);
        this.f44796e.put(str, d2);
        d2.p(bVar);
        d2.p(new c(str));
        this.f44797f.d(new d(this, d2));
    }

    public void y(String str, boolean z) {
        o().putBoolean(str, z);
    }

    public void z(String str, long j2) {
        o().putLong(str, j2);
    }
}
