package d.b.i0.c2.o.f;

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
import d.b.b.e.p.k;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.i0.c2.h.p;
import d.b.i0.c2.h.t;
import d.b.i0.c2.k.e.h;
import d.b.i0.c2.k.e.j;
import d.b.i0.c2.k.e.x;
import d.b.i0.c3.h0.o;
import d.b.i0.r2.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f53199b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.c2.h.e f53200c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f53201d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f53202e;

    /* renamed from: f  reason: collision with root package name */
    public f f53203f;

    /* renamed from: g  reason: collision with root package name */
    public d f53204g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f53205h;
    public j i;
    public h j;
    public x k;
    public PbFirstFloorItemAdapter l;
    public d.b.b.j.e.a m;
    public d.b.b.j.e.a n;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f53198a = new ArrayList();
    public View.OnClickListener o = new View$OnClickListenerC1172a();

    /* renamed from: d.b.i0.c2.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1172a implements View.OnClickListener {
        public View$OnClickListenerC1172a() {
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
            } else if (a.this.f53199b == null || a.this.f53199b.I() == null || a.this.f53199b.I().T2() == null) {
            } else {
                a.this.f53199b.I().T2().onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends f0<ShareItem> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.b.i0.c2.k.e.b1.b.c(a.this.f53199b.getContext(), a.this.h(), ShareSwitch.isOn() ? 1 : 6, a.this.f53199b.L());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.b.h0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f53208a;

        public c(int i) {
            this.f53208a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.f53199b.getContext(), this.f53208a, shareItem, false));
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53199b = detailInfoFragment;
        this.f53201d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        if (oVar == null || this.f53200c == null || oVar.B0() == null) {
            return;
        }
        oVar.B0().advertAppContext = new d.b.h0.r.q.d();
        if (this.f53200c.w() != null) {
            oVar.B0().advertAppContext.f50749b = this.f53200c.w().a();
        }
        oVar.B0().advertAppContext.f50748a = oVar.C0();
        if (this.f53200c.l() != null && (l = this.f53200c.l()) != null) {
            oVar.B0().advertAppContext.f50751d = l.getId();
            oVar.B0().advertAppContext.f50752e = l.getFirst_class();
            oVar.B0().advertAppContext.f50753f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.B0().advertAppContext.f50754g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.B0().advertAppContext.f50755h = oVar.B0().ext_info;
        oVar.B0().advertAppContext.i = false;
    }

    public final boolean f(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f53199b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f53199b.P(), true, i)));
            return false;
        }
        return true;
    }

    public final List<n> g(d.b.i0.c2.h.e eVar) {
        PostData postData;
        o oVar = null;
        if (eVar == null) {
            return null;
        }
        this.f53202e = new ArrayList();
        Iterator<PostData> it = eVar.D().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.z() == 1) {
                    break;
                }
            }
        }
        if (postData == null && eVar.j() != null) {
            postData = eVar.j();
        }
        if (postData != null) {
            this.f53202e.add(postData);
        }
        t tVar = new t();
        a2 L = eVar.L();
        tVar.f52475e = L;
        if (L != null && k.isEmpty(L.i0())) {
            tVar.f52475e.x3(eVar.n());
        }
        this.f53202e.add(tVar);
        p pVar = new p(eVar.L(), eVar.d());
        pVar.f52458f = true;
        this.f53202e.add(pVar);
        if (postData != null && postData.k0 != null && (eVar.l() == null || !TextUtils.equals(eVar.l().getName(), this.f53199b.L().a0()) || !this.f53199b.L().e0())) {
            d.b.i0.c2.h.h hVar = new d.b.i0.c2.h.h(postData.k0);
            hVar.f52433f = this.f53199b.L().O0();
            this.f53202e.add(hVar);
        }
        List<o> U = eVar.U();
        int i = 0;
        int i2 = -1;
        if (!d.b.i0.i1.o.k.a.e(U) && (oVar = (o) d.b.i0.i1.o.k.a.d(U, 0)) != null) {
            i2 = oVar.getPosition();
        }
        if (eVar.f() != null) {
            d.b.i0.c2.h.d dVar = new d.b.i0.c2.h.d();
            dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.f53202e.add(dVar);
            int i3 = 1;
            for (d.b.h0.r.q.p pVar2 : eVar.f()) {
                if (U != null && i3 == i2) {
                    if (oVar != null) {
                        e(oVar);
                        d.b.i0.i1.o.k.a.a(this.f53202e, oVar);
                        i++;
                        if (oVar.getType() != AdvertAppInfo.i4) {
                            i3++;
                        }
                    }
                    if (i < U.size() && (oVar = (o) d.b.i0.i1.o.k.a.d(U, i)) != null) {
                        i2 = oVar.getPosition();
                    }
                }
                d.b.i0.i1.o.k.a.a(this.f53202e, pVar2);
                i3++;
                if (i3 == 4 && eVar.A() != null) {
                    d.b.i0.i1.o.k.a.a(this.f53202e, eVar.A());
                    i3++;
                }
            }
        }
        return this.f53202e;
    }

    public final int h() {
        d.b.i0.c2.h.e eVar = this.f53200c;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f53200c.L().G();
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
        this.m = s.o().a(detailInfoFragment.I().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.n = s.o().a(detailInfoFragment.I().getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.f53198a.add(this.m);
        this.f53198a.add(this.n);
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53203f = new f(detailInfoFragment.I(), PostData.n0);
        this.f53204g = new d(detailInfoFragment.getContext(), t.f52474f);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.I(), p.j);
        this.f53205h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.o);
        this.i = new j(detailInfoFragment.I(), d.b.i0.c2.h.d.f52416g);
        h hVar = new h(detailInfoFragment.I(), d.b.h0.r.q.p.I3);
        this.j = hVar;
        hVar.p0(true);
        this.k = new x(detailInfoFragment.I());
        this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), d.b.i0.c2.h.h.f52431g);
        this.f53198a.add(this.f53203f);
        this.f53198a.add(this.f53204g);
        this.f53198a.add(this.f53205h);
        this.f53198a.add(this.i);
        this.f53198a.add(this.j);
        this.f53198a.add(this.k);
        this.f53198a.add(this.l);
        j(detailInfoFragment);
        bdTypeRecyclerView.a(this.f53198a);
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53201d;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f53201d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar = this.f53203f;
        if (fVar != null) {
            fVar.L();
        }
    }

    public void n(d.b.i0.c2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f53200c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f53201d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f53203f.H0(eVar);
        this.j.o0(eVar);
        this.k.m0(eVar);
        this.f53201d.setData(g(eVar));
    }
}
