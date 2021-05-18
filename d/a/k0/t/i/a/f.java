package d.a.k0.t.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.j.e.s;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.k0.q0.k;
import d.a.k0.x.b0;
import d.a.k0.x.z;
/* loaded from: classes4.dex */
public class f extends k<z1, FrsPageAlaVideoHolder> implements z, d.a.k0.m.f {
    public d.a.k0.t.i.e.e w;
    public String x;
    public String y;
    public b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            CustomMessage customMessage;
            if (view.getId() == R.id.layout_root) {
                customMessage = new CustomMessage(2921018);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header && view.getId() != R.id.user_avatar) {
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

    @Override // d.a.k0.x.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.y = str;
    }

    @Override // d.a.k0.q0.k, d.a.k0.x.y
    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.n(tbPageContext, bdUniqueId);
    }

    @Override // d.a.k0.x.z
    public void q(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public FrsPageAlaVideoHolder P(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.a.k0.t.i.e.e eVar = new d.a.k0.t.i.e.e(tbPageContext, this.f39568i);
        this.w = eVar;
        eVar.V(this.f39568i);
        this.w.a(this.x);
        this.w.o(this.z);
        return new FrsPageAlaVideoHolder(this.w);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: v0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(2921017);
        FrsViewData frsViewData = this.n;
        int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
        a2 a2Var = z1Var.w;
        a2Var.M1 = (i2 + 1) - topThreadSize;
        customMessage.setData(a2Var);
        this.o.sendMessage(customMessage);
        if (z1Var != null) {
            d.a.k0.t.i.e.e eVar = frsPageAlaVideoHolder.f14101a;
            if (eVar instanceof d.a.k0.m.e) {
                eVar.setPage(this.y);
            }
            frsPageAlaVideoHolder.f14101a.a(this.x);
            frsPageAlaVideoHolder.f14101a.W(g0());
            frsPageAlaVideoHolder.f14101a.m(z1Var.w);
            z1Var.w.A4();
        }
        this.q = (s) viewGroup;
        return frsPageAlaVideoHolder.a();
    }
}
