package d.a.n0.r0.n1.d;

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
public class d0 extends d.a.n0.r0.k<d.a.n0.e3.q, FrsVideoActivityViewHolder> {
    public String w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.e3.q f62716e;

        public a(d.a.n0.e3.q qVar) {
            this.f62716e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12587").param("fid", d0.this.w));
            d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
            j.w("frs_video_activity_tip" + d0.this.w, System.currentTimeMillis());
            d.a.n0.e3.q qVar = this.f62716e;
            if (qVar == null || StringUtils.isNull(qVar.f57892f)) {
                return;
            }
            d.a.m0.l.a.k(d0.this.f42909e, this.f62716e.f57892f);
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
    @Override // d.a.c.k.e.a
    /* renamed from: w0 */
    public FrsVideoActivityViewHolder Q(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42909e).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15356a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15358c, R.color.CAM_X0301);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f15357b, R.drawable.icon_news_list_prompt);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f15359d, R.drawable.icon_index_category_arrow_r);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15360e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15361f, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return frsVideoActivityViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: x0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.e3.q qVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        if (view == null || frsVideoActivityViewHolder == null) {
            return null;
        }
        view.setOnClickListener(new a(qVar));
        frsVideoActivityViewHolder.f15356a.setText(qVar != null ? qVar.f57891e : "");
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        if (v0(j.l("frs_video_activity_tip" + this.w, 0L))) {
            frsVideoActivityViewHolder.f15357b.setVisibility(0);
        } else {
            frsVideoActivityViewHolder.f15357b.setVisibility(8);
        }
        return frsVideoActivityViewHolder.a();
    }

    public void y0(String str) {
        this.w = str;
    }
}
