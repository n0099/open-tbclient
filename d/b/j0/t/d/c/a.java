package d.b.j0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.j0.t.d.c.d.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62291a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62292b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f62293c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f62294d;

    /* renamed from: e  reason: collision with root package name */
    public e f62295e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.t.d.c.d.c f62296f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.t.d.c.d.b f62297g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.t.d.c.d.a f62298h;
    public int i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.f62291a = tbPageContext;
        this.f62292b = tbPageContext.getPageActivity();
        this.f62293c = bdTypeRecyclerView;
        this.i = i;
        a();
    }

    public final void a() {
        this.f62294d = new ArrayList();
        this.f62295e = new e(this.f62291a, this.i);
        this.f62296f = new d.b.j0.t.d.c.d.c(this.f62291a);
        this.f62297g = new d.b.j0.t.d.c.d.b(this.f62291a);
        this.f62298h = new d.b.j0.t.d.c.d.a(this.f62291a);
        this.f62294d.add(this.f62295e);
        this.f62294d.add(this.f62296f);
        this.f62294d.add(this.f62297g);
        this.f62294d.add(this.f62298h);
        this.f62293c.a(this.f62294d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62293c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f62293c.setData(list);
    }
}
