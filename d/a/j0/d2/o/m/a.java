package d.a.j0.d2.o.m;

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
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.j0.d2.h.h;
import d.a.j0.d2.h.p;
import d.a.j0.d2.h.t;
import d.a.j0.d2.k.e.j;
import d.a.j0.d2.k.e.l;
import d.a.j0.d2.k.e.z;
import d.a.j0.d3.h0.o;
import d.a.j0.s2.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f52872b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.d2.h.e f52873c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f52874d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f52875e;

    /* renamed from: f  reason: collision with root package name */
    public f f52876f;

    /* renamed from: g  reason: collision with root package name */
    public d f52877g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f52878h;

    /* renamed from: i  reason: collision with root package name */
    public l f52879i;
    public j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public d.a.c.j.e.a m;
    public d.a.c.j.e.a n;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f52871a = new ArrayList();
    public View.OnClickListener o = new View$OnClickListenerC1192a();

    /* renamed from: d.a.j0.d2.o.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1192a implements View.OnClickListener {
        public View$OnClickListenerC1192a() {
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
            } else if (a.this.f52872b == null || a.this.f52872b.w() == null || a.this.f52872b.w().V2() == null) {
            } else {
                a.this.f52872b.w().V2().onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends f0<ShareItem> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.j0.d2.k.e.d1.b.c(a.this.f52872b.getContext(), a.this.h(), ShareSwitch.isOn() ? 1 : 6, a.this.f52872b.z());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52882a;

        public c(int i2) {
            this.f52882a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.f52872b.getContext(), this.f52882a, shareItem, false));
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52872b = detailInfoFragment;
        this.f52874d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        if (oVar == null || this.f52873c == null || oVar.D0() == null) {
            return;
        }
        oVar.D0().advertAppContext = new d.a.i0.r.q.d();
        if (this.f52873c.w() != null) {
            oVar.D0().advertAppContext.f49117b = this.f52873c.w().a();
        }
        oVar.D0().advertAppContext.f49116a = oVar.E0();
        if (this.f52873c.l() != null && (l = this.f52873c.l()) != null) {
            oVar.D0().advertAppContext.f49119d = l.getId();
            oVar.D0().advertAppContext.f49120e = l.getFirst_class();
            oVar.D0().advertAppContext.f49121f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.D0().advertAppContext.f49122g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.D0().advertAppContext.f49123h = oVar.D0().ext_info;
        oVar.D0().advertAppContext.f49124i = false;
    }

    public final boolean f(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f52872b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f52872b.A(), true, i2)));
            return false;
        }
        return true;
    }

    public final List<n> g(d.a.j0.d2.h.e eVar) {
        PostData postData;
        o oVar = null;
        if (eVar == null) {
            return null;
        }
        this.f52875e = new ArrayList();
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
            this.f52875e.add(postData);
        }
        t tVar = new t();
        a2 L = eVar.L();
        tVar.f52076e = L;
        if (L != null && k.isEmpty(L.i0())) {
            tVar.f52076e.y3(eVar.n());
        }
        this.f52875e.add(tVar);
        p pVar = new p(eVar.L(), eVar.d());
        pVar.f52057f = true;
        this.f52875e.add(pVar);
        if (postData != null && postData.k0 != null && (eVar.l() == null || !TextUtils.equals(eVar.l().getName(), this.f52872b.z().a0()) || !this.f52872b.z().e0())) {
            h hVar = new h(postData.k0);
            hVar.f52031f = this.f52872b.z().O0();
            this.f52875e.add(hVar);
        }
        List<o> V = eVar.V();
        int i2 = 0;
        int i3 = -1;
        if (!d.a.j0.j1.o.k.a.e(V) && (oVar = (o) d.a.j0.j1.o.k.a.d(V, 0)) != null) {
            i3 = oVar.getPosition();
        }
        if (eVar.f() != null) {
            d.a.j0.d2.h.d dVar = new d.a.j0.d2.h.d();
            dVar.h(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.f52875e.add(dVar);
            int i4 = 1;
            for (d.a.i0.r.q.p pVar2 : eVar.f()) {
                if (V != null && i4 == i3) {
                    if (oVar != null) {
                        e(oVar);
                        d.a.j0.j1.o.k.a.a(this.f52875e, oVar);
                        i2++;
                        if (oVar.getType() != AdvertAppInfo.i4) {
                            i4++;
                        }
                    }
                    if (i2 < V.size() && (oVar = (o) d.a.j0.j1.o.k.a.d(V, i2)) != null) {
                        i3 = oVar.getPosition();
                    }
                }
                d.a.j0.j1.o.k.a.a(this.f52875e, pVar2);
                i4++;
                if (i4 == 4 && eVar.A() != null) {
                    d.a.j0.j1.o.k.a.a(this.f52875e, eVar.A());
                    i4++;
                }
            }
        }
        return this.f52875e;
    }

    public final int h() {
        d.a.j0.d2.h.e eVar = this.f52873c;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f52873c.L().G();
    }

    public final void i(int i2) {
        h0.b(new b(), new c(i2));
        StatisticItem statisticItem = new StatisticItem("c13833");
        statisticItem.param("obj_locate", 1);
        if (i2 == 3) {
            statisticItem.param("obj_type", 1);
        } else if (i2 == 8) {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void j(DetailInfoFragment detailInfoFragment) {
        this.m = w.p().a(detailInfoFragment.w().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.n = w.p().a(detailInfoFragment.w().getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.f52871a.add(this.m);
        this.f52871a.add(this.n);
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52876f = new f(detailInfoFragment.w(), PostData.o0);
        this.f52877g = new d(detailInfoFragment.getContext(), t.f52075f);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.w(), p.j);
        this.f52878h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.o);
        this.f52879i = new l(detailInfoFragment.w(), d.a.j0.d2.h.d.f52012g);
        j jVar = new j(detailInfoFragment.w(), d.a.i0.r.q.p.I3);
        this.j = jVar;
        jVar.n0(true);
        this.k = new z(detailInfoFragment.w());
        this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), h.f52029g);
        this.f52871a.add(this.f52876f);
        this.f52871a.add(this.f52877g);
        this.f52871a.add(this.f52878h);
        this.f52871a.add(this.f52879i);
        this.f52871a.add(this.j);
        this.f52871a.add(this.k);
        this.f52871a.add(this.l);
        j(detailInfoFragment);
        bdTypeRecyclerView.a(this.f52871a);
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52874d;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f52874d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar = this.f52876f;
        if (fVar != null) {
            fVar.K();
        }
    }

    public void n(d.a.j0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f52873c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f52874d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f52876f.H0(eVar);
        this.j.m0(eVar);
        this.k.i0(eVar);
        this.f52874d.setData(g(eVar));
    }
}
