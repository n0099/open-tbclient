package d.a.j0.z2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f63036a;

    /* renamed from: b  reason: collision with root package name */
    public String f63037b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f63036a = jSONObject.optString("banner");
            this.f63037b = jSONObject.optString("link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
