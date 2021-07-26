package d.a.o0.a.q.e;

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
    public WebViewContainer f47277a;

    /* renamed from: b  reason: collision with root package name */
    public Context f47278b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47279c;

    /* renamed from: d  reason: collision with root package name */
    public double f47280d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f47281e;

    /* renamed from: f  reason: collision with root package name */
    public float f47282f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.a.i1.g.a f47283g;

    /* renamed from: h  reason: collision with root package name */
    public int f47284h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47285i;
    public WebViewContainer.b j;
    public WebViewContainer.c k;

    /* loaded from: classes7.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47286a;

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
            this.f47286a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47286a.j(false);
            }
        }
    }

    /* renamed from: d.a.o0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0878b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47287a;

        public C0878b(b bVar) {
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
            this.f47287a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f47287a.f47277a == null) {
                return;
            }
            this.f47287a.j((((double) this.f47287a.f47277a.getTopMargin()) * 1.0d) / (((double) this.f47287a.f47284h) * 1.0d) >= (z ? 1.0d - this.f47287a.f47280d : this.f47287a.f47280d));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47288a;

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
            this.f47288a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f47288a.f47277a.getTopMargin() > this.f47288a.f47284h) {
                    if (z || this.f47288a.f47277a.getTopMargin() < this.f47288a.f47277a.getMinTopMargin()) {
                        return false;
                    }
                    this.f47288a.j(true);
                    return true;
                }
                this.f47288a.j(false);
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
        public float f47289e;

        /* renamed from: f  reason: collision with root package name */
        public int f47290f;

        /* renamed from: g  reason: collision with root package name */
        public int f47291g;

        /* renamed from: h  reason: collision with root package name */
        public int f47292h;

        /* renamed from: i  reason: collision with root package name */
        public float f47293i;
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
            this.f47289e = 0.0f;
            this.f47290f = this.l.f47284h - this.l.f47277a.getTopMargin();
            int topMargin = this.l.f47277a.getTopMargin() - this.l.f47277a.getMinTopMargin();
            this.f47291g = topMargin;
            topMargin = this.k ? this.f47290f : topMargin;
            this.f47292h = topMargin;
            this.f47293i = topMargin * this.l.f47282f;
            this.j = this.l.f47277a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f47277a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f47279c ? this.f47292h : this.f47293i) * (floatValue - this.f47289e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            this.l.f47277a.scrollBy(0, i2);
            this.l.f47277a.setTopMargin(this.j);
            this.f47289e = floatValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47295f;

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
            this.f47295f = bVar;
            this.f47294e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f47295f.f47277a == null) {
                return;
            }
            this.f47295f.i(this.f47294e);
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
        this.f47279c = true;
        this.f47280d = 0.25d;
        this.f47285i = true;
        this.j = new a(this);
        this.k = new C0878b(this);
        this.f47278b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f47281e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f47277a) == null || this.f47283g == null) {
            return;
        }
        if (z) {
            if (this.f47279c) {
                webViewContainer.scrollBy(0, -(this.f47284h - webViewContainer.getTopMargin()));
                this.f47277a.setTopMargin(this.f47284h);
            }
            if (!this.f47283g.n() && !this.f47283g.m()) {
                this.f47283g.r();
            }
            this.f47285i = true;
            return;
        }
        if (this.f47279c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f47277a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f47277a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f47283g.n()) {
            this.f47283g.p();
        }
        this.f47285i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f47284h <= 0 || this.f47277a == null || this.f47283g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f47278b);
            this.f47277a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f47277a.setClipChildren(false);
            this.f47277a.setLayerType(2, null);
            this.f47277a.setTopLimit(this.f47284h);
            this.f47277a.setTopMargin(this.f47284h);
            this.f47277a.setAutoScroll2TopListener(this.j);
            this.f47277a.setOnUpListener(this.k);
            this.f47277a.setMinFlingVelocity(1000);
            this.f47277a.setUpYVelocityRatio(3.5f);
            this.f47277a.setInterceptFlingListener(new c(this));
            return this.f47277a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f47285i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f47281e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f47277a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f47281e = ofFloat;
        ofFloat.setDuration(100L);
        this.f47281e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f47277a.getYVelocity() >= 0.0f) {
            this.f47282f = this.f47277a.getYVelocity() / 4000.0f;
        } else {
            this.f47282f = (-this.f47277a.getYVelocity()) / 4000.0f;
        }
        this.f47282f = Math.min(this.f47282f, 1.0f);
        this.f47281e.addUpdateListener(new d(this, z));
        this.f47281e.addListener(new e(this, z));
        this.f47281e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f47284h = i2;
        }
    }

    public void p(d.a.o0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f47283g = aVar;
        }
    }
}
