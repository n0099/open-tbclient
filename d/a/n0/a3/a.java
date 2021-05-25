package d.a.n0.a3;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f51188a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f51189b = null;

    public int a() {
        return this.f51188a;
    }

    public String b() {
        return this.f51189b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51188a = jSONObject.optInt("errno");
            jSONObject.optString("errmsg");
            this.f51189b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
