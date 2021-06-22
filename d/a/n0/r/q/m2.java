package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
import tbclient.YulePostActivity;
/* loaded from: classes3.dex */
public class m2 {

    /* renamed from: a  reason: collision with root package name */
    public String f53865a;

    /* renamed from: b  reason: collision with root package name */
    public String f53866b;

    public String a() {
        return this.f53865a;
    }

    public String b() {
        return this.f53866b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong("start_time");
            jSONObject.optLong(ResultTB.ENDTIME);
            this.f53865a = jSONObject.optString("activity_banner");
            jSONObject.optString("activity_url");
            jSONObject.optString("activity_desc");
            this.f53866b = jSONObject.optString("activity_button");
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
        this.f53865a = yulePostActivity.activity_banner;
        String str = yulePostActivity.activity_url;
        String str2 = yulePostActivity.activity_desc;
        this.f53866b = yulePostActivity.activity_button;
    }
}
