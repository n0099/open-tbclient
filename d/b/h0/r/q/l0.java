package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes3.dex */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51245a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f51246b = 0;

    public int a() {
        return this.f51246b;
    }

    public String b() {
        return this.f51245a;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51246b = jSONObject.optInt("class_id", 0);
            this.f51245a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(Classify classify) {
        if (classify == null) {
            return;
        }
        this.f51246b = classify.class_id.intValue();
        this.f51245a = classify.class_name;
    }
}
