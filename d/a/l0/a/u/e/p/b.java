package d.a.l0.a.u.e.p;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.f2.a;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.l0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45194d = k.f43199a;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45195e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45196f;

        public a(String str, d.a.l0.a.a2.e eVar) {
            this.f45195e = str;
            this.f45196f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                if (b.f45194d) {
                    Log.d("Api-AddToDesktop", "start add to desktop");
                }
                b.this.u(this.f45196f.x(), this.f45196f);
                b.this.d(this.f45195e, new d.a.l0.a.u.h.b(0));
                return;
            }
            int b2 = iVar.b();
            b.this.d(this.f45195e, new d.a.l0.a.u.h.b(b2, d.a.l0.a.e2.c.d.f(b2)));
        }
    }

    /* renamed from: d.a.l0.a.u.e.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0868b implements a.f {
        public C0868b(b bVar) {
        }

        @Override // d.a.l0.a.f2.a.f
        public void a(int i2) {
            b.w(i2);
        }
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void w(int i2) {
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        String appId = g2.getAppId();
        String m = d.a.l0.a.j2.k.m(g2.l());
        fVar.f43190f = appId;
        fVar.f43186b = RetrieveTaskManager.KEY;
        fVar.f43185a = m;
        fVar.f43189e = "addshortcut";
        b.a L = g2.r().L();
        if (L != null) {
            fVar.f43187c = L.T();
        }
        fVar.a("appid", appId);
        fVar.a("resultstate", Integer.valueOf(i2));
        d.a.l0.a.j2.d.b(fVar);
    }

    public final void u(@NonNull Context context, @NonNull d.a.l0.a.a2.e eVar) {
        b.a N = eVar.N();
        if (N == null) {
            return;
        }
        d.a.l0.a.f2.a.k(context, N, new C0868b(this));
    }

    public d.a.l0.a.u.h.b v(String str) {
        if (f45194d) {
            Log.d("Api-AddToDesktop", "start addToDesktop action, params = " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-AddToDesktop", str);
        if (!((d.a.l0.a.u.h.b) b2.first).a()) {
            d.a.l0.a.e0.d.b("Api-AddToDesktop", "parse failed, params = " + str);
            return (d.a.l0.a.u.h.b) b2.first;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (f45194d) {
            Log.d("Api-AddToDesktop", "cb: " + optString);
        }
        if (TextUtils.isEmpty(optString)) {
            return new d.a.l0.a.u.h.b(202, "cb is required");
        }
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        Context i2 = i();
        if (!(i2 instanceof Activity) && (i2 = Q.x()) == null) {
            return new d.a.l0.a.u.h.b(1001, "the context is not an activity");
        }
        Q.T().g(i2, "scope_add_to_desktop", new a(optString, Q));
        return new d.a.l0.a.u.h.b(0);
    }
}
