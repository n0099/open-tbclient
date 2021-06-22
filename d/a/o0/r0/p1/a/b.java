package d.a.o0.r0.p1.a;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder;
import d.a.o0.e3.e0;
import d.a.o0.r0.k;
/* loaded from: classes4.dex */
public class b extends k<e0, FrsU9ViewHolder> {
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public FrsU9ViewHolder Q(ViewGroup viewGroup) {
        Log.e("Adapter", "Frs U9 Context:" + this.f43012e + "   Resource:" + this.f43012e.getResources() + "  Asset:" + this.f43012e.getResources().getAssets());
        return new FrsU9ViewHolder(this.o, LayoutInflater.from(this.f43012e).inflate(R.layout.u9_info_layout, (ViewGroup) null, true), this.f43016i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: t0 */
    public View X(int i2, View view, ViewGroup viewGroup, e0 e0Var, FrsU9ViewHolder frsU9ViewHolder) {
        super.X(i2, view, viewGroup, e0Var, frsU9ViewHolder);
        if (e0Var == null || frsU9ViewHolder == null) {
            return null;
        }
        frsU9ViewHolder.g(e0Var);
        frsU9ViewHolder.h(TbadkCoreApplication.getInst().getSkinType());
        return frsU9ViewHolder.a();
    }
}
