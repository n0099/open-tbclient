package d.b.j0.q0;

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
        this.w = (d.b.c.e.p.l.i(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds90);
    }

    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i, view, viewGroup, (t) obj, (FrsNoListItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: t0 */
    public FrsNoListItemViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f43095e).inflate(R.layout.frs_no_list_item_view, viewGroup, false);
        ViewGroup.LayoutParams u = u(viewGroup);
        u.width = -1;
        u.height = this.w;
        inflate.setLayoutParams(u);
        return new FrsNoListItemViewHolder(inflate, viewGroup);
    }

    public View u0(int i, View view, ViewGroup viewGroup, t tVar, FrsNoListItemViewHolder frsNoListItemViewHolder) {
        super.X(i, view, viewGroup, tVar, frsNoListItemViewHolder);
        if (tVar.a() == 6) {
            frsNoListItemViewHolder.f15738d.setText(R.string.attention_no_post_tip);
        } else {
            frsNoListItemViewHolder.f15738d.setText(R.string.no_data_common_txt);
        }
        SkinManager.setViewTextColor(frsNoListItemViewHolder.f15738d, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(frsNoListItemViewHolder.f15739e, R.drawable.new_pic_emotion_06);
        return view;
    }
}
