package d.a.k0.v2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62419a;

    /* renamed from: b  reason: collision with root package name */
    public int f62420b;

    /* renamed from: c  reason: collision with root package name */
    public int f62421c;

    /* renamed from: d  reason: collision with root package name */
    public int f62422d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62423e;

    /* renamed from: f  reason: collision with root package name */
    public int f62424f;

    /* renamed from: g  reason: collision with root package name */
    public int f62425g;

    /* renamed from: h  reason: collision with root package name */
    public int f62426h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f62427i;
    public int j;
    public int k;

    public int a() {
        return this.f62425g;
    }

    public int b() {
        return this.f62426h;
    }

    public int c() {
        return this.f62420b;
    }

    public int d() {
        return this.f62421c;
    }

    public int e() {
        return this.f62422d;
    }

    public SimpleUser f() {
        return this.f62427i;
    }

    public int g() {
        return this.f62424f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f62419a;
    }

    public boolean j() {
        return this.f62423e;
    }

    public boolean k() {
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f62419a = j.k("post" + currentAccount, 0);
        this.f62420b = j.k("like" + currentAccount, 0);
        this.f62421c = j.k("group" + currentAccount, 0);
        this.f62422d = j.k("live" + currentAccount, 0);
        this.f62424f = j.k("reply" + currentAccount, 1);
        this.k = j.k("reply_show_myself" + currentAccount, 0);
        this.f62425g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f62426h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f62423e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f62419a == 0 && this.f62420b == 0 && this.f62421c == 0 && this.f62422d == 0 && this.f62424f == 1 && this.k == 0 && this.f62425g == 0 && this.f62426h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f62419a = aVar.f62419a;
        this.f62420b = aVar.f62420b;
        this.f62421c = aVar.f62421c;
        this.f62423e = aVar.f62423e;
        this.f62422d = aVar.f62422d;
        this.j = aVar.j;
        this.f62424f = aVar.f62424f;
        this.k = aVar.k;
        this.f62426h = aVar.f62426h;
        this.f62425g = aVar.f62425g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        j.v("post" + currentAccount, this.f62419a);
        j.v("like" + currentAccount, this.f62420b);
        j.v("group" + currentAccount, this.f62421c);
        j.v("live" + currentAccount, this.f62422d);
        j.v("reply" + currentAccount, this.f62424f);
        j.v("reply_show_myself" + currentAccount, this.k);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f62425g);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f62426h);
        TbadkCoreApplication.getInst().setLocationShared(this.f62423e);
    }

    public void n(String str, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        j.v(str + currentAccount, i2);
    }

    public void o(int i2) {
        this.f62425g = i2;
    }

    public void p(int i2) {
        this.f62426h = i2;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f62420b = i2;
    }

    public void s(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f62421c = i2;
    }

    public void t(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f62422d = i2;
    }

    public void u(int i2) {
        if (i2 != 1) {
            this.f62423e = false;
        } else {
            this.f62423e = true;
        }
    }

    public void v(SimpleUser simpleUser) {
        this.f62427i = simpleUser;
        if (simpleUser != null) {
            x(simpleUser.show_onlyme.intValue());
        }
    }

    public void w(int i2) {
        if (i2 == 0) {
            this.f62424f = 1;
        } else {
            this.f62424f = i2;
        }
    }

    public void x(int i2) {
        this.k = i2;
    }

    public void y(int i2) {
        this.f62419a = i2;
    }
}
