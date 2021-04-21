package d.b.j0.z2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f64705a;

    /* renamed from: b  reason: collision with root package name */
    public String f64706b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, "reason", StringUtil.NULL_STRING);
            return;
        }
        try {
            this.f64705a = jSONObject.optString("banner_pic");
            this.f64706b = jSONObject.optString("banner_url");
        } catch (Exception e2) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, "reason", e2.toString());
            BdLog.e(e2.getMessage());
        }
    }
}
