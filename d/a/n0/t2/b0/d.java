package d.a.n0.t2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.n0.r0.k;
import d.a.n0.t2.c0.h;
import d.a.n0.t2.r;
import d.a.n0.t2.u;
import d.a.n0.t2.y;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public AdvertAppInfo.ILegoAdvert w;
    public u x;

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.k1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f60909a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60910b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60911c;

        public a(d dVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f60909a = advertAppInfo;
            this.f60910b = i2;
            this.f60911c = str;
        }

        @Override // d.a.n0.k1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            if (y.p(i2)) {
                d.a.n0.t2.i0.d.f(this.f60909a, this.f60910b, hashMap, i2);
            } else {
                d.a.n0.t2.i0.d.n(this.f60909a, this.f60910b, this.f60911c, null, hashMap);
            }
            d.a.n0.k1.o.h.c.h(d.a.n0.k1.o.h.c.e(this.f60909a));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.n0.k1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60912a;

        public b(String str) {
            this.f60912a = str;
        }

        @Override // d.a.n0.k1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i2, d.this.t0(advertAppInfo, this.f60912a));
        }
    }

    public d(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.o(), bdUniqueId);
        this.w = null;
        this.x = uVar;
    }

    @Override // d.a.n0.r0.k
    public void h0() {
        V v = this.k;
        if (v != 0) {
            ((FrsAppLegoViewHolder) v).b();
        }
        super.h0();
    }

    public final DownloadStaticsData t0(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.Q3);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.Y3);
        downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
        downloadStaticsData.setExtensionInfo(advertAppInfo.N3);
        return downloadStaticsData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public View H(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.O3) == null) {
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
        if (this.w == null || (view = (View) d.a.n0.k1.o.b.h().a(this.o, this.w, 1)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.w);
        return new FrsAppLegoViewHolder((d.a.n0.k1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: x0 */
    public FrsAppLegoViewHolder Q(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.O3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        return P(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    /* renamed from: y0 */
    public View W(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        super.W(i2, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
        if (this.x == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.O3;
        this.w = iLegoAdvert;
        if (iLegoAdvert == null || view == null) {
            return null;
        }
        this.o.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.o.getLayoutMode().j(view);
        d.a.m0.r.q.d.b(advertAppInfo);
        d.a.n0.k1.o.l.e eVar = (d.a.n0.k1.o.l.e) view;
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
