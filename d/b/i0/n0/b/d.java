package d.b.i0.n0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import d.b.b.j.e.n;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f57016e;

    /* renamed from: f  reason: collision with root package name */
    public String f57017f;

    /* renamed from: g  reason: collision with root package name */
    public String f57018g;

    /* renamed from: h  reason: collision with root package name */
    public String f57019h;
    public String i;
    public int j;

    public int a() {
        return this.j;
    }

    public String e() {
        return this.f57017f;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.f57018g;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public String j() {
        if (StringUtils.isNull(this.f57019h)) {
            return this.f57018g;
        }
        return this.f57019h;
    }

    public String k() {
        return this.f57016e;
    }

    public void l(int i) {
        this.j = i;
    }

    public void n(String str) {
        this.f57017f = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public void p(String str) {
        this.f57018g = str;
    }

    public void q(String str) {
        this.f57019h = str;
    }

    public void r(String str) {
        this.f57016e = str;
    }

    public void s(User user, int i) {
        if (user == null || user.god_data == null) {
            return;
        }
        r(user.id + "");
        n(user.portrait);
        p(user.name);
        q(user.name_show);
        o(user.god_data.intro);
        l(user.fans_num.intValue());
    }
}
