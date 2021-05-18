package d.a.k0.q0.r1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f59374a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f59375b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59376c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59377d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59378e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f59379f;

    /* renamed from: g  reason: collision with root package name */
    public View f59380g;

    /* renamed from: h  reason: collision with root package name */
    public int f59381h;

    /* renamed from: i  reason: collision with root package name */
    public int f59382i = 3;

    public b(View view) {
        this.f59374a = view;
        this.f59375b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f59376c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f59377d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f59378e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f59379f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f59380g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
