package d.a.n0.r0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f59399a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59400b;

    /* renamed from: c  reason: collision with root package name */
    public d f59401c;

    /* renamed from: d  reason: collision with root package name */
    public c f59402d;

    /* renamed from: e  reason: collision with root package name */
    public b f59403e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59400b = bdTypeRecyclerView;
        this.f59401c = new d(forumRulesShowActivity, d.a.n0.r0.q1.c.b.q);
        this.f59402d = new c(forumRulesShowActivity, d.a.n0.r0.q1.c.c.f59418h);
        this.f59403e = new b(forumRulesShowActivity, d.a.n0.r0.q1.c.a.j);
        this.f59399a.add(this.f59401c);
        this.f59399a.add(this.f59402d);
        this.f59399a.add(this.f59403e);
        bdTypeRecyclerView.a(this.f59399a);
    }

    public void b(int i2) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59400b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f59402d;
        if (cVar != null) {
            cVar.i0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f59401c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f59403e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
