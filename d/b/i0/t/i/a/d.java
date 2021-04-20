package d.b.i0.t.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i0.d3.h;
import d.b.i0.q0.k;
import d.b.i0.x.z;
/* loaded from: classes4.dex */
public class d extends k<h, FrsPageAlaStageViewHolder> implements z {
    public String w;
    public d.b.i0.t.i.e.d x;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i, view, viewGroup, (h) obj, (FrsPageAlaStageViewHolder) viewHolder);
        return view;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public FrsPageAlaStageViewHolder R(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.b.i0.t.i.e.d dVar = new d.b.i0.t.i.e.d(tbPageContext);
        this.x = dVar;
        dVar.a(this.w);
        return new FrsPageAlaStageViewHolder(this.x);
    }

    public View u0(int i, View view, ViewGroup viewGroup, h hVar, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        super.X(i, view, viewGroup, hVar, frsPageAlaStageViewHolder);
        if (hVar != null) {
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            d.b.i0.t.i.e.d dVar = frsPageAlaStageViewHolder.f14697a;
            dVar.B = (i + 1) - topThreadSize;
            dVar.a(this.w);
            frsPageAlaStageViewHolder.f14697a.n(hVar);
        }
        return view;
    }
}
