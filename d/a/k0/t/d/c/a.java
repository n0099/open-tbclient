package d.a.k0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.k0.t.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61198a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61199b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f61200c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f61201d;

    /* renamed from: e  reason: collision with root package name */
    public d f61202e;

    /* renamed from: f  reason: collision with root package name */
    public d f61203f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.t.d.c.d.c f61204g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.t.d.c.d.b f61205h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.t.d.c.d.a f61206i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        this.f61198a = tbPageContext;
        this.f61199b = tbPageContext.getPageActivity();
        this.f61200c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        this.f61201d = new ArrayList();
        this.f61202e = new d(this.f61198a, this.j, false);
        this.f61203f = new d(this.f61198a, this.j, true);
        this.f61204g = new d.a.k0.t.d.c.d.c(this.f61198a);
        this.f61205h = new d.a.k0.t.d.c.d.b(this.f61198a);
        this.f61206i = new d.a.k0.t.d.c.d.a(this.f61198a);
        this.f61201d.add(this.f61202e);
        this.f61201d.add(this.f61203f);
        this.f61201d.add(this.f61204g);
        this.f61201d.add(this.f61205h);
        this.f61201d.add(this.f61206i);
        this.f61200c.a(this.f61201d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f61200c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f61200c.setData(list);
    }
}
