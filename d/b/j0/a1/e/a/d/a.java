package d.b.j0.a1.e.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import d.b.c.j.e.s;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.b.c.j.e.a<T, V> {
    public boolean m;
    public TbPageContext<?> n;
    public s o;
    public d.b.i0.m.f p;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.m = true;
        i(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    @Override // d.b.c.j.e.a
    public View X(int i, View view, ViewGroup viewGroup, T t, V v) {
        return view;
    }

    @Override // d.b.c.j.e.a
    public void f0(BdUniqueId bdUniqueId) {
        this.i = bdUniqueId;
    }

    public void h0(View view, a2 a2Var) {
        d.b.i0.m.f fVar = this.p;
        if (fVar != null) {
            int i = a2Var.position;
            fVar.a(view, a2Var, i, i);
        }
    }

    public void i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.f43095e = tbPageContext.getPageActivity();
            this.n = tbPageContext;
            this.i = bdUniqueId;
        }
    }

    public boolean i0() {
        return this.m;
    }

    public void j0(d.b.i0.m.f fVar) {
        this.p = fVar;
    }

    public void l0(s sVar) {
        this.o = sVar;
    }

    public void m0(View view, a2 a2Var, int i, long j) {
        d.b.i0.m.f fVar = this.p;
        if (fVar != null) {
            fVar.c(view, a2Var, i, j);
        }
    }

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.m = true;
        TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
        this.n = pageContext;
        i(pageContext, pageContext == null ? null : pageContext.getUniqueId());
    }
}
