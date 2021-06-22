package d.a.n0.l.f;

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
    public final Context f53270a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53271b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f53272c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f53273d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53274e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53275f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53276g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53277h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53278i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f53270a = context;
        this.f53271b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f53272c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f53271b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f53272c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f53272c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f53273d.U(this.f53272c.getVideo_info().getThumbnail_url(), 10, false);
        this.f53278i.setText(StringHelper.numFormatOverWanWithNegative(this.f53272c.getAgree_num()));
        this.f53275f.setText(StringHelper.numFormatOverWanWithNegative(this.f53272c.getPost_num()));
    }

    public final void c() {
        this.f53275f = (TextView) this.f53271b.findViewById(R.id.comment_num);
        this.f53276g = (TextView) this.f53271b.findViewById(R.id.comment_desc);
        this.f53277h = (TextView) this.f53271b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f53271b.findViewById(R.id.praise_num);
        this.f53278i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f53275f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f53277h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f53276g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f53271b.findViewById(R.id.video_img);
        this.f53273d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f53273d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f53273d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f53271b.findViewById(R.id.play_icon);
        this.f53274e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
