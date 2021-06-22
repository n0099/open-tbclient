package d.a.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.v0.a;
import d.a.n0.r.q.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l0<T extends d.a.n0.r.q.a> implements q, d.a.o0.o.e {

    /* renamed from: e  reason: collision with root package name */
    public int f43809e;

    /* renamed from: f  reason: collision with root package name */
    public p<T> f43810f;

    /* renamed from: g  reason: collision with root package name */
    public Context f43811g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadCardView f43812h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f43813i;
    public LinearLayout j;
    public d.a.i.a<T> k;
    public d.a.i.a<T> l;
    public List<h> m;
    public d.a.i.a<T> n;
    public ArrayList<c> o;
    public q p;
    public m0 q;
    public View r;
    public T s;
    public d.a.i.v0.a t;
    public int u;
    public a.C0602a v;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x000d, code lost:
            if (r1 != 3) goto L9;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                l0.this.v.d(Boolean.FALSE);
                l0 l0Var = l0.this;
                l0Var.o(l0Var.v);
                return false;
            }
            l0.this.v.d(Boolean.TRUE);
            l0 l0Var2 = l0.this;
            l0Var2.o(l0Var2.v);
            return false;
        }
    }

    public /* synthetic */ l0(b bVar, a aVar) {
        this(bVar);
    }

    public void b(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return;
        }
        n(cVar);
        cVar.b().setVisibility(0);
        if (cVar.d() == null) {
            this.f43813i.addView(cVar.b(), cVar.c());
        } else {
            this.f43813i.addView(cVar.b(), cVar.c(), cVar.d());
        }
        cVar.j(this);
        cVar.e();
        this.o.add(cVar);
    }

    public final void c() {
        c cVar = new c();
        cVar.g(new TbImageView(this.f43811g));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.a.c.e.p.l.g(this.f43811g, R.dimen.ds180), d.a.c.e.p.l.g(this.f43811g, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.q.f43830g;
        cVar.i(layoutParams);
        cVar.h(-1);
        this.o.add(cVar);
    }

    public final void d(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            z = 8 != viewGroup.getChildAt(i2).getVisibility();
            if (z) {
                break;
            }
        }
        viewGroup.setVisibility(z ? 0 : 8);
    }

    public d.a.i.a<T> e() {
        return this.n;
    }

    public d.a.i.a<T> f() {
        return this.l;
    }

    public Context g() {
        return this.f43811g;
    }

    public List<h> h() {
        return this.m;
    }

    public int i() {
        return this.u;
    }

    public View j() {
        return this.f43812h;
    }

    public final void k() {
        if (this.q == null) {
            return;
        }
        if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            m0 m0Var = this.q;
            ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).setMargins(m0Var.f43829f, m0Var.f43827d, m0Var.f43830g, m0Var.f43828e);
            this.j.postInvalidate();
        }
        if (this.q.f43824a) {
            c();
        }
        d.a.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.j(this);
            this.j.addView(this.k.g());
            this.k.h();
        }
        d.a.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.j(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.q.f43825b;
            if (this.l.f().booleanValue()) {
                m0 m0Var2 = this.q;
                layoutParams.leftMargin = -m0Var2.f43829f;
                layoutParams.rightMargin = -m0Var2.f43830g;
            }
            this.j.addView(this.l.g(), layoutParams);
            this.l.h();
        }
        if (this.m != null) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                h hVar = this.m.get(i2);
                if (hVar != null) {
                    hVar.j(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = hVar.p();
                    layoutParams2.bottomMargin = hVar.o();
                    if (hVar.f().booleanValue()) {
                        m0 m0Var3 = this.q;
                        layoutParams2.leftMargin = -m0Var3.f43829f;
                        layoutParams2.rightMargin = -m0Var3.f43830g;
                    }
                    this.j.addView(hVar.g(), layoutParams2);
                    hVar.h();
                }
            }
        }
        if (this.n != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.q.f43826c;
            this.n.j(this);
            this.j.addView(this.n.g(), layoutParams3);
            this.n.h();
        }
        if (ListUtils.isEmpty(this.o)) {
            return;
        }
        Iterator<c> it = this.o.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.b() != null) {
                if (next.d() == null) {
                    this.f43813i.addView(next.b(), next.c());
                } else {
                    this.f43813i.addView(next.b(), next.c(), next.d());
                }
                next.j(this);
                next.e();
            }
        }
    }

    public void l(T t) {
        this.s = t;
        d.a.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.a(t);
        }
        d.a.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.a(t);
        }
        if (!ListUtils.isEmpty(this.m)) {
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = this.m.get(i2);
                hVar.a(t);
                if (i2 == 0) {
                    boolean z = true;
                    ThreadCardUtils.dealMainViewTopMargin(hVar.g(), (ThreadCardUtils.isNoThreadTitle(t.i()) && ThreadCardUtils.isNoThreadAbstract(t.i()) && ThreadCardUtils.isNoThreadVoice(t.i()) && t.i().a3() < 1 && t.i().x1() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        d.a.i.a<T> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(t);
        }
        p<T> pVar = this.f43810f;
        if (pVar != null) {
            pVar.a(t);
        }
        d(this.j);
        d(this.f43813i);
    }

    public void m(int i2, a.b bVar) {
        this.t.a(i2, bVar);
    }

    public void n(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return;
        }
        this.o.remove(cVar);
        if (cVar.b().getParent() != null) {
            ((ViewGroup) cVar.b().getParent()).removeView(cVar.b());
            cVar.f();
            cVar.j(null);
        }
    }

    public boolean o(a.C0602a c0602a) {
        return this.t.b(c0602a);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (i2 == this.f43809e) {
            return;
        }
        this.f43809e = i2;
        T t = this.s;
        if (t != null && !t.isSupportNone()) {
            SkinManager.setBackgroundResource(this.f43812h, this.q.f43831h);
        }
        d.a.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
            if (this.n == null) {
                d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f43812h);
                d2.l(1);
                d2.m(R.string.J_X06);
                d2.f(this.q.f43831h);
            }
        }
        d.a.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i2);
        }
        for (h hVar : this.m) {
            if (hVar != null) {
                hVar.onChangeSkinType(tbPageContext, i2);
            }
        }
        d.a.i.a<T> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.onChangeSkinType(tbPageContext, i2);
            if (this.k == null) {
                d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(this.f43812h);
                d3.l(2);
                d3.m(R.string.J_X06);
                d3.f(this.q.f43831h);
            }
        }
        if (this.k != null && this.n != null) {
            d.a.n0.r.u.c d4 = d.a.n0.r.u.c.d(this.f43812h);
            d4.m(R.string.J_X06);
            d4.h(this.q.f43831h, R.color.CAM_X0206);
        }
        if (!ListUtils.isEmpty(this.o)) {
            Iterator<c> it = this.o.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && (next instanceof q)) {
                    ((q) next).onChangeSkinType(tbPageContext, i2);
                }
            }
        }
        q qVar = this.p;
        if (qVar != null) {
            qVar.onChangeSkinType(tbPageContext, i2);
        }
    }

    public void p(d.a.o0.z.b0<T> b0Var) {
        d.a.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.l(b0Var);
        }
        d.a.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.l(b0Var);
        }
        for (h hVar : this.m) {
            if (hVar != null) {
                hVar.l(b0Var);
            }
        }
        d.a.i.a<T> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.l(b0Var);
        }
    }

    public void q(int i2) {
        ThreadCardView threadCardView = this.f43812h;
        if (threadCardView != null) {
            threadCardView.setPosition(i2);
        }
    }

    public void r(int i2) {
        this.u = i2;
    }

    @Override // d.a.o0.o.e
    public void setPage(String str) {
    }

    public /* synthetic */ l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, d.a.c.k.e.s sVar, a aVar) {
        this(bVar, supportType, viewGroup, sVar);
    }

    public /* synthetic */ l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    public l0(b bVar) {
        this(bVar, BaseCardInfo.SupportType.FULL);
    }

    public l0(b bVar, BaseCardInfo.SupportType supportType) {
        this(bVar, supportType, null);
    }

    public l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (d.a.c.k.e.s) null);
    }

    public l0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, d.a.c.k.e.s sVar) {
        this.f43809e = 3;
        this.f43810f = null;
        this.p = null;
        this.t = new d.a.i.v0.a();
        this.u = 0;
        this.v = new a.C0602a(7);
        Context context = bVar.f43820f;
        this.f43811g = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_card_layout, viewGroup, false);
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.f43812h = threadCardView;
        this.f43813i = (RelativeLayout) threadCardView.findViewById(R.id.card_decor_layer);
        LinearLayout linearLayout = (LinearLayout) this.f43812h.findViewById(R.id.body_root);
        this.j = linearLayout;
        linearLayout.setClipToPadding(false);
        this.r = this.f43812h.findViewById(R.id.card_top_line);
        this.k = bVar.f43815a;
        this.l = bVar.f43816b;
        this.m = bVar.f43817c;
        this.n = bVar.f43818d;
        this.o = bVar.f43819e;
        this.q = bVar.f43821g;
        this.f43812h.setParent(viewGroup);
        this.f43812h.setITypeListView(sVar);
        k();
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.f43812h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f43812h.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.f43812h.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.f43812h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f43812h.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            this.f43812h.postInvalidate();
        }
        inflate.setOnTouchListener(new a());
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public d.a.i.a f43815a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.i.a f43816b;

        /* renamed from: c  reason: collision with root package name */
        public List<h> f43817c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.i.a f43818d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f43819e;

        /* renamed from: f  reason: collision with root package name */
        public Context f43820f;

        /* renamed from: g  reason: collision with root package name */
        public m0 f43821g;

        public b(Context context, boolean z) {
            this.f43815a = null;
            this.f43816b = null;
            this.f43818d = null;
            this.f43820f = context;
            this.f43819e = new ArrayList<>();
            m0 m0Var = new m0();
            this.f43821g = m0Var;
            if (!z) {
                m0Var.e(0);
            }
            this.f43817c = new ArrayList();
        }

        public b h(h hVar) {
            this.f43817c.add(hVar);
            return this;
        }

        public l0 i() {
            return new l0(this, (a) null);
        }

        public l0 j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            return new l0(this, supportType, viewGroup, (a) null);
        }

        public l0 k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, d.a.c.k.e.s sVar) {
            return new l0(this, supportType, viewGroup, sVar, null);
        }

        public m0 l() {
            return this.f43821g;
        }

        public b m(d.a.i.a aVar) {
            this.f43818d = aVar;
            return this;
        }

        public b n(d.a.i.a aVar) {
            this.f43816b = aVar;
            return this;
        }

        public b o(d.a.i.a aVar) {
            this.f43815a = aVar;
            return this;
        }

        public b(Context context) {
            this(context, true);
        }
    }
}
