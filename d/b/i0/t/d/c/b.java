package d.b.i0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.i0.t.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61878a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61879b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f61880c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f61881d;

    /* renamed from: e  reason: collision with root package name */
    public d f61882e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.t.d.c.d.a f61883f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61884g = false;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f61878a = tbPageContext;
        this.f61879b = tbPageContext.getPageActivity();
        this.f61880c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        this.f61881d = new ArrayList();
        d dVar = new d(this.f61878a);
        this.f61882e = dVar;
        dVar.j0(this.f61884g);
        this.f61883f = new d.b.i0.t.d.c.d.a(this.f61878a);
        this.f61881d.add(this.f61882e);
        this.f61881d.add(this.f61883f);
        this.f61880c.a(this.f61881d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f61880c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f61880c.setData(list);
    }

    public void d(boolean z) {
        this.f61884g = z;
    }
}
