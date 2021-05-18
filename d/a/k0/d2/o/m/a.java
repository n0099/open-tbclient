package d.a.k0.d2.o.m;

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
import d.a.j0.r.q.a2;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.k0.d2.h.h;
import d.a.k0.d2.h.p;
import d.a.k0.d2.h.t;
import d.a.k0.d2.k.e.j;
import d.a.k0.d2.k.e.l;
import d.a.k0.d2.k.e.z;
import d.a.k0.d3.h0.o;
import d.a.k0.s2.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f53575b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.d2.h.e f53576c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f53577d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f53578e;

    /* renamed from: f  reason: collision with root package name */
    public f f53579f;

    /* renamed from: g  reason: collision with root package name */
    public d f53580g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f53581h;

    /* renamed from: i  reason: collision with root package name */
    public l f53582i;
    public j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public d.a.c.j.e.a m;
    public d.a.c.j.e.a n;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f53574a = new ArrayList();
    public View.OnClickListener o = new View$OnClickListenerC1264a();

    /* renamed from: d.a.k0.d2.o.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1264a implements View.OnClickListener {
        public View$OnClickListenerC1264a() {
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
            } else if (a.this.f53575b == null || a.this.f53575b.w() == null || a.this.f53575b.w().U2() == null) {
            } else {
                a.this.f53575b.w().U2().onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends f0<ShareItem> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.k0.d2.k.e.d1.b.c(a.this.f53575b.getContext(), a.this.h(), ShareSwitch.isOn() ? 1 : 6, a.this.f53575b.z());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.a.j0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f53585a;

        public c(int i2) {
            this.f53585a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.f53575b.getContext(), this.f53585a, shareItem, false));
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53575b = detailInfoFragment;
        this.f53577d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData l;
        if (oVar == null || this.f53576c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().O3 = new d.a.j0.r.q.d();
        if (this.f53576c.w() != null) {
            oVar.getAdvertAppInfo().O3.f49936b = this.f53576c.w().a();
        }
        oVar.getAdvertAppInfo().O3.f49935a = oVar.E0();
        if (this.f53576c.l() != null && (l = this.f53576c.l()) != null) {
            oVar.getAdvertAppInfo().O3.f49938d = l.getId();
            oVar.getAdvertAppInfo().O3.f49939e = l.getFirst_class();
            oVar.getAdvertAppInfo().O3.f49940f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().O3.f49941g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().O3.f49942h = oVar.getAdvertAppInfo().M3;
        oVar.getAdvertAppInfo().O3.f49943i = false;
    }

    public final boolean f(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f53575b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f53575b.A(), true, i2)));
            return false;
        }
        return true;
    }

    public final List<n> g(d.a.k0.d2.h.e eVar) {
        PostData postData;
        o oVar = null;
        if (eVar == null) {
            return null;
        }
        this.f53578e = new ArrayList();
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
            this.f53578e.add(postData);
        }
        t tVar = new t();
        a2 L = eVar.L();
        tVar.f52775e = L;
        if (L != null && k.isEmpty(L.i0())) {
            tVar.f52775e.A3(eVar.n());
        }
        this.f53578e.add(tVar);
        p pVar = new p(eVar.L(), eVar.d());
        pVar.f52756f = true;
        this.f53578e.add(pVar);
        if (postData != null && postData.k0 != null && (eVar.l() == null || !TextUtils.equals(eVar.l().getName(), this.f53575b.z().a0()) || !this.f53575b.z().e0())) {
            h hVar = new h(postData.k0);
            hVar.f52730f = this.f53575b.z().O0();
            this.f53578e.add(hVar);
        }
        List<o> V = eVar.V();
        int i2 = 0;
        int i3 = -1;
        if (!d.a.k0.j1.o.k.a.e(V) && (oVar = (o) d.a.k0.j1.o.k.a.d(V, 0)) != null) {
            i3 = oVar.getPosition();
        }
        if (eVar.f() != null) {
            d.a.k0.d2.h.d dVar = new d.a.k0.d2.h.d();
            dVar.h(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.f53578e.add(dVar);
            int i4 = 1;
            for (d.a.j0.r.q.p pVar2 : eVar.f()) {
                if (V != null && i4 == i3) {
                    if (oVar != null) {
                        e(oVar);
                        d.a.k0.j1.o.k.a.a(this.f53578e, oVar);
                        i2++;
                        if (oVar.getType() != AdvertAppInfo.a4) {
                            i4++;
                        }
                    }
                    if (i2 < V.size() && (oVar = (o) d.a.k0.j1.o.k.a.d(V, i2)) != null) {
                        i3 = oVar.getPosition();
                    }
                }
                d.a.k0.j1.o.k.a.a(this.f53578e, pVar2);
                i4++;
                if (i4 == 4 && eVar.A() != null) {
                    d.a.k0.j1.o.k.a.a(this.f53578e, eVar.A());
                    i4++;
                }
            }
        }
        return this.f53578e;
    }

    public final int h() {
        d.a.k0.d2.h.e eVar = this.f53576c;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f53576c.L().G();
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
        this.m = x.p().a(detailInfoFragment.w().getBaseFragmentActivity(), AdvertAppInfo.a4);
        this.n = x.p().a(detailInfoFragment.w().getBaseFragmentActivity(), AdvertAppInfo.c4);
        this.f53574a.add(this.m);
        this.f53574a.add(this.n);
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53579f = new f(detailInfoFragment.w(), PostData.o0);
        this.f53580g = new d(detailInfoFragment.getContext(), t.f52774f);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.w(), p.j);
        this.f53581h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.o);
        this.f53582i = new l(detailInfoFragment.w(), d.a.k0.d2.h.d.f52711g);
        j jVar = new j(detailInfoFragment.w(), d.a.j0.r.q.p.J3);
        this.j = jVar;
        jVar.n0(true);
        this.k = new z(detailInfoFragment.w());
        this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), h.f52728g);
        this.f53574a.add(this.f53579f);
        this.f53574a.add(this.f53580g);
        this.f53574a.add(this.f53581h);
        this.f53574a.add(this.f53582i);
        this.f53574a.add(this.j);
        this.f53574a.add(this.k);
        this.f53574a.add(this.l);
        j(detailInfoFragment);
        bdTypeRecyclerView.a(this.f53574a);
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53577d;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f53577d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar = this.f53579f;
        if (fVar != null) {
            fVar.K();
        }
    }

    public void n(d.a.k0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f53576c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f53577d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f53579f.H0(eVar);
        this.j.m0(eVar);
        this.k.i0(eVar);
        this.f53577d.setData(g(eVar));
    }
}
