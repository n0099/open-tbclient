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
    public TbPageContext<?> f63467a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63468b;

    /* renamed from: c  reason: collision with root package name */
    public b f63469c;

    /* renamed from: d  reason: collision with root package name */
    public u f63470d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f63471e = new LinkedList();

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63467a = tbPageContext;
        this.f63468b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        b bVar = new b(this.f63467a);
        this.f63469c = bVar;
        this.f63471e.add(bVar);
        u uVar = new u(this.f63467a);
        this.f63470d = uVar;
        this.f63471e.add(uVar);
        this.f63468b.a(this.f63471e);
    }

    public void b() {
        this.f63468b.getAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        this.f63468b.setData(list);
    }
}
