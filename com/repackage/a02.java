package com.repackage;

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
import android.widget.Button;
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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ce2;
import com.repackage.d02;
import com.repackage.z53;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.component.anim.TimeFunctionConst;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class a02 extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public l02 B0;
    public double C0;
    public boolean D0;
    public final String h0;
    public Activity i0;
    public vq2 j0;
    public View k0;
    public SwanAppActionBar l0;
    public z64 m0;
    public SwanAppMenuHeaderView n0;
    public View o0;
    public TextView p0;
    public TextView q0;
    public Button r0;
    public AtomicBoolean s0;
    @Nullable
    public vf3 t0;
    public boolean u0;
    public SlideHelper v0;
    public int w0;
    public int x0;
    public o y0;
    public p z0;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public a(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A1(tw2.E());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ a02 b;

        public b(a02 a02Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a02Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a02 a02Var = this.b;
                if (a02Var.i0 == null || (swanAppActionBar = a02Var.l0) == null) {
                    return;
                }
                if (this.a) {
                    if (a02Var.p0 == null) {
                        a02Var.p0 = new TextView(this.b.i0);
                    }
                    if (this.b.p0.getParent() instanceof SwanAppActionBar) {
                        return;
                    }
                    this.b.p0.setText(R.string.obfuscated_res_0x7f0f013d);
                    a02 a02Var2 = this.b;
                    a02Var2.p0.setTextColor(a02Var2.I1().getColor(17170455));
                    a02 a02Var3 = this.b;
                    a02Var3.l0.addView(a02Var3.p0);
                    return;
                }
                TextView textView = a02Var.p0;
                if (textView != null) {
                    swanAppActionBar.removeView(textView);
                    this.b.p0 = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public c(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public d(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.a.v0.setRegionFactor(0.1d);
                    a02 a02Var = this.a;
                    a02Var.C0 = 0.1d;
                    a02Var.v0.setCanSlide(a02Var.x1());
                    return;
                }
                a02 a02Var2 = this.a;
                a02Var2.v0.setCanSlide(a02Var2.x1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public e(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.D1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
                View maskView = this.a.v0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                this.a.k2(f);
                if (this.a.z0 != null) {
                    this.a.z0.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public f(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ir2.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        /* loaded from: classes5.dex */
        public class a implements g22<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.g22
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.a.a.g2();
                }
            }
        }

        public g(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ae2.b().c()) {
                    ae2.b().f(this.a.i0, new a(this));
                } else {
                    this.a.g2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public h(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i2();
                x73 x73Var = new x73();
                x73Var.e = SupportMenuInflater.XML_MENU;
                if (u03.a0() != null && u03.a0().T().d("key_unread_counts_message", 0).intValue() > 0) {
                    x73Var.g = String.valueOf(1);
                }
                this.a.z1(x73Var);
                if (this.a.y0 != null) {
                    this.a.y0.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        /* loaded from: classes5.dex */
        public class a implements nf3<x53<z53.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(x53<z53.e> x53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                    if (s53.h(x53Var)) {
                        this.a.a.p2();
                    } else {
                        this.a.a.l2();
                    }
                }
            }
        }

        public i(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.i0) != null && (activity instanceof SwanAppActivity)) {
                u03 a0 = u03.a0();
                if (a0 != null && !TextUtils.isEmpty(a0.getAppId())) {
                    if (hd3.f() && xc4.a().d()) {
                        a0.d0().g(a0.x(), "mapp_emit_app_close", new a(this));
                        return;
                    } else {
                        this.a.l2();
                        return;
                    }
                }
                this.a.y1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements g22<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public j(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g22
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                this.a.y1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ a02 b;

        public k(a02 a02Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a02Var;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || s63.g()) {
                return;
            }
            this.b.B1(this.a, s63.d(), s63.f());
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;
        public final /* synthetic */ a02 d;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.d.n2();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.d.P2();
                }
            }
        }

        public l(a02 a02Var, boolean z, boolean z2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var, Boolean.valueOf(z), Boolean.valueOf(z2), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a02Var;
            this.a = z;
            this.b = z2;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a || this.b) {
                    a02 a02Var = this.d;
                    if (a02Var.r0 == null) {
                        View view2 = this.c;
                        if (view2 == null) {
                            ux1.b("SwanAppBaseFragment", "view为null");
                            return;
                        }
                        a02Var.r0 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f091e3c);
                    }
                    this.d.r0.setVisibility(0);
                    if (this.a) {
                        this.d.r0.setOnClickListener(new a(this));
                    }
                    if (this.b) {
                        this.d.s0 = new AtomicBoolean(false);
                        this.d.r0.setText(R.string.obfuscated_res_0x7f0f12f7);
                        this.d.r0.setOnClickListener(new b(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ce2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public m(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // com.repackage.ce2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;

        public n(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public Runnable c;
        public final /* synthetic */ a02 d;

        public o(a02 a02Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a02Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a02Var;
            this.a = 0;
            this.b = 0L;
            this.c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.b > 1333) {
                    this.b = currentTimeMillis;
                    this.a = 1;
                    return;
                }
                int i = this.a + 1;
                this.a = i;
                if (i == 3) {
                    Runnable runnable = this.c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.a = 0;
                    this.b = 0L;
                    return;
                }
                this.b = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface p {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755910674, "Lcom/repackage/a02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755910674, "Lcom/repackage/a02;");
                return;
            }
        }
        E0 = eh1.a;
    }

    public a02() {
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
        this.h0 = UUID.randomUUID().toString();
        this.u0 = vf3.i;
        this.w0 = 1;
        this.x0 = 1;
        this.A0 = false;
        this.C0 = -1.0d;
        this.D0 = false;
    }

    public final void A1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            oe3.e0(new b(this, z));
        }
    }

    public void A2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.o0 != null) {
                int i2 = 8;
                if (!z && a2()) {
                    i2 = 0;
                }
                this.o0.setVisibility(i2);
            }
        }
    }

    public void B1(View view2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            oe3.e0(new l(this, z, z2, view2));
        }
    }

    public boolean B2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? C2(i2, "", false) : invokeI.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (E0) {
                Log.d("SwanAppBaseFragment", "onDetach");
            }
            this.i0 = null;
            Q1(false);
            super.C0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("u");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public View C1(View view2, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.v0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view2.getContext(), view2, slideInterceptor);
            this.v0.setFadeColor(0);
            x2();
            J2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public boolean C2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.l0 == null) {
                return false;
            }
            H2(!this.A0);
            j13 F1 = F1();
            if (F1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    F1.c = str;
                }
                F1.g(z);
            }
            int i3 = i2 != -16777216 ? -1 : -16777216;
            if (S1() && i3 != this.w0) {
                this.w0 = i3;
                u1();
            }
            return this.l0.f(i2, this.A0);
        }
        return invokeCommon.booleanValue;
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d02 L1 = L1();
            if (L1 != null && L1.k() != 1) {
                i73.f(UUID.randomUUID().toString(), 1);
                d02.b i2 = L1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                w73 w73Var = new w73();
                w73Var.e = "back";
                w73Var.g = Y1() ? "1" : "0";
                w73Var.b = "gesture";
                d73.a(w73Var, t03.J().r().V());
                d73.c(w73Var);
                return;
            }
            Activity activity = this.i0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                we3.b().e(1);
            }
        }
    }

    public boolean D2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) ? C2(SwanAppConfigData.t(str), str, z) : invokeLZ.booleanValue;
    }

    public final ce2.b E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new m(this) : (ce2.b) invokeV.objValue;
    }

    public void E2(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            this.z0 = pVar;
        }
    }

    public j13 F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (j13) invokeV.objValue;
    }

    public void F2(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d2)}) == null) && Z1(d2)) {
            if (Z1(this.C0)) {
                d2 = this.C0;
            }
            this.v0.setRegionFactor(d2);
        }
    }

    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (TextUtils.isEmpty(u03.f0())) {
                return 0;
            }
            return s72.n(u03.f0()) ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public void G2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (activity = this.i0) == null) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }

    @Nullable
    public vf3 H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.t0 : (vf3) invokeV.objValue;
    }

    public void H2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.l0.setRightExitViewVisibility(z);
        }
    }

    public final Resources I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (g0()) {
                return getResources();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void I2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.l0.setRightZoneVisibility(z);
        }
    }

    public SwanAppActionBar J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l0 : (SwanAppActionBar) invokeV.objValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.v0.setSlideListener(new e(this));
        }
    }

    public View K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k0 : (View) invokeV.objValue;
    }

    public boolean K2(FrameLayout frameLayout, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{frameLayout, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            j13 F1 = F1();
            if (F1 != null) {
                F1.e = i2;
                F1.p = z;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public abstract boolean L();

    public final d02 L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            Activity activity = this.i0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).getSwanAppFragmentManager();
        }
        return (d02) invokeV.objValue;
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    public vq2 M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.j0 : (vq2) invokeV.objValue;
    }

    public boolean M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public z64 N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.m0 : (z64) invokeV.objValue;
    }

    public final void N2(boolean z, float f2) {
        d02 L1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) || (L1 = L1()) == null || L1.k() < 2) {
            return;
        }
        a02 j2 = L1.j(L1.k() - 2);
        f2(f2, j2);
        if (z) {
            if (j2.D0) {
                O2(L1, f2);
                return;
            } else {
                L1.h().o(j2);
                return;
            }
        }
        L1.h().c(j2);
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            d43.f("backtohome", SupportMenuInflater.XML_MENU, hm2.U().g());
            x73 x73Var = new x73();
            x73Var.e = "gohome";
            x73Var.c = SupportMenuInflater.XML_MENU;
            z1(x73Var);
        }
    }

    public final void O2(d02 d02Var, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048607, this, d02Var, f2) == null) || d02Var == null || d02Var.k() < 3) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int k2 = d02Var.k() - 3;
        while (true) {
            if (k2 < 0) {
                break;
            }
            a02 j2 = d02Var.j(k2);
            if (j2.D0) {
                f2(f2, j2);
                arrayList.add(j2);
                k2--;
            } else {
                f2(f2, j2);
                arrayList.add(j2);
                break;
            }
        }
        d02Var.h().p(arrayList);
    }

    public void P1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            FloatButton c2 = k33.d().c();
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

    public final void P2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.r0 == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.s0;
        atomicBoolean.set(!atomicBoolean.get());
        boolean z = this.s0.get();
        this.r0.setText(z ? R.string.obfuscated_res_0x7f0f12f8 : R.string.obfuscated_res_0x7f0f12f7);
        s63.j(z);
    }

    public void Q1(boolean z) {
        d02 V;
        a02 j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (V = hm2.U().V()) == null) {
            return;
        }
        if (z) {
            j2 = V.m();
        } else {
            j2 = V.j(V.k() - 1);
        }
        if (j2 == null) {
            return;
        }
        P1(j2.b2());
    }

    public void Q2(j02 j02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, j02Var) == null) {
            this.B0.e(j02Var);
        }
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            nu2.e().d(new a(this), "updateCtsView", false);
        }
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.u0 : invokeV.booleanValue;
    }

    public void S2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
            nu2.e().d(new k(this, view2), "updateStabilityDataView", false);
        }
    }

    public void T1(View view2) {
        j13 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
            U1(view2);
            SwanAppConfigData s = hm2.U().s();
            if (s == null) {
                if (E0) {
                    Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            vq2 vq2Var = this.j0;
            if (vq2Var == null) {
                f2 = s.e;
            } else {
                f2 = hm2.U().f(m43.c(vq2Var.i(), s));
            }
            s2(f2.a);
            this.l0.setTitle(f2.b);
            this.y0 = new o(this, new f(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                B2(SwanAppConfigData.t(f2.c));
            }
            String str = f2.c;
        }
    }

    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, view2) == null) || view2 == null) {
            return;
        }
        this.l0 = (SwanAppActionBar) view2.findViewById(R.id.obfuscated_res_0x7f09017c);
        this.k0 = view2.findViewById(R.id.obfuscated_res_0x7f09017d);
        this.o0 = view2.findViewById(R.id.obfuscated_res_0x7f092099);
        this.l0.setLeftBackViewMinWidth(le3.f(this.i0, 38.0f));
        g gVar = new g(this);
        this.l0.setLeftBackViewClickListener(gVar);
        this.l0.setLeftFloatBackViewClickListener(gVar);
        this.l0.setRightMenuOnClickListener(new h(this));
        this.l0.setRightExitOnClickListener(new i(this));
    }

    public View V1(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if ("IMMERSION_LAYOUT_TAG".equals(view2.getTag())) {
                return view2;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                if ("IMMERSION_LAYOUT_TAG".equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view2);
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            W1(frameLayout, view2);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public View W1(FrameLayout frameLayout, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, frameLayout, view2)) == null) {
            frameLayout.setTag("IMMERSION_LAYOUT_TAG");
            frameLayout.addView(view2);
            this.t0 = new vf3(this.i0, frameLayout);
            u1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            Activity activity = this.i0;
            return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            d02 L1 = L1();
            return L1 != null && L1.k() > 1;
        }
        return invokeV.booleanValue;
    }

    public boolean Z1(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 >= 0.0d && d2 <= 1.0d : invokeCommon.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.x0 == -1 : invokeV.booleanValue;
    }

    public abstract boolean b2();

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(u03.f0()) : invokeV.booleanValue;
    }

    public abstract boolean d2();

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.l0.setLeftHomeViewVisibility(0);
            this.l0.setLeftHomeViewClickListener(new c(this));
        }
    }

    public final void f2(float f2, Fragment fragment) {
        View S;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o2 = le3.o(this.i0) >> 2;
            float f3 = (f2 * o2) - o2;
            if (fragment == null || (S = fragment.S()) == null) {
                return;
            }
            S.setX(f3);
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            Activity activity = this.i0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).onBackPressed(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
        }
    }

    public abstract void i2();

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            N2(false, 1.0f);
        }
    }

    public void k2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048634, this, f2) == null) {
            N2(true, f2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            super.l1(z);
            if (z) {
                o2();
            }
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (ae2.b().c()) {
                ae2.b().f(this.i0, new j(this));
            } else if (ce2.c().h()) {
                y1();
            } else {
                be2 be2Var = new be2();
                be2Var.h();
                if (be2Var.j()) {
                    ce2.c().j(this.i0, be2Var.f(), be2Var.e(), be2Var, E1());
                    return;
                }
                y1();
                ir2.e().g();
            }
        }
    }

    public void m2(j02 j02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, j02Var) == null) {
            this.B0.d(j02Var);
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            Button button = this.r0;
            if (button != null) {
                button.setVisibility(8);
            }
            TextView textView = this.q0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (s63.d()) {
                s63.l(true);
            }
        }
    }

    public void o2() {
        vf3 vf3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || this.D0 || !S1() || (vf3Var = this.t0) == null) {
            return;
        }
        vf3Var.l();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!X1()) {
                le3.c(this.i0);
            }
            if (S1() && this.t0 != null && configuration.orientation == 1) {
                getActivity().getWindow().clearFlags(1024);
                oe3.f0(new n(this), 200L);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.B0.c();
            super.onPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            super.onResume();
            this.B0.b();
            if (E0) {
                Log.d("SwanAppBaseFragment", "onResume");
            }
            if (Q()) {
                o2();
            }
            R2();
            if (this.m0 != null) {
                boolean d2 = bk2.y0().d();
                z64 z64Var = this.m0;
                if (d2 != z64Var.p) {
                    z64Var.z();
                    this.m0.p = bk2.y0().d();
                }
            }
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            String C = hm2.U().C();
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, C);
            hm2.U().u(new va2("closeBtn", hashMap));
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, u03.f0());
            hm2.U().u(new wa2(hashMap));
            ux1.i("SwanAppBaseFragment", "onClose");
            x73 x73Var = new x73();
            x73Var.e = "close";
            z1(x73Var);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void r2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048645, this, i2, str) == null) {
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
                    if (str.equals(TimeFunctionConst.Timing.LINEAR)) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.l0, AnimationProperty.OPACITY, 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            vf3 vf3Var = this.t0;
            if (vf3Var == null || vf3Var.e() == null) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.t0.e(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(linearInterpolator);
            ofFloat2.start();
        }
    }

    public boolean s2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048646, this, i2)) == null) ? t2(i2, false) : invokeI.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void t0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, context) == null) {
            if (E0) {
                Log.d("SwanAppBaseFragment", "onAttach");
            }
            this.B0 = new l02();
            super.t0(context);
            this.i0 = getActivity();
            Q1(true);
        }
    }

    public boolean t2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null || this.o0 == null) {
                return false;
            }
            this.x0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            j13 F1 = F1();
            if (F1 != null) {
                F1.a = i2;
                F1.g(z);
            }
            if (S1()) {
                u1();
            }
            if (a2()) {
                this.o0.setVisibility(0);
                return true;
            }
            this.o0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048649, this) == null) || this.t0 == null) {
            return;
        }
        v1(this.x0);
    }

    @Nullable
    public boolean u2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) ? v2(str, false) : invokeL.booleanValue;
    }

    public void v1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048651, this, i2) == null) || this.t0 == null) {
            return;
        }
        w1(i2, false);
    }

    public boolean v2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048652, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            j13 F1 = F1();
            if (F1 != null) {
                F1.b = str;
                F1.g(z);
            }
            ux1.i("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void w1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.t0 == null) {
            return;
        }
        this.x0 = i2;
        int i3 = this.w0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = gd3.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.t0.m(i2, z, z2);
    }

    public void w2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.l0.setLeftBackViewVisibility(z);
        }
    }

    public final boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? (I1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true : invokeV.booleanValue;
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            j13 F1 = F1();
            if (F1 != null && (F1.l || F1.m)) {
                u03 a0 = u03.a0();
                if (a0 != null) {
                    a0.d0().g(a0.x(), "scope_disable_swipe_back", new d(this));
                    return;
                } else {
                    this.v0.setCanSlide(x1());
                    return;
                }
            }
            this.v0.setCanSlide(x1());
        }
    }

    public void y1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || this.i0 == null) {
            return;
        }
        im2.a().d(false);
        this.i0.moveTaskToBack(true);
        q2();
        ((SwanAppActivity) this.i0).handleSwanAppExit(1);
        we3.b().e(2);
    }

    public void y2(boolean z) {
        SlideHelper slideHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048658, this, z) == null) || (slideHelper = this.v0) == null) {
            return;
        }
        slideHelper.setCanSlide(x1() && z);
    }

    public final void z1(x73 x73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, x73Var) == null) {
            Activity activity = this.i0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).doUBCEventStatistic(x73Var);
            }
        }
    }

    public void z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.A0 = z;
        }
    }
}
