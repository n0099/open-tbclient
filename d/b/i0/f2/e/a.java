package d.b.i0.f2.e;

import tbclient.BannerImage;
/* loaded from: classes5.dex */
public class a implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f54760a;

    /* renamed from: b  reason: collision with root package name */
    public String f54761b;

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f54760a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f54761b;
    }

    public String c() {
        return this.f54761b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f54760a = bannerImage.img_url;
        this.f54761b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
