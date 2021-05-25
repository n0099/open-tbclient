package d.a.n0.p0.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.manito.ManitoHeaderItemViewHolder;
import d.a.n0.r0.k;
/* loaded from: classes4.dex */
public class a extends k<b, ManitoHeaderItemViewHolder> {
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        t0(i2, view, viewGroup, (b) obj, (ManitoHeaderItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public ManitoHeaderItemViewHolder P(ViewGroup viewGroup) {
        return new ManitoHeaderItemViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.manito_item_header, (ViewGroup) null));
    }

    public View t0(int i2, View view, ViewGroup viewGroup, b bVar, ManitoHeaderItemViewHolder manitoHeaderItemViewHolder) {
        super.W(i2, view, viewGroup, bVar, manitoHeaderItemViewHolder);
        if (manitoHeaderItemViewHolder.f14955b != this.r) {
            SkinManager.setBackgroundColor(manitoHeaderItemViewHolder.a(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(manitoHeaderItemViewHolder.f14954a, R.color.CAM_X0105, 1);
        }
        manitoHeaderItemViewHolder.f14954a.setText(String.format(this.f39228e.getResources().getString(R.string.forum_manito_num), Integer.valueOf(bVar.c())));
        manitoHeaderItemViewHolder.f14955b = this.r;
        return view;
    }
}
