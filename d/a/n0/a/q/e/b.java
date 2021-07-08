package d.a.n0.a.q.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WebViewContainer f46773a;

    /* renamed from: b  reason: collision with root package name */
    public Context f46774b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46775c;

    /* renamed from: d  reason: collision with root package name */
    public double f46776d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f46777e;

    /* renamed from: f  reason: collision with root package name */
    public float f46778f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.a.i1.g.a f46779g;

    /* renamed from: h  reason: collision with root package name */
    public int f46780h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46781i;
    public WebViewContainer.b j;
    public WebViewContainer.c k;

    /* loaded from: classes7.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f46782a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46782a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46782a.j(false);
            }
        }
    }

    /* renamed from: d.a.n0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0869b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f46783a;

        public C0869b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46783a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f46783a.f46773a == null) {
                return;
            }
            this.f46783a.j((((double) this.f46783a.f46773a.getTopMargin()) * 1.0d) / (((double) this.f46783a.f46780h) * 1.0d) >= (z ? 1.0d - this.f46783a.f46776d : this.f46783a.f46776d));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f46784a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46784a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f46784a.f46773a.getTopMargin() > this.f46784a.f46780h) {
                    if (z || this.f46784a.f46773a.getTopMargin() < this.f46784a.f46773a.getMinTopMargin()) {
                        return false;
                    }
                    this.f46784a.j(true);
                    return true;
                }
                this.f46784a.j(false);
                return true;
            }
            return invokeZ.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f46785e;

        /* renamed from: f  reason: collision with root package name */
        public int f46786f;

        /* renamed from: g  reason: collision with root package name */
        public int f46787g;

        /* renamed from: h  reason: collision with root package name */
        public int f46788h;

        /* renamed from: i  reason: collision with root package name */
        public float f46789i;
        public int j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ b l;

        public d(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar;
            this.k = z;
            this.f46785e = 0.0f;
            this.f46786f = this.l.f46780h - this.l.f46773a.getTopMargin();
            int topMargin = this.l.f46773a.getTopMargin() - this.l.f46773a.getMinTopMargin();
            this.f46787g = topMargin;
            topMargin = this.k ? this.f46786f : topMargin;
            this.f46788h = topMargin;
            this.f46789i = topMargin * this.l.f46778f;
            this.j = this.l.f46773a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f46773a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f46775c ? this.f46788h : this.f46789i) * (floatValue - this.f46785e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            this.l.f46773a.scrollBy(0, i2);
            this.l.f46773a.setTopMargin(this.j);
            this.f46785e = floatValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f46791f;

        public e(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46791f = bVar;
            this.f46790e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f46791f.f46773a == null) {
                return;
            }
            this.f46791f.i(this.f46790e);
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46775c = true;
        this.f46776d = 0.25d;
        this.f46781i = true;
        this.j = new a(this);
        this.k = new C0869b(this);
        this.f46774b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f46777e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f46773a) == null || this.f46779g == null) {
            return;
        }
        if (z) {
            if (this.f46775c) {
                webViewContainer.scrollBy(0, -(this.f46780h - webViewContainer.getTopMargin()));
                this.f46773a.setTopMargin(this.f46780h);
            }
            if (!this.f46779g.n() && !this.f46779g.m()) {
                this.f46779g.r();
            }
            this.f46781i = true;
            return;
        }
        if (this.f46775c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f46773a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f46773a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f46779g.n()) {
            this.f46779g.p();
        }
        this.f46781i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f46780h <= 0 || this.f46773a == null || this.f46779g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f46774b);
            this.f46773a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f46773a.setClipChildren(false);
            this.f46773a.setLayerType(2, null);
            this.f46773a.setTopLimit(this.f46780h);
            this.f46773a.setTopMargin(this.f46780h);
            this.f46773a.setAutoScroll2TopListener(this.j);
            this.f46773a.setOnUpListener(this.k);
            this.f46773a.setMinFlingVelocity(1000);
            this.f46773a.setUpYVelocityRatio(3.5f);
            this.f46773a.setInterceptFlingListener(new c(this));
            return this.f46773a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f46781i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f46777e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f46773a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f46777e = ofFloat;
        ofFloat.setDuration(100L);
        this.f46777e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f46773a.getYVelocity() >= 0.0f) {
            this.f46778f = this.f46773a.getYVelocity() / 4000.0f;
        } else {
            this.f46778f = (-this.f46773a.getYVelocity()) / 4000.0f;
        }
        this.f46778f = Math.min(this.f46778f, 1.0f);
        this.f46777e.addUpdateListener(new d(this, z));
        this.f46777e.addListener(new e(this, z));
        this.f46777e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f46780h = i2;
        }
    }

    public void p(d.a.n0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f46779g = aVar;
        }
    }
}
