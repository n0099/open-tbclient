package d.b.i0.t.d.c.f.d;

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
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f61962a;

    /* renamed from: b  reason: collision with root package name */
    public View f61963b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f61964c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61965d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61966e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f61967f;

    /* renamed from: g  reason: collision with root package name */
    public i f61968g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.a.c f61969h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f61969h == null || g.this.f61969h.f61806h == null || view != g.this.f61963b || g.this.f61968g == null) {
                    return;
                }
                g.this.f61968g.a(g.this.f61969h);
                return;
            }
            l.I(g.this.f61962a.getPageActivity(), g.this.f61962a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f61962a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f61963b = inflate;
        this.f61967f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f61964c = (HeadImageView) this.f61963b.findViewById(R.id.iv_anchor_avatar);
        this.f61965d = (TextView) this.f61963b.findViewById(R.id.tv_anchor_name);
        this.f61966e = (TextView) this.f61963b.findViewById(R.id.tv_live_aud_num);
        this.f61963b.setOnClickListener(this.i);
        this.f61964c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f61964c.setIsRound(true);
        this.f61964c.setPlaceHolder(1);
        this.f61964c.setAutoChangeStyle(true);
        this.f61964c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f61967f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f61962a.getPageActivity()) - (this.f61962a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f61962a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f61963b;
    }

    public void f(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61806h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f61969h = cVar;
            boolean z = cVar.j;
            cVar.f61806h.T().getUserId();
            this.f61964c.X(cVar.f61806h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f61806h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f61965d.setText(name_show);
            }
            if (cVar.f61806h.q1() != null) {
                this.f61966e.setText(String.format(this.f61962a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f61806h.q1().audience_count)));
            }
            g(this.f61962a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.f61965d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61966e, R.color.CAM_X0109);
        if (i == 1) {
            this.f61964c.setBorderColor(this.f61962a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f61964c.setBorderColor(this.f61962a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f61962a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f61962a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f61962a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f61966e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f61966e.setCompoundDrawablePadding(this.f61962a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f61968g = iVar;
    }
}
