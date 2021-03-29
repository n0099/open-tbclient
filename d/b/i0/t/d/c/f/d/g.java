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
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60398a;

    /* renamed from: b  reason: collision with root package name */
    public View f60399b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f60400c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60401d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60402e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60403f;

    /* renamed from: g  reason: collision with root package name */
    public i f60404g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.a.c f60405h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f60405h == null || g.this.f60405h.f60242h == null || view != g.this.f60399b || g.this.f60404g == null) {
                    return;
                }
                g.this.f60404g.a(g.this.f60405h);
                return;
            }
            l.I(g.this.f60398a.getPageActivity(), g.this.f60398a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f60398a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f60399b = inflate;
        this.f60403f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f60400c = (HeadImageView) this.f60399b.findViewById(R.id.iv_anchor_avatar);
        this.f60401d = (TextView) this.f60399b.findViewById(R.id.tv_anchor_name);
        this.f60402e = (TextView) this.f60399b.findViewById(R.id.tv_live_aud_num);
        this.f60399b.setOnClickListener(this.i);
        this.f60400c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f60400c.setIsRound(true);
        this.f60400c.setPlaceHolder(1);
        this.f60400c.setAutoChangeStyle(true);
        this.f60400c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60403f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f60398a.getPageActivity()) - (this.f60398a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f60398a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f60399b;
    }

    public void f(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60242h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f60405h = cVar;
            boolean z = cVar.j;
            cVar.f60242h.T().getUserId();
            this.f60400c.X(cVar.f60242h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f60242h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f60401d.setText(name_show);
            }
            if (cVar.f60242h.q1() != null) {
                this.f60402e.setText(String.format(this.f60398a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f60242h.q1().audience_count)));
            }
            g(this.f60398a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.f60401d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60402e, R.color.CAM_X0109);
        if (i == 1) {
            this.f60400c.setBorderColor(this.f60398a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f60400c.setBorderColor(this.f60398a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f60398a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f60398a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f60398a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f60402e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f60402e.setCompoundDrawablePadding(this.f60398a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f60404g = iVar;
    }
}
