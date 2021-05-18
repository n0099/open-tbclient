package d.a.k0.s2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.k0.q0.k;
import d.a.k0.s2.c0.h;
import d.a.k0.s2.r;
import d.a.k0.s2.u;
import d.a.k0.s2.y;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public AdvertAppInfo.ILegoAdvert w;
    public u x;

    /* loaded from: classes5.dex */
    public class a implements d.a.k0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f60807a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60808b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60809c;

        public a(d dVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f60807a = advertAppInfo;
            this.f60808b = i2;
            this.f60809c = str;
        }

        @Override // d.a.k0.j1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            if (y.p(i2)) {
                d.a.k0.s2.i0.d.f(this.f60807a, this.f60808b, hashMap, i2);
            } else {
                d.a.k0.s2.i0.d.n(this.f60807a, this.f60808b, this.f60809c, null, hashMap);
            }
            d.a.k0.j1.o.h.c.h(d.a.k0.j1.o.h.c.e(this.f60807a));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.k0.j1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60810a;

        public b(String str) {
            this.f60810a = str;
        }

        @Override // d.a.k0.j1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i2, d.this.t0(advertAppInfo, this.f60810a));
        }
    }

    public d(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.o(), bdUniqueId);
        this.w = null;
        this.x = uVar;
    }

    @Override // d.a.k0.q0.k
    public void h0() {
        V v = this.k;
        if (v != 0) {
            ((FrsAppLegoViewHolder) v).b();
        }
        super.h0();
    }

    public final DownloadStaticsData t0(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.P3);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.X3);
        downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
        downloadStaticsData.setExtensionInfo(advertAppInfo.M3);
        return downloadStaticsData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public View H(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.N3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        if (v0(view)) {
            FrsAppLegoViewHolder P = P(viewGroup);
            this.k = P;
            if (P == null) {
                return null;
            }
            view = P.a();
        }
        View view2 = view;
        return W(i2, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
    }

    public final boolean v0(View view) {
        V v;
        if (view == null || view.getTag() == null || (v = this.k) == 0 || this.w == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return true;
        }
        return !this.w.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: w0 */
    public FrsAppLegoViewHolder P(ViewGroup viewGroup) {
        View view;
        if (this.w == null || (view = (View) d.a.k0.j1.o.b.h().a(this.o, this.w, 1)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.w);
        return new FrsAppLegoViewHolder((d.a.k0.j1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: x0 */
    public FrsAppLegoViewHolder Q(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.N3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        return P(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: y0 */
    public View W(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        super.W(i2, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
        if (this.x == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.N3;
        this.w = iLegoAdvert;
        if (iLegoAdvert == null || view == null) {
            return null;
        }
        this.o.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.o.getLayoutMode().j(view);
        d.a.j0.r.q.d.b(advertAppInfo);
        d.a.k0.j1.o.l.e eVar = (d.a.k0.j1.o.l.e) view;
        eVar.setFromCDN(this.m);
        eVar.g(this.w);
        String F = this.x.F();
        int t0 = this.x.t0();
        this.x.O();
        eVar.setAfterClickSchemeListener(new a(this, advertAppInfo, t0, F));
        eVar.setDownloadAppCallback(new b(F));
        if (r.class.isAssignableFrom(view.getClass())) {
            frsAppLegoViewHolder.c(((r) view).getVideoOrVrView());
        }
        return view;
    }
}
