package d.a.j0.r1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.a.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f59551a;

    /* renamed from: b  reason: collision with root package name */
    public String f59552b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f59551a = vipBannerItem.img_url;
        this.f59552b = vipBannerItem.link;
    }

    @Override // d.a.i0.r.w.b.a
    public String a() {
        return this.f59551a;
    }

    @Override // d.a.i0.r.w.b.a
    public String b() {
        return this.f59552b;
    }
}
