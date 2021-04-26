package d.a.j0.t.d.c.f.d;

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
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60564a;

    /* renamed from: b  reason: collision with root package name */
    public View f60565b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f60566c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60567d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60568e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60569f;

    /* renamed from: g  reason: collision with root package name */
    public i f60570g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.t.d.a.c f60571h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f60572i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f60571h == null || g.this.f60571h.f60405h == null || view != g.this.f60565b || g.this.f60570g == null) {
                    return;
                }
                g.this.f60570g.a(g.this.f60571h);
                return;
            }
            l.J(g.this.f60564a.getPageActivity(), g.this.f60564a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f60564a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f60565b = inflate;
        this.f60569f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f60566c = (HeadImageView) this.f60565b.findViewById(R.id.iv_anchor_avatar);
        this.f60567d = (TextView) this.f60565b.findViewById(R.id.tv_anchor_name);
        this.f60568e = (TextView) this.f60565b.findViewById(R.id.tv_live_aud_num);
        this.f60565b.setOnClickListener(this.f60572i);
        this.f60566c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f60566c.setIsRound(true);
        this.f60566c.setPlaceHolder(1);
        this.f60566c.setAutoChangeStyle(true);
        this.f60566c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60569f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f60564a.getPageActivity()) - (this.f60564a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f60564a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f60565b;
    }

    public void f(d.a.j0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60405h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f60571h = cVar;
            boolean z = cVar.j;
            cVar.f60405h.T().getUserId();
            this.f60566c.W(cVar.f60405h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f60405h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f60567d.setText(name_show);
            }
            if (cVar.f60405h.q1() != null) {
                this.f60568e.setText(String.format(this.f60564a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f60405h.q1().audience_count)));
            }
            g(this.f60564a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.f60567d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60568e, R.color.CAM_X0109);
        if (i2 == 1) {
            this.f60566c.setBorderColor(this.f60564a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f60566c.setBorderColor(this.f60564a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f60564a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f60564a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f60564a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f60568e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f60568e.setCompoundDrawablePadding(this.f60564a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f60570g = iVar;
    }
}
