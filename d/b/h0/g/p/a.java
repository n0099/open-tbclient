package d.b.h0.g.p;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.r1.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49251a;

    /* renamed from: b  reason: collision with root package name */
    public String f49252b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49253c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49254d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49255e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49256f;

    /* renamed from: d.b.h0.g.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1019a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f49257a;

        /* renamed from: b  reason: collision with root package name */
        public String f49258b;

        public C1019a(boolean z, String str) {
            this.f49257a = false;
            this.f49257a = z;
            this.f49258b = str;
        }

        public static C1019a c() {
            return new C1019a(false, "未启用真机调试");
        }

        public String a() {
            return this.f49258b;
        }

        public boolean b() {
            return this.f49257a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f49251a = null;
        this.f49252b = null;
        this.f49253c = false;
        this.f49254d = false;
        this.f49255e = false;
        this.f49256f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f49251a = optJSONObject.optString("hostname", null);
            this.f49252b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f49253c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f49256f = z;
        if (z) {
            this.f49251a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f49251a);
            this.f49252b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f49252b);
            this.f49253c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f49253c);
            this.f49254d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f49254d);
        }
        String str = this.f49251a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f49255e = true;
    }

    public static C1019a f(a aVar) {
        return aVar == null ? C1019a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f49251a);
        if (this.f49252b != null) {
            str = ":" + this.f49252b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f49254d;
    }

    public final boolean c() {
        return d.b.h0.a.u.a.f(e.T());
    }

    public boolean d() {
        return this.f49253c;
    }

    public C1019a e() {
        if (!this.f49256f && c()) {
            return new C1019a(false, "线上包禁用真机调试");
        }
        boolean z = this.f49255e;
        return new C1019a(z, !z ? "未启用真机调试" : this.f49256f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
