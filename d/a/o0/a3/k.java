package d.a.o0.a3;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f55053a;

    /* renamed from: b  reason: collision with root package name */
    public String f55054b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f55053a = jSONObject.optString("banner");
            this.f55054b = jSONObject.optString("link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
