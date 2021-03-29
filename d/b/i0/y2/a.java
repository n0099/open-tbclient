package d.b.i0.y2;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62606a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f62607b = null;

    public int a() {
        return this.f62606a;
    }

    public String b() {
        return this.f62607b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f62606a = jSONObject.optInt("errno");
            jSONObject.optString("errmsg");
            this.f62607b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
