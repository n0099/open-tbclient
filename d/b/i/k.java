package d.b.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class k extends h {
    public d.b.h0.r.q.a l;
    public ForumEnterLayout m;
    public final View.OnClickListener n;

    /* loaded from: classes2.dex */
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
        int g2 = d.b.b.e.p.l.g(context, R.dimen.M_H_X003);
        int g3 = d.b.b.e.p.l.g(context, d.b.h0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
        r(g2);
        q(g3);
        ForumEnterLayout forumEnterLayout = new ForumEnterLayout(context);
        this.m = forumEnterLayout;
        forumEnterLayout.setOnAfterClickListener(this.n);
    }

    @Override // d.b.i.a
    public View g() {
        return this.m;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.m.m(tbPageContext, i);
    }

    public void t() {
        if (d.b.h0.b.d.R()) {
            int g2 = d.b.b.e.p.l.g(this.f51762f, R.dimen.M_H_X003);
            int g3 = d.b.b.e.p.l.g(this.f51762f, d.b.h0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
            r(g2);
            q(g3);
            return;
        }
        int g4 = d.b.b.e.p.l.g(this.f51762f, R.dimen.tbds10);
        r(g4);
        q(0);
        v(this.m, g4, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: u */
    public void a(d.b.h0.r.q.a aVar) {
        this.l = aVar;
        this.m.setSourceForPb(this.f51761e.i());
        this.m.setData(aVar);
    }

    public void v(View view, int i, int i2) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin == i && marginLayoutParams.bottomMargin == i2) {
            return;
        }
        marginLayoutParams.topMargin = i;
        marginLayoutParams.bottomMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }
}
