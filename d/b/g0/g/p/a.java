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
    public String f48529a;

    /* renamed from: b  reason: collision with root package name */
    public String f48530b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48531c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48532d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48533e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48534f;

    /* renamed from: d.b.g0.g.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0986a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f48535a;

        /* renamed from: b  reason: collision with root package name */
        public String f48536b;

        public C0986a(boolean z, String str) {
            this.f48535a = false;
            this.f48535a = z;
            this.f48536b = str;
        }

        public static C0986a c() {
            return new C0986a(false, "未启用真机调试");
        }

        public String a() {
            return this.f48536b;
        }

        public boolean b() {
            return this.f48535a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f48529a = null;
        this.f48530b = null;
        this.f48531c = false;
        this.f48532d = false;
        this.f48533e = false;
        this.f48534f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f48529a = optJSONObject.optString("hostname", null);
            this.f48530b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f48531c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f48534f = z;
        if (z) {
            this.f48529a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f48529a);
            this.f48530b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f48530b);
            this.f48531c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f48531c);
            this.f48532d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f48532d);
        }
        String str = this.f48529a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f48533e = true;
    }

    public static C0986a f(a aVar) {
        return aVar == null ? C0986a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f48529a);
        if (this.f48530b != null) {
            str = ":" + this.f48530b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f48532d;
    }

    public final boolean c() {
        return d.b.g0.a.u.a.f(e.T());
    }

    public boolean d() {
        return this.f48531c;
    }

    public C0986a e() {
        if (!this.f48534f && c()) {
            return new C0986a(false, "线上包禁用真机调试");
        }
        boolean z = this.f48533e;
        return new C0986a(z, !z ? "未启用真机调试" : this.f48534f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
