package d.a.j0.q0.p1.a;

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
import d.a.j0.q0.k;
import d.a.j0.x.e0.n;
import d.a.j0.x.o;
/* loaded from: classes4.dex */
public class a extends k<n, C1446a> {
    public boolean w;

    /* renamed from: d.a.j0.q0.p1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1446a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public o f58455a;

        public C1446a(a aVar, o oVar) {
            super(oVar.l());
            this.f58455a = oVar;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.w = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public C1446a P(ViewGroup viewGroup) {
        o oVar = new o(this.o);
        oVar.v(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C1446a(this, oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    /* renamed from: u0 */
    public View W(int i2, View view, ViewGroup viewGroup, n nVar, C1446a c1446a) {
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.j = i2 + 1;
            c1446a.f58455a.w(l.e(this.o.getPageActivity(), 7.0f));
            c1446a.f58455a.y(this.w);
            c1446a.f58455a.n(this.o, TbadkCoreApplication.getInst().getSkinType());
        }
        c1446a.f58455a.m(nVar);
        return c1446a.a();
    }
}
