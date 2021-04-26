package d.a.j0.z2;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62973a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f62974b = null;

    public int a() {
        return this.f62973a;
    }

    public String b() {
        return this.f62974b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f62973a = jSONObject.optInt("errno");
            jSONObject.optString("errmsg");
            this.f62974b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
