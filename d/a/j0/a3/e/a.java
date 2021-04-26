package d.a.j0.a3.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f51239a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f51240b;

    /* renamed from: c  reason: collision with root package name */
    public b f51241c;

    /* renamed from: d  reason: collision with root package name */
    public u f51242d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51243e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f51239a = tbPageContext;
        this.f51240b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f51239a);
        this.f51241c = bVar;
        this.f51243e.add(bVar);
        u uVar = new u(this.f51239a);
        this.f51242d = uVar;
        this.f51243e.add(uVar);
        this.f51240b.a(this.f51243e);
    }

    public void b() {
        this.f51240b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f51240b.setData(list);
    }
}
