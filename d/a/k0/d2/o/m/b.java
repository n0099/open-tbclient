package d.a.k0.d2.o.m;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.k0.d2.h.g;
import d.a.k0.d2.h.h;
import d.a.k0.d2.h.p;
import d.a.k0.d2.h.u;
import d.a.k0.d2.k.e.b0;
import d.a.k0.d2.k.e.j;
import d.a.k0.d2.k.e.j0;
import d.a.k0.d2.k.e.l;
import d.a.k0.d2.k.e.m;
import d.a.k0.d2.k.e.n0;
import d.a.k0.d2.k.e.z;
import d.a.k0.d3.h0.o;
import d.a.k0.s2.t;
import d.a.k0.s2.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b extends d.a.k0.d2.o.o.a {
    public SortSwitchButton.f H;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f53588b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53589c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.d2.h.e f53590d;

    /* renamed from: f  reason: collision with root package name */
    public m f53592f;

    /* renamed from: g  reason: collision with root package name */
    public f f53593g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f53594h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.d2.o.m.c f53595i;
    public PbFirstFloorEnterForumAdapter j;
    public n0 k;
    public PbReplyLoadMoreAdapter l;
    public j0 m;
    public b0 n;
    public l o;
    public j p;
    public z q;
    public e r;
    public PbFirstFloorItemAdapter s;
    public d.a.c.j.e.a t;
    public d.a.c.j.e.a u;
    public ArrayList<n> w;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f53587a = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f53591e = new ArrayList();
    public boolean v = true;
    public String x = null;
    public boolean y = true;
    public boolean z = false;
    public int A = -1;
    public int B = -1;
    public View.OnClickListener C = null;
    public View.OnClickListener D = null;
    public TbRichTextView.x E = null;
    public d.a.k0.d2.i.c F = null;
    public View.OnLongClickListener G = null;
    public View.OnClickListener I = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.qq_share_container) {
                if (b.this.g(11009)) {
                    b.this.o(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.g(11009)) {
                b.this.o(3);
            }
        }
    }

    /* renamed from: d.a.k0.d2.o.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1265b extends f0<ShareItem> {
        public C1265b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.k0.d2.k.e.d1.b.c(b.this.f53588b.getContext(), b.this.h(), ShareSwitch.isOn() ? 1 : 6, b.this.f53588b.z());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.a.j0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f53598a;

        public c(int i2) {
            this.f53598a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.f53588b.getContext(), this.f53598a, shareItem, false));
        }
    }

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53588b = detailInfoAndReplyFragment;
        this.f53589c = bdTypeRecyclerView;
        p();
    }

    public void A(View.OnLongClickListener onLongClickListener) {
        this.G = onLongClickListener;
    }

    public void B(SortSwitchButton.f fVar) {
        this.H = fVar;
    }

    public void C(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void D(d.a.k0.d2.i.c cVar) {
        this.F = cVar;
    }

    public final void E() {
        o oVar;
        o oVar2;
        d.a.k0.d2.h.e eVar = this.f53590d;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f53590d.e();
        if (e2 == null || e2.isEmpty() || D == null || D.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.D0() != null) {
                sb.append(next.D0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<o> it2 = e2.iterator();
        while (it2.hasNext()) {
            o next2 = it2.next();
            if (next2 != null) {
                next2.K0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int G4 = next3.getAdvertAppInfo().G4();
                if (G4 != 0) {
                    d.a.k0.s2.i0.d.i(next3, G4);
                    if (G4 != 28 && G4 != 31) {
                        next3.getAdvertAppInfo().H3 = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + G4);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.k0.s2.i0.d.i(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
            if (this.f53590d.l() != null) {
                oVar4.z0 = this.f53590d.l().getId();
            }
            if (this.f53590d.L() != null) {
                oVar4.C0 = d.a.c.e.m.b.f(this.f53590d.L().o0(), 0L);
            }
            d.a.k0.d2.h.e eVar2 = this.f53590d;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.D0 = this.f53590d.w().a();
            }
            f(oVar4);
            int position = oVar4.getPosition() + this.f53590d.X;
            if (position >= D.size()) {
                oVar4.K0 = position;
                d.a.k0.s2.i0.d.j(oVar4, 2, position + i4, D.size());
                return;
            }
            if (!this.v) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.k0.s2.i0.d.i(oVar4, 23);
            } else if (n(D, position)) {
                d.a.k0.s2.i0.d.i(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f53588b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().X3);
            }
        }
    }

    @Override // d.a.k0.d2.o.o.a
    public ArrayList<n> a() {
        return this.w;
    }

    public final void f(o oVar) {
        ForumData l;
        if (oVar == null || this.f53590d == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().O3 = new d.a.j0.r.q.d();
        if (this.f53590d.w() != null) {
            oVar.getAdvertAppInfo().O3.f49936b = this.f53590d.w().a();
        }
        oVar.getAdvertAppInfo().O3.f49935a = oVar.E0();
        if (this.f53590d.l() != null && (l = this.f53590d.l()) != null) {
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

    public final boolean g(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f53588b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f53588b.A(), true, i2)));
            return false;
        }
        return true;
    }

    public final int h() {
        d.a.k0.d2.h.e eVar = this.f53590d;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f53590d.L().G();
    }

    public int i() {
        return this.B;
    }

    public int j() {
        return this.A;
    }

    public n0 k() {
        return this.k;
    }

    public m l() {
        return this.f53592f;
    }

    public PbFirstFloorCommentAndPraiseAdapter m() {
        return this.f53594h;
    }

    public final boolean n(ArrayList<PostData> arrayList, int i2) {
        for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
            if (arrayList.get(max) instanceof o) {
                return true;
            }
        }
        return false;
    }

    public final void o(int i2) {
        h0.b(new C1265b(), new c(i2));
        StatisticItem statisticItem = new StatisticItem("c13833");
        statisticItem.param("obj_locate", 1);
        if (i2 == 3) {
            statisticItem.param("obj_type", 1);
        } else if (i2 == 8) {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void p() {
        this.f53593g = new f(this.f53588b.w(), PostData.o0);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f53588b.w(), p.j);
        this.f53594h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.I);
        this.f53595i = new d.a.k0.d2.o.m.c(this.f53588b.getContext(), u.f52776f);
        this.j = new PbFirstFloorEnterForumAdapter(this.f53588b.getContext(), g.l);
        this.k = new n0(this.f53588b.w(), d.a.k0.d2.h.o.l);
        this.n = new b0(this.f53588b.w(), d.a.k0.d2.h.j.f52733f, this.f53588b.getUniqueId());
        this.m = new j0(this.f53588b.w(), d.a.k0.d2.h.l.D0);
        this.o = new l(this.f53588b.w(), d.a.k0.d2.h.d.f52711g);
        j jVar = new j(this.f53588b.w(), d.a.j0.r.q.p.J3);
        this.p = jVar;
        jVar.n0(true);
        this.q = new z(this.f53588b.w());
        m mVar = new m(this.f53588b.w(), PostData.p0);
        this.f53592f = mVar;
        mVar.Y0(this.f53588b.w());
        this.l = new PbReplyLoadMoreAdapter(this.f53588b.w(), PostData.v0);
        this.t = x.p().a(this.f53588b.w().getBaseFragmentActivity(), AdvertAppInfo.a4);
        this.u = x.p().a(this.f53588b.w().getBaseFragmentActivity(), AdvertAppInfo.c4);
        e eVar = new e(this.f53588b.getPageContext(), a2.Z2, this.f53588b.getUniqueId());
        this.r = eVar;
        eVar.g0(this.f53589c);
        this.s = new PbFirstFloorItemAdapter(this.f53588b.getContext(), h.f52728g);
        this.f53591e.add(this.f53593g);
        this.f53591e.add(this.f53594h);
        this.f53591e.add(this.f53595i);
        this.f53591e.add(this.j);
        this.f53591e.add(this.k);
        this.f53591e.add(this.m);
        this.f53591e.add(this.n);
        this.f53591e.add(this.o);
        this.f53591e.add(this.p);
        this.f53591e.add(this.q);
        this.f53591e.add(this.t);
        this.f53591e.add(this.u);
        this.f53591e.add(this.f53592f);
        this.f53591e.add(this.l);
        this.f53591e.add(this.r);
        this.f53591e.add(this.s);
        this.f53591e.add(new PbPrivateTitleAdapter(this.f53588b.w()));
        this.f53589c.a(this.f53591e);
    }

    public boolean q() {
        if (this.f53588b.z() != null) {
            return this.f53588b.z().d0();
        }
        return false;
    }

    public void r() {
        if (this.f53589c.getAdapter() instanceof BdRecyclerAdapter) {
            this.f53589c.getAdapter().notifyDataSetChanged();
        }
    }

    public void s() {
        n0 n0Var = this.k;
        if (n0Var != null) {
            n0Var.onDestroy();
        }
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f53594h;
        if (pbFirstFloorCommentAndPraiseAdapter != null) {
            pbFirstFloorCommentAndPraiseAdapter.onDestroy();
        }
    }

    public final void t() {
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            n nVar = this.w.get(i2);
            if (nVar instanceof d.a.k0.d2.h.o) {
                this.A = i2;
                z = true;
            } else if ((nVar instanceof d.a.k0.d2.h.d) && ((d.a.k0.d2.h.d) nVar).c() == this.f53587a) {
                this.B = i2;
                z2 = true;
            }
        }
        if (!z) {
            this.A = -1;
        }
        if (z2) {
            return;
        }
        this.B = -1;
    }

    public void u(d.a.k0.d2.h.e eVar) {
        v(eVar, false);
    }

    public void v(d.a.k0.d2.h.e eVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        if (eVar == null) {
            return;
        }
        this.f53590d = eVar;
        if (eVar != null && eVar.L() != null && eVar.L().T() != null) {
            this.x = eVar.L().T().getUserId();
        }
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.clear();
        Iterator<PostData> it = eVar.D().iterator();
        while (true) {
            oVar = null;
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
            this.w.add(postData);
        }
        this.f53593g.H0(eVar);
        this.f53593g.p(this.x);
        int i2 = 0;
        if (!ListUtils.isEmpty(eVar.D()) && eVar.D().get(0) != null && eVar.L() != null) {
            eVar.L().P3(eVar.D().get(0).F());
            eVar.L().R3(eVar.D().get(0).G());
        }
        if (eVar.L() != null && eVar.L().T0() != null) {
            z1 z1Var = new z1();
            z1Var.w = eVar.L();
            z1Var.r = true;
            this.w.add(z1Var);
        }
        p pVar = new p(eVar.L(), eVar.d());
        pVar.l(false);
        pVar.f52756f = false;
        this.w.add(pVar);
        if (postData == null || postData.k0 == null || (eVar.l() != null && TextUtils.equals(eVar.l().getName(), this.f53588b.z().a0()) && this.f53588b.z().e0())) {
            z2 = false;
        } else {
            h hVar = new h(postData.k0);
            hVar.f52730f = this.f53588b.z().O0();
            this.w.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.l() != null && !StringUtils.isNull(eVar.l().getName()) && (!TextUtils.equals(eVar.l().getName(), this.f53588b.z().a0()) || !this.f53588b.z().e0())) {
            g gVar = new g(eVar.l());
            gVar.k = this.f53588b.z().O0();
            gVar.f52727i = false;
            this.w.add(gVar);
            pVar.l(false);
            pVar.f52756f = false;
        }
        d.a.k0.d2.h.o oVar2 = new d.a.k0.d2.h.o(d.a.k0.d2.h.o.l);
        a2 L = eVar.L();
        if (L != null) {
            L.Z0();
        }
        this.f53588b.z().M0();
        oVar2.f52753h = q();
        oVar2.f52752g = eVar.f52720g;
        eVar.c();
        oVar2.f52754i = eVar.a0();
        oVar2.k = eVar.f52719f;
        this.k.s(eVar);
        this.w.add(oVar2);
        if (eVar.I() == 4) {
            this.w.add(new d.a.k0.d2.h.n());
        }
        E();
        d.a.c.j.e.a aVar = this.u;
        if (aVar != null && (aVar instanceof t)) {
            ((t) aVar).j(this.z);
        }
        Iterator<PostData> it2 = eVar.D().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.w.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !d.a.c.e.p.j.z())) {
            d.a.k0.d2.h.l lVar = new d.a.k0.d2.h.l();
            lVar.y0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.x0 = R.drawable.new_pic_emotion_03;
            lVar.z0 = -2;
            lVar.A0 = d.a.c.e.p.l.g(this.f53588b.getContext(), R.dimen.tbds74);
            this.w.add(lVar);
        }
        this.f53592f.s(eVar);
        this.f53592f.setFromCDN(this.z);
        this.f53592f.p(this.x);
        this.f53592f.c(this.y);
        this.f53592f.e(this.D);
        this.f53592f.l(this.C);
        this.f53592f.o(this.E);
        this.f53592f.d(this.G);
        this.f53592f.X0(this.F);
        this.k.e(this.D);
        this.k.m0(this.H);
        this.l.i0(this.D);
        if (eVar.w().b() == 0) {
            if (z3) {
                this.n.i0(this.f53588b.w().U2());
                d.a.k0.d2.h.j jVar = new d.a.k0.d2.h.j();
                jVar.f52734e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.w.add(jVar);
            }
            List<o> V = eVar.V();
            int i3 = -1;
            if (V != null && !V.isEmpty()) {
                oVar = V.get(0);
                i3 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                d.a.k0.d2.h.d dVar = new d.a.k0.d2.h.d();
                dVar.h(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.f(this.f53587a);
                this.w.add(dVar);
                int i4 = 1;
                for (d.a.j0.r.q.p pVar2 : eVar.f()) {
                    if (V != null && i4 == i3) {
                        if (oVar != null) {
                            f(oVar);
                            this.w.add(oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.a4) {
                                i4++;
                            }
                        }
                        if (i2 < V.size()) {
                            o oVar3 = V.get(i2);
                            oVar = oVar3;
                            i3 = oVar3.getPosition();
                        }
                    }
                    this.w.add(pVar2);
                    i4++;
                    if (i4 == 4 && eVar.A() != null) {
                        this.w.add(eVar.A());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f53589c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.w);
        }
        t();
    }

    public void w(boolean z) {
        this.z = z;
    }

    public void x(boolean z) {
        this.v = z;
    }

    public void y(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public void z(TbRichTextView.x xVar) {
        this.E = xVar;
    }
}
