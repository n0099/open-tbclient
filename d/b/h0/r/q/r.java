package d.b.h0.r.q;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50865a;

    /* renamed from: b  reason: collision with root package name */
    public int f50866b;

    /* renamed from: c  reason: collision with root package name */
    public int f50867c;

    /* renamed from: d  reason: collision with root package name */
    public int f50868d;

    /* renamed from: e  reason: collision with root package name */
    public int f50869e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f50870f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f50871g = 10;

    public int a() {
        return this.f50868d;
    }

    public int b() {
        return this.f50870f;
    }

    public int c() {
        return this.f50866b;
    }

    public int d() {
        return this.f50871g;
    }

    public int e() {
        return this.f50869e;
    }

    public int f() {
        return this.f50867c;
    }

    public boolean g() {
        return this.f50865a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f50865a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f50865a = true;
            } else {
                this.f50865a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f50868d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f50867c = optJSONObject2.optInt("time");
                this.f50866b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f50869e = optJSONObject3.optInt("succ");
                this.f50870f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f50871g = optJSONObject3.optInt("slow");
            }
            if (this.f50867c <= 0 || this.f50866b <= 0 || this.f50868d <= 0) {
                this.f50865a = false;
            }
        } catch (Exception e2) {
            this.f50865a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f50865a != z) {
            d.b.b.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f50865a = z;
    }
}
