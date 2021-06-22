package d.a.o0.r0.m2;

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
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public View f62763a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f62764b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f62765c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f62766d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62767e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f62768f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f62769g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f62770h;

    /* renamed from: i  reason: collision with root package name */
    public View f62771i;
    public TbImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f62772e;

        public a(g gVar, Context context) {
            this.f62772e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = this.f62772e;
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
        this.f62763a = inflate;
        this.f62764b = (RelativeLayout) inflate.findViewById(R.id.head_top_bg_container);
        this.f62765c = (LinearGradientView) this.f62763a.findViewById(R.id.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f62763a.findViewById(R.id.head_top_bg_mask);
        this.j = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.j.setDefaultResource(R.drawable.pic_frs_head_default);
        this.f62766d = (BarImageView) this.f62763a.findViewById(R.id.frs_image);
        TextView textView = (TextView) this.f62763a.findViewById(R.id.forum_name);
        this.f62767e = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        this.f62768f = (FrsHeaderBannerView) this.f62763a.findViewById(R.id.frs_header_banner);
        this.f62769g = (LinearLayout) this.f62763a.findViewById(R.id.fake_content_layout);
        this.f62770h = (ImageView) this.f62763a.findViewById(R.id.fake_content_img);
        this.f62771i = this.f62763a.findViewById(R.id.header_round_corner_layout);
        this.k = (ImageView) this.f62763a.findViewById(R.id.fake_return_icon);
        this.l = (ImageView) this.f62763a.findViewById(R.id.fake_share_icon);
        this.m = (ImageView) this.f62763a.findViewById(R.id.fake_information_icon);
        this.n = (ImageView) this.f62763a.findViewById(R.id.fake_search_icon);
        this.k.setOnClickListener(new a(this, context));
        this.f62766d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62766d.setContentDescription(context.getResources().getString(R.string.bar_header));
        this.f62766d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f62766d.setShowOval(true);
        this.f62766d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.f62766d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f62763a, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f62771i, R.drawable.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f62770h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62770h, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
