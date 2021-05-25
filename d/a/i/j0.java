package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j0 extends h {
    public ThreadSmartAppLayout l;
    public d.a.m0.r.q.a m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j0.this.d() != null) {
                j0.this.d().a(view, j0.this.m);
            }
        }
    }

    public j0(Context context) {
        super(context);
        r(d.a.c.e.p.l.g(context, R.dimen.M_H_X003));
        this.l = new ThreadSmartAppLayout(context);
        this.l.setAfterClickListener(new a());
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        ThreadSmartAppLayout threadSmartAppLayout = this.l;
        if (threadSmartAppLayout != null) {
            threadSmartAppLayout.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: t */
    public void a(d.a.m0.r.q.a aVar) {
        this.m = aVar;
        this.l.a(aVar);
    }
}
