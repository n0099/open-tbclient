package d.b.h0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.b.h0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f50916a;

    /* renamed from: b  reason: collision with root package name */
    public String f50917b;

    /* renamed from: c  reason: collision with root package name */
    public String f50918c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50919d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50920e;

    /* renamed from: f  reason: collision with root package name */
    public int f50921f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f50922g;

    /* renamed from: h  reason: collision with root package name */
    public int f50923h;
    public int i;
    public String j;

    public String a() {
        return this.f50918c;
    }

    public int b() {
        return this.f50921f;
    }

    public boolean c() {
        return this.f50920e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50916a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f50917b = jSONObject.optString("name");
        this.f50918c = jSONObject.optString("avatar");
        this.f50921f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f50922g = d0Var;
            d0Var.a(optJSONObject);
        }
        this.i = jSONObject.optInt("memberNum", 0);
        this.f50923h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f50916a = String.valueOf(simpleForum.id);
        this.f50917b = simpleForum.name;
        this.f50918c = simpleForum.avatar;
        this.f50919d = simpleForum.is_liked.intValue() == 1;
        this.f50921f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f50922g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.i = simpleForum.member_num.intValue();
        this.f50923h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.b.h0.r.f0.n.a
    public boolean getIsLike() {
        return this.f50919d;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public String h() {
        return this.f50916a;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public String i() {
        return this.f50917b;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public void j(boolean z) {
        this.f50920e = z;
    }

    @Override // d.b.h0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f50919d = z;
    }
}
