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
    public TbPageContext<?> f60397a;

    /* renamed from: b  reason: collision with root package name */
    public View f60398b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f60399c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60400d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60401e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60402f;

    /* renamed from: g  reason: collision with root package name */
    public i f60403g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.a.c f60404h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f60404h == null || g.this.f60404h.f60241h == null || view != g.this.f60398b || g.this.f60403g == null) {
                    return;
                }
                g.this.f60403g.a(g.this.f60404h);
                return;
            }
            l.I(g.this.f60397a.getPageActivity(), g.this.f60397a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f60397a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f60398b = inflate;
        this.f60402f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f60399c = (HeadImageView) this.f60398b.findViewById(R.id.iv_anchor_avatar);
        this.f60400d = (TextView) this.f60398b.findViewById(R.id.tv_anchor_name);
        this.f60401e = (TextView) this.f60398b.findViewById(R.id.tv_live_aud_num);
        this.f60398b.setOnClickListener(this.i);
        this.f60399c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f60399c.setIsRound(true);
        this.f60399c.setPlaceHolder(1);
        this.f60399c.setAutoChangeStyle(true);
        this.f60399c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60402f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f60397a.getPageActivity()) - (this.f60397a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f60397a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f60398b;
    }

    public void f(d.b.i0.t.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60241h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f60404h = cVar;
            boolean z = cVar.j;
            cVar.f60241h.T().getUserId();
            this.f60399c.X(cVar.f60241h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f60241h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f60400d.setText(name_show);
            }
            if (cVar.f60241h.q1() != null) {
                this.f60401e.setText(String.format(this.f60397a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f60241h.q1().audience_count)));
            }
            g(this.f60397a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.f60400d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60401e, R.color.CAM_X0109);
        if (i == 1) {
            this.f60399c.setBorderColor(this.f60397a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f60399c.setBorderColor(this.f60397a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f60397a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f60397a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f60397a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f60401e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f60401e.setCompoundDrawablePadding(this.f60397a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f60403g = iVar;
    }
}
