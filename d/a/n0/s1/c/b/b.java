package d.a.n0.s1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f60419a;

    /* renamed from: b  reason: collision with root package name */
    public String f60420b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f60419a = vipBannerItem.img_url;
        this.f60420b = vipBannerItem.link;
    }

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f60419a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f60420b;
    }
}
