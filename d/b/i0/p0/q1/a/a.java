package d.b.i0.p0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f58339a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58340b;

    /* renamed from: c  reason: collision with root package name */
    public d f58341c;

    /* renamed from: d  reason: collision with root package name */
    public c f58342d;

    /* renamed from: e  reason: collision with root package name */
    public b f58343e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58340b = bdTypeRecyclerView;
        this.f58341c = new d(forumRulesShowActivity, d.b.i0.p0.q1.c.b.q);
        this.f58342d = new c(forumRulesShowActivity, d.b.i0.p0.q1.c.c.f58356h);
        this.f58343e = new b(forumRulesShowActivity, d.b.i0.p0.q1.c.a.j);
        this.f58339a.add(this.f58341c);
        this.f58339a.add(this.f58342d);
        this.f58339a.add(this.f58343e);
        bdTypeRecyclerView.a(this.f58339a);
    }

    public void b(int i) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58340b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f58342d;
        if (cVar != null) {
            cVar.m0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f58341c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f58343e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
