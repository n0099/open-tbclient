package d.b.j0.j3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f58069a;

    /* renamed from: b  reason: collision with root package name */
    public String f58070b;

    /* renamed from: c  reason: collision with root package name */
    public String f58071c;

    /* renamed from: d  reason: collision with root package name */
    public String f58072d;

    /* renamed from: e  reason: collision with root package name */
    public String f58073e;

    /* renamed from: f  reason: collision with root package name */
    public String f58074f;

    /* renamed from: g  reason: collision with root package name */
    public int f58075g;

    /* renamed from: h  reason: collision with root package name */
    public int f58076h;
    public int i;
    public int j = 0;

    public long a() {
        return this.f58069a;
    }

    public String b() {
        return this.f58074f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f58071c;
    }

    public String e() {
        return this.f58072d;
    }

    public int f() {
        return this.f58076h;
    }

    public int g() {
        return this.f58075g;
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.f58073e;
    }

    public String j() {
        return this.f58070b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f58069a = themeCardPropMain.props_id.longValue();
        this.f58070b = themeCardPropMain.title;
        this.f58071c = themeCardPropMain.description;
        this.f58072d = themeCardPropMain.example_url;
        this.f58073e = themeCardPropMain.permission;
        this.f58074f = themeCardPropMain.props_state_img;
        this.f58075g = themeCardPropMain.in_use.intValue();
        this.f58076h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f58069a = j;
    }

    public void n(String str) {
        this.f58074f = str;
    }

    public void o(int i) {
        this.j = i;
    }

    public void p(String str) {
        this.f58071c = str;
    }

    public void q(String str) {
        this.f58072d = str;
    }

    public void r(int i) {
        this.f58076h = i;
    }

    public void s(int i) {
        this.f58075g = i;
    }

    public void t(int i) {
        this.i = i;
    }

    public void u(String str) {
        this.f58073e = str;
    }

    public void v(String str) {
        this.f58070b = str;
    }
}
