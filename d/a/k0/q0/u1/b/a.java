package d.a.k0.q0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.a.c.j.e.n;
import d.a.k0.d0.h;
import d.a.k0.q0.x;
import d.a.k0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59523a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59524b;

    /* renamed from: d  reason: collision with root package name */
    public String f59526d;

    /* renamed from: e  reason: collision with root package name */
    public String f59527e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f59528f = new C1540a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f59525c = new ArrayList();

    /* renamed from: d.a.k0.q0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1540a extends b0 {
        public C1540a() {
        }

        @Override // d.a.k0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f59523a = tbPageContext;
        this.f59524b = bdTypeListView;
        this.f59526d = str;
        this.f59527e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f59523a, this.f59526d, this.f59527e);
        bVar.j0(this.f59528f);
        this.f59525c.add(bVar);
        c cVar = new c(this.f59523a, this.f59526d);
        cVar.j0(this.f59528f);
        this.f59525c.add(cVar);
        this.f59525c.add(new f(this.f59523a, this.f59526d));
        this.f59525c.add(new e(this.f59523a, this.f59526d));
        List<d.a.c.j.e.a> list = this.f59525c;
        TbPageContext tbPageContext = this.f59523a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f52571f, tbPageContext.getUniqueId(), this.f59526d));
        d dVar = new d(this.f59523a, this.f59526d);
        dVar.h0(this.f59528f);
        this.f59525c.add(dVar);
        List<d.a.c.j.e.a> list2 = this.f59525c;
        TbPageContext tbPageContext2 = this.f59523a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.k0.d0.c.f52561f, tbPageContext2.getUniqueId(), this.f59526d));
        List<d.a.c.j.e.a> list3 = this.f59525c;
        TbPageContext tbPageContext3 = this.f59523a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.k0.d0.f.f52567f, tbPageContext3.getUniqueId(), this.f59526d));
        TbPageContext tbPageContext4 = this.f59523a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.f59661i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.w0();
        frsUserRecommendAdapter.v0(this.f59526d);
        this.f59525c.add(frsUserRecommendAdapter);
        this.f59524b.a(this.f59525c);
    }

    public void b() {
        if (this.f59524b.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f59524b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f59524b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
