package d.b.h0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f51242a;

    /* renamed from: b  reason: collision with root package name */
    public String f51243b;

    /* renamed from: c  reason: collision with root package name */
    public String f51244c;

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f51242a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f51243b;
    }

    public String c() {
        return this.f51243b;
    }

    public String d() {
        return this.f51242a;
    }

    public String e() {
        return this.f51244c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f51242a = bannerImage.img_url;
        this.f51243b = bannerImage.ahead_url;
        this.f51244c = bannerImage.title;
    }

    public void g(String str) {
        this.f51243b = str;
    }
}
