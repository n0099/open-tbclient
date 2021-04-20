package d.b.g0.a.v1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.k;
import d.b.g0.a.t.c.a.b;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.a.v1.c.i.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.r1.f {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47048g = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.a2.g.g f47049a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47050b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47051c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f47052d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.b.g0.a.v1.c.i.b> f47053e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.g0.a.i2.t0.c f47054f;

    /* renamed from: d.b.g0.a.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0866a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f47056f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47057g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47058h;

        /* renamed from: d.b.g0.a.v1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0867a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {
            public C0867a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
                C0866a c0866a = C0866a.this;
                a.this.t(c0866a.f47055e, hVar);
            }
        }

        public C0866a(d.b.g0.a.i2.u0.b bVar, boolean z, Context context, String str) {
            this.f47055e = bVar;
            this.f47056f = z;
            this.f47057g = context;
            this.f47058h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [ResultDataT, d.b.g0.a.v1.c.i.b$e] */
        /* JADX WARN: Type inference failed for: r8v6, types: [ResultDataT, d.b.g0.a.v1.c.i.b$e] */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.e eVar) {
            d.b.g0.a.v1.c.h hVar = new d.b.g0.a.v1.c.h();
            if (a.f47048g && d.b.g0.a.m1.a.a.k()) {
                hVar.e();
                hVar.f47200a = new b.e(true, null);
                a.this.t(this.f47055e, hVar);
                return;
            }
            boolean z = false;
            boolean z2 = eVar == null;
            d.b.g0.a.c0.c.h("SwanAppSetting", "isResultNull = " + z2);
            if (!z2 && !eVar.f47163d) {
                if (!this.f47056f ? eVar.j == 0 : eVar.j <= 0) {
                    z = true;
                }
                if (z) {
                    a.this.c(this.f47057g, this.f47058h, this.f47056f, new C0867a());
                    return;
                }
                if (eVar.j > 0) {
                    hVar.e();
                    hVar.f47200a = new b.e(true, null);
                } else {
                    hVar.d(new OAuthException(10003));
                }
                a.this.t(this.f47055e, hVar);
                return;
            }
            hVar.d(new OAuthException(10005));
            a.this.t(this.f47055e, hVar);
            d.b.g0.a.z1.h.q(10005, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47060e;

        public b(d.b.g0.a.i2.u0.b bVar) {
            this.f47060e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.e eVar) {
            a.this.t(this.f47060e, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47062e;

        public c(String str) {
            this.f47062e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            a.this.f47053e.remove(this.f47062e);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.g0.a.i2.t0.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.v1.c.i.b f47064f;

        /* renamed from: d.b.g0.a.v1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0868a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {
            public C0868a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
                d.this.a();
            }
        }

        public d(a aVar, d.b.g0.a.v1.c.i.b bVar) {
            this.f47064f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47064f.p(new C0868a());
            this.f47064f.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends i<d.b.g0.a.i2.u0.b<ResulT>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f47066a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, Object obj) {
            super(aVar, null);
            this.f47066a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.v1.a.i
        /* renamed from: b */
        public void a(d.b.g0.a.i2.u0.b<ResulT> bVar) {
            bVar.onCallback(this.f47066a);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f47067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f47068f;

        public f(a aVar, i iVar, Object obj) {
            this.f47067e = iVar;
            this.f47068f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47067e.a(this.f47068f);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends i<j> {
        public g(a aVar) {
            super(aVar, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.v1.a.i
        /* renamed from: b */
        public void a(j jVar) {
            jVar.a();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends d.b.g0.a.i2.t0.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47069f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.c f47070g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f47071h;
        public final /* synthetic */ d.b.g0.a.i2.u0.b i;

        /* renamed from: d.b.g0.a.v1.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0869a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<f.d>> {
            public C0869a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.g0.a.v1.c.h<f.d> hVar) {
                h.this.a();
            }
        }

        public h(a aVar, Activity activity, b.c cVar, Bundle bundle, d.b.g0.a.i2.u0.b bVar) {
            this.f47069f = activity;
            this.f47070g = cVar;
            this.f47071h = bundle;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.v1.c.i.f b2 = d.b.g0.a.r1.d.e().o().a().a().b(this.f47069f, this.f47070g, this.f47071h);
            b2.p(this.i);
            b2.p(new C0869a());
            b2.a();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class i<CallBackT> {
        public i(a aVar) {
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(a aVar, C0866a c0866a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    public a(d.b.g0.a.r1.e eVar) {
        super(eVar);
        this.f47052d = new HashSet();
        this.f47053e = new HashMap();
        this.f47054f = new d.b.g0.a.i2.t0.c();
        this.f47050b = d.b.g0.a.a2.b.d(eVar);
        this.f47051c = "aiapp_setting_" + this.f47050b;
    }

    public static void w(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void A(String str, String str2) {
        o().putString(str, str2);
    }

    public synchronized void B(j jVar) {
        this.f47052d.add(jVar);
    }

    public void C(String str) {
        this.f47049a.remove(str);
    }

    public boolean D() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.q1.b.f.d.e(AppRuntime.getAppContext(), d.b.g0.a.h.aiapps_open_fragment_failed_toast).C();
            return false;
        }
        f.b i2 = W.i("navigateTo");
        i2.n(d.b.g0.a.e0.l.f.f44405g, d.b.g0.a.e0.l.f.i);
        i2.k("authority", null).a();
        return true;
    }

    public synchronized void E(j jVar) {
        this.f47052d.remove(jVar);
    }

    public void c(Context context, String str, boolean z, d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> bVar) {
        d(context, str, z, true, false, bVar);
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> bVar) {
        x(context, str, z, z2, z3, bVar);
    }

    public void e(String str, d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> bVar) {
        if (TextUtils.isEmpty(str)) {
            t(bVar, null);
        } else {
            d.b.g0.a.g1.o.c.a.i(str, new b(bVar));
        }
    }

    public boolean f(String str) {
        if (f47048g && d.b.g0.a.m1.a.a.k()) {
            return true;
        }
        d.b.g0.a.v1.c.e k = d.b.g0.a.g1.o.c.a.k(str);
        return (k == null || k.f47163d || !k.a()) ? false : true;
    }

    public void g(Context context, String str, d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> bVar) {
        h(context, str, false, bVar);
    }

    public void h(Context context, String str, boolean z, d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> bVar) {
        e(str, new C0866a(bVar, z, context, str));
    }

    public void i() {
        o().edit().clear().apply();
    }

    public synchronized void j() {
        this.f47053e.clear();
        this.f47054f.c();
        k();
    }

    public synchronized void k() {
        this.f47052d.clear();
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

    public final d.b.g0.a.a2.g.g o() {
        if (this.f47049a == null) {
            this.f47049a = new d.b.g0.a.a2.g.g(this.f47051c, false);
        }
        return this.f47049a;
    }

    public String p(String str, String str2) {
        return o().getString(str, str2);
    }

    public void q(Activity activity, b.c cVar, Bundle bundle, d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<f.d>> bVar) {
        this.f47054f.d(new h(this, activity, cVar, bundle, bVar));
    }

    public synchronized <CallBackT> void r(CallBackT callbackt, i<CallBackT> iVar) {
        w(new f(this, iVar, callbackt));
    }

    public synchronized <CallBackT> void s(Collection<CallBackT> collection, i<CallBackT> iVar) {
        for (CallBackT callbackt : collection) {
            r(callbackt, iVar);
        }
    }

    public final <ResulT> void t(d.b.g0.a.i2.u0.b<ResulT> bVar, ResulT result) {
        r(bVar, new e(this, result));
    }

    public void u() {
        s(this.f47052d, new g(this));
    }

    public void v(Activity activity) {
    }

    public final void x(Context context, String str, boolean z, boolean z2, boolean z3, d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> bVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        d.b.g0.a.v1.c.i.b bVar2 = this.f47053e.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
            bVar2.p(bVar);
            return;
        }
        d.b.g0.a.v1.c.i.b e2 = d.b.g0.a.r1.d.e().o().a().a().e(context, z, z2, new String[]{str}, null, z3);
        this.f47053e.put(str, e2);
        e2.p(bVar);
        e2.p(new c(str));
        this.f47054f.d(new d(this, e2));
    }

    public void y(String str, boolean z) {
        o().putBoolean(str, z);
    }

    public void z(String str, long j2) {
        o().putLong(str, j2);
    }
}
