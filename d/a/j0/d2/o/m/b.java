package d.a.j0.d2.o.m;

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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.j0.d2.h.g;
import d.a.j0.d2.h.h;
import d.a.j0.d2.h.p;
import d.a.j0.d2.h.u;
import d.a.j0.d2.k.e.b0;
import d.a.j0.d2.k.e.j;
import d.a.j0.d2.k.e.j0;
import d.a.j0.d2.k.e.l;
import d.a.j0.d2.k.e.m;
import d.a.j0.d2.k.e.n0;
import d.a.j0.d2.k.e.z;
import d.a.j0.d3.h0.o;
import d.a.j0.s2.s;
import d.a.j0.s2.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends d.a.j0.d2.o.o.a {
    public SortSwitchButton.f H;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f52885b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f52886c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.d2.h.e f52887d;

    /* renamed from: f  reason: collision with root package name */
    public m f52889f;

    /* renamed from: g  reason: collision with root package name */
    public f f52890g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f52891h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.d2.o.m.c f52892i;
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
    public final BdUniqueId f52884a = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f52888e = new ArrayList();
    public boolean v = true;
    public String x = null;
    public boolean y = true;
    public boolean z = false;
    public int A = -1;
    public int B = -1;
    public View.OnClickListener C = null;
    public View.OnClickListener D = null;
    public TbRichTextView.x E = null;
    public d.a.j0.d2.i.c F = null;
    public View.OnLongClickListener G = null;
    public View.OnClickListener I = new a();

    /* loaded from: classes3.dex */
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

    /* renamed from: d.a.j0.d2.o.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1193b extends f0<ShareItem> {
        public C1193b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.a.j0.d2.k.e.d1.b.c(b.this.f52885b.getContext(), b.this.h(), ShareSwitch.isOn() ? 1 : 6, b.this.f52885b.z());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52895a;

        public c(int i2) {
            this.f52895a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.f52885b.getContext(), this.f52895a, shareItem, false));
        }
    }

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52885b = detailInfoAndReplyFragment;
        this.f52886c = bdTypeRecyclerView;
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

    public void D(d.a.j0.d2.i.c cVar) {
        this.F = cVar;
    }

    public final void E() {
        o oVar;
        o oVar2;
        d.a.j0.d2.h.e eVar = this.f52887d;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f52887d.e();
        if (e2 == null || e2.isEmpty() || D == null || D.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.C0() != null) {
                sb.append(next.C0());
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
                next2.A0 = sb.toString();
                next2.M0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.D0() != null) {
                int u = next3.D0().u();
                if (u != 0) {
                    d.a.j0.s2.h0.d.i(next3, u);
                    if (u != 28 && u != 31) {
                        if (next3.D0().goods != null) {
                            next3.D0().goods.goods_style = -1001;
                        }
                        Log.e("cq", "updateAppData，Data InValidate: " + u);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.j0.s2.h0.d.i(oVar2, 30);
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
            if (this.f52887d.l() != null) {
                oVar4.B0 = this.f52887d.l().getId();
            }
            if (this.f52887d.L() != null) {
                oVar4.E0 = d.a.c.e.m.b.f(this.f52887d.L().o0(), 0L);
            }
            d.a.j0.d2.h.e eVar2 = this.f52887d;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.K0 = this.f52887d.w().a();
            }
            f(oVar4);
            int position = oVar4.getPosition() + this.f52887d.X;
            if (position >= D.size()) {
                oVar4.M0 = position;
                d.a.j0.s2.h0.d.j(oVar4, 2, position + i4, D.size());
                return;
            }
            if (!this.v) {
                position--;
                oVar4.M0 = position;
            }
            if (position < 0) {
                d.a.j0.s2.h0.d.i(oVar4, 23);
            } else if (n(D, position)) {
                d.a.j0.s2.h0.d.i(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f52885b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, DpStatConstants.KEY_APP_NAME, oVar4.D0().apk_name);
            }
        }
    }

    @Override // d.a.j0.d2.o.o.a
    public ArrayList<n> a() {
        return this.w;
    }

    public final void f(o oVar) {
        ForumData l;
        if (oVar == null || this.f52887d == null || oVar.D0() == null) {
            return;
        }
        oVar.D0().advertAppContext = new d.a.i0.r.q.d();
        if (this.f52887d.w() != null) {
            oVar.D0().advertAppContext.f49117b = this.f52887d.w().a();
        }
        oVar.D0().advertAppContext.f49116a = oVar.E0();
        if (this.f52887d.l() != null && (l = this.f52887d.l()) != null) {
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

    public final boolean g(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f52885b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f52885b.A(), true, i2)));
            return false;
        }
        return true;
    }

    public final int h() {
        d.a.j0.d2.h.e eVar = this.f52887d;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f52887d.L().G();
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
        return this.f52889f;
    }

    public PbFirstFloorCommentAndPraiseAdapter m() {
        return this.f52891h;
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
        h0.b(new C1193b(), new c(i2));
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
        this.f52890g = new f(this.f52885b.w(), PostData.o0);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f52885b.w(), p.j);
        this.f52891h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.I);
        this.f52892i = new d.a.j0.d2.o.m.c(this.f52885b.getContext(), u.f52077f);
        this.j = new PbFirstFloorEnterForumAdapter(this.f52885b.getContext(), g.l);
        this.k = new n0(this.f52885b.w(), d.a.j0.d2.h.o.l);
        this.n = new b0(this.f52885b.w(), d.a.j0.d2.h.j.f52034f, this.f52885b.getUniqueId());
        this.m = new j0(this.f52885b.w(), d.a.j0.d2.h.l.D0);
        this.o = new l(this.f52885b.w(), d.a.j0.d2.h.d.f52012g);
        j jVar = new j(this.f52885b.w(), d.a.i0.r.q.p.I3);
        this.p = jVar;
        jVar.n0(true);
        this.q = new z(this.f52885b.w());
        m mVar = new m(this.f52885b.w(), PostData.p0);
        this.f52889f = mVar;
        mVar.Y0(this.f52885b.w());
        this.l = new PbReplyLoadMoreAdapter(this.f52885b.w(), PostData.v0);
        this.t = w.p().a(this.f52885b.w().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.u = w.p().a(this.f52885b.w().getBaseFragmentActivity(), AdvertAppInfo.k4);
        e eVar = new e(this.f52885b.getPageContext(), a2.Y2, this.f52885b.getUniqueId());
        this.r = eVar;
        eVar.g0(this.f52886c);
        this.s = new PbFirstFloorItemAdapter(this.f52885b.getContext(), h.f52029g);
        this.f52888e.add(this.f52890g);
        this.f52888e.add(this.f52891h);
        this.f52888e.add(this.f52892i);
        this.f52888e.add(this.j);
        this.f52888e.add(this.k);
        this.f52888e.add(this.m);
        this.f52888e.add(this.n);
        this.f52888e.add(this.o);
        this.f52888e.add(this.p);
        this.f52888e.add(this.q);
        this.f52888e.add(this.t);
        this.f52888e.add(this.u);
        this.f52888e.add(this.f52889f);
        this.f52888e.add(this.l);
        this.f52888e.add(this.r);
        this.f52888e.add(this.s);
        this.f52888e.add(new PbPrivateTitleAdapter(this.f52885b.w()));
        this.f52886c.a(this.f52888e);
    }

    public boolean q() {
        if (this.f52885b.z() != null) {
            return this.f52885b.z().d0();
        }
        return false;
    }

    public void r() {
        if (this.f52886c.getAdapter() instanceof BdRecyclerAdapter) {
            this.f52886c.getAdapter().notifyDataSetChanged();
        }
    }

    public void s() {
        n0 n0Var = this.k;
        if (n0Var != null) {
            n0Var.onDestroy();
        }
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f52891h;
        if (pbFirstFloorCommentAndPraiseAdapter != null) {
            pbFirstFloorCommentAndPraiseAdapter.onDestroy();
        }
    }

    public final void t() {
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            n nVar = this.w.get(i2);
            if (nVar instanceof d.a.j0.d2.h.o) {
                this.A = i2;
                z = true;
            } else if ((nVar instanceof d.a.j0.d2.h.d) && ((d.a.j0.d2.h.d) nVar).c() == this.f52884a) {
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

    public void u(d.a.j0.d2.h.e eVar) {
        v(eVar, false);
    }

    public void v(d.a.j0.d2.h.e eVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        if (eVar == null) {
            return;
        }
        this.f52887d = eVar;
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
        this.f52890g.H0(eVar);
        this.f52890g.p(this.x);
        int i2 = 0;
        if (!ListUtils.isEmpty(eVar.D()) && eVar.D().get(0) != null && eVar.L() != null) {
            eVar.L().N3(eVar.D().get(0).F());
            eVar.L().P3(eVar.D().get(0).G());
        }
        if (eVar.L() != null && eVar.L().T0() != null) {
            z1 z1Var = new z1();
            z1Var.w = eVar.L();
            z1Var.r = true;
            this.w.add(z1Var);
        }
        p pVar = new p(eVar.L(), eVar.d());
        pVar.l(false);
        pVar.f52057f = false;
        this.w.add(pVar);
        if (postData == null || postData.k0 == null || (eVar.l() != null && TextUtils.equals(eVar.l().getName(), this.f52885b.z().a0()) && this.f52885b.z().e0())) {
            z2 = false;
        } else {
            h hVar = new h(postData.k0);
            hVar.f52031f = this.f52885b.z().O0();
            this.w.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.l() != null && !StringUtils.isNull(eVar.l().getName()) && (!TextUtils.equals(eVar.l().getName(), this.f52885b.z().a0()) || !this.f52885b.z().e0())) {
            g gVar = new g(eVar.l());
            gVar.k = this.f52885b.z().O0();
            gVar.f52028i = false;
            this.w.add(gVar);
            pVar.l(false);
            pVar.f52057f = false;
        }
        d.a.j0.d2.h.o oVar2 = new d.a.j0.d2.h.o(d.a.j0.d2.h.o.l);
        a2 L = eVar.L();
        if (L != null) {
            L.Z0();
        }
        this.f52885b.z().M0();
        oVar2.f52054h = q();
        oVar2.f52053g = eVar.f52021g;
        eVar.c();
        oVar2.f52055i = eVar.a0();
        oVar2.k = eVar.f52020f;
        this.k.s(eVar);
        this.w.add(oVar2);
        if (eVar.I() == 4) {
            this.w.add(new d.a.j0.d2.h.n());
        }
        E();
        d.a.c.j.e.a aVar = this.u;
        if (aVar != null && (aVar instanceof s)) {
            ((s) aVar).j(this.z);
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
            d.a.j0.d2.h.l lVar = new d.a.j0.d2.h.l();
            lVar.y0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.x0 = R.drawable.new_pic_emotion_03;
            lVar.z0 = -2;
            lVar.A0 = d.a.c.e.p.l.g(this.f52885b.getContext(), R.dimen.tbds74);
            this.w.add(lVar);
        }
        this.f52889f.s(eVar);
        this.f52889f.setFromCDN(this.z);
        this.f52889f.p(this.x);
        this.f52889f.c(this.y);
        this.f52889f.e(this.D);
        this.f52889f.l(this.C);
        this.f52889f.o(this.E);
        this.f52889f.d(this.G);
        this.f52889f.X0(this.F);
        this.k.e(this.D);
        this.k.m0(this.H);
        this.l.i0(this.D);
        if (eVar.w().b() == 0) {
            if (z3) {
                this.n.i0(this.f52885b.w().V2());
                d.a.j0.d2.h.j jVar = new d.a.j0.d2.h.j();
                jVar.f52035e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.w.add(jVar);
            }
            List<o> V = eVar.V();
            int i3 = -1;
            if (V != null && !V.isEmpty()) {
                oVar = V.get(0);
                i3 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                d.a.j0.d2.h.d dVar = new d.a.j0.d2.h.d();
                dVar.h(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.f(this.f52884a);
                this.w.add(dVar);
                int i4 = 1;
                for (d.a.i0.r.q.p pVar2 : eVar.f()) {
                    if (V != null && i4 == i3) {
                        if (oVar != null) {
                            f(oVar);
                            this.w.add(oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.i4) {
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f52886c;
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
