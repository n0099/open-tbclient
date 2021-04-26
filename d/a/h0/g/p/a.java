package d.a.h0.g.p;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.r1.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46745a;

    /* renamed from: b  reason: collision with root package name */
    public String f46746b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46747c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46748d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46749e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46750f;

    /* renamed from: d.a.h0.g.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0958a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f46751a;

        /* renamed from: b  reason: collision with root package name */
        public String f46752b;

        public C0958a(boolean z, String str) {
            this.f46751a = false;
            this.f46751a = z;
            this.f46752b = str;
        }

        public static C0958a c() {
            return new C0958a(false, "未启用真机调试");
        }

        public String a() {
            return this.f46752b;
        }

        public boolean b() {
            return this.f46751a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f46745a = null;
        this.f46746b = null;
        this.f46747c = false;
        this.f46748d = false;
        this.f46749e = false;
        this.f46750f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f46745a = optJSONObject.optString("hostname", null);
            this.f46746b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f46747c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f46750f = z;
        if (z) {
            this.f46745a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f46745a);
            this.f46746b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f46746b);
            this.f46747c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f46747c);
            this.f46748d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f46748d);
        }
        String str = this.f46745a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f46749e = true;
    }

    public static C0958a f(a aVar) {
        return aVar == null ? C0958a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f46745a);
        if (this.f46746b != null) {
            str = ":" + this.f46746b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f46748d;
    }

    public final boolean c() {
        return d.a.h0.a.u.a.f(e.T());
    }

    public boolean d() {
        return this.f46747c;
    }

    public C0958a e() {
        if (!this.f46750f && c()) {
            return new C0958a(false, "线上包禁用真机调试");
        }
        boolean z = this.f46749e;
        return new C0958a(z, !z ? "未启用真机调试" : this.f46750f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
