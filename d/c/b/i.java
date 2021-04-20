package d.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final Context f65851a;

    /* renamed from: b  reason: collision with root package name */
    public final q1 f65852b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f65853c;

    /* renamed from: d  reason: collision with root package name */
    public final SharedPreferences f65854d;

    /* renamed from: e  reason: collision with root package name */
    public final SharedPreferences f65855e;

    /* renamed from: f  reason: collision with root package name */
    public volatile JSONObject f65856f;

    /* renamed from: g  reason: collision with root package name */
    public volatile JSONObject f65857g;

    public i(Context context, q1 q1Var) {
        this.f65851a = context;
        this.f65852b = q1Var;
        this.f65855e = context.getSharedPreferences("embed_applog_stats", 0);
        this.f65853c = this.f65851a.getSharedPreferences("embed_header_custom", 0);
        this.f65854d = this.f65851a.getSharedPreferences("embed_last_sp_session", 0);
    }

    public SharedPreferences A() {
        return this.f65855e;
    }

    public boolean B() {
        return this.f65852b.g();
    }

    public JSONObject C() {
        return this.f65857g;
    }

    public long D() {
        return this.f65855e.getLong("app_log_last_config_time", 0L);
    }

    public int E() {
        return this.f65855e.getInt("bav_monitor_rate", 0);
    }

    public String F() {
        return this.f65852b.h();
    }

    public String G() {
        return this.f65852b.j();
    }

    public String H() {
        return this.f65852b.k();
    }

    public String I() {
        return this.f65852b.l();
    }

    public String J() {
        return this.f65852b.m();
    }

    public String K() {
        return this.f65853c.getString("header_custom_info", null);
    }

    public String L() {
        return this.f65853c.getString("ab_sdk_version", "");
    }

    public String M() {
        return this.f65853c.getString("user_unique_id", null);
    }

    public boolean N() {
        if (this.f65852b.o() == 0) {
            this.f65852b.b(!s0.b(this.f65851a).contains(":"));
        }
        return this.f65852b.o() == 1;
    }

    public long O() {
        return this.f65855e.getLong("abtest_fetch_interval", 0L);
    }

    public String P() {
        if (!TextUtils.isEmpty(this.f65852b.x())) {
            return this.f65852b.x();
        }
        return this.f65853c.getString("ab_version", null);
    }

    public JSONObject Q() {
        JSONObject jSONObject = this.f65856f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (R()) {
                        jSONObject = new JSONObject(this.f65853c.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f65856f = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean R() {
        return this.f65855e.getBoolean("bav_ab_config", false);
    }

    public boolean S() {
        return this.f65855e.getBoolean("bav_log_collect", false);
    }

    public long T() {
        return this.f65855e.getLong("session_interval", StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public long U() {
        return this.f65855e.getLong("batch_event_interval", StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public String V() {
        return null;
    }

    public String W() {
        return this.f65852b.c();
    }

    @Nullable
    public String a() {
        return this.f65855e.getString(com.alipay.sdk.cons.b.f1877b, null);
    }

    public long b() {
        return 10000L;
    }

    public String c() {
        return this.f65852b.q();
    }

    public int d() {
        return this.f65852b.t();
    }

    public int e() {
        return this.f65852b.u();
    }

    public int f() {
        return this.f65852b.v();
    }

    public String g() {
        return this.f65852b.r();
    }

    public String h() {
        return this.f65852b.s();
    }

    public String i() {
        return this.f65852b.w();
    }

    public String j() {
        return this.f65852b.y();
    }

    public String k() {
        return this.f65852b.z();
    }

    public String l() {
        return this.f65852b.A();
    }

    public String m() {
        return this.f65852b.D() == null ? "" : this.f65852b.D();
    }

    public boolean n() {
        return this.f65852b.C();
    }

    public q1 o() {
        return this.f65852b;
    }

    public CharSequence p() {
        return this.f65852b.B();
    }

    public String q() {
        return this.f65852b.n();
    }

    public void r(long j) {
    }

    public void s(String str, int i) {
        this.f65854d.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public void t(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public void u(JSONObject jSONObject) {
        if (r0.f65909b) {
            r0.a("setConfig, " + jSONObject.toString(), null);
        }
        this.f65857g = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.f65855e.edit();
        long optInt = jSONObject.optInt("session_interval", 0);
        if (optInt > 0 && optInt <= 604800) {
            edit.putLong("session_interval", optInt * 1000);
        } else {
            edit.remove("session_interval");
        }
        long optInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 > 0 && optInt2 <= 604800) {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        } else {
            edit.remove("batch_event_interval");
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 > 0 && optInt3 <= 604800) {
            edit.putInt("send_launch_timely", optInt3);
        } else {
            edit.remove("send_launch_timely");
        }
        long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 > 20 && optInt4 <= 604800) {
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
        r0.f65908a = optBoolean;
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
        return this.f65854d.getString("session_last_day", "");
    }

    public void x(JSONObject jSONObject) {
        this.f65853c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public int y() {
        return this.f65854d.getInt("session_order", 0);
    }

    public void z(JSONObject jSONObject) {
        r0.a("setAbConfig, " + jSONObject.toString(), null);
        this.f65853c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f65856f = null;
    }
}
