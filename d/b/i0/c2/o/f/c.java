package d.b.i0.c2.o.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbEnterForumViewHolder;
import d.b.b.e.p.l;
import d.b.i0.c2.h.u;
/* loaded from: classes5.dex */
public class c extends d.b.b.j.e.a<u, VideoPbEnterForumViewHolder> {
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, u uVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        i0(i, view, viewGroup, uVar, videoPbEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public VideoPbEnterForumViewHolder R(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f42357e);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f42357e);
        cardForumHeadLayout.setPadding(l.g(this.f42357e, R.dimen.tbds32), 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(this.f42357e, R.dimen.tbds156));
        layoutParams.leftMargin = l.g(this.f42357e, R.dimen.tbds44);
        layoutParams.rightMargin = l.g(this.f42357e, R.dimen.tbds44);
        layoutParams.bottomMargin = l.g(this.f42357e, R.dimen.tbds76);
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        return new VideoPbEnterForumViewHolder(frameLayout);
    }

    public View i0(int i, View view, ViewGroup viewGroup, u uVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        if (uVar != null) {
            videoPbEnterForumViewHolder.setData(uVar.f52477e);
        }
        videoPbEnterForumViewHolder.b();
        return view;
    }
}
