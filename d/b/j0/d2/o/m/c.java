package d.b.j0.d2.o.m;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbEnterForumViewHolder;
import d.b.c.e.p.l;
import d.b.j0.d2.h.u;
/* loaded from: classes3.dex */
public class c extends d.b.c.j.e.a<u, VideoPbEnterForumViewHolder> {
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, u uVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        i0(i, view, viewGroup, uVar, videoPbEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public VideoPbEnterForumViewHolder R(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f43095e);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f43095e);
        cardForumHeadLayout.setPadding(l.g(this.f43095e, R.dimen.tbds32), 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(this.f43095e, R.dimen.tbds156));
        layoutParams.leftMargin = l.g(this.f43095e, R.dimen.tbds44);
        layoutParams.rightMargin = l.g(this.f43095e, R.dimen.tbds44);
        layoutParams.bottomMargin = l.g(this.f43095e, R.dimen.tbds76);
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        return new VideoPbEnterForumViewHolder(frameLayout);
    }

    public View i0(int i, View view, ViewGroup viewGroup, u uVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        if (uVar != null) {
            videoPbEnterForumViewHolder.setData(uVar.f54294e);
        }
        videoPbEnterForumViewHolder.b();
        return view;
    }
}
