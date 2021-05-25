package d.a.n0.v.j.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class i extends d.a.c.j.e.a<d.a.n0.v.j.d.l, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;
    public TextView n;
    public String o;
    public String p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.g0();
        }
    }

    public i(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.j.d.l.f62067f);
        this.m = tbPageContext;
    }

    public final void f0(d.a.n0.v.j.d.l lVar, d.a.n0.v.j.h.a aVar) {
        d.a.n0.v.j.d.c h2 = lVar.h();
        if (h2 == null || aVar == null) {
            return;
        }
        this.n = aVar.s();
        this.o = h2.b().user_id;
        j0(h2, aVar);
        aVar.x(8);
        aVar.y(this.f39228e.getResources().getString(R.string.ala_person_live_privilege));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g0() {
        AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
        m0(this.n, this.p, false);
        StatisticItem statisticItem = new StatisticItem("c13333");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        String p = d.a.m0.r.d0.b.j().p("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
        if (p == null) {
            return;
        }
        if (p.endsWith("/")) {
            p = p.substring(0, p.length() - 1);
        }
        String str = this.o;
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(str);
        if (!p.contains("?")) {
            sb.insert(0, "?");
        } else {
            sb.insert(0, "&");
        }
        sb.insert(0, p);
        d.a.m0.l.a.l(this.m.getPageActivity(), sb.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public CardViewHolder<d.a.n0.v.j.h.a> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.v.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.j.d.l lVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        f0(lVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a());
        return cardViewHolder.b().l();
    }

    public final void j0(d.a.n0.v.j.d.c cVar, d.a.n0.v.j.h.a aVar) {
        if (cVar == null || aVar == null) {
        }
    }

    public final void m0(TextView textView, String str, boolean z) {
        if (textView == null || this.m == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.m.getResources().getDrawable(R.drawable.ala_person_center_red_tip_drawable);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
