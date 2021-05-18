package d.a.k0.s1;

import android.text.TextUtils;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.LoginPassV6Switch;
import com.baidu.tbadk.switchs.LowVersionLoginPassV6Switch;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public void a(String str) {
        try {
            b(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray(SetImageWatermarkTypeReqMsg.SWITCH)) == null) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                if (jSONObject2 != null) {
                    String optString = jSONObject2.optString("name");
                    Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", 0));
                    if (LoginPassV6Switch.KEY.equals(optString)) {
                        SwitchManager.getInstance().turn(optString, valueOf.intValue());
                        d.a.j0.s.a.a.a();
                    }
                    if (TextUtils.equals(LowVersionLoginPassV6Switch.KEY, optString)) {
                        SwitchManager.getInstance().turn(optString, valueOf.intValue());
                        d.a.j0.s.a.a.a();
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
