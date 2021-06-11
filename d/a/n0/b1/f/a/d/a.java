package d.a.n0.b1.f.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import d.a.c.k.e.s;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.a.c.k.e.a<T, V> {
    public boolean m;
    public TbPageContext<?> n;
    public s o;
    public d.a.m0.m.f p;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.m = true;
        o(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    @Override // d.a.c.k.e.a
    public View X(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return view;
    }

    @Override // d.a.c.k.e.a
    public void c0(BdUniqueId bdUniqueId) {
        this.f42913i = bdUniqueId;
    }

    public void e0(View view, a2 a2Var) {
        d.a.m0.m.f fVar = this.p;
        if (fVar != null) {
            int i2 = a2Var.position;
            fVar.a(view, a2Var, i2, i2);
        }
    }

    public boolean g0() {
        return this.m;
    }

    public void h0(d.a.m0.m.f fVar) {
        this.p = fVar;
    }

    public void i0(s sVar) {
        this.o = sVar;
    }

    public void j0(View view, a2 a2Var, int i2, long j) {
        d.a.m0.m.f fVar = this.p;
        if (fVar != null) {
            fVar.c(view, a2Var, i2, j);
        }
    }

    public void o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f42909e = tbPageContext.getPageActivity();
            this.n = tbPageContext;
            this.f42913i = bdUniqueId;
        }
    }

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.m = true;
        TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
        this.n = pageContext;
        o(pageContext, pageContext == null ? null : pageContext.getUniqueId());
    }
}
