package d.b.h0.r.q;

import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class w1 implements d.b.h0.r.f0.n.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f50915a;

    /* renamed from: b  reason: collision with root package name */
    public String f50916b;

    /* renamed from: c  reason: collision with root package name */
    public String f50917c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50918d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50919e;

    /* renamed from: f  reason: collision with root package name */
    public int f50920f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f50921g;

    /* renamed from: h  reason: collision with root package name */
    public int f50922h;
    public int i;
    public String j;

    public String a() {
        return this.f50917c;
    }

    public int b() {
        return this.f50920f;
    }

    public boolean c() {
        return this.f50919e;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50915a = String.valueOf(jSONObject.optLong("id", 0L));
        this.f50916b = jSONObject.optString("name");
        this.f50917c = jSONObject.optString("avatar");
        this.f50920f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            d0 d0Var = new d0();
            this.f50921g = d0Var;
            d0Var.a(optJSONObject);
        }
        this.i = jSONObject.optInt("memberNum", 0);
        this.f50922h = jSONObject.optInt("post_num", 0);
    }

    public void e(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        this.f50915a = String.valueOf(simpleForum.id);
        this.f50916b = simpleForum.name;
        this.f50917c = simpleForum.avatar;
        this.f50918d = simpleForum.is_liked.intValue() == 1;
        this.f50920f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            d0 d0Var = new d0();
            this.f50921g = d0Var;
            d0Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.i = simpleForum.member_num.intValue();
        this.f50922h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
    }

    @Override // d.b.h0.r.f0.n.a
    public boolean getIsLike() {
        return this.f50918d;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public String h() {
        return this.f50915a;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public String i() {
        return this.f50916b;
    }

    @Override // d.b.h0.r.f0.n.c.b
    public void j(boolean z) {
        this.f50919e = z;
    }

    @Override // d.b.h0.r.f0.n.a
    public void setIsLike(boolean z) {
        this.f50918d = z;
    }
}
