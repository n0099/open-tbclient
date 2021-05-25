package d.a.l0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends d.a.l0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44976e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44977f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44978g;

        public a(String str, boolean z, boolean z2) {
            this.f44976e = str;
            this.f44977f = z;
            this.f44978g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            d.a.l0.a.o2.b.a t = g.t();
            if (t == null) {
                d.a.l0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                g.this.d(this.f44976e, new d.a.l0.a.u.h.b(1001));
                return;
            }
            if (this.f44977f) {
                j = t.r(this.f44978g);
            } else {
                j = t.j(this.f44978g);
            }
            if (!j) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f44977f ? "open" : IntentConfig.CLOSE);
                sb.append("bottom bar fail");
                d.a.l0.a.e0.d.b("Api-TabBar", sb.toString());
                g.this.d(this.f44976e, new d.a.l0.a.u.h.b(1001));
            }
            g.this.d(this.f44976e, new d.a.l0.a.u.h.b(0));
        }
    }

    public g(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static d.a.l0.a.o2.b.a t() {
        d.a.l0.a.h0.g.f l;
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W == null || (l = W.l()) == null) {
            return null;
        }
        return l.i3();
    }

    public static boolean v() {
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        return W == null || W.o() == null || !W.o().Z1();
    }

    public d.a.l0.a.u.h.b r(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-TabBar", "start close tab bar");
        }
        return u(str, false);
    }

    public d.a.l0.a.u.h.b s(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-TabBar", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.l0.a.u.c.d.f44812c) {
                d.a.l0.a.e0.d.b("Api-TabBar", "parse fail");
            }
            return bVar;
        }
        int optInt = ((JSONObject) b2.second).optInt("index");
        if (v()) {
            d.a.l0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
            return new d.a.l0.a.u.h.b(1001, "fail not TabBar page");
        }
        d.a.l0.a.o2.b.a t = t();
        if (t == null) {
            d.a.l0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
            return new d.a.l0.a.u.h.b(1001, "tabBarViewController is null");
        } else if (!t.k(optInt)) {
            d.a.l0.a.e0.d.b("Api-TabBar", "close red dot fail");
            return new d.a.l0.a.u.h.b(1001, "close red dot fail");
        } else {
            return new d.a.l0.a.u.h.b(0);
        }
    }

    public final d.a.l0.a.u.h.b u(String str, boolean z) {
        if (v()) {
            d.a.l0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
            return new d.a.l0.a.u.h.b(1001, "fail not TabBar page");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-TabBar", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.l0.a.u.c.d.f44812c) {
                d.a.l0.a.e0.d.b("Api-TabBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("Api-TabBar", "callback is null");
            return new d.a.l0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new a(optString, z, jSONObject.optBoolean("animation")));
        return new d.a.l0.a.u.h.b(0);
    }

    public d.a.l0.a.u.h.b w(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-TabBar", "start open tab bar");
        }
        return u(str, true);
    }

    public d.a.l0.a.u.h.b x(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-TabBar", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.l0.a.u.c.d.f44812c) {
                d.a.l0.a.e0.d.b("Api-TabBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        if (v()) {
            d.a.l0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
            return new d.a.l0.a.u.h.b(1001, "fail not TabBar page");
        }
        d.a.l0.a.o2.b.a t = t();
        if (t == null) {
            d.a.l0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
            return new d.a.l0.a.u.h.b(1001, "tabBarViewController is null");
        } else if (!t.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            d.a.l0.a.e0.d.b("Api-TabBar", "set tab bar item fail");
            return new d.a.l0.a.u.h.b(1001, "set tab bar item fail");
        } else {
            return new d.a.l0.a.u.h.b(0);
        }
    }
}
