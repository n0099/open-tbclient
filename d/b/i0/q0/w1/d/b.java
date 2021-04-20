package d.b.i0.q0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f60351f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60352e;

    public b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("id");
        this.f60352e = jSONObject.optString("user_id");
        jSONObject.optString("forum_id");
        jSONObject.optString("score");
        jSONObject.optString("create_time");
        jSONObject.optString("time_passed");
        jSONObject.optString("content");
        jSONObject.optInt("zan_num");
        jSONObject.optInt("is_zan", 0);
        jSONObject.optString("user_name");
        jSONObject.optString("portrait");
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f60351f;
    }
}
