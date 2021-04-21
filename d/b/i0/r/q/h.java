package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.AppCode;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f51547a;

    public String a() {
        return this.f51547a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optString("game_icon");
            this.f51547a = jSONObject.optString("post_url");
            jSONObject.optString("button_text");
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void c(AppCode appCode) {
        if (appCode == null) {
            return;
        }
        String str = appCode.game_icon;
        this.f51547a = appCode.post_url;
        String str2 = appCode.button_text;
    }
}
