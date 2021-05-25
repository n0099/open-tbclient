package d.a.n0.v.d.c;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.n0.v.d.c.d.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61486a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61487b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f61488c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f61489d;

    /* renamed from: e  reason: collision with root package name */
    public d f61490e;

    /* renamed from: f  reason: collision with root package name */
    public d f61491f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.v.d.c.d.c f61492g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.v.d.c.d.b f61493h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.v.d.c.d.a f61494i;
    public int j;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i2) {
        this.f61486a = tbPageContext;
        this.f61487b = tbPageContext.getPageActivity();
        this.f61488c = bdTypeRecyclerView;
        this.j = i2;
        a();
    }

    public final void a() {
        this.f61489d = new ArrayList();
        this.f61490e = new d(this.f61486a, this.j, false);
        this.f61491f = new d(this.f61486a, this.j, true);
        this.f61492g = new d.a.n0.v.d.c.d.c(this.f61486a);
        this.f61493h = new d.a.n0.v.d.c.d.b(this.f61486a);
        this.f61494i = new d.a.n0.v.d.c.d.a(this.f61486a);
        this.f61489d.add(this.f61490e);
        this.f61489d.add(this.f61491f);
        this.f61489d.add(this.f61492g);
        this.f61489d.add(this.f61493h);
        this.f61489d.add(this.f61494i);
        this.f61488c.a(this.f61489d);
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f61488c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f61488c.setData(list);
    }
}
