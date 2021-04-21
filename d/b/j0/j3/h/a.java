package d.b.j0.j3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.b.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f58237a;

    /* renamed from: b  reason: collision with root package name */
    public String f58238b;

    @Override // d.b.i0.r.w.b.a
    public String a() {
        return this.f58237a;
    }

    @Override // d.b.i0.r.w.b.a
    public String b() {
        return this.f58238b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f58237a = themeCarousel.pic_url;
        this.f58238b = themeCarousel.active_url;
    }
}
