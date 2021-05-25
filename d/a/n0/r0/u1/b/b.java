package d.a.n0.r0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.z.b0;
import d.a.n0.z.m;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.n0.e0.a, CardViewHolder<d.a.n0.z.d>> {
    public TbPageContext<?> m;
    public d.a.n0.z.d n;
    public String o;
    public String p;
    public b0 q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.e0.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.e0.a aVar) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 2).param("fid", b.this.o));
            b.this.g0(view, aVar);
        }
    }

    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), d.a.n0.e0.a.f52762f);
        this.o = str;
        this.p = str2;
        this.m = tbPageContext;
    }

    public final void g0(View view, d.a.n0.e0.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(aVar.h(), null, m.g(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.h().c0()));
        createFromThreadCfg.setForumName(aVar.h().i0());
        createFromThreadCfg.setStartFrom(0);
        m.a(aVar.h().y1());
        this.m.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        b0 b0Var = this.q;
        if (b0Var != null) {
            b0Var.a(view, aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.n0.z.d> P(ViewGroup viewGroup) {
        this.n = new d.a.n0.z.d(this.m, this.o, this.p);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.e0.a aVar, CardViewHolder<d.a.n0.z.d> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(aVar);
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().o(new a());
        return cardViewHolder.b().l();
    }

    public void j0(b0 b0Var) {
        this.q = b0Var;
    }
}
