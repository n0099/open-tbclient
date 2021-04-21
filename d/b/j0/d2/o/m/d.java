package d.b.j0.d2.o.m;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbEnterForumAndTopicViewHolder;
import d.b.c.e.p.l;
import d.b.j0.d2.h.t;
/* loaded from: classes3.dex */
public class d extends d.b.c.j.e.a<t, VideoPbEnterForumAndTopicViewHolder> {
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, t tVar, VideoPbEnterForumAndTopicViewHolder videoPbEnterForumAndTopicViewHolder) {
        i0(i, view, viewGroup, tVar, videoPbEnterForumAndTopicViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public VideoPbEnterForumAndTopicViewHolder R(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f43095e);
        FlowLabelLayout flowLabelLayout = new FlowLabelLayout(this.f43095e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = l.g(this.f43095e, R.dimen.M_W_X007);
        layoutParams.topMargin = l.g(this.f43095e, R.dimen.M_W_X004);
        layoutParams.rightMargin = l.g(this.f43095e, R.dimen.M_W_X007);
        layoutParams.bottomMargin = l.g(this.f43095e, R.dimen.M_W_X004);
        frameLayout.addView(flowLabelLayout, layoutParams);
        return new VideoPbEnterForumAndTopicViewHolder(this.f43095e, frameLayout);
    }

    public View i0(int i, View view, ViewGroup viewGroup, t tVar, VideoPbEnterForumAndTopicViewHolder videoPbEnterForumAndTopicViewHolder) {
        if (tVar != null) {
            videoPbEnterForumAndTopicViewHolder.setData(tVar.f54292e);
        }
        videoPbEnterForumAndTopicViewHolder.b();
        return view;
    }
}
