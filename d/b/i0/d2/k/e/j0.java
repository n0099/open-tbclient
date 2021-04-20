package d.b.i0.d2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
/* loaded from: classes3.dex */
public class j0 extends o<d.b.i0.d2.h.l, PbNoDataItemViewHolder> {
    public j0(d.b.i0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (d.b.i0.d2.h.l) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public PbNoDataItemViewHolder R(ViewGroup viewGroup) {
        return new PbNoDataItemViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.f42855e);
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.d2.h.l lVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        super.X(i, view, viewGroup, lVar, pbNoDataItemViewHolder);
        this.p = TbadkCoreApplication.getInst().getSkinType();
        pbNoDataItemViewHolder.f19168a.setText(lVar.y0);
        int i2 = lVar.x0;
        if (i2 != 0) {
            SkinManager.setImageResource(pbNoDataItemViewHolder.f19169b, i2);
        } else {
            SkinManager.setImageResource(pbNoDataItemViewHolder.f19169b, R.drawable.new_pic_emotion_06);
        }
        SkinManager.setViewTextColor(pbNoDataItemViewHolder.f19168a, R.color.CAM_X0109);
        if (lVar.z0 != 0 && view.getLayoutParams() != null) {
            view.getLayoutParams().height = lVar.z0;
        }
        if (lVar.A0 != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f19169b.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.A0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        if (lVar.B0 != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f19168a.getLayoutParams();
            int i3 = marginLayoutParams2.leftMargin;
            marginLayoutParams2.setMargins(i3, i3, marginLayoutParams2.rightMargin, lVar.B0);
        }
        pbNoDataItemViewHolder.f19169b.setVisibility(lVar.C0);
        return view;
    }
}
