package d.a.n0.a3;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f51251a;

    /* renamed from: b  reason: collision with root package name */
    public String f51252b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51251a = jSONObject.optString("banner");
            this.f51252b = jSONObject.optString("link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
