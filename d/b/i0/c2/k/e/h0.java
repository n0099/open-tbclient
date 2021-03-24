package d.b.i0.c2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
/* loaded from: classes4.dex */
public class h0 extends m<d.b.i0.c2.h.l, PbNoDataItemViewHolder> {
    public h0(d.b.i0.c2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (d.b.i0.c2.h.l) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public PbNoDataItemViewHolder R(ViewGroup viewGroup) {
        return new PbNoDataItemViewHolder(LayoutInflater.from(this.f42357e).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.f42357e);
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.c2.h.l lVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        super.X(i, view, viewGroup, lVar, pbNoDataItemViewHolder);
        this.p = TbadkCoreApplication.getInst().getSkinType();
        pbNoDataItemViewHolder.f19490a.setText(lVar.x0);
        int i2 = lVar.w0;
        if (i2 != 0) {
            SkinManager.setImageResource(pbNoDataItemViewHolder.f19491b, i2);
        } else {
            SkinManager.setImageResource(pbNoDataItemViewHolder.f19491b, R.drawable.new_pic_emotion_06);
        }
        SkinManager.setViewTextColor(pbNoDataItemViewHolder.f19490a, R.color.CAM_X0109);
        if (lVar.y0 != 0 && view.getLayoutParams() != null) {
            view.getLayoutParams().height = lVar.y0;
        }
        if (lVar.z0 != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f19491b.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.z0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        if (lVar.A0 != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f19490a.getLayoutParams();
            int i3 = marginLayoutParams2.leftMargin;
            marginLayoutParams2.setMargins(i3, i3, marginLayoutParams2.rightMargin, lVar.A0);
        }
        pbNoDataItemViewHolder.f19491b.setVisibility(lVar.B0);
        return view;
    }
}
