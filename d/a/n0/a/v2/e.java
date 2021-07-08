package d.a.n0.a.v2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.f1.e.b;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class e implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f48022i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SlideHelper f48023e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<SwanAppActivity> f48024f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.a.g2.b f48025g;

    /* renamed from: h  reason: collision with root package name */
    public BroadcastReceiver f48026h;

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (("homekey".equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && this.this$0.f48023e != null) {
                    this.this$0.f48023e.closePane();
                    this.this$0.f48023e.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48027a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48028b;

        public b(e eVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48028b = eVar;
            this.f48027a = swanAppActivity;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f48027a.onBackPressed(3);
                this.f48028b.h();
                this.f48027a.overridePendingTransition(0, 0);
                d.a.n0.a.m1.g.f().i();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) || (maskView = this.f48028b.f48023e.getMaskView()) == null) {
                return;
            }
            maskView.setAlpha(1.0f - f2);
            if (this.f48027a.hasActivedFrame()) {
                this.f48027a.getFrame().i0();
            }
            if (f2 == 0.0f) {
                maskView.setBackgroundColor(Color.parseColor(SlideHelper.DEFAULT_MASK_COLOR));
            }
            if (f2 == 1.0f) {
                maskView.setBackgroundColor(0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(719464371, "Ld/a/n0/a/v2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(719464371, "Ld/a/n0/a/v2/e;");
                return;
            }
        }
        f48022i = d.a.n0.a.k.f45831a;
    }

    public e(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48026h = new a(this);
        this.f48024f = new WeakReference<>(swanAppActivity);
        this.f48023e = new SlideHelper();
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SwanAppActivity swanAppActivity = this.f48024f.get();
            return (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f48023e.closePane();
        }
    }

    public void f() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (swanAppActivity = this.f48024f.get()) == null || swanAppActivity.isDestroyed()) {
            return;
        }
        this.f48023e.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
        this.f48023e.attachActivity(swanAppActivity);
        this.f48023e.setEnableReleaseWhenNoTranslucent(false);
        this.f48023e.setFadeColor(0);
        this.f48023e.setSlideInterceptor(this);
        this.f48023e.setSlideListener(new b(this, swanAppActivity));
        d.a.n0.a.p.e.b g2 = g();
        if (g2 != null) {
            this.f48023e.setRegionFactor(g2.F());
        }
    }

    public final d.a.n0.a.p.e.b g() {
        InterceptResult invokeV;
        d.a.n0.a.h0.g.g swanAppFragmentManager;
        d.a.n0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppActivity swanAppActivity = this.f48024f.get();
            if (swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || !(m instanceof d.a.n0.a.h0.g.f)) {
                return null;
            }
            return ((d.a.n0.a.h0.g.f) m).b3();
        }
        return (d.a.n0.a.p.e.b) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && d.a.n0.a.c1.a.H().a()) {
            this.f48025g.c(8);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.n0.a.p.e.c] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        d.a.n0.a.h0.g.g swanAppFragmentManager;
        d.a.n0.a.p.e.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            SwanAppActivity swanAppActivity = this.f48024f.get();
            if (swanAppActivity == null || !swanAppActivity.hasActivedFrame() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (g2 = g()) == null) {
                return false;
            }
            d.a.n0.a.p.e.e m = g2.m();
            return swanAppFragmentManager.k() <= 1 && g2.isSlidable(motionEvent) && !(m != null && m.u() != 0 && m.u().canGoBack()) && j();
        }
        return invokeL.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppActivity swanAppActivity = this.f48024f.get();
            if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.hasActivedFrame()) {
                d.a.n0.a.h0.g.f o = swanAppActivity.getSwanAppFragmentManager().o();
                if (o != null) {
                    d.a.n0.a.a2.n.g D1 = o.D1();
                    if (D1 == null) {
                        return true;
                    }
                    if (D1.l || D1.m) {
                        d.a.n0.a.e2.c.f fVar = d.a.n0.a.n1.q.c.a.g(true).get("scope_disable_swipe_back");
                        if (fVar == null || fVar.f44329d) {
                            return false;
                        }
                        SlideHelper slideHelper = this.f48023e;
                        if (slideHelper != null) {
                            slideHelper.setRegionFactor(0.1d);
                        }
                    }
                    return true;
                } else if (f48022i) {
                    Log.d("SwanActivitySlideHelper", "topFragment = null; return false");
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (swanAppActivity = this.f48024f.get()) == null) {
            return;
        }
        d.a.n0.a.g2.b skinDecorator = swanAppActivity.getSkinDecorator();
        this.f48025g = skinDecorator;
        if (skinDecorator == null) {
            return;
        }
        if (d.a.n0.a.f1.c.a.c(false).booleanValue()) {
            this.f48025g.c(0);
        }
        f();
    }

    public void n() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (swanAppActivity = this.f48024f.get()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.f48026h, intentFilter);
    }

    public void p() {
        WeakReference<SwanAppActivity> weakReference;
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (weakReference = this.f48024f) == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.f48026h);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f48024f.get() == null) {
            return;
        }
        this.f48023e.setCanSlide(c());
    }

    public void r() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (swanAppActivity = this.f48024f.get()) == null) {
            return;
        }
        b.a launchInfo = swanAppActivity.getLaunchInfo();
        if ((launchInfo != null && "1230000000000000".equals(launchInfo.T())) || swanAppActivity.getFrameType() == 1) {
            this.f48023e.setCanSlide(false);
        } else {
            this.f48023e.setCanSlide(c());
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && d.a.n0.a.f1.c.a.c(true).booleanValue()) {
            this.f48025g.c(0);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f48023e.setCanSlide(z);
        }
    }
}
