package d.b.i0.p0.n1.d;

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
public class i0 extends d.b.i0.p0.k<d.b.i0.c3.q, FrsVideoActivityViewHolder> {
    public String w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.c3.q f57995e;

        public a(d.b.i0.c3.q qVar) {
            this.f57995e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12587").param("fid", i0.this.w));
            d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
            i.v("frs_video_activity_tip" + i0.this.w, System.currentTimeMillis());
            d.b.i0.c3.q qVar = this.f57995e;
            if (qVar == null || StringUtils.isNull(qVar.f53573f)) {
                return;
            }
            d.b.h0.l.a.k(i0.this.f42357e, this.f57995e.f53573f);
        }
    }

    public i0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
    @Override // d.b.b.j.e.a
    /* renamed from: w0 */
    public FrsVideoActivityViewHolder R(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f42357e).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f16219a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f16221c, R.color.CAM_X0301);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f16220b, R.drawable.icon_news_list_prompt);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f16222d, R.drawable.icon_index_category_arrow_r);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f16223e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f16224f, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return frsVideoActivityViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: x0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.c3.q qVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        if (view == null || frsVideoActivityViewHolder == null) {
            return null;
        }
        view.setOnClickListener(new a(qVar));
        frsVideoActivityViewHolder.f16219a.setText(qVar != null ? qVar.f53572e : "");
        d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
        if (v0(i2.k("frs_video_activity_tip" + this.w, 0L))) {
            frsVideoActivityViewHolder.f16220b.setVisibility(0);
        } else {
            frsVideoActivityViewHolder.f16220b.setVisibility(8);
        }
        return frsVideoActivityViewHolder.a();
    }

    public void y0(String str) {
        this.w = str;
    }
}
