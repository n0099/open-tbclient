package d.a.j0.s2.a0;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.j0.q0.k;
import d.a.j0.s2.b0.h;
import d.a.j0.s2.q;
import d.a.j0.s2.t;
import d.a.j0.s2.x;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public AdvertAppInfo.ILegoAdvert w;
    public t x;

    /* loaded from: classes3.dex */
    public class a implements d.a.j0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f60077a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60078b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60079c;

        /* renamed from: d.a.j0.s2.a0.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1540a extends BdAsyncTask<String, Void, Void> {
            public C1540a(a aVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                if (strArr == null || strArr.length <= 0) {
                    return null;
                }
                new NetWork(strArr[0]).postNetData();
                return null;
            }
        }

        public a(d dVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f60077a = advertAppInfo;
            this.f60078b = i2;
            this.f60079c = str;
        }

        @Override // d.a.j0.j1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            if (x.p(i2)) {
                d.a.j0.s2.h0.d.f(this.f60077a, this.f60078b, hashMap, i2);
            } else {
                d.a.j0.s2.h0.d.n(this.f60077a, this.f60078b, this.f60079c, null, hashMap);
            }
            d.a.j0.j1.o.h.c.h(d.a.j0.j1.o.h.c.e(this.f60077a));
        }

        @Override // d.a.j0.j1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("da_area", "button");
            d.a.j0.s2.h0.d.n(this.f60077a, this.f60078b, this.f60079c, str, hashMap);
            d.a.j0.j1.o.h.c.h(d.a.j0.j1.o.h.c.e(this.f60077a));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            new C1540a(this).execute(str2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.j0.j1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60080a;

        public b(String str) {
            this.f60080a = str;
        }

        @Override // d.a.j0.j1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i2, d.this.u0(advertAppInfo, this.f60080a));
        }
    }

    public d(t tVar, BdUniqueId bdUniqueId) {
        super(tVar.o(), bdUniqueId);
        this.w = null;
        this.x = tVar;
    }

    @Override // d.a.j0.q0.k
    public void i0() {
        V v = this.k;
        if (v != 0) {
            ((FrsAppLegoViewHolder) v).b();
        }
        super.i0();
    }

    public final DownloadStaticsData u0(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(advertAppInfo.c4);
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.J3);
        downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
        downloadStaticsData.setPrice(advertAppInfo.O3);
        downloadStaticsData.setExtensionInfo(advertAppInfo.T3);
        return downloadStaticsData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: v0 */
    public View H(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.W3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        if (w0(view)) {
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

    public final boolean w0(View view) {
        V v;
        if (view == null || view.getTag() == null || (v = this.k) == 0 || this.w == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return true;
        }
        return !this.w.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: x0 */
    public FrsAppLegoViewHolder P(ViewGroup viewGroup) {
        View view;
        if (this.w == null || (view = (View) d.a.j0.j1.o.b.h().a(this.o, this.w, 1)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.w);
        return new FrsAppLegoViewHolder((d.a.j0.j1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: y0 */
    public FrsAppLegoViewHolder Q(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.W3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        return P(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: z0 */
    public View W(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        super.W(i2, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
        if (this.x == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.W3;
        this.w = iLegoAdvert;
        if (iLegoAdvert == null || view == null) {
            return null;
        }
        this.o.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.o.getLayoutMode().j(view);
        if (g0()) {
            advertAppInfo.position = i2 - this.n.getTopThreadSize();
        }
        d.a.i0.r.q.d.b(advertAppInfo);
        d.a.j0.j1.o.l.e eVar = (d.a.j0.j1.o.l.e) view;
        eVar.setFromCDN(this.m);
        eVar.g(this.w);
        String F = this.x.F();
        int u0 = this.x.u0();
        this.x.O();
        eVar.setAfterClickSchemeListener(new a(this, advertAppInfo, u0, F));
        eVar.setDownloadAppCallback(new b(F));
        if (!advertAppInfo.V3) {
            advertAppInfo.V3 = true;
            this.x.r0(advertAppInfo, "show");
        }
        if (q.class.isAssignableFrom(view.getClass())) {
            frsAppLegoViewHolder.c(((q) view).getVideoOrVrView());
        }
        return view;
    }
}
