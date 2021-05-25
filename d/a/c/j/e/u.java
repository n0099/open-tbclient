package d.a.c.j.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.NoDataItemViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u extends a<v, NoDataItemViewHolder> {
    public int m;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), v.f39324g);
        this.m = 3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        f0(i2, view, viewGroup, vVar, noDataItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public NoDataItemViewHolder P(ViewGroup viewGroup) {
        return new NoDataItemViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false));
    }

    public View f0(int i2, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        noDataItemViewHolder.f2376a.setText(vVar.f39325e);
        if (this.m != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setImageResource(noDataItemViewHolder.f2377b, vVar.f39326f);
            SkinManager.setViewTextColor(noDataItemViewHolder.f2376a, R.color.CAM_X0109);
            this.m = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
