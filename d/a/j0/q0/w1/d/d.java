package d.a.j0.q0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f58890e;

    /* renamed from: f  reason: collision with root package name */
    public String f58891f;

    /* renamed from: g  reason: collision with root package name */
    public String f58892g;

    /* renamed from: h  reason: collision with root package name */
    public String f58893h;

    /* renamed from: i  reason: collision with root package name */
    public String f58894i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f58890e = jSONObject.optString("id");
        this.f58891f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f58892g = jSONObject.optString("user_id");
        this.f58893h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.f58894i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.j = jSONObject.optString("time_passed");
        this.k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f58890e.equals(((d) obj).f58890e);
        }
        return false;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f58890e).intValue() * 31) + 7;
    }
}
