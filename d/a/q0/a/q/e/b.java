package d.a.q0.a.q.e;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WebViewContainer f50075a;

    /* renamed from: b  reason: collision with root package name */
    public Context f50076b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50077c;

    /* renamed from: d  reason: collision with root package name */
    public double f50078d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f50079e;

    /* renamed from: f  reason: collision with root package name */
    public float f50080f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a.i1.g.a f50081g;

    /* renamed from: h  reason: collision with root package name */
    public int f50082h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50083i;
    public WebViewContainer.b j;
    public WebViewContainer.c k;

    /* loaded from: classes8.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50084a;

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
            this.f50084a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50084a.j(false);
            }
        }
    }

    /* renamed from: d.a.q0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0920b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50085a;

        public C0920b(b bVar) {
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
            this.f50085a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f50085a.f50075a == null) {
                return;
            }
            this.f50085a.j((((double) this.f50085a.f50075a.getTopMargin()) * 1.0d) / (((double) this.f50085a.f50082h) * 1.0d) >= (z ? 1.0d - this.f50085a.f50078d : this.f50085a.f50078d));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50086a;

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
            this.f50086a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f50086a.f50075a.getTopMargin() > this.f50086a.f50082h) {
                    if (z || this.f50086a.f50075a.getTopMargin() < this.f50086a.f50075a.getMinTopMargin()) {
                        return false;
                    }
                    this.f50086a.j(true);
                    return true;
                }
                this.f50086a.j(false);
                return true;
            }
            return invokeZ.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f50087e;

        /* renamed from: f  reason: collision with root package name */
        public int f50088f;

        /* renamed from: g  reason: collision with root package name */
        public int f50089g;

        /* renamed from: h  reason: collision with root package name */
        public int f50090h;

        /* renamed from: i  reason: collision with root package name */
        public float f50091i;
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
            this.f50087e = 0.0f;
            this.f50088f = this.l.f50082h - this.l.f50075a.getTopMargin();
            int topMargin = this.l.f50075a.getTopMargin() - this.l.f50075a.getMinTopMargin();
            this.f50089g = topMargin;
            topMargin = this.k ? this.f50088f : topMargin;
            this.f50090h = topMargin;
            this.f50091i = topMargin * this.l.f50080f;
            this.j = this.l.f50075a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f50075a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f50077c ? this.f50090h : this.f50091i) * (floatValue - this.f50087e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            this.l.f50075a.scrollBy(0, i2);
            this.l.f50075a.setTopMargin(this.j);
            this.f50087e = floatValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50092e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50093f;

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
            this.f50093f = bVar;
            this.f50092e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f50093f.f50075a == null) {
                return;
            }
            this.f50093f.i(this.f50092e);
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
        this.f50077c = true;
        this.f50078d = 0.25d;
        this.f50083i = true;
        this.j = new a(this);
        this.k = new C0920b(this);
        this.f50076b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f50079e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f50075a) == null || this.f50081g == null) {
            return;
        }
        if (z) {
            if (this.f50077c) {
                webViewContainer.scrollBy(0, -(this.f50082h - webViewContainer.getTopMargin()));
                this.f50075a.setTopMargin(this.f50082h);
            }
            if (!this.f50081g.n() && !this.f50081g.m()) {
                this.f50081g.r();
            }
            this.f50083i = true;
            return;
        }
        if (this.f50077c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f50075a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f50075a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f50081g.n()) {
            this.f50081g.p();
        }
        this.f50083i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f50082h <= 0 || this.f50075a == null || this.f50081g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f50076b);
            this.f50075a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f50075a.setClipChildren(false);
            this.f50075a.setLayerType(2, null);
            this.f50075a.setTopLimit(this.f50082h);
            this.f50075a.setTopMargin(this.f50082h);
            this.f50075a.setAutoScroll2TopListener(this.j);
            this.f50075a.setOnUpListener(this.k);
            this.f50075a.setMinFlingVelocity(1000);
            this.f50075a.setUpYVelocityRatio(3.5f);
            this.f50075a.setInterceptFlingListener(new c(this));
            return this.f50075a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50083i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f50079e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f50075a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f50079e = ofFloat;
        ofFloat.setDuration(100L);
        this.f50079e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f50075a.getYVelocity() >= 0.0f) {
            this.f50080f = this.f50075a.getYVelocity() / 4000.0f;
        } else {
            this.f50080f = (-this.f50075a.getYVelocity()) / 4000.0f;
        }
        this.f50080f = Math.min(this.f50080f, 1.0f);
        this.f50079e.addUpdateListener(new d(this, z));
        this.f50079e.addListener(new e(this, z));
        this.f50079e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f50082h = i2;
        }
    }

    public void p(d.a.q0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f50081g = aVar;
        }
    }
}
