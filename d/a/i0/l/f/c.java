package d.a.i0.l.f;

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
    public final Context f48616a;

    /* renamed from: b  reason: collision with root package name */
    public final View f48617b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f48618c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f48619d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f48620e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f48621f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48622g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48623h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48624i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f48616a = context;
        this.f48617b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f48618c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f48617b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f48618c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f48618c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f48619d.V(this.f48618c.getVideo_info().getThumbnail_url(), 10, false);
        this.f48624i.setText(StringHelper.numFormatOverWanWithNegative(this.f48618c.getAgree_num()));
        this.f48621f.setText(StringHelper.numFormatOverWanWithNegative(this.f48618c.getPost_num()));
    }

    public final void c() {
        this.f48621f = (TextView) this.f48617b.findViewById(R.id.comment_num);
        this.f48622g = (TextView) this.f48617b.findViewById(R.id.comment_desc);
        this.f48623h = (TextView) this.f48617b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f48617b.findViewById(R.id.praise_num);
        this.f48624i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f48621f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f48623h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f48622g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f48617b.findViewById(R.id.video_img);
        this.f48619d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f48619d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f48619d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f48617b.findViewById(R.id.play_icon);
        this.f48620e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
