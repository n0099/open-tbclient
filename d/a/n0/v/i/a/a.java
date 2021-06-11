package d.a.n0.v.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaInsertRecLiveHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.m0.r.q.a2;
import d.a.n0.e3.g;
import d.a.n0.r0.k;
import d.a.n0.z.z;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends k<g, FrsPageAlaInsertRecLiveHolder> implements z {
    public String w;
    public d.a.n0.v.i.e.a x;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.w = "";
    }

    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (g) obj, (FrsPageAlaInsertRecLiveHolder) viewHolder);
        return view;
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.a.n0.z.z
    public void r(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public FrsPageAlaInsertRecLiveHolder Q(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        d.a.n0.v.i.e.a aVar = new d.a.n0.v.i.e.a(tbPageContext);
        this.x = aVar;
        aVar.a(this.w);
        return new FrsPageAlaInsertRecLiveHolder(this.x);
    }

    public View t0(int i2, View view, ViewGroup viewGroup, g gVar, FrsPageAlaInsertRecLiveHolder frsPageAlaInsertRecLiveHolder) {
        super.X(i2, view, viewGroup, gVar, frsPageAlaInsertRecLiveHolder);
        if (gVar != null) {
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            List<a2> list = gVar.f57662e;
            if (list != null && list.get(0) != null) {
                gVar.f57662e.get(0).O1 = (i2 + 1) - topThreadSize;
            }
            frsPageAlaInsertRecLiveHolder.f14059a.a(this.w);
            frsPageAlaInsertRecLiveHolder.f14059a.n(gVar);
        }
        return view;
    }
}
