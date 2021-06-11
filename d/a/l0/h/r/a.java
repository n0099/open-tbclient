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
    public String f51333a;

    /* renamed from: b  reason: collision with root package name */
    public String f51334b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51335c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51336d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51337e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51338f;

    /* renamed from: d.a.l0.h.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1105a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51339a;

        /* renamed from: b  reason: collision with root package name */
        public String f51340b;

        public C1105a(boolean z, String str) {
            this.f51339a = false;
            this.f51339a = z;
            this.f51340b = str;
        }

        public static C1105a c() {
            return new C1105a(false, "未启用真机调试");
        }

        public String a() {
            return this.f51340b;
        }

        public boolean b() {
            return this.f51339a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f51333a = null;
        this.f51334b = null;
        this.f51335c = false;
        this.f51336d = false;
        this.f51337e = false;
        this.f51338f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f51333a = optJSONObject.optString("hostname", null);
            this.f51334b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f51335c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f51338f = z;
        if (z) {
            this.f51333a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f51333a);
            this.f51334b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f51334b);
            this.f51335c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f51335c);
            this.f51336d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f51336d);
        }
        String str = this.f51333a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f51337e = true;
    }

    public static C1105a f(a aVar) {
        return aVar == null ? C1105a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f51333a);
        if (this.f51334b != null) {
            str = ":" + this.f51334b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f51336d;
    }

    public final boolean c() {
        return d.a.l0.a.v.a.f(e.V());
    }

    public boolean d() {
        return this.f51335c;
    }

    public C1105a e() {
        if (!this.f51338f && c()) {
            return new C1105a(false, "线上包禁用真机调试");
        }
        boolean z = this.f51337e;
        return new C1105a(z, !z ? "未启用真机调试" : this.f51338f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
