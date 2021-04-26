package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes3.dex */
public class l2 {

    /* renamed from: a  reason: collision with root package name */
    public int f49215a = 0;

    /* renamed from: b  reason: collision with root package name */
    public k2 f49216b = new k2();

    public boolean a() {
        return this.f49215a != 0;
    }

    public k2 b() {
        return this.f49216b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49215a = jSONObject.optInt("activity_show");
            this.f49216b.d(jSONObject.optJSONObject("yule_activity"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(Yule yule) {
        if (yule == null) {
            return;
        }
        this.f49215a = yule.activity_show.intValue();
        this.f49216b.e(yule.yule_activity);
    }
}
