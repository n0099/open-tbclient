package d.b.i0.p0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.x.b0;
import d.b.i0.x.m;
/* loaded from: classes4.dex */
public class c extends d.b.b.j.e.a<d.b.i0.d0.b, CardViewHolder<d.b.i0.x.e>> {
    public TbPageContext<?> m;
    public d.b.i0.x.e n;
    public b0 o;
    public String p;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.i0.d0.b> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.d0.b bVar) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 3).param("fid", c.this.p));
            c.this.j0(view, bVar);
        }
    }

    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.b.i0.d0.b.f53625f);
        this.m = tbPageContext;
        this.p = str;
    }

    public final void j0(View view, d.b.i0.d0.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(bVar.g(), null, m.g(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.g().c0()));
        createFromThreadCfg.setForumName(bVar.g().i0());
        createFromThreadCfg.setStartFrom(0);
        m.a(bVar.g().w1());
        this.m.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        b0 b0Var = this.o;
        if (b0Var != null) {
            b0Var.a(view, bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public CardViewHolder<d.b.i0.x.e> R(ViewGroup viewGroup) {
        this.n = new d.b.i0.x.e(this.m);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.d0.b bVar, CardViewHolder<d.b.i0.x.e> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(bVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().q(new a());
        return cardViewHolder.b().m();
    }

    public void n0(b0 b0Var) {
        this.o = b0Var;
    }
}
