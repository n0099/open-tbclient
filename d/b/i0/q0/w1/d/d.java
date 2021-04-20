package d.b.i0.q0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f60357e;

    /* renamed from: f  reason: collision with root package name */
    public String f60358f;

    /* renamed from: g  reason: collision with root package name */
    public String f60359g;

    /* renamed from: h  reason: collision with root package name */
    public String f60360h;
    public String i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60357e = jSONObject.optString("id");
        this.f60358f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f60359g = jSONObject.optString("user_id");
        this.f60360h = jSONObject.optString("user_name");
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
            return this.f60357e.equals(((d) obj).f60357e);
        }
        return false;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f60357e).intValue() * 31) + 7;
    }
}
