package d.a.o0.t2.b0;

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
import d.a.o0.e3.h0.o;
import d.a.o0.t2.c0.h;
import d.a.o0.t2.p;
import d.a.o0.t2.r;
import d.a.o0.t2.t;
import d.a.o0.t2.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class f extends d.a.c.k.e.a<o, PbAppLegoViewHolder> implements t, p {
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
            f.this.z0();
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
    public class d implements d.a.o0.k1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f64734a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f64735b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f64736c;

        public d(f fVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f64734a = advertAppInfo;
            this.f64735b = i2;
            this.f64736c = str;
        }

        @Override // d.a.o0.k1.o.a
        public void a(int i2, HashMap hashMap) {
            if (i2 == 0) {
                return;
            }
            if (y.p(i2)) {
                d.a.o0.t2.i0.d.f(this.f64734a, this.f64735b, hashMap, i2);
            } else {
                d.a.o0.t2.i0.d.n(this.f64734a, this.f64735b, this.f64736c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.f64734a;
            if (advertAppInfo.O3) {
                return;
            }
            d.a.o0.k1.o.h.c.h(d.a.o0.k1.o.h.c.e(advertAppInfo));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d.a.o0.k1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64737a;

        public e(String str) {
            this.f64737a = str;
        }

        @Override // d.a.o0.k1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(f.this.m.getPageContext().getPageActivity(), advertAppInfo, i2, f.this.q0(advertAppInfo, this.f64737a));
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
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder Q(ViewGroup viewGroup) {
        w0(viewGroup);
        throw null;
    }

    @Override // d.a.o0.t2.t
    public void k(boolean z) {
        this.n = z;
    }

    @Override // d.a.o0.t2.p
    public void onDestroy() {
        V v = this.k;
        if (v != 0) {
            ((PbAppLegoViewHolder) v).e();
        }
    }

    @Override // d.a.o0.t2.p
    public void onPause() {
        V v = this.k;
        if (v != 0) {
            ((PbAppLegoViewHolder) v).stopPlay();
        }
        this.o = false;
    }

    @Override // d.a.o0.t2.p
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
        downloadStaticsData.setApk_name(advertAppInfo.b4);
        downloadStaticsData.setAdPosition(advertAppInfo.P3);
        downloadStaticsData.setExtensionInfo(advertAppInfo.Q3);
        return downloadStaticsData;
    }

    public final String s0(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.T3) ? "PB" : advertAppInfo.T3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: t0 */
    public View I(int i2, View view, ViewGroup viewGroup, o oVar) {
        if (oVar == null || oVar.F0() == null) {
            return null;
        }
        if (v0(view, oVar)) {
            PbAppLegoViewHolder R = R(viewGroup, oVar);
            this.k = R;
            if (R != null) {
                view = R.a();
            }
        }
        View view2 = view;
        if (view2 != null) {
            view2 = X(i2, view2, viewGroup, oVar, (PbAppLegoViewHolder) view2.getTag());
            if (r.class.isAssignableFrom(view2.getClass())) {
                ((PbAppLegoViewHolder) this.k).f(((r) view2).getVideoOrVrView());
            }
        }
        return view2;
    }

    public final boolean v0(View view, o oVar) {
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

    public PbAppLegoViewHolder w0(ViewGroup viewGroup) {
        throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: x0 */
    public PbAppLegoViewHolder R(ViewGroup viewGroup, o oVar) {
        View view = (View) d.a.o0.k1.o.b.h().a(this.m.getPageContext(), oVar.F0(), 4);
        if (view != null) {
            PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((d.a.o0.k1.o.l.e) view);
            pbAppLegoViewHolder.setIsRecyclable(false);
            return pbAppLegoViewHolder;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: y0 */
    public View X(int i2, View view, ViewGroup viewGroup, o oVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        if (this.m == null) {
            return null;
        }
        if (oVar.F0() instanceof AdCard) {
            ((AdCard) oVar.F0()).isPBBanner = oVar.D0;
        }
        pbAppLegoViewHolder.setIsRecyclable(false);
        AdvertAppInfo.ILegoAdvert F0 = oVar.F0();
        view.setTag(R.id.tag_first, F0);
        this.m.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.m.getLayoutMode().j(view);
        d.a.n0.r.q.d.f(oVar);
        if (oVar.L0) {
            d.a.o0.q.e.a.i().k(d.a.o0.q.e.a.g(oVar.getAdvertAppInfo()));
        }
        AdvertAppInfo advertAppInfo = oVar.getAdvertAppInfo();
        if (advertAppInfo.S3 == null) {
            advertAppInfo.S3 = new d.a.n0.r.q.d();
        }
        d.a.n0.r.q.d dVar = advertAppInfo.S3;
        dVar.f53763b = oVar.I0;
        dVar.f53762a = oVar.E0();
        advertAppInfo.position = oVar.K0;
        advertAppInfo.O3 = oVar.L0;
        d.a.o0.k1.o.l.e eVar = (d.a.o0.k1.o.l.e) view;
        F0.setAdvertAppInfo(advertAppInfo);
        eVar.setFromCDN(this.n);
        eVar.i(F0);
        int i3 = oVar.I0;
        String str = oVar.E0;
        eVar.setAfterClickSchemeListener(new d(this, advertAppInfo, i3, str));
        eVar.setDownloadAppCallback(new e(str));
        WeakReference<PbAppLegoViewHolder> weakReference = this.s;
        if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
            this.s = new WeakReference<>(pbAppLegoViewHolder);
        }
        z0();
        return view;
    }

    public void z0() {
        WeakReference<PbAppLegoViewHolder> weakReference = this.s;
        PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
        if (pbAppLegoViewHolder != null) {
            pbAppLegoViewHolder.h();
        }
    }
}
