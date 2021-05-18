package d.a.j0.r.q;

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
    public boolean f50059a;

    /* renamed from: b  reason: collision with root package name */
    public int f50060b;

    /* renamed from: c  reason: collision with root package name */
    public int f50061c;

    /* renamed from: d  reason: collision with root package name */
    public int f50062d;

    /* renamed from: e  reason: collision with root package name */
    public int f50063e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f50064f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f50065g = 10;

    public int a() {
        return this.f50062d;
    }

    public int b() {
        return this.f50064f;
    }

    public int c() {
        return this.f50060b;
    }

    public int d() {
        return this.f50065g;
    }

    public int e() {
        return this.f50063e;
    }

    public int f() {
        return this.f50061c;
    }

    public boolean g() {
        return this.f50059a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f50059a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f50059a = true;
            } else {
                this.f50059a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f50062d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f50061c = optJSONObject2.optInt("time");
                this.f50060b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f50063e = optJSONObject3.optInt("succ");
                this.f50064f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f50065g = optJSONObject3.optInt("slow");
            }
            if (this.f50061c <= 0 || this.f50060b <= 0 || this.f50062d <= 0) {
                this.f50059a = false;
            }
        } catch (Exception e2) {
            this.f50059a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f50059a != z) {
            d.a.c.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f50059a = z;
    }
}
