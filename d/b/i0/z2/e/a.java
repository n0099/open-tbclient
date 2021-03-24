package d.b.i0.z2.e;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f63466a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63467b;

    /* renamed from: c  reason: collision with root package name */
    public b f63468c;

    /* renamed from: d  reason: collision with root package name */
    public u f63469d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f63470e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63466a = tbPageContext;
        this.f63467b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f63466a);
        this.f63468c = bVar;
        this.f63470e.add(bVar);
        u uVar = new u(this.f63466a);
        this.f63469d = uVar;
        this.f63470e.add(uVar);
        this.f63467b.a(this.f63470e);
    }

    public void b() {
        this.f63467b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f63467b.setData(list);
    }
}
