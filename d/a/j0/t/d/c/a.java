package d.a.j0.t.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.j0.t.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60474a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60475b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f60476c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f60477d;

    /* renamed from: e  reason: collision with root package name */
    public d f60478e;

    /* renamed from: f  reason: collision with root package name */
    public d f60479f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.t.d.c.d.c f60480g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.t.d.c.d.b f60481h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.t.d.c.d.a f60482i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        this.f60474a = tbPageContext;
        this.f60475b = tbPageContext.getPageActivity();
        this.f60476c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        this.f60477d = new ArrayList();
        this.f60478e = new d(this.f60474a, this.j, false);
        this.f60479f = new d(this.f60474a, this.j, true);
        this.f60480g = new d.a.j0.t.d.c.d.c(this.f60474a);
        this.f60481h = new d.a.j0.t.d.c.d.b(this.f60474a);
        this.f60482i = new d.a.j0.t.d.c.d.a(this.f60474a);
        this.f60477d.add(this.f60478e);
        this.f60477d.add(this.f60479f);
        this.f60477d.add(this.f60480g);
        this.f60477d.add(this.f60481h);
        this.f60477d.add(this.f60482i);
        this.f60476c.a(this.f60477d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60476c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f60476c.setData(list);
    }
}
