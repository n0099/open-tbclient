package d.b.h0.a.v1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.k;
import d.b.h0.a.t.c.a.b;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.a.v1.c.i.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends d.b.h0.a.r1.f {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47377g = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.a2.g.g f47378a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47379b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47380c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f47381d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.b.h0.a.v1.c.i.b> f47382e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.h0.a.i2.t0.c f47383f;

    /* renamed from: d.b.h0.a.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0886a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f47384e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f47385f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47386g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47387h;

        /* renamed from: d.b.h0.a.v1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0887a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {
            public C0887a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
                C0886a c0886a = C0886a.this;
                a.this.t(c0886a.f47384e, hVar);
            }
        }

        public C0886a(d.b.h0.a.i2.u0.b bVar, boolean z, Context context, String str) {
            this.f47384e = bVar;
            this.f47385f = z;
            this.f47386g = context;
            this.f47387h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [d.b.h0.a.v1.c.i.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [d.b.h0.a.v1.c.i.b$e, ResultDataT] */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.e eVar) {
            d.b.h0.a.v1.c.h hVar = new d.b.h0.a.v1.c.h();
            if (a.f47377g && d.b.h0.a.m1.a.a.k()) {
                hVar.e();
                hVar.f47529a = new b.e(true, null);
                a.this.t(this.f47384e, hVar);
                return;
            }
            boolean z = false;
            boolean z2 = eVar == null;
            d.b.h0.a.c0.c.h("SwanAppSetting", "isResultNull = " + z2);
            if (!z2 && !eVar.f47492d) {
                if (!this.f47385f ? eVar.j == 0 : eVar.j <= 0) {
                    z = true;
                }
                if (z) {
                    a.this.c(this.f47386g, this.f47387h, this.f47385f, new C0887a());
                    return;
                }
                if (eVar.j > 0) {
                    hVar.e();
                    hVar.f47529a = new b.e(true, null);
                } else {
                    hVar.d(new OAuthException(10003));
                }
                a.this.t(this.f47384e, hVar);
                return;
            }
            hVar.d(new OAuthException(10005));
            a.this.t(this.f47384e, hVar);
            d.b.h0.a.z1.h.q(10005, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f47389e;

        public b(d.b.h0.a.i2.u0.b bVar) {
            this.f47389e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.e eVar) {
            a.this.t(this.f47389e, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47391e;

        public c(String str) {
            this.f47391e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            a.this.f47382e.remove(this.f47391e);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.h0.a.i2.t0.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.v1.c.i.b f47393f;

        /* renamed from: d.b.h0.a.v1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0888a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {
            public C0888a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
                d.this.a();
            }
        }

        public d(a aVar, d.b.h0.a.v1.c.i.b bVar) {
            this.f47393f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47393f.p(new C0888a());
            this.f47393f.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends i<d.b.h0.a.i2.u0.b<ResulT>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f47395a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, Object obj) {
            super(aVar, null);
            this.f47395a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.v1.a.i
        /* renamed from: b */
        public void a(d.b.h0.a.i2.u0.b<ResulT> bVar) {
            bVar.onCallback(this.f47395a);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f47396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f47397f;

        public f(a aVar, i iVar, Object obj) {
            this.f47396e = iVar;
            this.f47397f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47396e.a(this.f47397f);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends i<j> {
        public g(a aVar) {
            super(aVar, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.v1.a.i
        /* renamed from: b */
        public void a(j jVar) {
            jVar.a();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends d.b.h0.a.i2.t0.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47398f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.c f47399g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f47400h;
        public final /* synthetic */ d.b.h0.a.i2.u0.b i;

        /* renamed from: d.b.h0.a.v1.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0889a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<f.d>> {
            public C0889a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.h0.a.v1.c.h<f.d> hVar) {
                h.this.a();
            }
        }

        public h(a aVar, Activity activity, b.c cVar, Bundle bundle, d.b.h0.a.i2.u0.b bVar) {
            this.f47398f = activity;
            this.f47399g = cVar;
            this.f47400h = bundle;
            this.i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.v1.c.i.f b2 = d.b.h0.a.r1.d.e().o().a().a().b(this.f47398f, this.f47399g, this.f47400h);
            b2.p(this.i);
            b2.p(new C0889a());
            b2.a();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class i<CallBackT> {
        public i(a aVar) {
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(a aVar, C0886a c0886a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    public a(d.b.h0.a.r1.e eVar) {
        super(eVar);
        this.f47381d = new HashSet();
        this.f47382e = new HashMap();
        this.f47383f = new d.b.h0.a.i2.t0.c();
        this.f47379b = d.b.h0.a.a2.b.d(eVar);
        this.f47380c = "aiapp_setting_" + this.f47379b;
    }

    public static void w(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void A(String str, String str2) {
        o().putString(str, str2);
    }

    public synchronized void B(j jVar) {
        this.f47381d.add(jVar);
    }

    public void C(String str) {
        this.f47378a.remove(str);
    }

    public boolean D() {
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            d.b.h0.a.q1.b.f.d.e(AppRuntime.getAppContext(), d.b.h0.a.h.aiapps_open_fragment_failed_toast).C();
            return false;
        }
        f.b i2 = W.i("navigateTo");
        i2.n(d.b.h0.a.e0.l.f.f44734g, d.b.h0.a.e0.l.f.i);
        i2.k("authority", null).a();
        return true;
    }

    public synchronized void E(j jVar) {
        this.f47381d.remove(jVar);
    }

    public void c(Context context, String str, boolean z, d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> bVar) {
        d(context, str, z, true, false, bVar);
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> bVar) {
        x(context, str, z, z2, z3, bVar);
    }

    public void e(String str, d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.e> bVar) {
        if (TextUtils.isEmpty(str)) {
            t(bVar, null);
        } else {
            d.b.h0.a.g1.o.c.a.i(str, new b(bVar));
        }
    }

    public boolean f(String str) {
        if (f47377g && d.b.h0.a.m1.a.a.k()) {
            return true;
        }
        d.b.h0.a.v1.c.e k = d.b.h0.a.g1.o.c.a.k(str);
        return (k == null || k.f47492d || !k.a()) ? false : true;
    }

    public void g(Context context, String str, d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> bVar) {
        h(context, str, false, bVar);
    }

    public void h(Context context, String str, boolean z, d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> bVar) {
        e(str, new C0886a(bVar, z, context, str));
    }

    public void i() {
        o().edit().clear().apply();
    }

    public synchronized void j() {
        this.f47382e.clear();
        this.f47383f.c();
        k();
    }

    public synchronized void k() {
        this.f47381d.clear();
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

    public final d.b.h0.a.a2.g.g o() {
        if (this.f47378a == null) {
            this.f47378a = new d.b.h0.a.a2.g.g(this.f47380c, false);
        }
        return this.f47378a;
    }

    public String p(String str, String str2) {
        return o().getString(str, str2);
    }

    public void q(Activity activity, b.c cVar, Bundle bundle, d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<f.d>> bVar) {
        this.f47383f.d(new h(this, activity, cVar, bundle, bVar));
    }

    public synchronized <CallBackT> void r(CallBackT callbackt, i<CallBackT> iVar) {
        w(new f(this, iVar, callbackt));
    }

    public synchronized <CallBackT> void s(Collection<CallBackT> collection, i<CallBackT> iVar) {
        for (CallBackT callbackt : collection) {
            r(callbackt, iVar);
        }
    }

    public final <ResulT> void t(d.b.h0.a.i2.u0.b<ResulT> bVar, ResulT result) {
        r(bVar, new e(this, result));
    }

    public void u() {
        s(this.f47381d, new g(this));
    }

    public void v(Activity activity) {
    }

    public final void x(Context context, String str, boolean z, boolean z2, boolean z3, d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> bVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        d.b.h0.a.v1.c.i.b bVar2 = this.f47382e.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
            bVar2.p(bVar);
            return;
        }
        d.b.h0.a.v1.c.i.b e2 = d.b.h0.a.r1.d.e().o().a().a().e(context, z, z2, new String[]{str}, null, z3);
        this.f47382e.put(str, e2);
        e2.p(bVar);
        e2.p(new c(str));
        this.f47383f.d(new d(this, e2));
    }

    public void y(String str, boolean z) {
        o().putBoolean(str, z);
    }

    public void z(String str, long j2) {
        o().putLong(str, j2);
    }
}
