package d.b.i0.t.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.b.j.e.s;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.p0.k;
import d.b.i0.x.b0;
import d.b.i0.x.z;
/* loaded from: classes4.dex */
public class f extends k<z1, FrsPageAlaVideoHolder> implements z, d.b.i0.m.f {
    public d.b.i0.t.i.e.e w;
    public String x;
    public String y;
    public b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            CustomMessage customMessage;
            if (view.getId() == R.id.layout_root) {
                customMessage = new CustomMessage(2921018);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
                customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
            } else {
                customMessage = new CustomMessage(2921016);
            }
            if (customMessage == null || f.this.o == null) {
                return;
            }
            customMessage.setData(a2Var);
            f.this.o.sendMessage(customMessage);
        }
    }

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.z = new a();
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.b.i0.p0.k, d.b.i0.x.y
    public void i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.i(tbPageContext, bdUniqueId);
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.y = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: v0 */
    public FrsPageAlaVideoHolder R(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.b.i0.t.i.e.e eVar = new d.b.i0.t.i.e.e(tbPageContext, this.i);
        this.w = eVar;
        eVar.W(this.i);
        this.w.a(this.x);
        this.w.q(this.z);
        return new FrsPageAlaVideoHolder(this.w);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: w0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(2921017);
        FrsViewData frsViewData = this.n;
        int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
        a2 a2Var = z1Var.w;
        a2Var.M1 = (i + 1) - topThreadSize;
        customMessage.setData(a2Var);
        this.o.sendMessage(customMessage);
        if (z1Var != null) {
            d.b.i0.t.i.e.e eVar = frsPageAlaVideoHolder.f15034a;
            if (eVar instanceof d.b.i0.m.e) {
                eVar.setPage(this.y);
            }
            frsPageAlaVideoHolder.f15034a.a(this.x);
            frsPageAlaVideoHolder.f15034a.X(l0());
            frsPageAlaVideoHolder.f15034a.n(z1Var.w);
            z1Var.w.x4();
        }
        this.q = (s) viewGroup;
        return frsPageAlaVideoHolder.a();
    }
}
