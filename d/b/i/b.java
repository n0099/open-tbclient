package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.i.u0.a;
/* loaded from: classes2.dex */
public class b extends d.b.i.a<d.b.h0.r.q.a> {
    public BjhArticleLayout j;
    public d.b.h0.r.q.a k;
    public View.OnClickListener l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.r(bVar.f51761e.j(), b.this.k);
        }
    }

    /* renamed from: d.b.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1116b implements a.b {
        public C1116b() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1117a c1117a) {
            if (b.this.k != null && b.this.k.n() != null) {
                d.b.i0.x.m.a(b.this.k.n().o0());
                d.b.i0.x.m.l(b.this.j.getTitle(), b.this.k.n().o0(), R.color.CAM_X0101, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public b(Context context) {
        super(context);
        this.l = new a();
        BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(context);
        this.j = bjhArticleLayout;
        bjhArticleLayout.setJumpToPbListener(this.l);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.a
    public void h() {
        super.h();
        i(1, new C1116b());
    }

    @Override // d.b.i.a
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        super.l(b0Var);
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.j.onChangeSkinType(tbPageContext, i);
    }

    public final void r(View view, d.b.b.j.e.n nVar) {
        d.b.h0.r.q.a aVar = this.k;
        if (((aVar instanceof d.b.i0.x.e0.e) || (aVar instanceof a2)) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            if (nVar instanceof d.b.i0.x.e0.e) {
                d.b.i0.x.e0.e eVar = (d.b.i0.x.e0.e) this.k;
                eVar.k = 1;
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) eVar, view.getContext(), eVar.f62196e.T1 ? 2 : 1, false);
                threadCardViewHolder.b().o(new a.C1117a(1));
            } else if (nVar instanceof a2) {
                a2 a2Var = (a2) this.k;
                a2Var.objType = 1;
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) a2Var, view.getContext(), 3, false);
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: s */
    public void a(d.b.h0.r.q.a aVar) {
        this.k = aVar;
        this.j.a(aVar);
    }
}
