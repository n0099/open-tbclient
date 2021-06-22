package d.a.o0.e2.o.m;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbEnterForumViewHolder;
import d.a.c.e.p.l;
import d.a.o0.e2.h.v;
/* loaded from: classes5.dex */
public class c extends d.a.c.k.e.a<v, VideoPbEnterForumViewHolder> {
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, v vVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        g0(i2, view, viewGroup, vVar, videoPbEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public VideoPbEnterForumViewHolder Q(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f43012e);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f43012e);
        cardForumHeadLayout.setPadding(l.g(this.f43012e, R.dimen.tbds32), 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(this.f43012e, R.dimen.tbds156));
        layoutParams.leftMargin = l.g(this.f43012e, R.dimen.tbds44);
        layoutParams.rightMargin = l.g(this.f43012e, R.dimen.tbds44);
        layoutParams.bottomMargin = l.g(this.f43012e, R.dimen.tbds76);
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        return new VideoPbEnterForumViewHolder(frameLayout);
    }

    public View g0(int i2, View view, ViewGroup viewGroup, v vVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        if (vVar != null) {
            videoPbEnterForumViewHolder.setData(vVar.f56797e);
        }
        videoPbEnterForumViewHolder.b();
        return view;
    }
}
