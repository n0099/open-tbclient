package d.a.n0.v.d.c.f.d;

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
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61576a;

    /* renamed from: b  reason: collision with root package name */
    public View f61577b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f61578c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61579d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61580e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f61581f;

    /* renamed from: g  reason: collision with root package name */
    public i f61582g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.v.d.a.c f61583h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f61584i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f61583h == null || g.this.f61583h.f61417h == null || view != g.this.f61577b || g.this.f61582g == null) {
                    return;
                }
                g.this.f61582g.a(g.this.f61583h);
                return;
            }
            l.J(g.this.f61576a.getPageActivity(), g.this.f61576a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f61576a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f61577b = inflate;
        this.f61581f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f61578c = (HeadImageView) this.f61577b.findViewById(R.id.iv_anchor_avatar);
        this.f61579d = (TextView) this.f61577b.findViewById(R.id.tv_anchor_name);
        this.f61580e = (TextView) this.f61577b.findViewById(R.id.tv_live_aud_num);
        this.f61577b.setOnClickListener(this.f61584i);
        this.f61578c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f61578c.setIsRound(true);
        this.f61578c.setPlaceHolder(1);
        this.f61578c.setAutoChangeStyle(true);
        this.f61578c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f61581f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f61576a.getPageActivity()) - (this.f61576a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f61576a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f61577b;
    }

    public void f(d.a.n0.v.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61417h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f61583h = cVar;
            boolean z = cVar.j;
            cVar.f61417h.T().getUserId();
            this.f61578c.W(cVar.f61417h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f61417h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f61579d.setText(name_show);
            }
            if (cVar.f61417h.r1() != null) {
                this.f61580e.setText(String.format(this.f61576a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f61417h.r1().audience_count)));
            }
            g(this.f61576a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.f61579d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61580e, R.color.CAM_X0109);
        if (i2 == 1) {
            this.f61578c.setBorderColor(this.f61576a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f61578c.setBorderColor(this.f61576a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f61576a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f61576a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f61576a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f61580e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f61580e.setCompoundDrawablePadding(this.f61576a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f61582g = iVar;
    }
}
