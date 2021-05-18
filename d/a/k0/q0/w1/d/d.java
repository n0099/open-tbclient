package d.a.k0.q0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f59632e;

    /* renamed from: f  reason: collision with root package name */
    public String f59633f;

    /* renamed from: g  reason: collision with root package name */
    public String f59634g;

    /* renamed from: h  reason: collision with root package name */
    public String f59635h;

    /* renamed from: i  reason: collision with root package name */
    public String f59636i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f59632e = jSONObject.optString("id");
        this.f59633f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f59634g = jSONObject.optString("user_id");
        this.f59635h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.f59636i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.j = jSONObject.optString("time_passed");
        this.k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f59632e.equals(((d) obj).f59632e);
        }
        return false;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f59632e).intValue() * 31) + 7;
    }
}
