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
    public TbPageContext f58584a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58585b;

    /* renamed from: d  reason: collision with root package name */
    public String f58587d;

    /* renamed from: e  reason: collision with root package name */
    public String f58588e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f58589f = new C1440a();

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f58586c = new ArrayList();

    /* renamed from: d.b.i0.p0.u1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1440a extends b0 {
        public C1440a() {
        }

        @Override // d.b.i0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            super.a(view, baseCardInfo);
            a.this.b();
        }
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        this.f58584a = tbPageContext;
        this.f58585b = bdTypeListView;
        this.f58587d = str;
        this.f58588e = str2;
        a();
    }

    public final void a() {
        b bVar = new b(this.f58584a, this.f58587d, this.f58588e);
        bVar.n0(this.f58589f);
        this.f58586c.add(bVar);
        c cVar = new c(this.f58584a, this.f58587d);
        cVar.n0(this.f58589f);
        this.f58586c.add(cVar);
        this.f58586c.add(new f(this.f58584a, this.f58587d));
        this.f58586c.add(new e(this.f58584a, this.f58587d));
        List<d.b.b.j.e.a> list = this.f58586c;
        TbPageContext tbPageContext = this.f58584a;
        list.add(new GameSpecialTopicAdapter(tbPageContext, h.f53637f, tbPageContext.getUniqueId(), this.f58587d));
        d dVar = new d(this.f58584a, this.f58587d);
        dVar.l0(this.f58589f);
        this.f58586c.add(dVar);
        List<d.b.b.j.e.a> list2 = this.f58586c;
        TbPageContext tbPageContext2 = this.f58584a;
        list2.add(new GameCompetitionAdapter(tbPageContext2, d.b.i0.d0.c.f53627f, tbPageContext2.getUniqueId(), this.f58587d));
        List<d.b.b.j.e.a> list3 = this.f58586c;
        TbPageContext tbPageContext3 = this.f58584a;
        list3.add(new GameRecommendGameAdapter(tbPageContext3, d.b.i0.d0.f.f53633f, tbPageContext3.getUniqueId(), this.f58587d));
        TbPageContext tbPageContext4 = this.f58584a;
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, x.i, tbPageContext4.getUniqueId());
        frsUserRecommendAdapter.x0();
        frsUserRecommendAdapter.w0(this.f58587d);
        this.f58586c.add(frsUserRecommendAdapter);
        this.f58585b.a(this.f58586c);
    }

    public void b() {
        if (this.f58585b.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f58585b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView = this.f58585b;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
