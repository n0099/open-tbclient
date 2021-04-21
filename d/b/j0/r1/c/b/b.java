package d.b.j0.r1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.b.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f61408a;

    /* renamed from: b  reason: collision with root package name */
    public String f61409b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f61408a = vipBannerItem.img_url;
        this.f61409b = vipBannerItem.link;
    }

    @Override // d.b.i0.r.w.b.a
    public String a() {
        return this.f61408a;
    }

    @Override // d.b.i0.r.w.b.a
    public String b() {
        return this.f61409b;
    }
}
