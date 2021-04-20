package d.b.i0.q0.q1.a;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f60002a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f60003b;

    /* renamed from: c  reason: collision with root package name */
    public d f60004c;

    /* renamed from: d  reason: collision with root package name */
    public c f60005d;

    /* renamed from: e  reason: collision with root package name */
    public b f60006e;

    public a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f60003b = bdTypeRecyclerView;
        this.f60004c = new d(forumRulesShowActivity, d.b.i0.q0.q1.c.b.q);
        this.f60005d = new c(forumRulesShowActivity, d.b.i0.q0.q1.c.c.f60019h);
        this.f60006e = new b(forumRulesShowActivity, d.b.i0.q0.q1.c.a.j);
        this.f60002a.add(this.f60004c);
        this.f60002a.add(this.f60005d);
        this.f60002a.add(this.f60006e);
        bdTypeRecyclerView.a(this.f60002a);
    }

    public void b(int i) {
    }

    public void c(List<n> list) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60003b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(list);
        }
        c cVar = this.f60005d;
        if (cVar != null) {
            cVar.m0(list);
        }
    }

    public void d(String str) {
        d dVar = this.f60004c;
        if (dVar != null) {
            dVar.setFrom(str);
        }
        b bVar = this.f60006e;
        if (bVar != null) {
            bVar.setFrom(str);
        }
    }
}
