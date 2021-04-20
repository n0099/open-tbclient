package d.b.i0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.view.SortSwitchButton;
/* loaded from: classes3.dex */
public class n0 extends o<d.b.i0.d2.h.o, PbReplyTitleViewHolder> {
    public View.OnClickListener s;
    public SortSwitchButton.f t;
    public BdUniqueId u;
    public BdUniqueId v;
    public boolean w;
    public d.b.i0.d2.h.e x;
    public View y;

    public n0(d.b.i0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
        this.w = false;
        this.u = BdUniqueId.gen();
        this.v = BdUniqueId.gen();
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i, view, viewGroup, (d.b.i0.d2.h.o) obj, (PbReplyTitleViewHolder) viewHolder);
        return view;
    }

    public final void j0() {
        d.b.i0.d2.h.e eVar = this.x;
        if (eVar == null || eVar.L() == null || this.x.h() == null) {
            return;
        }
        d.b.i0.d2.h.e eVar2 = this.x;
        if (eVar2.i && !this.w) {
            this.w = true;
            boolean isLike = eVar2.h().getIsLike();
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_id", this.x.h().h()).param("thread_type", this.x.L().s1()).param("tid", this.x.L().o0()));
            if (isLike) {
                return;
            }
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_id", this.x.h().h()).param("thread_type", this.x.L().s1()).param("tid", this.x.L().o0()));
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public View l0() {
        return this.y;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public PbReplyTitleViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42855e).inflate(R.layout.pb_reply_title_layout, viewGroup, false);
        this.y = inflate;
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.m.getPageContext(), inflate);
        PbFragment pbFragment = this.n;
        if (pbFragment != null) {
            pbReplyTitleViewHolder.q(pbFragment.g0);
        }
        pbReplyTitleViewHolder.u = false;
        pbReplyTitleViewHolder.p(this.s);
        pbReplyTitleViewHolder.o(this.t);
        if (G() == d.b.i0.d2.h.o.l) {
            pbReplyTitleViewHolder.n(this.u);
        } else if (G() == d.b.i0.d2.h.o.m) {
            pbReplyTitleViewHolder.m(this.v);
        }
        return pbReplyTitleViewHolder;
    }

    public View n0(int i, View view, ViewGroup viewGroup, d.b.i0.d2.h.o oVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.X(i, view, viewGroup, oVar, pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            j0();
            oVar.k = this.x.f53820f;
            pbReplyTitleViewHolder.h(oVar);
        }
        return view;
    }

    public void o0(SortSwitchButton.f fVar) {
        this.t = fVar;
    }

    public void onDestroy() {
        this.w = false;
        MessageManager.getInstance().unRegisterListener(this.u);
        MessageManager.getInstance().unRegisterListener(this.v);
    }

    public void s(d.b.i0.d2.h.e eVar) {
        this.x = eVar;
    }
}
