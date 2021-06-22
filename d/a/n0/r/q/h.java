package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import org.json.JSONObject;
import tbclient.AppCode;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f53821a;

    public String a() {
        return this.f53821a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optString("game_icon");
            this.f53821a = jSONObject.optString("post_url");
            jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void c(AppCode appCode) {
        if (appCode == null) {
            return;
        }
        String str = appCode.game_icon;
        this.f53821a = appCode.post_url;
        String str2 = appCode.button_text;
    }
}
