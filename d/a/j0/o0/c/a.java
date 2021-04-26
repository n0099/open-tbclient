package d.a.j0.o0.c;

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
public class a extends d.a.c.j.e.a<b, ComplaintBarlordViewHolder> {
    public int m;
    public View.OnClickListener n;

    /* renamed from: d.a.j0.o0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1378a implements View.OnClickListener {
        public View$OnClickListenerC1378a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                String str = (String) view.getTag();
                if (a.this.m == 1 || a.this.m == 4) {
                    str = str + "?isNightModel=1";
                }
                CustomMessage customMessage = new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.f40319e, a.this.f40319e.getString(R.string.complaint_bar_lord), str, true));
                customMessage.setTag(a.this.f40323i);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    public a(d.a.c.a.f fVar) {
        super(fVar.getPageActivity(), b.f57168g, fVar.getUniqueId());
        this.n = new View$OnClickListenerC1378a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        n0(i2, view, viewGroup, bVar, complaintBarlordViewHolder);
        return view;
    }

    public final void i0(ComplaintBarlordViewHolder complaintBarlordViewHolder, b bVar) {
        complaintBarlordViewHolder.f15747d.setText(bVar.f57169e);
        complaintBarlordViewHolder.f15745b.setTag(bVar.f57170f);
        complaintBarlordViewHolder.f15745b.setOnClickListener(this.n);
    }

    public final void j0(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (complaintBarlordViewHolder.f15744a == skinType) {
            return;
        }
        complaintBarlordViewHolder.f15744a = skinType;
        SkinManager.setBackgroundResource(complaintBarlordViewHolder.f15745b, R.drawable.frs_member_manito_bg);
        SkinManager.setBackgroundColor(complaintBarlordViewHolder.f15746c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(complaintBarlordViewHolder.f15747d, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(complaintBarlordViewHolder.f15748e, R.drawable.icon_arrow12_gray66_right);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public ComplaintBarlordViewHolder P(ViewGroup viewGroup) {
        return new ComplaintBarlordViewHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.item_complaint_bar_lord_view, viewGroup, false));
    }

    public View n0(int i2, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        if (bVar != null && complaintBarlordViewHolder != null) {
            j0(complaintBarlordViewHolder);
            i0(complaintBarlordViewHolder, bVar);
        }
        return view;
    }
}
