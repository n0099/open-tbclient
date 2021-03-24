package d.b.i0.c2.k.d;

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
import d.b.b.j.e.n;
import d.b.i0.c2.k.e.c0;
import d.b.i0.c2.k.e.k;
import d.b.i0.c2.k.e.q0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements d.b.h0.k0.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f52526e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f52527f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.c2.k.d.d f52528g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c2.k.d.c f52529h;
    public q0 i;
    public k j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.w m;
    public View.OnLongClickListener n;
    public d.b.i0.c2.i.c o;
    public final MoreGodReplyModel p;
    public d.b.h0.k0.d q;
    public long r;
    public BdListView.p s = new C1146a();
    public AbsListView.OnScrollListener t = new b();
    public c0.b u = new c();
    public PbFragment.l2 v = new h();

    /* renamed from: d.b.i0.c2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1146a implements BdListView.p {
        public C1146a() {
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
        public int f52531e = -1;

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
            if (!a(this.f52531e) && a(i) && (pbFragment = a.this.f52527f) != null && pbFragment.G4() != null) {
                a.this.f52527f.G4().S1();
                a.this.f52527f.G4().O0();
            }
            this.f52531e = i;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c0.b {
        public c() {
        }

        @Override // d.b.i0.c2.k.e.c0.b
        public void a(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                return;
            }
            a.this.i.Y2(str);
        }

        @Override // d.b.i0.c2.k.e.c0.b
        public void onSuccess(List<PostData> list) {
            a.this.x();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f52534e;

        public d(Runnable runnable) {
            this.f52534e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f52528g.i();
            a.this.f52526e = false;
            PbFragment pbFragment = a.this.f52527f;
            if (pbFragment != null) {
                if (pbFragment.G4() != null) {
                    a.this.f52527f.G4().F2(false);
                    d.b.i0.c2.k.e.g e0 = a.this.f52527f.G4().e0();
                    e0.Z(a.this.f52527f.L().y0(), true);
                    e0.U();
                }
                a aVar = a.this;
                aVar.f52527f.z5(aVar.v);
            }
            Runnable runnable = this.f52534e;
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
    public class h implements PbFragment.l2 {
        public h() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.l2
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
            a.this.f52529h.g(false);
        }
    }

    public a(PbFragment pbFragment, q0 q0Var, ViewStub viewStub) {
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.L());
        this.p = moreGodReplyModel;
        moreGodReplyModel.E(this.u);
        this.i = q0Var;
        this.f52527f = pbFragment;
        this.f52528g = new d.b.i0.c2.k.d.d(pbFragment, viewStub);
        this.f52529h = new d.b.i0.c2.k.d.c(this);
    }

    @Override // d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a053";
    }

    @Override // d.b.h0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        PbFragment pbFragment = this.f52527f;
        if (pbFragment == null) {
            return null;
        }
        return pbFragment.getNextPageSourceKeyList();
    }

    @Override // d.b.h0.k0.a
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

    @Override // d.b.h0.k0.a
    public d.b.h0.k0.b getPageStayFilter() {
        return null;
    }

    public void h() {
        i(null);
    }

    public void i(Runnable runnable) {
        this.p.cancelLoadData();
        this.f52527f.R4();
        if (!l() && runnable != null) {
            runnable.run();
            return;
        }
        if (l() && !this.f52529h.e()) {
            this.f52528g.r(new d(runnable));
        }
        if (this.r != 0) {
            d.b.h0.k0.d j = j();
            j.v(System.currentTimeMillis() - this.r);
            d.b.h0.k0.e.b().i(this.f52527f.getContext(), j, getPageStayFilter());
        }
    }

    public d.b.h0.k0.d j() {
        if (this.q == null) {
            d.b.h0.k0.d dVar = new d.b.h0.k0.d();
            this.q = dVar;
            dVar.u(getCurrentPageSourceKeyList());
            this.q.p(getCurrentPageKey());
            PbModel L = this.f52527f.L();
            if (L != null) {
                this.q.q(d.b.b.e.m.b.f(L.getForumId(), 0L));
                this.q.y(d.b.b.e.m.b.f(L.O0(), 0L));
            }
        }
        return this.q;
    }

    public d.b.i0.c2.k.d.d k() {
        return this.f52528g;
    }

    public boolean l() {
        return this.f52526e;
    }

    public void m(int i2) {
        this.f52528g.o(i2);
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

    public void q(TbRichTextView.w wVar) {
        this.m = wVar;
    }

    public void r(View.OnLongClickListener onLongClickListener) {
        this.n = onLongClickListener;
    }

    public void s(d.b.i0.c2.i.c cVar) {
        this.o = cVar;
    }

    public final void t(BdTypeListView bdTypeListView) {
        if (this.j == null) {
            k kVar = new k(this.f52527f, PostData.o0);
            this.j = kVar;
            kVar.U0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.j);
            bdTypeListView.a(arrayList);
        }
    }

    public final void u() {
        boolean m = this.f52528g.m();
        this.f52528g.p();
        if (!m) {
            this.f52528g.d().setOnClickListener(new e());
            this.f52528g.c().setOnClickListener(new f());
            this.f52528g.f().z(new g());
            this.f52528g.e().setOnScrollListener(this.t);
        }
        this.r = System.currentTimeMillis();
    }

    public void v() {
        if (!l()) {
            this.f52527f.R4();
            this.f52526e = true;
            this.f52529h.h(false);
            this.f52529h.g(true);
            u();
            x();
            this.f52528g.q(new i());
            this.f52527f.N3(this.v);
            this.p.D();
        }
        this.f52527f.G4().O0();
    }

    public final void w(d.b.i0.c2.h.e eVar) {
        this.j.s(eVar);
        d.b.i0.c2.k.e.g e0 = this.i.e0();
        this.j.setFromCDN(e0.S());
        this.j.n(eVar.L().T().getUserId());
        this.j.h(e0.T());
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
        d.b.i0.c2.h.e y0 = this.p.A().y0();
        this.f52528g.p();
        this.f52528g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f52528g.e();
        this.f52529h.d();
        t(e2);
        w(y0);
        e2.setData(new ArrayList(z));
        this.f52528g.g().setCenterTextTitle(String.format(this.f52527f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(y0.P().f52471b.size())));
        this.f52528g.b(this.p.B());
        if (e2.getAdapter2() instanceof d.b.b.j.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
