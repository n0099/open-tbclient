package d.b.i0.d2.k.g.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes3.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.b.c.j.e.a<T, V> {
    public d.b.i0.d2.k.a m;
    public boolean n;

    public a(d.b.i0.d2.k.a aVar, BdUniqueId bdUniqueId) {
        this(aVar, bdUniqueId, null);
    }

    public void setFromCDN(boolean z) {
        this.n = z;
    }

    public a(d.b.i0.d2.k.a aVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(aVar.getPageContext().getPageActivity(), bdUniqueId, bdUniqueId2);
        this.n = false;
        this.m = aVar;
    }
}
