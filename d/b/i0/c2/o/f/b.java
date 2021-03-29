package d.b.i0.c2.o.f;

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
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.h0.z0.f0;
import d.b.i0.c2.h.g;
import d.b.i0.c2.h.l;
import d.b.i0.c2.h.p;
import d.b.i0.c2.h.u;
import d.b.i0.c2.k.e.h;
import d.b.i0.c2.k.e.h0;
import d.b.i0.c2.k.e.j;
import d.b.i0.c2.k.e.k;
import d.b.i0.c2.k.e.l0;
import d.b.i0.c2.k.e.x;
import d.b.i0.c2.k.e.z;
import d.b.i0.c3.h0.o;
import d.b.i0.r2.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b extends d.b.i0.c2.o.h.a {
    public SortSwitchButton.f H;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f53212b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53213c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.c2.h.e f53214d;

    /* renamed from: f  reason: collision with root package name */
    public k f53216f;

    /* renamed from: g  reason: collision with root package name */
    public f f53217g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f53218h;
    public d.b.i0.c2.o.f.c i;
    public PbFirstFloorEnterForumAdapter j;
    public l0 k;
    public PbReplyLoadMoreAdapter l;
    public h0 m;
    public z n;
    public j o;
    public h p;
    public x q;
    public e r;
    public PbFirstFloorItemAdapter s;
    public d.b.b.j.e.a t;
    public d.b.b.j.e.a u;
    public ArrayList<n> w;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f53211a = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f53215e = new ArrayList();
    public boolean v = true;
    public String x = null;
    public boolean y = true;
    public boolean z = false;
    public int A = -1;
    public int B = -1;
    public View.OnClickListener C = null;
    public View.OnClickListener D = null;
    public TbRichTextView.w E = null;
    public d.b.i0.c2.i.c F = null;
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

    /* renamed from: d.b.i0.c2.o.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1174b extends f0<ShareItem> {
        public C1174b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return d.b.i0.c2.k.e.b1.b.c(b.this.f53212b.getContext(), b.this.h(), ShareSwitch.isOn() ? 1 : 6, b.this.f53212b.L());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.b.h0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f53221a;

        public c(int i) {
            this.f53221a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.f53212b.getContext(), this.f53221a, shareItem, false));
        }
    }

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53212b = detailInfoAndReplyFragment;
        this.f53213c = bdTypeRecyclerView;
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

    public void D(d.b.i0.c2.i.c cVar) {
        this.F = cVar;
    }

    public final void E() {
        o oVar;
        o oVar2;
        d.b.i0.c2.h.e eVar = this.f53214d;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f53214d.e();
        if (e2 == null || e2.isEmpty() || D == null || D.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.A0() != null) {
                sb.append(next.A0());
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
                next2.z0 = sb.toString();
                next2.L0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.B0() != null) {
                int u = next3.B0().u();
                if (u != 0) {
                    d.b.i0.r2.b0.d.h(next3, u);
                    if (u != 28 && u != 31) {
                        if (next3.B0().goods != null) {
                            next3.B0().goods.goods_style = -1001;
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
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.A0(), oVar3)) != null) {
                d.b.i0.r2.b0.d.h(oVar2, 30);
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
            if (this.f53214d.l() != null) {
                oVar4.A0 = this.f53214d.l().getId();
            }
            if (this.f53214d.L() != null) {
                oVar4.D0 = d.b.b.e.m.b.f(this.f53214d.L().o0(), 0L);
            }
            d.b.i0.c2.h.e eVar2 = this.f53214d;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.E0 = this.f53214d.w().a();
            }
            f(oVar4);
            int position = oVar4.getPosition() + this.f53214d.X;
            if (position >= D.size()) {
                oVar4.L0 = position;
                d.b.i0.r2.b0.d.i(oVar4, 2, position + i3, D.size());
                return;
            }
            if (!this.v) {
                position--;
                oVar4.L0 = position;
            }
            if (position < 0) {
                d.b.i0.r2.b0.d.h(oVar4, 23);
            } else if (n(D, position)) {
                d.b.i0.r2.b0.d.h(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f53212b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, DpStatConstants.KEY_APP_NAME, oVar4.B0().apk_name);
            }
        }
    }

    @Override // d.b.i0.c2.o.h.a
    public ArrayList<n> a() {
        return this.w;
    }

    public final void f(o oVar) {
        ForumData l;
        if (oVar == null || this.f53214d == null || oVar.B0() == null) {
            return;
        }
        oVar.B0().advertAppContext = new d.b.h0.r.q.d();
        if (this.f53214d.w() != null) {
            oVar.B0().advertAppContext.f50750b = this.f53214d.w().a();
        }
        oVar.B0().advertAppContext.f50749a = oVar.C0();
        if (this.f53214d.l() != null && (l = this.f53214d.l()) != null) {
            oVar.B0().advertAppContext.f50752d = l.getId();
            oVar.B0().advertAppContext.f50753e = l.getFirst_class();
            oVar.B0().advertAppContext.f50754f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.B0().advertAppContext.f50755g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.B0().advertAppContext.f50756h = oVar.B0().ext_info;
        oVar.B0().advertAppContext.i = false;
    }

    public final boolean g(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.f53212b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f53212b.P(), true, i)));
            return false;
        }
        return true;
    }

    public final int h() {
        d.b.i0.c2.h.e eVar = this.f53214d;
        if (eVar == null || eVar.L() == null) {
            return -1;
        }
        return this.f53214d.L().G();
    }

    public int i() {
        return this.B;
    }

    public int j() {
        return this.A;
    }

    public l0 k() {
        return this.k;
    }

    public k l() {
        return this.f53216f;
    }

    public PbFirstFloorCommentAndPraiseAdapter m() {
        return this.f53218h;
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
        d.b.h0.z0.h0.b(new C1174b(), new c(i));
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
        this.f53217g = new f(this.f53212b.I(), PostData.n0);
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f53212b.I(), p.j);
        this.f53218h = pbFirstFloorCommentAndPraiseAdapter;
        pbFirstFloorCommentAndPraiseAdapter.t0(this.I);
        this.i = new d.b.i0.c2.o.f.c(this.f53212b.getContext(), u.f52477f);
        this.j = new PbFirstFloorEnterForumAdapter(this.f53212b.getContext(), g.l);
        this.k = new l0(this.f53212b.I(), d.b.i0.c2.h.o.l);
        this.n = new z(this.f53212b.I(), d.b.i0.c2.h.j.f52437f, this.f53212b.getUniqueId());
        this.m = new h0(this.f53212b.I(), l.C0);
        this.o = new j(this.f53212b.I(), d.b.i0.c2.h.d.f52417g);
        h hVar = new h(this.f53212b.I(), d.b.h0.r.q.p.I3);
        this.p = hVar;
        hVar.p0(true);
        this.q = new x(this.f53212b.I());
        k kVar = new k(this.f53212b.I(), PostData.o0);
        this.f53216f = kVar;
        kVar.Y0(this.f53212b.I());
        this.l = new PbReplyLoadMoreAdapter(this.f53212b.I(), PostData.u0);
        this.t = s.o().a(this.f53212b.I().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.u = s.o().a(this.f53212b.I().getBaseFragmentActivity(), AdvertAppInfo.k4);
        e eVar = new e(this.f53212b.getPageContext(), a2.Y2, this.f53212b.getUniqueId());
        this.r = eVar;
        eVar.j0(this.f53213c);
        this.s = new PbFirstFloorItemAdapter(this.f53212b.getContext(), d.b.i0.c2.h.h.f52432g);
        this.f53215e.add(this.f53217g);
        this.f53215e.add(this.f53218h);
        this.f53215e.add(this.i);
        this.f53215e.add(this.j);
        this.f53215e.add(this.k);
        this.f53215e.add(this.m);
        this.f53215e.add(this.n);
        this.f53215e.add(this.o);
        this.f53215e.add(this.p);
        this.f53215e.add(this.q);
        this.f53215e.add(this.t);
        this.f53215e.add(this.u);
        this.f53215e.add(this.f53216f);
        this.f53215e.add(this.l);
        this.f53215e.add(this.r);
        this.f53215e.add(this.s);
        this.f53215e.add(new PbPrivateTitleAdapter(this.f53212b.I()));
        this.f53213c.a(this.f53215e);
    }

    public boolean q() {
        if (this.f53212b.L() != null) {
            return this.f53212b.L().d0();
        }
        return false;
    }

    public void r() {
        if (this.f53213c.getAdapter() instanceof BdRecyclerAdapter) {
            this.f53213c.getAdapter().notifyDataSetChanged();
        }
    }

    public void s() {
        l0 l0Var = this.k;
        if (l0Var != null) {
            l0Var.onDestroy();
        }
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f53218h;
        if (pbFirstFloorCommentAndPraiseAdapter != null) {
            pbFirstFloorCommentAndPraiseAdapter.onDestroy();
        }
    }

    public final void t() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.w.size(); i++) {
            n nVar = this.w.get(i);
            if (nVar instanceof d.b.i0.c2.h.o) {
                this.A = i;
                z = true;
            } else if ((nVar instanceof d.b.i0.c2.h.d) && ((d.b.i0.c2.h.d) nVar).a() == this.f53211a) {
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

    public void u(d.b.i0.c2.h.e eVar) {
        v(eVar, false);
    }

    public void v(d.b.i0.c2.h.e eVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        if (eVar == null) {
            return;
        }
        this.f53214d = eVar;
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
                if (postData.z() == 1) {
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
        this.f53217g.H0(eVar);
        this.f53217g.n(this.x);
        int i = 0;
        if (!ListUtils.isEmpty(eVar.D()) && eVar.D().get(0) != null && eVar.L() != null) {
            eVar.L().M3(eVar.D().get(0).E());
            eVar.L().O3(eVar.D().get(0).F());
        }
        if (eVar.L() != null && eVar.L().T0() != null) {
            z1 z1Var = new z1();
            z1Var.w = eVar.L();
            z1Var.r = true;
            this.w.add(z1Var);
        }
        p pVar = new p(eVar.L(), eVar.d());
        pVar.l(false);
        pVar.f52459f = false;
        this.w.add(pVar);
        if (postData == null || postData.k0 == null || (eVar.l() != null && TextUtils.equals(eVar.l().getName(), this.f53212b.L().a0()) && this.f53212b.L().e0())) {
            z2 = false;
        } else {
            d.b.i0.c2.h.h hVar = new d.b.i0.c2.h.h(postData.k0);
            hVar.f52434f = this.f53212b.L().O0();
            this.w.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.l() != null && !StringUtils.isNull(eVar.l().getName()) && (!TextUtils.equals(eVar.l().getName(), this.f53212b.L().a0()) || !this.f53212b.L().e0())) {
            g gVar = new g(eVar.l());
            gVar.k = this.f53212b.L().O0();
            gVar.i = false;
            this.w.add(gVar);
            pVar.l(false);
            pVar.f52459f = false;
        }
        d.b.i0.c2.h.o oVar2 = new d.b.i0.c2.h.o(d.b.i0.c2.h.o.l);
        a2 L = eVar.L();
        if (L != null) {
            L.Z0();
        }
        this.f53212b.L().M0();
        oVar2.f52457h = q();
        oVar2.f52456g = eVar.f52426g;
        eVar.c();
        oVar2.i = eVar.Z();
        oVar2.k = eVar.f52425f;
        this.k.s(eVar);
        this.w.add(oVar2);
        if (eVar.I() == 4) {
            this.w.add(new d.b.i0.c2.h.n());
        }
        E();
        d.b.b.j.e.a aVar = this.u;
        if (aVar != null && (aVar instanceof d.b.i0.r2.p)) {
            ((d.b.i0.r2.p) aVar).c(this.z);
        }
        Iterator<PostData> it2 = eVar.D().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.z() != 1) {
                this.w.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !d.b.b.e.p.j.z())) {
            l lVar = new l();
            lVar.x0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.w0 = R.drawable.new_pic_emotion_03;
            lVar.y0 = -2;
            lVar.z0 = d.b.b.e.p.l.g(this.f53212b.getContext(), R.dimen.tbds74);
            this.w.add(lVar);
        }
        this.f53216f.s(eVar);
        this.f53216f.setFromCDN(this.z);
        this.f53216f.n(this.x);
        this.f53216f.h(this.y);
        this.f53216f.l(this.D);
        this.f53216f.e(this.C);
        this.f53216f.j(this.E);
        this.f53216f.k(this.G);
        this.f53216f.X0(this.F);
        this.k.l(this.D);
        this.k.o0(this.H);
        this.l.m0(this.D);
        if (eVar.w().b() == 0) {
            if (z3) {
                this.n.m0(this.f53212b.I().T2());
                d.b.i0.c2.h.j jVar = new d.b.i0.c2.h.j();
                jVar.f52438e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.w.add(jVar);
            }
            List<o> U = eVar.U();
            int i2 = -1;
            if (U != null && !U.isEmpty()) {
                oVar = U.get(0);
                i2 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                d.b.i0.c2.h.d dVar = new d.b.i0.c2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.f(this.f53211a);
                this.w.add(dVar);
                int i3 = 1;
                for (d.b.h0.r.q.p pVar2 : eVar.f()) {
                    if (U != null && i3 == i2) {
                        if (oVar != null) {
                            f(oVar);
                            this.w.add(oVar);
                            i++;
                            if (oVar.getType() != AdvertAppInfo.i4) {
                                i3++;
                            }
                        }
                        if (i < U.size()) {
                            o oVar3 = U.get(i);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f53213c;
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

    public void z(TbRichTextView.w wVar) {
        this.E = wVar;
    }
}
