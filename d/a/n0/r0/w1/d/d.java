package d.a.n0.r0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59773e;

    /* renamed from: f  reason: collision with root package name */
    public String f59774f;

    /* renamed from: g  reason: collision with root package name */
    public String f59775g;

    /* renamed from: h  reason: collision with root package name */
    public String f59776h;

    /* renamed from: i  reason: collision with root package name */
    public String f59777i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f59773e = jSONObject.optString("id");
        this.f59774f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f59775g = jSONObject.optString("user_id");
        this.f59776h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.f59777i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.j = jSONObject.optString("time_passed");
        this.k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f59773e.equals(((d) obj).f59773e);
        }
        return false;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f59773e).intValue() * 31) + 7;
    }
}
