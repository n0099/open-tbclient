package d.a.l0.a.u.e.m;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import d.a.l0.a.a2.e;
import d.a.l0.a.k2.c;
import d.a.l0.a.u.c.d;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.l0.a.u.e.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0918a implements b {
        public C0918a() {
        }

        @Override // d.a.l0.a.u.e.m.a.b
        public d.a.l0.a.u.h.b a(e eVar, String str) {
            JSONObject A = a.A(a.this.v(eVar).getString(str, null));
            if (A == null) {
                return new d.a.l0.a.u.h.b(202, "JSONException");
            }
            return new d.a.l0.a.u.h.b(0, A);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        d.a.l0.a.u.h.b a(e eVar, String str);
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    @Nullable
    public static JSONObject A(@Nullable String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("key")) {
                    jSONObject.remove("key");
                }
                return jSONObject;
            } catch (JSONException unused) {
                if (d.f48486c) {
                    Log.d("Api-Storage", "parseDataAsJsonResult:data is not json.");
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        if (str == null) {
            str = "";
        }
        try {
            jSONObject2.put("data", str);
            return jSONObject2;
        } catch (JSONException unused2) {
            return null;
        }
    }

    @Nullable
    public static String B(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String C(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }

    public d.a.l0.a.u.h.b D(String str) {
        if (d.f48486c) {
            Log.d("Api-Storage", "start remove storage");
        }
        e i2 = e.i();
        if (y() && i2 == null) {
            return new d.a.l0.a.u.h.b(1001, "swan app is null");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Storage", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.f48486c) {
                d.a.l0.a.e0.d.b("Api-Storage", "parse fail");
            }
            return bVar;
        }
        String C = C((JSONObject) b2.second);
        if (C == null) {
            return new d.a.l0.a.u.h.b(202);
        }
        v(i2).remove(C);
        H();
        return new d.a.l0.a.u.h.b(0);
    }

    public d.a.l0.a.u.h.b E(String str) {
        if (d.f48486c) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return D(str);
    }

    public d.a.l0.a.u.h.b F(String str) {
        if (d.f48486c) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new d.a.l0.a.u.h.b(1001, "exceed storage item max length");
        }
        e i2 = e.i();
        if (y() && i2 == null) {
            return new d.a.l0.a.u.h.b(1001, "swan app is null");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Storage", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.f48486c) {
                d.a.l0.a.e0.d.b("Api-Storage", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String C = C(jSONObject);
        if (C == null) {
            return new d.a.l0.a.u.h.b(202);
        }
        if (c.b(C)) {
            return new d.a.l0.a.u.h.b(1001, "exceed storage key max length");
        }
        String B = B(jSONObject);
        if (B == null) {
            return new d.a.l0.a.u.h.b(202);
        }
        if (c.c(B)) {
            return new d.a.l0.a.u.h.b(1001, "exceed storage item max length");
        }
        if (z(i2, C, B)) {
            if (d.f48486c) {
                d.a.l0.a.e0.d.b("Api-Storage", "exceed storage max length");
            }
            return new d.a.l0.a.u.h.b(1003, "exceed storage max length");
        }
        v(i2).putString(C, B);
        H();
        return new d.a.l0.a.u.h.b(0);
    }

    public d.a.l0.a.u.h.b G(String str) {
        if (d.f48486c) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return F(str);
    }

    public void H() {
        d.a.l0.a.q2.d.f47909h.b();
    }

    public d.a.l0.a.u.h.b r() {
        if (d.f48486c) {
            Log.d("Api-Storage", "start clear storage");
        }
        e i2 = e.i();
        if (y() && i2 == null) {
            return new d.a.l0.a.u.h.b(1001, "swan app is null");
        }
        v(i2).edit().clear().apply();
        H();
        return new d.a.l0.a.u.h.b(0);
    }

    public d.a.l0.a.u.h.b s() {
        if (d.f48486c) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return r();
    }

    public d.a.l0.a.u.h.b t(String str) {
        if (d.f48486c) {
            Log.d("Api-Storage", "start get storage");
        }
        return u(str, new C0918a());
    }

    public final d.a.l0.a.u.h.b u(String str, b bVar) {
        e i2 = e.i();
        if (y() && i2 == null) {
            return new d.a.l0.a.u.h.b(1001, "swan app is null");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Storage", str);
        d.a.l0.a.u.h.b bVar2 = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar2.isSuccess()) {
            if (d.f48486c) {
                d.a.l0.a.e0.d.b("Api-Storage", "parse fail");
            }
            return bVar2;
        }
        String C = C((JSONObject) b2.second);
        if (C == null) {
            return new d.a.l0.a.u.h.b(202);
        }
        return bVar.a(i2, C);
    }

    public d.a.l0.t.b v(@NonNull e eVar) {
        return eVar.U().g();
    }

    public d.a.l0.a.u.h.b w() {
        e i2 = e.i();
        if (i2 == null) {
            return new d.a.l0.a.u.h.b(1001, "swan app is null");
        }
        c U = i2.U();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) U.g().a()));
            jSONObject.put("currentSize", U.e() / 1024);
            jSONObject.put("limitSize", U.n() / 1024);
            return new d.a.l0.a.u.h.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.f48486c) {
                e2.printStackTrace();
            }
            return new d.a.l0.a.u.h.b(202, "JSONException");
        }
    }

    public d.a.l0.a.u.h.b x(String str) {
        if (d.f48486c) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return t(str);
    }

    public boolean y() {
        return true;
    }

    public boolean z(@Nullable e eVar, @NonNull String str, @NonNull String str2) {
        if (eVar == null) {
            return false;
        }
        return eVar.U().m(str, str2);
    }
}
