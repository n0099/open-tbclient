package d.a.q0.a.g2;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f47881a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47881a = null;
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        if (this.f47881a == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            this.f47881a = frameLayout;
            frameLayout.setBackgroundResource(c.aiapps_night_mode_cover_layer);
        }
        viewGroup.removeView(this.f47881a);
        viewGroup.addView(this.f47881a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void b(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || viewGroup == null || (frameLayout = this.f47881a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f47881a = null;
    }

    public void c(int i2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (frameLayout = this.f47881a) == null) {
            return;
        }
        frameLayout.setVisibility(i2);
    }
}
