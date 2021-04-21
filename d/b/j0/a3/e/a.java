package d.b.j0.a3.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f53507a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f53508b;

    /* renamed from: c  reason: collision with root package name */
    public b f53509c;

    /* renamed from: d  reason: collision with root package name */
    public u f53510d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53511e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53507a = tbPageContext;
        this.f53508b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f53507a);
        this.f53509c = bVar;
        this.f53511e.add(bVar);
        u uVar = new u(this.f53507a);
        this.f53510d = uVar;
        this.f53511e.add(uVar);
        this.f53508b.a(this.f53511e);
    }

    public void b() {
        this.f53508b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f53508b.setData(list);
    }
}
