package d.a.n0.r0.r1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f63206a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f63207b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63208c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63209d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63210e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f63211f;

    /* renamed from: g  reason: collision with root package name */
    public View f63212g;

    /* renamed from: h  reason: collision with root package name */
    public int f63213h;

    /* renamed from: i  reason: collision with root package name */
    public int f63214i = 3;

    public b(View view) {
        this.f63206a = view;
        this.f63207b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f63208c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f63209d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f63210e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f63211f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f63212g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
