package d.a.j0.q0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.a.c.j.e.n;
import d.a.j0.d0.h;
import d.a.j0.q0.x;
import d.a.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58781a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58782b;

    /* renamed from: d  reason: collision with root package name */
    public String f58784d;

    /* renamed from: e  reason: collision with root package name */
    public String f58785e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f58786f = new C1466a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58783c = new ArrayList();

    /* renamed from: d.a.j0.q0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1466a extends b0 {
        public C1466a() {
        }

        @Override // d.a.j0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f58781a = tbPageContext;
        this.f58782b = bdTypeListView;
        this.f58784d = str;
        this.f58785e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f58781a, this.f58784d, this.f58785e);
        bVar.j0(this.f58786f);
        this.f58783c.add(bVar);
        c cVar = new c(this.f58781a, this.f58784d);
        cVar.j0(this.f58786f);
        this.f58783c.add(cVar);
        this.f58783c.add(new f(this.f58781a, this.f58784d));
        this.f58783c.add(new e(this.f58781a, this.f58784d));
        List<d.a.c.j.e.a> list = this.f58783c;
        TbPageContext tbPageContext = this.f58781a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f51872f, tbPageContext.getUniqueId(), this.f58784d));
        d dVar = new d(this.f58781a, this.f58784d);
        dVar.h0(this.f58786f);
        this.f58783c.add(dVar);
        List<d.a.c.j.e.a> list2 = this.f58783c;
        TbPageContext tbPageContext2 = this.f58781a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.j0.d0.c.f51862f, tbPageContext2.getUniqueId(), this.f58784d));
        List<d.a.c.j.e.a> list3 = this.f58783c;
        TbPageContext tbPageContext3 = this.f58781a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.j0.d0.f.f51868f, tbPageContext3.getUniqueId(), this.f58784d));
        TbPageContext tbPageContext4 = this.f58781a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.f58919i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.x0();
        frsUserRecommendAdapter.w0(this.f58784d);
        this.f58783c.add(frsUserRecommendAdapter);
        this.f58782b.a(this.f58783c);
    }

    public void b() {
        if (this.f58782b.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f58782b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f58782b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
