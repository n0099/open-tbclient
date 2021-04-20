package d.b.i0.j3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f57648a;

    /* renamed from: b  reason: collision with root package name */
    public String f57649b;

    /* renamed from: c  reason: collision with root package name */
    public String f57650c;

    /* renamed from: d  reason: collision with root package name */
    public String f57651d;

    /* renamed from: e  reason: collision with root package name */
    public String f57652e;

    /* renamed from: f  reason: collision with root package name */
    public String f57653f;

    /* renamed from: g  reason: collision with root package name */
    public int f57654g;

    /* renamed from: h  reason: collision with root package name */
    public int f57655h;
    public int i;
    public int j = 0;

    public long a() {
        return this.f57648a;
    }

    public String b() {
        return this.f57653f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f57650c;
    }

    public String e() {
        return this.f57651d;
    }

    public int f() {
        return this.f57655h;
    }

    public int g() {
        return this.f57654g;
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.f57652e;
    }

    public String j() {
        return this.f57649b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f57648a = themeCardPropMain.props_id.longValue();
        this.f57649b = themeCardPropMain.title;
        this.f57650c = themeCardPropMain.description;
        this.f57651d = themeCardPropMain.example_url;
        this.f57652e = themeCardPropMain.permission;
        this.f57653f = themeCardPropMain.props_state_img;
        this.f57654g = themeCardPropMain.in_use.intValue();
        this.f57655h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f57648a = j;
    }

    public void n(String str) {
        this.f57653f = str;
    }

    public void o(int i) {
        this.j = i;
    }

    public void p(String str) {
        this.f57650c = str;
    }

    public void q(String str) {
        this.f57651d = str;
    }

    public void r(int i) {
        this.f57655h = i;
    }

    public void s(int i) {
        this.f57654g = i;
    }

    public void t(int i) {
        this.i = i;
    }

    public void u(String str) {
        this.f57652e = str;
    }

    public void v(String str) {
        this.f57649b = str;
    }
}
