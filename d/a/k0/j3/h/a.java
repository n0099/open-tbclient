package d.a.k0.j3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.a.j0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f56937a;

    /* renamed from: b  reason: collision with root package name */
    public String f56938b;

    @Override // d.a.j0.r.w.b.a
    public String a() {
        return this.f56937a;
    }

    @Override // d.a.j0.r.w.b.a
    public String b() {
        return this.f56938b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f56937a = themeCarousel.pic_url;
        this.f56938b = themeCarousel.active_url;
    }
}
