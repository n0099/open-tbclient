package d.a.o0.r0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f63215a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63216b;

    /* renamed from: c  reason: collision with root package name */
    public d f63217c;

    /* renamed from: d  reason: collision with root package name */
    public c f63218d;

    /* renamed from: e  reason: collision with root package name */
    public b f63219e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63216b = bdTypeRecyclerView;
        this.f63217c = new d(forumRulesShowActivity, d.a.o0.r0.q1.c.b.q);
        this.f63218d = new c(forumRulesShowActivity, d.a.o0.r0.q1.c.c.f63234h);
        this.f63219e = new b(forumRulesShowActivity, d.a.o0.r0.q1.c.a.j);
        this.f63215a.add(this.f63217c);
        this.f63215a.add(this.f63218d);
        this.f63215a.add(this.f63219e);
        bdTypeRecyclerView.a(this.f63215a);
    }

    public void b(int i2) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63216b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f63218d;
        if (cVar != null) {
            cVar.j0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f63217c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f63219e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
