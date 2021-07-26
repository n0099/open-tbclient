package d.a.i0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.sdk.internal.ScreenUtils;
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
import d.a.f0.a.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a implements d.a.i0.a.g.b, AdView.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String M = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public String H;
    public String I;
    public boolean J;
    public int K;
    public JSONObject L;

    /* renamed from: a  reason: collision with root package name */
    public Context f42947a;

    /* renamed from: b  reason: collision with root package name */
    public int f42948b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f42949c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f42950d;

    /* renamed from: e  reason: collision with root package name */
    public AbsCountDownView f42951e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.i0.a.k.b f42952f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42953g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42954h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.a.c.b f42955i;
    public JSONObject j;
    public JSONObject k;
    public AdView l;
    public d.a.i0.a.j.a m;
    public TextView n;
    public d.a.i0.a.g.a o;
    public d.a.i0.a.g.c p;
    public int q;
    public String r;
    public String s;
    public int t;
    public String u;
    public boolean v;
    public String w;
    public String x;
    public boolean y;
    public boolean z;

    /* renamed from: d.a.i0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC0605a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42956e;

        public View$OnClickListenerC0605a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42956e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42956e.C();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42957e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42957e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42957e.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42958e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42958e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42958e.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42959a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42959a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPermissionClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42959a.I();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPrivacyClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f42959a.J();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.i0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f42960a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42961b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f42962c;

        /* renamed from: d.a.i0.a.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0606a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f42963e;

            public RunnableC0606a(e eVar) {
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
                this.f42963e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f42963e;
                    eVar.f42962c.A(eVar.f42960a, eVar.f42961b);
                }
            }
        }

        public e(a aVar, ImageView imageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, imageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42962c = aVar;
            this.f42960a = imageView;
            this.f42961b = str;
        }

        @Override // d.a.i0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                this.f42962c.D("Fetch Ad icon image load failed.");
            }
        }

        @Override // d.a.i0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.f42962c.A(this.f42960a, this.f42961b);
                } else {
                    d.a.i0.a.k.a.a(new RunnableC0606a(this));
                }
            }
        }

        @Override // d.a.i0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42964e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42964e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42964e.f42953g) {
                return;
            }
            this.f42964e.f42953g = true;
            this.f42964e.F();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42965e;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42965e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42965e.f42953g) {
                return;
            }
            this.f42965e.f42953g = true;
            this.f42965e.F();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f42966e;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42966e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42966e.pause();
                this.f42966e.K();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42967a;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42967a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f42967a.f42954h) {
                this.f42967a.u("time_end");
            }
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f42968a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f42969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f42970c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f42971d;

        /* renamed from: d.a.i0.a.d.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC0607a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f42972e;

            public View$OnClickListenerC0607a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42972e = jVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f42972e.f42971d.C();
                }
            }
        }

        public j(a aVar, LottieAnimationView lottieAnimationView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lottieAnimationView, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42971d = aVar;
            this.f42968a = lottieAnimationView;
            this.f42969b = i2;
            this.f42970c = i3;
        }

        @Override // d.a.f0.a.c.b.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f42971d;
                aVar.m(this.f42968a, this.f42969b, this.f42970c, "click_float_lottie", aVar.L);
                this.f42968a.setOnClickListener(new View$OnClickListenerC0607a(this));
            }
        }

        @Override // d.a.f0.a.c.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a aVar = this.f42971d;
                if (aVar.f42948b == 2 || aVar.f42947a == null) {
                    return;
                }
                try {
                    aVar.j.put("displayMantle", true);
                    this.f42971d.r();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1885296010, "Ld/a/i0/a/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1885296010, "Ld/a/i0/a/d/a;");
        }
    }

    public a(Context context, JSONObject jSONObject) {
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
        this.f42948b = 0;
        this.f42949c = null;
        this.f42950d = null;
        this.f42953g = false;
        this.q = 4;
        this.r = "";
        this.s = "image";
        this.t = 5000;
        this.u = "";
        this.y = true;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = false;
        this.G = 16;
        this.f42947a = context.getApplicationContext();
        this.j = jSONObject;
        this.f42952f = d.a.i0.a.k.b.i();
        AdView adView = new AdView(this.f42947a);
        this.l = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.l.setListener(this);
        this.f42955i = new d.a.i0.a.c.b(this.f42947a);
        this.m = new d.a.i0.a.j.a(this.f42947a);
        L();
    }

    public final void A(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || this.l == null || this.f42947a == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(XBaseAdContainer.Baidu_Ad_IMG_ID);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            l(imageView, d.a.i0.a.k.h.a(this.f42947a, 13.0f), d.a.i0.a.k.h.a(this.f42947a, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            l(imageView, d.a.i0.a.k.h.a(this.f42947a, 25.0f), d.a.i0.a.k.h.a(this.f42947a, 13.0f), "ad_logo");
        }
        this.f42949c = (ImageView) this.l.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.l.findViewWithTag("AD_LOGO");
        this.f42950d = imageView2;
        this.f42953g = false;
        if (this.f42949c == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new f(this));
        this.f42949c.setOnClickListener(new g(this));
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            ImageView imageView = new ImageView(this.f42947a);
            MaterialLoader.k(this.f42947a).q(imageView, str, new e(this, imageView, str));
        }
    }

    public void C() {
        d.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onAdClick();
    }

    public void D(String str) {
        d.a.i0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdError(str);
    }

    public void E() {
        d.a.i0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdLoad();
    }

    public void F() {
        d.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onAdLogoClick();
    }

    public void G() {
        d.a.i0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdStart();
    }

    public void H(String str) {
        d.a.i0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdStop(str);
    }

    public void I() {
        d.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onPermissionClick();
    }

    public void J() {
        d.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onPrivacyClick();
    }

    public void K() {
        d.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onSkipClick();
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                this.r = this.j.optString("prod");
                this.u = this.j.optString("material_url");
                this.k = this.j.optJSONObject("style");
                this.L = this.j.optJSONObject("inner_style");
                this.f42954h = this.j.optBoolean("countDownNew", true);
                this.A = this.j.optBoolean("Display_Down_Info");
                this.v = this.j.optBoolean("popDialogIfDl", false);
                this.w = this.j.optString("publisher");
                this.x = this.j.optString("app_version");
                this.z = this.j.optBoolean("show_wifi_view", "video".equals(this.s));
                this.y = this.j.optBoolean("show_skip", "rsplash".equals(this.r));
                this.t = this.j.optInt("skipTime", 5000);
                this.B = this.j.optBoolean("hide_ad_logo", true);
                this.C = this.j.optBoolean("hide_bd_logo", false);
                this.D = this.j.optBoolean("full_screen", true);
                this.E = this.j.optBoolean("show_host_small_logo", false);
                this.F = this.j.optInt("skip_btn_type");
                this.q = this.j.optInt("close_type");
                this.G = this.j.optInt("bitmapDisplayMode");
                this.H = this.j.optString("host_big_logo_res_id");
            } catch (Exception unused) {
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f42952f.b(M, "start");
            d.a.i0.a.k.a.a(new b(this));
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f42948b = 2;
            d.a.i0.a.k.a.a(new c(this));
            AbsCountDownView absCountDownView = this.f42951e;
            if (absCountDownView != null) {
                absCountDownView.c();
            }
        }
    }

    @Override // d.a.i0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f42952f.b(M, "load");
            this.f42948b = 1;
        }
    }

    @Override // d.a.i0.a.g.b
    public void b(d.a.i0.a.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.p = cVar;
        }
    }

    @Override // d.a.i0.a.g.b
    public void d(d.a.i0.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.o = aVar;
        }
    }

    @Override // d.a.i0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            int optInt = this.j.optInt("ad_label_width", 25);
            int optInt2 = this.j.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.f42947a);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            l(textView, d.a.i0.a.k.h.a(this.f42947a, optInt), d.a.i0.a.k.h.a(this.f42947a, optInt2), NotificationCompatJellybean.KEY_LABEL);
        }
    }

    public void j(View view, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view, layoutParams) == null) {
            if (this.D) {
                this.l.addView(view, layoutParams);
                return;
            }
            n();
            layoutParams.addRule(2, 15);
            this.l.addView(view, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || !this.A || this.v || TextUtils.isEmpty(this.x) || TextUtils.isEmpty(this.w)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f42947a);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.f42947a);
        cVar.a(this.x, this.w);
        cVar.c(-10066330);
        cVar.b(new d(this));
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        l(relativeLayout, -1, -2, "download_desc");
    }

    public void l(View view, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            m(view, i2, i3, str, this.k);
        }
    }

    public void m(View view, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.l == null || view == null || view.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.m.g(layoutParams, new d.a.i0.a.j.b().b(jSONObject, str, this.D));
        this.l.addView(view, layoutParams);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || TextUtils.isEmpty(this.H)) {
            return;
        }
        int optInt = this.j.optInt("bottom_logo_height", d.a.i0.a.j.b.f43004a);
        if (optInt != d.a.i0.a.j.b.f43004a) {
            d.a.i0.a.j.b.f43004a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.f42947a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d.a.i0.a.k.h.a(this.f42947a, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            ImageView imageView = new ImageView(this.f42947a);
            imageView.setImageResource(Integer.parseInt(this.H));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            this.l.addView(relativeLayout, layoutParams);
        } catch (Throwable th) {
            this.f42952f.f(M, th);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.E) {
            String optString = this.j.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.j.optInt("small_logo_width", -2);
            int optInt2 = this.j.optInt("small_logo_height", -2);
            try {
                ImageView imageView = new ImageView(this.f42947a);
                imageView.setImageResource(Integer.parseInt(optString));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                l(imageView, d.a.i0.a.k.h.a(this.f42947a, optInt), d.a.i0.a.k.h.a(this.f42947a, optInt2), "logo");
            } catch (Throwable th) {
                this.f42952f.f(M, th);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.B) {
            String optString = this.j.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                i(optString);
            } else {
                B("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.C) {
                B("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    @Override // d.a.i0.a.g.b
    public void pause() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (absCountDownView = this.f42951e) == null) {
            return;
        }
        absCountDownView.c();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.I = this.j.optString("lottie_url");
            this.J = this.j.optBoolean("lottie_show");
            int optInt = this.j.optInt("ad_click_opt");
            this.K = optInt;
            if (optInt == 1) {
                v();
            }
            if (TextUtils.isEmpty(this.I) || !this.J) {
                return;
            }
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.f42947a);
            JSONObject optJSONObject = this.L.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int screenWidth = (int) (ScreenUtils.getScreenWidth(this.f42947a) * optDouble);
            d.a.f0.a.c.b.c().b(this.I, lottieAnimationView, null, new j(this, lottieAnimationView, screenWidth, (int) (screenWidth * optDouble2)));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.j.optBoolean("displayMantle", false)) {
            String optString = this.j.optString("mantleActionText");
            int optInt = this.j.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.D);
            aVar.n(new View$OnClickListenerC0605a(this));
            aVar.k(this.f42947a).a(this.l);
        }
    }

    @Override // d.a.i0.a.g.b
    public void resume() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (absCountDownView = this.f42951e) == null) {
            return;
        }
        absCountDownView.b();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            try {
                if (this.F == 1) {
                    this.f42951e = new RectangleCountDownView(this.f42947a);
                } else {
                    this.f42951e = new CircleTextProgressbar(this.f42947a);
                }
                this.f42951e.setVisibility(4);
                this.f42951e.setOnClickListener(new h(this));
                this.f42951e.setCountdownProgressListener(new i(this));
                l(this.f42951e, d.a.i0.a.k.h.a(this.f42947a, this.j.optInt("skip_btn_width", 40)), d.a.i0.a.k.h.a(this.f42947a, this.j.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.z) {
            TextView textView = new TextView(this.f42947a);
            this.n = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.n.setTextColor(Color.parseColor("#999999"));
            this.n.setTextSize(0, d.a.i0.a.k.h.c(this.f42947a, 11));
            l(this.n, -2, -2, "wifi_tip");
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            H(str);
        }
    }

    public abstract void v();

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && d.a.i0.a.k.e.f43009b && this.f42947a != null) {
            TextView textView = new TextView(this.f42947a);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + d.a.i0.a.k.e.f43008a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.l.addView(textView, layoutParams);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.y) {
            s();
            if (!"video".equals(this.s)) {
                this.f42951e.setTimeMillis(this.t);
                this.f42951e.b();
            }
            int i2 = this.q;
            if (i2 == 5) {
                this.f42951e.setVisibility(0);
            } else if (i2 == 1) {
                this.f42951e.setVisibility(0);
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            t();
            r();
            k();
            x();
            p();
            o();
            w();
            q();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }
}
