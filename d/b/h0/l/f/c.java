package d.b.h0.l.f;

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
    public final Context f50286a;

    /* renamed from: b  reason: collision with root package name */
    public final View f50287b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f50288c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f50289d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f50290e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50291f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50292g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50293h;
    public TextView i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f50286a = context;
        this.f50287b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f50288c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f50287b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f50288c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f50288c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f50289d.W(this.f50288c.getVideo_info().getThumbnail_url(), 10, false);
        this.i.setText(StringHelper.numFormatOverWanWithNegative(this.f50288c.getAgree_num()));
        this.f50291f.setText(StringHelper.numFormatOverWanWithNegative(this.f50288c.getPost_num()));
    }

    public final void c() {
        this.f50291f = (TextView) this.f50287b.findViewById(R.id.comment_num);
        this.f50292g = (TextView) this.f50287b.findViewById(R.id.comment_desc);
        this.f50293h = (TextView) this.f50287b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f50287b.findViewById(R.id.praise_num);
        this.i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f50291f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f50293h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f50292g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f50287b.findViewById(R.id.video_img);
        this.f50289d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f50289d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f50289d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f50287b.findViewById(R.id.play_icon);
        this.f50290e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
