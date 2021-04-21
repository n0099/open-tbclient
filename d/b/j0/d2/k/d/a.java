package d.b.j0.d2.k.d;

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
import d.b.c.j.e.n;
import d.b.j0.d2.k.e.e0;
import d.b.j0.d2.k.e.m;
import d.b.j0.d2.k.e.s0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements d.b.i0.k0.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f54343e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f54344f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.d2.k.d.d f54345g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.d2.k.d.c f54346h;
    public s0 i;
    public m j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.x m;
    public View.OnLongClickListener n;
    public d.b.j0.d2.i.c o;
    public final MoreGodReplyModel p;
    public d.b.i0.k0.d q;
    public long r;
    public BdListView.p s = new C1227a();
    public AbsListView.OnScrollListener t = new b();
    public e0.b u = new c();
    public PbFragment.m2 v = new h();

    /* renamed from: d.b.j0.d2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1227a implements BdListView.p {
        public C1227a() {
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
        public int f54348e = -1;

        public b() {
        }

        public final boolean a(int i) {
            return i == 2 || i == 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            PbFragment pbFragment;
            if (!a(this.f54348e) && a(i) && (pbFragment = a.this.f54344f) != null && pbFragment.J4() != null) {
                a.this.f54344f.J4().f2();
                a.this.f54344f.J4().V0();
            }
            this.f54348e = i;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements e0.b {
        public c() {
        }

        @Override // d.b.j0.d2.k.e.e0.b
        public void a(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            a.this.i.m3(str);
        }

        @Override // d.b.j0.d2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            a.this.x();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f54351e;

        public d(Runnable runnable) {
            this.f54351e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f54345g.i();
            a.this.f54343e = false;
            PbFragment pbFragment = a.this.f54344f;
            if (pbFragment != null) {
                if (pbFragment.J4() != null) {
                    a.this.f54344f.J4().S2(false);
                    d.b.j0.d2.k.e.i k0 = a.this.f54344f.J4().k0();
                    k0.Z(a.this.f54344f.L().y0(), true);
                    k0.U();
                }
                a aVar = a.this;
                aVar.f54344f.C5(aVar.v);
            }
            Runnable runnable = this.f54351e;
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
    public class h implements PbFragment.m2 {
        public h() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.m2
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
            a.this.f54346h.g(false);
        }
    }

    public a(PbFragment pbFragment, s0 s0Var, ViewStub viewStub) {
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.L());
        this.p = moreGodReplyModel;
        moreGodReplyModel.E(this.u);
        this.i = s0Var;
        this.f54344f = pbFragment;
        this.f54345g = new d.b.j0.d2.k.d.d(pbFragment, viewStub);
        this.f54346h = new d.b.j0.d2.k.d.c(this);
    }

    @Override // d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // d.b.i0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        PbFragment pbFragment = this.f54344f;
        if (pbFragment == null) {
            return null;
        }
        return pbFragment.getNextPageSourceKeyList();
    }

    @Override // d.b.i0.k0.a
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

    @Override // d.b.i0.k0.a
    public d.b.i0.k0.b getPageStayFilter() {
        return null;
    }

    public void h() {
        i(null);
    }

    public void i(Runnable runnable) {
        this.p.cancelLoadData();
        this.f54344f.U4();
        if (!l() && runnable != null) {
            runnable.run();
            return;
        }
        if (l() && !this.f54346h.e()) {
            this.f54345g.r(new d(runnable));
        }
        if (this.r != 0) {
            d.b.i0.k0.d j = j();
            j.v(System.currentTimeMillis() - this.r);
            d.b.i0.k0.e.b().i(this.f54344f.getContext(), j, getPageStayFilter());
        }
    }

    public d.b.i0.k0.d j() {
        if (this.q == null) {
            d.b.i0.k0.d dVar = new d.b.i0.k0.d();
            this.q = dVar;
            dVar.u(getCurrentPageSourceKeyList());
            this.q.p(getCurrentPageKey());
            PbModel L = this.f54344f.L();
            if (L != null) {
                this.q.q(d.b.c.e.m.b.f(L.getForumId(), 0L));
                this.q.y(d.b.c.e.m.b.f(L.O0(), 0L));
            }
        }
        return this.q;
    }

    public d.b.j0.d2.k.d.d k() {
        return this.f54345g;
    }

    public boolean l() {
        return this.f54343e;
    }

    public void m(int i2) {
        this.f54345g.o(i2);
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

    public void s(d.b.j0.d2.i.c cVar) {
        this.o = cVar;
    }

    public final void t(BdTypeListView bdTypeListView) {
        if (this.j == null) {
            m mVar = new m(this.f54344f, PostData.p0);
            this.j = mVar;
            mVar.U0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.j);
            bdTypeListView.a(arrayList);
        }
    }

    public final void u() {
        boolean m = this.f54345g.m();
        this.f54345g.p();
        if (!m) {
            this.f54345g.d().setOnClickListener(new e());
            this.f54345g.c().setOnClickListener(new f());
            this.f54345g.f().z(new g());
            this.f54345g.e().setOnScrollListener(this.t);
        }
        this.r = System.currentTimeMillis();
    }

    public void v() {
        if (!l()) {
            this.f54344f.U4();
            this.f54343e = true;
            this.f54346h.h(false);
            this.f54346h.g(true);
            u();
            x();
            this.f54345g.q(new i());
            this.f54344f.P3(this.v);
            this.p.D();
        }
        this.f54344f.J4().V0();
    }

    public final void w(d.b.j0.d2.h.e eVar) {
        this.j.s(eVar);
        d.b.j0.d2.k.e.i k0 = this.i.k0();
        this.j.setFromCDN(k0.S());
        this.j.n(eVar.L().T().getUserId());
        this.j.h(k0.T());
        this.j.l(this.k);
        this.j.e(this.l);
        this.j.j(this.m);
        this.j.k(this.n);
        this.j.X0(this.o);
    }

    public final void x() {
        List<n> z = this.p.z();
        if (z == null) {
            return;
        }
        d.b.j0.d2.h.e y0 = this.p.A().y0();
        this.f54345g.p();
        this.f54345g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f54345g.e();
        this.f54346h.d();
        t(e2);
        w(y0);
        e2.setData(new ArrayList(z));
        this.f54345g.g().setCenterTextTitle(String.format(this.f54344f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(y0.Q().f54288b.size())));
        this.f54345g.b(this.p.B());
        if (e2.getAdapter2() instanceof d.b.c.j.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
