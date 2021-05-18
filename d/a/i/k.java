package d.a.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class k extends h {
    public d.a.j0.r.q.a l;
    public ForumEnterLayout m;
    public final View.OnClickListener n;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.d() != null) {
                k.this.d().a(view, k.this.l);
            }
        }
    }

    public k(Context context) {
        super(context);
        this.n = new a();
        int g2 = d.a.c.e.p.l.g(context, R.dimen.M_H_X003);
        int g3 = d.a.c.e.p.l.g(context, d.a.j0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
        r(g2);
        q(g3);
        ForumEnterLayout forumEnterLayout = new ForumEnterLayout(context);
        this.m = forumEnterLayout;
        forumEnterLayout.setOnAfterClickListener(this.n);
    }

    @Override // d.a.i.a
    public View g() {
        return this.m;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.m.m(tbPageContext, i2);
    }

    public void t() {
        if (d.a.j0.b.d.U()) {
            int g2 = d.a.c.e.p.l.g(this.f40316f, R.dimen.M_H_X003);
            int g3 = d.a.c.e.p.l.g(this.f40316f, d.a.j0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
            r(g2);
            q(g3);
            return;
        }
        int g4 = d.a.c.e.p.l.g(this.f40316f, R.dimen.tbds10);
        r(g4);
        q(0);
        v(this.m, g4, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: u */
    public void a(d.a.j0.r.q.a aVar) {
        this.l = aVar;
        this.m.setSourceForPb(this.f40315e.i());
        this.m.setData(aVar);
    }

    public void v(View view, int i2, int i3) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin == i2 && marginLayoutParams.bottomMargin == i3) {
            return;
        }
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.bottomMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }
}
