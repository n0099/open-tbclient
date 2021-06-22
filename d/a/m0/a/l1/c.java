package d.a.m0.a.l1;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47145e = k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public static String f47146f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f47147a;

    /* renamed from: b  reason: collision with root package name */
    public String f47148b;

    /* renamed from: c  reason: collision with root package name */
    public String f47149c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47150d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f47151a = new c();

        public c a() {
            return this.f47151a;
        }

        public a b(String str) {
            this.f47151a.f47148b = str;
            return this;
        }

        public a c(boolean z) {
            this.f47151a.f47150d = z;
            return this;
        }

        public a d(String str) {
            this.f47151a.f47147a = str;
            return this;
        }

        public a e(String str) {
            this.f47151a.f47149c = str;
            return this;
        }
    }

    public static c e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.f47147a = jSONObject.optString("page");
            cVar.f47149c = jSONObject.optString("params");
            cVar.f47148b = jSONObject.optString("baseUrl");
            cVar.f47150d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f47145e) {
                String str2 = f47146f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f47148b;
    }

    public String g() {
        return this.f47147a;
    }

    public String h() {
        return this.f47149c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f47147a);
            jSONObject.put("params", this.f47149c);
            jSONObject.put("baseUrl", this.f47148b);
            jSONObject.put("isFirstPage", this.f47150d);
        } catch (JSONException e2) {
            if (f47145e) {
                String str = f47146f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f47150d = false;
    }
}
