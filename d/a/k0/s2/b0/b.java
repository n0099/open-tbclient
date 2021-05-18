package d.a.k0.s2.b0;

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
import d.a.k0.s2.c0.h;
import d.a.k0.s2.p;
import d.a.k0.s2.r;
import d.a.k0.s2.t;
import d.a.k0.s2.y;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b extends d.a.c.j.e.a<d.a.k0.x.e0.d, CardAppLegoViewHolder> implements p, t {
    public TbPageContext<?> m;
    public int n;
    public boolean o;
    public AdvertAppInfo.ILegoAdvert p;
    public Runnable q;
    public CustomMessageListener r;

    /* loaded from: classes5.dex */
    public class a implements d.a.k0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f60800a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60801b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60802c;

        public a(b bVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            this.f60800a = advertAppInfo;
            this.f60801b = i2;
            this.f60802c = str;
        }

        @Override // d.a.k0.j1.o.a
        public void a(int i2, HashMap hashMap) {
            if (i2 == 0) {
                return;
            }
            if (y.p(i2)) {
                d.a.k0.s2.i0.d.f(this.f60800a, this.f60801b, hashMap, i2);
            } else {
                d.a.k0.s2.i0.d.n(this.f60800a, this.f60801b, this.f60802c, null, hashMap);
            }
            d.a.k0.j1.o.h.c.h(d.a.k0.j1.o.h.c.e(this.f60800a));
        }
    }

    /* renamed from: d.a.k0.s2.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1609b implements d.a.k0.j1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60803a;

        public C1609b(String str) {
            this.f60803a = str;
        }

        @Override // d.a.k0.j1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            h.b(b.this.m.getPageActivity(), advertAppInfo, i2, b.this.q0(advertAppInfo, this.f60803a));
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
            if (bdUniqueId == AdvertAppInfo.f4 || bdUniqueId == AdvertAppInfo.h4) {
                MessageManager.getInstance().registerListener(this.r);
            }
        }
    }

    @Override // d.a.k0.s2.t
    public void j(boolean z) {
        this.o = z;
    }

    @Override // d.a.k0.s2.p
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.r);
    }

    @Override // d.a.k0.s2.p
    public void onPause() {
    }

    @Override // d.a.k0.s2.p
    public void onResume() {
    }

    public final DownloadStaticsData q0(AdvertAppInfo advertAppInfo, String str) {
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
    /* renamed from: s0 */
    public View H(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.d dVar) {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null || (advertAppInfo = dVar.f63184e) == null || (iLegoAdvert = advertAppInfo.N3) == null) {
            return null;
        }
        this.p = iLegoAdvert;
        if (t0(view)) {
            CardAppLegoViewHolder P = P(viewGroup);
            this.k = P;
            if (P != null) {
                view = P.a();
            }
        }
        View view2 = view;
        if (view2 != null) {
            view2 = W(i2, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
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
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public CardAppLegoViewHolder P(ViewGroup viewGroup) {
        View view;
        if (this.p == null || (view = (View) d.a.k0.j1.o.b.h().a(this.m, this.p, 2)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.p);
        return new CardAppLegoViewHolder((d.a.k0.j1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: v0 */
    public CardAppLegoViewHolder Q(ViewGroup viewGroup, d.a.k0.x.e0.d dVar) {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null || (advertAppInfo = dVar.f63184e) == null || (iLegoAdvert = advertAppInfo.N3) == null) {
            return null;
        }
        this.p = iLegoAdvert;
        return P(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: w0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        AdvertAppInfo advertAppInfo;
        if (this.m != null && dVar != null && (advertAppInfo = dVar.f63184e) != null) {
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.N3;
            this.p = iLegoAdvert;
            if (iLegoAdvert != null && view != null) {
                if (this.k == 0) {
                    this.k = cardAppLegoViewHolder;
                }
                d.a.j0.r.q.d.d(dVar);
                this.m.getLayoutMode().k(this.n == 1);
                this.m.getLayoutMode().j(view);
                AdvertAppInfo h2 = dVar.h();
                d.a.k0.j1.o.l.e eVar = (d.a.k0.j1.o.l.e) view;
                this.p.setAdvertAppInfo(h2);
                eVar.setFromCDN(this.o);
                eVar.g(this.p);
                int i3 = dVar.f63186g;
                String str = dVar.f63185f;
                eVar.setAfterClickSchemeListener(new a(this, h2, i3, str));
                eVar.setDownloadAppCallback(new C1609b(str));
                if (r.class.isAssignableFrom(view.getClass())) {
                    cardAppLegoViewHolder.e(((r) view).getVideoOrVrView());
                }
                return view;
            }
        }
        return null;
    }
}
