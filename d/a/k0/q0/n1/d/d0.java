package d.a.k0.q0.n1.d;

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
public class d0 extends d.a.k0.q0.k<d.a.k0.d3.q, FrsVideoActivityViewHolder> {
    public String w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.d3.q f58884e;

        public a(d.a.k0.d3.q qVar) {
            this.f58884e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12587").param("fid", d0.this.w));
            d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
            j.w("frs_video_activity_tip" + d0.this.w, System.currentTimeMillis());
            d.a.k0.d3.q qVar = this.f58884e;
            if (qVar == null || StringUtils.isNull(qVar.f53990f)) {
                return;
            }
            d.a.j0.l.a.k(d0.this.f39564e, this.f58884e.f53990f);
        }
    }

    public d0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    public final boolean u0(long j) {
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
    @Override // d.a.c.j.e.a
    /* renamed from: v0 */
    public FrsVideoActivityViewHolder P(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f39564e).inflate(R.layout.frs_video_activity_item, (ViewGroup) null);
        FrsVideoActivityViewHolder frsVideoActivityViewHolder = new FrsVideoActivityViewHolder(inflate);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15391a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(frsVideoActivityViewHolder.f15393c, R.color.CAM_X0301);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f15392b, R.drawable.icon_news_list_prompt);
        SkinManager.setImageResource(frsVideoActivityViewHolder.f15394d, R.drawable.icon_index_category_arrow_r);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15395e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(frsVideoActivityViewHolder.f15396f, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(inflate, R.drawable.home_thread_card_item_bg);
        return frsVideoActivityViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: w0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.d3.q qVar, FrsVideoActivityViewHolder frsVideoActivityViewHolder) {
        if (view == null || frsVideoActivityViewHolder == null) {
            return null;
        }
        view.setOnClickListener(new a(qVar));
        frsVideoActivityViewHolder.f15391a.setText(qVar != null ? qVar.f53989e : "");
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        if (u0(j.l("frs_video_activity_tip" + this.w, 0L))) {
            frsVideoActivityViewHolder.f15392b.setVisibility(0);
        } else {
            frsVideoActivityViewHolder.f15392b.setVisibility(8);
        }
        return frsVideoActivityViewHolder.a();
    }

    public void x0(String str) {
        this.w = str;
    }
}
