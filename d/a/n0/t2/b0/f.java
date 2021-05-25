package d.a.n0.t2.b0;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.PbAppLegoViewHolder;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.n0.e3.h0.o;
import d.a.n0.t2.c0.h;
import d.a.n0.t2.p;
import d.a.n0.t2.r;
import d.a.n0.t2.t;
import d.a.n0.t2.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class f extends d.a.c.j.e.a<o, PbAppLegoViewHolder> implements t, p {
    public BaseFragmentActivity m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public WeakReference<PbAppLegoViewHolder> s;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.k == null || !f.this.o) {
                return;
            }
            int d2 = ((PbAppLegoViewHolder) f.this.k).d();
            if (((PbAppLegoViewHolder) f.this.k).c()) {
                if (d2 == -1) {
                    ((PbAppLegoViewHolder) f.this.k).b((int) TimeUnit.SECONDS.toSeconds(1L));
                }
            } else if (d2 != -1) {
                ((PbAppLegoViewHolder) f.this.k).stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.y0();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.k != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) f.this.k).stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.n0.k1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f60917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60918b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60919c;

        public d(f fVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f60917a = advertAppInfo;
            this.f60918b = i2;
            this.f60919c = str;
        }

        @Override // d.a.n0.k1.o.a
        public void a(int i2, HashMap hashMap) {
            if (i2 == 0) {
                return;
            }
            if (y.p(i2)) {
                d.a.n0.t2.i0.d.f(this.f60917a, this.f60918b, hashMap, i2);
            } else {
                d.a.n0.t2.i0.d.n(this.f60917a, this.f60918b, this.f60919c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.f60917a;
            if (advertAppInfo.L3) {
                return;
            }
            d.a.n0.k1.o.h.c.h(d.a.n0.k1.o.h.c.e(advertAppInfo));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d.a.n0.k1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60920a;

        public e(String str) {
            this.f60920a = str;
        }

        @Override // d.a.n0.k1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(f.this.m.getPageContext().getPageActivity(), advertAppInfo, i2, f.this.q0(advertAppInfo, this.f60920a));
        }
    }

    public f(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.o = true;
        this.p = new a(2004013);
        this.q = new b(2004018);
        this.r = new c(2004020);
        this.s = null;
        this.m = baseFragmentActivity;
        baseFragmentActivity.registerListener(this.p);
        this.m.registerListener(this.r);
        this.m.registerListener(this.q);
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder P(ViewGroup viewGroup) {
        v0(viewGroup);
        throw null;
    }

    @Override // d.a.n0.t2.t
    public void j(boolean z) {
        this.n = z;
    }

    @Override // d.a.n0.t2.p
    public void onDestroy() {
        V v = this.k;
        if (v != 0) {
            ((PbAppLegoViewHolder) v).e();
        }
    }

    @Override // d.a.n0.t2.p
    public void onPause() {
        V v = this.k;
        if (v != 0) {
            ((PbAppLegoViewHolder) v).stopPlay();
        }
        this.o = false;
    }

    @Override // d.a.n0.t2.p
    public void onResume() {
        V v = this.k;
        if (v == 0 || !((PbAppLegoViewHolder) v).c()) {
            return;
        }
        if (((PbAppLegoViewHolder) this.k).d() == -1) {
            ((PbAppLegoViewHolder) this.k).b((int) TimeUnit.SECONDS.toSeconds(1L));
        }
        this.o = true;
    }

    public final DownloadStaticsData q0(AdvertAppInfo advertAppInfo, String str) {
        DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
        downloadStaticsData.setDa_page(s0(advertAppInfo));
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.Y3);
        downloadStaticsData.setAdPosition(advertAppInfo.M3);
        downloadStaticsData.setExtensionInfo(advertAppInfo.N3);
        return downloadStaticsData;
    }

    public final String s0(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.Q3) ? "PB" : advertAppInfo.Q3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public View H(int i2, View view, ViewGroup viewGroup, o oVar) {
        if (oVar == null || oVar.F0() == null) {
            return null;
        }
        if (u0(view, oVar)) {
            PbAppLegoViewHolder Q = Q(viewGroup, oVar);
            this.k = Q;
            if (Q != null) {
                view = Q.a();
            }
        }
        View view2 = view;
        if (view2 != null) {
            view2 = W(i2, view2, viewGroup, oVar, (PbAppLegoViewHolder) view2.getTag());
            if (r.class.isAssignableFrom(view2.getClass())) {
                ((PbAppLegoViewHolder) this.k).f(((r) view2).getVideoOrVrView());
            }
        }
        return view2;
    }

    public final boolean u0(View view, o oVar) {
        V v;
        if (view == null || view.getTag() == null || (v = this.k) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.k).getClass())) {
            return true;
        }
        AdvertAppInfo.ILegoAdvert F0 = oVar.F0();
        Object tag = view.getTag(R.id.tag_first);
        if (tag instanceof AdvertAppInfo.ILegoAdvert) {
            return !F0.isReusable((AdvertAppInfo.ILegoAdvert) tag);
        }
        return true;
    }

    public PbAppLegoViewHolder v0(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: w0 */
    public PbAppLegoViewHolder Q(ViewGroup viewGroup, o oVar) {
        View view = (View) d.a.n0.k1.o.b.h().a(this.m.getPageContext(), oVar.F0(), 4);
        if (view != null) {
            PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((d.a.n0.k1.o.l.e) view);
            pbAppLegoViewHolder.setIsRecyclable(false);
            return pbAppLegoViewHolder;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: x0 */
    public View W(int i2, View view, ViewGroup viewGroup, o oVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        if (this.m == null) {
            return null;
        }
        if (oVar.F0() instanceof AdCard) {
            ((AdCard) oVar.F0()).isPBBanner = oVar.y0;
        }
        pbAppLegoViewHolder.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert F0 = oVar.F0();
        view.setTag(R.id.tag_first, F0);
        this.m.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.m.getLayoutMode().j(view);
        d.a.m0.r.q.d.f(oVar);
        if (oVar.L0) {
            d.a.n0.q.e.a.i().k(d.a.n0.q.e.a.g(oVar.getAdvertAppInfo()));
        }
        AdvertAppInfo advertAppInfo = oVar.getAdvertAppInfo();
        if (advertAppInfo.P3 == null) {
            advertAppInfo.P3 = new d.a.m0.r.q.d();
        }
        d.a.m0.r.q.d dVar = advertAppInfo.P3;
        dVar.f49980b = oVar.D0;
        dVar.f49979a = oVar.E0();
        advertAppInfo.position = oVar.K0;
        advertAppInfo.L3 = oVar.L0;
        d.a.n0.k1.o.l.e eVar = (d.a.n0.k1.o.l.e) view;
        F0.setAdvertAppInfo(advertAppInfo);
        eVar.setFromCDN(this.n);
        eVar.g(F0);
        int i3 = oVar.D0;
        String str = oVar.z0;
        eVar.setAfterClickSchemeListener(new d(this, advertAppInfo, i3, str));
        eVar.setDownloadAppCallback(new e(str));
        WeakReference<PbAppLegoViewHolder> weakReference = this.s;
        if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
            this.s = new WeakReference<>(pbAppLegoViewHolder);
        }
        y0();
        return view;
    }

    public void y0() {
        WeakReference<PbAppLegoViewHolder> weakReference = this.s;
        PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
        if (pbAppLegoViewHolder != null) {
            pbAppLegoViewHolder.g();
        }
    }
}
