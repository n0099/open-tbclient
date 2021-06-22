package d.a.o0.e2.k.e;

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
import d.a.n0.r.q.a2;
import d.a.n0.r.q.d1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class i {
    public boolean F;
    public boolean G;
    public int I;
    public Runnable T;
    public int V;
    public a2 X;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57164a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57165b;

    /* renamed from: c  reason: collision with root package name */
    public s f57166c;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f57167d;
    public List<d.a.c.k.e.a> d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f57168e;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f57169f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.e2.k.e.z0.a f57170g;

    /* renamed from: h  reason: collision with root package name */
    public n0 f57171h;

    /* renamed from: i  reason: collision with root package name */
    public n0 f57172i;
    public m j;
    public d.a.o0.e2.n.a k;
    public d.a.o0.z.f0.a l;
    public d.a.c.k.e.a m;
    public d.a.c.k.e.a n;
    public d.a.c.k.e.a o;
    public d.a.c.k.e.a p;
    public k0 q;
    public l0 r;
    public j0 s;
    public PbReplyLoadMoreAdapter t;
    public j v;
    public x w;
    public d.a.o0.e2.h.e x;
    public ArrayList<d.a.c.k.e.n> z;
    public ArrayList<d.a.o0.e2.k.c.a> u = new ArrayList<>();
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
    public d.a.o0.e2.i.c O = null;
    public View.OnLongClickListener P = null;
    public SortSwitchButton.f Q = null;
    public final List<d.a.c.k.e.a> R = new ArrayList();
    public final List<d.a.c.k.e.a> S = new ArrayList();
    public int U = -1;
    public int W = -1;
    public final CustomMessageListener Y = new a(2921523);
    public CustomMessageListener Z = new b(2004015);
    public final CustomMessageListener a0 = new c(2001118);
    public final View.OnClickListener b0 = new d();
    public CustomMessageListener c0 = new f(2016470);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.o0.e3.h0.n)) {
                return;
            }
            d.a.o0.e3.h0.n nVar = (d.a.o0.e3.h0.n) customResponsedMessage.getData();
            if (i.this.X == null || i.this.X.F2 != nVar) {
                return;
            }
            i.this.X.F2.m(true);
            i.this.f57165b.setData(i.this.z);
            i.this.U();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof d.a.o0.e3.h0.d)) {
                AbsDelegateAdapterList a2 = ((d.a.o0.e3.h0.d) customResponsedMessage.getData()).a();
                Iterator<d.a.c.k.e.a<?, ?>> it = a2.iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof o) {
                        ((o) next).g0(i.this.f57164a);
                        if (next instanceof d.a.o0.e2.k.c.a) {
                            i.this.u.add((d.a.o0.e2.k.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                i.this.S.clear();
                i.this.S.addAll(arrayList);
                if (i.this.f57165b != null) {
                    i.this.f57165b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {

        /* loaded from: classes5.dex */
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
            if (customResponsedMessage == null || i.this.x == null || d.a.c.a.j.c(i.this.f57164a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.f57164a == null || i.this.x == null || i.this.x.Q() == null) {
                return;
            }
            i.this.f57164a.N4().D0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f57178e;

        public e(List list) {
            this.f57178e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f57165b.setSelectionFromTop(i.this.f57165b.getHeaderViewsCount() + this.f57178e.size(), 0 - i.this.V);
            i.this.G = false;
        }
    }

    /* loaded from: classes5.dex */
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
        this.f57164a = pbFragment;
        this.f57165b = bdTypeListView;
        H(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.a0);
        this.V = d.a.c.e.p.l.i(this.f57164a.getContext()) / 3;
    }

    public int A() {
        BdTypeListView bdTypeListView = this.f57165b;
        if (bdTypeListView == null || bdTypeListView.getData() == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.f57165b.getData().size(); i2++) {
            d.a.c.k.e.n nVar = this.f57165b.getData().get(i2);
            if (nVar != null && nVar.getType() == d.a.o0.e2.h.o.l) {
                return i2;
            }
        }
        return -1;
    }

    public int B(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
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

    public int C(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
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

    public final int E(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
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
        s sVar = this.f57166c;
        if (sVar == null || sVar.y0() == null) {
            return null;
        }
        if (this.f57166c.y0().s != null && this.f57166c.y0().s.isShown()) {
            return this.f57166c.y0().s;
        }
        return this.f57166c.y0().r;
    }

    public void H(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        s sVar = new s(pbFragment, PostData.t0);
        this.f57166c = sVar;
        sVar.I0(pbFragment);
        this.f57167d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, d.a.o0.e2.h.p.j);
        this.f57168e = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), d.a.o0.e2.h.g.l);
        this.f57169f = new PbFirstFloorItemAdapter(pbFragment.getContext(), d.a.o0.e2.h.h.f56747g);
        this.f57170g = new d.a.o0.e2.k.e.z0.a(pbFragment, d.a.o0.e2.h.a.f56718g);
        this.f57171h = new n0(pbFragment, d.a.o0.e2.h.o.l);
        this.f57172i = new n0(pbFragment, d.a.o0.e2.h.o.m);
        m mVar = new m(pbFragment, PostData.u0);
        this.j = mVar;
        mVar.Z0(pbFragment);
        this.m = d.a.o0.t2.x.p().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.e4);
        this.n = d.a.o0.t2.x.p().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.g4);
        this.o = d.a.o0.s0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.p = d.a.o0.s0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.n4);
        this.s = new j0(pbFragment, d.a.o0.e2.h.l.I0);
        this.q = new k0(pbFragment, i0.F0);
        this.r = new l0(pbFragment, d1.L0);
        this.t = new PbReplyLoadMoreAdapter(pbFragment, PostData.A0);
        this.k = new d.a.o0.e2.n.a(pbFragment, d.a.o0.e2.n.b.f57489e);
        this.l = new d.a.o0.z.f0.a(pbFragment.getPageContext());
        this.v = new j(pbFragment, d.a.n0.r.q.p.N3);
        this.w = new x(pbFragment, pbFragment.getUniqueId());
        this.R.add(this.f57166c);
        this.R.add(this.f57167d);
        this.R.add(this.f57168e);
        this.R.add(this.f57169f);
        this.R.add(this.f57170g);
        this.R.add(this.j);
        this.R.add(this.f57171h);
        this.R.add(this.f57172i);
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
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new d.a.o0.e3.h0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.a(this.R);
    }

    public final void I(@NonNull d.a.o0.e2.h.e eVar) {
        this.f57166c.t(eVar);
        this.f57166c.setFromCDN(this.A);
        this.f57166c.n(this.I);
        this.f57166c.c(this.B);
        this.f57166c.e(this.M);
        this.f57166c.m(this.L);
        this.f57166c.p(this.N);
        this.f57166c.d(this.P);
        this.f57166c.H0(this.O);
        this.j.t(eVar);
        this.j.setFromCDN(this.A);
        this.j.q(this.J);
        this.j.c(this.B);
        this.j.e(this.M);
        this.j.m(this.L);
        this.j.p(this.N);
        this.j.d(this.P);
        this.j.Y0(this.O);
        this.f57167d.t0(this.M);
        this.t.j0(this.M);
        this.k.j0(this.b0);
        d.a.c.k.e.a aVar = this.n;
        if (aVar != null && (aVar instanceof d.a.o0.t2.t)) {
            ((d.a.o0.t2.t) aVar).k(this.A);
        }
        Iterator<d.a.o0.e2.k.c.a> it = this.u.iterator();
        while (it.hasNext()) {
            d.a.o0.e2.k.c.a next = it.next();
            if (next != null) {
                next.t(eVar);
                next.setFromCDN(this.A);
                next.q(this.J);
                next.n(this.I);
                next.c(this.B);
                next.f(this.C);
                next.s(this.H);
                next.e(this.M);
                next.m(this.L);
                next.p(this.N);
                next.d(this.P);
            }
        }
        this.f57171h.e(this.M);
        this.f57171h.l0(this.Q);
        this.f57172i.e(this.M);
        this.f57171h.t(eVar);
        this.f57170g.t(eVar);
        this.f57172i.t(eVar);
        this.q.t(eVar);
        this.r.t(eVar);
        this.v.l0(eVar);
        this.v.k0(this.f57164a.m1);
        this.w.j0(eVar);
    }

    public final d.a.c.k.e.n J(ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        if (this.x == null) {
            return null;
        }
        d.a.o0.e3.h0.o Y = this.f57164a.A().Y();
        if (Y == null) {
            Y = this.x.x();
        }
        if (Y == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert F0 = Y.F0();
        if (F0 != null) {
            F0.setAdvertAppInfo(Y.getAdvertAppInfo());
        }
        int I4 = Y.getAdvertAppInfo().I4();
        if (I4 != 0) {
            d.a.o0.t2.i0.d.i(Y, I4);
            if (I4 != 28 && I4 != 31) {
                Y.getAdvertAppInfo().L3 = -1001;
            }
            return null;
        }
        if (this.x.l() != null) {
            Y.E0 = this.x.l().getId();
        }
        if (this.x.L() != null) {
            Y.H0 = d.a.c.e.m.b.f(this.x.L().o0(), 0L);
        }
        d.a.o0.e2.h.e eVar = this.x;
        if (eVar != null && eVar.w() != null) {
            Y.I0 = this.x.w().a();
        }
        l(Y);
        if (i2 >= 0) {
            d.a.o0.k1.o.k.a.b(arrayList, Y, i2);
            return Y;
        }
        return null;
    }

    public final boolean K(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(eVar.f()) && eVar.f().size() > 2) {
            int min = Math.min(eVar.f().size(), 7);
            for (int i6 = 0; i6 < min; i6++) {
                d.a.n0.r.q.p pVar = eVar.f().get(i6);
                if (!z2 && i6 == 0) {
                    pVar.I4(true);
                }
                if (pVar.x1() == null) {
                    if (i6 == min - 1) {
                        pVar.K4(true);
                    }
                } else if (i6 == min - 2) {
                    pVar.K4(true);
                } else if (i6 == min - 1) {
                    pVar.J4(true);
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

    public final d.a.c.k.e.n L(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        d.a.o0.e2.h.a aVar;
        if (i2 < 0 || eVar == null || !eVar.k || (aVar = eVar.l) == null) {
            return null;
        }
        ListUtils.add(arrayList, i2, aVar);
        return aVar;
    }

    public final d.a.c.k.e.n M(ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        if (d.a.n0.b.d.B() && i2 > 0) {
            String d2 = d.a.o0.s0.d.c.e().d("pb_banner");
            if (this.X == null && d.a.o0.s0.a.h().k(d2)) {
                a2 a2Var = new a2();
                this.X = a2Var;
                a2Var.F2 = new d.a.o0.e3.h0.n();
                d.a.o0.e2.h.e eVar = this.x;
                if (eVar != null) {
                    this.X.F2.j(eVar.m());
                    this.X.F2.n(this.x.N());
                }
            }
            a2 a2Var2 = this.X;
            if (a2Var2 != null && a2Var2.F2 != null) {
                ListUtils.add(arrayList, i2, a2Var2);
            }
        }
        return this.X;
    }

    public final d.a.c.k.e.n N(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        d.a.o0.e2.h.g gVar;
        if (eVar.l() == null || StringUtils.isNull(eVar.l().getName())) {
            return null;
        }
        if (TextUtils.equals(eVar.l().getName(), this.f57164a.A().e0()) && this.f57164a.A().i0()) {
            return null;
        }
        if (!this.f57164a.isSimpleForum() && !ListUtils.isEmpty(eVar.p())) {
            gVar = new d.a.o0.e2.h.g(eVar.p().get(0));
        } else {
            gVar = new d.a.o0.e2.h.g(eVar.l());
        }
        gVar.k = this.f57164a.A().S0();
        ListUtils.add(arrayList, i2 + 1, gVar);
        return gVar;
    }

    public final d.a.c.k.e.n O(d.a.o0.e2.h.e eVar, PostData postData, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        d.a.o0.e2.h.h hVar = null;
        if (eVar.l() == null || StringUtils.isNull(eVar.l().getName()) || !TextUtils.equals(eVar.l().getName(), this.f57164a.A().e0()) || !this.f57164a.A().i0()) {
            if (postData != null) {
                if (postData.p0 != null) {
                    hVar = new d.a.o0.e2.h.h(postData.p0);
                }
            } else {
                PostData postData2 = this.K;
                if (postData2 != null && postData2.p0 != null) {
                    hVar = new d.a.o0.e2.h.h(this.K.p0);
                }
            }
            if (hVar != null) {
                hVar.f56749f = this.f57164a.A().S0();
                ListUtils.add(arrayList, i2 + 1, hVar);
            }
            return hVar;
        }
        return null;
    }

    public final y P(ArrayList<d.a.c.k.e.n> arrayList, d.a.c.k.e.n nVar, int i2, int i3) {
        y z = this.x.z();
        if (z != null) {
            if (nVar != null) {
                if (i3 >= 0 || nVar.getType() == AdvertAppInfo.g4) {
                    i3 = nVar.getType() != AdvertAppInfo.g4 ? i3 + 1 : -1;
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

    public final void Q(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        d.a.o0.e2.h.o oVar = new d.a.o0.e2.h.o(d.a.o0.e2.h.o.l);
        a2 L = eVar.L();
        if (L != null) {
            L.b1();
        }
        oVar.f56772h = this.f57164a.f5();
        oVar.f56771g = eVar.f56739g;
        eVar.c();
        oVar.f56773i = eVar.a0();
        oVar.k = eVar.f56738f;
        ListUtils.add(arrayList, i2, oVar);
        if (eVar.I() == 4) {
            ListUtils.add(arrayList, i2 + 1, new d.a.o0.e2.h.n());
        }
    }

    public final d.a.c.k.e.n R(ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        PbModel A;
        if (i2 < 0 || (A = this.f57164a.A()) == null || TextUtils.isEmpty(A.G0())) {
            return null;
        }
        d.a.o0.e3.h0.o oVar = new d.a.o0.e3.h0.o();
        l(oVar);
        ListUtils.add(arrayList, i2 + 1, oVar);
        return oVar;
    }

    public boolean S() {
        return this.A;
    }

    public boolean T() {
        return this.B;
    }

    public void U() {
        this.U = A();
        if (this.f57165b.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f57165b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void V(int i2) {
        if (i2 == 1) {
            s sVar = this.f57166c;
            if (sVar != null) {
                sVar.C0();
            }
            d.a.c.k.e.a aVar = this.n;
            if (aVar instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) aVar).onPause();
            }
            d.a.c.k.e.a aVar2 = this.o;
            if (aVar2 instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) aVar2).onPause();
            }
            n.a().h(this.f57164a.B());
        } else if (i2 == 2) {
            s sVar2 = this.f57166c;
            if (sVar2 != null) {
                sVar2.E0();
            }
            d.a.c.k.e.a aVar3 = this.n;
            if (aVar3 instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) aVar3).onResume();
            }
            d.a.c.k.e.a aVar4 = this.o;
            if (aVar4 instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) aVar4).onResume();
            }
            Y(false);
        } else if (i2 != 3) {
        } else {
            s sVar3 = this.f57166c;
            if (sVar3 != null) {
                sVar3.D0();
            }
            d.a.c.k.e.a aVar5 = this.n;
            if (aVar5 instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) aVar5).onDestroy();
            }
            d.a.c.k.e.a aVar6 = this.o;
            if (aVar6 instanceof d.a.o0.t2.p) {
                ((d.a.o0.t2.p) aVar6).onDestroy();
            }
            n.a().c();
        }
    }

    public void W() {
        d.a.c.e.m.e.a().removeCallbacks(this.T);
        n0 n0Var = this.f57171h;
        if (n0Var != null) {
            n0Var.onDestroy();
        }
        n0 n0Var2 = this.f57172i;
        if (n0Var2 != null) {
            n0Var2.onDestroy();
        }
        PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f57167d;
        if (pbFirstFloorCommentAndPraiseAdapter != null) {
            pbFirstFloorCommentAndPraiseAdapter.onDestroy();
        }
        d.a.o0.e2.k.e.z0.a aVar = this.f57170g;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    public final void X(boolean z, boolean z2, int i2, List<d.a.c.k.e.n> list) {
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
        if (this.f57164a.N4() == null || this.f57164a.B() == null || this.f57164a.B().getPbModel() == null) {
            return;
        }
        n.a().f(this.f57164a.B().getPbModel().b1(), this.f57171h.i0(), this.f57164a.N4().H0(), this.f57164a.B().getPageStayDurationItem(), z);
    }

    public void Z(d.a.o0.e2.h.e eVar, boolean z) {
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
        List<d.a.c.k.e.n> list;
        int i4;
        boolean z8;
        d.a.c.k.e.n nVar;
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
        d.a.o0.e2.h.e eVar2 = this.x;
        if (eVar2 != null && eVar2.D() != null && this.x.D().size() > 0) {
            this.y.addAll(this.x.D());
        }
        if (eVar.L() != null && eVar.L().T() != null) {
            this.J = eVar.L().T().getUserId();
        }
        if (this.f57166c == null) {
            return;
        }
        I(eVar);
        ArrayList<d.a.c.k.e.n> arrayList = new ArrayList<>(eVar.D());
        if (d.a.n0.c1.b.e.d()) {
            this.f57165b.setData(arrayList.subList(0, 1));
            this.f57166c.G0(false);
            return;
        }
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
        if (this.f57164a.C4()) {
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
        d.a.o0.e3.v.f(arrayList, 1);
        int z10 = z(eVar, arrayList);
        if (z10 >= 0) {
            Q(eVar, arrayList, z10);
            z4 = true;
        } else {
            z4 = false;
        }
        int t = t(eVar, arrayList);
        List<d.a.c.k.e.n> u = u(eVar);
        if (!ListUtils.isEmpty(u) && t >= 0) {
            d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(arrayList, t);
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
            d.a.c.k.e.n R = R(arrayList, E);
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
            if (d.a.n0.b.d.B() && z13) {
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
        this.f57166c.G0(!z5);
        boolean p0 = p0(postData);
        if (this.D && !p0) {
            arrayList.remove(postData);
            this.D = false;
        }
        if (eVar.P() != null) {
            eVar.P().k(!z6);
        }
        if (this.f57165b != null) {
            this.z = arrayList;
            List<d.a.c.k.e.n> O = eVar.O();
            if (!ListUtils.isEmpty(O)) {
                ArrayList arrayList2 = new ArrayList(arrayList.size() + O.size() + 2);
                arrayList2.addAll(arrayList);
                d.a.o0.e2.h.j jVar = new d.a.o0.e2.h.j();
                jVar.f56753e = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                arrayList2.add(jVar);
                d.a.o0.z.f0.e eVar3 = new d.a.o0.z.f0.e();
                eVar3.f67342e = TbadkCoreApplication.getInst().getString(R.string.hot_recommendation);
                eVar3.needTopMargin = false;
                arrayList2.add(eVar3);
                arrayList2.addAll(O);
                this.f57165b.setData(arrayList2);
            } else {
                this.f57165b.setData(this.z);
            }
        }
        X(p0, z, i4, list);
        if (q(postData, arrayList, z3)) {
            this.f57165b.setData(arrayList);
        }
    }

    public void a0(boolean z) {
        this.A = z;
        this.f57166c.setFromCDN(z);
        d.a.c.k.e.a aVar = this.n;
        if (aVar != null && (aVar instanceof d.a.o0.t2.t)) {
            ((d.a.o0.t2.t) aVar).k(z);
        }
        Iterator<d.a.o0.e2.k.c.a> it = this.u.iterator();
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
            mVar.X0(z);
        }
    }

    public void j0(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void k0(TbRichTextView.x xVar) {
        this.N = xVar;
    }

    public final void l(d.a.o0.e3.h0.o oVar) {
        ForumData l;
        if (oVar == null || this.x == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().S3 = new d.a.n0.r.q.d();
        if (this.x.w() != null) {
            oVar.getAdvertAppInfo().S3.f53763b = this.x.w().a();
        }
        oVar.getAdvertAppInfo().S3.f53762a = oVar.E0();
        if (this.x.l() != null && (l = this.x.l()) != null) {
            oVar.getAdvertAppInfo().S3.f53765d = l.getId();
            oVar.getAdvertAppInfo().S3.f53766e = l.getFirst_class();
            oVar.getAdvertAppInfo().S3.f53767f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().S3.f53768g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().S3.f53769h = oVar.getAdvertAppInfo().Q3;
        oVar.getAdvertAppInfo().S3.f53770i = false;
    }

    public void l0(View.OnLongClickListener onLongClickListener) {
        this.P = onLongClickListener;
    }

    public final void m() {
        if (this.f57164a == null || n()) {
            return;
        }
        this.f57164a.registerListener(this.c0);
    }

    public void m0(SortSwitchButton.f fVar) {
        this.Q = fVar;
    }

    public final boolean n() {
        if (this.f57164a == null) {
            return false;
        }
        this.d0 = new ArrayList();
        ArrayList<BdUniqueId> g2 = d.a.o0.e3.v.g();
        if (g2 == null || g2.size() <= 0) {
            return false;
        }
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            d.a.o0.k1.o.g.a b2 = d.a.o0.k1.r.b.d().b(this.f57164a.getPageContext(), g2.get(i2), 2);
            if (b2 != null) {
                this.R.add(b2);
                this.d0.add(b2);
            }
        }
        if (ListUtils.isEmpty(this.d0)) {
            return true;
        }
        this.f57165b.a(this.d0);
        return true;
    }

    public void n0(View.OnClickListener onClickListener) {
        this.M = onClickListener;
    }

    public final void o(List<d.a.c.k.e.n> list) {
        int size;
        if (list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof PostData) {
                PostData postData = (PostData) list.get(i2);
                if (!TextUtils.isEmpty(postData.H())) {
                    d.a.n0.r.q.n0 n0Var = new d.a.n0.r.q.n0();
                    n0Var.i(postData.H());
                    list.set(i2, n0Var);
                }
            }
        }
    }

    public void o0(d.a.o0.e2.i.c cVar) {
        this.O = cVar;
    }

    public final PostData p(ArrayList<d.a.c.k.e.n> arrayList) {
        Iterator<d.a.c.k.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
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
        return (this.f57164a.A() == null || postData == null || postData.E() == null || !postData.E().equals(this.f57164a.A().W0())) ? false : true;
    }

    public final boolean q(PostData postData, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
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
        d.a.o0.e3.h0.o oVar;
        d.a.o0.e3.h0.o oVar2;
        d.a.o0.e2.h.e eVar = this.x;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<d.a.o0.e3.h0.o> e2 = this.x.e();
        if (d.a.o0.k1.o.k.a.e(D) || d.a.o0.k1.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<d.a.o0.e3.h0.o> it = e2.iterator();
        while (it.hasNext()) {
            d.a.o0.e3.h0.o next = it.next();
            if (next != null && next.D0() != null) {
                sb.append(next.D0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<d.a.o0.e3.h0.o> it2 = e2.iterator();
        while (it2.hasNext()) {
            d.a.o0.e3.h0.o next2 = it2.next();
            if (next2 != null) {
                next2.K0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<d.a.o0.e3.h0.o> it3 = e2.iterator();
        while (it3.hasNext()) {
            d.a.o0.e3.h0.o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int I4 = next3.getAdvertAppInfo().I4();
                if (I4 != 0) {
                    d.a.o0.t2.i0.d.i(next3, I4);
                    if (I4 != 28 && I4 != 31) {
                        next3.getAdvertAppInfo().L3 = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            d.a.o0.e3.h0.o oVar3 = (d.a.o0.e3.h0.o) sparseArray.valueAt(i2);
            if (oVar3 != null && (oVar2 = (d.a.o0.e3.h0.o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.o0.t2.i0.d.i(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (d.a.o0.e3.h0.o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            d.a.o0.k1.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < d.a.o0.k1.o.k.a.k(arrayList); i4++) {
            d.a.o0.e3.h0.o oVar4 = (d.a.o0.e3.h0.o) sparseArray.get(((Integer) d.a.o0.k1.o.k.a.d(arrayList, i4)).intValue());
            if (this.x.l() != null) {
                oVar4.E0 = this.x.l().getId();
            }
            if (this.x.L() != null) {
                oVar4.H0 = d.a.c.e.m.b.f(this.x.L().o0(), 0L);
            }
            d.a.o0.e2.h.e eVar2 = this.x;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.I0 = this.x.w().a();
            }
            l(oVar4);
            int position = oVar4.getPosition() + this.x.X;
            if (position >= d.a.o0.k1.o.k.a.k(D)) {
                oVar4.K0 = position;
                d.a.o0.t2.i0.d.j(oVar4, 2, position, d.a.o0.k1.o.k.a.k(D));
                return;
            }
            if (!this.C) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.o0.t2.i0.d.i(oVar4, 23);
            } else {
                d.a.o0.k1.o.k.a.b(D, oVar4, position);
                TiebaStatic.eventStat(this.f57164a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().b4);
            }
        }
    }

    public ArrayList<d.a.c.k.e.n> r() {
        return this.z;
    }

    public void r0() {
        int i2 = this.W;
        if (i2 <= 0 || M(this.z, i2) == null) {
            return;
        }
        this.W = -1;
        this.f57165b.setData(this.z);
        U();
    }

    public PbFirstFloorViewHolder s() {
        s sVar = this.f57166c;
        if (sVar == null || sVar.y0() == null) {
            return null;
        }
        return this.f57166c.y0();
    }

    public final int t(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList) {
        boolean z;
        if (this.E || eVar == null || ListUtils.isEmpty(eVar.D()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.f0() && this.C) ? 0 : -1;
        } else if (this.f57164a.A() == null || !this.f57164a.A().m0()) {
            if (this.f57164a.N4() == null || !this.f57164a.N4().z0()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i2 = -1;
                        break;
                    }
                    d.a.c.k.e.n nVar = arrayList.get(i2);
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

    public final List<d.a.c.k.e.n> u(d.a.o0.e2.h.e eVar) {
        if (eVar == null || eVar.Q() == null || ListUtils.isEmpty(eVar.Q().f56790a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.Q().f56790a;
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
        if (ListUtils.getCount(eVar.Q().f56791b) > 2) {
            d.a.c.k.e.n nVar = (d.a.c.k.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).P = false;
            }
            arrayList.add(new d.a.o0.e2.n.b());
        } else {
            d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).P = true;
            }
        }
        d.a.o0.e2.h.o oVar = new d.a.o0.e2.h.o(d.a.o0.e2.h.o.m);
        oVar.f56769e = eVar.Q().f56792c;
        arrayList.add(0, oVar);
        return arrayList;
    }

    public int v() {
        return this.f57165b.getHeaderViewsCount();
    }

    public d.a.c.k.e.n w(int i2) {
        return this.f57165b.G(i2);
    }

    public BdUniqueId x(int i2) {
        if (this.f57165b.G(i2) != null) {
            return this.f57165b.G(i2).getType();
        }
        return null;
    }

    public PbFirstFloorCommentAndPraiseAdapter y() {
        return this.f57167d;
    }

    public final int z(d.a.o0.e2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList) {
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
            d.a.c.k.e.n nVar = arrayList.get(i2);
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
