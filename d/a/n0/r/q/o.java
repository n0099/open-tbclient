package d.a.n0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class o {
    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public abstract void parserJson(JSONObject jSONObject);
}
