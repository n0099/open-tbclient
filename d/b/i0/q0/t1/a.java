package d.b.i0.q0.t1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.gamepaltform.GameRankListViewHolder;
import d.b.i0.q0.j2.d;
import d.b.i0.q0.k;
/* loaded from: classes4.dex */
public class a extends k<d.b.i0.t0.b, GameRankListViewHolder> implements d {
    public d.b.i0.q0.j2.b w;

    /* renamed from: d.b.i0.q0.t1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1503a implements GameRankHorizontalLayout.b {
        public C1503a() {
        }

        @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.b
        public void a(d.b.i0.t0.a aVar, int i) {
            if (aVar == null) {
                return;
            }
            if (a.this.w != null) {
                TiebaStatic.log(new StatisticItem("c12105").param("fid", a.this.w.f59401c).param("obj_locate", i + 1));
            }
            if (StringUtils.isNull(aVar.c())) {
                return;
            }
            d.b.h0.l.a.l(a.this.o.getPageActivity(), aVar.c());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
            j.x("game_rank_list_info", System.currentTimeMillis() + ",7");
            d.b.h0.r.d0.b.j().v("game_rank_list_show_times", 0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921005));
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.w = new d.b.i0.q0.j2.b();
    }

    @Override // d.b.i0.q0.j2.d
    public d.b.i0.q0.j2.b b() {
        return this.w;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: v0 */
    public GameRankListViewHolder R(ViewGroup viewGroup) {
        return new GameRankListViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.game_rank_list_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: w0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t0.b bVar, GameRankListViewHolder gameRankListViewHolder) {
        super.X(i, view, viewGroup, bVar, gameRankListViewHolder);
        if (bVar == null) {
            return null;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        if (this.w != null) {
            TiebaStatic.log(new StatisticItem("c12104").param("fid", this.w.f59401c));
        }
        GameRankHorizontalLayout gameRankHorizontalLayout = gameRankListViewHolder.f16027a;
        if (gameRankHorizontalLayout != null) {
            gameRankHorizontalLayout.setData(bVar);
            gameRankListViewHolder.f16027a.setOnCardClickListener(new C1503a());
        }
        TextView textView = gameRankListViewHolder.f16028b;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
        this.o.getLayoutMode().k(this.r == 1);
        this.o.getLayoutMode().j(view);
        return view;
    }
}
