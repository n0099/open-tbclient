package d.a.o0.a.w2.h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.f;
import d.a.o0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class a implements h.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f48853a;

    /* renamed from: d.a.o0.a.w2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0978a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f48854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f48855f;

        public RunnableC0978a(a aVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48855f = aVar;
            this.f48854e = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48855f.f48853a == null) {
                    this.f48855f.f48853a = new FrameLayout(this.f48854e.getContext());
                    this.f48855f.f48853a.setBackgroundResource(d.a.o0.a.c.aiapps_night_mode_cover_layer);
                }
                this.f48854e.removeView(this.f48855f.f48853a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.f48854e.addView(this.f48855f.f48853a, layoutParams);
            }
        }
    }

    public a() {
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
        this.f48853a = null;
    }

    @Override // d.a.o0.a.z1.b.b.h.c
    public void a(h hVar, h.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, hVar, bVar) == null) || hVar == null || bVar == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        f(hVar);
        ViewGroup viewGroup = (ViewGroup) hVar.findViewById(16908290);
        if (viewGroup != null) {
            if (d.a.o0.a.c1.a.H().a()) {
                d(viewGroup, bVar.r);
            } else {
                e(viewGroup);
            }
        }
    }

    public final void d(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, view) == null) || viewGroup == null || view == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        view.post(new RunnableC0978a(this, viewGroup));
    }

    public final void e(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) || viewGroup == null || (frameLayout = this.f48853a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f48853a = null;
    }

    public final void f(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            Context context = hVar.getContext();
            if (hVar.getContext() instanceof ContextWrapper) {
                context = ((ContextWrapper) hVar.getContext()).getBaseContext();
            }
            if (context instanceof Activity) {
                f.b((Activity) context, hVar);
            }
        }
    }
}
