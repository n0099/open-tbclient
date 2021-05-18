package d.a.k0.t.d.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61288a;

    /* renamed from: b  reason: collision with root package name */
    public View f61289b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f61290c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61291d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61292e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f61293f;

    /* renamed from: g  reason: collision with root package name */
    public i f61294g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.t.d.a.c f61295h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f61296i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f61295h == null || g.this.f61295h.f61129h == null || view != g.this.f61289b || g.this.f61294g == null) {
                    return;
                }
                g.this.f61294g.a(g.this.f61295h);
                return;
            }
            l.J(g.this.f61288a.getPageActivity(), g.this.f61288a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f61288a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f61289b = inflate;
        this.f61293f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f61290c = (HeadImageView) this.f61289b.findViewById(R.id.iv_anchor_avatar);
        this.f61291d = (TextView) this.f61289b.findViewById(R.id.tv_anchor_name);
        this.f61292e = (TextView) this.f61289b.findViewById(R.id.tv_live_aud_num);
        this.f61289b.setOnClickListener(this.f61296i);
        this.f61290c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f61290c.setIsRound(true);
        this.f61290c.setPlaceHolder(1);
        this.f61290c.setAutoChangeStyle(true);
        this.f61290c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f61293f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f61288a.getPageActivity()) - (this.f61288a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f61288a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f61289b;
    }

    public void f(d.a.k0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61129h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f61295h = cVar;
            boolean z = cVar.j;
            cVar.f61129h.T().getUserId();
            this.f61290c.W(cVar.f61129h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f61129h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f61291d.setText(name_show);
            }
            if (cVar.f61129h.q1() != null) {
                this.f61292e.setText(String.format(this.f61288a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f61129h.q1().audience_count)));
            }
            g(this.f61288a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.f61291d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61292e, R.color.CAM_X0109);
        if (i2 == 1) {
            this.f61290c.setBorderColor(this.f61288a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f61290c.setBorderColor(this.f61288a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f61288a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f61288a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f61288a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f61292e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f61292e.setCompoundDrawablePadding(this.f61288a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f61294g = iVar;
    }
}
