package d.b.i0.r.q;

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
    public boolean f51609a;

    /* renamed from: b  reason: collision with root package name */
    public int f51610b;

    /* renamed from: c  reason: collision with root package name */
    public int f51611c;

    /* renamed from: d  reason: collision with root package name */
    public int f51612d;

    /* renamed from: e  reason: collision with root package name */
    public int f51613e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f51614f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f51615g = 10;

    public int a() {
        return this.f51612d;
    }

    public int b() {
        return this.f51614f;
    }

    public int c() {
        return this.f51610b;
    }

    public int d() {
        return this.f51615g;
    }

    public int e() {
        return this.f51613e;
    }

    public int f() {
        return this.f51611c;
    }

    public boolean g() {
        return this.f51609a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f51609a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f51609a = true;
            } else {
                this.f51609a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f51612d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f51611c = optJSONObject2.optInt("time");
                this.f51610b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f51613e = optJSONObject3.optInt("succ");
                this.f51614f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f51615g = optJSONObject3.optInt("slow");
            }
            if (this.f51611c <= 0 || this.f51610b <= 0 || this.f51612d <= 0) {
                this.f51609a = false;
            }
        } catch (Exception e2) {
            this.f51609a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f51609a != z) {
            d.b.c.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f51609a = z;
    }
}
