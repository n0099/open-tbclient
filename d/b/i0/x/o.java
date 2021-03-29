package d.b.i0.x;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class o extends b<d.b.i0.x.e0.n> {
    public View A;
    public View B;
    public d.b.i0.x.e0.n C;
    public String D;
    public View m;
    public TextView n;
    public TextView o;
    public LinearLayout p;
    public LinearLayout q;
    public LinearLayout r;
    public LinearLayout s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.h0.p0.b.b(o.this.l())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(o.this.l().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        u(m());
    }

    public void A(boolean z) {
        if (z) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62180e != i) {
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.A, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.B, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.p, R.drawable.card_topic_click_selector);
            SkinManager.setBackgroundResource(this.q, R.drawable.card_topic_click_selector);
            SkinManager.setBackgroundResource(this.r, R.drawable.card_topic_click_selector);
            SkinManager.setBackgroundResource(this.s, R.drawable.card_topic_click_selector);
            v(this.t, 0);
            v(this.u, 1);
            v(this.v, 2);
            v(this.w, 3);
        }
        this.f62180e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int d2 = d.b.b.e.m.b.d((String) view.getTag(), -1);
        d.b.i0.x.e0.n nVar = this.C;
        if (nVar == null || ListUtils.getItem(nVar.f62224h, d2) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(this.D).param("obj_locate", String.valueOf(this.C.j)).param("obj_name", this.C.f62224h.get(d2).f62219b));
        if (d2 >= 0 && !d.b.h0.p0.b.b(l())) {
            l().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(l().getPageActivity()).createNormalConfig(String.valueOf(this.C.f62224h.get(d2).f62218a), this.C.f62224h.get(d2).f62219b, "")));
        }
    }

    public final void u(View view) {
        this.m = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.n = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.o = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.p = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.q = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.r = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.s = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.t = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.u = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.v = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.w = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.x = view.findViewById(R.id.home_top_div);
        this.y = view.findViewById(R.id.home_top_topic_div_one);
        this.z = view.findViewById(R.id.home_top_topic_div_two);
        this.A = view.findViewById(R.id.home_card_top_divider_line);
        this.B = view.findViewById(R.id.home_card_bottom_divider_line);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.o.setOnClickListener(new a());
    }

    public final void v(TextView textView, int i) {
        d.b.i0.x.e0.m mVar;
        d.b.i0.x.e0.n nVar = this.C;
        if (nVar == null || ListUtils.getCount(nVar.f62224h) < 4 || (mVar = (d.b.i0.x.e0.m) ListUtils.getItem(this.C.f62224h, i)) == null) {
            return;
        }
        int i2 = mVar.f62220c;
        if (i2 == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
        } else if (i2 == 2) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
        } else if (i2 != 3) {
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: w */
    public void n(d.b.i0.x.e0.n nVar) {
        if (nVar != null && !StringUtils.isNull(nVar.f62223g) && ListUtils.getCount(nVar.f62224h) >= 4) {
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            this.C = nVar;
            this.A.setVisibility(nVar.f62221e ? 0 : 8);
            A(this.C.f62222f);
            this.n.setText(this.C.f62223g.trim());
            z(this.t, 0);
            z(this.u, 1);
            z(this.v, 2);
            z(this.w, 3);
            v(this.t, 0);
            v(this.u, 1);
            v(this.v, 2);
            v(this.w, 3);
            return;
        }
        this.m.setVisibility(8);
    }

    public void x(String str, String str2) {
        this.D = str2;
    }

    public void y(int i) {
        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
        layoutParams.height = i;
        this.A.setLayoutParams(layoutParams);
    }

    public final void z(TextView textView, int i) {
        d.b.i0.x.e0.m mVar = this.C.f62224h.get(i);
        if (StringUtils.isNull(mVar.f62219b)) {
            return;
        }
        textView.setText(mVar.f62219b.trim());
    }
}
