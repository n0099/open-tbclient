package d.a.j0.d2.k.e;

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
import com.baidu.tieba.R;
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
import d.a.i0.r.q.a2;
import d.a.i0.r.q.d1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class i {
    public boolean F;
    public boolean G;
    public int I;
    public Runnable T;
    public int V;
    public a2 X;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52395a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f52396b;

    /* renamed from: c  reason: collision with root package name */
    public s f52397c;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f52398d;
    public List<d.a.c.j.e.a> d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f52399e;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f52400f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.d2.k.e.y0.a f52401g;

    /* renamed from: h  reason: collision with root package name */
    public n0 f52402h;

    /* renamed from: i  reason: collision with root package name */
    public n0 f52403i;
    public m j;
    public d.a.j0.d2.n.a k;
    public d.a.j0.x.f0.a l;
    public d.a.c.j.e.a m;
    public d.a.c.j.e.a n;
    public d.a.c.j.e.a o;
    public d.a.c.j.e.a p;
    public k0 q;
    public l0 r;
    public j0 s;
    public PbReplyLoadMoreAdapter t;
    public j v;
    public x w;
    public d.a.j0.d2.h.e x;
    public ArrayList<d.a.c.j.e.n> z;
    public ArrayList<d.a.j0.d2.k.c.a> u = new ArrayList<>();
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
    public TbRichTextView.x N = null;
    public d.a.j0.d2.i.c O = null;
    public View.OnLongClickListener P = null;
    public SortSwitchButton.f Q = null;
    public final List<d.a.c.j.e.a> R = new ArrayList();
    public final List<d.a.c.j.e.a> S = new ArrayList();
    public int U = -1;
    public int W = -1;
    public final CustomMessageListener Y = new a(2921523);
    public CustomMessageListener Z = new b(2004015);
    public final CustomMessageListener a0 = new c(2001118);
    public final View.OnClickListener b0 = new d();
    public CustomMessageListener c0 = new f(2016470);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.h0.n)) {
                return;
            }
            d.a.j0.d3.h0.n nVar = (d.a.j0.d3.h0.n) customResponsedMessage.getData();
            if (i.this.X == null || i.this.X.C2 != nVar) {
                return;
            }
            i.this.X.C2.m(true);
            i.this.f52396b.setData(i.this.z);
            i.this.U();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof d.a.j0.d3.h0.d)) {
                AbsDelegateAdapterList a2 = ((d.a.j0.d3.h0.d) customResponsedMessage.getData()).a();
                Iterator<d.a.c.j.e.a<?, ?>> it = a2.iterator();
                while (it.hasNext()) {
                    d.a.c.j.e.a<?, ?> next = it.next();
                    if (next instanceof o) {
                        ((o) next).f0(i.this.f52395a);
                        if (next instanceof d.a.j0.d2.k.c.a) {
                            i.this.u.add((d.a.j0.d2.k.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                i.this.S.clear();
                i.this.S.addAll(arrayList);
                if (i.this.f52396b != null) {
                    i.this.f52396b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.U();
            }
        }

        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            if (customResponsedMessage == null || i.this.x == null || d.a.c.a.j.c(i.this.f52395a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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
                d.a.c.e.m.e.a().postDelayed(new a(), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.f52395a == null || i.this.x == null || i.this.x.Q() == null) {
                return;
            }
            i.this.f52395a.J4().C0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f52409e;

        public e(List list) {
            this.f52409e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f52396b.setSelectionFromTop(i.this.f52396b.getHeaderViewsCount() + this.f52409e.size(), 0 - i.this.V);
            i.this.G = false;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ListUtils.isEmpty(i.this.d0)) {
                i.this.n();
                i iVar = i.this;
                iVar.Z(iVar.x, false);
            }
        }
    }

    public i(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.I = 0;
        this.V = 0;
        this.I = d.a.c.e.p.l.k(pbFragment.getPageContext().getPageActivity());
        this.f52395a = pbFragment;
        this.f52396b = bdTypeListView;
        H(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.a0);
        this.V = d.a.c.e.p.l.i(this.f52395a.getContext()) / 3;
    }

    public int A() {
        BdTypeListView bdTypeListView = this.f52396b;
        if (bdTypeListView == null || bdTypeListView.getData() == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.f52396b.getData().size(); i2++) {
            d.a.c.j.e.n nVar = this.f52396b.getData().get(i2);
            if (nVar != null && nVar.getType() == d.a.j0.d2.h.o.l) {
                return i2;
            }
        }
        return -1;
    }

    public int B(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList, boolean z) {
        if (eVar == null || eVar.D() == null || eVar.B() == null || eVar.D().size() == 0 || eVar.L() == null || arrayList == null || !eVar.B().C0()) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (eVar.D().get(0) == null || eVar.D().get(0).A() != 1) ? -1 : 1;
        } else if (size == 0) {
            return 0;
        } else {
            return (eVar.w() == null || eVar.w().a() != eVar.w().h()) ? -1 : 0;
        }
    }

    public int C(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList, boolean z) {
        if (eVar == null || eVar.D() == null || eVar.C() == null || eVar.D().size() == 0 || eVar.L() == null || arrayList == null || !eVar.C().C0()) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (eVar.D().get(0) == null || eVar.D().get(0).A() != 1) ? -1 : 1;
        } else if (size == 0) {
            return 0;
        } else {
            return (eVar.w() == null || eVar.w().a() != eVar.w().h()) ? -1 : 0;
        }
    }

    public ArrayList<PostData> D() {
        return this.y;
    }

    public final int E(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList, boolean z) {
        if (eVar == null || ListUtils.isEmpty(eVar.D()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.f0()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.D().get(0) == null || eVar.D().get(0).A() != 1) ? -1 : 1;
        }
        return 0;
    }

    public int F() {
        return this.U;
    }

    public View G() {
        s sVar = this.f52397c;
        if (sVar == null || sVar.x0() == null) {
            return null;
        }
        if (this.f52397c.x0().s != null && this.f52397c.x0().s.isShown()) {
            return this.f52397c.x0().s;
        }
        return this.f52397c.x0().r;
    }

    public void H(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        s sVar = new s(pbFragment, PostData.o0);
        this.f52397c = sVar;
        sVar.H0(pbFragment);
        this.f52398d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, d.a.j0.d2.h.p.j);
        this.f52399e = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), d.a.j0.d2.h.g.l);
        this.f52400f = new PbFirstFloorItemAdapter(pbFragment.getContext(), d.a.j0.d2.h.h.f52029g);
        this.f52401g = new d.a.j0.d2.k.e.y0.a(pbFragment, d.a.j0.d2.h.a.f52000g);
        this.f52402h = new n0(pbFragment, d.a.j0.d2.h.o.l);
        this.f52403i = new n0(pbFragment, d.a.j0.d2.h.o.m);
        m mVar = new m(pbFragment, PostData.p0);
        this.j = mVar;
        mVar.Y0(pbFragment);
        this.m = d.a.j0.s2.w.p().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.n = d.a.j0.s2.w.p().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.o = d.a.j0.r0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.l4);
        this.p = d.a.j0.r0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.s = new j0(pbFragment, d.a.j0.d2.h.l.D0);
        this.q = new k0(pbFragment, i0.A0);
        this.r = new l0(pbFragment, d1.L0);
        this.t = new PbReplyLoadMoreAdapter(pbFragment, PostData.v0);
        this.k = new d.a.j0.d2.n.a(pbFragment, d.a.j0.d2.n.b.f52762e);
        this.l = new d.a.j0.x.f0.a(pbFragment.getPageContext());
        this.v = new j(pbFragment, d.a.i0.r.q.p.I3);
        this.w = new x(pbFragment, pbFragment.getUniqueId());
        this.R.add(this.f52397c);
        this.R.add(this.f52398d);
        this.R.add(this.f52399e);
        this.R.add(this.f52400f);
        this.R.add(this.f52401g);
        this.R.add(this.j);
        this.R.add(this.f52402h);
        this.R.add(this.f52403i);
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
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new d.a.j0.d3.h0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.a(this.R);
    }

    public final void I(@NonNull d.a.j0.d2.h.e eVar) {
        this.f52397c.s(eVar);
        this.f52397c.setFromCDN(this.A);
        this.f52397c.m(this.I);
        this.f52397c.c(this.B);
        this.f52397c.e(this.M);
        this.f52397c.l(this.L);
        this.f52397c.o(this.N);
        this.f52397c.d(this.P);
        this.f52397c.G0(this.O);
        this.j.s(eVar);
        this.j.setFromCDN(this.A);
        this.j.p(this.J);
        this.j.c(this.B);
        this.j.e(this.M);
        this.j.l(this.L);
        this.j.o(this.N);
        this.j.d(this.P);
        this.j.X0(this.O);
        this.f52398d.t0(this.M);
        this.t.i0(this.M);
        this.k.i0(this.b0);
        d.a.c.j.e.a aVar = this.n;
        if (aVar != null && (aVar instanceof d.a.j0.s2.s)) {
            ((d.a.j0.s2.s) aVar).j(this.A);
        }
        Iterator<d.a.j0.d2.k.c.a> it = this.u.iterator();
        while (it.hasNext()) {
            d.a.j0.d2.k.c.a next = it.next();
            if (next != null) {
                next.s(eVar);
                next.setFromCDN(this.A);
                next.p(this.J);
                next.m(this.I);
                next.c(this.B);
                next.f(this.C);
                next.r(this.H);
                next.e(this.M);
                next.l(this.L);
                next.o(this.N);
                next.d(this.P);
            }
        }
        this.f52402h.e(this.M);
        this.f52402h.m0(this.Q);
        this.f52403i.e(this.M);
        this.f52402h.s(eVar);
        this.f52401g.s(eVar);
        this.f52403i.s(eVar);
        this.q.s(eVar);
        this.r.s(eVar);
        this.v.m0(eVar);
        this.v.j0(this.f52395a.m1);
        this.w.i0(eVar);
    }

    public final d.a.c.j.e.n J(ArrayList<d.a.c.j.e.n> arrayList, int i2) {
        if (this.x == null) {
            return null;
        }
        d.a.j0.d3.h0.o U = this.f52395a.z().U();
        if (U == null) {
            U = this.x.x();
        }
        if (U == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert F0 = U.F0();
        if (F0 != null) {
            F0.setAdvertAppInfo(U.L0());
        }
        int u = U.D0().u();
        if (u != 0) {
            d.a.j0.s2.h0.d.i(U, u);
            if (u != 28 && u != 31 && U.D0().goods != null) {
                U.D0().goods.goods_style = -1001;
            }
            return null;
        }
        if (this.x.l() != null) {
            U.B0 = this.x.l().getId();
        }
        if (this.x.L() != null) {
            U.E0 = d.a.c.e.m.b.f(this.x.L().o0(), 0L);
        }
        d.a.j0.d2.h.e eVar = this.x;
        if (eVar != null && eVar.w() != null) {
            U.K0 = this.x.w().a();
        }
        l(U);
        if (i2 >= 0) {
            d.a.j0.j1.o.k.a.b(arrayList, U, i2);
            return U;
        }
        return null;
    }

    public final boolean K(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList, boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(eVar.f()) && eVar.f().size() > 2) {
            int min = Math.min(eVar.f().size(), 7);
            for (int i6 = 0; i6 < min; i6++) {
                d.a.i0.r.q.p pVar = eVar.f().get(i6);
                if (!z2 && i6 == 0) {
                    pVar.E4(true);
                }
                if (pVar.u1() == null) {
                    if (i6 == min - 1) {
                        pVar.G4(true);
                    }
                } else if (i6 == min - 2) {
                    pVar.G4(true);
                } else if (i6 == min - 1) {
                    pVar.F4(true);
                }
                arrayList2.add(pVar);
            }
        }
        if (arrayList2.size() > 0) {
            int i7 = (!z || i2 < 0) ? z ? i3 + 2 : i3 >= 0 ? i3 + 1 : i4 >= 0 ? i4 : i5 >= 0 ? i5 : -1 : i2 + 1;
            if (i7 >= 0 && arrayList2.size() > 1) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ListUtils.add(arrayList, i7, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    public final d.a.c.j.e.n L(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList, int i2) {
        d.a.j0.d2.h.a aVar;
        if (i2 < 0 || eVar == null || !eVar.k || (aVar = eVar.l) == null) {
            return null;
        }
        ListUtils.add(arrayList, i2, aVar);
        return aVar;
    }

    public final d.a.c.j.e.n M(ArrayList<d.a.c.j.e.n> arrayList, int i2) {
        if (d.a.i0.b.d.B() && i2 > 0) {
            String d2 = d.a.j0.r0.d.c.e().d("pb_banner");
            if (this.X == null && d.a.j0.r0.a.h().k(d2)) {
                a2 a2Var = new a2();
                this.X = a2Var;
                a2Var.C2 = new d.a.j0.d3.h0.n();
                d.a.j0.d2.h.e eVar = this.x;
                if (eVar != null) {
                    this.X.C2.j(eVar.m());
                    this.X.C2.n(this.x.N());
                }
            }
            a2 a2Var2 = this.X;
            if (a2Var2 != null && a2Var2.C2 != null) {
                ListUtils.add(arrayList, i2, a2Var2);
            }
        }
        return this.X;
    }

    public final d.a.c.j.e.n N(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList, int i2) {
        d.a.j0.d2.h.g gVar;
        if (eVar.l() == null || StringUtils.isNull(eVar.l().getName())) {
            return null;
        }
        if (TextUtils.equals(eVar.l().getName(), this.f52395a.z().a0()) && this.f52395a.z().e0()) {
            return null;
        }
        if (!this.f52395a.isSimpleForum() && !ListUtils.isEmpty(eVar.p())) {
            gVar = new d.a.j0.d2.h.g(eVar.p().get(0));
        } else {
            gVar = new d.a.j0.d2.h.g(eVar.l());
        }
        gVar.k = this.f52395a.z().O0();
        ListUtils.add(arrayList, i2 + 1, gVar);
        return gVar;
    }

    public final d.a.c.j.e.n O(d.a.j0.d2.h.e eVar, PostData postData, ArrayList<d.a.c.j.e.n> arrayList, int i2) {
        d.a.j0.d2.h.h hVar = null;
        if (eVar.l() == null || StringUtils.isNull(eVar.l().getName()) || !TextUtils.equals(eVar.l().getName(), this.f52395a.z().a0()) || !this.f52395a.z().e0()) {
            if (postData != null) {
                if (postData.k0 != null) {
                    hVar = new d.a.j0.d2.h.h(postData.k0);
                }
            } else {
                PostData postData2 = this.K;
                if (postData2 != null && postData2.k0 != null) {
                    hVar = new d.a.j0.d2.h.h(this.K.k0);
                }
            }
            if (hVar != null) {
                hVar.f52031f = this.f52395a.z().O0();
                ListUtils.add(arrayList, i2 + 1, hVar);
            }
            return hVar;
        }
        return null;
    }

    public final y P(ArrayList<d.a.c.j.e.n> arrayList, d.a.c.j.e.n nVar, int i2, int i3) {
        y z = this.x.z();
        if (z != null) {
            if (nVar != null) {
                if (i3 >= 0 || nVar.getType() == AdvertAppInfo.k4) {
                    i3 = nVar.getType() != AdvertAppInfo.k4 ? i3 + 1 : -1;
                } else {
                    i3 = i2 + 2;
                }
            }
            if (i3 <= 0 || !(z instanceof y)) {
                return null;
            }
            ListUtils.add(arrayList, i3, z);
            return z;
        }
        return null;
    }

    public final void Q(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList, int i2) {
        d.a.j0.d2.h.o oVar = new d.a.j0.d2.h.o(d.a.j0.d2.h.o.l);
        a2 L = eVar.L();
        if (L != null) {
            L.Z0();
        }
        oVar.f52054h = this.f52395a.b5();
        oVar.f52053g = eVar.f52021g;
        eVar.c();
        oVar.f52055i = eVar.a0();
        oVar.k = eVar.f52020f;
        ListUtils.add(arrayList, i2, oVar);
        if (eVar.I() == 4) {
            ListUtils.add(arrayList, i2 + 1, new d.a.j0.d2.h.n());
        }
    }

    public final d.a.c.j.e.n R(ArrayList<d.a.c.j.e.n> arrayList, int i2) {
        PbModel z;
        if (i2 >= 0 && (z = this.f52395a.z()) != null) {
            String C0 = z.C0();
            if (TextUtils.isEmpty(C0)) {
                return null;
            }
            d.a.j0.d3.h0.o oVar = new d.a.j0.d3.h0.o();
            oVar.J0(C0);
            l(oVar);
            ListUtils.add(arrayList, i2 + 1, oVar);
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
        if (this.f52396b.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f52396b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void V(int i2) {
        if (i2 == 1) {
            s sVar = this.f52397c;
            if (sVar != null) {
                sVar.B0();
            }
            d.a.c.j.e.a aVar = this.n;
            if (aVar instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) aVar).onPause();
            }
            d.a.c.j.e.a aVar2 = this.o;
            if (aVar2 instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) aVar2).onPause();
            }
            n.a().h(this.f52395a.A());
        } else if (i2 == 2) {
            s sVar2 = this.f52397c;
            if (sVar2 != null) {
                sVar2.D0();
            }
            d.a.c.j.e.a aVar3 = this.n;
            if (aVar3 instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) aVar3).onResume();
            }
            d.a.c.j.e.a aVar4 = this.o;
            if (aVar4 instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) aVar4).onResume();
            }
            Y(false);
        } else if (i2 != 3) {
        } else {
            s sVar3 = this.f52397c;
            if (sVar3 != null) {
                sVar3.C0();
            }
            d.a.c.j.e.a aVar5 = this.n;
            if (aVar5 instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) aVar5).onDestroy();
            }
            d.a.c.j.e.a aVar6 = this.o;
            if (aVar6 instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) aVar6).onDestroy();
            }
            n.a().c();
        }
    }

    public void W() {
        d.a.c.e.m.e.a().removeCallbacks(this.T);
        n0 n0Var = this.f52402h;
        if (n0Var != null) {
            n0Var.onDestroy();
        }
        n0 n0Var2 = this.f52403i;
        if (n0Var2 != null) {
            n0Var2.onDestroy();
        }
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f52398d;
        if (pbFirstFloorCommentAndPraiseAdapter != null) {
            pbFirstFloorCommentAndPraiseAdapter.onDestroy();
        }
        d.a.j0.d2.k.e.y0.a aVar = this.f52401g;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    public final void X(boolean z, boolean z2, int i2, List<d.a.c.j.e.n> list) {
        if (z || z2) {
            return;
        }
        if ((!this.F && !this.E) || i2 == -1 || ListUtils.isEmpty(list) || this.G) {
            return;
        }
        this.T = new e(list);
        d.a.c.e.m.e.a().post(this.T);
    }

    public void Y(boolean z) {
        if (this.f52395a.J4() == null || this.f52395a.A() == null || this.f52395a.A().getPbModel() == null) {
            return;
        }
        n.a().f(this.f52395a.A().getPbModel().Y0(), this.f52402h.h0(), this.f52395a.J4().G0(), this.f52395a.A().getPageStayDurationItem(), z);
    }

    public void Z(d.a.j0.d2.h.e eVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        boolean z7;
        y yVar;
        int i3;
        List<d.a.c.j.e.n> list;
        int i4;
        boolean z8;
        d.a.c.j.e.n nVar;
        int i5;
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
        d.a.j0.d2.h.e eVar2 = this.x;
        if (eVar2 != null && eVar2.D() != null && this.x.D().size() > 0) {
            this.y.addAll(this.x.D());
        }
        if (eVar.L() != null && eVar.L().T() != null) {
            this.J = eVar.L().T().getUserId();
        }
        if (this.f52397c == null) {
            return;
        }
        I(eVar);
        ArrayList<d.a.c.j.e.n> arrayList = new ArrayList<>(eVar.D());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (p != null) {
            this.K = p;
        }
        if (this.C || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (eVar.f0() && p.K() != null) {
                p.t0(null);
            }
            z9 = true;
            z2 = true;
        }
        if (z9 || eVar.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = eVar.j();
            if (!this.C && eVar.f0() && j.K() != null) {
                j.t0(null);
            }
            postData = j;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.f52395a.y4()) {
            if (eVar.D().size() > 0 && (postData2 = eVar.D().get(0)) != null && postData2.A() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        d.a.j0.d3.v.f(arrayList, 1);
        int z10 = z(eVar, arrayList);
        if (z10 >= 0) {
            Q(eVar, arrayList, z10);
            z4 = true;
        } else {
            z4 = false;
        }
        int t = t(eVar, arrayList);
        List<d.a.c.j.e.n> u = u(eVar);
        if (!ListUtils.isEmpty(u) && t >= 0) {
            d.a.c.j.e.n nVar2 = (d.a.c.j.e.n) ListUtils.getItem(arrayList, t);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).R = true;
            }
            ListUtils.addAll(arrayList, t, u);
            z4 = true;
        }
        int E = z9 ? E(eVar, arrayList, this.C) : -1;
        if (E < 0 || eVar.P() == null) {
            if (postData != null) {
                postData.Q = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, E, eVar.P());
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
            d.a.c.j.e.n R = R(arrayList, E);
            boolean z12 = R != null;
            if (z12) {
                z8 = z12;
                nVar = R;
                i5 = -1;
            } else {
                i5 = E >= 0 ? E + 1 : t >= 0 ? t : z10 >= 0 ? z10 : -1;
                nVar = J(arrayList, i5);
                z8 = nVar != null;
            }
            boolean z13 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z13) {
                this.W = i5;
                if (M(arrayList, i5) != null) {
                    this.W = -1;
                    E++;
                }
            }
            if (d.a.i0.b.d.B() && z13) {
                i2 = E;
                z7 = z8;
                yVar = null;
            } else {
                y P = P(arrayList, nVar, E, i5);
                if (P != null) {
                    if (!z8) {
                        i3 = i5;
                        yVar = P;
                        i2 = E;
                        z7 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        E++;
                    }
                }
                yVar = P;
                i2 = E;
                z7 = z8;
            }
            i3 = i5;
        } else {
            i2 = E;
            z7 = false;
            yVar = null;
            i3 = -1;
        }
        if (z9) {
            y yVar2 = yVar;
            list = u;
            i4 = t;
            boolean K = K(eVar, arrayList, z7, yVar != null, i3, i2, t, z10);
            if (yVar2 != null) {
                yVar2.r = K;
            }
        } else {
            list = u;
            i4 = t;
        }
        this.f52397c.F0(!z5);
        boolean p0 = p0(postData);
        if (this.D && !p0) {
            arrayList.remove(postData);
            this.D = false;
        }
        if (eVar.P() != null) {
            eVar.P().l(!z6);
        }
        if (this.f52396b != null) {
            this.z = arrayList;
            List<d.a.c.j.e.n> O = eVar.O();
            if (!ListUtils.isEmpty(O)) {
                ArrayList arrayList2 = new ArrayList(arrayList.size() + O.size() + 2);
                arrayList2.addAll(arrayList);
                d.a.j0.d2.h.j jVar = new d.a.j0.d2.h.j();
                jVar.f52035e = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                arrayList2.add(jVar);
                d.a.j0.x.f0.e eVar3 = new d.a.j0.x.f0.e();
                eVar3.f62495e = TbadkCoreApplication.getInst().getString(R.string.hot_recommendation);
                eVar3.needTopMargin = false;
                arrayList2.add(eVar3);
                arrayList2.addAll(O);
                this.f52396b.setData(arrayList2);
            } else {
                this.f52396b.setData(this.z);
            }
        }
        X(p0, z, i4, list);
        if (q(postData, arrayList, z3)) {
            this.f52396b.setData(arrayList);
        }
    }

    public void a0(boolean z) {
        this.A = z;
        this.f52397c.setFromCDN(z);
        d.a.c.j.e.a aVar = this.n;
        if (aVar != null && (aVar instanceof d.a.j0.s2.s)) {
            ((d.a.j0.s2.s) aVar).j(z);
        }
        Iterator<d.a.j0.d2.k.c.a> it = this.u.iterator();
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
        m mVar = this.j;
        if (mVar != null) {
            mVar.W0(z);
        }
    }

    public void j0(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void k0(TbRichTextView.x xVar) {
        this.N = xVar;
    }

    public final void l(d.a.j0.d3.h0.o oVar) {
        ForumData l;
        if (oVar == null || this.x == null || oVar.D0() == null) {
            return;
        }
        oVar.D0().advertAppContext = new d.a.i0.r.q.d();
        if (this.x.w() != null) {
            oVar.D0().advertAppContext.f49117b = this.x.w().a();
        }
        oVar.D0().advertAppContext.f49116a = oVar.E0();
        if (this.x.l() != null && (l = this.x.l()) != null) {
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

    public void l0(View.OnLongClickListener onLongClickListener) {
        this.P = onLongClickListener;
    }

    public final void m() {
        if (this.f52395a == null || n()) {
            return;
        }
        this.f52395a.registerListener(this.c0);
    }

    public void m0(SortSwitchButton.f fVar) {
        this.Q = fVar;
    }

    public final boolean n() {
        if (this.f52395a == null) {
            return false;
        }
        this.d0 = new ArrayList();
        ArrayList<BdUniqueId> g2 = d.a.j0.d3.v.g();
        if (g2 == null || g2.size() <= 0) {
            return false;
        }
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            d.a.j0.j1.o.g.a b2 = d.a.j0.j1.r.b.d().b(this.f52395a.getPageContext(), g2.get(i2), 2);
            if (b2 != null) {
                this.R.add(b2);
                this.d0.add(b2);
            }
        }
        if (ListUtils.isEmpty(this.d0)) {
            return true;
        }
        this.f52396b.a(this.d0);
        return true;
    }

    public void n0(View.OnClickListener onClickListener) {
        this.M = onClickListener;
    }

    public final void o(List<d.a.c.j.e.n> list) {
        int size;
        if (list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof PostData) {
                PostData postData = (PostData) list.get(i2);
                if (!TextUtils.isEmpty(postData.H())) {
                    d.a.i0.r.q.n0 n0Var = new d.a.i0.r.q.n0();
                    n0Var.m(postData.H());
                    list.set(i2, n0Var);
                }
            }
        }
    }

    public void o0(d.a.j0.d2.i.c cVar) {
        this.O = cVar;
    }

    public final PostData p(ArrayList<d.a.c.j.e.n> arrayList) {
        Iterator<d.a.c.j.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.n next = it.next();
            if (next instanceof PostData) {
                PostData postData = (PostData) next;
                if (postData.A() == 1) {
                    return postData;
                }
            }
        }
        return null;
    }

    public final boolean p0(PostData postData) {
        return (this.f52395a.z() == null || postData == null || postData.E() == null || !postData.E().equals(this.f52395a.z().S0())) ? false : true;
    }

    public final boolean q(PostData postData, ArrayList<d.a.c.j.e.n> arrayList, boolean z) {
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
            postData3.i0(1);
            ListUtils.add(arrayList, 0, postData3);
        }
        return true;
    }

    public final void q0() {
        d.a.j0.d3.h0.o oVar;
        d.a.j0.d3.h0.o oVar2;
        d.a.j0.d2.h.e eVar = this.x;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<d.a.j0.d3.h0.o> e2 = this.x.e();
        if (d.a.j0.j1.o.k.a.e(D) || d.a.j0.j1.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<d.a.j0.d3.h0.o> it = e2.iterator();
        while (it.hasNext()) {
            d.a.j0.d3.h0.o next = it.next();
            if (next != null && next.C0() != null) {
                sb.append(next.C0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<d.a.j0.d3.h0.o> it2 = e2.iterator();
        while (it2.hasNext()) {
            d.a.j0.d3.h0.o next2 = it2.next();
            if (next2 != null) {
                next2.A0 = sb.toString();
                next2.M0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<d.a.j0.d3.h0.o> it3 = e2.iterator();
        while (it3.hasNext()) {
            d.a.j0.d3.h0.o next3 = it3.next();
            if (next3.D0() != null) {
                int u = next3.D0().u();
                if (u != 0) {
                    d.a.j0.s2.h0.d.i(next3, u);
                    if (u != 28 && u != 31) {
                        if (next3.D0().goods != null) {
                            next3.D0().goods.goods_style = -1001;
                        }
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            d.a.j0.d3.h0.o oVar3 = (d.a.j0.d3.h0.o) sparseArray.valueAt(i2);
            if (oVar3 != null && (oVar2 = (d.a.j0.d3.h0.o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.j0.s2.h0.d.i(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (d.a.j0.d3.h0.o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            d.a.j0.j1.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < d.a.j0.j1.o.k.a.k(arrayList); i4++) {
            d.a.j0.d3.h0.o oVar4 = (d.a.j0.d3.h0.o) sparseArray.get(((Integer) d.a.j0.j1.o.k.a.d(arrayList, i4)).intValue());
            if (this.x.l() != null) {
                oVar4.B0 = this.x.l().getId();
            }
            if (this.x.L() != null) {
                oVar4.E0 = d.a.c.e.m.b.f(this.x.L().o0(), 0L);
            }
            d.a.j0.d2.h.e eVar2 = this.x;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.K0 = this.x.w().a();
            }
            l(oVar4);
            int position = oVar4.getPosition() + this.x.X;
            if (position >= d.a.j0.j1.o.k.a.k(D)) {
                oVar4.M0 = position;
                d.a.j0.s2.h0.d.j(oVar4, 2, position, d.a.j0.j1.o.k.a.k(D));
                return;
            }
            if (!this.C) {
                position--;
                oVar4.M0 = position;
            }
            if (position < 0) {
                d.a.j0.s2.h0.d.i(oVar4, 23);
            } else {
                d.a.j0.j1.o.k.a.b(D, oVar4, position);
                TiebaStatic.eventStat(this.f52395a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, DpStatConstants.KEY_APP_NAME, oVar4.D0().apk_name);
            }
        }
    }

    public ArrayList<d.a.c.j.e.n> r() {
        return this.z;
    }

    public void r0() {
        int i2 = this.W;
        if (i2 <= 0 || M(this.z, i2) == null) {
            return;
        }
        this.W = -1;
        this.f52396b.setData(this.z);
        U();
    }

    public PbFirstFloorViewHolder s() {
        s sVar = this.f52397c;
        if (sVar == null || sVar.x0() == null) {
            return null;
        }
        return this.f52397c.x0();
    }

    public final int t(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList) {
        boolean z;
        if (this.E || eVar == null || ListUtils.isEmpty(eVar.D()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.f0() && this.C) ? 0 : -1;
        } else if (this.f52395a.z() == null || !this.f52395a.z().i0()) {
            if (this.f52395a.J4() == null || !this.f52395a.J4().y0()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i2 = -1;
                        break;
                    }
                    d.a.c.j.e.n nVar = arrayList.get(i2);
                    if (nVar instanceof PostData) {
                        PostData postData = (PostData) nVar;
                        if (postData.A() == 1 && postData.O == 0) {
                            z = true;
                            break;
                        }
                    }
                    i2++;
                }
                return !z ? eVar.f0() ? 0 : -1 : i2 + 1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    public final List<d.a.c.j.e.n> u(d.a.j0.d2.h.e eVar) {
        if (eVar == null || eVar.Q() == null || ListUtils.isEmpty(eVar.Q().f52071a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.Q().f52071a;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i2 = 0; i2 < min; i2++) {
            PostData postData = list.get(i2);
            if (postData != null) {
                postData.c0 = true;
                postData.P = true;
                arrayList.add(postData);
            }
        }
        if (ListUtils.getCount(eVar.Q().f52072b) > 2) {
            d.a.c.j.e.n nVar = (d.a.c.j.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).P = false;
            }
            arrayList.add(new d.a.j0.d2.n.b());
        } else {
            d.a.c.j.e.n nVar2 = (d.a.c.j.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).P = true;
            }
        }
        d.a.j0.d2.h.o oVar = new d.a.j0.d2.h.o(d.a.j0.d2.h.o.m);
        oVar.f52051e = eVar.Q().f52073c;
        arrayList.add(0, oVar);
        return arrayList;
    }

    public int v() {
        return this.f52396b.getHeaderViewsCount();
    }

    public d.a.c.j.e.n w(int i2) {
        return this.f52396b.G(i2);
    }

    public BdUniqueId x(int i2) {
        if (this.f52396b.G(i2) != null) {
            return this.f52396b.G(i2).getType();
        }
        return null;
    }

    public PbFirstFloorCommentAndPraiseAdapter y() {
        return this.f52398d;
    }

    public final int z(d.a.j0.d2.h.e eVar, ArrayList<d.a.c.j.e.n> arrayList) {
        boolean z;
        if (eVar == null || ListUtils.isEmpty(eVar.D()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(eVar.D(), 0)) == null) {
            return 0;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = false;
                i2 = 0;
                break;
            }
            d.a.c.j.e.n nVar = arrayList.get(i2);
            if (nVar instanceof PostData) {
                PostData postData = (PostData) nVar;
                if (postData.A() == 1 && postData.O == 0) {
                    z = true;
                    break;
                }
            }
            i2++;
        }
        if (z) {
            return i2 + 1;
        }
        return 0;
    }
}
