package d.b.i0.n0.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ComplaintBarlordViewHolder;
/* loaded from: classes4.dex */
public class a extends d.b.b.j.e.a<b, ComplaintBarlordViewHolder> {
    public int m;
    public View.OnClickListener n;

    /* renamed from: d.b.i0.n0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1351a implements View.OnClickListener {
        public View$OnClickListenerC1351a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                String str = (String) view.getTag();
                if (a.this.m == 1 || a.this.m == 4) {
                    str = str + "?isNightModel=1";
                }
                CustomMessage customMessage = new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.f42357e, a.this.f42357e.getString(R.string.complaint_bar_lord), str, true));
                customMessage.setTag(a.this.i);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public a(d.b.b.a.f fVar) {
        super(fVar.getPageActivity(), b.f57021g, fVar.getUniqueId());
        this.n = new View$OnClickListenerC1351a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        p0(i, view, viewGroup, bVar, complaintBarlordViewHolder);
        return view;
    }

    public final void m0(ComplaintBarlordViewHolder complaintBarlordViewHolder, b bVar) {
        complaintBarlordViewHolder.f15915d.setText(bVar.f57022e);
        complaintBarlordViewHolder.f15913b.setTag(bVar.f57023f);
        complaintBarlordViewHolder.f15913b.setOnClickListener(this.n);
    }

    public final void n0(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (complaintBarlordViewHolder.f15912a == skinType) {
            return;
        }
        complaintBarlordViewHolder.f15912a = skinType;
        SkinManager.setBackgroundResource(complaintBarlordViewHolder.f15913b, R.drawable.frs_member_manito_bg);
        SkinManager.setBackgroundColor(complaintBarlordViewHolder.f15914c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(complaintBarlordViewHolder.f15915d, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(complaintBarlordViewHolder.f15916e, R.drawable.icon_arrow12_gray66_right);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public ComplaintBarlordViewHolder R(ViewGroup viewGroup) {
        return new ComplaintBarlordViewHolder(LayoutInflater.from(this.f42357e).inflate(R.layout.item_complaint_bar_lord_view, viewGroup, false));
    }

    public View p0(int i, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        if (bVar != null && complaintBarlordViewHolder != null) {
            n0(complaintBarlordViewHolder);
            m0(complaintBarlordViewHolder, bVar);
        }
        return view;
    }
}
