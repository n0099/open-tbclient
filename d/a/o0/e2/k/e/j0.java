package d.a.o0.e2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
/* loaded from: classes5.dex */
public class j0 extends o<d.a.o0.e2.h.l, PbNoDataItemViewHolder> {
    public j0(d.a.o0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    @Override // d.a.o0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (d.a.o0.e2.h.l) obj, (PbNoDataItemViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbNoDataItemViewHolder Q(ViewGroup viewGroup) {
        return new PbNoDataItemViewHolder(LayoutInflater.from(this.f43012e).inflate(R.layout.pb_no_data_item_layout, viewGroup, false), this.f43012e);
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.o0.e2.h.l lVar, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        super.X(i2, view, viewGroup, lVar, pbNoDataItemViewHolder);
        this.p = TbadkCoreApplication.getInst().getSkinType();
        pbNoDataItemViewHolder.f18994a.setText(lVar.D0);
        int i3 = lVar.C0;
        if (i3 != 0) {
            SkinManager.setImageResource(pbNoDataItemViewHolder.f18995b, i3);
        } else {
            SkinManager.setImageResource(pbNoDataItemViewHolder.f18995b, R.drawable.new_pic_emotion_06);
        }
        SkinManager.setViewTextColor(pbNoDataItemViewHolder.f18994a, R.color.CAM_X0109);
        if (lVar.E0 != 0 && view.getLayoutParams() != null) {
            view.getLayoutParams().height = lVar.E0;
        }
        if (lVar.F0 != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f18995b.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, lVar.F0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        if (lVar.G0 != 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.f18994a.getLayoutParams();
            int i4 = marginLayoutParams2.leftMargin;
            marginLayoutParams2.setMargins(i4, i4, marginLayoutParams2.rightMargin, lVar.G0);
        }
        pbNoDataItemViewHolder.f18995b.setVisibility(lVar.H0);
        return view;
    }
}
