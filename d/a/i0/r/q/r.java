package d.a.i0.r.q;

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
    public boolean f49240a;

    /* renamed from: b  reason: collision with root package name */
    public int f49241b;

    /* renamed from: c  reason: collision with root package name */
    public int f49242c;

    /* renamed from: d  reason: collision with root package name */
    public int f49243d;

    /* renamed from: e  reason: collision with root package name */
    public int f49244e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f49245f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f49246g = 10;

    public int a() {
        return this.f49243d;
    }

    public int b() {
        return this.f49245f;
    }

    public int c() {
        return this.f49241b;
    }

    public int d() {
        return this.f49246g;
    }

    public int e() {
        return this.f49244e;
    }

    public int f() {
        return this.f49242c;
    }

    public boolean g() {
        return this.f49240a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f49240a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f49240a = true;
            } else {
                this.f49240a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f49243d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f49242c = optJSONObject2.optInt("time");
                this.f49241b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f49244e = optJSONObject3.optInt("succ");
                this.f49245f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f49246g = optJSONObject3.optInt("slow");
            }
            if (this.f49242c <= 0 || this.f49241b <= 0 || this.f49243d <= 0) {
                this.f49240a = false;
            }
        } catch (Exception e2) {
            this.f49240a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f49240a != z) {
            d.a.c.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f49240a = z;
    }
}
