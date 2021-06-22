package d.a.o0.b3.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55919a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55920b;

    /* renamed from: c  reason: collision with root package name */
    public b f55921c;

    /* renamed from: d  reason: collision with root package name */
    public u f55922d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55923e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55919a = tbPageContext;
        this.f55920b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f55919a);
        this.f55921c = bVar;
        this.f55923e.add(bVar);
        u uVar = new u(this.f55919a);
        this.f55922d = uVar;
        this.f55923e.add(uVar);
        this.f55920b.a(this.f55923e);
    }

    public void b() {
        this.f55920b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f55920b.setData(list);
    }
}
