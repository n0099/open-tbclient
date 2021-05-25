package d.a.m0.l.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f49489a;

    /* renamed from: b  reason: collision with root package name */
    public final View f49490b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f49491c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f49492d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f49493e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49494f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49495g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49496h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49497i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f49489a = context;
        this.f49490b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f49491c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f49490b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f49491c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f49491c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f49492d.V(this.f49491c.getVideo_info().getThumbnail_url(), 10, false);
        this.f49497i.setText(StringHelper.numFormatOverWanWithNegative(this.f49491c.getAgree_num()));
        this.f49494f.setText(StringHelper.numFormatOverWanWithNegative(this.f49491c.getPost_num()));
    }

    public final void c() {
        this.f49494f = (TextView) this.f49490b.findViewById(R.id.comment_num);
        this.f49495g = (TextView) this.f49490b.findViewById(R.id.comment_desc);
        this.f49496h = (TextView) this.f49490b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f49490b.findViewById(R.id.praise_num);
        this.f49497i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f49494f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f49496h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f49495g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f49490b.findViewById(R.id.video_img);
        this.f49492d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f49492d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f49492d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f49490b.findViewById(R.id.play_icon);
        this.f49493e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
