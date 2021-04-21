package d.b.j0.d2.o.m;

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
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.j0.d2.h.g;
import d.b.j0.d2.h.h;
import d.b.j0.d2.h.p;
import d.b.j0.d2.h.u;
import d.b.j0.d2.k.e.b0;
import d.b.j0.d2.k.e.j;
import d.b.j0.d2.k.e.j0;
import d.b.j0.d2.k.e.l;
import d.b.j0.d2.k.e.m;
import d.b.j0.d2.k.e.n0;
import d.b.j0.d2.k.e.z;
import d.b.j0.d3.h0.o;
import d.b.j0.s2.s;
import d.b.j0.s2.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends d.b.j0.d2.o.o.a {
    public SortSwitchButton.f H;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f55057b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f55058c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.d2.h.e f55059d;

    /* renamed from: f  reason: collision with root package name */
    public m f55061f;

    /* renamed from: g  reason: collision with root package name */
    public f f55062g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f55063h;
    public d.b.j0.d2.o.m.c i;
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
    public d.b.c.j.e.a t;
    public d.b.c.j.e.a u;
    public ArrayList<n> w;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f55056a = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f55060e = new ArrayList();
    public boolean v = true;
    public String x = null;
    public boolean y = true;
    public boolean z = false;
    public int A = -1;
    public int B = -1;
    public View.OnClickListener C = null;
    public View.OnClickListener D = null;
    public TbRichTextView.x E = null;
    public d.b.j0.d2.i.c F = null;
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

    /* renamed from: d.b.j0.d2.o.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1254b extends f0<ShareItem> {
        public C1254b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.b.j0.d2.k.e.d1.b.c(b.this.f55057b.getContext(), b.this.h(), ShareSwitch.isOn() ? 1 : 6, b.this.f55057b.L());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.i0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55066a;

        public c(int i) {
            this.f55066a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.f55057b.getContext(), this.f55066a, shareItem, false));
        }
    }

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55057b = detailInfoAndReplyFragment;
        this.f55058c = bdTypeRecyclerView;
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

    public void D(d.b.j0.d2.i.c cVar) {
        this.F = cVar;
    }

    public final void E() {
        o oVar;
        o oVar2;
        d.b.j0.d2.h.e eVar = this.f55059d;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f55059d.e();
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
                    d.b.j0.s2.f0.d.i(next3, u);
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
        for (int i = 0; i < sparseArray.size(); i++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.b.j0.s2.f0.d.i(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.f55059d.l() != null) {
                oVar4.B0 = this.f55059d.l().getId();
            }
            if (this.f55059d.L() != null) {
                oVar4.E0 = d.b.c.e.m.b.f(this.f55059d.L().o0(), 0L);
            }
            d.b.j0.d2.h.e eVar2 = this.f55059d;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.K0 = this.f55059d.w().a();
            }
            f(oVar4);
            int position = oVar4.getPosition() + this.f55059d.X;
            if (position >= D.size()) {
                oVar4.M0 = position;
                d.b.j0.s2.f0.d.j(oVar4, 2, position + i3, D.size());
                return;
            }
            if (!this.v) {
                position--;
                oVar4.M0 = position;
            }
            if (position < 0) {
                d.b.j0.s2.f0.d.i(oVar4, 23);
            } else if (n(D, position)) {
                d.b.j0.s2.f0.d.i(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f55057b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, DpStatConstants.KEY_APP_NAME, oVar4.D0().apk_name);
            }
        }
    }

    @Override // d.b.j0.d2.o.o.a
    public ArrayList<n> a() {
        return this.w;
    }

    public final void f(o oVar) {
        ForumData l;
        if (oVar == null || this.f55059d == null || oVar.D0() == null) {
            return;
        }
        oVar.D0().advertAppContext = new d.b.i0.r.q.d();
        if (this.f55059d.w() != null) {
            oVar.D0().advertAppContext.f51493b = this.f55059d.w().a();
        }
        oVar.D0().advertAppContext.f51492a = oVar.E0();
        if (this.f55059d.l() != null && (l = this.f55059d.l()) != null) {
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

    public final boolean g(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f55057b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f55057b.P(), true, i)));
            return false;
        }
        return true;
    }

    public final int h() {
        d.b.j0.d2.h.e eVar = this.f55059d;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f55059d.L().G();
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
        return this.f55061f;
    }

    public PbFirstFloorCommentAndPraiseAdapter m() {
        return this.f55063h;
    }

    public final boolean n(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof o) {
                return true;
            }
        }
        return false;
    }

    public final void o(int i) {
        h0.b(new C1254b(), new c(i));
        StatisticItem statisticItem = new StatisticItem("c13833");
        statisticItem.param("obj_locate", 1);
        if (i == 3) {
            statisticItem.param("obj_type", 1);
        } else if (i == 8) {
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void p() {
        this.f55062g = new f(this.f55057b.I(), PostData.o0);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f55057b.I(), p.j);
        this.f55063h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.I);
        this.i = new d.b.j0.d2.o.m.c(this.f55057b.getContext(), u.f54293f);
        this.j = new PbFirstFloorEnterForumAdapter(this.f55057b.getContext(), g.l);
        this.k = new n0(this.f55057b.I(), d.b.j0.d2.h.o.l);
        this.n = new b0(this.f55057b.I(), d.b.j0.d2.h.j.f54253f, this.f55057b.getUniqueId());
        this.m = new j0(this.f55057b.I(), d.b.j0.d2.h.l.D0);
        this.o = new l(this.f55057b.I(), d.b.j0.d2.h.d.f54233g);
        j jVar = new j(this.f55057b.I(), d.b.i0.r.q.p.I3);
        this.p = jVar;
        jVar.p0(true);
        this.q = new z(this.f55057b.I());
        m mVar = new m(this.f55057b.I(), PostData.p0);
        this.f55061f = mVar;
        mVar.Y0(this.f55057b.I());
        this.l = new PbReplyLoadMoreAdapter(this.f55057b.I(), PostData.v0);
        this.t = v.p().a(this.f55057b.I().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.u = v.p().a(this.f55057b.I().getBaseFragmentActivity(), AdvertAppInfo.k4);
        e eVar = new e(this.f55057b.getPageContext(), a2.Y2, this.f55057b.getUniqueId());
        this.r = eVar;
        eVar.j0(this.f55058c);
        this.s = new PbFirstFloorItemAdapter(this.f55057b.getContext(), h.f54248g);
        this.f55060e.add(this.f55062g);
        this.f55060e.add(this.f55063h);
        this.f55060e.add(this.i);
        this.f55060e.add(this.j);
        this.f55060e.add(this.k);
        this.f55060e.add(this.m);
        this.f55060e.add(this.n);
        this.f55060e.add(this.o);
        this.f55060e.add(this.p);
        this.f55060e.add(this.q);
        this.f55060e.add(this.t);
        this.f55060e.add(this.u);
        this.f55060e.add(this.f55061f);
        this.f55060e.add(this.l);
        this.f55060e.add(this.r);
        this.f55060e.add(this.s);
        this.f55060e.add(new PbPrivateTitleAdapter(this.f55057b.I()));
        this.f55058c.a(this.f55060e);
    }

    public boolean q() {
        if (this.f55057b.L() != null) {
            return this.f55057b.L().d0();
        }
        return false;
    }

    public void r() {
        if (this.f55058c.getAdapter() instanceof BdRecyclerAdapter) {
            this.f55058c.getAdapter().notifyDataSetChanged();
        }
    }

    public void s() {
        n0 n0Var = this.k;
        if (n0Var != null) {
            n0Var.onDestroy();
        }
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f55063h;
        if (pbFirstFloorCommentAndPraiseAdapter != null) {
            pbFirstFloorCommentAndPraiseAdapter.onDestroy();
        }
    }

    public final void t() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.w.size(); i++) {
            n nVar = this.w.get(i);
            if (nVar instanceof d.b.j0.d2.h.o) {
                this.A = i;
                z = true;
            } else if ((nVar instanceof d.b.j0.d2.h.d) && ((d.b.j0.d2.h.d) nVar).a() == this.f55056a) {
                this.B = i;
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

    public void u(d.b.j0.d2.h.e eVar) {
        v(eVar, false);
    }

    public void v(d.b.j0.d2.h.e eVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        if (eVar == null) {
            return;
        }
        this.f55059d = eVar;
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
        this.f55062g.H0(eVar);
        this.f55062g.n(this.x);
        int i = 0;
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
        pVar.f54275f = false;
        this.w.add(pVar);
        if (postData == null || postData.k0 == null || (eVar.l() != null && TextUtils.equals(eVar.l().getName(), this.f55057b.L().a0()) && this.f55057b.L().e0())) {
            z2 = false;
        } else {
            h hVar = new h(postData.k0);
            hVar.f54250f = this.f55057b.L().O0();
            this.w.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.l() != null && !StringUtils.isNull(eVar.l().getName()) && (!TextUtils.equals(eVar.l().getName(), this.f55057b.L().a0()) || !this.f55057b.L().e0())) {
            g gVar = new g(eVar.l());
            gVar.k = this.f55057b.L().O0();
            gVar.i = false;
            this.w.add(gVar);
            pVar.l(false);
            pVar.f54275f = false;
        }
        d.b.j0.d2.h.o oVar2 = new d.b.j0.d2.h.o(d.b.j0.d2.h.o.l);
        a2 L = eVar.L();
        if (L != null) {
            L.Z0();
        }
        this.f55057b.L().M0();
        oVar2.f54273h = q();
        oVar2.f54272g = eVar.f54242g;
        eVar.c();
        oVar2.i = eVar.a0();
        oVar2.k = eVar.f54241f;
        this.k.s(eVar);
        this.w.add(oVar2);
        if (eVar.I() == 4) {
            this.w.add(new d.b.j0.d2.h.n());
        }
        E();
        d.b.c.j.e.a aVar = this.u;
        if (aVar != null && (aVar instanceof s)) {
            ((s) aVar).c(this.z);
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
        if (!z3 && (!z || !d.b.c.e.p.j.z())) {
            d.b.j0.d2.h.l lVar = new d.b.j0.d2.h.l();
            lVar.y0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.x0 = R.drawable.new_pic_emotion_03;
            lVar.z0 = -2;
            lVar.A0 = d.b.c.e.p.l.g(this.f55057b.getContext(), R.dimen.tbds74);
            this.w.add(lVar);
        }
        this.f55061f.s(eVar);
        this.f55061f.setFromCDN(this.z);
        this.f55061f.n(this.x);
        this.f55061f.h(this.y);
        this.f55061f.l(this.D);
        this.f55061f.e(this.C);
        this.f55061f.j(this.E);
        this.f55061f.k(this.G);
        this.f55061f.X0(this.F);
        this.k.l(this.D);
        this.k.o0(this.H);
        this.l.m0(this.D);
        if (eVar.w().b() == 0) {
            if (z3) {
                this.n.m0(this.f55057b.I().V2());
                d.b.j0.d2.h.j jVar = new d.b.j0.d2.h.j();
                jVar.f54254e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.w.add(jVar);
            }
            List<o> V = eVar.V();
            int i2 = -1;
            if (V != null && !V.isEmpty()) {
                oVar = V.get(0);
                i2 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                d.b.j0.d2.h.d dVar = new d.b.j0.d2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.f(this.f55056a);
                this.w.add(dVar);
                int i3 = 1;
                for (d.b.i0.r.q.p pVar2 : eVar.f()) {
                    if (V != null && i3 == i2) {
                        if (oVar != null) {
                            f(oVar);
                            this.w.add(oVar);
                            i++;
                            if (oVar.getType() != AdvertAppInfo.i4) {
                                i3++;
                            }
                        }
                        if (i < V.size()) {
                            o oVar3 = V.get(i);
                            oVar = oVar3;
                            i2 = oVar3.getPosition();
                        }
                    }
                    this.w.add(pVar2);
                    i3++;
                    if (i3 == 4 && eVar.A() != null) {
                        this.w.add(eVar.A());
                        i3++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f55058c;
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
