package d.a.j0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.a.j0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f50026a;

    /* renamed from: b  reason: collision with root package name */
    public String f50027b;

    /* renamed from: c  reason: collision with root package name */
    public String f50028c;

    @Override // d.a.j0.r.w.b.a
    public String a() {
        return this.f50026a;
    }

    @Override // d.a.j0.r.w.b.a
    public String b() {
        return this.f50027b;
    }

    public String c() {
        return this.f50027b;
    }

    public String d() {
        return this.f50026a;
    }

    public String e() {
        return this.f50028c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f50026a = bannerImage.img_url;
        this.f50027b = bannerImage.ahead_url;
        this.f50028c = bannerImage.title;
    }

    public void g(String str) {
        this.f50027b = str;
    }
}
