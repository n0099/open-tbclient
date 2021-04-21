package d.b.j0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.j0.t.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62299a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62300b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f62301c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f62302d;

    /* renamed from: e  reason: collision with root package name */
    public d f62303e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.t.d.c.d.a f62304f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62305g = false;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f62299a = tbPageContext;
        this.f62300b = tbPageContext.getPageActivity();
        this.f62301c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f62302d = new ArrayList();
        d dVar = new d(this.f62299a);
        this.f62303e = dVar;
        dVar.j0(this.f62305g);
        this.f62304f = new d.b.j0.t.d.c.d.a(this.f62299a);
        this.f62302d.add(this.f62303e);
        this.f62302d.add(this.f62304f);
        this.f62301c.a(this.f62302d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62301c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f62301c.setData(list);
    }

    public void d(boolean z) {
        this.f62305g = z;
    }
}
