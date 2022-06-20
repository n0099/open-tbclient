package com.repackage;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.view.SwanAppLaunchCircleAnimationView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.loading.SwanLoadingTips;
import com.baidu.swan.apps.view.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pc3;
import com.repackage.pk2;
import com.repackage.wz2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes7.dex */
public class ue3 {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static View A;
    public static boolean B;
    public static final boolean y;
    @SuppressLint({"StaticFieldLeak"})
    public static View z;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public SwanAppRoundedImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public RelativeLayout h;
    public BdBaseImageView i;
    public TextView j;
    public View k;
    public on1 l;
    public SwanAppActivity m;
    public View n;
    public SwanLoadingTipsView o;
    public SwanLoadingTips p;
    public TextView q;
    public ValueAnimator r;
    public float s;
    public float t;
    public float u;
    public k v;
    public String w;
    public n02 x;

    /* loaded from: classes7.dex */
    public class a implements pc3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(ue3 ue3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.repackage.pc3.b
        public void a(String str, Bitmap bitmap) {
            SwanAppActivity x;
            ue3 T;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || (x = rz2.K().x()) == null || x.isDestroyed() || (T = x.T()) == null || !TextUtils.equals(this.a, rz2.K().getAppId())) {
                return;
            }
            T.J(bitmap);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ue3.y(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue3 a;

        public c(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e = bd3.e(this.a.m);
                if (!bd3.q(this.a.m, this.a.k) || this.a.m.i0()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.k.getLayoutParams();
                layoutParams.topMargin = this.a.k.getTop() + e;
                this.a.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue3 a;

        public d(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.q == null) {
                return;
            }
            this.a.q.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue3 a;

        public e(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e = bd3.e(this.a.m);
                if (!bd3.q(this.a.m, this.a.k) || this.a.m.i0()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.k.getLayoutParams();
                layoutParams.topMargin = this.a.k.getTop() + e;
                this.a.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue3 a;

        public f(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.D();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue3 a;

        public g(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue3 a;

        public h(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.m == null || this.a.m.isFinishing()) {
                return;
            }
            HybridUbcFlow m = xs2.m();
            if (m != null) {
                m.D("exitType", String.valueOf(3));
                m.E("value", "cancel");
                m.n();
            }
            this.a.m.moveTaskToBack(true);
            ud3.b().e(2);
            this.a.q();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ue3 b;

        public i(ue3 ue3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ue3Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (ue3.class) {
                    xs2.o().F(new UbcFlowEvent("first_anim_end"));
                    s53.d().i("first_anim_end");
                    if (this.b.l != null) {
                        this.b.l.l(this.b.m, this.a);
                    }
                    boolean unused = ue3.B = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue3 a;

        public j(ue3 ue3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue3Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue > 0.9f || floatValue - this.a.t > 0.05d) {
                    this.a.t = floatValue;
                    this.a.M();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final String b;
        public boolean c;
        public boolean d;
        public final pz2 e;
        public int f;
        public int g;
        public boolean h;
        public final /* synthetic */ ue3 i;

        /* loaded from: classes7.dex */
        public class a implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar, ue3 ue3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ue3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (ue3.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    this.a.g = aVar.i("KEY_PRELOAD_STATE");
                    this.a.e();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(k kVar, ue3 ue3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ue3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && ue3.y) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(k kVar, ue3 ue3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ue3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && ue3.y) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public d(k kVar, ue3 ue3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ue3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (ue3.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    this.a.h = true;
                    this.a.e();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class e implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public e(k kVar, ue3 ue3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ue3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && ue3.y) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                }
            }
        }

        /* loaded from: classes7.dex */
        public class f implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public f(k kVar, ue3 ue3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ue3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (ue3.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    this.a.f = aVar.j("KEY_PKG_STATE", -1);
                    this.a.e();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class g implements le3<wz2.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public g(k kVar, ue3 ue3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ue3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.le3
            /* renamed from: b */
            public void a(wz2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (ue3.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    this.a.f = aVar.j("KEY_PKG_STATE", -1);
                    this.a.e();
                }
            }
        }

        public k(ue3 ue3Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = ue3Var;
            this.c = false;
            this.d = false;
            this.f = -1;
            this.b = str;
            this.a = z;
            pz2 pz2Var = new pz2();
            pz2Var.f(new g(this, ue3Var), "event_pms_check_start");
            pz2Var.f(new f(this, ue3Var), "event_pms_check_finish");
            pz2Var.f(new e(this, ue3Var), "event_pkg_download_start");
            pz2Var.f(new d(this, ue3Var), "event_pkg_download_finish");
            pz2Var.f(new c(this, ue3Var), "event_preload_start");
            pz2Var.f(new b(this, ue3Var), "event_preload_error");
            pz2Var.f(new a(this, ue3Var), "event_preload_finish");
            this.e = pz2Var;
            rz2.K().v(this.e);
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean j = j();
                boolean g2 = g();
                boolean i = i();
                if (ue3.y) {
                    Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + j);
                    Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + g2);
                    Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + i);
                }
                if (j || g2 || !i) {
                    this.i.M();
                }
            }
        }

        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (ue3.y) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewStarter exec : post = ");
                    sb.append(z);
                    sb.append(" trace = ");
                    sb.append(z ? "post" : Log.getStackTraceString(new Exception()));
                    Log.i("SwanAppLoadingView", sb.toString());
                }
                this.d = true;
                boolean z2 = this.a;
                if (z2) {
                    this.i.x(z2, this.c);
                } else {
                    this.i.w(z2, this.c);
                }
            }
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                boolean h = h();
                boolean i = i();
                boolean z = h && i;
                if (ue3.y) {
                    Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + h);
                    Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + i);
                    Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.f;
                boolean z = true;
                if (i != 3 && i != 1) {
                    z = false;
                }
                if (ue3.y) {
                    Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean m0 = m62.U().m0();
                if (ue3.y) {
                    Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + m0);
                }
                return m0;
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                boolean z = this.f == 4;
                boolean i = i();
                if (ue3.y) {
                    Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                    Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + i);
                }
                return z && !i;
            }
            return invokeV.booleanValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (ue3.y) {
                    Log.i("SwanAppLoadingView", "onDestroy: ");
                }
                rz2.K().p(this.e);
            }
        }

        public k l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.c = true;
                return this;
            }
            return (k) invokeV.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                f(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755263890, "Lcom/repackage/ue3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755263890, "Lcom/repackage/ue3;");
                return;
            }
        }
        y = cg1.a;
        B = false;
    }

    public ue3(SwanAppActivity swanAppActivity) {
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
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.w = "";
        this.m = swanAppActivity;
        this.x = new n02();
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            z = null;
            A = null;
        }
    }

    public static View p(Context context, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65553, null, context, z2)) == null) {
            try {
                return LayoutInflater.from(context).inflate(z2 ? R.layout.obfuscated_res_0x7f0d0088 : R.layout.obfuscated_res_0x7f0d00b5, (ViewGroup) null);
            } catch (Exception e2) {
                if (y) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (View) invokeLZ.objValue;
    }

    public static void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            if (z == null) {
                z = p(context, false);
            }
            if (A == null) {
                A = p(context, true);
            }
            if (y) {
                Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + z + " Game=" + A);
            }
        }
    }

    public static void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            md3.f0(new b(context), 5000L);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.setOnClickListener(new h(this));
        }
    }

    public final void C(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.q == null || this.u > f2) {
            return;
        }
        this.u = f2;
        if (y) {
            Log.i("SwanAppLoadingView", "setProgressText: " + this.u);
        }
        int i2 = (int) (1000.0f * f2);
        String str = ((i2 / 10) + (i2 % 10 >= 5 ? 1 : 0)) + "%";
        String trim = this.w.trim();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trim)) {
            sb.append(trim);
            sb.append(" ");
        }
        sb.append(str);
        k kVar = this.v;
        if (kVar != null && !kVar.a) {
            if (kVar.j()) {
                if (y) {
                    Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                }
            } else if (!this.v.h() || this.u > 0.0f) {
                if (this.v.h && !this.v.i()) {
                    if (y) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.q.setVisibility(4);
                } else if (this.u >= 1.0f && !this.v.i()) {
                    if (y) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.q.setVisibility(4);
                } else {
                    this.q.setText(sb);
                }
            } else {
                if (y) {
                    Log.i("SwanAppLoadingView", "setProgressText: checking update");
                }
                this.q.setVisibility(4);
            }
        } else {
            this.q.setText(sb);
        }
        if (f2 == 1.0f) {
            this.q.setVisibility(4);
        }
    }

    public final void D() {
        SwanLoadingTips swanLoadingTips;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.o == null || (swanLoadingTips = this.p) == null) {
            return;
        }
        this.o.e(swanLoadingTips.b());
    }

    public void E(boolean z2, boolean z3, @Nullable wz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), aVar}) == null) {
            this.x.f();
            String V = rz2.K().r().W().V();
            k kVar = this.v;
            boolean z4 = true;
            boolean z5 = kVar == null || (kVar.a ^ z2) || TextUtils.isEmpty(V) || !TextUtils.equals(V, this.v.b);
            if (y) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + V + " newIsGameLoading = " + z2 + " reCreateStarter = " + z5 + " mViewStarter = " + this.v);
            }
            Handler M = rz2.M();
            if (this.v != null) {
                if (y) {
                    Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.v.b + " oldIsGameLoading = " + this.v.a);
                }
                M.removeCallbacks(this.v);
            }
            if (z5) {
                this.v = new k(this, V, z2);
            }
            if (this.v == null) {
                return;
            }
            z4 = (aVar == null || !aVar.e(" event_params_pkg_update", false)) ? false : false;
            k kVar2 = this.v;
            if (kVar2.d) {
                if (y) {
                    Log.i("SwanAppLoadingView", "showSwanAppStartView: return by executing pkgUpdating = " + z4 + " trace = " + Log.getStackTraceString(new Exception()));
                }
                if (z4) {
                    N(z2, z4);
                    return;
                }
                return;
            }
            if (z4) {
                kVar2.l();
            }
            if (z3) {
                this.v.f(false);
                return;
            }
            if (y) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            M.post(this.v);
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            Handler M = rz2.M();
            k kVar = this.v;
            if (kVar != null) {
                M.removeCallbacks(kVar);
                this.v.k();
                this.v = null;
            }
            M.post(new i(this, i2));
        }
    }

    public void G(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.r.removeAllUpdateListeners();
        }
        N(z2, z3);
        this.t = 0.0f;
        this.s = 0.0f;
        this.u = 0.0f;
        if (z2) {
            M();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.r = ofFloat;
            ofFloat.addUpdateListener(new j(this));
            this.r.setDuration(4000L);
            this.r.start();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (y) {
                Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
            }
            Handler M = rz2.M();
            k kVar = this.v;
            if (kVar != null) {
                M.removeCallbacks(kVar);
                this.v.k();
                this.v = null;
            }
            synchronized (ue3.class) {
                if (this.l != null) {
                    this.l.n();
                }
                if (this.o != null) {
                    this.o.c();
                    this.o = null;
                }
                if (this.q != null) {
                    this.q.setVisibility(8);
                    this.q = null;
                    this.w = "";
                    this.t = 0.0f;
                    this.s = 0.0f;
                    this.u = 0.0f;
                }
                if (this.r != null) {
                    this.r.removeAllUpdateListeners();
                    this.r.cancel();
                    this.r = null;
                }
                B = false;
                if (this.v != null) {
                    this.v.k();
                    this.v = null;
                }
            }
        }
    }

    public void I(String str) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (y) {
                Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
            }
            String appId = rz2.K().getAppId();
            if (!B || (swanAppRoundedImageView = this.c) == null) {
                return;
            }
            swanAppRoundedImageView.setImageBitmap(md3.k(str, "SwanAppLoadingView", true, new a(this, appId)));
        }
    }

    public final void J(Bitmap bitmap) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) || bitmap == null || (swanAppRoundedImageView = this.c) == null || swanAppRoundedImageView == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(bitmap);
    }

    public void K(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || !B || TextUtils.isEmpty(str) || (textView = this.b) == null) {
            return;
        }
        textView.setText(str);
    }

    public void L(int i2) {
        View view2;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 != PMSConstants.PayProtected.PAY_PROTECTED.type || (view2 = this.a) == null || (relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ca3)) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
    }

    public final void M() {
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.q == null) {
            return;
        }
        float o = o(this.t, this.s);
        if (o > 1.0f) {
            o = 1.0f;
        }
        C(o);
        if (o <= 0.0f || rz2.K().l() == 1 || (swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) this.m.findViewById(R.id.obfuscated_res_0x7f090001)) == null) {
            return;
        }
        swanAppLaunchCircleAnimationView.j(o);
    }

    public final void N(boolean z2, boolean z3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (textView = this.q) == null) {
            return;
        }
        if (!z2) {
            this.w = textView.getContext().getString(R.string.obfuscated_res_0x7f0f1289);
        } else {
            this.w = "";
        }
    }

    public final float o(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ((1.0f - f2) * f3) + f2 : invokeCommon.floatValue;
    }

    public final void q() {
        pk2.a S;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (S = this.m.S()) == null || (P = S.P()) == null) {
            return;
        }
        long j2 = P.getLong("page_display_flag_for_statistic");
        P.remove("page_display_flag_for_statistic");
        if (j2 <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - S.l("launch_time", 0L));
        v63 v63Var = new v63();
        v63Var.b = "launch";
        v63Var.e = "realcancel";
        v63Var.q = valueOf;
        v63Var.a("reason", "close");
        if (S.G() == 1) {
            v63Var.a("errorList", aj2.j().a());
        }
        this.m.N(v63Var);
        c63.q(S);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SwanLoadingTipsView swanLoadingTipsView = (SwanLoadingTipsView) this.a.findViewById(R.id.obfuscated_res_0x7f0901a8);
            this.o = swanLoadingTipsView;
            swanLoadingTipsView.setTipsAnimationFinishCallback(new f(this));
            this.p = new SwanLoadingTips();
            this.a.addOnAttachStateChangeListener(new g(this));
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            jd3.M(this.i, this.j, String.valueOf(i2));
        }
    }

    public final View t(Context context, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048593, this, context, z2)) == null) {
            View view2 = z2 ? A : z;
            if (z2) {
                A = null;
            } else {
                z = null;
            }
            boolean z3 = (view2 == null || view2.isAttachedToWindow()) ? false : true;
            if (!z3) {
                view2 = p(context, z2);
            }
            if (y) {
                Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z3 + " game=" + z2 + " container=" + view2);
            }
            return view2;
        }
        return (View) invokeLZ.objValue;
    }

    public void u(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            if (y) {
                Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f2 + " view: " + this.q);
            }
            this.x.d();
            if (this.q == null) {
                return;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.s = f2;
            M();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.r.cancel();
            this.r = null;
        }
        C(1.0f);
    }

    public final void w(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (ue3.class) {
                if (this.l == null) {
                    this.l = new on1();
                }
                View t = t(this.m, z2);
                this.a = t;
                if (!z2) {
                    t.setPadding(0, oy2.b ? jd3.t() : 0, 0, 0);
                } else {
                    r();
                }
                Handler M = rz2.M();
                pk2.a W = rz2.K().r().W();
                this.m.c().n(this.a);
                B = true;
                this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09205c);
                this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09205b);
                this.k = this.a.findViewById(R.id.obfuscated_res_0x7f09205a);
                if (z2) {
                    this.f.setClickable(true);
                    this.f.setImageResource(R.drawable.obfuscated_res_0x7f080123);
                    this.g.setImageResource(R.drawable.obfuscated_res_0x7f08010e);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f08011f);
                    View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f09205d);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(R.color.obfuscated_res_0x7f06037a);
                    this.k.post(new c(this));
                } else {
                    this.f.setImageResource(R.drawable.obfuscated_res_0x7f080117);
                    this.g.setImageResource(R.drawable.obfuscated_res_0x7f08010b);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f08011e);
                    L(W.p1());
                }
                this.q = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09019a);
                M.postDelayed(new d(this), 2000L);
                G(z2, z3);
                TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901a4);
                this.b = textView;
                textView.getPaint().setFakeBoldText(true);
                this.c = (SwanAppRoundedImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090195);
                this.i = (BdBaseImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090198);
                this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090199);
                this.h = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090196);
                K(W.K());
                I(W.Q());
                s(W.getType());
                this.l.j(this.m);
                B();
            }
        }
    }

    public final void x(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (ue3.class) {
                if (this.l == null) {
                    this.l = new on1();
                }
                View t = t(this.m, z2);
                this.a = t;
                if (!z2) {
                    t.setPadding(0, oy2.b ? jd3.t() : 0, 0, 0);
                } else {
                    r();
                }
                this.q = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09019a);
                pk2.a W = rz2.K().r().W();
                W.f0();
                G(z2, z3);
                this.m.c().n(this.a);
                B = true;
                this.b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901a4);
                this.c = (SwanAppRoundedImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090195);
                this.i = (BdBaseImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090198);
                this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090199);
                this.h = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090196);
                K(W.K());
                I(W.Q());
                s(W.getType());
                this.d = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091205);
                this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09072a);
                this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09205c);
                this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09205b);
                this.k = this.a.findViewById(R.id.obfuscated_res_0x7f09205a);
                if (z2) {
                    this.f.setClickable(true);
                    this.f.setImageResource(R.drawable.obfuscated_res_0x7f080123);
                    this.g.setImageResource(R.drawable.obfuscated_res_0x7f08010e);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f08011f);
                    View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f09205d);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(R.color.obfuscated_res_0x7f06037a);
                    this.k.post(new e(this));
                } else {
                    this.f.setImageResource(R.drawable.obfuscated_res_0x7f080117);
                    this.g.setImageResource(R.drawable.obfuscated_res_0x7f08010b);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f08011e);
                    L(W.p1());
                }
                this.e.setAlpha(0.0f);
                this.l.m(this.m);
                B();
            }
        }
    }
}
