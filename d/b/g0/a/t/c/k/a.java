package d.b.g0.a.t.c.k;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.a2.c;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0837a implements b {
        public C0837a(a aVar) {
        }

        @Override // d.b.g0.a.t.c.k.a.b
        public d.b.g0.a.t.e.b a(e eVar, String str) {
            String string = eVar.S().g().getString(str, null);
            if (string == null && c.f43614f) {
                return new d.b.g0.a.t.e.b(1002, "data not found");
            }
            JSONObject w = a.w(string);
            if (w == null) {
                return new d.b.g0.a.t.e.b(202, "JSONException");
            }
            return new d.b.g0.a.t.e.b(0, w);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        d.b.g0.a.t.e.b a(e eVar, String str);
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    @Nullable
    public static JSONObject w(@Nullable String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("key")) {
                    jSONObject.remove("key");
                }
                return jSONObject;
            } catch (JSONException unused) {
                if (d.f46321c) {
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
    public static String x(@NonNull JSONObject jSONObject) {
        if (c.f43615g) {
            return jSONObject.optString("data");
        }
        if (jSONObject.isNull("data")) {
            return null;
        }
        return jSONObject.optString("data");
    }

    @Nullable
    public static String y(@NonNull JSONObject jSONObject) {
        if (jSONObject.isNull("key")) {
            return null;
        }
        return jSONObject.optString("key");
    }

    public d.b.g0.a.t.e.b A(String str) {
        if (d.f46321c) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return z(str);
    }

    public d.b.g0.a.t.e.b B(String str) {
        if (d.f46321c) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new d.b.g0.a.t.e.b(1001, "exceed storage item max length");
        }
        e y = e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Storage", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.f46321c) {
                d.b.g0.a.c0.c.b("Api-Storage", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String y2 = y(jSONObject);
        if (y2 == null) {
            return new d.b.g0.a.t.e.b(202);
        }
        if (c.b(y2)) {
            return new d.b.g0.a.t.e.b(1001, "exceed storage key max length");
        }
        String x = x(jSONObject);
        if (x == null) {
            return new d.b.g0.a.t.e.b(202);
        }
        if (c.c(x)) {
            return new d.b.g0.a.t.e.b(1001, "exceed storage item max length");
        }
        c S = y.S();
        if (S.m(y2, x)) {
            if (d.f46321c) {
                d.b.g0.a.c0.c.b("Api-Storage", "exceed storage max length");
            }
            return new d.b.g0.a.t.e.b(1003, "exceed storage max length");
        }
        S.g().putString(y2, x);
        d.b.g0.a.f2.d.f44859h.b();
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b C(String str) {
        if (d.f46321c) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return B(str);
    }

    public d.b.g0.a.t.e.b q() {
        if (d.f46321c) {
            Log.d("Api-Storage", "start clear storage");
        }
        e y = e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        y.S().g().edit().clear().apply();
        d.b.g0.a.f2.d.f44859h.b();
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b r() {
        if (d.f46321c) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return q();
    }

    public d.b.g0.a.t.e.b s(String str) {
        if (d.f46321c) {
            Log.d("Api-Storage", "start get storage");
        }
        return t(str, new C0837a(this));
    }

    public final d.b.g0.a.t.e.b t(String str, b bVar) {
        e y = e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Storage", str);
        d.b.g0.a.t.e.b bVar2 = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar2.b()) {
            if (d.f46321c) {
                d.b.g0.a.c0.c.b("Api-Storage", "parse fail");
            }
            return bVar2;
        }
        String y2 = y((JSONObject) a2.second);
        if (y2 == null) {
            return new d.b.g0.a.t.e.b(202);
        }
        return bVar.a(y, y2);
    }

    public d.b.g0.a.t.e.b u() {
        e y = e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        c S = y.S();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keys", new JSONArray((Collection) S.g().a()));
            jSONObject.put("currentSize", S.e() / 1024);
            jSONObject.put("limitSize", S.n() / 1024);
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.f46321c) {
                e2.printStackTrace();
            }
            return new d.b.g0.a.t.e.b(202, "JSONException");
        }
    }

    public d.b.g0.a.t.e.b v(String str) {
        if (d.f46321c) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return s(str);
    }

    public d.b.g0.a.t.e.b z(String str) {
        if (d.f46321c) {
            Log.d("Api-Storage", "start remove storage");
        }
        e y = e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Storage", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.f46321c) {
                d.b.g0.a.c0.c.b("Api-Storage", "parse fail");
            }
            return bVar;
        }
        String y2 = y((JSONObject) a2.second);
        if (y2 == null) {
            return new d.b.g0.a.t.e.b(202);
        }
        y.S().g().remove(y2);
        d.b.g0.a.f2.d.f44859h.b();
        return new d.b.g0.a.t.e.b(0);
    }
}
