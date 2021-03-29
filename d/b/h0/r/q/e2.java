package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes3.dex */
public class e2 {

    /* renamed from: a  reason: collision with root package name */
    public int f50775a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f50776b = "";

    public int a() {
        return this.f50775a;
    }

    public String b() {
        return this.f50776b;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50775a = jSONObject.optInt("is_lpost", 0);
            jSONObject.optInt("topic_type", 0);
            this.f50776b = jSONObject.optString("link", "");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(Topic topic) {
        if (topic == null) {
            return;
        }
        this.f50775a = topic.is_lpost.intValue();
        topic.topic_type.intValue();
        this.f50776b = topic.link;
    }
}
