package d.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.IMConstants;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final Context f68868a;

    /* renamed from: b  reason: collision with root package name */
    public final q1 f68869b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f68870c;

    /* renamed from: d  reason: collision with root package name */
    public final SharedPreferences f68871d;

    /* renamed from: e  reason: collision with root package name */
    public final SharedPreferences f68872e;

    /* renamed from: f  reason: collision with root package name */
    public volatile JSONObject f68873f;

    /* renamed from: g  reason: collision with root package name */
    public volatile JSONObject f68874g;

    public i(Context context, q1 q1Var) {
        this.f68868a = context;
        this.f68869b = q1Var;
        this.f68872e = context.getSharedPreferences("embed_applog_stats", 0);
        this.f68870c = this.f68868a.getSharedPreferences("embed_header_custom", 0);
        this.f68871d = this.f68868a.getSharedPreferences("embed_last_sp_session", 0);
    }

    public SharedPreferences A() {
        return this.f68872e;
    }

    public boolean B() {
        return this.f68869b.g();
    }

    public JSONObject C() {
        return this.f68874g;
    }

    public long D() {
        return this.f68872e.getLong("app_log_last_config_time", 0L);
    }

    public int E() {
        return this.f68872e.getInt("bav_monitor_rate", 0);
    }

    public String F() {
        return this.f68869b.h();
    }

    public String G() {
        return this.f68869b.j();
    }

    public String H() {
        return this.f68869b.k();
    }

    public String I() {
        return this.f68869b.l();
    }

    public String J() {
        return this.f68869b.m();
    }

    public String K() {
        return this.f68870c.getString("header_custom_info", null);
    }

    public String L() {
        return this.f68870c.getString("ab_sdk_version", "");
    }

    public String M() {
        return this.f68870c.getString("user_unique_id", null);
    }

    public boolean N() {
        if (this.f68869b.o() == 0) {
            this.f68869b.b(!s0.b(this.f68868a).contains(":"));
        }
        return this.f68869b.o() == 1;
    }

    public long O() {
        return this.f68872e.getLong("abtest_fetch_interval", 0L);
    }

    public String P() {
        if (!TextUtils.isEmpty(this.f68869b.x())) {
            return this.f68869b.x();
        }
        return this.f68870c.getString("ab_version", null);
    }

    public JSONObject Q() {
        JSONObject jSONObject = this.f68873f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (R()) {
                        jSONObject = new JSONObject(this.f68870c.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f68873f = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean R() {
        return this.f68872e.getBoolean("bav_ab_config", false);
    }

    public boolean S() {
        return this.f68872e.getBoolean("bav_log_collect", false);
    }

    public long T() {
        return this.f68872e.getLong("session_interval", 30000L);
    }

    public long U() {
        return this.f68872e.getLong("batch_event_interval", 30000L);
    }

    public String V() {
        return null;
    }

    public String W() {
        return this.f68869b.c();
    }

    @Nullable
    public String a() {
        return this.f68872e.getString(com.alipay.sdk.cons.b.f1838b, null);
    }

    public long b() {
        return 10000L;
    }

    public String c() {
        return this.f68869b.q();
    }

    public int d() {
        return this.f68869b.t();
    }

    public int e() {
        return this.f68869b.u();
    }

    public int f() {
        return this.f68869b.v();
    }

    public String g() {
        return this.f68869b.r();
    }

    public String h() {
        return this.f68869b.s();
    }

    public String i() {
        return this.f68869b.w();
    }

    public String j() {
        return this.f68869b.y();
    }

    public String k() {
        return this.f68869b.z();
    }

    public String l() {
        return this.f68869b.A();
    }

    public String m() {
        return this.f68869b.D() == null ? "" : this.f68869b.D();
    }

    public boolean n() {
        return this.f68869b.C();
    }

    public q1 o() {
        return this.f68869b;
    }

    public CharSequence p() {
        return this.f68869b.B();
    }

    public String q() {
        return this.f68869b.n();
    }

    public void r(long j) {
    }

    public void s(String str, int i2) {
        this.f68871d.edit().putString("session_last_day", str).putInt("session_order", i2).apply();
    }

    public void t(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public void u(JSONObject jSONObject) {
        if (r0.f68927b) {
            r0.a("setConfig, " + jSONObject.toString(), null);
        }
        this.f68874g = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.f68872e.edit();
        long optInt = jSONObject.optInt("session_interval", 0);
        if (optInt > 0 && optInt <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
            edit.putLong("session_interval", optInt * 1000);
        } else {
            edit.remove("session_interval");
        }
        long optInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 > 0 && optInt2 <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        } else {
            edit.remove("batch_event_interval");
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 > 0 && optInt3 <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
            edit.putInt("send_launch_timely", optInt3);
        } else {
            edit.remove("send_launch_timely");
        }
        long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 > 20 && optInt4 <= IMConstants.FANS_GROUP_INFO_EXPIRED_TIME) {
            edit.putLong("abtest_fetch_interval", optInt4 * 1000);
        } else {
            edit.remove("abtest_fetch_interval");
        }
        boolean optBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (optBoolean) {
            edit.putBoolean("bav_log_collect", true);
        } else {
            edit.remove("bav_log_collect");
        }
        r0.f68926a = optBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            edit.putBoolean("bav_ab_config", true);
        } else {
            edit.remove("bav_ab_config");
        }
        int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
        if (optInt5 > 0 && optInt5 <= 100) {
            edit.putInt("bav_monitor_rate", optInt5);
            q0.b(true);
        } else {
            edit.remove("bav_monitor_rate");
            q0.b(false);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }

    public boolean v(ArrayList<z> arrayList) {
        return true;
    }

    public String w() {
        return this.f68871d.getString("session_last_day", "");
    }

    public void x(JSONObject jSONObject) {
        this.f68870c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public int y() {
        return this.f68871d.getInt("session_order", 0);
    }

    public void z(JSONObject jSONObject) {
        r0.a("setAbConfig, " + jSONObject.toString(), null);
        this.f68870c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f68873f = null;
    }
}
