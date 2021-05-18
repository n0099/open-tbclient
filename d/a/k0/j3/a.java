package d.a.k0.j3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f56757a;

    /* renamed from: b  reason: collision with root package name */
    public String f56758b;

    /* renamed from: c  reason: collision with root package name */
    public String f56759c;

    /* renamed from: d  reason: collision with root package name */
    public String f56760d;

    /* renamed from: e  reason: collision with root package name */
    public String f56761e;

    /* renamed from: f  reason: collision with root package name */
    public String f56762f;

    /* renamed from: g  reason: collision with root package name */
    public int f56763g;

    /* renamed from: h  reason: collision with root package name */
    public int f56764h;

    /* renamed from: i  reason: collision with root package name */
    public int f56765i;
    public int j = 0;

    public long a() {
        return this.f56757a;
    }

    public String b() {
        return this.f56762f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f56759c;
    }

    public String e() {
        return this.f56760d;
    }

    public int f() {
        return this.f56764h;
    }

    public int g() {
        return this.f56763g;
    }

    public int h() {
        return this.f56765i;
    }

    public String i() {
        return this.f56761e;
    }

    public String j() {
        return this.f56758b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f56757a = themeCardPropMain.props_id.longValue();
        this.f56758b = themeCardPropMain.title;
        this.f56759c = themeCardPropMain.description;
        this.f56760d = themeCardPropMain.example_url;
        this.f56761e = themeCardPropMain.permission;
        this.f56762f = themeCardPropMain.props_state_img;
        this.f56763g = themeCardPropMain.in_use.intValue();
        this.f56764h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.f56765i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f56757a = j;
    }

    public void n(String str) {
        this.f56762f = str;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(String str) {
        this.f56759c = str;
    }

    public void q(String str) {
        this.f56760d = str;
    }

    public void r(int i2) {
        this.f56764h = i2;
    }

    public void s(int i2) {
        this.f56763g = i2;
    }

    public void t(int i2) {
        this.f56765i = i2;
    }

    public void u(String str) {
        this.f56761e = str;
    }

    public void v(String str) {
        this.f56758b = str;
    }
}
