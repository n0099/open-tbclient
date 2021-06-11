package d.a.n0.t2.b0;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.CardAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.n0.t2.c0.h;
import d.a.n0.t2.p;
import d.a.n0.t2.r;
import d.a.n0.t2.t;
import d.a.n0.t2.y;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b extends d.a.c.k.e.a<d.a.n0.z.e0.d, CardAppLegoViewHolder> implements p, t {
    public TbPageContext<?> m;
    public int n;
    public boolean o;
    public AdvertAppInfo.ILegoAdvert p;
    public Runnable q;
    public CustomMessageListener r;

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.k1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f64594a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f64595b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f64596c;

        public a(b bVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f64594a = advertAppInfo;
            this.f64595b = i2;
            this.f64596c = str;
        }

        @Override // d.a.n0.k1.o.a
        public void a(int i2, HashMap hashMap) {
            if (i2 == 0) {
                return;
            }
            if (y.p(i2)) {
                d.a.n0.t2.i0.d.f(this.f64594a, this.f64595b, hashMap, i2);
            } else {
                d.a.n0.t2.i0.d.n(this.f64594a, this.f64595b, this.f64596c, null, hashMap);
            }
            d.a.n0.k1.o.h.c.h(d.a.n0.k1.o.h.c.e(this.f64594a));
        }
    }

    /* renamed from: d.a.n0.t2.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1671b implements d.a.n0.k1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64597a;

        public C1671b(String str) {
            this.f64597a = str;
        }

        @Override // d.a.n0.k1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(b.this.m.getPageActivity(), advertAppInfo, i2, b.this.q0(advertAppInfo, this.f64597a));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((CardAppLegoViewHolder) b.this.k).b((int) TimeUnit.SECONDS.toSeconds(1L));
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.k == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) b.this.k).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) b.this.k).stopPlay();
            } else {
                int d2 = ((CardAppLegoViewHolder) b.this.k).d();
                if (!((CardAppLegoViewHolder) b.this.k).c()) {
                    if (d2 != -1) {
                        ((CardAppLegoViewHolder) b.this.k).stopPlay();
                    }
                } else if (d2 == -1) {
                    d.a.c.e.m.e.a().removeCallbacks(b.this.q);
                    d.a.c.e.m.e.a().postDelayed(b.this.q, 500L);
                }
            }
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = 3;
        this.o = false;
        this.p = null;
        this.q = new c();
        this.r = new d(2921517);
        this.m = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.j4 || bdUniqueId == AdvertAppInfo.l4) {
                MessageManager.getInstance().registerListener(this.r);
            }
        }
    }

    @Override // d.a.n0.t2.t
    public void k(boolean z) {
        this.o = z;
    }

    @Override // d.a.n0.t2.p
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.r);
    }

    @Override // d.a.n0.t2.p
    public void onPause() {
    }

    @Override // d.a.n0.t2.p
    public void onResume() {
    }

    public final DownloadStaticsData q0(AdvertAppInfo advertAppInfo, String str) {
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
    /* renamed from: s0 */
    public View I(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.d dVar) {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null || (advertAppInfo = dVar.f67182e) == null || (iLegoAdvert = advertAppInfo.R3) == null) {
            return null;
        }
        this.p = iLegoAdvert;
        if (t0(view)) {
            CardAppLegoViewHolder Q = Q(viewGroup);
            this.k = Q;
            if (Q != null) {
                view = Q.a();
            }
        }
        View view2 = view;
        if (view2 != null) {
            view2 = X(i2, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
            if (r.class.isAssignableFrom(view2.getClass())) {
                ((CardAppLegoViewHolder) this.k).e(((r) view2).getVideoOrVrView());
            }
        }
        return view2;
    }

    public final boolean t0(View view) {
        V v;
        if (view == null || view.getTag() == null || (v = this.k) == 0 || this.p == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
            return true;
        }
        return !this.p.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public CardAppLegoViewHolder Q(ViewGroup viewGroup) {
        View view;
        if (this.p == null || (view = (View) d.a.n0.k1.o.b.h().a(this.m, this.p, 2)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.p);
        return new CardAppLegoViewHolder((d.a.n0.k1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: w0 */
    public CardAppLegoViewHolder R(ViewGroup viewGroup, d.a.n0.z.e0.d dVar) {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null || (advertAppInfo = dVar.f67182e) == null || (iLegoAdvert = advertAppInfo.R3) == null) {
            return null;
        }
        this.p = iLegoAdvert;
        return Q(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: x0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        AdvertAppInfo advertAppInfo;
        if (this.m != null && dVar != null && (advertAppInfo = dVar.f67182e) != null) {
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.R3;
            this.p = iLegoAdvert;
            if (iLegoAdvert != null && view != null) {
                if (this.k == 0) {
                    this.k = cardAppLegoViewHolder;
                }
                d.a.m0.r.q.d.d(dVar);
                this.m.getLayoutMode().k(this.n == 1);
                this.m.getLayoutMode().j(view);
                AdvertAppInfo c2 = dVar.c();
                d.a.n0.k1.o.l.e eVar = (d.a.n0.k1.o.l.e) view;
                this.p.setAdvertAppInfo(c2);
                eVar.setFromCDN(this.o);
                eVar.i(this.p);
                int i3 = dVar.f67184g;
                String str = dVar.f67183f;
                eVar.setAfterClickSchemeListener(new a(this, c2, i3, str));
                eVar.setDownloadAppCallback(new C1671b(str));
                if (r.class.isAssignableFrom(view.getClass())) {
                    cardAppLegoViewHolder.e(((r) view).getVideoOrVrView());
                }
                return view;
            }
        }
        return null;
    }
}
