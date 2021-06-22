package d.a.m0.a.e2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.e2.c.j.f;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.k;
import d.a.m0.a.u.e.a.c;
import d.a.m0.a.v2.q0;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends d.a.m0.a.a2.f {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45346g = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.k2.g.g f45347a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45348b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45349c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f45350d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.m0.a.e2.c.j.b> f45351e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.m0.a.v2.d1.c f45352f;

    /* renamed from: d.a.m0.a.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0669a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f45353e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45354f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f45355g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f45356h;

        /* renamed from: d.a.m0.a.e2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0670a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {
            public C0670a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
                C0669a c0669a = C0669a.this;
                a.this.u(c0669a.f45353e, iVar);
            }
        }

        public C0669a(d.a.m0.a.v2.e1.b bVar, String str, boolean z, Context context) {
            this.f45353e = bVar;
            this.f45354f = str;
            this.f45355g = z;
            this.f45356h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [d.a.m0.a.e2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [d.a.m0.a.e2.c.j.b$e, ResultDataT] */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.f fVar) {
            d.a.m0.a.e2.c.i iVar = new d.a.m0.a.e2.c.i();
            if (a.f45346g && d.a.m0.a.u1.a.a.m()) {
                iVar.e();
                iVar.f45520a = new b.e(true, null);
                a.this.u(this.f45353e, iVar);
                return;
            }
            boolean z = false;
            boolean z2 = fVar == null;
            d.a.m0.a.e0.d.h("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f45354f);
            if (!z2 && !fVar.f45481d) {
                if (!this.f45355g ? fVar.j == 0 : fVar.j <= 0) {
                    z = true;
                }
                if (z) {
                    a.this.c(this.f45356h, this.f45354f, this.f45355g, new C0670a());
                    return;
                }
                if (fVar.j > 0) {
                    iVar.e();
                    iVar.f45520a = new b.e(true, null);
                } else {
                    iVar.d(new OAuthException(10003));
                }
                a.this.u(this.f45353e, iVar);
                return;
            }
            iVar.d(new OAuthException(10005));
            a.this.u(this.f45353e, iVar);
            d.a.m0.a.e0.d.i("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
            d.a.m0.a.j2.k.p(10005, fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f45359e;

        public b(d.a.m0.a.v2.e1.b bVar) {
            this.f45359e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.f fVar) {
            a.this.u(this.f45359e, fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45361e;

        public c(String str) {
            this.f45361e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            a.this.f45351e.remove(this.f45361e);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.m0.a.v2.d1.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.e2.c.j.b f45363f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45364g;

        /* renamed from: d.a.m0.a.e2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0671a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {
            public C0671a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
                d.this.a();
            }
        }

        public d(a aVar, d.a.m0.a.e2.c.j.b bVar, String str) {
            this.f45363f = bVar;
            this.f45364g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.e2.c.j.b bVar = this.f45363f;
            bVar.r(d.a.m0.a.j2.f.a(this.f45364g));
            bVar.p(new C0671a());
            this.f45363f.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends i<d.a.m0.a.v2.e1.b<ResulT>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f45366a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, Object obj) {
            super(aVar, null);
            this.f45366a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.e2.a.i
        /* renamed from: b */
        public void a(d.a.m0.a.v2.e1.b<ResulT> bVar) {
            bVar.onCallback(this.f45366a);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f45367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f45368f;

        public f(a aVar, i iVar, Object obj) {
            this.f45367e = iVar;
            this.f45368f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45367e.a(this.f45368f);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends i<j> {
        public g(a aVar) {
            super(aVar, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.e2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            jVar.a();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends d.a.m0.a.v2.d1.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f45369f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.C0891c f45370g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f45371h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45372i;
        public final /* synthetic */ d.a.m0.a.v2.e1.b j;

        /* renamed from: d.a.m0.a.e2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0672a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<f.d>> {
            public C0672a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.m0.a.e2.c.i<f.d> iVar) {
                h.this.a();
            }
        }

        public h(a aVar, Activity activity, c.C0891c c0891c, Bundle bundle, String str, d.a.m0.a.v2.e1.b bVar) {
            this.f45369f = activity;
            this.f45370g = c0891c;
            this.f45371h = bundle;
            this.f45372i = str;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.e2.c.j.f b2 = d.a.m0.a.a2.d.g().y().a().b().b(this.f45369f, this.f45370g, this.f45371h);
            b2.r(this.f45372i);
            b2.p(this.j);
            b2.p(new C0672a());
            b2.a();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class i<CallBackT> {
        public i(a aVar) {
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(a aVar, C0669a c0669a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    public a(d.a.m0.a.a2.e eVar) {
        super(eVar);
        this.f45350d = new HashSet();
        this.f45351e = new HashMap();
        this.f45352f = new d.a.m0.a.v2.d1.c();
        this.f45348b = d.a.m0.a.k2.b.t(eVar);
        this.f45349c = "aiapp_setting_" + this.f45348b;
    }

    public static void x(Runnable runnable) {
        if (d.a.m0.a.r1.l.e.g()) {
            q0.b0(runnable);
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public void A(String str, long j2) {
        o().putLong(str, j2);
    }

    public void B(String str, String str2) {
        o().putString(str, str2);
    }

    public synchronized void C(j jVar) {
        this.f45350d.add(jVar);
    }

    public void D(String str) {
        this.f45347a.remove(str);
    }

    public boolean E() {
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            d.a.m0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.m0.a.h.aiapps_open_fragment_failed_toast).F();
            return false;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(d.a.m0.a.h0.g.g.f45860g, d.a.m0.a.h0.g.g.f45862i);
        i2.k("authority", null).a();
        return true;
    }

    public synchronized void F(j jVar) {
        this.f45350d.remove(jVar);
    }

    public void c(Context context, String str, boolean z, d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> bVar) {
        d(context, str, z, true, false, bVar);
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> bVar) {
        y(context, str, z, z2, z3, bVar);
    }

    public void e(String str, d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.f> bVar) {
        if (TextUtils.isEmpty(str)) {
            u(bVar, null);
        } else {
            d.a.m0.a.n1.q.c.a.i(str, new b(bVar));
        }
    }

    public boolean f(String str) {
        if (f45346g && d.a.m0.a.u1.a.a.m()) {
            return true;
        }
        d.a.m0.a.e2.c.f k = d.a.m0.a.n1.q.c.a.k(str);
        return (k == null || k.f45481d || !k.a()) ? false : true;
    }

    public void g(Context context, String str, d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> bVar) {
        h(context, str, false, bVar);
    }

    public void h(Context context, String str, boolean z, d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> bVar) {
        e(str, new C0669a(bVar, str, z, context));
    }

    public void i() {
        o().edit().clear().apply();
    }

    public synchronized void j() {
        this.f45351e.clear();
        this.f45352f.c();
        k();
    }

    public synchronized void k() {
        this.f45350d.clear();
    }

    @SuppressLint({"ApplySharedPref"})
    public void l() {
        o().edit().clear().commit();
    }

    public boolean m(String str, boolean z) {
        return o().getBoolean(str, z);
    }

    public long n(String str, long j2) {
        return o().getLong(str, j2);
    }

    public final d.a.m0.a.k2.g.g o() {
        if (this.f45347a == null) {
            this.f45347a = new d.a.m0.a.k2.g.g(this.f45349c, false);
        }
        return this.f45347a;
    }

    public String p() {
        return this.f45349c;
    }

    public String q(String str, String str2) {
        return o().getString(str, str2);
    }

    public void r(Activity activity, c.C0891c c0891c, Bundle bundle, d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<f.d>> bVar, String str) {
        this.f45352f.d(new h(this, activity, c0891c, bundle, str, bVar));
    }

    public synchronized <CallBackT> void s(CallBackT callbackt, i<CallBackT> iVar) {
        x(new f(this, iVar, callbackt));
    }

    public synchronized <CallBackT> void t(Collection<CallBackT> collection, i<CallBackT> iVar) {
        for (CallBackT callbackt : collection) {
            s(callbackt, iVar);
        }
    }

    public final <ResulT> void u(d.a.m0.a.v2.e1.b<ResulT> bVar, ResulT result) {
        s(bVar, new e(this, result));
    }

    public void v() {
        t(this.f45350d, new g(this));
    }

    public void w(Activity activity) {
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> bVar) {
        String str2 = TextUtils.isEmpty(str) ? "" : str;
        d.a.m0.a.e2.c.j.b bVar2 = this.f45351e.get(str2);
        if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
            bVar2.p(bVar);
            return;
        }
        d.a.m0.a.e2.c.j.b d2 = d.a.m0.a.a2.d.g().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
        this.f45351e.put(str2, d2);
        d2.p(bVar);
        d2.p(new c(str2));
        d.a.m0.a.j2.k.N(d.a.m0.a.j2.f.a(str), "requestModifyScope");
        this.f45352f.d(new d(this, d2, str));
    }

    public void z(String str, boolean z) {
        o().putBoolean(str, z);
    }
}
