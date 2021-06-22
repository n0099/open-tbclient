package d.a.o0.e2.k.g.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes5.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends d.a.c.k.e.a<T, V> {
    public d.a.o0.e2.k.a m;
    public boolean n;

    public a(d.a.o0.e2.k.a aVar, BdUniqueId bdUniqueId) {
        this(aVar, bdUniqueId, null);
    }

    public void setFromCDN(boolean z) {
        this.n = z;
    }

    public a(d.a.o0.e2.k.a aVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(aVar.getPageContext().getPageActivity(), bdUniqueId, bdUniqueId2);
        this.n = false;
        this.m = aVar;
    }
}
