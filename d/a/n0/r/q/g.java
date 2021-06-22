package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes3.dex */
public class g {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong("activity_id");
            jSONObject.optString("main_title");
            jSONObject.optString("sub_title");
            jSONObject.optInt("back_pic_width");
            jSONObject.optInt("back_pic_height");
            jSONObject.optString("back_pic");
            jSONObject.optString("subpage_link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            return;
        }
        try {
            activityInfo.activity_id.longValue();
            String str = activityInfo.main_title;
            String str2 = activityInfo.sub_title;
            activityInfo.back_pic_width.intValue();
            activityInfo.back_pic_height.intValue();
            String str3 = activityInfo.back_pic;
            String str4 = activityInfo.subpage_link;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
