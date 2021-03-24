package d.b.i0.i0.m;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import d.b.h0.r.s.h;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends j {
    public TbPageContext o;
    public Context p;
    public ViewEventCenter q;
    public final l r;
    public d.b.i0.i0.d.f s;
    public final List<h> t;
    public final l.e u;

    /* loaded from: classes4.dex */
    public class a implements l.e {
        public a() {
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(l lVar, int i, View view) {
            d.this.dismiss();
            if (!d.b.b.e.p.j.z()) {
                d.b.b.e.p.l.K(d.this.p, R.string.network_not_available);
            } else if (i == 2) {
                d.this.q.dispatchMvcEvent(new d.b.h0.g0.c.b(4, d.this.s, null, null));
            } else if (i == 1) {
                d.this.q.dispatchMvcEvent(new d.b.h0.g0.c.b(13, d.this.s, null, null));
            }
        }
    }

    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        this.u = new a();
        this.o = tbPageContext;
        this.p = tbPageContext.getPageActivity();
        this.q = viewEventCenter;
        this.t = new ArrayList();
        l lVar = new l(this.p);
        this.r = lVar;
        lVar.n(this.u);
        h(this.r);
    }

    public final void p() {
        List<h> list;
        if (this.s == null || (list = this.t) == null || this.r == null) {
            return;
        }
        list.clear();
        this.t.add(new h(1, q(this.s.E() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.r));
        this.t.add(new h(2, q(R.string.delete, new Object[0]), this.r));
        this.r.k(this.t);
    }

    public final String q(int i, Object... objArr) {
        Context context = this.p;
        if (context == null) {
            return null;
        }
        return context.getString(i, objArr);
    }

    public void r() {
        l lVar = this.r;
        if (lVar != null) {
            lVar.j();
        }
    }

    public void s(d.b.i0.i0.d.f fVar) {
        this.s = fVar;
        p();
    }
}
