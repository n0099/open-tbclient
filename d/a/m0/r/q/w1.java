package d.a.m0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.a.m0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f50157a;

    /* renamed from: b  reason: collision with root package name */
    public String f50158b;

    /* renamed from: c  reason: collision with root package name */
    public String f50159c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50160d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50161e;

    /* renamed from: f  reason: collision with root package name */
    public int f50162f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f50163g;

    /* renamed from: h  reason: collision with root package name */
    public int f50164h;

    /* renamed from: i  reason: collision with root package name */
    public int f50165i;
    public String j;

    public String a() {
        return this.f50159c;
    }

    public int b() {
        return this.f50162f;
    }

    public boolean c() {
        return this.f50161e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50157a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f50158b = jSONObject.optString("name");
        this.f50159c = jSONObject.optString("avatar");
        this.f50162f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f50163g = d0Var;
            d0Var.a(optJSONObject);
        }
        this.f50165i = jSONObject.optInt("memberNum", 0);
        this.f50164h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f50157a = String.valueOf(simpleForum.id);
        this.f50158b = simpleForum.name;
        this.f50159c = simpleForum.avatar;
        this.f50160d = simpleForum.is_liked.intValue() == 1;
        this.f50162f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f50163g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.f50165i = simpleForum.member_num.intValue();
        this.f50164h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.a.m0.r.f0.n.c.b
    public String g() {
        return this.f50158b;
    }

    @Override // d.a.m0.r.f0.n.a
    public boolean getIsLike() {
        return this.f50160d;
    }

    @Override // d.a.m0.r.f0.n.c.b
    public String h() {
        return this.f50157a;
    }

    @Override // d.a.m0.r.f0.n.c.b
    public void i(boolean z) {
        this.f50161e = z;
    }

    @Override // d.a.m0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f50160d = z;
    }
}
