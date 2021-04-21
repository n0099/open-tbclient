package d.b.j0.q0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f60423a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f60424b;

    /* renamed from: c  reason: collision with root package name */
    public d f60425c;

    /* renamed from: d  reason: collision with root package name */
    public c f60426d;

    /* renamed from: e  reason: collision with root package name */
    public b f60427e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f60424b = bdTypeRecyclerView;
        this.f60425c = new d(forumRulesShowActivity, d.b.j0.q0.q1.c.b.q);
        this.f60426d = new c(forumRulesShowActivity, d.b.j0.q0.q1.c.c.f60440h);
        this.f60427e = new b(forumRulesShowActivity, d.b.j0.q0.q1.c.a.j);
        this.f60423a.add(this.f60425c);
        this.f60423a.add(this.f60426d);
        this.f60423a.add(this.f60427e);
        bdTypeRecyclerView.a(this.f60423a);
    }

    public void b(int i) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60424b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f60426d;
        if (cVar != null) {
            cVar.m0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f60425c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f60427e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
