package d.b.g0.a.e1;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44365e = k.f45050a;

    /* renamed from: f  reason: collision with root package name */
    public static String f44366f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f44367a;

    /* renamed from: b  reason: collision with root package name */
    public String f44368b;

    /* renamed from: c  reason: collision with root package name */
    public String f44369c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44370d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f44371a = new c();

        public c a() {
            return this.f44371a;
        }

        public a b(String str) {
            this.f44371a.f44368b = str;
            return this;
        }

        public a c(boolean z) {
            this.f44371a.f44370d = z;
            return this;
        }

        public a d(String str) {
            this.f44371a.f44367a = str;
            return this;
        }

        public a e(String str) {
            this.f44371a.f44369c = str;
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
            cVar.f44367a = jSONObject.optString("page");
            cVar.f44369c = jSONObject.optString("params");
            cVar.f44368b = jSONObject.optString("baseUrl");
            cVar.f44370d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f44365e) {
                String str2 = f44366f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f44368b;
    }

    public String g() {
        return this.f44367a;
    }

    public String h() {
        return this.f44369c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f44367a);
            jSONObject.put("params", this.f44369c);
            jSONObject.put("baseUrl", this.f44368b);
            jSONObject.put("isFirstPage", this.f44370d);
        } catch (JSONException e2) {
            if (f44365e) {
                String str = f44366f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f44370d = false;
    }
}
