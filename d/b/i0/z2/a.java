package d.b.i0.z2;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f64267a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f64268b = null;

    public int a() {
        return this.f64267a;
    }

    public String b() {
        return this.f64268b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f64267a = jSONObject.optInt("errno");
            jSONObject.optString("errmsg");
            this.f64268b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
