package d.b.i0.l.f;

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
    public final Context f51030a;

    /* renamed from: b  reason: collision with root package name */
    public final View f51031b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f51032c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f51033d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f51034e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51035f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51036g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51037h;
    public TextView i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f51030a = context;
        this.f51031b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f51032c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f51031b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f51032c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f51032c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f51033d.W(this.f51032c.getVideo_info().getThumbnail_url(), 10, false);
        this.i.setText(StringHelper.numFormatOverWanWithNegative(this.f51032c.getAgree_num()));
        this.f51035f.setText(StringHelper.numFormatOverWanWithNegative(this.f51032c.getPost_num()));
    }

    public final void c() {
        this.f51035f = (TextView) this.f51031b.findViewById(R.id.comment_num);
        this.f51036g = (TextView) this.f51031b.findViewById(R.id.comment_desc);
        this.f51037h = (TextView) this.f51031b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f51031b.findViewById(R.id.praise_num);
        this.i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f51035f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f51037h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f51036g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f51031b.findViewById(R.id.video_img);
        this.f51033d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f51033d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f51033d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f51031b.findViewById(R.id.play_icon);
        this.f51034e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
