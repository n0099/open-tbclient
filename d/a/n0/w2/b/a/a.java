package d.a.n0.w2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62526a;

    /* renamed from: b  reason: collision with root package name */
    public int f62527b;

    /* renamed from: c  reason: collision with root package name */
    public int f62528c;

    /* renamed from: d  reason: collision with root package name */
    public int f62529d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62530e;

    /* renamed from: f  reason: collision with root package name */
    public int f62531f;

    /* renamed from: g  reason: collision with root package name */
    public int f62532g;

    /* renamed from: h  reason: collision with root package name */
    public int f62533h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f62534i;
    public int j;
    public int k;

    public int a() {
        return this.f62532g;
    }

    public int b() {
        return this.f62533h;
    }

    public int c() {
        return this.f62527b;
    }

    public int d() {
        return this.f62528c;
    }

    public int e() {
        return this.f62529d;
    }

    public SimpleUser f() {
        return this.f62534i;
    }

    public int g() {
        return this.f62531f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f62526a;
    }

    public boolean j() {
        return this.f62530e;
    }

    public boolean k() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f62526a = j.k("post" + currentAccount, 0);
        this.f62527b = j.k("like" + currentAccount, 0);
        this.f62528c = j.k("group" + currentAccount, 0);
        this.f62529d = j.k("live" + currentAccount, 0);
        this.f62531f = j.k("reply" + currentAccount, 1);
        this.k = j.k("reply_show_myself" + currentAccount, 0);
        this.f62532g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f62533h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f62530e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f62526a == 0 && this.f62527b == 0 && this.f62528c == 0 && this.f62529d == 0 && this.f62531f == 1 && this.k == 0 && this.f62532g == 0 && this.f62533h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f62526a = aVar.f62526a;
        this.f62527b = aVar.f62527b;
        this.f62528c = aVar.f62528c;
        this.f62530e = aVar.f62530e;
        this.f62529d = aVar.f62529d;
        this.j = aVar.j;
        this.f62531f = aVar.f62531f;
        this.k = aVar.k;
        this.f62533h = aVar.f62533h;
        this.f62532g = aVar.f62532g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v("post" + currentAccount, this.f62526a);
        j.v("like" + currentAccount, this.f62527b);
        j.v("group" + currentAccount, this.f62528c);
        j.v("live" + currentAccount, this.f62529d);
        j.v("reply" + currentAccount, this.f62531f);
        j.v("reply_show_myself" + currentAccount, this.k);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f62532g);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f62533h);
        TbadkCoreApplication.getInst().setLocationShared(this.f62530e);
    }

    public void n(String str, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v(str + currentAccount, i2);
    }

    public void o(int i2) {
        this.f62532g = i2;
    }

    public void p(int i2) {
        this.f62533h = i2;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f62527b = i2;
    }

    public void s(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f62528c = i2;
    }

    public void t(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f62529d = i2;
    }

    public void u(int i2) {
        if (i2 != 1) {
            this.f62530e = false;
        } else {
            this.f62530e = true;
        }
    }

    public void v(SimpleUser simpleUser) {
        this.f62534i = simpleUser;
        if (simpleUser != null) {
            x(simpleUser.show_onlyme.intValue());
        }
    }

    public void w(int i2) {
        if (i2 == 0) {
            this.f62531f = 1;
        } else {
            this.f62531f = i2;
        }
    }

    public void x(int i2) {
        this.k = i2;
    }

    public void y(int i2) {
        this.f62526a = i2;
    }
}
