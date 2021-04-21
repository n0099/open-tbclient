package d.b.h0.a.e1;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45087e = k.f45772a;

    /* renamed from: f  reason: collision with root package name */
    public static String f45088f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f45089a;

    /* renamed from: b  reason: collision with root package name */
    public String f45090b;

    /* renamed from: c  reason: collision with root package name */
    public String f45091c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45092d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f45093a = new c();

        public c a() {
            return this.f45093a;
        }

        public a b(String str) {
            this.f45093a.f45090b = str;
            return this;
        }

        public a c(boolean z) {
            this.f45093a.f45092d = z;
            return this;
        }

        public a d(String str) {
            this.f45093a.f45089a = str;
            return this;
        }

        public a e(String str) {
            this.f45093a.f45091c = str;
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
            cVar.f45089a = jSONObject.optString("page");
            cVar.f45091c = jSONObject.optString("params");
            cVar.f45090b = jSONObject.optString("baseUrl");
            cVar.f45092d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f45087e) {
                String str2 = f45088f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f45090b;
    }

    public String g() {
        return this.f45089a;
    }

    public String h() {
        return this.f45091c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f45089a);
            jSONObject.put("params", this.f45091c);
            jSONObject.put("baseUrl", this.f45090b);
            jSONObject.put("isFirstPage", this.f45092d);
        } catch (JSONException e2) {
            if (f45087e) {
                String str = f45088f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f45092d = false;
    }
}
