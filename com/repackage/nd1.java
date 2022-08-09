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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
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
import com.repackage.db1;
import com.repackage.p01;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class nd1 implements yd1, AdView.a, SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String b0;
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
    public boolean N;
    public SensorManager O;
    public boolean P;
    public boolean Q;
    public String R;
    public int S;
    public AtomicBoolean T;
    public float U;
    public LottieAnimationView V;
    public BDSplashActionView W;
    public int X;
    public int Y;
    public float Z;
    public Context a;
    public int a0;
    public int b;
    public ImageView c;
    public ImageView d;
    public AbsCountDownView e;
    public boolean f;
    public boolean g;
    public kd1 h;
    public JSONObject i;
    public JSONObject j;
    public AdView k;
    public he1 l;
    public TextView m;
    public xd1 n;
    public zd1 o;
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
    public class a implements db1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ nd1 c;

        /* renamed from: com.repackage.nd1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0532a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0532a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.c.K();
                }
            }
        }

        public a(nd1 nd1Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nd1Var;
            this.a = i;
            this.b = i2;
        }

        @Override // com.repackage.db1.f
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    try {
                        this.c.V.setVisibility(0);
                        this.c.V.setComposition(lottieComposition);
                        this.c.V.playAnimation();
                        this.c.m(this.c.V, this.a, this.b, "click_float_lottie", this.c.K);
                        this.c.V.setOnClickListener(new View$OnClickListenerC0532a(this));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable unused) {
                    this.c.i.put("displayMantle", true);
                    this.c.s();
                }
            }
        }

        @Override // com.repackage.db1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                nd1 nd1Var = this.c;
                if (nd1Var.b == 2 || nd1Var.a == null) {
                    return;
                }
                try {
                    nd1Var.i.put("displayMantle", true);
                    this.c.s();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public b(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
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
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements db1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;
        public final /* synthetic */ nd1 b;

        /* loaded from: classes6.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float a;
            public float b;
            public final /* synthetic */ d c;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
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
                        float k = p01.c.k(this.c.b.a, motionEvent.getY() - this.b);
                        if (Math.abs(p01.c.k(this.c.b.a, x - this.a)) > this.c.b.S || Math.abs(k) > this.c.b.S) {
                            BaseVM.q("2");
                            this.c.b.K();
                        }
                    } else if (motionEvent.getAction() == 1) {
                        nd1 nd1Var = this.c.b;
                        if (nd1Var.J == 0) {
                            nd1Var.K();
                        }
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }
        }

        public d(nd1 nd1Var, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nd1Var;
            this.a = lottieAnimationView;
        }

        @Override // com.repackage.db1.f
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

        @Override // com.repackage.db1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public e(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
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
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public f(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public g(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Q();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements rd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ nd1 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h hVar = this.a;
                    hVar.c.E(hVar.a, hVar.b);
                }
            }
        }

        public h(nd1 nd1Var, ImageView imageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var, imageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nd1Var;
            this.a = imageView;
            this.b = str;
        }

        @Override // com.repackage.rd1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                this.c.L("Fetch Ad icon image load failed.");
            }
        }

        @Override // com.repackage.rd1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.c.E(this.a, this.b);
                } else {
                    qh0.b(new a(this));
                }
            }
        }

        @Override // com.repackage.rd1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public i(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.N();
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public j(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.N();
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public k(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.U();
                this.a.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public l(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g) {
                this.a.y("time_end");
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
    public class m implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
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
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755473450, "Lcom/repackage/nd1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755473450, "Lcom/repackage/nd1;");
                return;
            }
        }
        b0 = nd1.class.getSimpleName();
    }

    public nd1(Context context, JSONObject jSONObject) {
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
        this.N = false;
        this.P = false;
        this.T = new AtomicBoolean(false);
        this.Z = 1.0f;
        this.a = context.getApplicationContext();
        this.i = jSONObject;
        AdView adView = new AdView(this.a);
        this.k = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.k.setListener(this);
        this.h = new kd1(this.a);
        this.l = new he1(this.a);
        T();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && je1.b && this.a != null) {
            TextView textView = new TextView(this.a);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + je1.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.k.addView(textView, layoutParams);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.x) {
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

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u();
            s();
            k();
            B();
            q();
            p();
            A();
            r();
            n();
            v();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void E(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, imageView, str) == null) || this.k == null || this.a == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(16972527);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            l(imageView, p01.c.a(this.a, 13.0f), p01.c.a(this.a, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            l(imageView, p01.c.a(this.a, 25.0f), p01.c.a(this.a, 13.0f), "ad_logo");
        }
        this.c = (ImageView) this.k.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.k.findViewWithTag("AD_LOGO");
        this.d = imageView2;
        this.f = false;
        if (this.c == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new i(this));
        this.c.setOnClickListener(new j(this));
    }

    public final int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.Y;
            if (i2 <= 0) {
                return 2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.X;
            if (i2 <= 0) {
                return 67;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void H(@NonNull SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sensorEvent) == null) {
            float f2 = sensorEvent.values[1];
            if (this.T.compareAndSet(false, true)) {
                this.U = f2;
            }
            if (Math.abs(f2 - this.U) * 9.0f > this.S) {
                if (te0.a) {
                    xz0.a().showToast(this.k.getContext(), "摇一摇1.0");
                }
                BaseVM.q("1");
                K();
            }
        }
    }

    public final void I(@NonNull SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sensorEvent) == null) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            if (Math.pow(f2, 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d) < Math.pow(this.S, 2.0d)) {
                return;
            }
            if (this.Z * f2 >= 0.0f) {
                this.Z = f2;
                return;
            }
            this.Z = f2;
            int i2 = this.a0 + 1;
            this.a0 = i2;
            if (i2 >= F()) {
                if (te0.a) {
                    xz0.a().showToast(this.k.getContext(), "摇一摇 *3.0*");
                }
                BaseVM.q("7");
                K();
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            AdImageView adImageView = new AdImageView(this.a);
            MaterialLoader.k(this.a).q(adImageView, str, new h(this, adImageView, str));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.P) {
            return;
        }
        xd1 xd1Var = this.n;
        if (xd1Var != null) {
            xd1Var.a();
        }
        X();
        this.P = true;
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            zd1 zd1Var = this.o;
            if (zd1Var != null) {
                zd1Var.onAdError(str);
            }
            X();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            zd1 zd1Var = this.o;
            if (zd1Var != null) {
                zd1Var.d();
            }
            BaseVM.p();
        }
    }

    public void N() {
        xd1 xd1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (xd1Var = this.n) == null) {
            return;
        }
        xd1Var.f();
    }

    public void O() {
        zd1 zd1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (zd1Var = this.o) == null) {
            return;
        }
        zd1Var.g();
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            zd1 zd1Var = this.o;
            if (zd1Var != null) {
                zd1Var.h(str);
            }
            X();
        }
    }

    public void Q() {
        xd1 xd1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (xd1Var = this.n) == null) {
            return;
        }
        xd1Var.b();
    }

    public void R() {
        xd1 xd1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (xd1Var = this.n) == null) {
            return;
        }
        xd1Var.c();
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            xd1 xd1Var = this.n;
            if (xd1Var != null) {
                xd1Var.e();
            }
            X();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
                this.R = this.i.optString("gesture_lottie_url");
                this.M = this.i.optInt("gesture_lottie_type") == 1;
                this.N = this.i.optInt("gesture_lottie_type") == 7;
                this.X = this.i.optInt("shake_update_interval", 0);
                this.Y = this.i.optInt("shake_direction_count", 0);
                boolean z2 = this.i.optInt("gesture_lottie_type") == 2;
                this.L = z2;
                if (!this.M && !this.N && (!z2 || TextUtils.isEmpty(this.R))) {
                    z = false;
                }
                this.Q = z;
                this.S = this.i.optInt("gesture_lottie_sensitivity");
            } catch (Exception unused) {
            }
        }
    }

    public void U() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (absCountDownView = this.e) == null) {
            return;
        }
        absCountDownView.c();
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            qh0.b(new e(this));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b = 2;
            qh0.b(new f(this));
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.c();
            }
        }
    }

    public final void X() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (sensorManager = this.O) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    @Override // com.repackage.yd1
    public void a(zd1 zd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, zd1Var) == null) {
            this.o = zd1Var;
        }
    }

    @Override // com.repackage.yd1
    public void c(xd1 xd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, xd1Var) == null) {
            this.n = xd1Var;
        }
    }

    @Override // com.repackage.yd1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            int optInt = this.i.optInt("ad_label_width", 25);
            int optInt2 = this.i.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.a);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            l(textView, p01.c.a(this.a, optInt), p01.c.a(this.a, optInt2), "label");
        }
    }

    public void j(View view2, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, view2, layoutParams) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || !this.z || this.u || TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.v)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.a);
        cVar.a(this.w, this.v);
        cVar.c(-10066330);
        cVar.b(new g(this));
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        l(relativeLayout, -1, -2, "download_desc");
    }

    public void l(View view2, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            m(view2, i2, i3, str, this.j);
        }
    }

    @Override // com.repackage.yd1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.b = 1;
        }
    }

    public void m(View view2, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.k == null || view2 == null || view2.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.l.g(layoutParams, new ie1().b(jSONObject, str, this.C));
        this.k.addView(view2, layoutParams);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.Q) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.a);
            lottieAnimationView.setFailureListener(new c(this));
            db1.c().b(this.R, new d(this, lottieAnimationView));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || TextUtils.isEmpty(this.G)) {
            return;
        }
        int optInt = this.i.optInt("bottom_logo_height", ie1.a);
        if (optInt != ie1.a) {
            ie1.a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, p01.c.a(this.a, optInt));
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
        if (interceptable == null || interceptable.invokeLI(1048611, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, sensorEvent) == null) || sensorEvent == null || sensorEvent.values == null) {
            return;
        }
        if (this.N) {
            I(sensorEvent);
        } else {
            H(sensorEvent);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.D) {
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
                l(adImageView, p01.c.a(this.a, optInt), p01.c.a(this.a, optInt2), "logo");
            } catch (Throwable unused) {
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.A) {
            String optString = this.i.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                i(optString);
            } else {
                J("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.B) {
                J("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.H = this.i.optString("lottie_url");
            this.I = this.i.optBoolean("lottie_show");
            int optInt = this.i.optInt("ad_click_opt");
            this.J = optInt;
            if (optInt == 1) {
                z();
            }
            if (TextUtils.isEmpty(this.H) || !this.I) {
                return;
            }
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.a);
            this.V = lottieAnimationView;
            lottieAnimationView.setFailureListener(new m(this));
            JSONObject optJSONObject = this.K.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int e2 = (int) (p01.c.e(this.a) * optDouble);
            db1.c().b(this.H, new a(this, e2, (int) (e2 * optDouble2)));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.i.optBoolean("displayMantle", false)) {
            String optString = this.i.optString("mantleActionText");
            int optInt = this.i.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.C);
            aVar.n(new b(this));
            BDSplashActionView k2 = aVar.k(this.a);
            this.W = k2;
            k2.a(this.k);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            try {
                if (this.E == 1) {
                    this.e = new RectangleCountDownView(this.a);
                } else {
                    this.e = new CircleTextProgressbar(this.a);
                }
                this.e.setVisibility(4);
                this.e.setOnClickListener(new k(this));
                this.e.setCountdownProgressListener(new l(this));
                l(this.e, p01.c.a(this.a, this.i.optInt("skip_btn_width", 40)), p01.c.a(this.a, this.i.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.y) {
            TextView textView = new TextView(this.a);
            this.m = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.m.setTextColor(Color.parseColor("#999999"));
            this.m.setTextSize(0, p01.c.a(this.a, 11.0f));
            l(this.m, -2, -2, "wifi_tip");
        }
    }

    public void v() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.M || this.N) {
                if (this.O == null) {
                    try {
                        this.O = (SensorManager) this.a.getSystemService("sensor");
                    } catch (Exception unused) {
                        return;
                    }
                }
                SensorManager sensorManager = this.O;
                if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                    return;
                }
                this.O.registerListener(this, defaultSensor, x());
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            LottieAnimationView lottieAnimationView = this.V;
            if (lottieAnimationView != null) {
                lottieAnimationView.bringToFront();
            }
            BDSplashActionView bDSplashActionView = this.W;
            if (bDSplashActionView != null) {
                bDSplashActionView.bringToFront();
            }
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.bringToFront();
            }
        }
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            int G = G();
            if (G < 0 || G >= 20) {
                if (G < 20 || G >= 67) {
                    return ((G < 67 || G >= 200) && G >= 200) ? 3 : 2;
                }
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            P(str);
        }
    }

    public abstract void z();
}
