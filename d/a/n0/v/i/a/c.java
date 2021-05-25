package d.a.n0.v.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaEmptyLiveViewHolder;
import d.a.m0.r.q.a2;
import d.a.n0.r0.k;
import d.a.n0.z.b0;
import d.a.n0.z.z;
/* loaded from: classes4.dex */
public class c extends k<a2, FrsPageAlaEmptyLiveViewHolder> implements z {
    public d.a.n0.v.i.e.b w;
    public String x;
    public b0<a2> y;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001607, Integer.valueOf(a2Var.u1())));
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = new a(this);
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.a.n0.r0.k, d.a.n0.z.y
    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.n(tbPageContext, bdUniqueId);
    }

    @Override // d.a.n0.z.z
    public void q(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public FrsPageAlaEmptyLiveViewHolder P(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.a.n0.v.i.e.b bVar = new d.a.n0.v.i.e.b(tbPageContext);
        this.w = bVar;
        bVar.v(this.f39232i);
        this.w.a(this.x);
        return new FrsPageAlaEmptyLiveViewHolder(this.w);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    /* renamed from: t0 */
    public View W(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsPageAlaEmptyLiveViewHolder frsPageAlaEmptyLiveViewHolder) {
        frsPageAlaEmptyLiveViewHolder.f14001a.m(a2Var);
        frsPageAlaEmptyLiveViewHolder.f14001a.a(this.x);
        frsPageAlaEmptyLiveViewHolder.f14001a.o(this.y);
        if (a2Var != null) {
            a2Var.B4();
        }
        return frsPageAlaEmptyLiveViewHolder.a();
    }
}
