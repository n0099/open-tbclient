package d.b.i;

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
import d.b.h0.r.q.a;
import d.b.i.u0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k0<T extends d.b.h0.r.q.a> implements q, d.b.i0.m.e {

    /* renamed from: e  reason: collision with root package name */
    public int f51783e;

    /* renamed from: f  reason: collision with root package name */
    public p<T> f51784f;

    /* renamed from: g  reason: collision with root package name */
    public Context f51785g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadCardView f51786h;
    public RelativeLayout i;
    public LinearLayout j;
    public d.b.i.a<T> k;
    public d.b.i.a<T> l;
    public List<h> m;
    public d.b.i.a<T> n;
    public ArrayList<c> o;
    public q p;
    public l0 q;
    public View r;
    public T s;
    public d.b.i.u0.a t;
    public int u;
    public a.C1118a v;

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
                k0.this.v.d(Boolean.FALSE);
                k0 k0Var = k0.this;
                k0Var.o(k0Var.v);
                return false;
            }
            k0.this.v.d(Boolean.TRUE);
            k0 k0Var2 = k0.this;
            k0Var2.o(k0Var2.v);
            return false;
        }
    }

    public /* synthetic */ k0(b bVar, a aVar) {
        this(bVar);
    }

    public void b(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return;
        }
        n(cVar);
        cVar.b().setVisibility(0);
        if (cVar.d() == null) {
            this.i.addView(cVar.b(), cVar.c());
        } else {
            this.i.addView(cVar.b(), cVar.c(), cVar.d());
        }
        cVar.j(this);
        cVar.e();
        this.o.add(cVar);
    }

    public final void c() {
        c cVar = new c();
        cVar.g(new TbImageView(this.f51785g));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.b.b.e.p.l.g(this.f51785g, R.dimen.ds180), d.b.b.e.p.l.g(this.f51785g, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.q.f51802g;
        cVar.i(layoutParams);
        cVar.h(-1);
        this.o.add(cVar);
    }

    public final void d(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            z = 8 != viewGroup.getChildAt(i).getVisibility();
            if (z) {
                break;
            }
        }
        viewGroup.setVisibility(z ? 0 : 8);
    }

    public d.b.i.a<T> e() {
        return this.n;
    }

    public d.b.i.a<T> f() {
        return this.l;
    }

    public Context g() {
        return this.f51785g;
    }

    public List<h> h() {
        return this.m;
    }

    public int i() {
        return this.u;
    }

    public View j() {
        return this.f51786h;
    }

    public final void k() {
        if (this.q == null) {
            return;
        }
        if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            l0 l0Var = this.q;
            ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).setMargins(l0Var.f51801f, l0Var.f51799d, l0Var.f51802g, l0Var.f51800e);
            this.j.postInvalidate();
        }
        if (this.q.f51796a) {
            c();
        }
        d.b.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.j(this);
            this.j.addView(this.k.g());
            this.k.h();
        }
        d.b.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.j(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.q.f51797b;
            if (this.l.f().booleanValue()) {
                l0 l0Var2 = this.q;
                layoutParams.leftMargin = -l0Var2.f51801f;
                layoutParams.rightMargin = -l0Var2.f51802g;
            }
            this.j.addView(this.l.g(), layoutParams);
            this.l.h();
        }
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i++) {
                h hVar = this.m.get(i);
                if (hVar != null) {
                    hVar.j(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = hVar.p();
                    layoutParams2.bottomMargin = hVar.o();
                    if (hVar.f().booleanValue()) {
                        l0 l0Var3 = this.q;
                        layoutParams2.leftMargin = -l0Var3.f51801f;
                        layoutParams2.rightMargin = -l0Var3.f51802g;
                    }
                    this.j.addView(hVar.g(), layoutParams2);
                    hVar.h();
                }
            }
        }
        if (this.n != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.q.f51798c;
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
                    this.i.addView(next.b(), next.c());
                } else {
                    this.i.addView(next.b(), next.c(), next.d());
                }
                next.j(this);
                next.e();
            }
        }
    }

    public void l(T t) {
        this.s = t;
        d.b.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.a(t);
        }
        d.b.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.a(t);
        }
        if (!ListUtils.isEmpty(this.m)) {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.m.get(i);
                hVar.a(t);
                if (i == 0) {
                    boolean z = true;
                    ThreadCardUtils.dealMainViewTopMargin(hVar.g(), (ThreadCardUtils.isNoThreadTitle(t.n()) && ThreadCardUtils.isNoThreadAbstract(t.n()) && ThreadCardUtils.isNoThreadVoice(t.n()) && t.n().V2() < 1 && t.n().u1() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        d.b.i.a<T> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(t);
        }
        p<T> pVar = this.f51784f;
        if (pVar != null) {
            pVar.a(t);
        }
        d(this.j);
        d(this.i);
    }

    public void m(int i, a.b bVar) {
        this.t.a(i, bVar);
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

    public boolean o(a.C1118a c1118a) {
        return this.t.b(c1118a);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i == this.f51783e) {
            return;
        }
        this.f51783e = i;
        T t = this.s;
        if (t != null && !t.isSupportNone()) {
            SkinManager.setBackgroundResource(this.f51786h, this.q.f51803h);
        }
        d.b.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i);
            if (this.n == null) {
                d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f51786h);
                a2.g(1);
                a2.h(R.string.J_X06);
                a2.c(this.q.f51803h);
            }
        }
        d.b.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i);
        }
        for (h hVar : this.m) {
            if (hVar != null) {
                hVar.onChangeSkinType(tbPageContext, i);
            }
        }
        d.b.i.a<T> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.onChangeSkinType(tbPageContext, i);
            if (this.k == null) {
                d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.f51786h);
                a3.g(2);
                a3.h(R.string.J_X06);
                a3.c(this.q.f51803h);
            }
        }
        if (this.k != null && this.n != null) {
            d.b.h0.r.u.c a4 = d.b.h0.r.u.c.a(this.f51786h);
            a4.h(R.string.J_X06);
            a4.d(this.q.f51803h, R.color.CAM_X0206);
        }
        if (!ListUtils.isEmpty(this.o)) {
            Iterator<c> it = this.o.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && (next instanceof q)) {
                    ((q) next).onChangeSkinType(tbPageContext, i);
                }
            }
        }
        q qVar = this.p;
        if (qVar != null) {
            qVar.onChangeSkinType(tbPageContext, i);
        }
    }

    public void p(d.b.i0.x.b0<T> b0Var) {
        d.b.i.a<T> aVar = this.k;
        if (aVar != null) {
            aVar.l(b0Var);
        }
        d.b.i.a<T> aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.l(b0Var);
        }
        for (h hVar : this.m) {
            if (hVar != null) {
                hVar.l(b0Var);
            }
        }
        d.b.i.a<T> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.l(b0Var);
        }
    }

    public void q(int i) {
        ThreadCardView threadCardView = this.f51786h;
        if (threadCardView != null) {
            threadCardView.setPosition(i);
        }
    }

    public void r(int i) {
        this.u = i;
    }

    @Override // d.b.i0.m.e
    public void setPage(String str) {
    }

    public /* synthetic */ k0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, d.b.b.j.e.s sVar, a aVar) {
        this(bVar, supportType, viewGroup, sVar);
    }

    public /* synthetic */ k0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    public k0(b bVar) {
        this(bVar, BaseCardInfo.SupportType.FULL);
    }

    public k0(b bVar, BaseCardInfo.SupportType supportType) {
        this(bVar, supportType, null);
    }

    public k0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (d.b.b.j.e.s) null);
    }

    public k0(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, d.b.b.j.e.s sVar) {
        this.f51783e = 3;
        this.f51784f = null;
        this.p = null;
        this.t = new d.b.i.u0.a();
        this.u = 0;
        this.v = new a.C1118a(7);
        Context context = bVar.f51793f;
        this.f51785g = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_card_layout, viewGroup, false);
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.f51786h = threadCardView;
        this.i = (RelativeLayout) threadCardView.findViewById(R.id.card_decor_layer);
        LinearLayout linearLayout = (LinearLayout) this.f51786h.findViewById(R.id.body_root);
        this.j = linearLayout;
        linearLayout.setClipToPadding(false);
        this.r = this.f51786h.findViewById(R.id.card_top_line);
        this.k = bVar.f51788a;
        this.l = bVar.f51789b;
        this.m = bVar.f51790c;
        this.n = bVar.f51791d;
        this.o = bVar.f51792e;
        this.q = bVar.f51794g;
        this.f51786h.setParent(viewGroup);
        this.f51786h.setITypeListView(sVar);
        k();
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.f51786h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f51786h.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.f51786h.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.f51786h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f51786h.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            this.f51786h.postInvalidate();
        }
        inflate.setOnTouchListener(new a());
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public d.b.i.a f51788a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.i.a f51789b;

        /* renamed from: c  reason: collision with root package name */
        public List<h> f51790c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.i.a f51791d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f51792e;

        /* renamed from: f  reason: collision with root package name */
        public Context f51793f;

        /* renamed from: g  reason: collision with root package name */
        public l0 f51794g;

        public b(Context context, boolean z) {
            this.f51788a = null;
            this.f51789b = null;
            this.f51791d = null;
            this.f51793f = context;
            this.f51792e = new ArrayList<>();
            l0 l0Var = new l0();
            this.f51794g = l0Var;
            if (!z) {
                l0Var.e(0);
            }
            this.f51790c = new ArrayList();
        }

        public b h(h hVar) {
            this.f51790c.add(hVar);
            return this;
        }

        public k0 i() {
            return new k0(this, (a) null);
        }

        public k0 j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            return new k0(this, supportType, viewGroup, (a) null);
        }

        public k0 k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, d.b.b.j.e.s sVar) {
            return new k0(this, supportType, viewGroup, sVar, null);
        }

        public l0 l() {
            return this.f51794g;
        }

        public b m(d.b.i.a aVar) {
            this.f51791d = aVar;
            return this;
        }

        public b n(d.b.i.a aVar) {
            this.f51789b = aVar;
            return this;
        }

        public b o(d.b.i.a aVar) {
            this.f51788a = aVar;
            return this;
        }

        public b(Context context) {
            this(context, true);
        }
    }
}
