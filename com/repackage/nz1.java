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
import com.repackage.m53;
import com.repackage.pd2;
import com.repackage.qz1;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class nz1 extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean E0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public yz1 B0;
    public double C0;
    public boolean D0;
    public final String h0;
    public Activity i0;
    public iq2 j0;
    public View k0;
    public SwanAppActionBar l0;
    public m64 m0;
    public SwanAppMenuHeaderView n0;
    public View o0;
    public TextView p0;
    public TextView q0;
    public Button r0;
    public AtomicBoolean s0;
    @Nullable
    public if3 t0;
    public boolean u0;
    public SlideHelper v0;
    public int w0;
    public int x0;
    public o y0;
    public p z0;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public a(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B1(gw2.E());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ nz1 b;

        public b(nz1 nz1Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz1Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nz1 nz1Var = this.b;
                if (nz1Var.i0 == null || (swanAppActionBar = nz1Var.l0) == null) {
                    return;
                }
                if (this.a) {
                    if (nz1Var.p0 == null) {
                        nz1Var.p0 = new TextView(this.b.i0);
                    }
                    if (this.b.p0.getParent() instanceof SwanAppActionBar) {
                        return;
                    }
                    this.b.p0.setText(R.string.obfuscated_res_0x7f0f0140);
                    nz1 nz1Var2 = this.b;
                    nz1Var2.p0.setTextColor(nz1Var2.J1().getColor(17170455));
                    nz1 nz1Var3 = this.b;
                    nz1Var3.l0.addView(nz1Var3.p0);
                    return;
                }
                TextView textView = nz1Var.p0;
                if (textView != null) {
                    swanAppActionBar.removeView(textView);
                    this.b.p0 = null;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public c(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public d(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.a.v0.setRegionFactor(0.1d);
                    nz1 nz1Var = this.a;
                    nz1Var.C0 = 0.1d;
                    nz1Var.v0.setCanSlide(nz1Var.y1());
                    return;
                }
                nz1 nz1Var2 = this.a;
                nz1Var2.v0.setCanSlide(nz1Var2.y1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public e(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.E1();
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
                this.a.l2(f);
                if (this.a.z0 != null) {
                    this.a.z0.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public f(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vq2.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        /* loaded from: classes6.dex */
        public class a implements t12<Boolean> {
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
            @Override // com.repackage.t12
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.a.a.h2();
                }
            }
        }

        public g(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (nd2.b().c()) {
                    nd2.b().f(this.a.i0, new a(this));
                } else {
                    this.a.h2();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public h(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j2();
                k73 k73Var = new k73();
                k73Var.e = SupportMenuInflater.XML_MENU;
                if (h03.b0() != null && h03.b0().U().d("key_unread_counts_message", 0).intValue() > 0) {
                    k73Var.g = String.valueOf(1);
                }
                this.a.A1(k73Var);
                if (this.a.y0 != null) {
                    this.a.y0.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        /* loaded from: classes6.dex */
        public class a implements af3<k53<m53.e>> {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(k53<m53.e> k53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                    if (f53.h(k53Var)) {
                        this.a.a.q2();
                    } else {
                        this.a.a.m2();
                    }
                }
            }
        }

        public i(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.i0) != null && (activity instanceof SwanAppActivity)) {
                h03 b0 = h03.b0();
                if (b0 != null && !TextUtils.isEmpty(b0.getAppId())) {
                    if (uc3.f() && kc4.a().d()) {
                        b0.e0().g(b0.w(), "mapp_emit_app_close", new a(this));
                        return;
                    } else {
                        this.a.m2();
                        return;
                    }
                }
                this.a.z1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements t12<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public j(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t12
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                this.a.z1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ nz1 b;

        public k(nz1 nz1Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz1Var;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f63.g()) {
                return;
            }
            this.b.C1(this.a, f63.d(), f63.f());
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;
        public final /* synthetic */ nz1 d;

        /* loaded from: classes6.dex */
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
                    this.a.d.o2();
                }
            }
        }

        /* loaded from: classes6.dex */
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
                    this.a.d.Q2();
                }
            }
        }

        public l(nz1 nz1Var, boolean z, boolean z2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var, Boolean.valueOf(z), Boolean.valueOf(z2), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nz1Var;
            this.a = z;
            this.b = z2;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a || this.b) {
                    nz1 nz1Var = this.d;
                    if (nz1Var.r0 == null) {
                        View view2 = this.c;
                        if (view2 == null) {
                            hx1.b("SwanAppBaseFragment", "view为null");
                            return;
                        }
                        nz1Var.r0 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f091e7b);
                    }
                    this.d.r0.setVisibility(0);
                    if (this.a) {
                        this.d.r0.setOnClickListener(new a(this));
                    }
                    if (this.b) {
                        this.d.s0 = new AtomicBoolean(false);
                        this.d.r0.setText(R.string.obfuscated_res_0x7f0f130f);
                        this.d.r0.setOnClickListener(new b(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements pd2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public m(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // com.repackage.pd2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;

        public n(nz1 nz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public Runnable c;
        public final /* synthetic */ nz1 d;

        public o(nz1 nz1Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz1Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nz1Var;
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

    /* loaded from: classes6.dex */
    public interface p {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755452308, "Lcom/repackage/nz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755452308, "Lcom/repackage/nz1;");
                return;
            }
        }
        E0 = rg1.a;
    }

    public nz1() {
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
        this.u0 = if3.i;
        this.w0 = 1;
        this.x0 = 1;
        this.A0 = false;
        this.C0 = -1.0d;
        this.D0 = false;
    }

    public final void A1(k73 k73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k73Var) == null) {
            Activity activity = this.i0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).N(k73Var);
            }
        }
    }

    public void A2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.A0 = z;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (E0) {
                Log.d("SwanAppBaseFragment", "onDetach");
            }
            this.i0 = null;
            R1(false);
            super.B0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("u");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void B1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            be3.e0(new b(this, z));
        }
    }

    public void B2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.o0 != null) {
                int i2 = 8;
                if (!z && b2()) {
                    i2 = 0;
                }
                this.o0.setVisibility(i2);
            }
        }
    }

    public void C1(View view2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            be3.e0(new l(this, z, z2, view2));
        }
    }

    public boolean C2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? D2(i2, "", false) : invokeI.booleanValue;
    }

    public View D1(View view2, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view2, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.v0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view2.getContext(), view2, slideInterceptor);
            this.v0.setFadeColor(0);
            y2();
            K2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public boolean D2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.l0 == null) {
                return false;
            }
            I2(!this.A0);
            w03 G1 = G1();
            if (G1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    G1.c = str;
                }
                G1.g(z);
            }
            int i3 = i2 != -16777216 ? -1 : -16777216;
            if (T1() && i3 != this.w0) {
                this.w0 = i3;
                v1();
            }
            return this.l0.f(i2, this.A0);
        }
        return invokeCommon.booleanValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            qz1 M1 = M1();
            if (M1 != null && M1.k() != 1) {
                v63.f(UUID.randomUUID().toString(), 1);
                qz1.b i2 = M1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                j73 j73Var = new j73();
                j73Var.e = "back";
                j73Var.g = Z1() ? "1" : "0";
                j73Var.b = "gesture";
                q63.a(j73Var, g03.K().q().W());
                q63.c(j73Var);
                return;
            }
            Activity activity = this.i0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                je3.b().e(1);
            }
        }
    }

    public boolean E2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) ? D2(SwanAppConfigData.t(str), str, z) : invokeLZ.booleanValue;
    }

    public final pd2.b F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new m(this) : (pd2.b) invokeV.objValue;
    }

    public void F2(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) {
            this.z0 = pVar;
        }
    }

    public w03 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (w03) invokeV.objValue;
    }

    public void G2(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d2)}) == null) && a2(d2)) {
            if (a2(this.C0)) {
                d2 = this.C0;
            }
            this.v0.setRegionFactor(d2);
        }
    }

    public int H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (TextUtils.isEmpty(h03.g0())) {
                return 0;
            }
            return f72.n(h03.g0()) ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public void H2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (activity = this.i0) == null) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }

    @Nullable
    public if3 I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.t0 : (if3) invokeV.objValue;
    }

    public void I2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.l0.setRightExitViewVisibility(z);
        }
    }

    public final Resources J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (g0()) {
                return getResources();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void J2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.l0.setRightZoneVisibility(z);
        }
    }

    public SwanAppActionBar K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l0 : (SwanAppActionBar) invokeV.objValue;
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.v0.setSlideListener(new e(this));
        }
    }

    public abstract boolean L();

    public View L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k0 : (View) invokeV.objValue;
    }

    public boolean L2(FrameLayout frameLayout, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{frameLayout, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            w03 G1 = G1();
            if (G1 != null) {
                G1.e = i2;
                G1.p = z;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final qz1 M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Activity activity = this.i0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).X();
        }
        return (qz1) invokeV.objValue;
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public iq2 N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.j0 : (iq2) invokeV.objValue;
    }

    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public m64 O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.m0 : (m64) invokeV.objValue;
    }

    public final void O2(boolean z, float f2) {
        qz1 M1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) || (M1 = M1()) == null || M1.k() < 2) {
            return;
        }
        nz1 j2 = M1.j(M1.k() - 2);
        g2(f2, j2);
        if (z) {
            if (j2.D0) {
                P2(M1, f2);
                return;
            } else {
                M1.h().o(j2);
                return;
            }
        }
        M1.h().c(j2);
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            q33.f("backtohome", SupportMenuInflater.XML_MENU, ul2.U().g());
            k73 k73Var = new k73();
            k73Var.e = "gohome";
            k73Var.c = SupportMenuInflater.XML_MENU;
            A1(k73Var);
        }
    }

    public final void P2(qz1 qz1Var, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048609, this, qz1Var, f2) == null) || qz1Var == null || qz1Var.k() < 3) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int k2 = qz1Var.k() - 3;
        while (true) {
            if (k2 < 0) {
                break;
            }
            nz1 j2 = qz1Var.j(k2);
            if (j2.D0) {
                g2(f2, j2);
                arrayList.add(j2);
                k2--;
            } else {
                g2(f2, j2);
                arrayList.add(j2);
                break;
            }
        }
        qz1Var.h().p(arrayList);
    }

    public void Q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            FloatButton c2 = x23.d().c();
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

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.r0 == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.s0;
        atomicBoolean.set(!atomicBoolean.get());
        boolean z = this.s0.get();
        this.r0.setText(z ? R.string.obfuscated_res_0x7f0f1310 : R.string.obfuscated_res_0x7f0f130f);
        f63.j(z);
    }

    public void R1(boolean z) {
        qz1 V;
        nz1 j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || (V = ul2.U().V()) == null) {
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
        Q1(j2.c2());
    }

    public void R2(wz1 wz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, wz1Var) == null) {
            this.B0.e(wz1Var);
        }
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            au2.e().d(new a(this), "updateCtsView", false);
        }
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.u0 : invokeV.booleanValue;
    }

    public void T2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            au2.e().d(new k(this, view2), "updateStabilityDataView", false);
        }
    }

    public void U1(View view2) {
        w03 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view2) == null) {
            V1(view2);
            SwanAppConfigData s = ul2.U().s();
            if (s == null) {
                if (E0) {
                    Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            iq2 iq2Var = this.j0;
            if (iq2Var == null) {
                f2 = s.e;
            } else {
                f2 = ul2.U().f(z33.c(iq2Var.i(), s));
            }
            t2(f2.a);
            this.l0.setTitle(f2.b);
            this.y0 = new o(this, new f(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                C2(SwanAppConfigData.t(f2.c));
            }
            String str = f2.c;
        }
    }

    public void V1(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, view2) == null) || view2 == null) {
            return;
        }
        this.l0 = (SwanAppActionBar) view2.findViewById(R.id.obfuscated_res_0x7f09017a);
        this.k0 = view2.findViewById(R.id.obfuscated_res_0x7f09017b);
        this.o0 = view2.findViewById(R.id.obfuscated_res_0x7f0920e4);
        this.l0.setLeftBackViewMinWidth(yd3.f(this.i0, 38.0f));
        g gVar = new g(this);
        this.l0.setLeftBackViewClickListener(gVar);
        this.l0.setLeftFloatBackViewClickListener(gVar);
        this.l0.setRightMenuOnClickListener(new h(this));
        this.l0.setRightExitOnClickListener(new i(this));
    }

    public View W1(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, view2)) == null) {
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
            X1(frameLayout, view2);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public View X1(FrameLayout frameLayout, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, frameLayout, view2)) == null) {
            frameLayout.setTag("IMMERSION_LAYOUT_TAG");
            frameLayout.addView(view2);
            this.t0 = new if3(this.i0, frameLayout);
            v1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            Activity activity = this.i0;
            return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).R() == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            qz1 M1 = M1();
            return M1 != null && M1.k() > 1;
        }
        return invokeV.booleanValue;
    }

    public boolean a2(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 >= 0.0d && d2 <= 1.0d : invokeCommon.booleanValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.x0 == -1 : invokeV.booleanValue;
    }

    public abstract boolean c2();

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(h03.g0()) : invokeV.booleanValue;
    }

    public abstract boolean e2();

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.l0.setLeftHomeViewVisibility(0);
            this.l0.setLeftHomeViewClickListener(new c(this));
        }
    }

    public final void g2(float f2, Fragment fragment) {
        View U;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o2 = yd3.o(this.i0) >> 2;
            float f3 = (f2 * o2) - o2;
            if (fragment == null || (U = fragment.U()) == null) {
                return;
            }
            U.setX(f3);
        }
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            Activity activity = this.i0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).p0(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
        }
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public abstract void j2();

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            O2(false, 1.0f);
        }
    }

    public void l2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048636, this, f2) == null) {
            O2(true, f2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            super.m1(z);
            if (z) {
                p2();
            }
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (nd2.b().c()) {
                nd2.b().f(this.i0, new j(this));
            } else if (pd2.a().b()) {
                z1();
            } else {
                od2 od2Var = new od2();
                od2Var.h();
                if (od2Var.j()) {
                    pd2.a().c(this.i0, od2Var.f(), od2Var.e(), od2Var, F1());
                    return;
                }
                z1();
                vq2.e().g();
            }
        }
    }

    public void n2(wz1 wz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, wz1Var) == null) {
            this.B0.d(wz1Var);
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            Button button = this.r0;
            if (button != null) {
                button.setVisibility(8);
            }
            TextView textView = this.q0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (f63.d()) {
                f63.l(true);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!Y1()) {
                yd3.c(this.i0);
            }
            if (T1() && this.t0 != null && configuration.orientation == 1) {
                getActivity().getWindow().clearFlags(1024);
                be3.f0(new n(this), 200L);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.B0.c();
            super.onPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            super.onResume();
            this.B0.b();
            if (E0) {
                Log.d("SwanAppBaseFragment", "onResume");
            }
            if (R()) {
                p2();
            }
            S2();
            if (this.m0 != null) {
                boolean d2 = oj2.y0().d();
                m64 m64Var = this.m0;
                if (d2 != m64Var.p) {
                    m64Var.y();
                    this.m0.p = oj2.y0().d();
                }
            }
        }
    }

    public void p2() {
        if3 if3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || this.D0 || !T1() || (if3Var = this.t0) == null) {
            return;
        }
        if3Var.l();
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            String C = ul2.U().C();
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, C);
            ul2.U().u(new ia2("closeBtn", hashMap));
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, h03.g0());
            ul2.U().u(new ja2(hashMap));
            hx1.i("SwanAppBaseFragment", "onClose");
            k73 k73Var = new k73();
            k73Var.e = "close";
            A1(k73Var);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, context) == null) {
            if (E0) {
                Log.d("SwanAppBaseFragment", "onAttach");
            }
            this.B0 = new yz1();
            super.s0(context);
            this.i0 = getActivity();
            R1(true);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void s2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048648, this, i2, str) == null) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.l0, "alpha", 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            if3 if3Var = this.t0;
            if (if3Var == null || if3Var.e() == null) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.t0.e(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(linearInterpolator);
            ofFloat2.start();
        }
    }

    public boolean t2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i2)) == null) ? u2(i2, false) : invokeI.booleanValue;
    }

    public boolean u2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048650, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null || this.o0 == null) {
                return false;
            }
            this.x0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            w03 G1 = G1();
            if (G1 != null) {
                G1.a = i2;
                G1.g(z);
            }
            if (T1()) {
                v1();
            }
            if (b2()) {
                this.o0.setVisibility(0);
                return true;
            }
            this.o0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || this.t0 == null) {
            return;
        }
        w1(this.x0);
    }

    @Nullable
    public boolean v2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, str)) == null) ? w2(str, false) : invokeL.booleanValue;
    }

    public void w1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048653, this, i2) == null) || this.t0 == null) {
            return;
        }
        x1(i2, false);
    }

    public boolean w2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048654, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.l0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            w03 G1 = G1();
            if (G1 != null) {
                G1.b = str;
                G1.g(z);
            }
            hx1.i("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void x1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.t0 == null) {
            return;
        }
        this.x0 = i2;
        int i3 = this.w0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = tc3.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.t0.m(i2, z, z2);
    }

    public void x2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.l0.setLeftBackViewVisibility(z);
        }
    }

    public final boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? (J1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true : invokeV.booleanValue;
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            w03 G1 = G1();
            if (G1 != null && (G1.l || G1.m)) {
                h03 b0 = h03.b0();
                if (b0 != null) {
                    b0.e0().g(b0.w(), "scope_disable_swipe_back", new d(this));
                    return;
                } else {
                    this.v0.setCanSlide(y1());
                    return;
                }
            }
            this.v0.setCanSlide(y1());
        }
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || this.i0 == null) {
            return;
        }
        vl2.a().d(false);
        this.i0.moveTaskToBack(true);
        r2();
        ((SwanAppActivity) this.i0).Y(1);
        je3.b().e(2);
    }

    public void z2(boolean z) {
        SlideHelper slideHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048660, this, z) == null) || (slideHelper = this.v0) == null) {
            return;
        }
        slideHelper.setCanSlide(y1() && z);
    }
}
