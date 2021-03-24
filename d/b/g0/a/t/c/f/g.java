package d.b.g0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46047f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46048g;

        public a(String str, boolean z, boolean z2) {
            this.f46046e = str;
            this.f46047f = z;
            this.f46048g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            d.b.g0.a.d2.b.a s = g.s();
            if (s == null) {
                d.b.g0.a.c0.c.b("Api-TabBar", "tabBarViewController is null");
                g.this.c(this.f46046e, new d.b.g0.a.t.e.b(1001));
                return;
            }
            if (this.f46047f) {
                j = s.r(this.f46048g);
            } else {
                j = s.j(this.f46048g);
            }
            if (!j) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f46047f ? "open" : IntentConfig.CLOSE);
                sb.append("bottom bar fail");
                d.b.g0.a.c0.c.b("Api-TabBar", sb.toString());
                g.this.c(this.f46046e, new d.b.g0.a.t.e.b(1001));
            }
            g.this.c(this.f46046e, new d.b.g0.a.t.e.b(0));
        }
    }

    public g(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static d.b.g0.a.d2.b.a s() {
        d.b.g0.a.e0.l.e l;
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null || (l = W.l()) == null) {
            return null;
        }
        return l.Z2();
    }

    public static boolean u() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        return W == null || W.o() == null || !W.o().V1();
    }

    public d.b.g0.a.t.e.b q(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-TabBar", "start close tab bar");
        }
        return t(str, false);
    }

    public d.b.g0.a.t.e.b r(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-TabBar", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-TabBar", "parse fail");
            }
            return bVar;
        }
        int optInt = ((JSONObject) a2.second).optInt("index");
        if (u()) {
            d.b.g0.a.c0.c.b("Api-TabBar", "fail not TabBar page");
            return new d.b.g0.a.t.e.b(1001, "fail not TabBar page");
        }
        d.b.g0.a.d2.b.a s = s();
        if (s == null) {
            d.b.g0.a.c0.c.b("Api-TabBar", "tabBarViewController is null");
            return new d.b.g0.a.t.e.b(1001, "tabBarViewController is null");
        } else if (!s.k(optInt)) {
            d.b.g0.a.c0.c.b("Api-TabBar", "close red dot fail");
            return new d.b.g0.a.t.e.b(1001, "close red dot fail");
        } else {
            return new d.b.g0.a.t.e.b(0);
        }
    }

    public final d.b.g0.a.t.e.b t(String str, boolean z) {
        if (u()) {
            d.b.g0.a.c0.c.b("Api-TabBar", "fail not TabBar page");
            return new d.b.g0.a.t.e.b(1001, "fail not TabBar page");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-TabBar", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-TabBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-TabBar", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new a(optString, z, jSONObject.optBoolean("animation")));
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b v(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-TabBar", "start open tab bar");
        }
        return t(str, true);
    }

    public d.b.g0.a.t.e.b w(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-TabBar", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-TabBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (u()) {
            d.b.g0.a.c0.c.b("Api-TabBar", "fail not TabBar page");
            return new d.b.g0.a.t.e.b(1001, "fail not TabBar page");
        }
        d.b.g0.a.d2.b.a s = s();
        if (s == null) {
            d.b.g0.a.c0.c.b("Api-TabBar", "tabBarViewController is null");
            return new d.b.g0.a.t.e.b(1001, "tabBarViewController is null");
        } else if (!s.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            d.b.g0.a.c0.c.b("Api-TabBar", "set tab bar item fail");
            return new d.b.g0.a.t.e.b(1001, "set tab bar item fail");
        } else {
            return new d.b.g0.a.t.e.b(0);
        }
    }
}
