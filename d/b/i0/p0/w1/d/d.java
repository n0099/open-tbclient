package d.b.i0.p0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58689e;

    /* renamed from: f  reason: collision with root package name */
    public String f58690f;

    /* renamed from: g  reason: collision with root package name */
    public String f58691g;

    /* renamed from: h  reason: collision with root package name */
    public String f58692h;
    public String i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f58689e = jSONObject.optString("id");
        this.f58690f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f58691g = jSONObject.optString("user_id");
        this.f58692h = jSONObject.optString("user_name");
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
            return this.f58689e.equals(((d) obj).f58689e);
        }
        return false;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f58689e).intValue() * 31) + 7;
    }
}
