package d.a.m0.r.q;

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
    public boolean f50103a;

    /* renamed from: b  reason: collision with root package name */
    public int f50104b;

    /* renamed from: c  reason: collision with root package name */
    public int f50105c;

    /* renamed from: d  reason: collision with root package name */
    public int f50106d;

    /* renamed from: e  reason: collision with root package name */
    public int f50107e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f50108f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f50109g = 10;

    public int a() {
        return this.f50106d;
    }

    public int b() {
        return this.f50108f;
    }

    public int c() {
        return this.f50104b;
    }

    public int d() {
        return this.f50109g;
    }

    public int e() {
        return this.f50107e;
    }

    public int f() {
        return this.f50105c;
    }

    public boolean g() {
        return this.f50103a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f50103a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f50103a = true;
            } else {
                this.f50103a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f50106d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f50105c = optJSONObject2.optInt("time");
                this.f50104b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f50107e = optJSONObject3.optInt("succ");
                this.f50108f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f50109g = optJSONObject3.optInt("slow");
            }
            if (this.f50105c <= 0 || this.f50104b <= 0 || this.f50106d <= 0) {
                this.f50103a = false;
            }
        } catch (Exception e2) {
            this.f50103a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f50103a != z) {
            d.a.c.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f50103a = z;
    }
}
