package d.a.j0.d2.o.m;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbEnterForumViewHolder;
import d.a.c.e.p.l;
import d.a.j0.d2.h.u;
/* loaded from: classes3.dex */
public class c extends d.a.c.j.e.a<u, VideoPbEnterForumViewHolder> {
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, u uVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        f0(i2, view, viewGroup, uVar, videoPbEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public VideoPbEnterForumViewHolder P(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f40319e);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f40319e);
        cardForumHeadLayout.setPadding(l.g(this.f40319e, R.dimen.tbds32), 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(this.f40319e, R.dimen.tbds156));
        layoutParams.leftMargin = l.g(this.f40319e, R.dimen.tbds44);
        layoutParams.rightMargin = l.g(this.f40319e, R.dimen.tbds44);
        layoutParams.bottomMargin = l.g(this.f40319e, R.dimen.tbds76);
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        return new VideoPbEnterForumViewHolder(frameLayout);
    }

    public View f0(int i2, View view, ViewGroup viewGroup, u uVar, VideoPbEnterForumViewHolder videoPbEnterForumViewHolder) {
        if (uVar != null) {
            videoPbEnterForumViewHolder.setData(uVar.f52078e);
        }
        videoPbEnterForumViewHolder.b();
        return view;
    }
}
