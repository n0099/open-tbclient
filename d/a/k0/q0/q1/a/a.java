package d.a.k0.q0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f59258a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59259b;

    /* renamed from: c  reason: collision with root package name */
    public d f59260c;

    /* renamed from: d  reason: collision with root package name */
    public c f59261d;

    /* renamed from: e  reason: collision with root package name */
    public b f59262e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f59259b = bdTypeRecyclerView;
        this.f59260c = new d(forumRulesShowActivity, d.a.k0.q0.q1.c.b.q);
        this.f59261d = new c(forumRulesShowActivity, d.a.k0.q0.q1.c.c.f59277h);
        this.f59262e = new b(forumRulesShowActivity, d.a.k0.q0.q1.c.a.j);
        this.f59258a.add(this.f59260c);
        this.f59258a.add(this.f59261d);
        this.f59258a.add(this.f59262e);
        bdTypeRecyclerView.a(this.f59258a);
    }

    public void b(int i2) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59259b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f59261d;
        if (cVar != null) {
            cVar.i0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f59260c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f59262e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
