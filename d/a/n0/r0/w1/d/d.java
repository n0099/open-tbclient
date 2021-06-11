package d.a.n0.r0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f63464e;

    /* renamed from: f  reason: collision with root package name */
    public String f63465f;

    /* renamed from: g  reason: collision with root package name */
    public String f63466g;

    /* renamed from: h  reason: collision with root package name */
    public String f63467h;

    /* renamed from: i  reason: collision with root package name */
    public String f63468i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f63464e = jSONObject.optString("id");
        this.f63465f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f63466g = jSONObject.optString("user_id");
        this.f63467h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.f63468i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.j = jSONObject.optString("time_passed");
        this.k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f63464e.equals(((d) obj).f63464e);
        }
        return false;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f63464e).intValue() * 31) + 7;
    }
}
