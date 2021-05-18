package d.a.k0.t.d.c.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import d.a.c.e.p.l;
import d.a.k0.q0.t;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<t, FrsNoListItemViewHolder> {
    public final int m;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), t.f59517f);
        this.m = (l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, t tVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        f0(i2, view, viewGroup, tVar, frsNoListItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public FrsNoListItemViewHolder P(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f39564e).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams t = t(viewGroup);
        t.width = -1;
        t.height = this.m;
        inflate.setLayoutParams(t);
        return new FrsNoListItemViewHolder(inflate, viewGroup);
    }

    public View f0(int i2, View view, ViewGroup viewGroup, t tVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        frsNoListItemViewHolder.f15221d.setText(R.string.no_data_common_txt);
        SkinManager.setViewTextColor(frsNoListItemViewHolder.f15221d, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(frsNoListItemViewHolder.f15222e, R.drawable.new_pic_emotion_06);
        return view;
    }
}
