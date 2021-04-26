package d.a.j0.q0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.j0.x.b0;
import d.a.j0.x.m;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.j0.d0.b, CardViewHolder<d.a.j0.x.e>> {
    public TbPageContext<?> m;
    public d.a.j0.x.e n;
    public b0 o;
    public String p;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.j0.d0.b> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.d0.b bVar) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 3).param("fid", c.this.p));
            c.this.g0(view, bVar);
        }
    }

    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), d.a.j0.d0.b.f51860f);
        this.m = tbPageContext;
        this.p = str;
    }

    public final void g0(View view, d.a.j0.d0.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(bVar.h(), null, m.g(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.h().c0()));
        createFromThreadCfg.setForumName(bVar.h().i0());
        createFromThreadCfg.setStartFrom(0);
        m.a(bVar.h().w1());
        this.m.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        b0 b0Var = this.o;
        if (b0Var != null) {
            b0Var.a(view, bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.j0.x.e> P(ViewGroup viewGroup) {
        this.n = new d.a.j0.x.e(this.m);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.d0.b bVar, CardViewHolder<d.a.j0.x.e> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(bVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().o(new a());
        return cardViewHolder.b().l();
    }

    public void j0(b0 b0Var) {
        this.o = b0Var;
    }
}
