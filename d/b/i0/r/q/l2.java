package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes3.dex */
public class l2 {

    /* renamed from: a  reason: collision with root package name */
    public int f51586a = 0;

    /* renamed from: b  reason: collision with root package name */
    public k2 f51587b = new k2();

    public boolean a() {
        return this.f51586a != 0;
    }

    public k2 b() {
        return this.f51587b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51586a = jSONObject.optInt("activity_show");
            this.f51587b.d(jSONObject.optJSONObject("yule_activity"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(Yule yule) {
        if (yule == null) {
            return;
        }
        this.f51586a = yule.activity_show.intValue();
        this.f51587b.e(yule.yule_activity);
    }
}
