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
    public final Context f53163a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53164b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f53165c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f53166d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53167e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53168f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53169g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53170h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53171i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f53163a = context;
        this.f53164b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f53165c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f53164b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f53165c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f53165c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f53166d.U(this.f53165c.getVideo_info().getThumbnail_url(), 10, false);
        this.f53171i.setText(StringHelper.numFormatOverWanWithNegative(this.f53165c.getAgree_num()));
        this.f53168f.setText(StringHelper.numFormatOverWanWithNegative(this.f53165c.getPost_num()));
    }

    public final void c() {
        this.f53168f = (TextView) this.f53164b.findViewById(R.id.comment_num);
        this.f53169g = (TextView) this.f53164b.findViewById(R.id.comment_desc);
        this.f53170h = (TextView) this.f53164b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f53164b.findViewById(R.id.praise_num);
        this.f53171i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f53168f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f53170h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f53169g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f53164b.findViewById(R.id.video_img);
        this.f53166d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f53166d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f53166d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f53164b.findViewById(R.id.play_icon);
        this.f53167e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
