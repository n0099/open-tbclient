package d.a.k0.g2.e;

import tbclient.BannerImage;
/* loaded from: classes5.dex */
public class a implements d.a.j0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f55257a;

    /* renamed from: b  reason: collision with root package name */
    public String f55258b;

    @Override // d.a.j0.r.w.b.a
    public String a() {
        return this.f55257a;
    }

    @Override // d.a.j0.r.w.b.a
    public String b() {
        return this.f55258b;
    }

    public String c() {
        return this.f55258b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f55257a = bannerImage.img_url;
        this.f55258b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
