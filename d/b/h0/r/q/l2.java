package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes3.dex */
public class l2 {

    /* renamed from: a  reason: collision with root package name */
    public int f50843a = 0;

    /* renamed from: b  reason: collision with root package name */
    public k2 f50844b = new k2();

    public boolean a() {
        return this.f50843a != 0;
    }

    public k2 b() {
        return this.f50844b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50843a = jSONObject.optInt("activity_show");
            this.f50844b.d(jSONObject.optJSONObject("yule_activity"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(Yule yule) {
        if (yule == null) {
            return;
        }
        this.f50843a = yule.activity_show.intValue();
        this.f50844b.e(yule.yule_activity);
    }
}
