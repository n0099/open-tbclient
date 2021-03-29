package d.b.i0.i3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f56201a;

    /* renamed from: b  reason: collision with root package name */
    public String f56202b;

    /* renamed from: c  reason: collision with root package name */
    public String f56203c;

    /* renamed from: d  reason: collision with root package name */
    public String f56204d;

    /* renamed from: e  reason: collision with root package name */
    public String f56205e;

    /* renamed from: f  reason: collision with root package name */
    public String f56206f;

    /* renamed from: g  reason: collision with root package name */
    public int f56207g;

    /* renamed from: h  reason: collision with root package name */
    public int f56208h;
    public int i;
    public int j = 0;

    public long a() {
        return this.f56201a;
    }

    public String b() {
        return this.f56206f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f56203c;
    }

    public String e() {
        return this.f56204d;
    }

    public int f() {
        return this.f56208h;
    }

    public int g() {
        return this.f56207g;
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.f56205e;
    }

    public String j() {
        return this.f56202b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f56201a = themeCardPropMain.props_id.longValue();
        this.f56202b = themeCardPropMain.title;
        this.f56203c = themeCardPropMain.description;
        this.f56204d = themeCardPropMain.example_url;
        this.f56205e = themeCardPropMain.permission;
        this.f56206f = themeCardPropMain.props_state_img;
        this.f56207g = themeCardPropMain.in_use.intValue();
        this.f56208h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f56201a = j;
    }

    public void n(String str) {
        this.f56206f = str;
    }

    public void o(int i) {
        this.j = i;
    }

    public void p(String str) {
        this.f56203c = str;
    }

    public void q(String str) {
        this.f56204d = str;
    }

    public void r(int i) {
        this.f56208h = i;
    }

    public void s(int i) {
        this.f56207g = i;
    }

    public void t(int i) {
        this.i = i;
    }

    public void u(String str) {
        this.f56205e = str;
    }

    public void v(String str) {
        this.f56202b = str;
    }
}
