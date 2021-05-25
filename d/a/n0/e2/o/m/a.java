package d.a.n0.e2.o.m;

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
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.n0.e2.h.h;
import d.a.n0.e2.h.p;
import d.a.n0.e2.h.q;
import d.a.n0.e2.h.u;
import d.a.n0.e2.k.e.j;
import d.a.n0.e2.k.e.l;
import d.a.n0.e2.k.e.s0;
import d.a.n0.e2.k.e.z;
import d.a.n0.e3.h0.o;
import d.a.n0.t2.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f53785b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.e2.h.e f53786c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f53787d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f53788e;

    /* renamed from: f  reason: collision with root package name */
    public f f53789f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.e2.o.m.d f53790g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f53791h;

    /* renamed from: i  reason: collision with root package name */
    public l f53792i;
    public j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public d.a.c.j.e.a n;
    public d.a.c.j.e.a o;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f53784a = new ArrayList();
    public View.OnClickListener p = new View$OnClickListenerC1282a();
    public View.OnClickListener q = new b();

    /* renamed from: d.a.n0.e2.o.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1282a implements View.OnClickListener {

        /* renamed from: d.a.n0.e2.o.m.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1283a implements FullBrowseHelper.IAcceptPrivacyConfirm {

            /* renamed from: d.a.n0.e2.o.m.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1284a implements Runnable {
                public RunnableC1284a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f53785b.z().F1(3);
                }
            }

            public C1283a() {
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                if (!d.a.c.e.p.j.z()) {
                    a.this.f53785b.U0();
                } else {
                    d.a.c.e.m.e.a().postDelayed(new RunnableC1284a(), 10L);
                }
            }
        }

        public View$OnClickListenerC1282a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f53785b == null || a.this.f53785b.z() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(a.this.f53785b.getPageContext(), new C1283a());
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
            } else if (a.this.f53785b == null || a.this.f53785b.w() == null || a.this.f53785b.w().W2() == null) {
            } else {
                a.this.f53785b.w().W2().onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f0<ShareItem> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.n0.e2.k.e.e1.b.c(a.this.f53785b.getContext(), a.this.h(), ShareSwitch.isOn() ? 1 : 6, a.this.f53785b.z());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.m0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f53798a;

        public d(int i2) {
            this.f53798a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.f53785b.getContext(), this.f53798a, shareItem, false));
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53785b = detailInfoFragment;
        this.f53787d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        if (oVar == null || this.f53786c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().P3 = new d.a.m0.r.q.d();
        if (this.f53786c.w() != null) {
            oVar.getAdvertAppInfo().P3.f49980b = this.f53786c.w().a();
        }
        oVar.getAdvertAppInfo().P3.f49979a = oVar.E0();
        if (this.f53786c.l() != null && (l = this.f53786c.l()) != null) {
            oVar.getAdvertAppInfo().P3.f49982d = l.getId();
            oVar.getAdvertAppInfo().P3.f49983e = l.getFirst_class();
            oVar.getAdvertAppInfo().P3.f49984f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().P3.f49985g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().P3.f49986h = oVar.getAdvertAppInfo().N3;
        oVar.getAdvertAppInfo().P3.f49987i = false;
    }

    public final boolean f(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f53785b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f53785b.A(), true, i2)));
            return false;
        }
        return true;
    }

    public final List<n> g(d.a.n0.e2.h.e eVar) {
        PostData postData;
        o oVar = null;
        if (eVar == null) {
            return null;
        }
        this.f53788e = new ArrayList();
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
            this.f53788e.add(postData);
        }
        if (d.a.m0.c1.b.e.d()) {
            return this.f53788e;
        }
        u uVar = new u();
        a2 L = eVar.L();
        uVar.f52981e = L;
        if (L != null && k.isEmpty(L.i0())) {
            uVar.f52981e.B3(eVar.n());
        }
        this.f53788e.add(uVar);
        p pVar = new p(eVar.L(), eVar.d());
        pVar.f52961f = true;
        this.f53788e.add(pVar);
        if (postData != null && postData.k0 != null && (eVar.l() == null || !TextUtils.equals(eVar.l().getName(), this.f53785b.z().a0()) || !this.f53785b.z().e0())) {
            h hVar = new h(postData.k0);
            hVar.f52935f = this.f53785b.z().O0();
            this.f53788e.add(hVar);
        }
        List<o> V = eVar.V();
        int i2 = 0;
        int i3 = -1;
        if (!d.a.n0.k1.o.k.a.e(V) && (oVar = (o) d.a.n0.k1.o.k.a.d(V, 0)) != null) {
            i3 = oVar.getPosition();
        }
        if (eVar.f() != null) {
            d.a.n0.e2.h.d dVar = new d.a.n0.e2.h.d();
            dVar.h(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.f53788e.add(dVar);
            if (TbSingleton.getInstance().isBrowseMode()) {
                this.f53788e.add(new q());
            } else {
                int i4 = 1;
                for (d.a.m0.r.q.p pVar2 : eVar.f()) {
                    if (V != null && i4 == i3) {
                        if (oVar != null) {
                            e(oVar);
                            d.a.n0.k1.o.k.a.a(this.f53788e, oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.b4) {
                                i4++;
                            }
                        }
                        if (i2 < V.size() && (oVar = (o) d.a.n0.k1.o.k.a.d(V, i2)) != null) {
                            i3 = oVar.getPosition();
                        }
                    }
                    d.a.n0.k1.o.k.a.a(this.f53788e, pVar2);
                    i4++;
                    if (i4 == 4 && eVar.A() != null) {
                        d.a.n0.k1.o.k.a.a(this.f53788e, eVar.A());
                        i4++;
                    }
                }
            }
        }
        return this.f53788e;
    }

    public final int h() {
        d.a.n0.e2.h.e eVar = this.f53786c;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f53786c.L().G();
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
        this.n = x.p().a(detailInfoFragment.w().getBaseFragmentActivity(), AdvertAppInfo.b4);
        this.o = x.p().a(detailInfoFragment.w().getBaseFragmentActivity(), AdvertAppInfo.d4);
        this.f53784a.add(this.n);
        this.f53784a.add(this.o);
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53789f = new f(detailInfoFragment.w(), PostData.o0);
        this.f53790g = new d.a.n0.e2.o.m.d(detailInfoFragment.getContext(), u.f52980f);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.w(), p.j);
        this.f53791h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
        this.f53792i = new l(detailInfoFragment.w(), d.a.n0.e2.h.d.f52916g);
        j jVar = new j(detailInfoFragment.w(), d.a.m0.r.q.p.K3);
        this.j = jVar;
        jVar.n0(true);
        this.k = new z(detailInfoFragment.w());
        this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), h.f52933g);
        s0 s0Var = new s0(detailInfoFragment.w(), q.f52965e);
        this.m = s0Var;
        s0Var.i0(this.p);
        this.f53784a.add(this.f53789f);
        this.f53784a.add(this.f53790g);
        this.f53784a.add(this.f53791h);
        this.f53784a.add(this.f53792i);
        this.f53784a.add(this.j);
        this.f53784a.add(this.k);
        this.f53784a.add(this.l);
        this.f53784a.add(this.m);
        j(detailInfoFragment);
        bdTypeRecyclerView.a(this.f53784a);
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53787d;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f53787d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar = this.f53789f;
        if (fVar != null) {
            fVar.K();
        }
    }

    public void n(d.a.n0.e2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f53786c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f53787d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f53789f.H0(eVar);
        this.j.m0(eVar);
        this.k.i0(eVar);
        this.f53787d.setData(g(eVar));
    }
}
