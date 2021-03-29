package d.b.i0.p0.r1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f58505a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f58506b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58507c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58508d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58509e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f58510f;

    /* renamed from: g  reason: collision with root package name */
    public View f58511g;

    /* renamed from: h  reason: collision with root package name */
    public int f58512h;
    public int i = 3;

    public b(View view) {
        this.f58505a = view;
        this.f58506b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f58507c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f58508d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f58509e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f58510f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f58511g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
