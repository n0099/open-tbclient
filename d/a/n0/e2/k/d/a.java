package d.a.n0.e2.k.d;

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
import d.a.c.j.e.n;
import d.a.n0.e2.k.e.e0;
import d.a.n0.e2.k.e.m;
import d.a.n0.e2.k.e.t0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements d.a.m0.k0.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f53035e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f53036f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.e2.k.d.d f53037g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.e2.k.d.c f53038h;

    /* renamed from: i  reason: collision with root package name */
    public t0 f53039i;
    public m j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.x m;
    public View.OnLongClickListener n;
    public d.a.n0.e2.i.c o;
    public final MoreGodReplyModel p;
    public d.a.m0.k0.d q;
    public long r;
    public BdListView.p s = new C1256a();
    public AbsListView.OnScrollListener t = new b();
    public e0.b u = new c();
    public PbFragment.p2 v = new h();

    /* renamed from: d.a.n0.e2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1256a implements BdListView.p {
        public C1256a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.p.C()) {
                return;
            }
            a.this.p.D();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AbsListView.OnScrollListener {

        /* renamed from: e  reason: collision with root package name */
        public int f53041e = -1;

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
            if (!a(this.f53041e) && a(i2) && (pbFragment = a.this.f53036f) != null && pbFragment.K4() != null) {
                a.this.f53036f.K4().h2();
                a.this.f53036f.K4().W0();
            }
            this.f53041e = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements e0.b {
        public c() {
        }

        @Override // d.a.n0.e2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            a.this.f53039i.r3(str);
        }

        @Override // d.a.n0.e2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            a.this.x();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f53044e;

        public d(Runnable runnable) {
            this.f53044e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f53037g.i();
            a.this.f53035e = false;
            PbFragment pbFragment = a.this.f53036f;
            if (pbFragment != null) {
                if (pbFragment.K4() != null) {
                    a.this.f53036f.K4().V2(false);
                    d.a.n0.e2.k.e.i l0 = a.this.f53036f.K4().l0();
                    l0.Z(a.this.f53036f.z().y0(), true);
                    l0.U();
                }
                a aVar = a.this;
                aVar.f53036f.D5(aVar.v);
            }
            Runnable runnable = this.f53044e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.p.C()) {
                return;
            }
            a.this.p.D();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements PbFragment.p2 {
        public h() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.p2
        public boolean onBackPressed() {
            a.this.h();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f53038h.g(false);
        }
    }

    public a(PbFragment pbFragment, t0 t0Var, ViewStub viewStub) {
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.z());
        this.p = moreGodReplyModel;
        moreGodReplyModel.E(this.u);
        this.f53039i = t0Var;
        this.f53036f = pbFragment;
        this.f53037g = new d.a.n0.e2.k.d.d(pbFragment, viewStub);
        this.f53038h = new d.a.n0.e2.k.d.c(this);
    }

    @Override // d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        PbFragment pbFragment = this.f53036f;
        if (pbFragment == null) {
            return null;
        }
        return pbFragment.getNextPageSourceKeyList();
    }

    @Override // d.a.m0.k0.a
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

    @Override // d.a.m0.k0.a
    public d.a.m0.k0.b getPageStayFilter() {
        return null;
    }

    public void h() {
        i(null);
    }

    public void i(Runnable runnable) {
        this.p.cancelLoadData();
        this.f53036f.V4();
        if (!l() && runnable != null) {
            runnable.run();
            return;
        }
        if (l() && !this.f53038h.e()) {
            this.f53037g.r(new d(runnable));
        }
        if (this.r != 0) {
            d.a.m0.k0.d j = j();
            j.v(System.currentTimeMillis() - this.r);
            d.a.m0.k0.e.b().i(this.f53036f.getContext(), j, getPageStayFilter());
        }
    }

    public d.a.m0.k0.d j() {
        if (this.q == null) {
            d.a.m0.k0.d dVar = new d.a.m0.k0.d();
            this.q = dVar;
            dVar.u(getCurrentPageSourceKeyList());
            this.q.p(getCurrentPageKey());
            PbModel z = this.f53036f.z();
            if (z != null) {
                this.q.q(d.a.c.e.m.b.f(z.getForumId(), 0L));
                this.q.y(d.a.c.e.m.b.f(z.O0(), 0L));
            }
        }
        return this.q;
    }

    public d.a.n0.e2.k.d.d k() {
        return this.f53037g;
    }

    public boolean l() {
        return this.f53035e;
    }

    public void m(int i2) {
        this.f53037g.o(i2);
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

    public void s(d.a.n0.e2.i.c cVar) {
        this.o = cVar;
    }

    public final void t(BdTypeListView bdTypeListView) {
        if (this.j == null) {
            m mVar = new m(this.f53036f, PostData.p0);
            this.j = mVar;
            mVar.U0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.j);
            bdTypeListView.a(arrayList);
        }
    }

    public final void u() {
        boolean m = this.f53037g.m();
        this.f53037g.p();
        if (!m) {
            this.f53037g.d().setOnClickListener(new e());
            this.f53037g.c().setOnClickListener(new f());
            this.f53037g.f().z(new g());
            this.f53037g.e().setOnScrollListener(this.t);
        }
        this.r = System.currentTimeMillis();
    }

    public void v() {
        if (!l()) {
            this.f53036f.V4();
            this.f53035e = true;
            this.f53038h.h(false);
            this.f53038h.g(true);
            u();
            x();
            this.f53037g.q(new i());
            this.f53036f.P3(this.v);
            this.p.D();
        }
        this.f53036f.K4().W0();
    }

    public final void w(d.a.n0.e2.h.e eVar) {
        this.j.s(eVar);
        d.a.n0.e2.k.e.i l0 = this.f53039i.l0();
        this.j.setFromCDN(l0.S());
        this.j.p(eVar.L().T().getUserId());
        this.j.c(l0.T());
        this.j.e(this.k);
        this.j.l(this.l);
        this.j.o(this.m);
        this.j.d(this.n);
        this.j.X0(this.o);
    }

    public final void x() {
        List<n> z = this.p.z();
        if (z == null) {
            return;
        }
        d.a.n0.e2.h.e y0 = this.p.A().y0();
        this.f53037g.p();
        this.f53037g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f53037g.e();
        this.f53038h.d();
        t(e2);
        w(y0);
        e2.setData(new ArrayList(z));
        this.f53037g.g().setCenterTextTitle(String.format(this.f53036f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(y0.Q().f52977b.size())));
        this.f53037g.b(this.p.B());
        if (e2.getAdapter2() instanceof d.a.c.j.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
