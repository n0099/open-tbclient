package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes3.dex */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    public String f53749a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f53750b = 0;

    public int a() {
        return this.f53750b;
    }

    public String b() {
        return this.f53749a;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f53750b = jSONObject.optInt("class_id", 0);
            this.f53749a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(Classify classify) {
        if (classify == null) {
            return;
        }
        this.f53750b = classify.class_id.intValue();
        this.f53749a = classify.class_name;
    }
}
