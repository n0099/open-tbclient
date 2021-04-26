package d.a.j0.g2.e;

import tbclient.BannerImage;
/* loaded from: classes4.dex */
public class a implements d.a.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f54550a;

    /* renamed from: b  reason: collision with root package name */
    public String f54551b;

    @Override // d.a.i0.r.w.b.a
    public String a() {
        return this.f54550a;
    }

    @Override // d.a.i0.r.w.b.a
    public String b() {
        return this.f54551b;
    }

    public String c() {
        return this.f54551b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f54550a = bannerImage.img_url;
        this.f54551b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
