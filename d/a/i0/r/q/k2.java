package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes3.dex */
public class k2 {

    /* renamed from: a  reason: collision with root package name */
    public String f49204a;

    /* renamed from: b  reason: collision with root package name */
    public String f49205b;

    /* renamed from: c  reason: collision with root package name */
    public String f49206c;

    public String a() {
        return this.f49205b;
    }

    public String b() {
        return this.f49206c;
    }

    public String c() {
        return this.f49204a;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong("activity_id");
            jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f49204a = jSONObject.optString("activity_url");
            this.f49205b = jSONObject.optString("activity_all_icon");
            this.f49206c = jSONObject.optString("activity_half_icon");
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void e(YuleActivity yuleActivity) {
        if (yuleActivity == null) {
            return;
        }
        yuleActivity.activity_id.longValue();
        yuleActivity.activity_type.intValue();
        this.f49204a = yuleActivity.activity_url;
        this.f49205b = yuleActivity.activity_all_icon;
        this.f49206c = yuleActivity.activity_half_icon;
    }
}
