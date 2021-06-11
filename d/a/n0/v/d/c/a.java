package d.a.n0.v.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.n0.v.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65199a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65200b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f65201c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65202d;

    /* renamed from: e  reason: collision with root package name */
    public d f65203e;

    /* renamed from: f  reason: collision with root package name */
    public d f65204f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.v.d.c.d.c f65205g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.v.d.c.d.b f65206h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.v.d.c.d.a f65207i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        this.f65199a = tbPageContext;
        this.f65200b = tbPageContext.getPageActivity();
        this.f65201c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        this.f65202d = new ArrayList();
        this.f65203e = new d(this.f65199a, this.j, false);
        this.f65204f = new d(this.f65199a, this.j, true);
        this.f65205g = new d.a.n0.v.d.c.d.c(this.f65199a);
        this.f65206h = new d.a.n0.v.d.c.d.b(this.f65199a);
        this.f65207i = new d.a.n0.v.d.c.d.a(this.f65199a);
        this.f65202d.add(this.f65203e);
        this.f65202d.add(this.f65204f);
        this.f65202d.add(this.f65205g);
        this.f65202d.add(this.f65206h);
        this.f65202d.add(this.f65207i);
        this.f65201c.a(this.f65202d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f65201c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f65201c.setData(list);
    }
}
