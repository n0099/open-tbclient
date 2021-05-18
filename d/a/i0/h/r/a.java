package d.a.i0.h.r;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.a2.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47483a;

    /* renamed from: b  reason: collision with root package name */
    public String f47484b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47485c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47486d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47487e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47488f;

    /* renamed from: d.a.i0.h.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1038a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f47489a;

        /* renamed from: b  reason: collision with root package name */
        public String f47490b;

        public C1038a(boolean z, String str) {
            this.f47489a = false;
            this.f47489a = z;
            this.f47490b = str;
        }

        public static C1038a c() {
            return new C1038a(false, "未启用真机调试");
        }

        public String a() {
            return this.f47490b;
        }

        public boolean b() {
            return this.f47489a;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f47483a = null;
        this.f47484b = null;
        this.f47485c = false;
        this.f47486d = false;
        this.f47487e = false;
        this.f47488f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f47483a = optJSONObject.optString("hostname", null);
            this.f47484b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f47485c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f47488f = z;
        if (z) {
            this.f47483a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f47483a);
            this.f47484b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f47484b);
            this.f47485c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f47485c);
            this.f47486d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f47486d);
        }
        String str = this.f47483a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f47487e = true;
    }

    public static C1038a f(a aVar) {
        return aVar == null ? C1038a.c() : aVar.e();
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47483a);
        if (this.f47484b != null) {
            str = ":" + this.f47484b;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean b() {
        return this.f47486d;
    }

    public final boolean c() {
        return d.a.i0.a.v.a.f(e.V());
    }

    public boolean d() {
        return this.f47485c;
    }

    public C1038a e() {
        if (!this.f47488f && c()) {
            return new C1038a(false, "线上包禁用真机调试");
        }
        boolean z = this.f47487e;
        return new C1038a(z, !z ? "未启用真机调试" : this.f47488f ? "使用了 debug 面板配置" : "启用了真机调试");
    }
}
