package d.a.j0.v2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61695a;

    /* renamed from: b  reason: collision with root package name */
    public int f61696b;

    /* renamed from: c  reason: collision with root package name */
    public int f61697c;

    /* renamed from: d  reason: collision with root package name */
    public int f61698d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61699e;

    /* renamed from: f  reason: collision with root package name */
    public int f61700f;

    /* renamed from: g  reason: collision with root package name */
    public int f61701g;

    /* renamed from: h  reason: collision with root package name */
    public int f61702h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f61703i;
    public int j;
    public int k;

    public int a() {
        return this.f61701g;
    }

    public int b() {
        return this.f61702h;
    }

    public int c() {
        return this.f61696b;
    }

    public int d() {
        return this.f61697c;
    }

    public int e() {
        return this.f61698d;
    }

    public SimpleUser f() {
        return this.f61703i;
    }

    public int g() {
        return this.f61700f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f61695a;
    }

    public boolean j() {
        return this.f61699e;
    }

    public boolean k() {
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f61695a = j.k("post" + currentAccount, 0);
        this.f61696b = j.k("like" + currentAccount, 0);
        this.f61697c = j.k("group" + currentAccount, 0);
        this.f61698d = j.k("live" + currentAccount, 0);
        this.f61700f = j.k("reply" + currentAccount, 1);
        this.k = j.k("reply_show_myself" + currentAccount, 0);
        this.f61701g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f61702h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f61699e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f61695a == 0 && this.f61696b == 0 && this.f61697c == 0 && this.f61698d == 0 && this.f61700f == 1 && this.k == 0 && this.f61701g == 0 && this.f61702h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f61695a = aVar.f61695a;
        this.f61696b = aVar.f61696b;
        this.f61697c = aVar.f61697c;
        this.f61699e = aVar.f61699e;
        this.f61698d = aVar.f61698d;
        this.j = aVar.j;
        this.f61700f = aVar.f61700f;
        this.k = aVar.k;
        this.f61702h = aVar.f61702h;
        this.f61701g = aVar.f61701g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        j.v("post" + currentAccount, this.f61695a);
        j.v("like" + currentAccount, this.f61696b);
        j.v("group" + currentAccount, this.f61697c);
        j.v("live" + currentAccount, this.f61698d);
        j.v("reply" + currentAccount, this.f61700f);
        j.v("reply_show_myself" + currentAccount, this.k);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f61701g);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f61702h);
        TbadkCoreApplication.getInst().setLocationShared(this.f61699e);
    }

    public void n(String str, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        j.v(str + currentAccount, i2);
    }

    public void o(int i2) {
        this.f61701g = i2;
    }

    public void p(int i2) {
        this.f61702h = i2;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f61696b = i2;
    }

    public void s(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f61697c = i2;
    }

    public void t(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f61698d = i2;
    }

    public void u(int i2) {
        if (i2 != 1) {
            this.f61699e = false;
        } else {
            this.f61699e = true;
        }
    }

    public void v(SimpleUser simpleUser) {
        this.f61703i = simpleUser;
        if (simpleUser != null) {
            x(simpleUser.show_onlyme.intValue());
        }
    }

    public void w(int i2) {
        if (i2 == 0) {
            this.f61700f = 1;
        } else {
            this.f61700f = i2;
        }
    }

    public void x(int i2) {
        this.k = i2;
    }

    public void y(int i2) {
        this.f61695a = i2;
    }
}
