package d.b.i0.a3.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f53086a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f53087b;

    /* renamed from: c  reason: collision with root package name */
    public b f53088c;

    /* renamed from: d  reason: collision with root package name */
    public u f53089d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53090e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53086a = tbPageContext;
        this.f53087b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f53086a);
        this.f53088c = bVar;
        this.f53090e.add(bVar);
        u uVar = new u(this.f53086a);
        this.f53089d = uVar;
        this.f53090e.add(uVar);
        this.f53087b.a(this.f53090e);
    }

    public void b() {
        this.f53087b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f53087b.setData(list);
    }
}
