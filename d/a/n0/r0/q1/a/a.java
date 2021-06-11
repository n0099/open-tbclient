package d.a.n0.r0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f63090a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63091b;

    /* renamed from: c  reason: collision with root package name */
    public d f63092c;

    /* renamed from: d  reason: collision with root package name */
    public c f63093d;

    /* renamed from: e  reason: collision with root package name */
    public b f63094e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f63091b = bdTypeRecyclerView;
        this.f63092c = new d(forumRulesShowActivity, d.a.n0.r0.q1.c.b.q);
        this.f63093d = new c(forumRulesShowActivity, d.a.n0.r0.q1.c.c.f63109h);
        this.f63094e = new b(forumRulesShowActivity, d.a.n0.r0.q1.c.a.j);
        this.f63090a.add(this.f63092c);
        this.f63090a.add(this.f63093d);
        this.f63090a.add(this.f63094e);
        bdTypeRecyclerView.a(this.f63090a);
    }

    public void b(int i2) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63091b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f63093d;
        if (cVar != null) {
            cVar.j0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f63092c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f63094e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
