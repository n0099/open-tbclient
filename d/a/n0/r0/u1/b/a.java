package d.a.n0.r0.u1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import d.a.c.k.e.n;
import d.a.n0.e0.h;
import d.a.n0.r0.x;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63355a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f63356b;

    /* renamed from: d  reason: collision with root package name */
    public String f63358d;

    /* renamed from: e  reason: collision with root package name */
    public String f63359e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f63360f = new C1609a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f63357c = new ArrayList();

    /* renamed from: d.a.n0.r0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1609a extends b0 {
        public C1609a() {
        }

        @Override // d.a.n0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f63355a = tbPageContext;
        this.f63356b = bdTypeListView;
        this.f63358d = str;
        this.f63359e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f63355a, this.f63358d, this.f63359e);
        bVar.k0(this.f63360f);
        this.f63357c.add(bVar);
        c cVar = new c(this.f63355a, this.f63358d);
        cVar.k0(this.f63360f);
        this.f63357c.add(cVar);
        this.f63357c.add(new f(this.f63355a, this.f63358d));
        this.f63357c.add(new e(this.f63355a, this.f63358d));
        List<d.a.c.k.e.a> list = this.f63357c;
        TbPageContext tbPageContext = this.f63355a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f56465f, tbPageContext.getUniqueId(), this.f63358d));
        d dVar = new d(this.f63355a, this.f63358d);
        dVar.i0(this.f63360f);
        this.f63357c.add(dVar);
        List<d.a.c.k.e.a> list2 = this.f63357c;
        TbPageContext tbPageContext2 = this.f63355a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.a.n0.e0.c.f56455f, tbPageContext2.getUniqueId(), this.f63358d));
        List<d.a.c.k.e.a> list3 = this.f63357c;
        TbPageContext tbPageContext3 = this.f63355a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.a.n0.e0.f.f56461f, tbPageContext3.getUniqueId(), this.f63358d));
        TbPageContext tbPageContext4 = this.f63355a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.f63493i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.x0();
        frsUserRecommendAdapter.w0(this.f63358d);
        this.f63357c.add(frsUserRecommendAdapter);
        this.f63356b.a(this.f63357c);
    }

    public void b() {
        if (this.f63356b.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f63356b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f63356b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
