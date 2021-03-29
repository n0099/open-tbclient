package d.b.i0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.i0.t.d.c.d.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60306a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60307b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f60308c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60309d;

    /* renamed from: e  reason: collision with root package name */
    public e f60310e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.c.d.c f60311f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.t.d.c.d.b f60312g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.c.d.a f60313h;
    public int i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.f60306a = tbPageContext;
        this.f60307b = tbPageContext.getPageActivity();
        this.f60308c = bdTypeRecyclerView;
        this.i = i;
        a();
    }

    public final void a() {
        this.f60309d = new ArrayList();
        this.f60310e = new e(this.f60306a, this.i);
        this.f60311f = new d.b.i0.t.d.c.d.c(this.f60306a);
        this.f60312g = new d.b.i0.t.d.c.d.b(this.f60306a);
        this.f60313h = new d.b.i0.t.d.c.d.a(this.f60306a);
        this.f60309d.add(this.f60310e);
        this.f60309d.add(this.f60311f);
        this.f60309d.add(this.f60312g);
        this.f60309d.add(this.f60313h);
        this.f60308c.a(this.f60309d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60308c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f60308c.setData(list);
    }
}
