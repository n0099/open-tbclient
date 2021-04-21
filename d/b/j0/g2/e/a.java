package d.b.j0.g2.e;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class a implements d.b.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f56651a;

    /* renamed from: b  reason: collision with root package name */
    public String f56652b;

    @Override // d.b.i0.r.w.b.a
    public String a() {
        return this.f56651a;
    }

    @Override // d.b.i0.r.w.b.a
    public String b() {
        return this.f56652b;
    }

    public String c() {
        return this.f56652b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f56651a = bannerImage.img_url;
        this.f56652b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
