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
    public TbPageContext f60314a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60315b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f60316c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60317d;

    /* renamed from: e  reason: collision with root package name */
    public d f60318e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.c.d.a f60319f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60320g = false;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f60314a = tbPageContext;
        this.f60315b = tbPageContext.getPageActivity();
        this.f60316c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f60317d = new ArrayList();
        d dVar = new d(this.f60314a);
        this.f60318e = dVar;
        dVar.j0(this.f60320g);
        this.f60319f = new d.b.i0.t.d.c.d.a(this.f60314a);
        this.f60317d.add(this.f60318e);
        this.f60317d.add(this.f60319f);
        this.f60316c.a(this.f60317d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60316c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f60316c.setData(list);
    }

    public void d(boolean z) {
        this.f60320g = z;
    }
}
