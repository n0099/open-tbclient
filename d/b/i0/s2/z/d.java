package d.b.i0.s2.z;

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
import d.b.i0.q0.k;
import d.b.i0.s2.a0.h;
import d.b.i0.s2.q;
import d.b.i0.s2.t;
import d.b.i0.s2.w;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public AdvertAppInfo.ILegoAdvert w;
    public t x;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f61768a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f61769b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61770c;

        /* renamed from: d.b.i0.s2.z.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1588a extends BdAsyncTask<String, Void, Void> {
            public C1588a(a aVar) {
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

        public a(d dVar, AdvertAppInfo advertAppInfo, int i, String str) {
            this.f61768a = advertAppInfo;
            this.f61769b = i;
            this.f61770c = str;
        }

        @Override // d.b.i0.j1.o.a
        public void a(int i, HashMap<String, Object> hashMap) {
            if (w.p(i)) {
                d.b.i0.s2.f0.d.f(this.f61768a, this.f61769b, hashMap, i);
            } else {
                d.b.i0.s2.f0.d.n(this.f61768a, this.f61769b, this.f61770c, null, hashMap);
            }
            d.b.i0.j1.o.h.c.h(d.b.i0.j1.o.h.c.e(this.f61768a));
        }

        @Override // d.b.i0.j1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("da_area", "button");
            d.b.i0.s2.f0.d.n(this.f61768a, this.f61769b, this.f61770c, str, hashMap);
            d.b.i0.j1.o.h.c.h(d.b.i0.j1.o.h.c.e(this.f61768a));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            new C1588a(this).execute(str2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.j1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61771a;

        public b(String str) {
            this.f61771a = str;
        }

        @Override // d.b.i0.j1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i) {
            h.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i, d.this.u0(advertAppInfo, this.f61771a));
        }
    }

    public d(t tVar, BdUniqueId bdUniqueId) {
        super(tVar.q(), bdUniqueId);
        this.w = null;
        this.x = tVar;
    }

    @Override // d.b.i0.q0.k
    public void m0() {
        V v = this.k;
        if (v != 0) {
            ((FrsAppLegoViewHolder) v).b();
        }
        super.m0();
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
    @Override // d.b.c.j.e.a
    /* renamed from: v0 */
    public View I(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.W3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        if (w0(view)) {
            FrsAppLegoViewHolder R = R(viewGroup);
            this.k = R;
            if (R == null) {
                return null;
            }
            view = R.a();
        }
        View view2 = view;
        return X(i, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
    }

    public final boolean w0(View view) {
        V v;
        if (view == null || view.getTag() == null || (v = this.k) == 0 || this.w == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return true;
        }
        return !this.w.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: x0 */
    public FrsAppLegoViewHolder R(ViewGroup viewGroup) {
        View view;
        if (this.w == null || (view = (View) d.b.i0.j1.o.b.h().a(this.o, this.w, 1)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.w);
        return new FrsAppLegoViewHolder((d.b.i0.j1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: y0 */
    public FrsAppLegoViewHolder S(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.W3) == null) {
            return null;
        }
        this.w = iLegoAdvert;
        return R(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: z0 */
    public View X(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        super.X(i, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
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
        if (j0()) {
            advertAppInfo.position = i - this.n.getTopThreadSize();
        }
        d.b.h0.r.q.d.b(advertAppInfo);
        d.b.i0.j1.o.l.e eVar = (d.b.i0.j1.o.l.e) view;
        eVar.setFromCDN(this.m);
        eVar.c(this.w);
        String V = this.x.V();
        int n0 = this.x.n0();
        this.x.u0();
        eVar.setAfterClickSchemeListener(new a(this, advertAppInfo, n0, V));
        eVar.setDownloadAppCallback(new b(V));
        if (!advertAppInfo.V3) {
            advertAppInfo.V3 = true;
            this.x.j0(advertAppInfo, "show");
        }
        if (q.class.isAssignableFrom(view.getClass())) {
            frsAppLegoViewHolder.c(((q) view).getVideoOrVrView());
        }
        return view;
    }
}
