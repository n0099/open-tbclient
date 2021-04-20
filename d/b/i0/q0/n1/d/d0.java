package d.b.i0.q0.n1.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsVideoActivityViewHolder;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class d0 extends d.b.i0.q0.k<d.b.i0.d3.q, FrsVideoActivityViewHolder> {
    public String w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d3.q f59641e;

        public a(d.b.i0.d3.q qVar) {
            this.f59641e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12587").param("fid", d0.this.w));
            d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
            j.w("frs_video_activity_tip" + d0.this.w, System.currentTimeMillis());
            d.b.i0.d3.q qVar = this.f59641e;
            if (qVar == null || StringUtils.isNull(qVar.f55018f)) {
                return;
            }
            d.b.h0.l.a.k(d0.this.f42855e, this.f59641e.f55018f);
        }
    }

    public d0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    public final boolean v0(long j) {
        if (j == 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j > 86400000) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        return calendar.get(7) > calendar2.get(7);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: w0 */
    public FrsVideoActivityViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42855e).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15881a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15883c, R.color.CAM_X0301);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f15882b, R.drawable.icon_news_list_prompt);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f15884d, R.drawable.icon_index_category_arrow_r);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15885e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15886f, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return frsVideoActivityViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.q0.k, d.b.c.j.e.a
    /* renamed from: x0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.d3.q qVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        if (view == null || frsVideoActivityViewHolder == null) {
            return null;
        }
        view.setOnClickListener(new a(qVar));
        frsVideoActivityViewHolder.f15881a.setText(qVar != null ? qVar.f55017e : "");
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        if (v0(j.l("frs_video_activity_tip" + this.w, 0L))) {
            frsVideoActivityViewHolder.f15882b.setVisibility(0);
        } else {
            frsVideoActivityViewHolder.f15882b.setVisibility(8);
        }
        return frsVideoActivityViewHolder.a();
    }

    public void y0(String str) {
        this.w = str;
    }
}
