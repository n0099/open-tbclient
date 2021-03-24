package d.b.i0.y2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f62663a;

    /* renamed from: b  reason: collision with root package name */
    public String f62664b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f62663a = jSONObject.optString("banner");
            this.f62664b = jSONObject.optString("link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
