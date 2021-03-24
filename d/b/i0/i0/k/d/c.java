package d.b.i0.i0.k.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.b.i0.x.b<d.b.i0.i0.k.c.d> {
    public TbPageContext m;
    public int n;
    public TextView o;
    public View p;
    public TextView q;
    public d.b.i0.i0.k.c.d r;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        this.m = tbPageContext;
        u();
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.n = i;
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b0<d.b.i0.i0.k.c.d> i;
        if (view != this.q || (i = i()) == null || this.r.o() >= this.r.j().size()) {
            return;
        }
        i.a(view, this.r);
    }

    public final void u() {
        View m = m();
        this.o = (TextView) m.findViewById(R.id.recommend_title);
        this.p = m.findViewById(R.id.top_line);
        TextView textView = (TextView) m.findViewById(R.id.recommend_update);
        this.q = textView;
        textView.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(d.b.i0.i0.k.c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.r = dVar;
        o(this.m, this.n);
        if (StringUtils.isNull(dVar.u())) {
            return;
        }
        this.o.setText(dVar.u());
    }

    public void w(boolean z) {
        this.p.setVisibility(z ? 0 : 8);
    }
}
