package d.a.o0.x1.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f67125a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f67126b = null;

    public int a() {
        return this.f67125a;
    }

    public String b() {
        return this.f67126b;
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
            this.f67125a = jSONObject.optInt("errno");
            this.f67126b = jSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
