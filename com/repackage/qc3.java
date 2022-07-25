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
import com.repackage.fl2;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class qc3 implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public SlideHelper a;
    public WeakReference<SwanAppActivity> b;
    public x53 c;
    public BroadcastReceiver d;

    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc3 this$0;

        public a(qc3 qc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = qc3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if ((PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_HOME_KEY.equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && this.this$0.a != null) {
                    this.this$0.a.closePane();
                    this.this$0.a.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ qc3 b;

        public b(qc3 qc3Var, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc3Var, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qc3Var;
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
                this.a.p0(3);
                this.b.h();
                this.a.overridePendingTransition(0, 0);
                wq2.e().g();
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
            if (this.a.Z()) {
                this.a.Q().t0();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755384976, "Lcom/repackage/qc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755384976, "Lcom/repackage/qc3;");
                return;
            }
        }
        e = sg1.a;
    }

    public qc3(SwanAppActivity swanAppActivity) {
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

    public void e() {
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
        om1 g = g();
        if (g != null) {
            this.a.setRegionFactor(g.B());
        }
    }

    public final om1 g() {
        InterceptResult invokeV;
        rz1 X;
        oz1 m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity == null || (X = swanAppActivity.X()) == null || (m = X.m()) == null || !(m instanceof qz1)) {
                return null;
            }
            return ((qz1) m).o3();
        }
        return (om1) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && pj2.M().a()) {
            this.c.c(8);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.repackage.pm1] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        rz1 X;
        om1 g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity == null || !swanAppActivity.Z() || (X = swanAppActivity.X()) == null || (g = g()) == null) {
                return false;
            }
            rm1 l = g.l();
            return X.k() <= 1 && g.isSlidable(motionEvent) && !(l != null && l.t() != 0 && l.t().canGoBack()) && j();
        }
        return invokeL.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.Z()) {
                qz1 o = swanAppActivity.X().o();
                if (o != null) {
                    x03 G1 = o.G1();
                    if (G1 == null) {
                        return true;
                    }
                    if (G1.l || G1.m) {
                        i53 i53Var = gs2.g(true).get("scope_disable_swipe_back");
                        if (i53Var == null || i53Var.d) {
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

    public void m() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (swanAppActivity = this.b.get()) == null) {
            return;
        }
        x53 w = swanAppActivity.w();
        this.c = w;
        if (w == null) {
            return;
        }
        if (al2.c(false).booleanValue()) {
            this.c.c(0);
        }
        f();
    }

    public void o() {
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
        fl2.a S = swanAppActivity.S();
        if ((S != null && "1230000000000000".equals(S.T())) || swanAppActivity.R() == 1) {
            this.a.setCanSlide(false);
        } else {
            this.a.setCanSlide(c());
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && al2.c(true).booleanValue()) {
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
