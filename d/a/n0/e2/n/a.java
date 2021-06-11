package d.a.n0.e2.n;

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
import d.a.n0.e2.k.e.o;
/* loaded from: classes5.dex */
public class a extends o<b, GodReplyMoreViewHolder> {
    public View.OnClickListener s;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (b) obj, (GodReplyMoreViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public GodReplyMoreViewHolder Q(ViewGroup viewGroup) {
        return new GodReplyMoreViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    public View i0(int i2, View view, ViewGroup viewGroup, b bVar, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        TextView textView;
        super.X(i2, view, viewGroup, bVar, godReplyMoreViewHolder);
        if (godReplyMoreViewHolder != null && (textView = godReplyMoreViewHolder.f19418a) != null) {
            View.OnClickListener onClickListener = this.s;
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            if (godReplyMoreViewHolder.f19420c != TbadkCoreApplication.getInst().getSkinType()) {
                godReplyMoreViewHolder.f19420c = TbadkCoreApplication.getInst().getSkinType();
                SkinManager.setViewTextColor(godReplyMoreViewHolder.f19418a, R.color.CAM_X0106);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19418a, R.drawable.more_all);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19419b, R.color.CAM_X0204);
            }
        }
        return view;
    }

    public void j0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
