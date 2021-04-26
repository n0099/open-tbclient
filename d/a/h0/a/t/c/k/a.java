package d.a.h0.a.t.c.k;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import d.a.h0.a.a2.c;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.b.d;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.h0.a.t.c.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0796a implements b {
        public C0796a(a aVar) {
        }

        @Override // d.a.h0.a.t.c.k.a.b
        public d.a.h0.a.t.e.b a(e eVar, String str) {
            String string = eVar.S().g().getString(str, null);
            if (string == null && c.f41212f) {
                return new d.a.h0.a.t.e.b(1002, "data not found");
            }
            JSONObject w = a.w(string);
            if (w == null) {
                return new d.a.h0.a.t.e.b(202, "JSONException");
            }
            return new d.a.h0.a.t.e.b(0, w);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        d.a.h0.a.t.e.b a(e eVar, String str);
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
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
                if (d.f44021c) {
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
        if (c.f41213g) {
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

    public d.a.h0.a.t.e.b A(String str) {
        if (d.f44021c) {
            Log.d("Api-Storage", "start remove storage sync");
        }
        return z(str);
    }

    public d.a.h0.a.t.e.b B(String str) {
        if (d.f44021c) {
            Log.d("Api-Storage", "start set storage");
        }
        if (str != null && str.length() > 3145728) {
            return new d.a.h0.a.t.e.b(1001, "exceed storage item max length");
        }
        e h2 = e.h();
        if (h2 == null) {
            return new d.a.h0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-Storage", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.f44021c) {
                d.a.h0.a.c0.c.b("Api-Storage", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String y = y(jSONObject);
        if (y == null) {
            return new d.a.h0.a.t.e.b(202);
        }
        if (c.b(y)) {
            return new d.a.h0.a.t.e.b(1001, "exceed storage key max length");
        }
        String x = x(jSONObject);
        if (x == null) {
            return new d.a.h0.a.t.e.b(202);
        }
        if (c.c(x)) {
            return new d.a.h0.a.t.e.b(1001, "exceed storage item max length");
        }
        c S = h2.S();
        if (S.m(y, x)) {
            if (d.f44021c) {
                d.a.h0.a.c0.c.b("Api-Storage", "exceed storage max length");
            }
            return new d.a.h0.a.t.e.b(1003, "exceed storage max length");
        }
        S.g().putString(y, x);
        d.a.h0.a.f2.d.f42499h.b();
        return new d.a.h0.a.t.e.b(0);
    }

    public d.a.h0.a.t.e.b C(String str) {
        if (d.f44021c) {
            Log.d("Api-Storage", "start set storage sync");
        }
        return B(str);
    }

    public d.a.h0.a.t.e.b q() {
        if (d.f44021c) {
            Log.d("Api-Storage", "start clear storage");
        }
        e h2 = e.h();
        if (h2 == null) {
            return new d.a.h0.a.t.e.b(1001, "swan app is null");
        }
        h2.S().g().edit().clear().apply();
        d.a.h0.a.f2.d.f42499h.b();
        return new d.a.h0.a.t.e.b(0);
    }

    public d.a.h0.a.t.e.b r() {
        if (d.f44021c) {
            Log.d("Api-Storage", "start clear storage sync");
        }
        return q();
    }

    public d.a.h0.a.t.e.b s(String str) {
        if (d.f44021c) {
            Log.d("Api-Storage", "start get storage");
        }
        return t(str, new C0796a(this));
    }

    public final d.a.h0.a.t.e.b t(String str, b bVar) {
        e h2 = e.h();
        if (h2 == null) {
            return new d.a.h0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-Storage", str);
        d.a.h0.a.t.e.b bVar2 = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar2.a()) {
            if (d.f44021c) {
                d.a.h0.a.c0.c.b("Api-Storage", "parse fail");
            }
            return bVar2;
        }
        String y = y((JSONObject) a2.second);
        if (y == null) {
            return new d.a.h0.a.t.e.b(202);
        }
        return bVar.a(h2, y);
    }

    public d.a.h0.a.t.e.b u() {
        e h2 = e.h();
        if (h2 == null) {
            return new d.a.h0.a.t.e.b(1001, "swan app is null");
        }
        c S = h2.S();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) S.g().a()));
            jSONObject.put("currentSize", S.e() / 1024);
            jSONObject.put("limitSize", S.n() / 1024);
            return new d.a.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.f44021c) {
                e2.printStackTrace();
            }
            return new d.a.h0.a.t.e.b(202, "JSONException");
        }
    }

    public d.a.h0.a.t.e.b v(String str) {
        if (d.f44021c) {
            Log.d("Api-Storage", "start get storage sync");
        }
        return s(str);
    }

    public d.a.h0.a.t.e.b z(String str) {
        if (d.f44021c) {
            Log.d("Api-Storage", "start remove storage");
        }
        e h2 = e.h();
        if (h2 == null) {
            return new d.a.h0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-Storage", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.f44021c) {
                d.a.h0.a.c0.c.b("Api-Storage", "parse fail");
            }
            return bVar;
        }
        String y = y((JSONObject) a2.second);
        if (y == null) {
            return new d.a.h0.a.t.e.b(202);
        }
        h2.S().g().remove(y);
        d.a.h0.a.f2.d.f42499h.b();
        return new d.a.h0.a.t.e.b(0);
    }
}
