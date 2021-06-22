package d.a.o0.b1.f.a.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.NoDataItemViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.k.e.v;
/* loaded from: classes4.dex */
public class i extends d.a.c.k.e.a<v, NoDataItemViewHolder> {
    public int m;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), v.f43108g);
        this.m = 3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        g0(i2, view, viewGroup, vVar, noDataItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public NoDataItemViewHolder Q(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f43012e).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new NoDataItemViewHolder(inflate);
    }

    public View g0(int i2, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        noDataItemViewHolder.f2395a.setText(vVar.f43109e);
        if (this.m != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setImageResource(noDataItemViewHolder.f2396b, vVar.f43110f);
            SkinManager.setViewTextColor(noDataItemViewHolder.f2395a, R.color.CAM_X0109);
            this.m = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
