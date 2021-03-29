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
    public boolean f50866a;

    /* renamed from: b  reason: collision with root package name */
    public int f50867b;

    /* renamed from: c  reason: collision with root package name */
    public int f50868c;

    /* renamed from: d  reason: collision with root package name */
    public int f50869d;

    /* renamed from: e  reason: collision with root package name */
    public int f50870e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f50871f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f50872g = 10;

    public int a() {
        return this.f50869d;
    }

    public int b() {
        return this.f50871f;
    }

    public int c() {
        return this.f50867b;
    }

    public int d() {
        return this.f50872g;
    }

    public int e() {
        return this.f50870e;
    }

    public int f() {
        return this.f50868c;
    }

    public boolean g() {
        return this.f50866a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f50866a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f50866a = true;
            } else {
                this.f50866a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f50869d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f50868c = optJSONObject2.optInt("time");
                this.f50867b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f50870e = optJSONObject3.optInt("succ");
                this.f50871f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f50872g = optJSONObject3.optInt("slow");
            }
            if (this.f50868c <= 0 || this.f50867b <= 0 || this.f50869d <= 0) {
                this.f50866a = false;
            }
        } catch (Exception e2) {
            this.f50866a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f50866a != z) {
            d.b.b.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f50866a = z;
    }
}
