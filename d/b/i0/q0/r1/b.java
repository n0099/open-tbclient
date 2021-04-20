package d.b.i0.q0.r1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f60111a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f60112b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60113c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60114d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60115e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f60116f;

    /* renamed from: g  reason: collision with root package name */
    public View f60117g;

    /* renamed from: h  reason: collision with root package name */
    public int f60118h;
    public int i = 3;

    public b(View view) {
        this.f60111a = view;
        this.f60112b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f60113c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f60114d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f60115e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f60116f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f60117g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
