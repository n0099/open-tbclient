package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.MemberShowIcon;
/* loaded from: classes3.dex */
public class c0 {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optString("icon");
            jSONObject.optString("name");
            jSONObject.optString("url");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b(MemberShowIcon memberShowIcon) {
        if (memberShowIcon == null) {
            return;
        }
        String str = memberShowIcon.icon;
        String str2 = memberShowIcon.name;
        String str3 = memberShowIcon.url;
    }
}
