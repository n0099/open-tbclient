package d.b.i0.r2.w;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.CardAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.b.i0.r2.l;
import d.b.i0.r2.n;
import d.b.i0.r2.p;
import d.b.i0.r2.t;
import d.b.i0.r2.x.h;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b extends d.b.b.j.e.a<d.b.i0.x.e0.d, CardAppLegoViewHolder> implements l, p {
    public TbPageContext<?> m;
    public int n;
    public boolean o;
    public AdvertAppInfo.ILegoAdvert p;
    public Runnable q;
    public CustomMessageListener r;

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.i1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f59867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f59868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f59869c;

        /* renamed from: d.b.i0.r2.w.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1509a extends BdAsyncTask<String, Void, Void> {
            public C1509a(a aVar) {
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

        public a(b bVar, AdvertAppInfo advertAppInfo, int i, String str) {
            this.f59867a = advertAppInfo;
            this.f59868b = i;
            this.f59869c = str;
        }

        @Override // d.b.i0.i1.o.a
        public void a(int i, HashMap hashMap) {
            if (i == 0) {
                return;
            }
            if (t.p(i)) {
                d.b.i0.r2.b0.d.e(this.f59867a, this.f59868b, hashMap, i);
            } else {
                d.b.i0.r2.b0.d.k(this.f59867a, this.f59868b, this.f59869c, null, hashMap);
            }
            d.b.i0.i1.o.h.c.h(d.b.i0.i1.o.h.c.e(this.f59867a));
        }

        @Override // d.b.i0.i1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
            d.b.i0.r2.b0.d.k(this.f59867a, this.f59868b, this.f59869c, str, hashMap);
            d.b.i0.i1.o.h.c.h(d.b.i0.i1.o.h.c.e(this.f59867a));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            new C1509a(this).execute(str2);
        }
    }

    /* renamed from: d.b.i0.r2.w.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1510b implements d.b.i0.i1.o.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59870a;

        public C1510b(String str) {
            this.f59870a = str;
        }

        @Override // d.b.i0.i1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i) {
            h.b(b.this.m.getPageActivity(), advertAppInfo, i, b.this.r0(advertAppInfo, this.f59870a));
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
        public d(int i) {
            super(i);
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
                    d.b.b.e.m.e.a().removeCallbacks(b.this.q);
                    d.b.b.e.m.e.a().postDelayed(b.this.q, 500L);
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
            if (bdUniqueId == AdvertAppInfo.q4 || bdUniqueId == AdvertAppInfo.s4) {
                MessageManager.getInstance().registerListener(this.r);
            }
        }
    }

    @Override // d.b.i0.r2.p
    public void c(boolean z) {
        this.o = z;
    }

    @Override // d.b.i0.r2.l
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.r);
    }

    @Override // d.b.i0.r2.l
    public void onPause() {
    }

    @Override // d.b.i0.r2.l
    public void onResume() {
    }

    public final DownloadStaticsData r0(AdvertAppInfo advertAppInfo, String str) {
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
    @Override // d.b.b.j.e.a
    /* renamed from: s0 */
    public View I(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.d dVar) {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null || (advertAppInfo = dVar.f62200e) == null || (iLegoAdvert = advertAppInfo.W3) == null) {
            return null;
        }
        this.p = iLegoAdvert;
        if (t0(view)) {
            CardAppLegoViewHolder R = R(viewGroup);
            this.k = R;
            if (R != null) {
                view = R.a();
            }
        }
        View view2 = view;
        if (view2 != null) {
            view2 = X(i, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
            if (n.class.isAssignableFrom(view2.getClass())) {
                ((CardAppLegoViewHolder) this.k).e(((n) view2).getVideoOrVrView());
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
    @Override // d.b.b.j.e.a
    /* renamed from: u0 */
    public CardAppLegoViewHolder R(ViewGroup viewGroup) {
        View view;
        if (this.p == null || (view = (View) d.b.i0.i1.o.b.h().a(this.m, this.p, 2)) == null) {
            return null;
        }
        view.setTag(R.id.tag_first, this.p);
        return new CardAppLegoViewHolder((d.b.i0.i1.o.l.e) view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: v0 */
    public CardAppLegoViewHolder S(ViewGroup viewGroup, d.b.i0.x.e0.d dVar) {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null || (advertAppInfo = dVar.f62200e) == null || (iLegoAdvert = advertAppInfo.W3) == null) {
            return null;
        }
        this.p = iLegoAdvert;
        return R(viewGroup);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: w0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        AdvertAppInfo advertAppInfo;
        if (this.m != null && dVar != null && (advertAppInfo = dVar.f62200e) != null) {
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.W3;
            this.p = iLegoAdvert;
            if (iLegoAdvert != null && view != null) {
                if (this.k == 0) {
                    this.k = cardAppLegoViewHolder;
                }
                d.b.h0.r.q.d.d(dVar);
                this.m.getLayoutMode().k(this.n == 1);
                this.m.getLayoutMode().j(view);
                AdvertAppInfo g2 = dVar.g();
                d.b.i0.i1.o.l.e eVar = (d.b.i0.i1.o.l.e) view;
                this.p.setAdvertAppInfo(g2);
                eVar.setFromCDN(this.o);
                eVar.c(this.p);
                int i2 = dVar.f62202g;
                String str = dVar.f62201f;
                eVar.setAfterClickSchemeListener(new a(this, g2, i2, str));
                eVar.setDownloadAppCallback(new C1510b(str));
                if (n.class.isAssignableFrom(view.getClass())) {
                    cardAppLegoViewHolder.e(((n) view).getVideoOrVrView());
                }
                return view;
            }
        }
        return null;
    }
}
