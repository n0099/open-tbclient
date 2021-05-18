package d.a.k0.d2.n;

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
import d.a.k0.d2.k.e.o;
/* loaded from: classes5.dex */
public class a extends o<b, GodReplyMoreViewHolder> {
    public View.OnClickListener s;

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
    }

    @Override // d.a.k0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, (b) obj, (GodReplyMoreViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public GodReplyMoreViewHolder P(ViewGroup viewGroup) {
        return new GodReplyMoreViewHolder(LayoutInflater.from(this.f39564e).inflate(R.layout.pb_god_reply_look_more_item, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, b bVar, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        TextView textView;
        super.W(i2, view, viewGroup, bVar, godReplyMoreViewHolder);
        if (godReplyMoreViewHolder != null && (textView = godReplyMoreViewHolder.f19420a) != null) {
            View.OnClickListener onClickListener = this.s;
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            if (godReplyMoreViewHolder.f19422c != TbadkCoreApplication.getInst().getSkinType()) {
                godReplyMoreViewHolder.f19422c = TbadkCoreApplication.getInst().getSkinType();
                SkinManager.setViewTextColor(godReplyMoreViewHolder.f19420a, R.color.CAM_X0106);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19420a, R.drawable.more_all);
                SkinManager.setBackgroundResource(godReplyMoreViewHolder.f19421b, R.color.CAM_X0204);
            }
        }
        return view;
    }

    public void i0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
