package d.a.q0.a.h0.g;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.v0.c;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.x0;
import d.a.q0.k.n;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes8.dex */
public abstract class d extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B0;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.a.h0.g.l.c A0;
    public Activity k0;
    public d.a.q0.a.l1.c l0;
    public View m0;
    public SwanAppActionBar n0;
    public n o0;
    public SwanAppMenuHeaderView p0;
    public View q0;
    public TextView r0;
    @Nullable
    public d.a.q0.a.w2.d.b s0;
    public boolean t0;
    public SlideHelper u0;
    public int v0;
    public int w0;
    public l x0;
    public m y0;
    public boolean z0;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47967e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47967e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    this.f47967e.u0.setRegionFactor(0.1d);
                    d dVar = this.f47967e;
                    dVar.u0.setCanSlide(dVar.w1());
                    return;
                }
                d dVar2 = this.f47967e;
                dVar2.u0.setCanSlide(dVar2.w1());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f47968a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47968a = dVar;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47968a.f2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f47968a.B1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                View maskView = this.f47968a.u0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f2);
                }
                this.f47968a.g2(f2);
                if (this.f47968a.y0 != null) {
                    this.f47968a.y0.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47969e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47969e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.m1.g.d();
            }
        }
    }

    /* renamed from: d.a.q0.a.h0.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC0778d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47970e;

        /* renamed from: d.a.q0.a.h0.g.d$d$a */
        /* loaded from: classes8.dex */
        public class a implements d.a.q0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0778d f47971a;

            public a(View$OnClickListenerC0778d view$OnClickListenerC0778d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0778d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47971a = view$OnClickListenerC0778d;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.f47971a.f47970e.c2();
                }
            }
        }

        public View$OnClickListenerC0778d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47970e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (d.a.q0.a.v0.a.b().c()) {
                    d.a.q0.a.v0.a.b().f(this.f47970e.k0, new a(this));
                } else {
                    this.f47970e.c2();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47972e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47972e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47972e.e2();
                d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
                fVar.f49123e = SupportMenuInflater.XML_MENU;
                if (d.a.q0.a.a2.e.Q() != null && d.a.q0.a.a2.e.Q().J().d("key_unread_counts_message", 0).intValue() > 0) {
                    fVar.f49125g = String.valueOf(1);
                }
                this.f47972e.y1(fVar);
                if (this.f47972e.x0 != null) {
                    this.f47972e.x0.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47973e;

        /* loaded from: classes8.dex */
        public class a implements d.a.q0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f47974a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47974a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.f47974a.f47973e.x1();
                }
            }
        }

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47973e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f47973e.k0) != null && (activity instanceof SwanAppActivity)) {
                if (d.a.q0.a.a2.e.i() == null || d.a.q0.a.a2.e.V() == null) {
                    this.f47973e.x1();
                } else if (d.a.q0.a.v0.a.b().c()) {
                    d.a.q0.a.v0.a.b().f(this.f47973e.k0, new a(this));
                } else if (d.a.q0.a.v0.c.c().h()) {
                    this.f47973e.x1();
                } else {
                    d.a.q0.a.v0.b bVar = new d.a.q0.a.v0.b();
                    bVar.h();
                    if (!bVar.k()) {
                        this.f47973e.x1();
                        d.a.q0.a.m1.g.f().i();
                        return;
                    }
                    String f2 = bVar.f();
                    String e2 = bVar.e();
                    d.a.q0.a.v0.c c2 = d.a.q0.a.v0.c.c();
                    d dVar = this.f47973e;
                    c2.j(dVar.k0, f2, e2, bVar, dVar.C1());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f47975a;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47975a = dVar;
        }

        @Override // d.a.q0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47975a.x1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47976e;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47976e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47976e.i2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47977e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47977e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47977e.z1(d.a.q0.a.u1.a.a.D());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47978e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f47979f;

        public j(d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47979f = dVar;
            this.f47978e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f47979f;
                if (dVar.k0 == null || (swanAppActionBar = dVar.n0) == null) {
                    return;
                }
                if (this.f47978e) {
                    if (dVar.r0 == null) {
                        dVar.r0 = new TextView(this.f47979f.k0);
                    }
                    if (this.f47979f.r0.getParent() instanceof SwanAppActionBar) {
                        return;
                    }
                    this.f47979f.r0.setText(d.a.q0.a.h.aiapps_debug_open_cts);
                    d dVar2 = this.f47979f;
                    dVar2.r0.setTextColor(dVar2.G1().getColor(17170455));
                    d dVar3 = this.f47979f;
                    dVar3.n0.addView(dVar3.r0);
                    return;
                }
                TextView textView = dVar.r0;
                if (textView != null) {
                    swanAppActionBar.removeView(textView);
                    this.f47979f.r0 = null;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47980e;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47980e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47980e.d2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47981a;

        /* renamed from: b  reason: collision with root package name */
        public long f47982b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f47983c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f47984d;

        public l(d dVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47984d = dVar;
            this.f47981a = 0;
            this.f47982b = 0L;
            this.f47983c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f47982b > 1333) {
                    this.f47982b = currentTimeMillis;
                    this.f47981a = 1;
                    return;
                }
                int i2 = this.f47981a + 1;
                this.f47981a = i2;
                if (i2 == 3) {
                    Runnable runnable = this.f47983c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.f47981a = 0;
                    this.f47982b = 0L;
                    return;
                }
                this.f47982b = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface m {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705417293, "Ld/a/q0/a/h0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705417293, "Ld/a/q0/a/h0/g/d;");
                return;
            }
        }
        B0 = d.a.q0.a.k.f49133a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t0 = d.a.q0.a.w2.d.b.f51586i;
        this.v0 = 1;
        this.w0 = 1;
        this.z0 = false;
    }

    public View A1(View view, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.u0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
            this.u0.setFadeColor(0);
            q2();
            A2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.u0.setSlideListener(new b(this));
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.a.h0.g.g J1 = J1();
            if (J1 != null && J1.k() != 1) {
                g.b i2 = J1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
                eVar.f49123e = com.alipay.sdk.widget.j.j;
                eVar.f49125g = V1() ? "1" : "0";
                eVar.f49120b = "gesture";
                d.a.q0.a.j2.d.a(eVar, d.a.q0.a.a2.d.g().r().L());
                d.a.q0.a.j2.d.c(eVar);
                return;
            }
            Activity activity = this.k0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                x0.b().e(1);
            }
        }
    }

    public boolean B2(FrameLayout frameLayout, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, frameLayout, i2)) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            d.a.q0.a.a2.n.g D1 = D1();
            if (D1 != null) {
                D1.f46730e = i2;
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final c.b C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new g(this) : (c.b) invokeV.objValue;
    }

    public void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public d.a.q0.a.a2.n.g D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (d.a.q0.a.a2.n.g) invokeV.objValue;
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (B0) {
                Log.d("SwanAppBaseFragment", "onDetach");
            }
            this.k0 = null;
            N1(false);
            super.E0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("y");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TextUtils.isEmpty(d.a.q0.a.a2.e.V())) {
                return 0;
            }
            return d.a.q0.a.j0.b.a.n(d.a.q0.a.a2.e.V()) ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public final void E2(boolean z, float f2) {
        d.a.q0.a.h0.g.g J1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) || (J1 = J1()) == null || J1.k() < 2) {
            return;
        }
        d j2 = J1.j(J1.k() - 2);
        b2(f2, j2);
        if (z) {
            J1.h().o(j2);
        } else {
            J1.h().c(j2);
        }
    }

    @Nullable
    public d.a.q0.a.w2.d.b F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.s0 : (d.a.q0.a.w2.d.b) invokeV.objValue;
    }

    public void F2(d.a.q0.a.h0.g.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.A0.d(aVar);
        }
    }

    public final Resources G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (l0()) {
                return z();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.q0.a.r1.k.i.b.e().f(new i(this), "updateCtsView");
        }
    }

    public SwanAppActionBar H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n0 : (SwanAppActionBar) invokeV.objValue;
    }

    public View I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m0 : (View) invokeV.objValue;
    }

    public final d.a.q0.a.h0.g.g J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Activity activity = this.k0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).getSwanAppFragmentManager();
        }
        return (d.a.q0.a.h0.g.g) invokeV.objValue;
    }

    public abstract boolean K();

    public d.a.q0.a.l1.c K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l0 : (d.a.q0.a.l1.c) invokeV.objValue;
    }

    public void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.a.q0.a.c2.f.p0.a.f("backtohome", SupportMenuInflater.XML_MENU, d.a.q0.a.g1.f.V().f());
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49123e = "gohome";
            fVar.f49121c = SupportMenuInflater.XML_MENU;
            y1(fVar);
        }
    }

    public void M1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            FloatButton c2 = d.a.q0.a.c2.f.i0.a.d().c();
            if (!z) {
                if (c2 == null || c2.getVisibility() != 0) {
                    return;
                }
                c2.setVisibility(8);
            } else if (c2 == null || c2.getVisibility() == 0) {
            } else {
                c2.setVisibility(0);
            }
        }
    }

    public void N1(boolean z) {
        d.a.q0.a.h0.g.g W;
        d j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (W = d.a.q0.a.g1.f.V().W()) == null) {
            return;
        }
        if (z) {
            j2 = W.m();
        } else {
            j2 = W.j(W.k() - 1);
        }
        if (j2 == null) {
            return;
        }
        M1(j2.X1());
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public void Q1(View view) {
        d.a.q0.a.a2.n.g e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            R1(view);
            SwanAppConfigData s = d.a.q0.a.g1.f.V().s();
            if (s == null) {
                if (B0) {
                    Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            d.a.q0.a.l1.c cVar = this.l0;
            if (cVar == null) {
                e2 = s.f11460e;
            } else {
                e2 = d.a.q0.a.g1.f.V().e(d.a.q0.a.c2.f.p0.j.c(cVar.g(), s));
            }
            l2(e2.f46726a);
            this.n0.setTitle(e2.f46727b);
            this.x0 = new l(this, new c(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                t2(SwanAppConfigData.s(e2.f46728c));
            }
            String str = e2.f46728c;
        }
    }

    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, view) == null) || view == null) {
            return;
        }
        this.n0 = (SwanAppActionBar) view.findViewById(d.a.q0.a.f.ai_apps_title_bar);
        this.m0 = view.findViewById(d.a.q0.a.f.ai_apps_title_bar_root);
        this.q0 = view.findViewById(d.a.q0.a.f.title_shadow);
        this.n0.setLeftBackViewMinWidth(n0.f(this.k0, 38.0f));
        View$OnClickListenerC0778d view$OnClickListenerC0778d = new View$OnClickListenerC0778d(this);
        this.n0.setLeftBackViewClickListener(view$OnClickListenerC0778d);
        this.n0.setLeftFloatBackViewClickListener(view$OnClickListenerC0778d);
        this.n0.setRightMenuOnClickListener(new e(this));
        this.n0.setRightExitOnClickListener(new f(this));
    }

    public View S1(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view)) == null) {
            if (view == null) {
                return null;
            }
            if ("IMMERSION_LAYOUT_TAG".equals(view.getTag())) {
                return view;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if ("IMMERSION_LAYOUT_TAG".equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view);
            }
            FrameLayout frameLayout = new FrameLayout(q());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            T1(frameLayout, view);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public View T1(FrameLayout frameLayout, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, frameLayout, view)) == null) {
            frameLayout.setTag("IMMERSION_LAYOUT_TAG");
            frameLayout.addView(view);
            this.s0 = new d.a.q0.a.w2.d.b(this.k0, frameLayout);
            t1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            Activity activity = this.k0;
            return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            d.a.q0.a.h0.g.g J1 = J1();
            return J1 != null && J1.k() > 1;
        }
        return invokeV.booleanValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.w0 == -1 : invokeV.booleanValue;
    }

    public abstract boolean X1();

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(d.a.q0.a.a2.e.V()) : invokeV.booleanValue;
    }

    public abstract boolean Z1();

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.n0.setLeftHomeViewVisibility(0);
            this.n0.setLeftHomeViewClickListener(new k(this));
        }
    }

    public final void b2(float f2, Fragment fragment) {
        View b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o = n0.o(this.k0) >> 2;
            float f3 = (f2 * o) - o;
            if (fragment == null || (b0 = fragment.b0()) == null) {
                return;
            }
            b0.setX(f3);
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Activity activity = this.k0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).onBackPressed(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    public abstract void e2();

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            E2(false, 1.0f);
        }
    }

    public void g2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f2) == null) {
            E2(true, f2);
        }
    }

    public void h2(d.a.q0.a.h0.g.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, aVar) == null) {
            this.A0.c(aVar);
        }
    }

    public void i2() {
        d.a.q0.a.w2.d.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && P1() && (bVar = this.s0) != null) {
            bVar.l();
        }
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.q0.a.a2.e.V());
            d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.c(hashMap));
            d.a.q0.a.e0.d.g("SwanAppBaseFragment", "onClose");
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49123e = IntentConfig.CLOSE;
            y1(fVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void k2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048622, this, i2, str) == null) {
            switch (str.hashCode()) {
                case -1965087616:
                    if (str.equals("easeOut")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1310316109:
                    if (str.equals("easeIn")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1102672091:
                    if (str.equals("linear")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1330629787:
                    if (str.equals("easeInOut")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                linearInterpolator = new LinearInterpolator();
            } else if (c2 == 1) {
                linearInterpolator = new AccelerateInterpolator();
            } else if (c2 == 2) {
                linearInterpolator = new DecelerateInterpolator();
            } else if (c2 != 3) {
                linearInterpolator = new LinearInterpolator();
            } else {
                linearInterpolator = new AccelerateDecelerateInterpolator();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.n0, "alpha", 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            d.a.q0.a.w2.d.b bVar = this.s0;
            if (bVar == null || bVar.e() == null) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s0.e(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(linearInterpolator);
            ofFloat2.start();
        }
    }

    public boolean l2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) ? m2(i2, false) : invokeI.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            super.m1(z);
            if (z) {
                i2();
            }
        }
    }

    public boolean m2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null || this.q0 == null) {
                return false;
            }
            this.w0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            d.a.q0.a.a2.n.g D1 = D1();
            if (D1 != null) {
                D1.f46726a = i2;
                D1.g(z);
            }
            if (P1()) {
                t1();
            }
            if (W1()) {
                this.q0.setVisibility(0);
                return true;
            }
            this.q0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public boolean n2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) ? o2(str, false) : invokeL.booleanValue;
    }

    public boolean o2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048627, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            d.a.q0.a.a2.n.g D1 = D1();
            if (D1 != null) {
                D1.f46727b = str;
                D1.g(z);
            }
            d.a.q0.a.e0.d.g("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            n0.c(this.k0);
            if (P1() && this.s0 != null && configuration.orientation == 1) {
                h().getWindow().clearFlags(1024);
                q0.c0(new h(this), 200L);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.A0.b();
            super.onPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            this.A0.a();
            if (B0) {
                Log.d("SwanAppBaseFragment", MissionEvent.MESSAGE_RESUME);
            }
            if (W()) {
                i2();
            }
            G2();
        }
    }

    public void p2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.n0.setLeftBackViewVisibility(z);
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            d.a.q0.a.a2.n.g D1 = D1();
            if (D1 != null && (D1.l || D1.m)) {
                d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
                if (Q != null) {
                    Q.T().g(Q.x(), "scope_disable_swipe_back", new a(this));
                    return;
                } else {
                    this.u0.setCanSlide(w1());
                    return;
                }
            }
            this.u0.setCanSlide(w1());
        }
    }

    public void r2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.z0 = z;
        }
    }

    public void s2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.q0 != null) {
                int i2 = 8;
                if (!z && W1()) {
                    i2 = 0;
                }
                this.q0.setVisibility(i2);
            }
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || this.s0 == null) {
            return;
        }
        u1(this.w0);
    }

    public boolean t2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) ? u2(i2, "", false) : invokeI.booleanValue;
    }

    public void u1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048637, this, i2) == null) || this.s0 == null) {
            return;
        }
        v1(i2, false);
    }

    public boolean u2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048638, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.n0 == null) {
                return false;
            }
            y2(!this.z0);
            d.a.q0.a.a2.n.g D1 = D1();
            if (D1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    D1.f46728c = str;
                }
                D1.g(z);
            }
            int i3 = i2 != -16777216 ? -1 : -16777216;
            if (P1() && i3 != this.v0) {
                this.v0 = i3;
                t1();
            }
            return this.n0.f(i2, this.z0);
        }
        return invokeCommon.booleanValue;
    }

    public void v1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.s0 == null) {
            return;
        }
        this.w0 = i2;
        int i3 = this.v0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = d.a.q0.a.v2.i.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.s0.m(i2, z, z2);
    }

    public boolean v2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048640, this, str, z)) == null) ? u2(SwanAppConfigData.s(str), str, z) : invokeLZ.booleanValue;
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? (G1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true : invokeV.booleanValue;
    }

    public void w2(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, mVar) == null) {
            this.y0 = mVar;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void x0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, context) == null) {
            if (B0) {
                Log.d("SwanAppBaseFragment", "onAttach");
            }
            this.A0 = new d.a.q0.a.h0.g.l.c();
            super.x0(context);
            this.k0 = h();
            N1(true);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || this.k0 == null) {
            return;
        }
        d.a.q0.a.g1.g.a().d(false);
        this.k0.moveTaskToBack(true);
        j2();
        ((SwanAppActivity) this.k0).handleSwanAppExit(1);
        x0.b().e(2);
    }

    public void x2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048645, this, i2) == null) || (activity = this.k0) == null) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }

    public final void y1(d.a.q0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, fVar) == null) {
            Activity activity = this.k0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).doUBCEventStatistic(fVar);
            }
        }
    }

    public void y2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.n0.setRightExitViewVisibility(z);
        }
    }

    public final void z1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            q0.b0(new j(this, z));
        }
    }

    public void z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.n0.setRightZoneVisibility(z);
        }
    }
}
