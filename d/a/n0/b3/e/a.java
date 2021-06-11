package d.a.n0.b3.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55794a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f55795b;

    /* renamed from: c  reason: collision with root package name */
    public b f55796c;

    /* renamed from: d  reason: collision with root package name */
    public u f55797d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55798e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f55794a = tbPageContext;
        this.f55795b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f55794a);
        this.f55796c = bVar;
        this.f55798e.add(bVar);
        u uVar = new u(this.f55794a);
        this.f55797d = uVar;
        this.f55798e.add(uVar);
        this.f55795b.a(this.f55798e);
    }

    public void b() {
        this.f55795b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f55795b.setData(list);
    }
}
