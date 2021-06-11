package d.a.n0.n1.l.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61373a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("error");
        if (optJSONObject != null) {
            optJSONObject.optInt("errno");
            String optString = optJSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
            this.f61373a = optString;
            if (!StringUtils.isNull(optString)) {
                this.f61373a = optJSONObject.optString("errmsg");
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            optJSONObject2.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        }
    }
}
