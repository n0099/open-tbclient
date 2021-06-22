package d.a.o0.v.d.c.f.d;

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
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f65414a;

    /* renamed from: b  reason: collision with root package name */
    public View f65415b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f65416c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f65417d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65418e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f65419f;

    /* renamed from: g  reason: collision with root package name */
    public i f65420g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.v.d.a.c f65421h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f65422i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (g.this.f65421h == null || g.this.f65421h.f65255h == null || view != g.this.f65415b || g.this.f65420g == null) {
                    return;
                }
                g.this.f65420g.a(g.this.f65421h);
                return;
            }
            l.J(g.this.f65414a.getPageActivity(), g.this.f65414a.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        this.f65414a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f65415b = inflate;
        this.f65419f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f65416c = (HeadImageView) this.f65415b.findViewById(R.id.iv_anchor_avatar);
        this.f65417d = (TextView) this.f65415b.findViewById(R.id.tv_anchor_name);
        this.f65418e = (TextView) this.f65415b.findViewById(R.id.tv_live_aud_num);
        this.f65415b.setOnClickListener(this.f65422i);
        this.f65416c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f65416c.setIsRound(true);
        this.f65416c.setPlaceHolder(1);
        this.f65416c.setAutoChangeStyle(true);
        this.f65416c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f65419f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f65414a.getPageActivity()) - (this.f65414a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f65414a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        return this.f65415b;
    }

    public void f(d.a.o0.v.d.a.c cVar) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f65255h) != null && a2Var.T() != null) {
            e().setVisibility(0);
            this.f65421h = cVar;
            boolean z = cVar.j;
            cVar.f65255h.T().getUserId();
            this.f65416c.V(cVar.f65255h.T().getPortrait(), 25, false, false);
            String name_show = cVar.f65255h.T().getName_show();
            if (!StringUtils.isNull(name_show)) {
                if (k.byteLength(name_show) > 16) {
                    name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                }
                this.f65417d.setText(name_show);
            }
            if (cVar.f65255h.s1() != null) {
                this.f65418e.setText(String.format(this.f65414a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f65255h.s1().audience_count)));
            }
            g(this.f65414a, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        e().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.f65417d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f65418e, R.color.CAM_X0109);
        if (i2 == 1) {
            this.f65416c.setBorderColor(this.f65414a.getResources().getColor(R.color.CAM_X0903_1));
        } else {
            this.f65416c.setBorderColor(this.f65414a.getResources().getColor(R.color.CAM_X0903));
        }
        Drawable drawable = SkinManager.getDrawable(this.f65414a.getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, this.f65414a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f65414a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.f65418e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f65418e.setCompoundDrawablePadding(this.f65414a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public void h(i iVar) {
        this.f65420g = iVar;
    }
}
