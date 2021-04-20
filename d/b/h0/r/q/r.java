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
    public boolean f51273a;

    /* renamed from: b  reason: collision with root package name */
    public int f51274b;

    /* renamed from: c  reason: collision with root package name */
    public int f51275c;

    /* renamed from: d  reason: collision with root package name */
    public int f51276d;

    /* renamed from: e  reason: collision with root package name */
    public int f51277e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f51278f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f51279g = 10;

    public int a() {
        return this.f51276d;
    }

    public int b() {
        return this.f51278f;
    }

    public int c() {
        return this.f51274b;
    }

    public int d() {
        return this.f51279g;
    }

    public int e() {
        return this.f51277e;
    }

    public int f() {
        return this.f51275c;
    }

    public boolean g() {
        return this.f51273a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f51273a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f51273a = true;
            } else {
                this.f51273a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f51276d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f51275c = optJSONObject2.optInt("time");
                this.f51274b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f51277e = optJSONObject3.optInt("succ");
                this.f51278f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f51279g = optJSONObject3.optInt("slow");
            }
            if (this.f51275c <= 0 || this.f51274b <= 0 || this.f51276d <= 0) {
                this.f51273a = false;
            }
        } catch (Exception e2) {
            this.f51273a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f51273a != z) {
            d.b.c.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f51273a = z;
    }
}
