package d.b.g0.a.e1;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44366e = k.f45051a;

    /* renamed from: f  reason: collision with root package name */
    public static String f44367f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f44368a;

    /* renamed from: b  reason: collision with root package name */
    public String f44369b;

    /* renamed from: c  reason: collision with root package name */
    public String f44370c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44371d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f44372a = new c();

        public c a() {
            return this.f44372a;
        }

        public a b(String str) {
            this.f44372a.f44369b = str;
            return this;
        }

        public a c(boolean z) {
            this.f44372a.f44371d = z;
            return this;
        }

        public a d(String str) {
            this.f44372a.f44368a = str;
            return this;
        }

        public a e(String str) {
            this.f44372a.f44370c = str;
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
            cVar.f44368a = jSONObject.optString("page");
            cVar.f44370c = jSONObject.optString("params");
            cVar.f44369b = jSONObject.optString("baseUrl");
            cVar.f44371d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f44366e) {
                String str2 = f44367f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f44369b;
    }

    public String g() {
        return this.f44368a;
    }

    public String h() {
        return this.f44370c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f44368a);
            jSONObject.put("params", this.f44370c);
            jSONObject.put("baseUrl", this.f44369b);
            jSONObject.put("isFirstPage", this.f44371d);
        } catch (JSONException e2) {
            if (f44366e) {
                String str = f44367f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f44371d = false;
    }
}
