package d.b.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ForumGoodsEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class l extends h {
    public d.b.h0.r.q.a l;
    public ForumGoodsEnterLayout m;
    public int n;
    public final View.OnClickListener o;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.d() != null) {
                l.this.d().a(view, l.this.l);
            }
        }
    }

    public l(Context context) {
        super(context);
        this.o = new a();
        int g2 = d.b.b.e.p.l.g(context, R.dimen.M_H_X003);
        int g3 = d.b.b.e.p.l.g(context, d.b.h0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
        r(g2);
        q(g3);
        ForumGoodsEnterLayout forumGoodsEnterLayout = new ForumGoodsEnterLayout(context);
        this.m = forumGoodsEnterLayout;
        forumGoodsEnterLayout.setOnAfterClickListener(this.o);
    }

    @Override // d.b.i.a
    public View g() {
        return this.m;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.m.d(tbPageContext, i);
    }

    public void t() {
        int g2 = d.b.b.e.p.l.g(this.f51762f, R.dimen.M_H_X003);
        r(g2);
        q(0);
        w(this.m, g2, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: u */
    public void a(d.b.h0.r.q.a aVar) {
        this.l = aVar;
        this.m.setSourceForPb(this.f51761e.i());
        this.m.setFrstype(this.n);
        this.m.setData(aVar);
    }

    public void v(int i) {
        this.n = i;
    }

    public void w(View view, int i, int i2) {
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
