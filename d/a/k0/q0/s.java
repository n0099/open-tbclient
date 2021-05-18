package d.a.k0.q0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
/* loaded from: classes4.dex */
public class s extends k<t, FrsNoListItemViewHolder> {
    public final int w;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.w = (d.a.c.e.p.l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (t) obj, (FrsNoListItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public FrsNoListItemViewHolder P(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f39564e).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams t = t(viewGroup);
        t.width = -1;
        t.height = this.w;
        inflate.setLayoutParams(t);
        return new FrsNoListItemViewHolder(inflate, viewGroup);
    }

    public View t0(int i2, View view, ViewGroup viewGroup, t tVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        super.W(i2, view, viewGroup, tVar, frsNoListItemViewHolder);
        if (tVar.c() == 6) {
            frsNoListItemViewHolder.f15221d.setText(R.string.attention_no_post_tip);
        } else {
            frsNoListItemViewHolder.f15221d.setText(R.string.no_data_common_txt);
        }
        SkinManager.setViewTextColor(frsNoListItemViewHolder.f15221d, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(frsNoListItemViewHolder.f15222e, R.drawable.new_pic_emotion_06);
        return view;
    }
}
