package d.b.j0.q0.m2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public View f59986a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f59987b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f59988c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f59989d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59990e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f59991f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f59992g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59993h;
    public View i;
    public TbImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f59994e;

        public a(g gVar, Context context) {
            this.f59994e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = this.f59994e;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
    }

    public g(Context context) {
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
        this.f59986a = inflate;
        this.f59987b = (RelativeLayout) inflate.findViewById(R.id.head_top_bg_container);
        this.f59988c = (LinearGradientView) this.f59986a.findViewById(R.id.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f59986a.findViewById(R.id.head_top_bg_mask);
        this.j = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.j.setDefaultResource(R.drawable.pic_frs_head_default);
        this.f59989d = (BarImageView) this.f59986a.findViewById(R.id.frs_image);
        TextView textView = (TextView) this.f59986a.findViewById(R.id.forum_name);
        this.f59990e = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        this.f59991f = (FrsHeaderBannerView) this.f59986a.findViewById(R.id.frs_header_banner);
        this.f59992g = (LinearLayout) this.f59986a.findViewById(R.id.fake_content_layout);
        this.f59993h = (ImageView) this.f59986a.findViewById(R.id.fake_content_img);
        this.i = this.f59986a.findViewById(R.id.header_round_corner_layout);
        this.k = (ImageView) this.f59986a.findViewById(R.id.fake_return_icon);
        this.l = (ImageView) this.f59986a.findViewById(R.id.fake_share_icon);
        this.m = (ImageView) this.f59986a.findViewById(R.id.fake_information_icon);
        this.n = (ImageView) this.f59986a.findViewById(R.id.fake_search_icon);
        this.k.setOnClickListener(new a(this, context));
        this.f59989d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f59989d.setContentDescription(context.getResources().getString(R.string.bar_header));
        this.f59989d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f59989d.setShowOval(true);
        this.f59989d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.f59989d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f59986a, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.i, R.drawable.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f59993h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59993h, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
