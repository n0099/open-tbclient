package d.a.k0.r1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.a.j0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f60296a;

    /* renamed from: b  reason: collision with root package name */
    public String f60297b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f60296a = vipBannerItem.img_url;
        this.f60297b = vipBannerItem.link;
    }

    @Override // d.a.j0.r.w.b.a
    public String a() {
        return this.f60296a;
    }

    @Override // d.a.j0.r.w.b.a
    public String b() {
        return this.f60297b;
    }
}
