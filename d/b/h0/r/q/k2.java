package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes3.dex */
public class k2 {

    /* renamed from: a  reason: collision with root package name */
    public String f50832a;

    /* renamed from: b  reason: collision with root package name */
    public String f50833b;

    /* renamed from: c  reason: collision with root package name */
    public String f50834c;

    public String a() {
        return this.f50833b;
    }

    public String b() {
        return this.f50834c;
    }

    public String c() {
        return this.f50832a;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong("activity_id");
            jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f50832a = jSONObject.optString("activity_url");
            this.f50833b = jSONObject.optString("activity_all_icon");
            this.f50834c = jSONObject.optString("activity_half_icon");
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
        this.f50832a = yuleActivity.activity_url;
        this.f50833b = yuleActivity.activity_all_icon;
        this.f50834c = yuleActivity.activity_half_icon;
    }
}
