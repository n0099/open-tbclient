package d.b.i0.d2.n;

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
import d.b.i0.d2.k.e.o;
/* loaded from: classes3.dex */
public class a extends o<b, GodReplyMoreViewHolder> {
    public View.OnClickListener s;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (b) obj, (GodReplyMoreViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public GodReplyMoreViewHolder R(ViewGroup viewGroup) {
        return new GodReplyMoreViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, b bVar, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        TextView textView;
        super.X(i, view, viewGroup, bVar, godReplyMoreViewHolder);
        if (godReplyMoreViewHolder != null && (textView = godReplyMoreViewHolder.f19641a) != null) {
            View.OnClickListener onClickListener = this.s;
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            if (godReplyMoreViewHolder.f19643c != TbadkCoreApplication.getInst().getSkinType()) {
                godReplyMoreViewHolder.f19643c = TbadkCoreApplication.getInst().getSkinType();
                SkinManager.setViewTextColor(godReplyMoreViewHolder.f19641a, R.color.CAM_X0106);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19641a, R.drawable.more_all);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19642b, R.color.CAM_X0204);
            }
        }
        return view;
    }

    public void m0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
