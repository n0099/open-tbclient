package d.b.i0.p0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f58682f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58683e;

    public b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("id");
        this.f58683e = jSONObject.optString("user_id");
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

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f58682f;
    }
}
