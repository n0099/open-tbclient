package d.b.i0.p0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f58340a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58341b;

    /* renamed from: c  reason: collision with root package name */
    public d f58342c;

    /* renamed from: d  reason: collision with root package name */
    public c f58343d;

    /* renamed from: e  reason: collision with root package name */
    public b f58344e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58341b = bdTypeRecyclerView;
        this.f58342c = new d(forumRulesShowActivity, d.b.i0.p0.q1.c.b.q);
        this.f58343d = new c(forumRulesShowActivity, d.b.i0.p0.q1.c.c.f58357h);
        this.f58344e = new b(forumRulesShowActivity, d.b.i0.p0.q1.c.a.j);
        this.f58340a.add(this.f58342c);
        this.f58340a.add(this.f58343d);
        this.f58340a.add(this.f58344e);
        bdTypeRecyclerView.a(this.f58340a);
    }

    public void b(int i) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58341b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f58343d;
        if (cVar != null) {
            cVar.m0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f58342c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f58344e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
