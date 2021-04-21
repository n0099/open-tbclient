package d.b.j0.z2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f64746a;

    /* renamed from: b  reason: collision with root package name */
    public String f64747b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f64746a = jSONObject.optString("banner");
            this.f64747b = jSONObject.optString("link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
