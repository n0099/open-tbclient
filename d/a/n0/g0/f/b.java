package d.a.n0.g0.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.a.n0.g0.d.b;
import d.a.n0.g0.f.a;
import java.security.InvalidParameterException;
/* loaded from: classes3.dex */
public abstract class b<D, S extends d.a.n0.g0.d.b, H extends a<D, S>> extends c<D, S, H> {
    public final Class<?>[] r;
    public final int[] s;

    public b(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.r = clsArr;
        this.s = iArr;
        if (clsArr == null || iArr == null || clsArr.length == 0 || iArr.length == 0 || clsArr.length != iArr.length) {
            throw new InvalidParameterException("BaseMulitiListAdapter new failed");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.k && e()) {
            return -1;
        }
        return o(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.k && e()) {
            return a();
        }
        b();
        int itemViewType = getItemViewType(i2);
        Class<?> cls = this.r[itemViewType];
        int i3 = this.s[itemViewType];
        if (cls != null) {
            if (i3 != 0) {
                return f(view, i2, cls, i3);
            }
            throw new InvalidParameterException("BaseMulitiListAdapter holder layout error");
        }
        throw new InvalidParameterException("BaseMulitiListAdapter holder class error");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return this.r.length + 1;
    }

    public abstract int o(int i2);
}
