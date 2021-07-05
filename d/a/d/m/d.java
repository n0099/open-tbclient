package d.a.d.m;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.afd.videopaster.view.VideoPasterContentView;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.m.f.a;
import d.a.s0.w2.x;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f45195a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f45196b;

    /* renamed from: c  reason: collision with root package name */
    public View f45197c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.m.f.a f45198d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0611d f45199e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.m.g.b f45200f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.m.e.a f45201g;

    /* renamed from: h  reason: collision with root package name */
    public Context f45202h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45203i;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45204a;

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
            this.f45204a = dVar;
        }

        @Override // d.a.d.m.f.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f45204a.f45201g = null;
            }
        }

        @Override // d.a.d.m.f.a.b
        public void b(d.a.d.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f45204a.f45201g = aVar;
                this.f45204a.z(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements VideoPasterOverlayView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45205a;

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
            this.f45205a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45205a.f45200f.j(this.f45205a.q());
                d.a.s0.n1.o.h.c.h(this.f45205a.f45201g);
                if (this.f45205a.f45201g != null) {
                    int d2 = x.d(this.f45205a.f45202h, this.f45205a.f45201g.f45211i, this.f45205a.f45201g.f45209g, this.f45205a.f45201g.q);
                    d dVar = this.f45205a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f45205a.f45200f.k(this.f45205a.q());
                if (this.f45205a.f45199e != null) {
                    this.f45205a.f45199e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f45205a.o = true;
                this.f45205a.u();
                this.f45205a.f45200f.g(this.f45205a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f45205a.f45200f.e(this.f45205a.q());
                d.a.s0.n1.o.h.c.h(this.f45205a.f45201g);
                if (this.f45205a.f45201g != null) {
                    int d2 = x.d(this.f45205a.f45202h, this.f45205a.f45201g.f45211i, this.f45205a.f45201g.f45209g, this.f45205a.f45201g.q);
                    d dVar = this.f45205a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f45205a.f45200f.b(this.f45205a.q());
                d.a.s0.n1.o.h.c.h(this.f45205a.f45201g);
                if (this.f45205a.f45201g != null) {
                    int d2 = x.d(this.f45205a.f45202h, this.f45205a.f45201g.f45211i, this.f45205a.f45201g.f45209g, this.f45205a.f45201g.q);
                    d dVar = this.f45205a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements VideoPasterContentView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45206a;

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
            this.f45206a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45206a.v();
                if (this.f45206a.f45199e != null) {
                    this.f45206a.f45199e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.f45206a.f45196b.s()) {
                    i2 = 0;
                } else if (this.f45206a.o) {
                    this.f45206a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.f45206a.f45199e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.f45206a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.f45206a.f45199e.d()) {
                        return;
                    }
                    if (this.f45206a.p) {
                        this.f45206a.p = false;
                    } else if (z) {
                    } else {
                        this.f45206a.M(i2);
                    }
                }
            }
        }
    }

    /* renamed from: d.a.d.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0611d {
        void a();

        void b();

        void c();

        boolean d();
    }

    public d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45203i = false;
        this.o = false;
        this.p = false;
        this.f45202h = context;
        this.f45195a = viewGroup;
        this.f45200f = new d.a.d.m.g.b();
        d.a.d.m.f.a aVar = new d.a.d.m.f.a();
        this.f45198d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f45196b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f45196b.setContentViewCallback(new c(this));
        View view = new View(this.f45202h);
        this.f45197c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.d.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && x.p(i2)) {
            this.f45200f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f45203i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f45198d.i();
            this.f45196b.x();
            this.f45195a.removeView(this.f45196b);
            this.f45195a.removeView(this.f45197c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f45196b) == null) {
            return;
        }
        videoPasterContentView.z(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f45196b.A();
            if (s()) {
                int curDuration = this.f45196b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f45200f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0611d interfaceC0611d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0611d) == null) {
            this.f45199e = interfaceC0611d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f45196b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f45202h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (this.f45198d.f()) {
                return false;
            }
            this.f45203i = z2;
            this.j = str;
            VideoPasterResponseData e2 = this.f45198d.e();
            if (e2 == null) {
                return false;
            }
            d.a.d.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f45198d.i();
                return false;
            } else if (pasterData.c()) {
                this.f45200f.i(q());
                this.f45198d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f45198d.i();
                return false;
            } else {
                this.f45195a.removeView(this.f45197c);
                this.f45195a.addView(this.f45197c);
                this.f45195a.removeView(this.f45196b);
                this.f45195a.addView(this.f45196b);
                ViewGroup viewGroup = this.f45195a;
                if (viewGroup instanceof FrameLayout) {
                    this.f45196b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f45196b.setLayoutParams(layoutParams);
                }
                this.f45196b.setData(pasterData);
                this.k = this.f45196b.getCurDuration();
                if (!r()) {
                    this.f45200f.i(q());
                    d.a.s0.n1.o.h.c.g(this.f45201g);
                }
                this.f45196b.E(z, z2, str);
                InterfaceC0611d interfaceC0611d = this.f45199e;
                if (interfaceC0611d != null) {
                    interfaceC0611d.c();
                    return true;
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void J() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f45196b) == null) {
            return;
        }
        videoPasterContentView.B();
    }

    public void K(d.a.d.m.a aVar) {
        d.a.d.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f45198d) == null || aVar2.f() || this.f45198d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f45198d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f45196b.getCurDuration();
            if (s() && !H()) {
                this.f45200f.g(q());
            }
            this.f45196b.D();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f45200f.c(q(), i2);
            if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
                this.f45200f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f45203i : invokeV.booleanValue;
    }

    public d.a.d.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.d.m.g.a aVar = new d.a.d.m.g.a();
            aVar.f45228g = this.k;
            aVar.f45226e = this.f45196b.getTotalDuration();
            aVar.f45227f = this.f45196b.getCurDuration();
            aVar.f45224c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f45202h) == 1) {
                aVar.f45229h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f45202h) == 2) {
                aVar.f45229h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f45202h) == 0) {
                aVar.f45229h = 2;
            } else {
                aVar.f45229h = -1;
            }
            d.a.d.m.e.a aVar2 = this.f45201g;
            if (aVar2 != null) {
                aVar.f45230i = aVar2.a();
                d.a.d.m.e.a aVar3 = this.f45201g;
                aVar.j = aVar3.f45208f;
                aVar.f45225d = aVar3.q;
                aVar.k = aVar3.s;
                aVar.l = aVar3.t;
            }
            return aVar;
        }
        return (d.a.d.m.g.a) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f45196b.q() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f45196b.r() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f45196b;
            return videoPasterContentView != null && videoPasterContentView.t();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0611d interfaceC0611d = this.f45199e;
            if (interfaceC0611d != null) {
                interfaceC0611d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f45200f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f45198d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f45196b) == null) {
            return;
        }
        videoPasterContentView.v();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f45196b) == null) {
            return;
        }
        videoPasterContentView.w();
    }

    public final void z(d.a.d.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f45200f.d(q());
        }
    }
}
