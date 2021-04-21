package d.b.j0.q0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.b.c.j.e.n;
import d.b.j0.d0.h;
import d.b.j0.q0.x;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60674a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60675b;

    /* renamed from: d  reason: collision with root package name */
    public String f60677d;

    /* renamed from: e  reason: collision with root package name */
    public String f60678e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f60679f = new C1527a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f60676c = new ArrayList();

    /* renamed from: d.b.j0.q0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1527a extends b0 {
        public C1527a() {
        }

        @Override // d.b.j0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f60674a = tbPageContext;
        this.f60675b = bdTypeListView;
        this.f60677d = str;
        this.f60678e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f60674a, this.f60677d, this.f60678e);
        bVar.n0(this.f60679f);
        this.f60676c.add(bVar);
        c cVar = new c(this.f60674a, this.f60677d);
        cVar.n0(this.f60679f);
        this.f60676c.add(cVar);
        this.f60676c.add(new f(this.f60674a, this.f60677d));
        this.f60676c.add(new e(this.f60674a, this.f60677d));
        List<d.b.c.j.e.a> list = this.f60676c;
        TbPageContext tbPageContext = this.f60674a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f54098f, tbPageContext.getUniqueId(), this.f60677d));
        d dVar = new d(this.f60674a, this.f60677d);
        dVar.l0(this.f60679f);
        this.f60676c.add(dVar);
        List<d.b.c.j.e.a> list2 = this.f60676c;
        TbPageContext tbPageContext2 = this.f60674a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.b.j0.d0.c.f54088f, tbPageContext2.getUniqueId(), this.f60677d));
        List<d.b.c.j.e.a> list3 = this.f60676c;
        TbPageContext tbPageContext3 = this.f60674a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.b.j0.d0.f.f54094f, tbPageContext3.getUniqueId(), this.f60677d));
        TbPageContext tbPageContext4 = this.f60674a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.x0();
        frsUserRecommendAdapter.w0(this.f60677d);
        this.f60676c.add(frsUserRecommendAdapter);
        this.f60675b.a(this.f60676c);
    }

    public void b() {
        if (this.f60675b.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f60675b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f60675b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
