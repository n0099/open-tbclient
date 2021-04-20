package d.b.i0.t.d.c.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import d.b.c.e.p.l;
import d.b.i0.q0.t;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<t, FrsNoListItemViewHolder> {
    public final int m;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), t.f60247f);
        this.m = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, t tVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        i0(i, view, viewGroup, tVar, frsNoListItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public FrsNoListItemViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42855e).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams u = u(viewGroup);
        u.width = -1;
        u.height = this.m;
        inflate.setLayoutParams(u);
        return new FrsNoListItemViewHolder(inflate, viewGroup);
    }

    public View i0(int i, View view, ViewGroup viewGroup, t tVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        frsNoListItemViewHolder.f15730d.setText(R.string.no_data_common_txt);
        SkinManager.setViewTextColor(frsNoListItemViewHolder.f15730d, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(frsNoListItemViewHolder.f15731e, R.drawable.new_pic_emotion_06);
        return view;
    }
}
