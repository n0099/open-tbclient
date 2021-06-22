package d.a.o0.r0.u1.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.o0.z.b0;
import d.a.o0.z.m;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<d.a.o0.e0.a, CardViewHolder<d.a.o0.z.d>> {
    public TbPageContext<?> m;
    public d.a.o0.z.d n;
    public String o;
    public String p;
    public b0 q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.o0.e0.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.e0.a aVar) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 2).param("fid", b.this.o));
            b.this.h0(view, aVar);
        }
    }

    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), d.a.o0.e0.a.f56576f);
        this.o = str;
        this.p = str2;
        this.m = tbPageContext;
    }

    public final void h0(View view, d.a.o0.e0.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.m.getPageActivity()).createFromThreadCfg(aVar.c(), null, m.g(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.c().c0()));
        createFromThreadCfg.setForumName(aVar.c().i0());
        createFromThreadCfg.setStartFrom(0);
        m.a(aVar.c().z1());
        this.m.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        b0 b0Var = this.q;
        if (b0Var != null) {
            b0Var.a(view, aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.a.o0.z.d> Q(ViewGroup viewGroup) {
        this.n = new d.a.o0.z.d(this.m, this.o, this.p);
        return new CardViewHolder<>(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.e0.a aVar, CardViewHolder<d.a.o0.z.d> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(aVar);
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().p(new a());
        return cardViewHolder.b().m();
    }

    public void k0(b0 b0Var) {
        this.q = b0Var;
    }
}
