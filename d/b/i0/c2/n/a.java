package d.b.i0.c2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.GodReplyMoreViewHolder;
import d.b.i0.c2.k.e.m;
/* loaded from: classes5.dex */
public class a extends m<b, GodReplyMoreViewHolder> {
    public View.OnClickListener s;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (b) obj, (GodReplyMoreViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public GodReplyMoreViewHolder R(ViewGroup viewGroup) {
        return new GodReplyMoreViewHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, b bVar, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        TextView textView;
        super.X(i, view, viewGroup, bVar, godReplyMoreViewHolder);
        if (godReplyMoreViewHolder != null && (textView = godReplyMoreViewHolder.f19956a) != null) {
            View.OnClickListener onClickListener = this.s;
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            if (godReplyMoreViewHolder.f19958c != TbadkCoreApplication.getInst().getSkinType()) {
                godReplyMoreViewHolder.f19958c = TbadkCoreApplication.getInst().getSkinType();
                SkinManager.setViewTextColor(godReplyMoreViewHolder.f19956a, R.color.CAM_X0106);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19956a, R.drawable.more_all);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19957b, R.color.CAM_X0204);
            }
        }
        return view;
    }

    public void m0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
