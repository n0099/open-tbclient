package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes3.dex */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    public String f50837a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f50838b = 0;

    public int a() {
        return this.f50838b;
    }

    public String b() {
        return this.f50837a;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50838b = jSONObject.optInt("class_id", 0);
            this.f50837a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(Classify classify) {
        if (classify == null) {
            return;
        }
        this.f50838b = classify.class_id.intValue();
        this.f50837a = classify.class_name;
    }
}
