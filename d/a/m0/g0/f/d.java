package d.a.m0.g0.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.a.m0.g0.d.b;
import d.a.m0.g0.f.a;
/* loaded from: classes3.dex */
public class d<D, S extends d.a.m0.g0.d.b, H extends a<D, S>> extends c<D, S, H> {
    public final Class<H> r;
    public final int s;

    public d(TbPageContext<?> tbPageContext, Class<H> cls, int i2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.s = i2;
        this.r = cls;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i2) {
        if (this.k && e()) {
            return -1;
        }
        return super.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.k && e()) {
            return a();
        }
        b();
        return f(view, i2, this.r, this.s);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }
}
