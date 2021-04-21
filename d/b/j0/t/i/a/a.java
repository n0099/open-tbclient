package d.b.j0.t.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaInsertRecLiveHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i0.r.q.a2;
import d.b.j0.d3.g;
import d.b.j0.q0.k;
import d.b.j0.x.z;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends k<g, FrsPageAlaInsertRecLiveHolder> implements z {
    public String w;
    public d.b.j0.t.i.e.a x;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.w = "";
    }

    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i, view, viewGroup, (g) obj, (FrsPageAlaInsertRecLiveHolder) viewHolder);
        return view;
    }

    @Override // d.b.j0.x.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.b.j0.x.z
    public void p(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public FrsPageAlaInsertRecLiveHolder R(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.b.j0.t.i.e.a aVar = new d.b.j0.t.i.e.a(tbPageContext);
        this.x = aVar;
        aVar.a(this.w);
        return new FrsPageAlaInsertRecLiveHolder(this.x);
    }

    public View u0(int i, View view, ViewGroup viewGroup, g gVar, FrsPageAlaInsertRecLiveHolder frsPageAlaInsertRecLiveHolder) {
        super.X(i, view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder);
        if (gVar != null) {
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            List<a2> list = gVar.f55216e;
            if (list != null && list.get(0) != null) {
                gVar.f55216e.get(0).M1 = (i + 1) - topThreadSize;
            }
            frsPageAlaInsertRecLiveHolder.f14704a.a(this.w);
            frsPageAlaInsertRecLiveHolder.f14704a.n(gVar);
        }
        return view;
    }
}
