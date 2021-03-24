package d.b.i0.y2;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f62622a;

    /* renamed from: b  reason: collision with root package name */
    public String f62623b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, "reason", StringUtil.NULL_STRING);
            return;
        }
        try {
            this.f62622a = jSONObject.optString("banner_pic");
            this.f62623b = jSONObject.optString("banner_url");
        } catch (Exception e2) {
            BdStatisticsManager.getInstance().eventStat(null, "signall_advert_err", null, 1, "reason", e2.toString());
            BdLog.e(e2.getMessage());
        }
    }
}
