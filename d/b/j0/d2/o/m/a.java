package d.b.j0.d2.o.m;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.j0.d2.h.h;
import d.b.j0.d2.h.p;
import d.b.j0.d2.h.t;
import d.b.j0.d2.k.e.j;
import d.b.j0.d2.k.e.l;
import d.b.j0.d2.k.e.z;
import d.b.j0.d3.h0.o;
import d.b.j0.s2.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f55045b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.d2.h.e f55046c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f55047d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f55048e;

    /* renamed from: f  reason: collision with root package name */
    public f f55049f;

    /* renamed from: g  reason: collision with root package name */
    public d f55050g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f55051h;
    public l i;
    public j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public d.b.c.j.e.a m;
    public d.b.c.j.e.a n;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f55044a = new ArrayList();
    public View.OnClickListener o = new View$OnClickListenerC1253a();

    /* renamed from: d.b.j0.d2.o.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1253a implements View.OnClickListener {
        public View$OnClickListenerC1253a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.qq_share_container) {
                if (a.this.f(11009)) {
                    a.this.i(8);
                }
            } else if (view.getId() == R.id.share_num_container) {
                if (a.this.f(11009)) {
                    a.this.i(3);
                }
            } else if (a.this.f55045b == null || a.this.f55045b.I() == null || a.this.f55045b.I().V2() == null) {
            } else {
                a.this.f55045b.I().V2().onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends f0<ShareItem> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.b.j0.d2.k.e.d1.b.c(a.this.f55045b.getContext(), a.this.h(), ShareSwitch.isOn() ? 1 : 6, a.this.f55045b.L());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.i0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55054a;

        public c(int i) {
            this.f55054a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.f55045b.getContext(), this.f55054a, shareItem, false));
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55045b = detailInfoFragment;
        this.f55047d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        if (oVar == null || this.f55046c == null || oVar.D0() == null) {
            return;
        }
        oVar.D0().advertAppContext = new d.b.i0.r.q.d();
        if (this.f55046c.w() != null) {
            oVar.D0().advertAppContext.f51493b = this.f55046c.w().a();
        }
        oVar.D0().advertAppContext.f51492a = oVar.E0();
        if (this.f55046c.l() != null && (l = this.f55046c.l()) != null) {
            oVar.D0().advertAppContext.f51495d = l.getId();
            oVar.D0().advertAppContext.f51496e = l.getFirst_class();
            oVar.D0().advertAppContext.f51497f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.D0().advertAppContext.f51498g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.D0().advertAppContext.f51499h = oVar.D0().ext_info;
        oVar.D0().advertAppContext.i = false;
    }

    public final boolean f(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f55045b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f55045b.P(), true, i)));
            return false;
        }
        return true;
    }

    public final List<n> g(d.b.j0.d2.h.e eVar) {
        PostData postData;
        o oVar = null;
        if (eVar == null) {
            return null;
        }
        this.f55048e = new ArrayList();
        Iterator<PostData> it = eVar.D().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.A() == 1) {
                    break;
                }
            }
        }
        if (postData == null && eVar.j() != null) {
            postData = eVar.j();
        }
        if (postData != null) {
            this.f55048e.add(postData);
        }
        t tVar = new t();
        a2 L = eVar.L();
        tVar.f54292e = L;
        if (L != null && k.isEmpty(L.i0())) {
            tVar.f54292e.y3(eVar.n());
        }
        this.f55048e.add(tVar);
        p pVar = new p(eVar.L(), eVar.d());
        pVar.f54275f = true;
        this.f55048e.add(pVar);
        if (postData != null && postData.k0 != null && (eVar.l() == null || !TextUtils.equals(eVar.l().getName(), this.f55045b.L().a0()) || !this.f55045b.L().e0())) {
            h hVar = new h(postData.k0);
            hVar.f54250f = this.f55045b.L().O0();
            this.f55048e.add(hVar);
        }
        List<o> V = eVar.V();
        int i = 0;
        int i2 = -1;
        if (!d.b.j0.j1.o.k.a.e(V) && (oVar = (o) d.b.j0.j1.o.k.a.d(V, 0)) != null) {
            i2 = oVar.getPosition();
        }
        if (eVar.f() != null) {
            d.b.j0.d2.h.d dVar = new d.b.j0.d2.h.d();
            dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.f55048e.add(dVar);
            int i3 = 1;
            for (d.b.i0.r.q.p pVar2 : eVar.f()) {
                if (V != null && i3 == i2) {
                    if (oVar != null) {
                        e(oVar);
                        d.b.j0.j1.o.k.a.a(this.f55048e, oVar);
                        i++;
                        if (oVar.getType() != AdvertAppInfo.i4) {
                            i3++;
                        }
                    }
                    if (i < V.size() && (oVar = (o) d.b.j0.j1.o.k.a.d(V, i)) != null) {
                        i2 = oVar.getPosition();
                    }
                }
                d.b.j0.j1.o.k.a.a(this.f55048e, pVar2);
                i3++;
                if (i3 == 4 && eVar.A() != null) {
                    d.b.j0.j1.o.k.a.a(this.f55048e, eVar.A());
                    i3++;
                }
            }
        }
        return this.f55048e;
    }

    public final int h() {
        d.b.j0.d2.h.e eVar = this.f55046c;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f55046c.L().G();
    }

    public final void i(int i) {
        h0.b(new b(), new c(i));
        StatisticItem statisticItem = new StatisticItem("c13833");
        statisticItem.param("obj_locate", 1);
        if (i == 3) {
            statisticItem.param("obj_type", 1);
        } else if (i == 8) {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void j(DetailInfoFragment detailInfoFragment) {
        this.m = v.p().a(detailInfoFragment.I().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.n = v.p().a(detailInfoFragment.I().getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.f55044a.add(this.m);
        this.f55044a.add(this.n);
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55049f = new f(detailInfoFragment.I(), PostData.o0);
        this.f55050g = new d(detailInfoFragment.getContext(), t.f54291f);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.I(), p.j);
        this.f55051h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.o);
        this.i = new l(detailInfoFragment.I(), d.b.j0.d2.h.d.f54233g);
        j jVar = new j(detailInfoFragment.I(), d.b.i0.r.q.p.I3);
        this.j = jVar;
        jVar.p0(true);
        this.k = new z(detailInfoFragment.I());
        this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), h.f54248g);
        this.f55044a.add(this.f55049f);
        this.f55044a.add(this.f55050g);
        this.f55044a.add(this.f55051h);
        this.f55044a.add(this.i);
        this.f55044a.add(this.j);
        this.f55044a.add(this.k);
        this.f55044a.add(this.l);
        j(detailInfoFragment);
        bdTypeRecyclerView.a(this.f55044a);
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55047d;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f55047d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar = this.f55049f;
        if (fVar != null) {
            fVar.L();
        }
    }

    public void n(d.b.j0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f55046c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f55047d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f55049f.H0(eVar);
        this.j.o0(eVar);
        this.k.m0(eVar);
        this.f55047d.setData(g(eVar));
    }
}
