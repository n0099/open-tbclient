package d.b.i0.q0.p1.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.l;
import d.b.i0.q0.k;
import d.b.i0.x.e0.n;
import d.b.i0.x.o;
/* loaded from: classes4.dex */
public class a extends k<n, C1484a> {
    public boolean w;

    /* renamed from: d.b.i0.q0.p1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1484a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public o f59942a;

        public C1484a(a aVar, o oVar) {
            super(oVar.m());
            this.f59942a = oVar;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.w = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public C1484a R(ViewGroup viewGroup) {
        o oVar = new o(this.o);
        oVar.x(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C1484a(this, oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: u0 */
    public View X(int i, View view, ViewGroup viewGroup, n nVar, C1484a c1484a) {
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.j = i + 1;
            c1484a.f59942a.y(l.e(this.o.getPageActivity(), 7.0f));
            c1484a.f59942a.A(this.w);
            c1484a.f59942a.o(this.o, TbadkCoreApplication.getInst().getSkinType());
        }
        c1484a.f59942a.n(nVar);
        return c1484a.a();
    }
}
