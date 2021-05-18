package d.a.i0.a.e2;

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
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.e2.c.j.f;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.k;
import d.a.i0.a.u.e.a.c;
import d.a.i0.a.v2.q0;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends d.a.i0.a.a2.f {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f41388g = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.k2.g.g f41389a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41390b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41391c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<j> f41392d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.i0.a.e2.c.j.b> f41393e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.i0.a.v2.d1.c f41394f;

    /* renamed from: d.a.i0.a.e2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0599a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f41395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41396f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f41397g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f41398h;

        /* renamed from: d.a.i0.a.e2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0600a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {
            public C0600a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
                C0599a c0599a = C0599a.this;
                a.this.u(c0599a.f41395e, iVar);
            }
        }

        public C0599a(d.a.i0.a.v2.e1.b bVar, String str, boolean z, Context context) {
            this.f41395e = bVar;
            this.f41396f = str;
            this.f41397g = z;
            this.f41398h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r8v4, types: [d.a.i0.a.e2.c.j.b$e, ResultDataT] */
        /* JADX WARN: Type inference failed for: r8v6, types: [d.a.i0.a.e2.c.j.b$e, ResultDataT] */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.f fVar) {
            d.a.i0.a.e2.c.i iVar = new d.a.i0.a.e2.c.i();
            if (a.f41388g && d.a.i0.a.u1.a.a.m()) {
                iVar.e();
                iVar.f41562a = new b.e(true, null);
                a.this.u(this.f41395e, iVar);
                return;
            }
            boolean z = false;
            boolean z2 = fVar == null;
            d.a.i0.a.e0.d.h("SwanAppSetting", "isResultNull = " + z2 + "; scope = " + this.f41396f);
            if (!z2 && !fVar.f41523d) {
                if (!this.f41397g ? fVar.j == 0 : fVar.j <= 0) {
                    z = true;
                }
                if (z) {
                    a.this.c(this.f41398h, this.f41396f, this.f41397g, new C0600a());
                    return;
                }
                if (fVar.j > 0) {
                    iVar.e();
                    iVar.f41562a = new b.e(true, null);
                } else {
                    iVar.d(new OAuthException(10003));
                }
                a.this.u(this.f41395e, iVar);
                return;
            }
            iVar.d(new OAuthException(10005));
            a.this.u(this.f41395e, iVar);
            d.a.i0.a.e0.d.i("SwanAppSetting", "checkOrAuthorize", new Exception("authorize fail"));
            d.a.i0.a.j2.k.p(10005, fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f41401e;

        public b(d.a.i0.a.v2.e1.b bVar) {
            this.f41401e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.f fVar) {
            a.this.u(this.f41401e, fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41403e;

        public c(String str) {
            this.f41403e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            a.this.f41393e.remove(this.f41403e);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.i0.a.v2.d1.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.e2.c.j.b f41405f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41406g;

        /* renamed from: d.a.i0.a.e2.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0601a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {
            public C0601a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
                d.this.a();
            }
        }

        public d(a aVar, d.a.i0.a.e2.c.j.b bVar, String str) {
            this.f41405f = bVar;
            this.f41406g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.e2.c.j.b bVar = this.f41405f;
            bVar.r(d.a.i0.a.j2.f.a(this.f41406g));
            bVar.p(new C0601a());
            this.f41405f.a();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends i<d.a.i0.a.v2.e1.b<ResulT>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f41408a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, Object obj) {
            super(aVar, null);
            this.f41408a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.e2.a.i
        /* renamed from: b */
        public void a(d.a.i0.a.v2.e1.b<ResulT> bVar) {
            bVar.onCallback(this.f41408a);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f41409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f41410f;

        public f(a aVar, i iVar, Object obj) {
            this.f41409e = iVar;
            this.f41410f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41409e.a(this.f41410f);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends i<j> {
        public g(a aVar) {
            super(aVar, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.e2.a.i
        /* renamed from: b */
        public void a(j jVar) {
            jVar.a();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends d.a.i0.a.v2.d1.a {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f41411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.C0821c f41412g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f41413h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41414i;
        public final /* synthetic */ d.a.i0.a.v2.e1.b j;

        /* renamed from: d.a.i0.a.e2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0602a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<f.d>> {
            public C0602a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.i0.a.e2.c.i<f.d> iVar) {
                h.this.a();
            }
        }

        public h(a aVar, Activity activity, c.C0821c c0821c, Bundle bundle, String str, d.a.i0.a.v2.e1.b bVar) {
            this.f41411f = activity;
            this.f41412g = c0821c;
            this.f41413h = bundle;
            this.f41414i = str;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.e2.c.j.f b2 = d.a.i0.a.a2.d.g().y().a().b().b(this.f41411f, this.f41412g, this.f41413h);
            b2.r(this.f41414i);
            b2.p(this.j);
            b2.p(new C0602a());
            b2.a();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class i<CallBackT> {
        public i(a aVar) {
        }

        public abstract void a(CallBackT callbackt);

        public /* synthetic */ i(a aVar, C0599a c0599a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    public a(d.a.i0.a.a2.e eVar) {
        super(eVar);
        this.f41392d = new HashSet();
        this.f41393e = new HashMap();
        this.f41394f = new d.a.i0.a.v2.d1.c();
        this.f41390b = d.a.i0.a.k2.b.t(eVar);
        this.f41391c = "aiapp_setting_" + this.f41390b;
    }

    public static void x(Runnable runnable) {
        if (d.a.i0.a.r1.l.e.g()) {
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
        this.f41392d.add(jVar);
    }

    public void D(String str) {
        this.f41389a.remove(str);
    }

    public boolean E() {
        d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            d.a.i0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.i0.a.h.aiapps_open_fragment_failed_toast).F();
            return false;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(d.a.i0.a.h0.g.g.f41902g, d.a.i0.a.h0.g.g.f41904i);
        i2.k("authority", null).a();
        return true;
    }

    public synchronized void F(j jVar) {
        this.f41392d.remove(jVar);
    }

    public void c(Context context, String str, boolean z, d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> bVar) {
        d(context, str, z, true, false, bVar);
    }

    public void d(Context context, String str, boolean z, boolean z2, boolean z3, d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> bVar) {
        y(context, str, z, z2, z3, bVar);
    }

    public void e(String str, d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.f> bVar) {
        if (TextUtils.isEmpty(str)) {
            u(bVar, null);
        } else {
            d.a.i0.a.n1.q.c.a.i(str, new b(bVar));
        }
    }

    public boolean f(String str) {
        if (f41388g && d.a.i0.a.u1.a.a.m()) {
            return true;
        }
        d.a.i0.a.e2.c.f k = d.a.i0.a.n1.q.c.a.k(str);
        return (k == null || k.f41523d || !k.a()) ? false : true;
    }

    public void g(Context context, String str, d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> bVar) {
        h(context, str, false, bVar);
    }

    public void h(Context context, String str, boolean z, d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> bVar) {
        e(str, new C0599a(bVar, str, z, context));
    }

    public void i() {
        o().edit().clear().apply();
    }

    public synchronized void j() {
        this.f41393e.clear();
        this.f41394f.c();
        k();
    }

    public synchronized void k() {
        this.f41392d.clear();
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

    public final d.a.i0.a.k2.g.g o() {
        if (this.f41389a == null) {
            this.f41389a = new d.a.i0.a.k2.g.g(this.f41391c, false);
        }
        return this.f41389a;
    }

    public String p() {
        return this.f41391c;
    }

    public String q(String str, String str2) {
        return o().getString(str, str2);
    }

    public void r(Activity activity, c.C0821c c0821c, Bundle bundle, d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<f.d>> bVar, String str) {
        this.f41394f.d(new h(this, activity, c0821c, bundle, str, bVar));
    }

    public synchronized <CallBackT> void s(CallBackT callbackt, i<CallBackT> iVar) {
        x(new f(this, iVar, callbackt));
    }

    public synchronized <CallBackT> void t(Collection<CallBackT> collection, i<CallBackT> iVar) {
        for (CallBackT callbackt : collection) {
            s(callbackt, iVar);
        }
    }

    public final <ResulT> void u(d.a.i0.a.v2.e1.b<ResulT> bVar, ResulT result) {
        s(bVar, new e(this, result));
    }

    public void v() {
        t(this.f41392d, new g(this));
    }

    public void w(Activity activity) {
    }

    public final void y(Context context, String str, boolean z, boolean z2, boolean z3, d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> bVar) {
        String str2 = TextUtils.isEmpty(str) ? "" : str;
        d.a.i0.a.e2.c.j.b bVar2 = this.f41393e.get(str2);
        if (bVar2 != null && TaskState.FINISHED != bVar2.f()) {
            bVar2.p(bVar);
            return;
        }
        d.a.i0.a.e2.c.j.b d2 = d.a.i0.a.a2.d.g().y().a().b().d(context, z, z2, new String[]{str2}, null, z3);
        this.f41393e.put(str2, d2);
        d2.p(bVar);
        d2.p(new c(str2));
        d.a.i0.a.j2.k.N(d.a.i0.a.j2.f.a(str), "requestModifyScope");
        this.f41394f.d(new d(this, d2, str));
    }

    public void z(String str, boolean z) {
        o().putBoolean(str, z);
    }
}
