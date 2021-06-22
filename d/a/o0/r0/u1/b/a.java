package d.a.o0.r0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.a.c.k.e.n;
import d.a.o0.e0.h;
import d.a.o0.r0.x;
import d.a.o0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63480a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f63481b;

    /* renamed from: d  reason: collision with root package name */
    public String f63483d;

    /* renamed from: e  reason: collision with root package name */
    public String f63484e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f63485f = new C1613a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f63482c = new ArrayList();

    /* renamed from: d.a.o0.r0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1613a extends b0 {
        public C1613a() {
        }

        @Override // d.a.o0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f63480a = tbPageContext;
        this.f63481b = bdTypeListView;
        this.f63483d = str;
        this.f63484e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f63480a, this.f63483d, this.f63484e);
        bVar.k0(this.f63485f);
        this.f63482c.add(bVar);
        c cVar = new c(this.f63480a, this.f63483d);
        cVar.k0(this.f63485f);
        this.f63482c.add(cVar);
        this.f63482c.add(new f(this.f63480a, this.f63483d));
        this.f63482c.add(new e(this.f63480a, this.f63483d));
        List<d.a.c.k.e.a> list = this.f63482c;
        TbPageContext tbPageContext = this.f63480a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f56590f, tbPageContext.getUniqueId(), this.f63483d));
        d dVar = new d(this.f63480a, this.f63483d);
        dVar.i0(this.f63485f);
        this.f63482c.add(dVar);
        List<d.a.c.k.e.a> list2 = this.f63482c;
        TbPageContext tbPageContext2 = this.f63480a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.o0.e0.c.f56580f, tbPageContext2.getUniqueId(), this.f63483d));
        List<d.a.c.k.e.a> list3 = this.f63482c;
        TbPageContext tbPageContext3 = this.f63480a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.o0.e0.f.f56586f, tbPageContext3.getUniqueId(), this.f63483d));
        TbPageContext tbPageContext4 = this.f63480a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.f63618i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.x0();
        frsUserRecommendAdapter.w0(this.f63483d);
        this.f63482c.add(frsUserRecommendAdapter);
        this.f63481b.a(this.f63482c);
    }

    public void b() {
        if (this.f63481b.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f63481b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f63481b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
