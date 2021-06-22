package d.a.n0.r.q;

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
    public boolean f53886a;

    /* renamed from: b  reason: collision with root package name */
    public int f53887b;

    /* renamed from: c  reason: collision with root package name */
    public int f53888c;

    /* renamed from: d  reason: collision with root package name */
    public int f53889d;

    /* renamed from: e  reason: collision with root package name */
    public int f53890e = 25;

    /* renamed from: f  reason: collision with root package name */
    public int f53891f = 25;

    /* renamed from: g  reason: collision with root package name */
    public int f53892g = 10;

    public int a() {
        return this.f53889d;
    }

    public int b() {
        return this.f53891f;
    }

    public int c() {
        return this.f53887b;
    }

    public int d() {
        return this.f53892g;
    }

    public int e() {
        return this.f53890e;
    }

    public int f() {
        return this.f53888c;
    }

    public boolean g() {
        return this.f53886a;
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            i(new JSONObject(str));
        } catch (Exception e2) {
            this.f53886a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) == 1) {
                this.f53886a = true;
            } else {
                this.f53886a = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_ERROR);
            if (optJSONObject != null) {
                this.f53889d = optJSONObject.optInt("num");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
            if (optJSONObject2 != null) {
                this.f53888c = optJSONObject2.optInt("time");
                this.f53887b = optJSONObject2.optInt("num");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
            if (optJSONObject3 != null) {
                this.f53890e = optJSONObject3.optInt("succ");
                this.f53891f = optJSONObject3.optInt(NotificationCompat.CATEGORY_ERROR);
                this.f53892g = optJSONObject3.optInt("slow");
            }
            if (this.f53888c <= 0 || this.f53887b <= 0 || this.f53889d <= 0) {
                this.f53886a = false;
            }
        } catch (Exception e2) {
            this.f53886a = false;
            BdLog.e(e2.getMessage());
        }
    }

    public void j(boolean z) {
        if (this.f53886a != z) {
            d.a.c.e.n.a logItem = ImageLogger.getLogItem();
            logItem.b("act", "fallback");
            logItem.b("result", z ? "1" : "0");
            logItem.b("type", SetImageWatermarkTypeReqMsg.SWITCH);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
        this.f53886a = z;
    }
}
