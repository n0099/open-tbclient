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
    public TbPageContext f60305a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60306b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f60307c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60308d;

    /* renamed from: e  reason: collision with root package name */
    public e f60309e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.c.d.c f60310f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.t.d.c.d.b f60311g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.c.d.a f60312h;
    public int i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.f60305a = tbPageContext;
        this.f60306b = tbPageContext.getPageActivity();
        this.f60307c = bdTypeRecyclerView;
        this.i = i;
        a();
    }

    public final void a() {
        this.f60308d = new ArrayList();
        this.f60309e = new e(this.f60305a, this.i);
        this.f60310f = new d.b.i0.t.d.c.d.c(this.f60305a);
        this.f60311g = new d.b.i0.t.d.c.d.b(this.f60305a);
        this.f60312h = new d.b.i0.t.d.c.d.a(this.f60305a);
        this.f60308d.add(this.f60309e);
        this.f60308d.add(this.f60310f);
        this.f60308d.add(this.f60311g);
        this.f60308d.add(this.f60312h);
        this.f60307c.a(this.f60308d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60307c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f60307c.setData(list);
    }
}
