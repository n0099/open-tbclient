package d.a.e.m;

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
import d.a.e.m.f.a;
import d.a.q0.w2.x;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f42501a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f42502b;

    /* renamed from: c  reason: collision with root package name */
    public View f42503c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.e.m.f.a f42504d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0578d f42505e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.e.m.g.b f42506f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.e.m.e.a f42507g;

    /* renamed from: h  reason: collision with root package name */
    public Context f42508h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42509i;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42510a;

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
            this.f42510a = dVar;
        }

        @Override // d.a.e.m.f.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f42510a.f42507g = null;
            }
        }

        @Override // d.a.e.m.f.a.b
        public void b(d.a.e.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f42510a.f42507g = aVar;
                this.f42510a.z(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements VideoPasterOverlayView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42511a;

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
            this.f42511a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42511a.f42506f.j(this.f42511a.q());
                d.a.q0.n1.o.h.c.h(this.f42511a.f42507g);
                if (this.f42511a.f42507g != null) {
                    int d2 = x.d(this.f42511a.f42508h, this.f42511a.f42507g.f42517i, this.f42511a.f42507g.f42515g, this.f42511a.f42507g.q);
                    d dVar = this.f42511a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f42511a.f42506f.k(this.f42511a.q());
                if (this.f42511a.f42505e != null) {
                    this.f42511a.f42505e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f42511a.o = true;
                this.f42511a.u();
                this.f42511a.f42506f.g(this.f42511a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f42511a.f42506f.e(this.f42511a.q());
                d.a.q0.n1.o.h.c.h(this.f42511a.f42507g);
                if (this.f42511a.f42507g != null) {
                    int d2 = x.d(this.f42511a.f42508h, this.f42511a.f42507g.f42517i, this.f42511a.f42507g.f42515g, this.f42511a.f42507g.q);
                    d dVar = this.f42511a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f42511a.f42506f.b(this.f42511a.q());
                d.a.q0.n1.o.h.c.h(this.f42511a.f42507g);
                if (this.f42511a.f42507g != null) {
                    int d2 = x.d(this.f42511a.f42508h, this.f42511a.f42507g.f42517i, this.f42511a.f42507g.f42515g, this.f42511a.f42507g.q);
                    d dVar = this.f42511a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements VideoPasterContentView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42512a;

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
            this.f42512a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42512a.v();
                if (this.f42512a.f42505e != null) {
                    this.f42512a.f42505e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.f42512a.f42502b.s()) {
                    i2 = 0;
                } else if (this.f42512a.o) {
                    this.f42512a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.f42512a.f42505e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.f42512a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.f42512a.f42505e.d()) {
                        return;
                    }
                    if (this.f42512a.p) {
                        this.f42512a.p = false;
                    } else if (z) {
                    } else {
                        this.f42512a.M(i2);
                    }
                }
            }
        }
    }

    /* renamed from: d.a.e.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0578d {
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
        this.f42509i = false;
        this.o = false;
        this.p = false;
        this.f42508h = context;
        this.f42501a = viewGroup;
        this.f42506f = new d.a.e.m.g.b();
        d.a.e.m.f.a aVar = new d.a.e.m.f.a();
        this.f42504d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f42502b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f42502b.setContentViewCallback(new c(this));
        View view = new View(this.f42508h);
        this.f42503c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.e.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && x.p(i2)) {
            this.f42506f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f42509i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f42504d.i();
            this.f42502b.x();
            this.f42501a.removeView(this.f42502b);
            this.f42501a.removeView(this.f42503c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f42502b) == null) {
            return;
        }
        videoPasterContentView.z(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f42502b.A();
            if (s()) {
                int curDuration = this.f42502b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f42506f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0578d interfaceC0578d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0578d) == null) {
            this.f42505e = interfaceC0578d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f42502b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f42508h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
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
            if (this.f42504d.f()) {
                return false;
            }
            this.f42509i = z2;
            this.j = str;
            VideoPasterResponseData e2 = this.f42504d.e();
            if (e2 == null) {
                return false;
            }
            d.a.e.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f42504d.i();
                return false;
            } else if (pasterData.c()) {
                this.f42506f.i(q());
                this.f42504d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f42504d.i();
                return false;
            } else {
                this.f42501a.removeView(this.f42503c);
                this.f42501a.addView(this.f42503c);
                this.f42501a.removeView(this.f42502b);
                this.f42501a.addView(this.f42502b);
                ViewGroup viewGroup = this.f42501a;
                if (viewGroup instanceof FrameLayout) {
                    this.f42502b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f42502b.setLayoutParams(layoutParams);
                }
                this.f42502b.setData(pasterData);
                this.k = this.f42502b.getCurDuration();
                if (!r()) {
                    this.f42506f.i(q());
                    d.a.q0.n1.o.h.c.g(this.f42507g);
                }
                this.f42502b.E(z, z2, str);
                InterfaceC0578d interfaceC0578d = this.f42505e;
                if (interfaceC0578d != null) {
                    interfaceC0578d.c();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f42502b) == null) {
            return;
        }
        videoPasterContentView.B();
    }

    public void K(d.a.e.m.a aVar) {
        d.a.e.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f42504d) == null || aVar2.f() || this.f42504d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f42504d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f42502b.getCurDuration();
            if (s() && !H()) {
                this.f42506f.g(q());
            }
            this.f42502b.D();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f42506f.c(q(), i2);
            if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
                this.f42506f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f42509i : invokeV.booleanValue;
    }

    public d.a.e.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.e.m.g.a aVar = new d.a.e.m.g.a();
            aVar.f42534g = this.k;
            aVar.f42532e = this.f42502b.getTotalDuration();
            aVar.f42533f = this.f42502b.getCurDuration();
            aVar.f42530c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f42508h) == 1) {
                aVar.f42535h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f42508h) == 2) {
                aVar.f42535h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f42508h) == 0) {
                aVar.f42535h = 2;
            } else {
                aVar.f42535h = -1;
            }
            d.a.e.m.e.a aVar2 = this.f42507g;
            if (aVar2 != null) {
                aVar.f42536i = aVar2.a();
                d.a.e.m.e.a aVar3 = this.f42507g;
                aVar.j = aVar3.f42514f;
                aVar.f42531d = aVar3.q;
                aVar.k = aVar3.s;
                aVar.l = aVar3.t;
            }
            return aVar;
        }
        return (d.a.e.m.g.a) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f42502b.q() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f42502b.r() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f42502b;
            return videoPasterContentView != null && videoPasterContentView.t();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0578d interfaceC0578d = this.f42505e;
            if (interfaceC0578d != null) {
                interfaceC0578d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f42506f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f42504d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f42502b) == null) {
            return;
        }
        videoPasterContentView.v();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f42502b) == null) {
            return;
        }
        videoPasterContentView.w();
    }

    public final void z(d.a.e.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f42506f.d(q());
        }
    }
}
