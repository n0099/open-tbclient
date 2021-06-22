package d.a.o0.v.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.o0.v.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65324a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65325b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f65326c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65327d;

    /* renamed from: e  reason: collision with root package name */
    public d f65328e;

    /* renamed from: f  reason: collision with root package name */
    public d f65329f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.v.d.c.d.c f65330g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.v.d.c.d.b f65331h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.v.d.c.d.a f65332i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        this.f65324a = tbPageContext;
        this.f65325b = tbPageContext.getPageActivity();
        this.f65326c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        this.f65327d = new ArrayList();
        this.f65328e = new d(this.f65324a, this.j, false);
        this.f65329f = new d(this.f65324a, this.j, true);
        this.f65330g = new d.a.o0.v.d.c.d.c(this.f65324a);
        this.f65331h = new d.a.o0.v.d.c.d.b(this.f65324a);
        this.f65332i = new d.a.o0.v.d.c.d.a(this.f65324a);
        this.f65327d.add(this.f65328e);
        this.f65327d.add(this.f65329f);
        this.f65327d.add(this.f65330g);
        this.f65327d.add(this.f65331h);
        this.f65327d.add(this.f65332i);
        this.f65326c.a(this.f65327d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f65326c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f65326c.setData(list);
    }
}
