package d.a.j0.l.f;

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
    public final Context f49445a;

    /* renamed from: b  reason: collision with root package name */
    public final View f49446b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f49447c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f49448d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f49449e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49450f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49451g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49452h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49453i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f49445a = context;
        this.f49446b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f49447c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f49446b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f49447c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f49447c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f49448d.V(this.f49447c.getVideo_info().getThumbnail_url(), 10, false);
        this.f49453i.setText(StringHelper.numFormatOverWanWithNegative(this.f49447c.getAgree_num()));
        this.f49450f.setText(StringHelper.numFormatOverWanWithNegative(this.f49447c.getPost_num()));
    }

    public final void c() {
        this.f49450f = (TextView) this.f49446b.findViewById(R.id.comment_num);
        this.f49451g = (TextView) this.f49446b.findViewById(R.id.comment_desc);
        this.f49452h = (TextView) this.f49446b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f49446b.findViewById(R.id.praise_num);
        this.f49453i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f49450f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f49452h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f49451g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f49446b.findViewById(R.id.video_img);
        this.f49448d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f49448d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f49448d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f49446b.findViewById(R.id.play_icon);
        this.f49449e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
