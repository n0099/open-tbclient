package d.a.m0.h.r;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.a2.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f51441a;

    /* renamed from: b  reason: collision with root package name */
    public String f51442b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51443c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51444d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51445e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51446f;

    /* renamed from: d.a.m0.h.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1108a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51447a;

        /* renamed from: b  reason: collision with root package name */
        public String f51448b;

        public C1108a(boolean z, String str) {
            this.f51447a = false;
            this.f51447a = z;
            this.f51448b = str;
        }

        public static C1108a c() {
            return new C1108a(false, "未启用真机调试");
        }

        public String a() {
            return this.f51448b;
        }

        public boolean b() {
            return this.f51447a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f51441a = null;
        this.f51442b = null;
        this.f51443c = false;
        this.f51444d = false;
        this.f51445e = false;
        this.f51446f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f51441a = optJSONObject.optString("hostname", null);
            this.f51442b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f51443c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f51446f = z;
        if (z) {
            this.f51441a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f51441a);
            this.f51442b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f51442b);
            this.f51443c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f51443c);
            this.f51444d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f51444d);
        }
        String str = this.f51441a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f51445e = true;
    }

    public static C1108a f(a aVar) {
        return aVar == null ? C1108a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f51441a);
        if (this.f51442b != null) {
            str = ":" + this.f51442b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f51444d;
    }

    public final boolean c() {
        return d.a.m0.a.v.a.f(e.V());
    }

    public boolean d() {
        return this.f51443c;
    }

    public C1108a e() {
        if (!this.f51446f && c()) {
            return new C1108a(false, "线上包禁用真机调试");
        }
        boolean z = this.f51445e;
        return new C1108a(z, !z ? "未启用真机调试" : this.f51446f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
