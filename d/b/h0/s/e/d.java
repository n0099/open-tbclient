package d.b.h0.s.e;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f51311a;

    /* renamed from: b  reason: collision with root package name */
    public int f51312b;

    /* renamed from: c  reason: collision with root package name */
    public int f51313c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f51314d;

    public int[] a() {
        return this.f51314d;
    }

    public int b() {
        return this.f51311a;
    }

    public int c() {
        return this.f51312b;
    }

    public int d() {
        return this.f51313c;
    }

    public void e(String str) {
        try {
            f(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f51311a = jSONObject.optInt("conn_conf");
        this.f51312b = jSONObject.optInt("continuous_fail_count");
        this.f51313c = jSONObject.optInt("restart_time_interval");
        JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
        if (optJSONArray != null) {
            this.f51314d = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.f51314d[i] = optJSONArray.optInt(i);
            }
            return;
        }
        this.f51314d = new int[0];
    }
}
