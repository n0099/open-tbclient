package d.b.i0.p0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58688e;

    /* renamed from: f  reason: collision with root package name */
    public String f58689f;

    /* renamed from: g  reason: collision with root package name */
    public String f58690g;

    /* renamed from: h  reason: collision with root package name */
    public String f58691h;
    public String i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f58688e = jSONObject.optString("id");
        this.f58689f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f58690g = jSONObject.optString("user_id");
        this.f58691h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.j = jSONObject.optString("time_passed");
        this.k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f58688e.equals(((d) obj).f58688e);
        }
        return false;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f58688e).intValue() * 31) + 7;
    }
}
