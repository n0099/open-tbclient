package d.a.o0.r0.p1.a;

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
import d.a.o0.r0.k;
import d.a.o0.z.e0.n;
import d.a.o0.z.o;
/* loaded from: classes4.dex */
public class a extends k<n, C1593a> {
    public boolean w;

    /* renamed from: d.a.o0.r0.p1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1593a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public o f63154a;

        public C1593a(a aVar, o oVar) {
            super(oVar.m());
            this.f63154a = oVar;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.w = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public C1593a Q(ViewGroup viewGroup) {
        o oVar = new o(this.o);
        oVar.w(null, TbadkCoreStatisticKey.FRS_HOT_TOPIC_ITEM_CLICK);
        return new C1593a(this, oVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: t0 */
    public View X(int i2, View view, ViewGroup viewGroup, n nVar, C1593a c1593a) {
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_HOT_TOPIC_CARD_SHOW));
        if (nVar != null) {
            nVar.j = i2 + 1;
            c1593a.f63154a.x(l.e(this.o.getPageActivity(), 7.0f));
            c1593a.f63154a.z(this.w);
            c1593a.f63154a.o(this.o, TbadkCoreApplication.getInst().getSkinType());
        }
        c1593a.f63154a.n(nVar);
        return c1593a.a();
    }
}
