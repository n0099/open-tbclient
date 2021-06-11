package d.a.n0.p0.c;

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
public class a extends d.a.c.k.e.a<b, ComplaintBarlordViewHolder> {
    public int m;
    public View.OnClickListener n;

    /* renamed from: d.a.n0.p0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1516a implements View.OnClickListener {
        public View$OnClickListenerC1516a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                String str = (String) view.getTag();
                if (a.this.m == 1 || a.this.m == 4) {
                    str = str + "?isNightModel=1";
                }
                CustomMessage customMessage = new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.f42909e, a.this.f42909e.getString(R.string.complaint_bar_lord), str, true));
                customMessage.setTag(a.this.f42913i);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public a(d.a.c.a.f fVar) {
        super(fVar.getPageActivity(), b.f61675g, fVar.getUniqueId());
        this.n = new View$OnClickListenerC1516a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        m0(i2, view, viewGroup, bVar, complaintBarlordViewHolder);
        return view;
    }

    public final void j0(ComplaintBarlordViewHolder complaintBarlordViewHolder, b bVar) {
        complaintBarlordViewHolder.f15022d.setText(bVar.f61676e);
        complaintBarlordViewHolder.f15020b.setTag(bVar.f61677f);
        complaintBarlordViewHolder.f15020b.setOnClickListener(this.n);
    }

    public final void k0(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (complaintBarlordViewHolder.f15019a == skinType) {
            return;
        }
        complaintBarlordViewHolder.f15019a = skinType;
        SkinManager.setBackgroundResource(complaintBarlordViewHolder.f15020b, R.drawable.frs_member_manito_bg);
        SkinManager.setBackgroundColor(complaintBarlordViewHolder.f15021c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(complaintBarlordViewHolder.f15022d, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(complaintBarlordViewHolder.f15023e, R.drawable.icon_arrow12_gray66_right);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public ComplaintBarlordViewHolder Q(ViewGroup viewGroup) {
        return new ComplaintBarlordViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.item_complaint_bar_lord_view, viewGroup, false));
    }

    public View m0(int i2, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        if (bVar != null && complaintBarlordViewHolder != null) {
            k0(complaintBarlordViewHolder);
            j0(complaintBarlordViewHolder, bVar);
        }
        return view;
    }
}
