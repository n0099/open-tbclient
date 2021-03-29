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
    public final Context f50287a;

    /* renamed from: b  reason: collision with root package name */
    public final View f50288b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f50289c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f50290d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f50291e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50292f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50293g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50294h;
    public TextView i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f50287a = context;
        this.f50288b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f50289c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f50288b;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean = this.f50289c;
        if (paramBean == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f50289c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f50290d.W(this.f50289c.getVideo_info().getThumbnail_url(), 10, false);
        this.i.setText(StringHelper.numFormatOverWanWithNegative(this.f50289c.getAgree_num()));
        this.f50292f.setText(StringHelper.numFormatOverWanWithNegative(this.f50289c.getPost_num()));
    }

    public final void c() {
        this.f50292f = (TextView) this.f50288b.findViewById(R.id.comment_num);
        this.f50293g = (TextView) this.f50288b.findViewById(R.id.comment_desc);
        this.f50294h = (TextView) this.f50288b.findViewById(R.id.praise_desc);
        TextView textView = (TextView) this.f50288b.findViewById(R.id.praise_num);
        this.i = textView;
        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f50292f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f50294h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f50293g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        TbImageView tbImageView = (TbImageView) this.f50288b.findViewById(R.id.video_img);
        this.f50290d = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f50290d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f50290d.setPlaceHolder(2);
        ImageView imageView = (ImageView) this.f50288b.findViewById(R.id.play_icon);
        this.f50291e = imageView;
        imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
    }
}
