package d.a.n0.z;

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
public class o extends b<d.a.n0.z.e0.n> {
    public View A;
    public View B;
    public d.a.n0.z.e0.n C;
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
            if (d.a.m0.p0.b.b(o.this.k())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(o.this.k().getPageActivity()).createNormalConfig("homepage", "all")));
        }
    }

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        t(m());
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.f67158e != i2) {
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
            u(this.t, 0);
            u(this.u, 1);
            u(this.v, 2);
            u(this.w, 3);
        }
        this.f67158e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int d2 = d.a.c.e.m.b.d((String) view.getTag(), -1);
        d.a.n0.z.e0.n nVar = this.C;
        if (nVar == null || ListUtils.getItem(nVar.f67206h, d2) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(this.D).param("obj_locate", String.valueOf(this.C.j)).param("obj_name", this.C.f67206h.get(d2).f67201b));
        if (d2 >= 0 && !d.a.m0.p0.b.b(k())) {
            k().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(k().getPageActivity()).createNormalConfig(String.valueOf(this.C.f67206h.get(d2).f67200a), this.C.f67206h.get(d2).f67201b, "")));
        }
    }

    public final void t(View view) {
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

    public final void u(TextView textView, int i2) {
        d.a.n0.z.e0.m mVar;
        d.a.n0.z.e0.n nVar = this.C;
        if (nVar == null || ListUtils.getCount(nVar.f67206h) < 4 || (mVar = (d.a.n0.z.e0.m) ListUtils.getItem(this.C.f67206h, i2)) == null) {
            return;
        }
        int i3 = mVar.f67202c;
        if (i3 == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
        } else if (i3 == 2) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
        } else if (i3 != 3) {
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: v */
    public void n(d.a.n0.z.e0.n nVar) {
        if (nVar != null && !StringUtils.isNull(nVar.f67205g) && ListUtils.getCount(nVar.f67206h) >= 4) {
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            this.C = nVar;
            this.A.setVisibility(nVar.f67203e ? 0 : 8);
            z(this.C.f67204f);
            this.n.setText(this.C.f67205g.trim());
            y(this.t, 0);
            y(this.u, 1);
            y(this.v, 2);
            y(this.w, 3);
            u(this.t, 0);
            u(this.u, 1);
            u(this.v, 2);
            u(this.w, 3);
            return;
        }
        this.m.setVisibility(8);
    }

    public void w(String str, String str2) {
        this.D = str2;
    }

    public void x(int i2) {
        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
        layoutParams.height = i2;
        this.A.setLayoutParams(layoutParams);
    }

    public final void y(TextView textView, int i2) {
        d.a.n0.z.e0.m mVar = this.C.f67206h.get(i2);
        if (StringUtils.isNull(mVar.f67201b)) {
            return;
        }
        textView.setText(mVar.f67201b.trim());
    }

    public void z(boolean z) {
        if (z) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }
}
