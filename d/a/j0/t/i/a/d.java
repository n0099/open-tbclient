package d.a.j0.t.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.j0.d3.h;
import d.a.j0.q0.k;
import d.a.j0.x.z;
/* loaded from: classes4.dex */
public class d extends k<h, FrsPageAlaStageViewHolder> implements z {
    public String w;
    public d.a.j0.t.i.e.d x;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // d.a.j0.q0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i2, view, viewGroup, (h) obj, (FrsPageAlaStageViewHolder) viewHolder);
        return view;
    }

    @Override // d.a.j0.x.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.a.j0.x.z
    public void q(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public FrsPageAlaStageViewHolder P(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.a.j0.t.i.e.d dVar = new d.a.j0.t.i.e.d(tbPageContext);
        this.x = dVar;
        dVar.a(this.w);
        return new FrsPageAlaStageViewHolder(this.x);
    }

    public View u0(int i2, View view, ViewGroup viewGroup, h hVar, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        super.W(i2, view, viewGroup, hVar, frsPageAlaStageViewHolder);
        if (hVar != null) {
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            d.a.j0.t.i.e.d dVar = frsPageAlaStageViewHolder.f14785a;
            dVar.B = (i2 + 1) - topThreadSize;
            dVar.a(this.w);
            frsPageAlaStageViewHolder.f14785a.m(hVar);
        }
        return view;
    }
}
