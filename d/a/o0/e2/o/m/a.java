package d.a.o0.e2.o.m;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
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
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.o0.e2.h.h;
import d.a.o0.e2.h.p;
import d.a.o0.e2.h.q;
import d.a.o0.e2.h.u;
import d.a.o0.e2.k.e.j;
import d.a.o0.e2.k.e.l;
import d.a.o0.e2.k.e.s0;
import d.a.o0.e2.k.e.z;
import d.a.o0.e3.h0.o;
import d.a.o0.t2.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f57599b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.e2.h.e f57600c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f57601d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f57602e;

    /* renamed from: f  reason: collision with root package name */
    public f f57603f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.e2.o.m.d f57604g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f57605h;

    /* renamed from: i  reason: collision with root package name */
    public l f57606i;
    public j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public d.a.c.k.e.a n;
    public d.a.c.k.e.a o;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f57598a = new ArrayList();
    public View.OnClickListener p = new View$OnClickListenerC1342a();
    public View.OnClickListener q = new b();

    /* renamed from: d.a.o0.e2.o.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1342a implements View.OnClickListener {

        /* renamed from: d.a.o0.e2.o.m.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1343a implements FullBrowseHelper.IAcceptPrivacyConfirm {

            /* renamed from: d.a.o0.e2.o.m.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1344a implements Runnable {
                public RunnableC1344a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f57599b.A().I1(3);
                }
            }

            public C1343a() {
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                if (!d.a.c.e.p.j.z()) {
                    a.this.f57599b.X0();
                } else {
                    d.a.c.e.m.e.a().postDelayed(new RunnableC1344a(), 10L);
                }
            }
        }

        public View$OnClickListenerC1342a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57599b == null || a.this.f57599b.A() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(a.this.f57599b.getPageContext(), new C1343a());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
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
            } else if (a.this.f57599b == null || a.this.f57599b.x() == null || a.this.f57599b.x().Z2() == null) {
            } else {
                a.this.f57599b.x().Z2().onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f0<ShareItem> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.o0.e2.k.e.e1.b.c(a.this.f57599b.getContext(), a.this.h(), ShareSwitch.isOn() ? 1 : 6, a.this.f57599b.A());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.n0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f57612a;

        public d(int i2) {
            this.f57612a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.f57599b.getContext(), this.f57612a, shareItem, false));
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57599b = detailInfoFragment;
        this.f57601d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        if (oVar == null || this.f57600c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().S3 = new d.a.n0.r.q.d();
        if (this.f57600c.w() != null) {
            oVar.getAdvertAppInfo().S3.f53763b = this.f57600c.w().a();
        }
        oVar.getAdvertAppInfo().S3.f53762a = oVar.E0();
        if (this.f57600c.l() != null && (l = this.f57600c.l()) != null) {
            oVar.getAdvertAppInfo().S3.f53765d = l.getId();
            oVar.getAdvertAppInfo().S3.f53766e = l.getFirst_class();
            oVar.getAdvertAppInfo().S3.f53767f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().S3.f53768g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().S3.f53769h = oVar.getAdvertAppInfo().Q3;
        oVar.getAdvertAppInfo().S3.f53770i = false;
    }

    public final boolean f(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f57599b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f57599b.B(), true, i2)));
            return false;
        }
        return true;
    }

    public final List<n> g(d.a.o0.e2.h.e eVar) {
        PostData postData;
        o oVar = null;
        if (eVar == null) {
            return null;
        }
        this.f57602e = new ArrayList();
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
            this.f57602e.add(postData);
        }
        if (d.a.n0.c1.b.e.d()) {
            return this.f57602e;
        }
        u uVar = new u();
        a2 L = eVar.L();
        uVar.f56795e = L;
        if (L != null && k.isEmpty(L.i0())) {
            uVar.f56795e.C3(eVar.n());
        }
        this.f57602e.add(uVar);
        p pVar = new p(eVar.L(), eVar.d());
        pVar.f56775f = true;
        this.f57602e.add(pVar);
        if (postData != null && postData.p0 != null && (eVar.l() == null || !TextUtils.equals(eVar.l().getName(), this.f57599b.A().e0()) || !this.f57599b.A().i0())) {
            h hVar = new h(postData.p0);
            hVar.f56749f = this.f57599b.A().S0();
            this.f57602e.add(hVar);
        }
        List<o> V = eVar.V();
        int i2 = 0;
        int i3 = -1;
        if (!d.a.o0.k1.o.k.a.e(V) && (oVar = (o) d.a.o0.k1.o.k.a.d(V, 0)) != null) {
            i3 = oVar.getPosition();
        }
        if (eVar.f() != null) {
            d.a.o0.e2.h.d dVar = new d.a.o0.e2.h.d();
            dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.f57602e.add(dVar);
            if (TbSingleton.getInstance().isBrowseMode()) {
                this.f57602e.add(new q());
            } else {
                int i4 = 1;
                for (d.a.n0.r.q.p pVar2 : eVar.f()) {
                    if (V != null && i4 == i3) {
                        if (oVar != null) {
                            e(oVar);
                            d.a.o0.k1.o.k.a.a(this.f57602e, oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.e4) {
                                i4++;
                            }
                        }
                        if (i2 < V.size() && (oVar = (o) d.a.o0.k1.o.k.a.d(V, i2)) != null) {
                            i3 = oVar.getPosition();
                        }
                    }
                    d.a.o0.k1.o.k.a.a(this.f57602e, pVar2);
                    i4++;
                    if (i4 == 4 && eVar.A() != null) {
                        d.a.o0.k1.o.k.a.a(this.f57602e, eVar.A());
                        i4++;
                    }
                }
            }
        }
        return this.f57602e;
    }

    public final int h() {
        d.a.o0.e2.h.e eVar = this.f57600c;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f57600c.L().G();
    }

    public final void i(int i2) {
        h0.b(new c(), new d(i2));
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
        this.n = x.p().a(detailInfoFragment.x().getBaseFragmentActivity(), AdvertAppInfo.e4);
        this.o = x.p().a(detailInfoFragment.x().getBaseFragmentActivity(), AdvertAppInfo.g4);
        this.f57598a.add(this.n);
        this.f57598a.add(this.o);
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57603f = new f(detailInfoFragment.x(), PostData.t0);
        this.f57604g = new d.a.o0.e2.o.m.d(detailInfoFragment.getContext(), u.f56794f);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.x(), p.j);
        this.f57605h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
        this.f57606i = new l(detailInfoFragment.x(), d.a.o0.e2.h.d.f56730g);
        j jVar = new j(detailInfoFragment.x(), d.a.n0.r.q.p.N3);
        this.j = jVar;
        jVar.m0(true);
        this.k = new z(detailInfoFragment.x());
        this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), h.f56747g);
        s0 s0Var = new s0(detailInfoFragment.x(), q.f56779e);
        this.m = s0Var;
        s0Var.j0(this.p);
        this.f57598a.add(this.f57603f);
        this.f57598a.add(this.f57604g);
        this.f57598a.add(this.f57605h);
        this.f57598a.add(this.f57606i);
        this.f57598a.add(this.j);
        this.f57598a.add(this.k);
        this.f57598a.add(this.l);
        this.f57598a.add(this.m);
        j(detailInfoFragment);
        bdTypeRecyclerView.a(this.f57598a);
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57601d;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f57601d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar = this.f57603f;
        if (fVar != null) {
            fVar.L();
        }
    }

    public void n(d.a.o0.e2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f57600c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f57601d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f57603f.I0(eVar);
        this.j.l0(eVar);
        this.k.j0(eVar);
        this.f57601d.setData(g(eVar));
    }
}
