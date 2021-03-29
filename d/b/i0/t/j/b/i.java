package d.b.i0.t.j.b;

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
public class i extends d.b.b.j.e.a<d.b.i0.t.j.d.l, CardViewHolder<d.b.i0.t.j.h.a>> {
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
            i.this.j0();
        }
    }

    public i(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.j.d.l.f60871f);
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.j.d.l lVar, d.b.i0.t.j.h.a aVar) {
        d.b.i0.t.j.d.c g2 = lVar.g();
        if (g2 == null || aVar == null) {
            return;
        }
        this.n = aVar.u();
        this.o = g2.b().user_id;
        n0(g2, aVar);
        aVar.z(8);
        aVar.A(this.f42358e.getResources().getString(R.string.ala_person_live_privilege));
        aVar.o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0() {
        AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
        o0(this.n, this.p, false);
        StatisticItem statisticItem = new StatisticItem("c13333");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
        String o = d.b.h0.r.d0.b.i().o("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
        if (o == null) {
            return;
        }
        if (o.endsWith("/")) {
            o = o.substring(0, o.length() - 1);
        }
        String str = this.o;
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(str);
        if (!o.contains("?")) {
            sb.insert(0, "?");
        } else {
            sb.insert(0, "&");
        }
        sb.insert(0, o);
        d.b.h0.l.a.l(this.m.getPageActivity(), sb.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public CardViewHolder<d.b.i0.t.j.h.a> R(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.b.i0.t.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.j.d.l lVar, CardViewHolder<d.b.i0.t.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        i0(lVar, cardViewHolder.b());
        cardViewHolder.b().m().setOnClickListener(new a());
        return cardViewHolder.b().m();
    }

    public final void n0(d.b.i0.t.j.d.c cVar, d.b.i0.t.j.h.a aVar) {
        if (cVar == null || aVar == null) {
        }
    }

    public final void o0(TextView textView, String str, boolean z) {
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
