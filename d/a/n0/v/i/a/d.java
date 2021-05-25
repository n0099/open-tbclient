package d.a.n0.v.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.n0.e3.h;
import d.a.n0.r0.k;
import d.a.n0.z.z;
/* loaded from: classes4.dex */
public class d extends k<h, FrsPageAlaStageViewHolder> implements z {
    public String w;
    public d.a.n0.v.i.e.d x;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (h) obj, (FrsPageAlaStageViewHolder) viewHolder);
        return view;
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.a.n0.z.z
    public void q(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public FrsPageAlaStageViewHolder P(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.a.n0.v.i.e.d dVar = new d.a.n0.v.i.e.d(tbPageContext);
        this.x = dVar;
        dVar.a(this.w);
        return new FrsPageAlaStageViewHolder(this.x);
    }

    public View t0(int i2, View view, ViewGroup viewGroup, h hVar, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        super.W(i2, view, viewGroup, hVar, frsPageAlaStageViewHolder);
        if (hVar != null) {
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            d.a.n0.v.i.e.d dVar = frsPageAlaStageViewHolder.f14003a;
            dVar.B = (i2 + 1) - topThreadSize;
            dVar.a(this.w);
            frsPageAlaStageViewHolder.f14003a.m(hVar);
        }
        return view;
    }
}
