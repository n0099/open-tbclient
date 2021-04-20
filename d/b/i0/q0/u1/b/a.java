package d.b.i0.q0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.b.c.j.e.n;
import d.b.i0.d0.h;
import d.b.i0.q0.x;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60253a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60254b;

    /* renamed from: d  reason: collision with root package name */
    public String f60256d;

    /* renamed from: e  reason: collision with root package name */
    public String f60257e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f60258f = new C1504a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f60255c = new ArrayList();

    /* renamed from: d.b.i0.q0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1504a extends b0 {
        public C1504a() {
        }

        @Override // d.b.i0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f60253a = tbPageContext;
        this.f60254b = bdTypeListView;
        this.f60256d = str;
        this.f60257e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f60253a, this.f60256d, this.f60257e);
        bVar.n0(this.f60258f);
        this.f60255c.add(bVar);
        c cVar = new c(this.f60253a, this.f60256d);
        cVar.n0(this.f60258f);
        this.f60255c.add(cVar);
        this.f60255c.add(new f(this.f60253a, this.f60256d));
        this.f60255c.add(new e(this.f60253a, this.f60256d));
        List<d.b.c.j.e.a> list = this.f60255c;
        TbPageContext tbPageContext = this.f60253a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f53677f, tbPageContext.getUniqueId(), this.f60256d));
        d dVar = new d(this.f60253a, this.f60256d);
        dVar.l0(this.f60258f);
        this.f60255c.add(dVar);
        List<d.b.c.j.e.a> list2 = this.f60255c;
        TbPageContext tbPageContext2 = this.f60253a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.b.i0.d0.c.f53667f, tbPageContext2.getUniqueId(), this.f60256d));
        List<d.b.c.j.e.a> list3 = this.f60255c;
        TbPageContext tbPageContext3 = this.f60253a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.b.i0.d0.f.f53673f, tbPageContext3.getUniqueId(), this.f60256d));
        TbPageContext tbPageContext4 = this.f60253a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.x0();
        frsUserRecommendAdapter.w0(this.f60256d);
        this.f60255c.add(frsUserRecommendAdapter);
        this.f60254b.a(this.f60255c);
    }

    public void b() {
        if (this.f60254b.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f60254b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f60254b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
