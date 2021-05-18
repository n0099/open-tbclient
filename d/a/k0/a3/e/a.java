package d.a.k0.a3.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f51938a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51939b;

    /* renamed from: c  reason: collision with root package name */
    public b f51940c;

    /* renamed from: d  reason: collision with root package name */
    public u f51941d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51942e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51938a = tbPageContext;
        this.f51939b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f51938a);
        this.f51940c = bVar;
        this.f51942e.add(bVar);
        u uVar = new u(this.f51938a);
        this.f51941d = uVar;
        this.f51942e.add(uVar);
        this.f51939b.a(this.f51942e);
    }

    public void b() {
        this.f51939b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f51939b.setData(list);
    }
}
