package d.b.i0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.i0.t.d.c.d.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61870a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61871b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f61872c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f61873d;

    /* renamed from: e  reason: collision with root package name */
    public e f61874e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.c.d.c f61875f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.t.d.c.d.b f61876g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.c.d.a f61877h;
    public int i;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        this.f61870a = tbPageContext;
        this.f61871b = tbPageContext.getPageActivity();
        this.f61872c = bdTypeRecyclerView;
        this.i = i;
        a();
    }

    public final void a() {
        this.f61873d = new ArrayList();
        this.f61874e = new e(this.f61870a, this.i);
        this.f61875f = new d.b.i0.t.d.c.d.c(this.f61870a);
        this.f61876g = new d.b.i0.t.d.c.d.b(this.f61870a);
        this.f61877h = new d.b.i0.t.d.c.d.a(this.f61870a);
        this.f61873d.add(this.f61874e);
        this.f61873d.add(this.f61875f);
        this.f61873d.add(this.f61876g);
        this.f61873d.add(this.f61877h);
        this.f61872c.a(this.f61873d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f61872c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f61872c.setData(list);
    }
}
