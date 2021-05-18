package d.a.k0.z2;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f63697a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f63698b = null;

    public int a() {
        return this.f63697a;
    }

    public String b() {
        return this.f63698b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f63697a = jSONObject.optInt("errno");
            jSONObject.optString("errmsg");
            this.f63698b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
