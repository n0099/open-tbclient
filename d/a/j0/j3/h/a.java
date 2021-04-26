package d.a.j0.j3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.a.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f56230a;

    /* renamed from: b  reason: collision with root package name */
    public String f56231b;

    @Override // d.a.i0.r.w.b.a
    public String a() {
        return this.f56230a;
    }

    @Override // d.a.i0.r.w.b.a
    public String b() {
        return this.f56231b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f56230a = themeCarousel.pic_url;
        this.f56231b = themeCarousel.active_url;
    }
}
