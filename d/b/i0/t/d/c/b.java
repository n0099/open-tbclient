package d.b.i0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60313a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60314b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f60315c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60316d;

    /* renamed from: e  reason: collision with root package name */
    public d f60317e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.c.d.a f60318f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60319g = false;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f60313a = tbPageContext;
        this.f60314b = tbPageContext.getPageActivity();
        this.f60315c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f60316d = new ArrayList();
        d dVar = new d(this.f60313a);
        this.f60317e = dVar;
        dVar.j0(this.f60319g);
        this.f60318f = new d.b.i0.t.d.c.d.a(this.f60313a);
        this.f60316d.add(this.f60317e);
        this.f60316d.add(this.f60318f);
        this.f60315c.a(this.f60316d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60315c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f60315c.setData(list);
    }

    public void d(boolean z) {
        this.f60319g = z;
    }
}
