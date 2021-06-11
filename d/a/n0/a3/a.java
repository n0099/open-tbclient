package d.a.n0.a3;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f54865a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f54866b = null;

    public int a() {
        return this.f54865a;
    }

    public String b() {
        return this.f54866b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54865a = jSONObject.optInt("errno");
            jSONObject.optString("errmsg");
            this.f54866b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
