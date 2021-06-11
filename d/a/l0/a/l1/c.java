package d.a.l0.a.l1;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47037e = k.f46875a;

    /* renamed from: f  reason: collision with root package name */
    public static String f47038f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f47039a;

    /* renamed from: b  reason: collision with root package name */
    public String f47040b;

    /* renamed from: c  reason: collision with root package name */
    public String f47041c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47042d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f47043a = new c();

        public c a() {
            return this.f47043a;
        }

        public a b(String str) {
            this.f47043a.f47040b = str;
            return this;
        }

        public a c(boolean z) {
            this.f47043a.f47042d = z;
            return this;
        }

        public a d(String str) {
            this.f47043a.f47039a = str;
            return this;
        }

        public a e(String str) {
            this.f47043a.f47041c = str;
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
            cVar.f47039a = jSONObject.optString("page");
            cVar.f47041c = jSONObject.optString("params");
            cVar.f47040b = jSONObject.optString("baseUrl");
            cVar.f47042d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f47037e) {
                String str2 = f47038f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f47040b;
    }

    public String g() {
        return this.f47039a;
    }

    public String h() {
        return this.f47041c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f47039a);
            jSONObject.put("params", this.f47041c);
            jSONObject.put("baseUrl", this.f47040b);
            jSONObject.put("isFirstPage", this.f47042d);
        } catch (JSONException e2) {
            if (f47037e) {
                String str = f47038f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f47042d = false;
    }
}
