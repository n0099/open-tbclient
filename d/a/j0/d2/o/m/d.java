package d.a.j0.d2.o.m;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbEnterForumAndTopicViewHolder;
import d.a.c.e.p.l;
import d.a.j0.d2.h.t;
/* loaded from: classes3.dex */
public class d extends d.a.c.j.e.a<t, VideoPbEnterForumAndTopicViewHolder> {
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, t tVar, VideoPbEnterForumAndTopicViewHolder videoPbEnterForumAndTopicViewHolder) {
        f0(i2, view, viewGroup, tVar, videoPbEnterForumAndTopicViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public VideoPbEnterForumAndTopicViewHolder P(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f40319e);
        FlowLabelLayout flowLabelLayout = new FlowLabelLayout(this.f40319e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = l.g(this.f40319e, R.dimen.M_W_X007);
        layoutParams.topMargin = l.g(this.f40319e, R.dimen.M_W_X004);
        layoutParams.rightMargin = l.g(this.f40319e, R.dimen.M_W_X007);
        layoutParams.bottomMargin = l.g(this.f40319e, R.dimen.M_W_X004);
        frameLayout.addView(flowLabelLayout, layoutParams);
        return new VideoPbEnterForumAndTopicViewHolder(this.f40319e, frameLayout);
    }

    public View f0(int i2, View view, ViewGroup viewGroup, t tVar, VideoPbEnterForumAndTopicViewHolder videoPbEnterForumAndTopicViewHolder) {
        if (tVar != null) {
            videoPbEnterForumAndTopicViewHolder.setData(tVar.f52076e);
        }
        videoPbEnterForumAndTopicViewHolder.b();
        return view;
    }
}
