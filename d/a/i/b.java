package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
/* loaded from: classes.dex */
public class b extends d.a.i.a<d.a.j0.r.q.a> {
    public BjhArticleLayout j;
    public d.a.j0.r.q.a k;
    public View.OnClickListener l;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.r(bVar.f40315e.j(), b.this.k);
        }
    }

    /* renamed from: d.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0548b implements a.b {
        public C0548b() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0549a c0549a) {
            if (b.this.k != null && b.this.k.m() != null) {
                d.a.k0.x.m.a(b.this.k.m().o0());
                d.a.k0.x.m.l(b.this.j.getTitle(), b.this.k.m().o0(), R.color.CAM_X0101, R.color.CAM_X0109);
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

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.a
    public void h() {
        super.h();
        i(1, new C0548b());
    }

    @Override // d.a.i.a
    public void l(d.a.k0.x.b0<d.a.j0.r.q.a> b0Var) {
        super.l(b0Var);
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.j.onChangeSkinType(tbPageContext, i2);
    }

    public final void r(View view, d.a.c.j.e.n nVar) {
        d.a.j0.r.q.a aVar = this.k;
        if (((aVar instanceof d.a.k0.x.e0.e) || (aVar instanceof a2)) && (view.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
            if (nVar instanceof d.a.k0.x.e0.e) {
                d.a.k0.x.e0.e eVar = (d.a.k0.x.e0.e) this.k;
                eVar.k = 1;
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) eVar, view.getContext(), eVar.f63179e.T1 ? 2 : 1, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            } else if (nVar instanceof a2) {
                a2 a2Var = (a2) this.k;
                a2Var.objType = 1;
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) a2Var, view.getContext(), 3, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: s */
    public void a(d.a.j0.r.q.a aVar) {
        this.k = aVar;
        this.j.a(aVar);
    }
}
