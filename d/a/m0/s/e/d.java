package d.a.m0.s.e;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f50616a;

    /* renamed from: b  reason: collision with root package name */
    public int f50617b;

    /* renamed from: c  reason: collision with root package name */
    public int f50618c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f50619d;

    public int[] a() {
        return this.f50619d;
    }

    public int b() {
        return this.f50616a;
    }

    public int c() {
        return this.f50617b;
    }

    public int d() {
        return this.f50618c;
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
        this.f50616a = jSONObject.optInt("conn_conf");
        this.f50617b = jSONObject.optInt("continuous_fail_count");
        this.f50618c = jSONObject.optInt("restart_time_interval");
        JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
        if (optJSONArray != null) {
            this.f50619d = new int[optJSONArray.length()];
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.f50619d[i2] = optJSONArray.optInt(i2);
            }
            return;
        }
        this.f50619d = new int[0];
    }
}
