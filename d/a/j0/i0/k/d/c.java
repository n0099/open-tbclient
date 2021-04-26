package d.a.j0.i0.k.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.a.j0.x.b<d.a.j0.i0.k.c.d> {
    public TbPageContext m;
    public int n;
    public TextView o;
    public View p;
    public TextView q;
    public d.a.j0.i0.k.c.d r;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        this.m = tbPageContext;
        s();
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        this.n = i2;
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b0<d.a.j0.i0.k.c.d> h2;
        if (view != this.q || (h2 = h()) == null || this.r.p() >= this.r.l().size()) {
            return;
        }
        h2.a(view, this.r);
    }

    public final void s() {
        View l = l();
        this.o = (TextView) l.findViewById(R.id.recommend_title);
        this.p = l.findViewById(R.id.top_line);
        TextView textView = (TextView) l.findViewById(R.id.recommend_update);
        this.q = textView;
        textView.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(d.a.j0.i0.k.c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.r = dVar;
        n(this.m, this.n);
        if (StringUtils.isNull(dVar.u())) {
            return;
        }
        this.o.setText(dVar.u());
    }

    public void u(boolean z) {
        this.p.setVisibility(z ? 0 : 8);
    }
}
