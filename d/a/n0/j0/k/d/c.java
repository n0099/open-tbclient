package d.a.n0.j0.k.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class c extends d.a.n0.z.b<d.a.n0.j0.k.c.d> {
    public TbPageContext m;
    public int n;
    public TextView o;
    public View p;
    public TextView q;
    public d.a.n0.j0.k.c.d r;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        this.m = tbPageContext;
        t();
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        this.n = i2;
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b0<d.a.n0.j0.k.c.d> i2;
        if (view != this.q || (i2 = i()) == null || this.r.k() >= this.r.g().size()) {
            return;
        }
        i2.a(view, this.r);
    }

    public final void t() {
        View m = m();
        this.o = (TextView) m.findViewById(R.id.recommend_title);
        this.p = m.findViewById(R.id.top_line);
        TextView textView = (TextView) m.findViewById(R.id.recommend_update);
        this.q = textView;
        textView.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: u */
    public void n(d.a.n0.j0.k.c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.r = dVar;
        o(this.m, this.n);
        if (StringUtils.isNull(dVar.q())) {
            return;
        }
        this.o.setText(dVar.q());
    }

    public void v(boolean z) {
        this.p.setVisibility(z ? 0 : 8);
    }
}
