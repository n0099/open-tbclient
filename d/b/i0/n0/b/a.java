package d.b.i0.n0.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.manito.ManitoHeaderItemViewHolder;
import d.b.i0.p0.k;
/* loaded from: classes4.dex */
public class a extends k<b, ManitoHeaderItemViewHolder> {
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        u0(i, view, viewGroup, (b) obj, (ManitoHeaderItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: t0 */
    public ManitoHeaderItemViewHolder R(ViewGroup viewGroup) {
        return new ManitoHeaderItemViewHolder(LayoutInflater.from(this.f42357e).inflate(R.layout.manito_item_header, (ViewGroup) null));
    }

    public View u0(int i, View view, ViewGroup viewGroup, b bVar, ManitoHeaderItemViewHolder manitoHeaderItemViewHolder) {
        super.X(i, view, viewGroup, bVar, manitoHeaderItemViewHolder);
        if (manitoHeaderItemViewHolder.f15905b != this.r) {
            SkinManager.setBackgroundColor(manitoHeaderItemViewHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(manitoHeaderItemViewHolder.f15904a, R.color.CAM_X0105, 1);
        }
        manitoHeaderItemViewHolder.f15904a.setText(String.format(this.f42357e.getResources().getString(R.string.forum_manito_num), Integer.valueOf(bVar.a())));
        manitoHeaderItemViewHolder.f15905b = this.r;
        return view;
    }
}
