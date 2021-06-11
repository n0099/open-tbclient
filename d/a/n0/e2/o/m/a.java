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
import d.a.c.k.e.n;
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
    public DetailInfoFragment f57474b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.e2.h.e f57475c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f57476d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f57477e;

    /* renamed from: f  reason: collision with root package name */
    public f f57478f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.e2.o.m.d f57479g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f57480h;

    /* renamed from: i  reason: collision with root package name */
    public l f57481i;
    public j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public d.a.c.k.e.a n;
    public d.a.c.k.e.a o;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f57473a = new ArrayList();
    public View.OnClickListener p = new View$OnClickListenerC1338a();
    public View.OnClickListener q = new b();

    /* renamed from: d.a.n0.e2.o.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1338a implements View.OnClickListener {

        /* renamed from: d.a.n0.e2.o.m.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1339a implements FullBrowseHelper.IAcceptPrivacyConfirm {

            /* renamed from: d.a.n0.e2.o.m.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1340a implements Runnable {
                public RunnableC1340a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f57474b.A().I1(3);
                }
            }

            public C1339a() {
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                if (!d.a.c.e.p.j.z()) {
                    a.this.f57474b.X0();
                } else {
                    d.a.c.e.m.e.a().postDelayed(new RunnableC1340a(), 10L);
                }
            }
        }

        public View$OnClickListenerC1338a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57474b == null || a.this.f57474b.A() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(a.this.f57474b.getPageContext(), new C1339a());
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
            } else if (a.this.f57474b == null || a.this.f57474b.x() == null || a.this.f57474b.x().Z2() == null) {
            } else {
                a.this.f57474b.x().Z2().onClick(view);
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
            return d.a.n0.e2.k.e.e1.b.c(a.this.f57474b.getContext(), a.this.h(), ShareSwitch.isOn() ? 1 : 6, a.this.f57474b.A());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.m0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f57487a;

        public d(int i2) {
            this.f57487a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.f57474b.getContext(), this.f57487a, shareItem, false));
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57474b = detailInfoFragment;
        this.f57476d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        if (oVar == null || this.f57475c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().S3 = new d.a.m0.r.q.d();
        if (this.f57475c.w() != null) {
            oVar.getAdvertAppInfo().S3.f53656b = this.f57475c.w().a();
        }
        oVar.getAdvertAppInfo().S3.f53655a = oVar.E0();
        if (this.f57475c.l() != null && (l = this.f57475c.l()) != null) {
            oVar.getAdvertAppInfo().S3.f53658d = l.getId();
            oVar.getAdvertAppInfo().S3.f53659e = l.getFirst_class();
            oVar.getAdvertAppInfo().S3.f53660f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().S3.f53661g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().S3.f53662h = oVar.getAdvertAppInfo().Q3;
        oVar.getAdvertAppInfo().S3.f53663i = false;
    }

    public final boolean f(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f57474b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f57474b.B(), true, i2)));
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
        this.f57477e = new ArrayList();
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
            this.f57477e.add(postData);
        }
        if (d.a.m0.c1.b.e.d()) {
            return this.f57477e;
        }
        u uVar = new u();
        a2 L = eVar.L();
        uVar.f56670e = L;
        if (L != null && k.isEmpty(L.i0())) {
            uVar.f56670e.C3(eVar.n());
        }
        this.f57477e.add(uVar);
        p pVar = new p(eVar.L(), eVar.d());
        pVar.f56650f = true;
        this.f57477e.add(pVar);
        if (postData != null && postData.k0 != null && (eVar.l() == null || !TextUtils.equals(eVar.l().getName(), this.f57474b.A().e0()) || !this.f57474b.A().i0())) {
            h hVar = new h(postData.k0);
            hVar.f56624f = this.f57474b.A().S0();
            this.f57477e.add(hVar);
        }
        List<o> V = eVar.V();
        int i2 = 0;
        int i3 = -1;
        if (!d.a.n0.k1.o.k.a.e(V) && (oVar = (o) d.a.n0.k1.o.k.a.d(V, 0)) != null) {
            i3 = oVar.getPosition();
        }
        if (eVar.f() != null) {
            d.a.n0.e2.h.d dVar = new d.a.n0.e2.h.d();
            dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.f57477e.add(dVar);
            if (TbSingleton.getInstance().isBrowseMode()) {
                this.f57477e.add(new q());
            } else {
                int i4 = 1;
                for (d.a.m0.r.q.p pVar2 : eVar.f()) {
                    if (V != null && i4 == i3) {
                        if (oVar != null) {
                            e(oVar);
                            d.a.n0.k1.o.k.a.a(this.f57477e, oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.e4) {
                                i4++;
                            }
                        }
                        if (i2 < V.size() && (oVar = (o) d.a.n0.k1.o.k.a.d(V, i2)) != null) {
                            i3 = oVar.getPosition();
                        }
                    }
                    d.a.n0.k1.o.k.a.a(this.f57477e, pVar2);
                    i4++;
                    if (i4 == 4 && eVar.A() != null) {
                        d.a.n0.k1.o.k.a.a(this.f57477e, eVar.A());
                        i4++;
                    }
                }
            }
        }
        return this.f57477e;
    }

    public final int h() {
        d.a.n0.e2.h.e eVar = this.f57475c;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f57475c.L().G();
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
        this.f57473a.add(this.n);
        this.f57473a.add(this.o);
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57478f = new f(detailInfoFragment.x(), PostData.o0);
        this.f57479g = new d.a.n0.e2.o.m.d(detailInfoFragment.getContext(), u.f56669f);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.x(), p.j);
        this.f57480h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
        this.f57481i = new l(detailInfoFragment.x(), d.a.n0.e2.h.d.f56605g);
        j jVar = new j(detailInfoFragment.x(), d.a.m0.r.q.p.N3);
        this.j = jVar;
        jVar.m0(true);
        this.k = new z(detailInfoFragment.x());
        this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), h.f56622g);
        s0 s0Var = new s0(detailInfoFragment.x(), q.f56654e);
        this.m = s0Var;
        s0Var.j0(this.p);
        this.f57473a.add(this.f57478f);
        this.f57473a.add(this.f57479g);
        this.f57473a.add(this.f57480h);
        this.f57473a.add(this.f57481i);
        this.f57473a.add(this.j);
        this.f57473a.add(this.k);
        this.f57473a.add(this.l);
        this.f57473a.add(this.m);
        j(detailInfoFragment);
        bdTypeRecyclerView.a(this.f57473a);
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57476d;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f57476d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar = this.f57478f;
        if (fVar != null) {
            fVar.L();
        }
    }

    public void n(d.a.n0.e2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f57475c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f57476d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f57478f.I0(eVar);
        this.j.l0(eVar);
        this.k.j0(eVar);
        this.f57476d.setData(g(eVar));
    }
}
