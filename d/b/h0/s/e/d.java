package d.b.h0.s.e;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f51312a;

    /* renamed from: b  reason: collision with root package name */
    public int f51313b;

    /* renamed from: c  reason: collision with root package name */
    public int f51314c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f51315d;

    public int[] a() {
        return this.f51315d;
    }

    public int b() {
        return this.f51312a;
    }

    public int c() {
        return this.f51313b;
    }

    public int d() {
        return this.f51314c;
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
        this.f51312a = jSONObject.optInt("conn_conf");
        this.f51313b = jSONObject.optInt("continuous_fail_count");
        this.f51314c = jSONObject.optInt("restart_time_interval");
        JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
        if (optJSONArray != null) {
            this.f51315d = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.f51315d[i] = optJSONArray.optInt(i);
            }
            return;
        }
        this.f51315d = new int[0];
    }
}
