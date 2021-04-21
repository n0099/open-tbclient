package d.b.j0.t.d.c.f.d;

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
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f62383a;

    /* renamed from: b  reason: collision with root package name */
    public View f62384b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f62385c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62386d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62387e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f62388f;

    /* renamed from: g  reason: collision with root package name */
    public i f62389g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.t.d.a.c f62390h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f62390h == null || g.this.f62390h.f62227h == null || view != g.this.f62384b || g.this.f62389g == null) {
                    return;
                }
                g.this.f62389g.a(g.this.f62390h);
                return;
            }
            l.I(g.this.f62383a.getPageActivity(), g.this.f62383a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f62383a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f62384b = inflate;
        this.f62388f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f62385c = (HeadImageView) this.f62384b.findViewById(R.id.iv_anchor_avatar);
        this.f62386d = (TextView) this.f62384b.findViewById(R.id.tv_anchor_name);
        this.f62387e = (TextView) this.f62384b.findViewById(R.id.tv_live_aud_num);
        this.f62384b.setOnClickListener(this.i);
        this.f62385c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f62385c.setIsRound(true);
        this.f62385c.setPlaceHolder(1);
        this.f62385c.setAutoChangeStyle(true);
        this.f62385c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62388f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f62383a.getPageActivity()) - (this.f62383a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f62383a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f62384b;
    }

    public void f(d.b.j0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f62227h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f62390h = cVar;
            boolean z = cVar.j;
            cVar.f62227h.T().getUserId();
            this.f62385c.X(cVar.f62227h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f62227h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f62386d.setText(name_show);
            }
            if (cVar.f62227h.q1() != null) {
                this.f62387e.setText(String.format(this.f62383a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f62227h.q1().audience_count)));
            }
            g(this.f62383a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.f62386d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62387e, R.color.CAM_X0109);
        if (i == 1) {
            this.f62385c.setBorderColor(this.f62383a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f62385c.setBorderColor(this.f62383a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f62383a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f62383a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f62383a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f62387e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f62387e.setCompoundDrawablePadding(this.f62383a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f62389g = iVar;
    }
}
