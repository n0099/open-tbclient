package d.b.j0.w1.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f64122a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f64123b = null;

    public int a() {
        return this.f64122a;
    }

    public String b() {
        return this.f64123b;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            d(new JSONObject(str).optJSONObject("error"));
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void d(JSONObject jSONObject) {
        try {
            this.f64122a = jSONObject.optInt("errno");
            this.f64123b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
