package d.a.n0.r0.r1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f59515a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f59516b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59517c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59518d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59519e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f59520f;

    /* renamed from: g  reason: collision with root package name */
    public View f59521g;

    /* renamed from: h  reason: collision with root package name */
    public int f59522h;

    /* renamed from: i  reason: collision with root package name */
    public int f59523i = 3;

    public b(View view) {
        this.f59515a = view;
        this.f59516b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f59517c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f59518d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f59519e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f59520f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f59521g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
