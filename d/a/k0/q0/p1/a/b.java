package d.a.k0.q0.p1.a;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder;
import d.a.k0.d3.e0;
import d.a.k0.q0.k;
/* loaded from: classes4.dex */
public class b extends k<e0, FrsU9ViewHolder> {
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public FrsU9ViewHolder P(ViewGroup viewGroup) {
        Log.e("Adapter", "Frs U9 Context:" + this.f39564e + "   Resource:" + this.f39564e.getResources() + "  Asset:" + this.f39564e.getResources().getAssets());
        return new FrsU9ViewHolder(this.o, LayoutInflater.from(this.f39564e).inflate(R.layout.u9_info_layout, (ViewGroup) null, true), this.f39568i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: t0 */
    public View W(int i2, View view, ViewGroup viewGroup, e0 e0Var, FrsU9ViewHolder frsU9ViewHolder) {
        super.W(i2, view, viewGroup, e0Var, frsU9ViewHolder);
        if (e0Var == null || frsU9ViewHolder == null) {
            return null;
        }
        frsU9ViewHolder.g(e0Var);
        frsU9ViewHolder.h(TbadkCoreApplication.getInst().getSkinType());
        return frsU9ViewHolder.a();
    }
}
