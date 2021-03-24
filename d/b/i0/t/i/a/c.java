package d.b.i0.t.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaEmptyLiveViewHolder;
import d.b.h0.r.q.a2;
import d.b.i0.p0.k;
import d.b.i0.x.b0;
import d.b.i0.x.z;
/* loaded from: classes4.dex */
public class c extends k<a2, FrsPageAlaEmptyLiveViewHolder> implements z {
    public d.b.i0.t.i.e.b w;
    public String x;
    public b0<a2> y;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001607, Integer.valueOf(a2Var.s1())));
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = new a(this);
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.b.i0.p0.k, d.b.i0.x.y
    public void i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.i(tbPageContext, bdUniqueId);
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: t0 */
    public FrsPageAlaEmptyLiveViewHolder R(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.b.i0.t.i.e.b bVar = new d.b.i0.t.i.e.b(tbPageContext);
        this.w = bVar;
        bVar.x(this.i);
        this.w.a(this.x);
        return new FrsPageAlaEmptyLiveViewHolder(this.w);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: u0 */
    public View X(int i, View view, ViewGroup viewGroup, a2 a2Var, FrsPageAlaEmptyLiveViewHolder frsPageAlaEmptyLiveViewHolder) {
        frsPageAlaEmptyLiveViewHolder.f15031a.n(a2Var);
        frsPageAlaEmptyLiveViewHolder.f15031a.a(this.x);
        frsPageAlaEmptyLiveViewHolder.f15031a.q(this.y);
        if (a2Var != null) {
            a2Var.x4();
        }
        return frsPageAlaEmptyLiveViewHolder.a();
    }
}
