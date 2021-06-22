package d.a.o0.v.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.k.e.s;
import d.a.n0.r.q.a2;
import d.a.o0.r0.k;
import d.a.o0.z.b0;
import d.a.o0.z.z;
/* loaded from: classes4.dex */
public class e extends k<a2, FrsPageAlaVideoHolder> implements z, d.a.o0.o.f {
    public d.a.o0.v.i.e.e w;
    public String x;
    public String y;
    public b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
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
            if (customMessage == null || e.this.o == null) {
                return;
            }
            customMessage.setData(a2Var);
            e.this.o.sendMessage(customMessage);
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.z = new a();
    }

    @Override // d.a.o0.z.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.y = str;
    }

    @Override // d.a.o0.r0.k, d.a.o0.z.y
    public void o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.o(tbPageContext, bdUniqueId);
    }

    @Override // d.a.o0.z.z
    public void r(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public FrsPageAlaVideoHolder Q(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.a.o0.v.i.e.e eVar = new d.a.o0.v.i.e.e(tbPageContext, this.f43016i);
        this.w = eVar;
        eVar.V(this.f43016i);
        this.w.a(this.x);
        this.w.p(this.z);
        return new FrsPageAlaVideoHolder(this.w);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(2921017);
        FrsViewData frsViewData = this.n;
        a2Var.O1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        customMessage.setData(a2Var);
        this.o.sendMessage(customMessage);
        if (a2Var != null) {
            d.a.o0.v.i.e.e eVar = frsPageAlaVideoHolder.f14143a;
            if (eVar instanceof d.a.o0.o.e) {
                eVar.setPage(this.y);
            }
            frsPageAlaVideoHolder.f14143a.a(this.x);
            frsPageAlaVideoHolder.f14143a.X(h0());
            frsPageAlaVideoHolder.f14143a.n(a2Var);
            a2Var.C4();
        }
        this.q = (s) viewGroup;
        return frsPageAlaVideoHolder.a();
    }
}
