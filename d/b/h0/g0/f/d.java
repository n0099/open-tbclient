package d.b.h0.g0.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.b.h0.g0.d.b;
import d.b.h0.g0.f.a;
/* loaded from: classes3.dex */
public class d<D, S extends d.b.h0.g0.d.b, H extends a<D, S>> extends c<D, S, H> {
    public final Class<H> r;
    public final int s;

    public d(TbPageContext<?> tbPageContext, Class<H> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.s = i;
        this.r = cls;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.k && e()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.k && e()) {
            return a();
        }
        b();
        return f(view, i, this.r, this.s);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }
}
