package d.b.i0.l1.k.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56735a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("error");
        if (optJSONObject != null) {
            optJSONObject.optInt("errno");
            String optString = optJSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
            this.f56735a = optString;
            if (!StringUtils.isNull(optString)) {
                this.f56735a = optJSONObject.optString("errmsg");
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            optJSONObject2.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        }
    }
}
