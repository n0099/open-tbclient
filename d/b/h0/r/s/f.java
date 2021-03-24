package d.b.h0.r.s;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends e {
    public TextView l;
    public TextView m;
    public View.OnClickListener n;
    public int o;
    public int p;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.o = R.color.CAM_X0304;
        this.p = R.color.CAM_X0107;
        this.l = (TextView) e().findViewById(R.id.title_ok);
        this.m = (TextView) e().findViewById(R.id.title_cancel);
        i(true);
    }

    @Override // d.b.h0.r.s.e
    public void b(d.b.b.a.f<?> fVar) {
        super.b(fVar);
        o();
    }

    @Override // d.b.h0.r.s.e
    public void f() {
    }

    @Override // d.b.h0.r.s.e
    public void h(int i) {
        j(i);
    }

    public final void o() {
        d.b.h0.r.u.c.a(this.l).p(this.o);
        d.b.h0.r.u.c.a(this.m).p(this.p);
    }

    public f p(int i, View.OnClickListener onClickListener) {
        this.m.setText(i);
        this.m.setOnClickListener(onClickListener);
        this.m.setVisibility(0);
        return this;
    }

    public f q(int i, View.OnClickListener onClickListener) {
        this.l.setText(i);
        this.l.setOnClickListener(onClickListener);
        this.l.setVisibility(0);
        this.n = onClickListener;
        return this;
    }

    public void r(boolean z) {
        if (z) {
            this.o = R.color.CAM_X0304;
            this.l.setEnabled(true);
            this.l.setOnClickListener(this.n);
        } else {
            this.o = R.color.CAM_X0110;
            this.l.setEnabled(false);
            this.l.setOnClickListener(null);
        }
        o();
    }
}
