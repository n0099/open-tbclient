package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.sdk.container.widget.BDSplashActionView;
import com.baidu.sdk.container.widget.CircleTextProgressbar;
import com.baidu.sdk.container.widget.DisplayInfoView;
import com.baidu.sdk.container.widget.RectangleCountDownView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.repackage.ab1;
import com.repackage.m11;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class jd1 implements ud1, AdView.a, SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String W;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public String G;
    public String H;
    public boolean I;
    public int J;
    public JSONObject K;
    public boolean L;
    public boolean M;
    public SensorManager N;
    public boolean O;
    public boolean P;
    public String Q;
    public int R;
    public AtomicBoolean S;
    public float T;
    public LottieAnimationView U;
    public BDSplashActionView V;
    public Context a;
    public int b;
    public ImageView c;
    public ImageView d;
    public AbsCountDownView e;
    public boolean f;
    public boolean g;
    public gd1 h;
    public JSONObject i;
    public JSONObject j;
    public AdView k;
    public de1 l;
    public TextView m;
    public td1 n;
    public vd1 o;
    public int p;
    public String q;
    public String r;
    public int s;
    public String t;
    public boolean u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public a(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.F();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ab1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;
        public final /* synthetic */ jd1 b;

        /* loaded from: classes6.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float a;
            public float b;
            public final /* synthetic */ b c;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.a = motionEvent.getX();
                        this.b = motionEvent.getY();
                    } else if (motionEvent.getAction() == 2) {
                        float x = motionEvent.getX();
                        float k = m11.c.k(this.c.b.a, motionEvent.getY() - this.b);
                        if (Math.abs(m11.c.k(this.c.b.a, x - this.a)) > this.c.b.R || Math.abs(k) > this.c.b.R) {
                            BaseVM.p("2");
                            this.c.b.F();
                        }
                    } else if (motionEvent.getAction() == 1) {
                        jd1 jd1Var = this.c.b;
                        if (jd1Var.J == 0) {
                            jd1Var.F();
                        }
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }
        }

        public b(jd1 jd1Var, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jd1Var;
            this.a = lottieAnimationView;
        }

        @Override // com.repackage.ab1.f
        @SuppressLint({"ClickableViewAccessibility"})
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    this.a.setVisibility(0);
                    this.a.setComposition(lottieComposition);
                    this.a.playAnimation();
                    this.a.setRepeatCount(-1);
                    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (this.a != null && (this.a.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.getParent()).removeView(this.a);
                    }
                    this.b.k.addView(this.a, layoutParams);
                    this.b.w();
                    if (this.b.L) {
                        this.a.setOnTouchListener(new a(this));
                    }
                } catch (Throwable unused) {
                    this.a.setVisibility(8);
                }
            }
        }

        @Override // com.repackage.ab1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public c(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public d(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public e(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.L();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jd1 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.a;
                    fVar.c.D(fVar.a, fVar.b);
                }
            }
        }

        public f(jd1 jd1Var, ImageView imageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var, imageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jd1Var;
            this.a = imageView;
            this.b = str;
        }

        @Override // com.repackage.nd1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                this.c.G("Fetch Ad icon image load failed.");
            }
        }

        @Override // com.repackage.nd1
        public void b(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.c.D(this.a, this.b);
                } else {
                    vi0.b(new a(this));
                }
            }
        }

        @Override // com.repackage.nd1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public g(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.I();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public h(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.I();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public i(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.P();
                this.a.N();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd1 a;

        public j(jd1 jd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd1Var;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g) {
                this.a.x("time_end");
            }
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ab1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ jd1 c;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.c.F();
                }
            }
        }

        public k(jd1 jd1Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd1Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jd1Var;
            this.a = i;
            this.b = i2;
        }

        @Override // com.repackage.ab1.f
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    try {
                        this.c.U.setVisibility(0);
                        this.c.U.setComposition(lottieComposition);
                        this.c.U.playAnimation();
                        this.c.m(this.c.U, this.a, this.b, "click_float_lottie", this.c.K);
                        this.c.U.setOnClickListener(new a(this));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable unused) {
                    this.c.i.put("displayMantle", true);
                    this.c.s();
                }
            }
        }

        @Override // com.repackage.ab1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jd1 jd1Var = this.c;
                if (jd1Var.b == 2 || jd1Var.a == null) {
                    return;
                }
                try {
                    jd1Var.i.put("displayMantle", true);
                    this.c.s();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755592614, "Lcom/repackage/jd1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755592614, "Lcom/repackage/jd1;");
                return;
            }
        }
        W = jd1.class.getSimpleName();
    }

    public jd1(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = null;
        this.d = null;
        this.f = false;
        this.p = 4;
        this.q = "";
        this.r = "image";
        this.s = 5000;
        this.t = "";
        this.x = true;
        this.y = false;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = false;
        this.F = 16;
        this.L = false;
        this.M = false;
        this.O = false;
        this.S = new AtomicBoolean(false);
        this.a = context.getApplicationContext();
        this.i = jSONObject;
        AdView adView = new AdView(this.a);
        this.k = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.k.setListener(this);
        this.h = new gd1(this.a);
        this.l = new de1(this.a);
        O();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.x) {
            t();
            this.e.setTimeMillis(this.s);
            this.e.b();
            int i2 = this.p;
            if (i2 == 5) {
                this.e.setVisibility(0);
            } else if (i2 == 1) {
                this.e.setVisibility(0);
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u();
            s();
            k();
            A();
            q();
            p();
            z();
            r();
            n();
            v();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void D(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, imageView, str) == null) || this.k == null || this.a == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(16972527);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            l(imageView, m11.c.a(this.a, 13.0f), m11.c.a(this.a, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            l(imageView, m11.c.a(this.a, 25.0f), m11.c.a(this.a, 13.0f), "ad_logo");
        }
        this.c = (ImageView) this.k.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.k.findViewWithTag("AD_LOGO");
        this.d = imageView2;
        this.f = false;
        if (this.c == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new g(this));
        this.c.setOnClickListener(new h(this));
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            AdImageView adImageView = new AdImageView(this.a);
            MaterialLoader.k(this.a).q(adImageView, str, new f(this, adImageView, str));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.O) {
            return;
        }
        td1 td1Var = this.n;
        if (td1Var != null) {
            td1Var.b();
        }
        S();
        this.O = true;
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            vd1 vd1Var = this.o;
            if (vd1Var != null) {
                vd1Var.onAdError(str);
            }
            S();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            vd1 vd1Var = this.o;
            if (vd1Var != null) {
                vd1Var.d();
            }
            BaseVM.o();
        }
    }

    public void I() {
        td1 td1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (td1Var = this.n) == null) {
            return;
        }
        td1Var.f();
    }

    public void J() {
        vd1 vd1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (vd1Var = this.o) == null) {
            return;
        }
        vd1Var.g();
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            vd1 vd1Var = this.o;
            if (vd1Var != null) {
                vd1Var.h(str);
            }
            S();
        }
    }

    public void L() {
        td1 td1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (td1Var = this.n) == null) {
            return;
        }
        td1Var.a();
    }

    public void M() {
        td1 td1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (td1Var = this.n) == null) {
            return;
        }
        td1Var.c();
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            td1 td1Var = this.n;
            if (td1Var != null) {
                td1Var.e();
            }
            S();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                this.q = this.i.optString("prod");
                this.t = this.i.optString("material_url");
                this.j = this.i.optJSONObject("style");
                this.K = this.i.optJSONObject("inner_style");
                boolean z = true;
                this.g = this.i.optBoolean("countDownNew", true);
                this.z = this.i.optBoolean("Display_Down_Info");
                this.u = this.i.optBoolean("popDialogIfDl", false);
                this.v = this.i.optString("publisher");
                this.w = this.i.optString("app_version");
                this.y = this.i.optBoolean("show_wifi_view", "video".equals(this.r));
                this.x = this.i.optBoolean("show_skip", "rsplash".equals(this.q));
                this.s = this.i.optInt("skipTime", 5000);
                this.A = this.i.optBoolean("hide_ad_logo", true);
                this.B = this.i.optBoolean("hide_bd_logo", false);
                this.C = this.i.optBoolean("full_screen", true);
                this.D = this.i.optBoolean("show_host_small_logo", false);
                this.E = this.i.optInt("skip_btn_type");
                this.p = this.i.optInt("close_type");
                this.F = this.i.optInt("bitmapDisplayMode");
                this.G = this.i.optString("host_big_logo_res_id");
                this.Q = this.i.optString("gesture_lottie_url");
                this.M = this.i.optInt("gesture_lottie_type") == 1;
                boolean z2 = this.i.optInt("gesture_lottie_type") == 2;
                this.L = z2;
                if (!this.M && (!z2 || TextUtils.isEmpty(this.Q))) {
                    z = false;
                }
                this.P = z;
                this.R = this.i.optInt("gesture_lottie_sensitivity");
            } catch (Exception unused) {
            }
        }
    }

    public void P() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (absCountDownView = this.e) == null) {
            return;
        }
        absCountDownView.c();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            vi0.b(new c(this));
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.b = 2;
            vi0.b(new d(this));
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.c();
            }
        }
    }

    public final void S() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (sensorManager = this.N) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    @Override // com.repackage.ud1
    public void a(vd1 vd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vd1Var) == null) {
            this.o = vd1Var;
        }
    }

    @Override // com.repackage.ud1
    public void c(td1 td1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, td1Var) == null) {
            this.n = td1Var;
        }
    }

    @Override // com.repackage.ud1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            int optInt = this.i.optInt("ad_label_width", 25);
            int optInt2 = this.i.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.a);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            l(textView, m11.c.a(this.a, optInt), m11.c.a(this.a, optInt2), "label");
        }
    }

    public void j(View view2, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view2, layoutParams) == null) {
            if (this.C) {
                this.k.addView(view2, layoutParams);
                return;
            }
            o();
            layoutParams.addRule(2, 15);
            this.k.addView(view2, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || !this.z || this.u || TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.v)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.a);
        cVar.a(this.w, this.v);
        cVar.c(-10066330);
        cVar.b(new e(this));
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        l(relativeLayout, -1, -2, "download_desc");
    }

    public void l(View view2, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            m(view2, i2, i3, str, this.j);
        }
    }

    @Override // com.repackage.ud1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.b = 1;
        }
    }

    public void m(View view2, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.k == null || view2 == null || view2.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.l.g(layoutParams, new ee1().b(jSONObject, str, this.C));
        this.k.addView(view2, layoutParams);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.P) {
            ab1.c().b(this.Q, new b(this, new LottieAnimationView(this.a)));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || TextUtils.isEmpty(this.G)) {
            return;
        }
        int optInt = this.i.optInt("bottom_logo_height", ee1.a);
        if (optInt != ee1.a) {
            ee1.a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, m11.c.a(this.a, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            AdImageView adImageView = new AdImageView(this.a);
            adImageView.setImageResource(Integer.parseInt(this.G));
            adImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            relativeLayout.setClickable(true);
            relativeLayout.addView(adImageView, layoutParams2);
            this.k.addView(relativeLayout, layoutParams);
        } catch (Throwable unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, sensorEvent) == null) {
            float f2 = sensorEvent.values[1];
            if (this.S.compareAndSet(false, true)) {
                this.T = f2;
            }
            if (Math.abs(f2 - this.T) * 9.0f > this.R) {
                BaseVM.p("1");
                F();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.D) {
            String optString = this.i.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.i.optInt("small_logo_width", -2);
            int optInt2 = this.i.optInt("small_logo_height", -2);
            try {
                AdImageView adImageView = new AdImageView(this.a);
                adImageView.setImageResource(Integer.parseInt(optString));
                adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                l(adImageView, m11.c.a(this.a, optInt), m11.c.a(this.a, optInt2), "logo");
            } catch (Throwable unused) {
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.A) {
            String optString = this.i.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                i(optString);
            } else {
                E("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.B) {
                E("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.H = this.i.optString("lottie_url");
            this.I = this.i.optBoolean("lottie_show");
            int optInt = this.i.optInt("ad_click_opt");
            this.J = optInt;
            if (optInt == 1) {
                y();
            }
            if (TextUtils.isEmpty(this.H) || !this.I) {
                return;
            }
            this.U = new LottieAnimationView(this.a);
            JSONObject optJSONObject = this.K.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int e2 = (int) (m11.c.e(this.a) * optDouble);
            ab1.c().b(this.H, new k(this, e2, (int) (e2 * optDouble2)));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.i.optBoolean("displayMantle", false)) {
            String optString = this.i.optString("mantleActionText");
            int optInt = this.i.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.C);
            aVar.n(new a(this));
            BDSplashActionView k2 = aVar.k(this.a);
            this.V = k2;
            k2.a(this.k);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            try {
                if (this.E == 1) {
                    this.e = new RectangleCountDownView(this.a);
                } else {
                    this.e = new CircleTextProgressbar(this.a);
                }
                this.e.setVisibility(4);
                this.e.setOnClickListener(new i(this));
                this.e.setCountdownProgressListener(new j(this));
                l(this.e, m11.c.a(this.a, this.i.optInt("skip_btn_width", 40)), m11.c.a(this.a, this.i.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.y) {
            TextView textView = new TextView(this.a);
            this.m = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.m.setTextColor(Color.parseColor("#999999"));
            this.m.setTextSize(0, m11.c.a(this.a, 11.0f));
            l(this.m, -2, -2, "wifi_tip");
        }
    }

    public void v() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.M) {
            if (this.N == null) {
                try {
                    this.N = (SensorManager) this.a.getSystemService("sensor");
                } catch (Exception unused) {
                    return;
                }
            }
            SensorManager sensorManager = this.N;
            if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                return;
            }
            this.N.registerListener(this, defaultSensor, 2);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            LottieAnimationView lottieAnimationView = this.U;
            if (lottieAnimationView != null) {
                lottieAnimationView.bringToFront();
            }
            BDSplashActionView bDSplashActionView = this.V;
            if (bDSplashActionView != null) {
                bDSplashActionView.bringToFront();
            }
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.bringToFront();
            }
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            K(str);
        }
    }

    public abstract void y();

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && fe1.b && this.a != null) {
            TextView textView = new TextView(this.a);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + fe1.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.k.addView(textView, layoutParams);
        }
    }
}
