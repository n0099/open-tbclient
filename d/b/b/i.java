package d.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final Context f65033a;

    /* renamed from: b  reason: collision with root package name */
    public final q1 f65034b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f65035c;

    /* renamed from: d  reason: collision with root package name */
    public final SharedPreferences f65036d;

    /* renamed from: e  reason: collision with root package name */
    public final SharedPreferences f65037e;

    /* renamed from: f  reason: collision with root package name */
    public volatile JSONObject f65038f;

    /* renamed from: g  reason: collision with root package name */
    public volatile JSONObject f65039g;

    public i(Context context, q1 q1Var) {
        this.f65033a = context;
        this.f65034b = q1Var;
        this.f65037e = context.getSharedPreferences("embed_applog_stats", 0);
        this.f65035c = this.f65033a.getSharedPreferences("embed_header_custom", 0);
        this.f65036d = this.f65033a.getSharedPreferences("embed_last_sp_session", 0);
    }

    public SharedPreferences A() {
        return this.f65037e;
    }

    public boolean B() {
        return this.f65034b.g();
    }

    public JSONObject C() {
        return this.f65039g;
    }

    public long D() {
        return this.f65037e.getLong("app_log_last_config_time", 0L);
    }

    public int E() {
        return this.f65037e.getInt("bav_monitor_rate", 0);
    }

    public String F() {
        return this.f65034b.h();
    }

    public String G() {
        return this.f65034b.j();
    }

    public String H() {
        return this.f65034b.k();
    }

    public String I() {
        return this.f65034b.l();
    }

    public String J() {
        return this.f65034b.m();
    }

    public String K() {
        return this.f65035c.getString("header_custom_info", null);
    }

    public String L() {
        return this.f65035c.getString("ab_sdk_version", "");
    }

    public String M() {
        return this.f65035c.getString("user_unique_id", null);
    }

    public boolean N() {
        if (this.f65034b.o() == 0) {
            this.f65034b.b(!s0.b(this.f65033a).contains(":"));
        }
        return this.f65034b.o() == 1;
    }

    public long O() {
        return this.f65037e.getLong("abtest_fetch_interval", 0L);
    }

    public String P() {
        if (!TextUtils.isEmpty(this.f65034b.x())) {
            return this.f65034b.x();
        }
        return this.f65035c.getString("ab_version", null);
    }

    public JSONObject Q() {
        JSONObject jSONObject = this.f65038f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (R()) {
                        jSONObject = new JSONObject(this.f65035c.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f65038f = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean R() {
        return this.f65037e.getBoolean("bav_ab_config", false);
    }

    public boolean S() {
        return this.f65037e.getBoolean("bav_log_collect", false);
    }

    public long T() {
        return this.f65037e.getLong("session_interval", StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public long U() {
        return this.f65037e.getLong("batch_event_interval", StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
    }

    public String V() {
        return null;
    }

    public String W() {
        return this.f65034b.c();
    }

    @Nullable
    public String a() {
        return this.f65037e.getString(com.alipay.sdk.cons.b.f1825b, null);
    }

    public long b() {
        return 10000L;
    }

    public String c() {
        return this.f65034b.q();
    }

    public int d() {
        return this.f65034b.t();
    }

    public int e() {
        return this.f65034b.u();
    }

    public int f() {
        return this.f65034b.v();
    }

    public String g() {
        return this.f65034b.r();
    }

    public String h() {
        return this.f65034b.s();
    }

    public String i() {
        return this.f65034b.w();
    }

    public String j() {
        return this.f65034b.y();
    }

    public String k() {
        return this.f65034b.z();
    }

    public String l() {
        return this.f65034b.A();
    }

    public String m() {
        return this.f65034b.D() == null ? "" : this.f65034b.D();
    }

    public boolean n() {
        return this.f65034b.C();
    }

    public q1 o() {
        return this.f65034b;
    }

    public CharSequence p() {
        return this.f65034b.B();
    }

    public String q() {
        return this.f65034b.n();
    }

    public void r(long j) {
    }

    public void s(String str, int i2) {
        this.f65036d.edit().putString("session_last_day", str).putInt("session_order", i2).apply();
    }

    public void t(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public void u(JSONObject jSONObject) {
        if (r0.f65092b) {
            r0.a("setConfig, " + jSONObject.toString(), null);
        }
        this.f65039g = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.f65037e.edit();
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
        r0.f65091a = optBoolean;
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
        return this.f65036d.getString("session_last_day", "");
    }

    public void x(JSONObject jSONObject) {
        this.f65035c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public int y() {
        return this.f65036d.getInt("session_order", 0);
    }

    public void z(JSONObject jSONObject) {
        r0.a("setAbConfig, " + jSONObject.toString(), null);
        this.f65035c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f65038f = null;
    }
}
