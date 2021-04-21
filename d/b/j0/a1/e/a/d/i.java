package d.b.j0.a1.e.a.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.NoDataItemViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.j.e.v;
/* loaded from: classes4.dex */
public class i extends d.b.c.j.e.a<v, NoDataItemViewHolder> {
    public int m;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), v.f43183g);
        this.m = 3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        i0(i, view, viewGroup, vVar, noDataItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public NoDataItemViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f43095e).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new NoDataItemViewHolder(inflate);
    }

    public View i0(int i, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        noDataItemViewHolder.f2389a.setText(vVar.f43184e);
        if (this.m != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setImageResource(noDataItemViewHolder.f2390b, vVar.f43185f);
            SkinManager.setViewTextColor(noDataItemViewHolder.f2389a, R.color.CAM_X0109);
            this.m = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
