package d.b.i0.c2.k.e;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.d1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class g {
    public boolean F;
    public boolean G;
    public int I;
    public Runnable T;
    public int V;
    public a2 X;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52682a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f52683b;

    /* renamed from: c  reason: collision with root package name */
    public q f52684c;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f52685d;
    public List<d.b.b.j.e.a> d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f52686e;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f52687f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.c2.k.e.w0.a f52688g;

    /* renamed from: h  reason: collision with root package name */
    public l0 f52689h;
    public l0 i;
    public k j;
    public d.b.i0.c2.n.a k;
    public d.b.i0.x.f0.a l;
    public d.b.b.j.e.a m;
    public d.b.b.j.e.a n;
    public d.b.b.j.e.a o;
    public d.b.b.j.e.a p;
    public i0 q;
    public j0 r;
    public h0 s;
    public PbReplyLoadMoreAdapter t;
    public h v;
    public v w;
    public d.b.i0.c2.h.e x;
    public ArrayList<d.b.b.j.e.n> z;
    public ArrayList<d.b.i0.c2.k.c.a> u = new ArrayList<>();
    public ArrayList<PostData> y = new ArrayList<>();
    public boolean A = false;
    public boolean B = true;
    public boolean C = true;
    public boolean D = false;
    public boolean E = false;
    public boolean H = false;
    public String J = null;
    public PostData K = null;
    public View.OnClickListener L = null;
    public View.OnClickListener M = null;
    public TbRichTextView.w N = null;
    public d.b.i0.c2.i.c O = null;
    public View.OnLongClickListener P = null;
    public SortSwitchButton.f Q = null;
    public final List<d.b.b.j.e.a> R = new ArrayList();
    public final List<d.b.b.j.e.a> S = new ArrayList();
    public int U = -1;
    public int W = -1;
    public final CustomMessageListener Y = new a(2921523);
    public CustomMessageListener Z = new b(2004015);
    public final CustomMessageListener a0 = new c(2001118);
    public final View.OnClickListener b0 = new d();
    public CustomMessageListener c0 = new f(2016470);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.b.i0.c3.h0.n)) {
                return;
            }
            d.b.i0.c3.h0.n nVar = (d.b.i0.c3.h0.n) customResponsedMessage.getData();
            if (g.this.X == null || g.this.X.C2 != nVar) {
                return;
            }
            g.this.X.C2.j(true);
            g.this.f52683b.setData(g.this.z);
            g.this.U();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof d.b.i0.c3.h0.d)) {
                AbsDelegateAdapterList a2 = ((d.b.i0.c3.h0.d) customResponsedMessage.getData()).a();
                Iterator<d.b.b.j.e.a<?, ?>> it = a2.iterator();
                while (it.hasNext()) {
                    d.b.b.j.e.a<?, ?> next = it.next();
                    if (next instanceof m) {
                        ((m) next).i0(g.this.f52682a);
                        if (next instanceof d.b.i0.c2.k.c.a) {
                            g.this.u.add((d.b.i0.c2.k.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                g.this.S.clear();
                g.this.S.addAll(arrayList);
                if (g.this.f52683b != null) {
                    g.this.f52683b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.U();
            }
        }

        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            if (customResponsedMessage == null || g.this.x == null || d.b.b.a.j.c(g.this.f52682a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
                return;
            }
            boolean z = false;
            Iterator<DownloadData> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getStatus() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                d.b.b.e.m.e.a().postDelayed(new a(), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f52682a == null || g.this.x == null || g.this.x.P() == null) {
                return;
            }
            g.this.f52682a.G4().v0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f52695e;

        public e(List list) {
            this.f52695e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f52683b.setSelectionFromTop(g.this.f52683b.getHeaderViewsCount() + this.f52695e.size(), 0 - g.this.V);
            g.this.G = false;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(g.this.d0)) {
                g.this.n();
                g gVar = g.this;
                gVar.Z(gVar.x, false);
            }
        }
    }

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.I = 0;
        this.V = 0;
        this.I = d.b.b.e.p.l.k(pbFragment.getPageContext().getPageActivity());
        this.f52682a = pbFragment;
        this.f52683b = bdTypeListView;
        H(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.a0);
        this.V = d.b.b.e.p.l.i(this.f52682a.getContext()) / 3;
    }

    public int A() {
        BdTypeListView bdTypeListView = this.f52683b;
        if (bdTypeListView == null || bdTypeListView.getData() == null) {
            return -1;
        }
        for (int i = 0; i < this.f52683b.getData().size(); i++) {
            d.b.b.j.e.n nVar = this.f52683b.getData().get(i);
            if (nVar != null && nVar.getType() == d.b.i0.c2.h.o.l) {
                return i;
            }
        }
        return -1;
    }

    public int B(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList, boolean z) {
        if (eVar == null || eVar.D() == null || eVar.B() == null || eVar.D().size() == 0 || eVar.L() == null || arrayList == null || !eVar.B().A0()) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (eVar.D().get(0) == null || eVar.D().get(0).z() != 1) ? -1 : 1;
        } else if (size == 0) {
            return 0;
        } else {
            return (eVar.w() == null || eVar.w().a() != eVar.w().h()) ? -1 : 0;
        }
    }

    public int C(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList, boolean z) {
        if (eVar == null || eVar.D() == null || eVar.C() == null || eVar.D().size() == 0 || eVar.L() == null || arrayList == null || !eVar.C().A0()) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (eVar.D().get(0) == null || eVar.D().get(0).z() != 1) ? -1 : 1;
        } else if (size == 0) {
            return 0;
        } else {
            return (eVar.w() == null || eVar.w().a() != eVar.w().h()) ? -1 : 0;
        }
    }

    public ArrayList<PostData> D() {
        return this.y;
    }

    public final int E(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList, boolean z) {
        if (eVar == null || ListUtils.isEmpty(eVar.D()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.e0()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.D().get(0) == null || eVar.D().get(0).z() != 1) ? -1 : 1;
        }
        return 0;
    }

    public int F() {
        return this.U;
    }

    public View G() {
        q qVar = this.f52684c;
        if (qVar == null || qVar.x0() == null) {
            return null;
        }
        if (this.f52684c.x0().s != null && this.f52684c.x0().s.isShown()) {
            return this.f52684c.x0().s;
        }
        return this.f52684c.x0().r;
    }

    public void H(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        q qVar = new q(pbFragment, PostData.n0);
        this.f52684c = qVar;
        qVar.H0(pbFragment);
        this.f52685d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, d.b.i0.c2.h.p.j);
        this.f52686e = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), d.b.i0.c2.h.g.l);
        this.f52687f = new PbFirstFloorItemAdapter(pbFragment.getContext(), d.b.i0.c2.h.h.f52432g);
        this.f52688g = new d.b.i0.c2.k.e.w0.a(pbFragment, d.b.i0.c2.h.a.f52405g);
        this.f52689h = new l0(pbFragment, d.b.i0.c2.h.o.l);
        this.i = new l0(pbFragment, d.b.i0.c2.h.o.m);
        k kVar = new k(pbFragment, PostData.o0);
        this.j = kVar;
        kVar.Y0(pbFragment);
        this.m = d.b.i0.r2.s.o().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.n = d.b.i0.r2.s.o().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.o = d.b.i0.q0.b.d().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.l4);
        this.p = d.b.i0.q0.b.d().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.s = new h0(pbFragment, d.b.i0.c2.h.l.C0);
        this.q = new i0(pbFragment, g0.z0);
        this.r = new j0(pbFragment, d1.K0);
        this.t = new PbReplyLoadMoreAdapter(pbFragment, PostData.u0);
        this.k = new d.b.i0.c2.n.a(pbFragment, d.b.i0.c2.n.b.f53111e);
        this.l = new d.b.i0.x.f0.a(pbFragment.getPageContext());
        this.v = new h(pbFragment, d.b.h0.r.q.p.I3);
        this.w = new v(pbFragment, pbFragment.getUniqueId());
        this.R.add(this.f52684c);
        this.R.add(this.f52685d);
        this.R.add(this.f52686e);
        this.R.add(this.f52687f);
        this.R.add(this.f52688g);
        this.R.add(this.j);
        this.R.add(this.f52689h);
        this.R.add(this.i);
        this.R.add(this.m);
        this.R.add(this.n);
        this.R.add(this.o);
        this.R.add(this.p);
        this.R.add(this.s);
        this.R.add(this.q);
        this.R.add(this.r);
        this.R.add(this.k);
        this.R.add(this.t);
        this.R.add(this.l);
        this.R.add(this.v);
        this.R.add(this.w);
        this.R.add(new PbPrivateTitleAdapter(pbFragment));
        this.Z.setPriority(1);
        this.Z.setSelfListener(true);
        pbFragment.registerListener(this.Z);
        pbFragment.registerListener(this.Y);
        m();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new d.b.i0.c3.h0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.a(this.R);
    }

    public final void I(@NonNull d.b.i0.c2.h.e eVar) {
        this.f52684c.s(eVar);
        this.f52684c.setFromCDN(this.A);
        this.f52684c.g(this.I);
        this.f52684c.h(this.B);
        this.f52684c.l(this.M);
        this.f52684c.e(this.L);
        this.f52684c.j(this.N);
        this.f52684c.k(this.P);
        this.f52684c.G0(this.O);
        this.j.s(eVar);
        this.j.setFromCDN(this.A);
        this.j.n(this.J);
        this.j.h(this.B);
        this.j.l(this.M);
        this.j.e(this.L);
        this.j.j(this.N);
        this.j.k(this.P);
        this.j.X0(this.O);
        this.f52685d.t0(this.M);
        this.t.m0(this.M);
        this.k.m0(this.b0);
        d.b.b.j.e.a aVar = this.n;
        if (aVar != null && (aVar instanceof d.b.i0.r2.p)) {
            ((d.b.i0.r2.p) aVar).c(this.A);
        }
        Iterator<d.b.i0.c2.k.c.a> it = this.u.iterator();
        while (it.hasNext()) {
            d.b.i0.c2.k.c.a next = it.next();
            if (next != null) {
                next.s(eVar);
                next.setFromCDN(this.A);
                next.n(this.J);
                next.g(this.I);
                next.h(this.B);
                next.m(this.C);
                next.r(this.H);
                next.l(this.M);
                next.e(this.L);
                next.j(this.N);
                next.k(this.P);
            }
        }
        this.f52689h.l(this.M);
        this.f52689h.o0(this.Q);
        this.i.l(this.M);
        this.f52689h.s(eVar);
        this.f52688g.s(eVar);
        this.i.s(eVar);
        this.q.s(eVar);
        this.r.s(eVar);
        this.v.o0(eVar);
        this.v.n0(this.f52682a.l1);
        this.w.m0(eVar);
    }

    public final d.b.b.j.e.n J(ArrayList<d.b.b.j.e.n> arrayList, int i) {
        if (this.x == null) {
            return null;
        }
        d.b.i0.c3.h0.o U = this.f52682a.L().U();
        if (U == null) {
            U = this.x.x();
        }
        if (U == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert D0 = U.D0();
        if (D0 != null) {
            D0.setAdvertAppInfo(U.J0());
        }
        int u = U.B0().u();
        if (u != 0) {
            d.b.i0.r2.b0.d.h(U, u);
            if (u != 28 && u != 31 && U.B0().goods != null) {
                U.B0().goods.goods_style = -1001;
            }
            return null;
        }
        if (this.x.l() != null) {
            U.A0 = this.x.l().getId();
        }
        if (this.x.L() != null) {
            U.D0 = d.b.b.e.m.b.f(this.x.L().o0(), 0L);
        }
        d.b.i0.c2.h.e eVar = this.x;
        if (eVar != null && eVar.w() != null) {
            U.E0 = this.x.w().a();
        }
        l(U);
        if (i >= 0) {
            d.b.i0.i1.o.k.a.b(arrayList, U, i);
            return U;
        }
        return null;
    }

    public final boolean K(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(eVar.f()) && eVar.f().size() > 2) {
            int min = Math.min(eVar.f().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                d.b.h0.r.q.p pVar = eVar.f().get(i5);
                if (!z2 && i5 == 0) {
                    pVar.D4(true);
                }
                if (pVar.u1() == null) {
                    if (i5 == min - 1) {
                        pVar.F4(true);
                    }
                } else if (i5 == min - 2) {
                    pVar.F4(true);
                } else if (i5 == min - 1) {
                    pVar.E4(true);
                }
                arrayList2.add(pVar);
            }
        }
        if (arrayList2.size() > 0) {
            int i6 = (!z || i < 0) ? z ? i2 + 2 : i2 >= 0 ? i2 + 1 : i3 >= 0 ? i3 : i4 >= 0 ? i4 : -1 : i + 1;
            if (i6 >= 0 && arrayList2.size() > 1) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ListUtils.add(arrayList, i6, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    public final d.b.b.j.e.n L(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList, int i) {
        d.b.i0.c2.h.a aVar;
        if (i < 0 || eVar == null || !eVar.k || (aVar = eVar.l) == null) {
            return null;
        }
        ListUtils.add(arrayList, i, aVar);
        return aVar;
    }

    public final d.b.b.j.e.n M(ArrayList<d.b.b.j.e.n> arrayList, int i) {
        if (d.b.h0.b.d.A() && i > 0) {
            if (this.X == null && d.b.i0.q0.a.h().k("6051001775-457565154")) {
                a2 a2Var = new a2();
                this.X = a2Var;
                a2Var.C2 = new d.b.i0.c3.h0.n();
            }
            a2 a2Var2 = this.X;
            if (a2Var2 != null && a2Var2.C2 != null) {
                ListUtils.add(arrayList, i, a2Var2);
            }
        }
        return this.X;
    }

    public final d.b.b.j.e.n N(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList, int i) {
        d.b.i0.c2.h.g gVar;
        if (eVar.l() == null || StringUtils.isNull(eVar.l().getName())) {
            return null;
        }
        if (TextUtils.equals(eVar.l().getName(), this.f52682a.L().a0()) && this.f52682a.L().e0()) {
            return null;
        }
        if (!this.f52682a.isSimpleForum() && !ListUtils.isEmpty(eVar.p())) {
            gVar = new d.b.i0.c2.h.g(eVar.p().get(0));
        } else {
            gVar = new d.b.i0.c2.h.g(eVar.l());
        }
        gVar.k = this.f52682a.L().O0();
        ListUtils.add(arrayList, i + 1, gVar);
        return gVar;
    }

    public final d.b.b.j.e.n O(d.b.i0.c2.h.e eVar, PostData postData, ArrayList<d.b.b.j.e.n> arrayList, int i) {
        d.b.i0.c2.h.h hVar = null;
        if (eVar.l() == null || StringUtils.isNull(eVar.l().getName()) || !TextUtils.equals(eVar.l().getName(), this.f52682a.L().a0()) || !this.f52682a.L().e0()) {
            if (postData != null) {
                if (postData.k0 != null) {
                    hVar = new d.b.i0.c2.h.h(postData.k0);
                }
            } else {
                PostData postData2 = this.K;
                if (postData2 != null && postData2.k0 != null) {
                    hVar = new d.b.i0.c2.h.h(this.K.k0);
                }
            }
            if (hVar != null) {
                hVar.f52434f = this.f52682a.L().O0();
                ListUtils.add(arrayList, i + 1, hVar);
            }
            return hVar;
        }
        return null;
    }

    public final w P(ArrayList<d.b.b.j.e.n> arrayList, d.b.b.j.e.n nVar, int i, int i2) {
        w z = this.x.z();
        if (z != null) {
            if (nVar != null) {
                if (i2 >= 0 || nVar.getType() == AdvertAppInfo.k4) {
                    i2 = nVar.getType() != AdvertAppInfo.k4 ? i2 + 1 : -1;
                } else {
                    i2 = i + 2;
                }
            }
            if (i2 <= 0 || !(z instanceof w)) {
                return null;
            }
            ListUtils.add(arrayList, i2, z);
            return z;
        }
        return null;
    }

    public final void Q(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList, int i) {
        d.b.i0.c2.h.o oVar = new d.b.i0.c2.h.o(d.b.i0.c2.h.o.l);
        a2 L = eVar.L();
        if (L != null) {
            L.Z0();
        }
        oVar.f52457h = this.f52682a.Y4();
        oVar.f52456g = eVar.f52426g;
        eVar.c();
        oVar.i = eVar.Z();
        oVar.k = eVar.f52425f;
        ListUtils.add(arrayList, i, oVar);
        if (eVar.I() == 4) {
            ListUtils.add(arrayList, i + 1, new d.b.i0.c2.h.n());
        }
    }

    public final d.b.b.j.e.n R(ArrayList<d.b.b.j.e.n> arrayList, int i) {
        PbModel L;
        if (i >= 0 && (L = this.f52682a.L()) != null) {
            String C0 = L.C0();
            if (TextUtils.isEmpty(C0)) {
                return null;
            }
            d.b.i0.c3.h0.o oVar = new d.b.i0.c3.h0.o();
            oVar.H0(C0);
            l(oVar);
            ListUtils.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return null;
    }

    public boolean S() {
        return this.A;
    }

    public boolean T() {
        return this.B;
    }

    public void U() {
        this.U = A();
        if (this.f52683b.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f52683b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void V(int i) {
        if (i == 1) {
            q qVar = this.f52684c;
            if (qVar != null) {
                qVar.B0();
            }
            d.b.b.j.e.a aVar = this.n;
            if (aVar instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar).onPause();
            }
            d.b.b.j.e.a aVar2 = this.o;
            if (aVar2 instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar2).onPause();
            }
            l.a().h(this.f52682a.P());
        } else if (i == 2) {
            q qVar2 = this.f52684c;
            if (qVar2 != null) {
                qVar2.D0();
            }
            d.b.b.j.e.a aVar3 = this.n;
            if (aVar3 instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar3).onResume();
            }
            d.b.b.j.e.a aVar4 = this.o;
            if (aVar4 instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar4).onResume();
            }
            Y(false);
        } else if (i != 3) {
        } else {
            q qVar3 = this.f52684c;
            if (qVar3 != null) {
                qVar3.C0();
            }
            d.b.b.j.e.a aVar5 = this.n;
            if (aVar5 instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar5).onDestroy();
            }
            d.b.b.j.e.a aVar6 = this.o;
            if (aVar6 instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar6).onDestroy();
            }
            l.a().c();
        }
    }

    public void W() {
        d.b.b.e.m.e.a().removeCallbacks(this.T);
        l0 l0Var = this.f52689h;
        if (l0Var != null) {
            l0Var.onDestroy();
        }
        l0 l0Var2 = this.i;
        if (l0Var2 != null) {
            l0Var2.onDestroy();
        }
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f52685d;
        if (pbFirstFloorCommentAndPraiseAdapter != null) {
            pbFirstFloorCommentAndPraiseAdapter.onDestroy();
        }
        d.b.i0.c2.k.e.w0.a aVar = this.f52688g;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    public final void X(boolean z, boolean z2, int i, List<d.b.b.j.e.n> list) {
        if (z || z2) {
            return;
        }
        if ((!this.F && !this.E) || i == -1 || ListUtils.isEmpty(list) || this.G) {
            return;
        }
        this.T = new e(list);
        d.b.b.e.m.e.a().post(this.T);
    }

    public void Y(boolean z) {
        if (this.f52682a.G4() == null || this.f52682a.P() == null || this.f52682a.P().getPbModel() == null) {
            return;
        }
        l.a().f(this.f52682a.P().getPbModel().Y0(), this.f52689h.l0(), this.f52682a.G4().z0(), this.f52682a.P().getPageStayDurationItem(), z);
    }

    public void Z(d.b.i0.c2.h.e eVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        w wVar;
        int i2;
        List<d.b.b.j.e.n> list;
        int i3;
        boolean z8;
        d.b.b.j.e.n nVar;
        int i4;
        PostData postData2;
        if (eVar == null) {
            return;
        }
        this.x = eVar;
        q0();
        if (this.y == null) {
            this.y = new ArrayList<>();
        }
        this.y.clear();
        d.b.i0.c2.h.e eVar2 = this.x;
        if (eVar2 != null && eVar2.D() != null && this.x.D().size() > 0) {
            this.y.addAll(this.x.D());
        }
        if (eVar.L() != null && eVar.L().T() != null) {
            this.J = eVar.L().T().getUserId();
        }
        if (this.f52684c == null) {
            return;
        }
        I(eVar);
        ArrayList<d.b.b.j.e.n> arrayList = new ArrayList<>(eVar.D());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (p != null) {
            this.K = p;
        }
        if (this.C || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (eVar.e0() && p.J() != null) {
                p.r0(null);
            }
            z9 = true;
            z2 = true;
        }
        if (z9 || eVar.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = eVar.j();
            if (!this.C && eVar.e0() && j.J() != null) {
                j.r0(null);
            }
            postData = j;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.f52682a.v4()) {
            if (eVar.D().size() > 0 && (postData2 = eVar.D().get(0)) != null && postData2.z() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int B = B(this.x, arrayList, this.C);
            if (B >= 0) {
                ListUtils.add(arrayList, B, this.x.B());
            }
        }
        int C = C(this.x, arrayList, this.C);
        if (C >= 0) {
            ListUtils.add(arrayList, C, this.x.C());
        }
        d.b.i0.c3.v.f(arrayList, 1);
        int z10 = z(eVar, arrayList);
        if (z10 >= 0) {
            Q(eVar, arrayList, z10);
            z4 = true;
        } else {
            z4 = false;
        }
        int t = t(eVar, arrayList);
        List<d.b.b.j.e.n> u = u(eVar);
        if (!ListUtils.isEmpty(u) && t >= 0) {
            d.b.b.j.e.n nVar2 = (d.b.b.j.e.n) ListUtils.getItem(arrayList, t);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).R = true;
            }
            ListUtils.addAll(arrayList, t, u);
            z4 = true;
        }
        int E = z9 ? E(eVar, arrayList, this.C) : -1;
        if (E < 0 || eVar.O() == null) {
            if (postData != null) {
                postData.Q = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, E, eVar.O());
            z5 = true;
            z6 = true;
        }
        boolean z11 = O(eVar, postData, arrayList, E) != null;
        if (z11) {
            E++;
        }
        if (!z11 && N(eVar, arrayList, E) != null) {
            E++;
        }
        if (L(eVar, arrayList, E) != null) {
            E++;
        }
        if (z9) {
            d.b.b.j.e.n R = R(arrayList, E);
            boolean z12 = R != null;
            if (z12) {
                z8 = z12;
                nVar = R;
                i4 = -1;
            } else {
                i4 = E >= 0 ? E + 1 : t >= 0 ? t : z10 >= 0 ? z10 : -1;
                nVar = J(arrayList, i4);
                z8 = nVar != null;
            }
            boolean z13 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z13) {
                this.W = i4;
                if (M(arrayList, i4) != null) {
                    this.W = -1;
                    E++;
                }
            }
            if (d.b.h0.b.d.A() && z13) {
                i = E;
                z7 = z8;
                wVar = null;
            } else {
                w P = P(arrayList, nVar, E, i4);
                if (P != null) {
                    if (!z8) {
                        i2 = i4;
                        wVar = P;
                        i = E;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        E++;
                    }
                }
                wVar = P;
                i = E;
                z7 = z8;
            }
            i2 = i4;
        } else {
            i = E;
            z7 = false;
            wVar = null;
            i2 = -1;
        }
        if (z9) {
            w wVar2 = wVar;
            list = u;
            i3 = t;
            boolean K = K(eVar, arrayList, z7, wVar != null, i2, i, t, z10);
            if (wVar2 != null) {
                wVar2.r = K;
            }
        } else {
            list = u;
            i3 = t;
        }
        this.f52684c.F0(!z5);
        boolean p0 = p0(postData);
        if (this.D && !p0) {
            arrayList.remove(postData);
            this.D = false;
        }
        if (eVar.O() != null) {
            eVar.O().l(!z6);
        }
        BdTypeListView bdTypeListView = this.f52683b;
        if (bdTypeListView != null) {
            this.z = arrayList;
            bdTypeListView.setData(arrayList);
        }
        X(p0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            this.f52683b.setData(arrayList);
        }
    }

    public void a0(boolean z) {
        this.A = z;
        this.f52684c.setFromCDN(z);
        d.b.b.j.e.a aVar = this.n;
        if (aVar != null && (aVar instanceof d.b.i0.r2.p)) {
            ((d.b.i0.r2.p) aVar).c(z);
        }
        Iterator<d.b.i0.c2.k.c.a> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void b0(boolean z) {
        this.D = z;
    }

    public void c0(boolean z) {
        this.B = z;
    }

    public void d0(boolean z) {
        this.H = z;
    }

    public void e0(boolean z) {
        this.E = z;
    }

    public void f0(boolean z) {
        this.F = z;
    }

    public void g0(boolean z) {
        this.C = z;
    }

    public void h0(boolean z) {
        this.G = z;
    }

    public void i0(boolean z) {
        k kVar = this.j;
        if (kVar != null) {
            kVar.W0(z);
        }
    }

    public void j0(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void k0(TbRichTextView.w wVar) {
        this.N = wVar;
    }

    public final void l(d.b.i0.c3.h0.o oVar) {
        ForumData l;
        if (oVar == null || this.x == null || oVar.B0() == null) {
            return;
        }
        oVar.B0().advertAppContext = new d.b.h0.r.q.d();
        if (this.x.w() != null) {
            oVar.B0().advertAppContext.f50750b = this.x.w().a();
        }
        oVar.B0().advertAppContext.f50749a = oVar.C0();
        if (this.x.l() != null && (l = this.x.l()) != null) {
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

    public void l0(View.OnLongClickListener onLongClickListener) {
        this.P = onLongClickListener;
    }

    public final void m() {
        if (this.f52682a == null || n()) {
            return;
        }
        this.f52682a.registerListener(this.c0);
    }

    public void m0(SortSwitchButton.f fVar) {
        this.Q = fVar;
    }

    public final boolean n() {
        if (this.f52682a == null) {
            return false;
        }
        this.d0 = new ArrayList();
        ArrayList<BdUniqueId> g2 = d.b.i0.c3.v.g();
        if (g2 == null || g2.size() <= 0) {
            return false;
        }
        int size = g2.size();
        for (int i = 0; i < size; i++) {
            d.b.i0.i1.o.g.a c2 = d.b.i0.i1.r.b.d().c(this.f52682a.getPageContext(), g2.get(i), 2);
            if (c2 != null) {
                this.R.add(c2);
                this.d0.add(c2);
            }
        }
        if (ListUtils.isEmpty(this.d0)) {
            return true;
        }
        this.f52683b.a(this.d0);
        return true;
    }

    public void n0(View.OnClickListener onClickListener) {
        this.M = onClickListener;
    }

    public final void o(List<d.b.b.j.e.n> list) {
        int size;
        if (list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.G())) {
                    d.b.h0.r.q.n0 n0Var = new d.b.h0.r.q.n0();
                    n0Var.n(postData.G());
                    list.set(i, n0Var);
                }
            }
        }
    }

    public void o0(d.b.i0.c2.i.c cVar) {
        this.O = cVar;
    }

    public final PostData p(ArrayList<d.b.b.j.e.n> arrayList) {
        Iterator<d.b.b.j.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.b.j.e.n next = it.next();
            if (next instanceof PostData) {
                PostData postData = (PostData) next;
                if (postData.z() == 1) {
                    return postData;
                }
            }
        }
        return null;
    }

    public final boolean p0(PostData postData) {
        return (this.f52682a.L() == null || postData == null || postData.D() == null || !postData.D().equals(this.f52682a.L().S0())) ? false : true;
    }

    public final boolean q(PostData postData, ArrayList<d.b.b.j.e.n> arrayList, boolean z) {
        if (postData != null) {
            if (z) {
                ListUtils.add(arrayList, 0, postData);
                return true;
            }
            return false;
        }
        PostData postData2 = this.K;
        if (postData2 != null && !this.E) {
            ListUtils.add(arrayList, 0, postData2);
        } else {
            PostData postData3 = new PostData();
            postData3.g0(1);
            ListUtils.add(arrayList, 0, postData3);
        }
        return true;
    }

    public final void q0() {
        d.b.i0.c3.h0.o oVar;
        d.b.i0.c3.h0.o oVar2;
        d.b.i0.c2.h.e eVar = this.x;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<d.b.i0.c3.h0.o> e2 = this.x.e();
        if (d.b.i0.i1.o.k.a.e(D) || d.b.i0.i1.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<d.b.i0.c3.h0.o> it = e2.iterator();
        while (it.hasNext()) {
            d.b.i0.c3.h0.o next = it.next();
            if (next != null && next.A0() != null) {
                sb.append(next.A0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<d.b.i0.c3.h0.o> it2 = e2.iterator();
        while (it2.hasNext()) {
            d.b.i0.c3.h0.o next2 = it2.next();
            if (next2 != null) {
                next2.z0 = sb.toString();
                next2.L0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<d.b.i0.c3.h0.o> it3 = e2.iterator();
        while (it3.hasNext()) {
            d.b.i0.c3.h0.o next3 = it3.next();
            if (next3.B0() != null) {
                int u = next3.B0().u();
                if (u != 0) {
                    d.b.i0.r2.b0.d.h(next3, u);
                    if (u != 28 && u != 31) {
                        if (next3.B0().goods != null) {
                            next3.B0().goods.goods_style = -1001;
                        }
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            d.b.i0.c3.h0.o oVar3 = (d.b.i0.c3.h0.o) sparseArray.valueAt(i);
            if (oVar3 != null && (oVar2 = (d.b.i0.c3.h0.o) hashMap.put(oVar3.A0(), oVar3)) != null) {
                d.b.i0.r2.b0.d.h(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (d.b.i0.c3.h0.o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            d.b.i0.i1.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < d.b.i0.i1.o.k.a.j(arrayList); i3++) {
            d.b.i0.c3.h0.o oVar4 = (d.b.i0.c3.h0.o) sparseArray.get(((Integer) d.b.i0.i1.o.k.a.d(arrayList, i3)).intValue());
            if (this.x.l() != null) {
                oVar4.A0 = this.x.l().getId();
            }
            if (this.x.L() != null) {
                oVar4.D0 = d.b.b.e.m.b.f(this.x.L().o0(), 0L);
            }
            d.b.i0.c2.h.e eVar2 = this.x;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.E0 = this.x.w().a();
            }
            l(oVar4);
            int position = oVar4.getPosition() + this.x.X;
            if (position >= d.b.i0.i1.o.k.a.j(D)) {
                oVar4.L0 = position;
                d.b.i0.r2.b0.d.i(oVar4, 2, position, d.b.i0.i1.o.k.a.j(D));
                return;
            }
            if (!this.C) {
                position--;
                oVar4.L0 = position;
            }
            if (position < 0) {
                d.b.i0.r2.b0.d.h(oVar4, 23);
            } else {
                d.b.i0.i1.o.k.a.b(D, oVar4, position);
                TiebaStatic.eventStat(this.f52682a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, DpStatConstants.KEY_APP_NAME, oVar4.B0().apk_name);
            }
        }
    }

    public ArrayList<d.b.b.j.e.n> r() {
        return this.z;
    }

    public void r0() {
        int i = this.W;
        if (i <= 0 || M(this.z, i) == null) {
            return;
        }
        this.W = -1;
        this.f52683b.setData(this.z);
        U();
    }

    public PbFirstFloorViewHolder s() {
        q qVar = this.f52684c;
        if (qVar == null || qVar.x0() == null) {
            return null;
        }
        return this.f52684c.x0();
    }

    public final int t(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList) {
        boolean z;
        if (this.E || eVar == null || ListUtils.isEmpty(eVar.D()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.e0() && this.C) ? 0 : -1;
        } else if (this.f52682a.L() == null || !this.f52682a.L().i0()) {
            if (this.f52682a.G4() == null || !this.f52682a.G4().r0()) {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    d.b.b.j.e.n nVar = arrayList.get(i);
                    if (nVar instanceof PostData) {
                        PostData postData = (PostData) nVar;
                        if (postData.z() == 1 && postData.O == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
                return !z ? eVar.e0() ? 0 : -1 : i + 1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    public final List<d.b.b.j.e.n> u(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.P() == null || ListUtils.isEmpty(eVar.P().f52471a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.P().f52471a;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.c0 = true;
                postData.P = true;
                arrayList.add(postData);
            }
        }
        if (ListUtils.getCount(eVar.P().f52472b) > 2) {
            d.b.b.j.e.n nVar = (d.b.b.j.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).P = false;
            }
            arrayList.add(new d.b.i0.c2.n.b());
        } else {
            d.b.b.j.e.n nVar2 = (d.b.b.j.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).P = true;
            }
        }
        d.b.i0.c2.h.o oVar = new d.b.i0.c2.h.o(d.b.i0.c2.h.o.m);
        oVar.f52454e = eVar.P().f52473c;
        arrayList.add(0, oVar);
        return arrayList;
    }

    public int v() {
        return this.f52683b.getHeaderViewsCount();
    }

    public d.b.b.j.e.n w(int i) {
        return this.f52683b.G(i);
    }

    public BdUniqueId x(int i) {
        if (this.f52683b.G(i) != null) {
            return this.f52683b.G(i).getType();
        }
        return null;
    }

    public PbFirstFloorCommentAndPraiseAdapter y() {
        return this.f52685d;
    }

    public final int z(d.b.i0.c2.h.e eVar, ArrayList<d.b.b.j.e.n> arrayList) {
        boolean z;
        if (eVar == null || ListUtils.isEmpty(eVar.D()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(eVar.D(), 0)) == null) {
            return 0;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                i = 0;
                break;
            }
            d.b.b.j.e.n nVar = arrayList.get(i);
            if (nVar instanceof PostData) {
                PostData postData = (PostData) nVar;
                if (postData.z() == 1 && postData.O == 0) {
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (z) {
            return i + 1;
        }
        return 0;
    }
}
