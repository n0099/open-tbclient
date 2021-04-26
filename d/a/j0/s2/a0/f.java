package d.a.j0.s2.a0;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.PbAppLegoViewHolder;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.j0.d3.h0.o;
import d.a.j0.s2.b0.h;
import d.a.j0.s2.q;
import d.a.j0.s2.s;
import d.a.j0.s2.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class f extends d.a.c.j.e.a<o, PbAppLegoViewHolder> implements s, d.a.j0.s2.o {
    public BaseFragmentActivity m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public WeakReference<PbAppLegoViewHolder> s;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class d implements d.a.j0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f60085a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60086b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60087c;

        /* loaded from: classes3.dex */
        public class a extends BdAsyncTask<String, Void, Void> {
            public a(d dVar) {
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

        public d(f fVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f60085a = advertAppInfo;
            this.f60086b = i2;
            this.f60087c = str;
        }

        @Override // d.a.j0.j1.o.a
        public void a(int i2, HashMap hashMap) {
            if (i2 == 0) {
                return;
            }
            if (x.p(i2)) {
                d.a.j0.s2.h0.d.f(this.f60085a, this.f60086b, hashMap, i2);
            } else {
                d.a.j0.s2.h0.d.n(this.f60085a, this.f60086b, this.f60087c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.f60085a;
            if (advertAppInfo.g4) {
                return;
            }
            d.a.j0.j1.o.h.c.h(d.a.j0.j1.o.h.c.e(advertAppInfo));
        }

        @Override // d.a.j0.j1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
            d.a.j0.s2.h0.d.n(this.f60085a, this.f60086b, this.f60087c, str, hashMap);
            AdvertAppInfo advertAppInfo = this.f60085a;
            if (advertAppInfo.g4) {
                return;
            }
            d.a.j0.j1.o.h.c.h(d.a.j0.j1.o.h.c.e(advertAppInfo));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            new a(this).execute(str2);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.j0.j1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60088a;

        public e(String str) {
            this.f60088a = str;
        }

        @Override // d.a.j0.j1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(f.this.m.getPageContext().getPageActivity(), advertAppInfo, i2, f.this.q0(advertAppInfo, this.f60088a));
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

    @Override // d.a.j0.s2.s
    public void j(boolean z) {
        this.n = z;
    }

    @Override // d.a.j0.s2.o
    public void onDestroy() {
        V v = this.k;
        if (v != 0) {
            ((PbAppLegoViewHolder) v).e();
        }
    }

    @Override // d.a.j0.s2.o
    public void onPause() {
        V v = this.k;
        if (v != 0) {
            ((PbAppLegoViewHolder) v).stopPlay();
        }
        this.o = false;
    }

    @Override // d.a.j0.s2.o
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
        downloadStaticsData.setDa_page(r0(advertAppInfo));
        downloadStaticsData.setFid(str);
        downloadStaticsData.setApk_name(advertAppInfo.J3);
        downloadStaticsData.setAdPosition(advertAppInfo.K3);
        downloadStaticsData.setPrice(advertAppInfo.O3);
        downloadStaticsData.setExtensionInfo(advertAppInfo.T3);
        return downloadStaticsData;
    }

    public final String r0(AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.c4) ? "PB" : advertAppInfo.c4;
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
            if (q.class.isAssignableFrom(view2.getClass())) {
                ((PbAppLegoViewHolder) this.k).f(((q) view2).getVideoOrVrView());
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
        View view = (View) d.a.j0.j1.o.b.h().a(this.m.getPageContext(), oVar.F0(), 4);
        if (view != null) {
            PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((d.a.j0.j1.o.l.e) view);
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
        d.a.i0.r.q.d.f(oVar);
        if (oVar.N0) {
            d.a.j0.o.e.a.i().k(d.a.j0.o.e.a.g(oVar.D0()));
        }
        if (!oVar.z0) {
            d.a.i0.u.a.l().u(oVar.L0(), oVar.B0, oVar.E0, oVar.E0(), "show", oVar.K0);
            oVar.z0 = true;
        }
        if (oVar != null) {
            d.a.i0.u.a.o = oVar.A0;
        }
        AdvertAppInfo L0 = oVar.L0();
        if (L0.Y3 == null) {
            L0.Y3 = new d.a.i0.r.q.d();
        }
        d.a.i0.r.q.d dVar = L0.Y3;
        dVar.f49117b = oVar.K0;
        dVar.f49116a = oVar.E0();
        L0.position = oVar.M0;
        L0.g4 = oVar.N0;
        d.a.j0.j1.o.l.e eVar = (d.a.j0.j1.o.l.e) view;
        F0.setAdvertAppInfo(L0);
        eVar.setFromCDN(this.n);
        eVar.g(F0);
        int i3 = oVar.K0;
        String str = oVar.B0;
        eVar.setAfterClickSchemeListener(new d(this, L0, i3, str));
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
