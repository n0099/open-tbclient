package d.a.n0.b3.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f52105a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f52106b;

    /* renamed from: c  reason: collision with root package name */
    public b f52107c;

    /* renamed from: d  reason: collision with root package name */
    public u f52108d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52109e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f52105a = tbPageContext;
        this.f52106b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f52105a);
        this.f52107c = bVar;
        this.f52109e.add(bVar);
        u uVar = new u(this.f52105a);
        this.f52108d = uVar;
        this.f52109e.add(uVar);
        this.f52106b.a(this.f52109e);
    }

    public void b() {
        this.f52106b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f52106b.setData(list);
    }
}
