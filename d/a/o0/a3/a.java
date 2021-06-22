package d.a.o0.a3;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f54990a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f54991b = null;

    public int a() {
        return this.f54990a;
    }

    public String b() {
        return this.f54991b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54990a = jSONObject.optInt("errno");
            jSONObject.optString("errmsg");
            this.f54991b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
