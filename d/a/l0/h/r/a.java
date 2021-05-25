package d.a.l0.h.r;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.a2.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47659a;

    /* renamed from: b  reason: collision with root package name */
    public String f47660b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47661c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47662d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47663e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47664f;

    /* renamed from: d.a.l0.h.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1049a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f47665a;

        /* renamed from: b  reason: collision with root package name */
        public String f47666b;

        public C1049a(boolean z, String str) {
            this.f47665a = false;
            this.f47665a = z;
            this.f47666b = str;
        }

        public static C1049a c() {
            return new C1049a(false, "未启用真机调试");
        }

        public String a() {
            return this.f47666b;
        }

        public boolean b() {
            return this.f47665a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f47659a = null;
        this.f47660b = null;
        this.f47661c = false;
        this.f47662d = false;
        this.f47663e = false;
        this.f47664f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f47659a = optJSONObject.optString("hostname", null);
            this.f47660b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f47661c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f47664f = z;
        if (z) {
            this.f47659a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f47659a);
            this.f47660b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f47660b);
            this.f47661c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f47661c);
            this.f47662d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f47662d);
        }
        String str = this.f47659a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f47663e = true;
    }

    public static C1049a f(a aVar) {
        return aVar == null ? C1049a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47659a);
        if (this.f47660b != null) {
            str = ":" + this.f47660b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f47662d;
    }

    public final boolean c() {
        return d.a.l0.a.v.a.f(e.V());
    }

    public boolean d() {
        return this.f47661c;
    }

    public C1049a e() {
        if (!this.f47664f && c()) {
            return new C1049a(false, "线上包禁用真机调试");
        }
        boolean z = this.f47663e;
        return new C1049a(z, !z ? "未启用真机调试" : this.f47664f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
