package d.a.n0.r0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.a.c.j.e.n;
import d.a.n0.e0.h;
import d.a.n0.r0.x;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59664a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59665b;

    /* renamed from: d  reason: collision with root package name */
    public String f59667d;

    /* renamed from: e  reason: collision with root package name */
    public String f59668e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f59669f = new C1553a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f59666c = new ArrayList();

    /* renamed from: d.a.n0.r0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1553a extends b0 {
        public C1553a() {
        }

        @Override // d.a.n0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f59664a = tbPageContext;
        this.f59665b = bdTypeListView;
        this.f59667d = str;
        this.f59668e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f59664a, this.f59667d, this.f59668e);
        bVar.j0(this.f59669f);
        this.f59666c.add(bVar);
        c cVar = new c(this.f59664a, this.f59667d);
        cVar.j0(this.f59669f);
        this.f59666c.add(cVar);
        this.f59666c.add(new f(this.f59664a, this.f59667d));
        this.f59666c.add(new e(this.f59664a, this.f59667d));
        List<d.a.c.j.e.a> list = this.f59666c;
        TbPageContext tbPageContext = this.f59664a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f52776f, tbPageContext.getUniqueId(), this.f59667d));
        d dVar = new d(this.f59664a, this.f59667d);
        dVar.h0(this.f59669f);
        this.f59666c.add(dVar);
        List<d.a.c.j.e.a> list2 = this.f59666c;
        TbPageContext tbPageContext2 = this.f59664a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.n0.e0.c.f52766f, tbPageContext2.getUniqueId(), this.f59667d));
        List<d.a.c.j.e.a> list3 = this.f59666c;
        TbPageContext tbPageContext3 = this.f59664a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.n0.e0.f.f52772f, tbPageContext3.getUniqueId(), this.f59667d));
        TbPageContext tbPageContext4 = this.f59664a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.f59802i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.w0();
        frsUserRecommendAdapter.v0(this.f59667d);
        this.f59666c.add(frsUserRecommendAdapter);
        this.f59665b.a(this.f59666c);
    }

    public void b() {
        if (this.f59665b.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f59665b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f59665b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
