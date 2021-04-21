package d.b.j0.q0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60778e;

    /* renamed from: f  reason: collision with root package name */
    public String f60779f;

    /* renamed from: g  reason: collision with root package name */
    public String f60780g;

    /* renamed from: h  reason: collision with root package name */
    public String f60781h;
    public String i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60778e = jSONObject.optString("id");
        this.f60779f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f60780g = jSONObject.optString("user_id");
        this.f60781h = jSONObject.optString("user_name");
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
            return this.f60778e.equals(((d) obj).f60778e);
        }
        return false;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f60778e).intValue() * 31) + 7;
    }
}
