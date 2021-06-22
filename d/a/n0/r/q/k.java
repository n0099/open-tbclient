package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Badges;
/* loaded from: classes3.dex */
public class k {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("badge_id", 0);
            jSONObject.optString("badge_url", "");
            jSONObject.optString("webview");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b(Badges badges) {
        if (badges == null) {
            return;
        }
        badges.badge_id.intValue();
        String str = badges.badge_url;
        String str2 = badges.webview;
    }
}
