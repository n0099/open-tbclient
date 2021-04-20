package d.b.i0.s0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes4.dex */
public class d implements d.b.i0.r0.c {
    @Override // d.b.i0.r0.c
    public d.b.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.l4) {
            d.b.i0.s0.e.b bVar = new d.b.i0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.m0(d.b.i0.r0.d.c.e().d("pb_banner"));
            bVar.j0("pb");
            bVar.l0("pb_banner");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.m4) {
            return new d.b.i0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }

    @Override // d.b.i0.r0.c
    public d.b.c.j.e.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.n4) {
            d.b.i0.s0.e.b bVar = new d.b.i0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.m0(d.b.i0.r0.d.c.e().d("frs_feed"));
            bVar.j0("frs");
            bVar.l0("frs_feed");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.m4) {
            return new d.b.i0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }

    @Override // d.b.i0.r0.c
    public d.b.c.j.e.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.n4) {
            d.b.i0.s0.e.b bVar = new d.b.i0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.m0(d.b.i0.r0.d.c.e().d("frs_feed"));
            bVar.j0("frs");
            bVar.l0("frs_feed");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.m4) {
            return new d.b.i0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }

    @Override // d.b.i0.r0.c
    public d.b.c.j.e.a<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.n4) {
            d.b.i0.s0.e.b bVar = new d.b.i0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.m0("6051001980-1210572494");
            bVar.j0("personalize");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.m4) {
            return new d.b.i0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }
}
