package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.YulePostActivity;
/* loaded from: classes3.dex */
public class m2 {

    /* renamed from: a  reason: collision with root package name */
    public String f51590a;

    /* renamed from: b  reason: collision with root package name */
    public String f51591b;

    public String a() {
        return this.f51590a;
    }

    public String b() {
        return this.f51591b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong("start_time");
            jSONObject.optLong("end_time");
            this.f51590a = jSONObject.optString("activity_banner");
            jSONObject.optString("activity_url");
            jSONObject.optString("activity_desc");
            this.f51591b = jSONObject.optString("activity_button");
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void d(YulePostActivity yulePostActivity) {
        if (yulePostActivity == null) {
            return;
        }
        Long l = yulePostActivity.start_time;
        if (l != null) {
            l.longValue();
        }
        Long l2 = yulePostActivity.end_time;
        if (l2 != null) {
            l2.longValue();
        }
        this.f51590a = yulePostActivity.activity_banner;
        String str = yulePostActivity.activity_url;
        String str2 = yulePostActivity.activity_desc;
        this.f51591b = yulePostActivity.activity_button;
    }
}
