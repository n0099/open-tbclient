package d.b.g0.g.p;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.r1.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48530a;

    /* renamed from: b  reason: collision with root package name */
    public String f48531b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48532c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48533d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48534e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48535f;

    /* renamed from: d.b.g0.g.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0987a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f48536a;

        /* renamed from: b  reason: collision with root package name */
        public String f48537b;

        public C0987a(boolean z, String str) {
            this.f48536a = false;
            this.f48536a = z;
            this.f48537b = str;
        }

        public static C0987a c() {
            return new C0987a(false, "未启用真机调试");
        }

        public String a() {
            return this.f48537b;
        }

        public boolean b() {
            return this.f48536a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f48530a = null;
        this.f48531b = null;
        this.f48532c = false;
        this.f48533d = false;
        this.f48534e = false;
        this.f48535f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f48530a = optJSONObject.optString("hostname", null);
            this.f48531b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f48532c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f48535f = z;
        if (z) {
            this.f48530a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f48530a);
            this.f48531b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f48531b);
            this.f48532c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f48532c);
            this.f48533d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f48533d);
        }
        String str = this.f48530a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f48534e = true;
    }

    public static C0987a f(a aVar) {
        return aVar == null ? C0987a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f48530a);
        if (this.f48531b != null) {
            str = ":" + this.f48531b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f48533d;
    }

    public final boolean c() {
        return d.b.g0.a.u.a.f(e.T());
    }

    public boolean d() {
        return this.f48532c;
    }

    public C0987a e() {
        if (!this.f48535f && c()) {
            return new C0987a(false, "线上包禁用真机调试");
        }
        boolean z = this.f48534e;
        return new C0987a(z, !z ? "未启用真机调试" : this.f48535f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
