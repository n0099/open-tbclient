package d.a.o0.r0.r1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f63331a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f63332b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63333c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63334d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63335e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f63336f;

    /* renamed from: g  reason: collision with root package name */
    public View f63337g;

    /* renamed from: h  reason: collision with root package name */
    public int f63338h;

    /* renamed from: i  reason: collision with root package name */
    public int f63339i = 3;

    public b(View view) {
        this.f63331a = view;
        this.f63332b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f63333c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f63334d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f63335e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f63336f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f63337g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
