package d.a.o0.a.w2.h;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements d.a.o0.k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f48856a;

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
        this.f48856a = null;
    }

    @Override // d.a.o0.k.a
    public void a(BaseMenuView baseMenuView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, baseMenuView) == null) || baseMenuView == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        if (d.a.o0.a.c1.a.H().a()) {
            b(baseMenuView);
        } else {
            c(baseMenuView);
        }
    }

    public final void b(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) && viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.f48856a == null) {
                FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
                this.f48856a = frameLayout;
                frameLayout.setBackgroundResource(d.a.o0.a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.f48856a);
            viewGroup.addView(this.f48856a, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void c(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) || viewGroup == null || (frameLayout = this.f48856a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f48856a = null;
    }
}
