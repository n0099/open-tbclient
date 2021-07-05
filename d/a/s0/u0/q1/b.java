package d.a.s0.u0.q1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66877a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f66878b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66879c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66880d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66881e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f66882f;

    /* renamed from: g  reason: collision with root package name */
    public View f66883g;

    /* renamed from: h  reason: collision with root package name */
    public int f66884h;

    /* renamed from: i  reason: collision with root package name */
    public int f66885i;

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66885i = 3;
        this.f66877a = view;
        this.f66878b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f66879c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f66880d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f66881e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f66882f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f66883g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
