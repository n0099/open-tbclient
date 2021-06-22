package d.a.o0.t2.b0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.o0.r0.k;
import d.a.o0.t2.c0.h;
import d.a.o0.t2.r;
import d.a.o0.t2.u;
import d.a.o0.t2.y;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public AdvertAppInfo.ILegoAdvert w;
    public u x;

    /* loaded from: classes5.dex */
    public class a implements d.a.o0.k1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f64726a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f64727b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f64728c;

        public a(d dVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f64726a = advertAppInfo;
            this.f64727b = i2;
            this.f64728c = str;
        }

        @Override // d.a.o0.k1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            if (y.p(i2)) {
                d.a.o0.t2.i0.d.f(this.f64726a, this.f64727b, hashMap, i2);
            } else {
                d.a.o0.t2.i0.d.n(this.f64726a, this.f64727b, this.f64728c, null, hashMap);
            }
            d.a.o0.k1.o.h.c.h(d.a.o0.k1.o.h.c.e(this.f64726a));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.o0.k1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64729a;

        public b(String str) {
            this.f64729a = str;
        }

        @Override // d.a.o0.k1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i2, d.this.t0(advertAppInfo, this.f64729a));
        }
    }

    public d(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.p(), bdUniqueId);
        this.w = null;
        this.x = uVar;
    }

    @Override // d.a.o0.r0.k
    public void i0() {
        V v = this.k;
        if (v != 0) {
            ((FrsAppLegoViewHolder) v).b();
        }
        super.i0();
    }

    public final DownloadStaticsData t0(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.T3);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.b4);
        downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
        downloadStaticsData.setExtensionInfo(advertAppInfo.Q3);
        return downloadStaticsData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public View I(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.R3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        if (w0(view)) {
            FrsAppLegoViewHolder Q = Q(viewGroup);
            this.k = Q;
            if (Q == null) {
                return null;
            }
            view = Q.a();
        }
        View view2 = view;
        return X(i2, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
    }

    public final boolean w0(View view) {
        V v;
        if (view == null || view.getTag() == null || (v = this.k) == 0 || this.w == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return true;
        }
        return !this.w.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: x0 */
    public FrsAppLegoViewHolder Q(ViewGroup viewGroup) {
        View view;
        if (this.w == null || (view = (View) d.a.o0.k1.o.b.h().a(this.o, this.w, 1)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.w);
        return new FrsAppLegoViewHolder((d.a.o0.k1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: y0 */
    public FrsAppLegoViewHolder R(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.R3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        return Q(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: z0 */
    public View X(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        super.X(i2, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
        if (this.x == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.R3;
        this.w = iLegoAdvert;
        if (iLegoAdvert == null || view == null) {
            return null;
        }
        this.o.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.o.getLayoutMode().j(view);
        d.a.n0.r.q.d.b(advertAppInfo);
        d.a.o0.k1.o.l.e eVar = (d.a.o0.k1.o.l.e) view;
        eVar.setFromCDN(this.m);
        eVar.i(this.w);
        String G = this.x.G();
        int w0 = this.x.w0();
        this.x.P();
        eVar.setAfterClickSchemeListener(new a(this, advertAppInfo, w0, G));
        eVar.setDownloadAppCallback(new b(G));
        if (r.class.isAssignableFrom(view.getClass())) {
            frsAppLegoViewHolder.c(((r) view).getVideoOrVrView());
        }
        return view;
    }
}
