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
    public String f48922a;

    /* renamed from: b  reason: collision with root package name */
    public String f48923b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48924c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48925d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48926e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48927f;

    /* renamed from: d.b.g0.g.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0999a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f48928a;

        /* renamed from: b  reason: collision with root package name */
        public String f48929b;

        public C0999a(boolean z, String str) {
            this.f48928a = false;
            this.f48928a = z;
            this.f48929b = str;
        }

        public static C0999a c() {
            return new C0999a(false, "未启用真机调试");
        }

        public String a() {
            return this.f48929b;
        }

        public boolean b() {
            return this.f48928a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f48922a = null;
        this.f48923b = null;
        this.f48924c = false;
        this.f48925d = false;
        this.f48926e = false;
        this.f48927f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f48922a = optJSONObject.optString("hostname", null);
            this.f48923b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f48924c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f48927f = z;
        if (z) {
            this.f48922a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f48922a);
            this.f48923b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f48923b);
            this.f48924c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f48924c);
            this.f48925d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f48925d);
        }
        String str = this.f48922a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f48926e = true;
    }

    public static C0999a f(a aVar) {
        return aVar == null ? C0999a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f48922a);
        if (this.f48923b != null) {
            str = ":" + this.f48923b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f48925d;
    }

    public final boolean c() {
        return d.b.g0.a.u.a.f(e.T());
    }

    public boolean d() {
        return this.f48924c;
    }

    public C0999a e() {
        if (!this.f48927f && c()) {
            return new C0999a(false, "线上包禁用真机调试");
        }
        boolean z = this.f48926e;
        return new C0999a(z, !z ? "未启用真机调试" : this.f48927f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
