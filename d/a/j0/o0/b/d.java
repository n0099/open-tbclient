package d.a.j0.o0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import d.a.c.j.e.n;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57162e;

    /* renamed from: f  reason: collision with root package name */
    public String f57163f;

    /* renamed from: g  reason: collision with root package name */
    public String f57164g;

    /* renamed from: h  reason: collision with root package name */
    public String f57165h;

    /* renamed from: i  reason: collision with root package name */
    public String f57166i;
    public int j;

    public int c() {
        return this.j;
    }

    public String e() {
        return this.f57163f;
    }

    public String f() {
        return this.f57166i;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public String h() {
        return this.f57164g;
    }

    public String i() {
        if (StringUtils.isNull(this.f57165h)) {
            return this.f57164g;
        }
        return this.f57165h;
    }

    public String k() {
        return this.f57162e;
    }

    public void l(int i2) {
        this.j = i2;
    }

    public void m(String str) {
        this.f57163f = str;
    }

    public void o(String str) {
        this.f57166i = str;
    }

    public void p(String str) {
        this.f57164g = str;
    }

    public void q(String str) {
        this.f57165h = str;
    }

    public void r(String str) {
        this.f57162e = str;
    }

    public void s(User user, int i2) {
        if (user == null || user.god_data == null) {
            return;
        }
        r(user.id + "");
        m(user.portrait);
        p(user.name);
        q(user.name_show);
        o(user.god_data.intro);
        l(user.fans_num.intValue());
    }
}
