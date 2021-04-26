package d.a.j0.q0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f58516a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58517b;

    /* renamed from: c  reason: collision with root package name */
    public d f58518c;

    /* renamed from: d  reason: collision with root package name */
    public c f58519d;

    /* renamed from: e  reason: collision with root package name */
    public b f58520e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f58517b = bdTypeRecyclerView;
        this.f58518c = new d(forumRulesShowActivity, d.a.j0.q0.q1.c.b.q);
        this.f58519d = new c(forumRulesShowActivity, d.a.j0.q0.q1.c.c.f58535h);
        this.f58520e = new b(forumRulesShowActivity, d.a.j0.q0.q1.c.a.j);
        this.f58516a.add(this.f58518c);
        this.f58516a.add(this.f58519d);
        this.f58516a.add(this.f58520e);
        bdTypeRecyclerView.a(this.f58516a);
    }

    public void b(int i2) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f58517b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f58519d;
        if (cVar != null) {
            cVar.i0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f58518c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f58520e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
