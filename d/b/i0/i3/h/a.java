package d.b.i0.i3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f56369a;

    /* renamed from: b  reason: collision with root package name */
    public String f56370b;

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f56369a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f56370b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f56369a = themeCarousel.pic_url;
        this.f56370b = themeCarousel.active_url;
    }
}
