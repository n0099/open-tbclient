package d.a.o0.r0.w1.d;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f63589e;

    /* renamed from: f  reason: collision with root package name */
    public String f63590f;

    /* renamed from: g  reason: collision with root package name */
    public String f63591g;

    /* renamed from: h  reason: collision with root package name */
    public String f63592h;

    /* renamed from: i  reason: collision with root package name */
    public String f63593i;
    public String j;
    public boolean k;

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f63589e = jSONObject.optString("id");
        this.f63590f = jSONObject.optString("main_tower_id");
        jSONObject.optString("forum_id");
        this.f63591g = jSONObject.optString("user_id");
        this.f63592h = jSONObject.optString("user_name");
        jSONObject.optString("create_time");
        this.f63593i = jSONObject.optString("content");
        jSONObject.optString("reply_user_id");
        this.j = jSONObject.optString("time_passed");
        this.k = jSONObject.optInt("is_main_tower_user", 0) == 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.f63589e.equals(((d) obj).f63589e);
        }
        return false;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f63589e).intValue() * 31) + 7;
    }
}
