package d.b.i0.s.e;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f52065a;

    /* renamed from: b  reason: collision with root package name */
    public int f52066b;

    /* renamed from: c  reason: collision with root package name */
    public int f52067c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f52068d;

    public int[] a() {
        return this.f52068d;
    }

    public int b() {
        return this.f52065a;
    }

    public int c() {
        return this.f52066b;
    }

    public int d() {
        return this.f52067c;
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
        this.f52065a = jSONObject.optInt("conn_conf");
        this.f52066b = jSONObject.optInt("continuous_fail_count");
        this.f52067c = jSONObject.optInt("restart_time_interval");
        JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
        if (optJSONArray != null) {
            this.f52068d = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.f52068d[i] = optJSONArray.optInt(i);
            }
            return;
        }
        this.f52068d = new int[0];
    }
}
