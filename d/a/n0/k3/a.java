package d.a.n0.k3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f56937a;

    /* renamed from: b  reason: collision with root package name */
    public String f56938b;

    /* renamed from: c  reason: collision with root package name */
    public String f56939c;

    /* renamed from: d  reason: collision with root package name */
    public String f56940d;

    /* renamed from: e  reason: collision with root package name */
    public String f56941e;

    /* renamed from: f  reason: collision with root package name */
    public String f56942f;

    /* renamed from: g  reason: collision with root package name */
    public int f56943g;

    /* renamed from: h  reason: collision with root package name */
    public int f56944h;

    /* renamed from: i  reason: collision with root package name */
    public int f56945i;
    public int j = 0;

    public long a() {
        return this.f56937a;
    }

    public String b() {
        return this.f56942f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f56939c;
    }

    public String e() {
        return this.f56940d;
    }

    public int f() {
        return this.f56944h;
    }

    public int g() {
        return this.f56943g;
    }

    public int h() {
        return this.f56945i;
    }

    public String i() {
        return this.f56941e;
    }

    public String j() {
        return this.f56938b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f56937a = themeCardPropMain.props_id.longValue();
        this.f56938b = themeCardPropMain.title;
        this.f56939c = themeCardPropMain.description;
        this.f56940d = themeCardPropMain.example_url;
        this.f56941e = themeCardPropMain.permission;
        this.f56942f = themeCardPropMain.props_state_img;
        this.f56943g = themeCardPropMain.in_use.intValue();
        this.f56944h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.f56945i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f56937a = j;
    }

    public void n(String str) {
        this.f56942f = str;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(String str) {
        this.f56939c = str;
    }

    public void q(String str) {
        this.f56940d = str;
    }

    public void r(int i2) {
        this.f56944h = i2;
    }

    public void s(int i2) {
        this.f56943g = i2;
    }

    public void t(int i2) {
        this.f56945i = i2;
    }

    public void u(String str) {
        this.f56941e = str;
    }

    public void v(String str) {
        this.f56938b = str;
    }
}
