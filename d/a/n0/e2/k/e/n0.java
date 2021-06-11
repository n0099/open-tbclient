package d.a.n0.e2.k.e;

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
/* loaded from: classes5.dex */
public class n0 extends o<d.a.n0.e2.h.o, PbReplyTitleViewHolder> {
    public View.OnClickListener s;
    public SortSwitchButton.f t;
    public BdUniqueId u;
    public BdUniqueId v;
    public boolean w;
    public d.a.n0.e2.h.e x;
    public View y;

    public n0(d.a.n0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
        this.w = false;
        this.u = BdUniqueId.gen();
        this.v = BdUniqueId.gen();
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view, viewGroup, (d.a.n0.e2.h.o) obj, (PbReplyTitleViewHolder) viewHolder);
        return view;
    }

    public void e(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public final void h0() {
        d.a.n0.e2.h.e eVar = this.x;
        if (eVar == null || eVar.L() == null || this.x.h() == null) {
            return;
        }
        d.a.n0.e2.h.e eVar2 = this.x;
        if (eVar2.f56616i && !this.w) {
            this.w = true;
            boolean isLike = eVar2.h().getIsLike();
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_id", this.x.h().i()).param("thread_type", this.x.L().v1()).param("tid", this.x.L().o0()));
            if (isLike) {
                return;
            }
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_id", this.x.h().i()).param("thread_type", this.x.L().v1()).param("tid", this.x.L().o0()));
        }
    }

    public View i0() {
        return this.y;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public PbReplyTitleViewHolder Q(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42909e).inflate(R.layout.pb_reply_title_layout, viewGroup, false);
        this.y = inflate;
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.m.getPageContext(), inflate);
        PbFragment pbFragment = this.n;
        if (pbFragment != null) {
            pbReplyTitleViewHolder.q(pbFragment.g0);
        }
        pbReplyTitleViewHolder.u = false;
        pbReplyTitleViewHolder.p(this.s);
        pbReplyTitleViewHolder.o(this.t);
        if (H() == d.a.n0.e2.h.o.l) {
            pbReplyTitleViewHolder.n(this.u);
        } else if (H() == d.a.n0.e2.h.o.m) {
            pbReplyTitleViewHolder.m(this.v);
        }
        return pbReplyTitleViewHolder;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, d.a.n0.e2.h.o oVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        super.X(i2, view, viewGroup, oVar, pbReplyTitleViewHolder);
        if (pbReplyTitleViewHolder != null) {
            h0();
            oVar.k = this.x.f56613f;
            pbReplyTitleViewHolder.h(oVar);
        }
        return view;
    }

    public void l0(SortSwitchButton.f fVar) {
        this.t = fVar;
    }

    public void onDestroy() {
        this.w = false;
        MessageManager.getInstance().unRegisterListener(this.u);
        MessageManager.getInstance().unRegisterListener(this.v);
    }

    public void t(d.a.n0.e2.h.e eVar) {
        this.x = eVar;
    }
}
