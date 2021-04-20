package d.b.i0.g2.e;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class a implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f56230a;

    /* renamed from: b  reason: collision with root package name */
    public String f56231b;

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f56230a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f56231b;
    }

    public String c() {
        return this.f56231b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f56230a = bannerImage.img_url;
        this.f56231b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
