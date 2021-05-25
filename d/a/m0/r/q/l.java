package d.a.m0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f50070a;

    /* renamed from: b  reason: collision with root package name */
    public String f50071b;

    /* renamed from: c  reason: collision with root package name */
    public String f50072c;

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f50070a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f50071b;
    }

    public String c() {
        return this.f50071b;
    }

    public String d() {
        return this.f50070a;
    }

    public String e() {
        return this.f50072c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f50070a = bannerImage.img_url;
        this.f50071b = bannerImage.ahead_url;
        this.f50072c = bannerImage.title;
    }

    public void g(String str) {
        this.f50071b = str;
    }
}
