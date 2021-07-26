package d.a.q0.u0.q1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f64305a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f64306b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64307c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64308d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f64309e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f64310f;

    /* renamed from: g  reason: collision with root package name */
    public View f64311g;

    /* renamed from: h  reason: collision with root package name */
    public int f64312h;

    /* renamed from: i  reason: collision with root package name */
    public int f64313i;

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
        this.f64313i = 3;
        this.f64305a = view;
        this.f64306b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f64307c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f64308d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f64309e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f64310f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f64311g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
