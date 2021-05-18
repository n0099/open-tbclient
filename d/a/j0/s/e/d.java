package d.a.j0.s.e;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f50543a;

    /* renamed from: b  reason: collision with root package name */
    public int f50544b;

    /* renamed from: c  reason: collision with root package name */
    public int f50545c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f50546d;

    public int[] a() {
        return this.f50546d;
    }

    public int b() {
        return this.f50543a;
    }

    public int c() {
        return this.f50544b;
    }

    public int d() {
        return this.f50545c;
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
        this.f50543a = jSONObject.optInt("conn_conf");
        this.f50544b = jSONObject.optInt("continuous_fail_count");
        this.f50545c = jSONObject.optInt("restart_time_interval");
        JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
        if (optJSONArray != null) {
            this.f50546d = new int[optJSONArray.length()];
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.f50546d[i2] = optJSONArray.optInt(i2);
            }
            return;
        }
        this.f50546d = new int[0];
    }
}
