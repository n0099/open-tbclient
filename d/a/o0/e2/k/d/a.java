package d.a.o0.e2.k.d;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.k.e.n;
import d.a.o0.e2.k.e.e0;
import d.a.o0.e2.k.e.m;
import d.a.o0.e2.k.e.t0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements d.a.n0.k0.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f56849e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f56850f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.e2.k.d.d f56851g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.e2.k.d.c f56852h;

    /* renamed from: i  reason: collision with root package name */
    public t0 f56853i;
    public m j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.x m;
    public View.OnLongClickListener n;
    public d.a.o0.e2.i.c o;
    public final MoreGodReplyModel p;
    public d.a.n0.k0.d q;
    public long r;
    public BdListView.p s = new C1316a();
    public AbsListView.OnScrollListener t = new b();
    public e0.b u = new c();
    public PbFragment.p2 v = new h();

    /* renamed from: d.a.o0.e2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1316a implements BdListView.p {
        public C1316a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.p.G()) {
                return;
            }
            a.this.p.H();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsListView.OnScrollListener {

        /* renamed from: e  reason: collision with root package name */
        public int f56855e = -1;

        public b() {
        }

        public final boolean a(int i2) {
            return i2 == 2 || i2 == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            PbFragment pbFragment;
            if (!a(this.f56855e) && a(i2) && (pbFragment = a.this.f56850f) != null && pbFragment.N4() != null) {
                a.this.f56850f.N4().h2();
                a.this.f56850f.N4().W0();
            }
            this.f56855e = i2;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements e0.b {
        public c() {
        }

        @Override // d.a.o0.e2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            a.this.f56853i.r3(str);
        }

        @Override // d.a.o0.e2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            a.this.x();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f56858e;

        public d(Runnable runnable) {
            this.f56858e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f56851g.i();
            a.this.f56849e = false;
            PbFragment pbFragment = a.this.f56850f;
            if (pbFragment != null) {
                if (pbFragment.N4() != null) {
                    a.this.f56850f.N4().V2(false);
                    d.a.o0.e2.k.e.i l0 = a.this.f56850f.N4().l0();
                    l0.Z(a.this.f56850f.A().C0(), true);
                    l0.U();
                }
                a aVar = a.this;
                aVar.f56850f.G5(aVar.v);
            }
            Runnable runnable = this.f56858e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.p.G()) {
                return;
            }
            a.this.p.H();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements PbFragment.p2 {
        public h() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.p2
        public boolean onBackPressed() {
            a.this.h();
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f56852h.g(false);
        }
    }

    public a(PbFragment pbFragment, t0 t0Var, ViewStub viewStub) {
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.A());
        this.p = moreGodReplyModel;
        moreGodReplyModel.I(this.u);
        this.f56853i = t0Var;
        this.f56850f = pbFragment;
        this.f56851g = new d.a.o0.e2.k.d.d(pbFragment, viewStub);
        this.f56852h = new d.a.o0.e2.k.d.c(this);
    }

    @Override // d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // d.a.n0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        PbFragment pbFragment = this.f56850f;
        if (pbFragment == null) {
            return null;
        }
        return pbFragment.getNextPageSourceKeyList();
    }

    @Override // d.a.n0.k0.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (ListUtils.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.addAll(arrayList2);
        }
        if (getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
            if (!StringUtils.isNull(currentPageKey)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(currentPageKey);
            }
            return arrayList;
        }
        return arrayList;
    }

    @Override // d.a.n0.k0.a
    public d.a.n0.k0.b getPageStayFilter() {
        return null;
    }

    public void h() {
        i(null);
    }

    public void i(Runnable runnable) {
        this.p.cancelLoadData();
        this.f56850f.Y4();
        if (!l() && runnable != null) {
            runnable.run();
            return;
        }
        if (l() && !this.f56852h.e()) {
            this.f56851g.r(new d(runnable));
        }
        if (this.r != 0) {
            d.a.n0.k0.d j = j();
            j.v(System.currentTimeMillis() - this.r);
            d.a.n0.k0.e.b().i(this.f56850f.getContext(), j, getPageStayFilter());
        }
    }

    public d.a.n0.k0.d j() {
        if (this.q == null) {
            d.a.n0.k0.d dVar = new d.a.n0.k0.d();
            this.q = dVar;
            dVar.u(getCurrentPageSourceKeyList());
            this.q.p(getCurrentPageKey());
            PbModel A = this.f56850f.A();
            if (A != null) {
                this.q.q(d.a.c.e.m.b.f(A.getForumId(), 0L));
                this.q.y(d.a.c.e.m.b.f(A.S0(), 0L));
            }
        }
        return this.q;
    }

    public d.a.o0.e2.k.d.d k() {
        return this.f56851g;
    }

    public boolean l() {
        return this.f56849e;
    }

    public void m(int i2) {
        this.f56851g.o(i2);
    }

    public void n() {
        if (l()) {
            x();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void q(TbRichTextView.x xVar) {
        this.m = xVar;
    }

    public void r(View.OnLongClickListener onLongClickListener) {
        this.n = onLongClickListener;
    }

    public void s(d.a.o0.e2.i.c cVar) {
        this.o = cVar;
    }

    public final void t(BdTypeListView bdTypeListView) {
        if (this.j == null) {
            m mVar = new m(this.f56850f, PostData.u0);
            this.j = mVar;
            mVar.V0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.j);
            bdTypeListView.a(arrayList);
        }
    }

    public final void u() {
        boolean m = this.f56851g.m();
        this.f56851g.p();
        if (!m) {
            this.f56851g.d().setOnClickListener(new e());
            this.f56851g.c().setOnClickListener(new f());
            this.f56851g.f().z(new g());
            this.f56851g.e().setOnScrollListener(this.t);
        }
        this.r = System.currentTimeMillis();
    }

    public void v() {
        if (!l()) {
            this.f56850f.Y4();
            this.f56849e = true;
            this.f56852h.h(false);
            this.f56852h.g(true);
            u();
            x();
            this.f56851g.q(new i());
            this.f56850f.S3(this.v);
            this.p.H();
        }
        this.f56850f.N4().W0();
    }

    public final void w(d.a.o0.e2.h.e eVar) {
        this.j.t(eVar);
        d.a.o0.e2.k.e.i l0 = this.f56853i.l0();
        this.j.setFromCDN(l0.S());
        this.j.q(eVar.L().T().getUserId());
        this.j.c(l0.T());
        this.j.e(this.k);
        this.j.m(this.l);
        this.j.p(this.m);
        this.j.d(this.n);
        this.j.Y0(this.o);
    }

    public final void x() {
        List<n> D = this.p.D();
        if (D == null) {
            return;
        }
        d.a.o0.e2.h.e C0 = this.p.E().C0();
        this.f56851g.p();
        this.f56851g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f56851g.e();
        this.f56852h.d();
        t(e2);
        w(C0);
        e2.setData(new ArrayList(D));
        this.f56851g.g().setCenterTextTitle(String.format(this.f56850f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(C0.Q().f56791b.size())));
        this.f56851g.b(this.p.F());
        if (e2.getAdapter2() instanceof d.a.c.k.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
