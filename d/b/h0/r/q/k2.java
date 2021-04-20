package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes3.dex */
public class k2 {

    /* renamed from: a  reason: collision with root package name */
    public String f51239a;

    /* renamed from: b  reason: collision with root package name */
    public String f51240b;

    /* renamed from: c  reason: collision with root package name */
    public String f51241c;

    public String a() {
        return this.f51240b;
    }

    public String b() {
        return this.f51241c;
    }

    public String c() {
        return this.f51239a;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong("activity_id");
            jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f51239a = jSONObject.optString("activity_url");
            this.f51240b = jSONObject.optString("activity_all_icon");
            this.f51241c = jSONObject.optString("activity_half_icon");
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
        this.f51239a = yuleActivity.activity_url;
        this.f51240b = yuleActivity.activity_all_icon;
        this.f51241c = yuleActivity.activity_half_icon;
    }
}
