package d.b.i0.p0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.b.b.j.e.n;
import d.b.i0.d0.h;
import d.b.i0.p0.x;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58585a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58586b;

    /* renamed from: d  reason: collision with root package name */
    public String f58588d;

    /* renamed from: e  reason: collision with root package name */
    public String f58589e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f58590f = new C1441a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f58587c = new ArrayList();

    /* renamed from: d.b.i0.p0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1441a extends b0 {
        public C1441a() {
        }

        @Override // d.b.i0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f58585a = tbPageContext;
        this.f58586b = bdTypeListView;
        this.f58588d = str;
        this.f58589e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f58585a, this.f58588d, this.f58589e);
        bVar.n0(this.f58590f);
        this.f58587c.add(bVar);
        c cVar = new c(this.f58585a, this.f58588d);
        cVar.n0(this.f58590f);
        this.f58587c.add(cVar);
        this.f58587c.add(new f(this.f58585a, this.f58588d));
        this.f58587c.add(new e(this.f58585a, this.f58588d));
        List<d.b.b.j.e.a> list = this.f58587c;
        TbPageContext tbPageContext = this.f58585a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f53638f, tbPageContext.getUniqueId(), this.f58588d));
        d dVar = new d(this.f58585a, this.f58588d);
        dVar.l0(this.f58590f);
        this.f58587c.add(dVar);
        List<d.b.b.j.e.a> list2 = this.f58587c;
        TbPageContext tbPageContext2 = this.f58585a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.b.i0.d0.c.f53628f, tbPageContext2.getUniqueId(), this.f58588d));
        List<d.b.b.j.e.a> list3 = this.f58587c;
        TbPageContext tbPageContext3 = this.f58585a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.b.i0.d0.f.f53634f, tbPageContext3.getUniqueId(), this.f58588d));
        TbPageContext tbPageContext4 = this.f58585a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.x0();
        frsUserRecommendAdapter.w0(this.f58588d);
        this.f58587c.add(frsUserRecommendAdapter);
        this.f58586b.a(this.f58587c);
    }

    public void b() {
        if (this.f58586b.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f58586b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f58586b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
