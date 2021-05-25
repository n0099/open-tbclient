package d.a.n0.r0.p1.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.l;
import d.a.n0.r0.k;
import d.a.n0.z.e0.n;
import d.a.n0.z.o;
/* loaded from: classes4.dex */
public class a extends k<n, C1533a> {
    public boolean w;

    /* renamed from: d.a.n0.r0.p1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1533a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public o f59338a;

        public C1533a(a aVar, o oVar) {
            super(oVar.l());
            this.f59338a = oVar;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.w = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public C1533a P(ViewGroup viewGroup) {
        o oVar = new o(this.o);
        oVar.v(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C1533a(this, oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    /* renamed from: t0 */
    public View W(int i2, View view, ViewGroup viewGroup, n nVar, C1533a c1533a) {
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.j = i2 + 1;
            c1533a.f59338a.w(l.e(this.o.getPageActivity(), 7.0f));
            c1533a.f59338a.y(this.w);
            c1533a.f59338a.n(this.o, TbadkCoreApplication.getInst().getSkinType());
        }
        c1533a.f59338a.m(nVar);
        return c1533a.a();
    }
}
