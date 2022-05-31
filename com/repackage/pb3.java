package com.repackage;

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
import com.repackage.ek2;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class pb3 implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public SlideHelper a;
    public WeakReference<SwanAppActivity> b;
    public w43 c;
    public BroadcastReceiver d;

    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pb3 this$0;

        public a(pb3 pb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pb3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (("homekey".equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && this.this$0.a != null) {
                    this.this$0.a.closePane();
                    this.this$0.a.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ pb3 b;

        public b(pb3 pb3Var, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pb3Var;
            this.a = swanAppActivity;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.onBackPressed(3);
                this.b.h();
                this.a.overridePendingTransition(0, 0);
                vp2.e().g();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view2, float f) {
            View maskView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) || (maskView = this.b.a.getMaskView()) == null) {
                return;
            }
            maskView.setAlpha(1.0f - f);
            if (this.a.hasActivedFrame()) {
                this.a.getFrame().t0();
            }
            if (f == 0.0f) {
                maskView.setBackgroundColor(Color.parseColor("#40000000"));
            }
            if (f == 1.0f) {
                maskView.setBackgroundColor(0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755415728, "Lcom/repackage/pb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755415728, "Lcom/repackage/pb3;");
                return;
            }
        }
        e = rf1.a;
    }

    public pb3(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.b = new WeakReference<>(swanAppActivity);
        this.a = new SlideHelper();
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            return (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.closePane();
        }
    }

    public void f() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (swanAppActivity = this.b.get()) == null || swanAppActivity.isDestroyed()) {
            return;
        }
        this.a.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
        this.a.attachActivity(swanAppActivity);
        this.a.setEnableReleaseWhenNoTranslucent(false);
        this.a.setFadeColor(0);
        this.a.setSlideInterceptor(this);
        this.a.setSlideListener(new b(this, swanAppActivity));
        nl1 g = g();
        if (g != null) {
            this.a.setRegionFactor(g.C());
        }
    }

    public final nl1 g() {
        InterceptResult invokeV;
        qy1 swanAppFragmentManager;
        ny1 m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || !(m instanceof py1)) {
                return null;
            }
            return ((py1) m).n3();
        }
        return (nl1) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && oi2.M().a()) {
            this.c.c(8);
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.hasActivedFrame()) {
                py1 o = swanAppActivity.getSwanAppFragmentManager().o();
                if (o != null) {
                    wz2 F1 = o.F1();
                    if (F1 == null) {
                        return true;
                    }
                    if (F1.l || F1.m) {
                        h43 h43Var = fr2.g(true).get("scope_disable_swipe_back");
                        if (h43Var == null || h43Var.d) {
                            return false;
                        }
                        SlideHelper slideHelper = this.a;
                        if (slideHelper != null) {
                            slideHelper.setRegionFactor(0.1d);
                        }
                    }
                    return true;
                } else if (e) {
                    Log.d("SwanActivitySlideHelper", "topFragment = null; return false");
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.repackage.ol1] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        qy1 swanAppFragmentManager;
        nl1 g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity == null || !swanAppActivity.hasActivedFrame() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (g = g()) == null) {
                return false;
            }
            ql1 m = g.m();
            return swanAppFragmentManager.k() <= 1 && g.isSlidable(motionEvent) && !(m != null && m.u() != 0 && m.u().canGoBack()) && i();
        }
        return invokeL.booleanValue;
    }

    public void k() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (swanAppActivity = this.b.get()) == null) {
            return;
        }
        w43 skinDecorator = swanAppActivity.getSkinDecorator();
        this.c = skinDecorator;
        if (skinDecorator == null) {
            return;
        }
        if (zj2.c(false).booleanValue()) {
            this.c.c(0);
        }
        f();
    }

    public void n() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (swanAppActivity = this.b.get()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.d, intentFilter);
    }

    public void p() {
        WeakReference<SwanAppActivity> weakReference;
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (weakReference = this.b) == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.d);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b.get() == null) {
            return;
        }
        this.a.setCanSlide(c());
    }

    public void r() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (swanAppActivity = this.b.get()) == null) {
            return;
        }
        ek2.a launchInfo = swanAppActivity.getLaunchInfo();
        if ((launchInfo != null && "1230000000000000".equals(launchInfo.T())) || swanAppActivity.getFrameType() == 1) {
            this.a.setCanSlide(false);
        } else {
            this.a.setCanSlide(c());
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && zj2.c(true).booleanValue()) {
            this.c.c(0);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.a.setCanSlide(z);
        }
    }
}
