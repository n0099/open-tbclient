package d.b.b.j.e;

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
        super(tbPageContext.getPageActivity(), v.f42446g);
        this.m = 3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        i0(i, view, viewGroup, vVar, noDataItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public NoDataItemViewHolder R(ViewGroup viewGroup) {
        return new NoDataItemViewHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false));
    }

    public View i0(int i, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        noDataItemViewHolder.f2354a.setText(vVar.f42447e);
        if (this.m != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setImageResource(noDataItemViewHolder.f2355b, vVar.f42448f);
            SkinManager.setViewTextColor(noDataItemViewHolder.f2354a, R.color.CAM_X0109);
            this.m = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
