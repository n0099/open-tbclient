package d.b.i0.x;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class s extends b<d.b.i0.x.e0.o> {
    public View m;
    public HeadImageView n;
    public TextView o;
    public TextView p;
    public TbImageView q;
    public TextView r;
    public View s;
    public d.b.i0.x.e0.o t;
    public int u;
    public String v;
    public String w;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.u = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        u(m());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_promotion_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62180e != i) {
            SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundResource(this.r, R.drawable.label_bg_gray);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
            this.n.setPlaceHolder(1);
            this.q.setPlaceHolder(2);
        }
        this.f62180e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.n || view == this.o || view == this.r) && !StringUtils.isNull(this.t.f62228h)) {
            TiebaStatic.log(new StatisticItem(this.v).param("obj_id", String.valueOf(this.t.f62225e)));
            UrlManager.getInstance().dealOneLink(l(), new String[]{this.t.f62228h});
        } else if ((view == this.m || view == this.p || view == this.q) && !StringUtils.isNull(this.t.k)) {
            TiebaStatic.log(new StatisticItem(this.w).param("obj_id", String.valueOf(this.t.f62225e)));
            UrlManager.getInstance().dealOneLink(l(), new String[]{this.t.k});
        }
    }

    public final void u(View view) {
        this.m = view.findViewById(R.id.root_view);
        this.n = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.o = (TextView) view.findViewById(R.id.promotion_name);
        this.p = (TextView) view.findViewById(R.id.promotion_desc);
        this.q = (TbImageView) view.findViewById(R.id.promotion_img);
        this.r = (TextView) view.findViewById(R.id.promotion_icon);
        this.s = view.findViewById(R.id.top_line);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setDefaultResource(17170445);
        this.n.setPlaceHolder(1);
        this.n.setRadius(this.u);
        this.q.setDrawBorder(true);
        this.q.setBorderWidth(1);
        this.q.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(d.b.i0.x.e0.o oVar) {
        if (oVar == null) {
            this.m.setVisibility(8);
            return;
        }
        if (this.m.getVisibility() != 0) {
            this.m.setVisibility(0);
        }
        this.t = oVar;
        this.n.W(oVar.f62227g, 10, false);
        this.o.setText(UtilHelper.getFixedText(oVar.f62226f, 7, true));
        if (StringUtils.isNull(oVar.m)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
            this.r.setText(oVar.m);
        }
        this.p.setText(oVar.i);
        if (d.b.h0.r.k.c().g()) {
            this.q.setVisibility(0);
            this.q.W(oVar.j, 10, false);
            return;
        }
        this.q.setVisibility(8);
    }

    public void w(String str, String str2, String str3) {
        this.v = str2;
        this.w = str3;
    }
}
