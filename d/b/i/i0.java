package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class i0 extends h {
    public ThreadSmartAppLayout l;
    public d.b.h0.r.q.a m;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i0.this.d() != null) {
                i0.this.d().a(view, i0.this.m);
            }
        }
    }

    public i0(Context context) {
        super(context);
        r(d.b.b.e.p.l.g(context, R.dimen.M_H_X003));
        this.l = new ThreadSmartAppLayout(context);
        this.l.setAfterClickListener(new a());
    }

    @Override // d.b.i.a
    public View g() {
        return this.l;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ThreadSmartAppLayout threadSmartAppLayout = this.l;
        if (threadSmartAppLayout != null) {
            threadSmartAppLayout.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: t */
    public void a(d.b.h0.r.q.a aVar) {
        this.m = aVar;
        this.l.a(aVar);
    }
}
