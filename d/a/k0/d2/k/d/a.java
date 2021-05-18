package d.a.k0.d2.k.d;

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
import d.a.k0.d2.k.e.e0;
import d.a.k0.d2.k.e.m;
import d.a.k0.d2.k.e.s0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.a.j0.k0.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f52829e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f52830f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.d2.k.d.d f52831g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.d2.k.d.c f52832h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f52833i;
    public m j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.x m;
    public View.OnLongClickListener n;
    public d.a.k0.d2.i.c o;
    public final MoreGodReplyModel p;
    public d.a.j0.k0.d q;
    public long r;
    public BdListView.p s = new C1238a();
    public AbsListView.OnScrollListener t = new b();
    public e0.b u = new c();
    public PbFragment.m2 v = new h();

    /* renamed from: d.a.k0.d2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1238a implements BdListView.p {
        public C1238a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.p.C()) {
                return;
            }
            a.this.p.D();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {

        /* renamed from: e  reason: collision with root package name */
        public int f52835e = -1;

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
            if (!a(this.f52835e) && a(i2) && (pbFragment = a.this.f52830f) != null && pbFragment.J4() != null) {
                a.this.f52830f.J4().f2();
                a.this.f52830f.J4().V0();
            }
            this.f52835e = i2;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements e0.b {
        public c() {
        }

        @Override // d.a.k0.d2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            a.this.f52833i.p3(str);
        }

        @Override // d.a.k0.d2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            a.this.x();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f52838e;

        public d(Runnable runnable) {
            this.f52838e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f52831g.i();
            a.this.f52829e = false;
            PbFragment pbFragment = a.this.f52830f;
            if (pbFragment != null) {
                if (pbFragment.J4() != null) {
                    a.this.f52830f.J4().T2(false);
                    d.a.k0.d2.k.e.i k0 = a.this.f52830f.J4().k0();
                    k0.Z(a.this.f52830f.z().y0(), true);
                    k0.U();
                }
                a aVar = a.this;
                aVar.f52830f.C5(aVar.v);
            }
            Runnable runnable = this.f52838e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.h();
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class h implements PbFragment.m2 {
        public h() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.m2
        public boolean onBackPressed() {
            a.this.h();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f52832h.g(false);
        }
    }

    public a(PbFragment pbFragment, s0 s0Var, ViewStub viewStub) {
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.z());
        this.p = moreGodReplyModel;
        moreGodReplyModel.E(this.u);
        this.f52833i = s0Var;
        this.f52830f = pbFragment;
        this.f52831g = new d.a.k0.d2.k.d.d(pbFragment, viewStub);
        this.f52832h = new d.a.k0.d2.k.d.c(this);
    }

    @Override // d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // d.a.j0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        PbFragment pbFragment = this.f52830f;
        if (pbFragment == null) {
            return null;
        }
        return pbFragment.getNextPageSourceKeyList();
    }

    @Override // d.a.j0.k0.a
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

    @Override // d.a.j0.k0.a
    public d.a.j0.k0.b getPageStayFilter() {
        return null;
    }

    public void h() {
        i(null);
    }

    public void i(Runnable runnable) {
        this.p.cancelLoadData();
        this.f52830f.U4();
        if (!l() && runnable != null) {
            runnable.run();
            return;
        }
        if (l() && !this.f52832h.e()) {
            this.f52831g.r(new d(runnable));
        }
        if (this.r != 0) {
            d.a.j0.k0.d j = j();
            j.v(System.currentTimeMillis() - this.r);
            d.a.j0.k0.e.b().i(this.f52830f.getContext(), j, getPageStayFilter());
        }
    }

    public d.a.j0.k0.d j() {
        if (this.q == null) {
            d.a.j0.k0.d dVar = new d.a.j0.k0.d();
            this.q = dVar;
            dVar.u(getCurrentPageSourceKeyList());
            this.q.p(getCurrentPageKey());
            PbModel z = this.f52830f.z();
            if (z != null) {
                this.q.q(d.a.c.e.m.b.f(z.getForumId(), 0L));
                this.q.y(d.a.c.e.m.b.f(z.O0(), 0L));
            }
        }
        return this.q;
    }

    public d.a.k0.d2.k.d.d k() {
        return this.f52831g;
    }

    public boolean l() {
        return this.f52829e;
    }

    public void m(int i2) {
        this.f52831g.o(i2);
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

    public void s(d.a.k0.d2.i.c cVar) {
        this.o = cVar;
    }

    public final void t(BdTypeListView bdTypeListView) {
        if (this.j == null) {
            m mVar = new m(this.f52830f, PostData.p0);
            this.j = mVar;
            mVar.U0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.j);
            bdTypeListView.a(arrayList);
        }
    }

    public final void u() {
        boolean m = this.f52831g.m();
        this.f52831g.p();
        if (!m) {
            this.f52831g.d().setOnClickListener(new e());
            this.f52831g.c().setOnClickListener(new f());
            this.f52831g.f().z(new g());
            this.f52831g.e().setOnScrollListener(this.t);
        }
        this.r = System.currentTimeMillis();
    }

    public void v() {
        if (!l()) {
            this.f52830f.U4();
            this.f52829e = true;
            this.f52832h.h(false);
            this.f52832h.g(true);
            u();
            x();
            this.f52831g.q(new i());
            this.f52830f.O3(this.v);
            this.p.D();
        }
        this.f52830f.J4().V0();
    }

    public final void w(d.a.k0.d2.h.e eVar) {
        this.j.s(eVar);
        d.a.k0.d2.k.e.i k0 = this.f52833i.k0();
        this.j.setFromCDN(k0.S());
        this.j.p(eVar.L().T().getUserId());
        this.j.c(k0.T());
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
        d.a.k0.d2.h.e y0 = this.p.A().y0();
        this.f52831g.p();
        this.f52831g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f52831g.e();
        this.f52832h.d();
        t(e2);
        w(y0);
        e2.setData(new ArrayList(z));
        this.f52831g.g().setCenterTextTitle(String.format(this.f52830f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(y0.Q().f52771b.size())));
        this.f52831g.b(this.p.B());
        if (e2.getAdapter2() instanceof d.a.c.j.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
