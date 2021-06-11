package d.a.n0.p0.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import d.a.c.k.e.n;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f61669e;

    /* renamed from: f  reason: collision with root package name */
    public String f61670f;

    /* renamed from: g  reason: collision with root package name */
    public String f61671g;

    /* renamed from: h  reason: collision with root package name */
    public String f61672h;

    /* renamed from: i  reason: collision with root package name */
    public String f61673i;
    public int j;

    public int b() {
        return this.j;
    }

    public String c() {
        return this.f61670f;
    }

    public String e() {
        return this.f61673i;
    }

    public String g() {
        return this.f61671g;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }

    public String h() {
        if (StringUtils.isNull(this.f61672h)) {
            return this.f61671g;
        }
        return this.f61672h;
    }

    public String i() {
        return this.f61669e;
    }

    public void k(int i2) {
        this.j = i2;
    }

    public void l(String str) {
        this.f61670f = str;
    }

    public void n(String str) {
        this.f61673i = str;
    }

    public void o(String str) {
        this.f61671g = str;
    }

    public void p(String str) {
        this.f61672h = str;
    }

    public void q(String str) {
        this.f61669e = str;
    }

    public void s(User user, int i2) {
        if (user == null || user.god_data == null) {
            return;
        }
        q(user.id + "");
        l(user.portrait);
        o(user.name);
        p(user.name_show);
        n(user.god_data.intro);
        k(user.fans_num.intValue());
    }
}
