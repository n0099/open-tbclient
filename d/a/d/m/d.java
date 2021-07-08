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
import d.a.p0.w2.x;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f41997a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPasterContentView f41998b;

    /* renamed from: c  reason: collision with root package name */
    public View f41999c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.m.f.a f42000d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0569d f42001e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.m.g.b f42002f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.m.e.a f42003g;

    /* renamed from: h  reason: collision with root package name */
    public Context f42004h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42005i;
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
        public final /* synthetic */ d f42006a;

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
            this.f42006a = dVar;
        }

        @Override // d.a.d.m.f.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f42006a.f42003g = null;
            }
        }

        @Override // d.a.d.m.f.a.b
        public void b(d.a.d.m.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f42006a.f42003g = aVar;
                this.f42006a.z(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements VideoPasterOverlayView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42007a;

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
            this.f42007a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42007a.f42002f.j(this.f42007a.q());
                d.a.p0.n1.o.h.c.h(this.f42007a.f42003g);
                if (this.f42007a.f42003g != null) {
                    int d2 = x.d(this.f42007a.f42004h, this.f42007a.f42003g.f42013i, this.f42007a.f42003g.f42011g, this.f42007a.f42003g.q);
                    d dVar = this.f42007a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f42007a.f42002f.k(this.f42007a.q());
                if (this.f42007a.f42001e != null) {
                    this.f42007a.f42001e.b();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f42007a.o = true;
                this.f42007a.u();
                this.f42007a.f42002f.g(this.f42007a.q());
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f42007a.f42002f.e(this.f42007a.q());
                d.a.p0.n1.o.h.c.h(this.f42007a.f42003g);
                if (this.f42007a.f42003g != null) {
                    int d2 = x.d(this.f42007a.f42004h, this.f42007a.f42003g.f42013i, this.f42007a.f42003g.f42011g, this.f42007a.f42003g.q);
                    d dVar = this.f42007a;
                    dVar.A(dVar.q(), d2);
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.b
        public void onClickAd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f42007a.f42002f.b(this.f42007a.q());
                d.a.p0.n1.o.h.c.h(this.f42007a.f42003g);
                if (this.f42007a.f42003g != null) {
                    int d2 = x.d(this.f42007a.f42004h, this.f42007a.f42003g.f42013i, this.f42007a.f42003g.f42011g, this.f42007a.f42003g.q);
                    d dVar = this.f42007a;
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
        public final /* synthetic */ d f42008a;

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
            this.f42008a = dVar;
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42008a.v();
                if (this.f42008a.f42001e != null) {
                    this.f42008a.f42001e.a();
                }
            }
        }

        @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.i
        public void onDetachedFromWindow() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = true;
                if (this.f42008a.f41998b.s()) {
                    i2 = 0;
                } else if (this.f42008a.o) {
                    this.f42008a.o = false;
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                if (this.f42008a.f42001e != null) {
                    if (i2 == 0 || i2 == 1) {
                        this.f42008a.M(i2);
                    } else {
                        z = false;
                    }
                    if (this.f42008a.f42001e.d()) {
                        return;
                    }
                    if (this.f42008a.p) {
                        this.f42008a.p = false;
                    } else if (z) {
                    } else {
                        this.f42008a.M(i2);
                    }
                }
            }
        }
    }

    /* renamed from: d.a.d.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0569d {
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
        this.f42005i = false;
        this.o = false;
        this.p = false;
        this.f42004h = context;
        this.f41997a = viewGroup;
        this.f42002f = new d.a.d.m.g.b();
        d.a.d.m.f.a aVar = new d.a.d.m.f.a();
        this.f42000d = aVar;
        aVar.j(new a(this));
        VideoPasterContentView videoPasterContentView = new VideoPasterContentView(context);
        this.f41998b = videoPasterContentView;
        videoPasterContentView.setOverlayViewCallback(new b(this));
        this.f41998b.setContentViewCallback(new c(this));
        View view = new View(this.f42004h);
        this.f41999c = view;
        view.setBackgroundResource(R.color.black_alpha100);
    }

    public final void A(d.a.d.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) && x.p(i2)) {
            this.f42002f.l(aVar, i2);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            this.f42005i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f42000d.i();
            this.f41998b.x();
            this.f41997a.removeView(this.f41998b);
            this.f41997a.removeView(this.f41999c);
        }
    }

    public void D(int i2) {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoPasterContentView = this.f41998b) == null) {
            return;
        }
        videoPasterContentView.z(i2);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f41998b.A();
            if (s()) {
                int curDuration = this.f41998b.getCurDuration();
                this.k = curDuration;
                this.m = curDuration;
                this.f42002f.h(q());
            }
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public void G(InterfaceC0569d interfaceC0569d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0569d) == null) {
            this.f42001e = interfaceC0569d;
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f41998b;
            if (videoPasterContentView != null) {
                int[] iArr = new int[2];
                videoPasterContentView.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                if (UtilHelper.getRealScreenOrientation(this.f42004h) == 1 && i2 == 0 && TextUtils.equals(this.j, "VIDEO_LIST")) {
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
            if (this.f42000d.f()) {
                return false;
            }
            this.f42005i = z2;
            this.j = str;
            VideoPasterResponseData e2 = this.f42000d.e();
            if (e2 == null) {
                return false;
            }
            d.a.d.m.e.a pasterData = e2.getPasterData();
            if (pasterData == null) {
                this.f42000d.i();
                return false;
            } else if (pasterData.c()) {
                this.f42002f.i(q());
                this.f42000d.i();
                return false;
            } else if (!pasterData.d()) {
                this.f42000d.i();
                return false;
            } else {
                this.f41997a.removeView(this.f41999c);
                this.f41997a.addView(this.f41999c);
                this.f41997a.removeView(this.f41998b);
                this.f41997a.addView(this.f41998b);
                ViewGroup viewGroup = this.f41997a;
                if (viewGroup instanceof FrameLayout) {
                    this.f41998b.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.f41998b.setLayoutParams(layoutParams);
                }
                this.f41998b.setData(pasterData);
                this.k = this.f41998b.getCurDuration();
                if (!r()) {
                    this.f42002f.i(q());
                    d.a.p0.n1.o.h.c.g(this.f42003g);
                }
                this.f41998b.E(z, z2, str);
                InterfaceC0569d interfaceC0569d = this.f42001e;
                if (interfaceC0569d != null) {
                    interfaceC0569d.c();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoPasterContentView = this.f41998b) == null) {
            return;
        }
        videoPasterContentView.B();
    }

    public void K(d.a.d.m.a aVar) {
        d.a.d.m.f.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || (aVar2 = this.f42000d) == null || aVar2.f() || this.f42000d.e() != null || aVar == null) {
            return;
        }
        this.n = aVar.b() + 1;
        this.f42000d.g(new VideoPasterRequestData(aVar));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = this.f41998b.getCurDuration();
            if (s() && !H()) {
                this.f42002f.g(q());
            }
            this.f41998b.D();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f42002f.c(q(), i2);
            if (TextUtils.equals(this.j, "VIDEO_LIST") && i2 == 2) {
                this.f42002f.g(q());
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f42005i : invokeV.booleanValue;
    }

    public d.a.d.m.g.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.d.m.g.a aVar = new d.a.d.m.g.a();
            aVar.f42030g = this.k;
            aVar.f42028e = this.f41998b.getTotalDuration();
            aVar.f42029f = this.f41998b.getCurDuration();
            aVar.f42026c = this.n;
            if (UtilHelper.getRealScreenOrientation(this.f42004h) == 1) {
                aVar.f42031h = 0;
            } else if (UtilHelper.getRealScreenOrientation(this.f42004h) == 2) {
                aVar.f42031h = 1;
            } else if (UtilHelper.getRealScreenOrientation(this.f42004h) == 0) {
                aVar.f42031h = 2;
            } else {
                aVar.f42031h = -1;
            }
            d.a.d.m.e.a aVar2 = this.f42003g;
            if (aVar2 != null) {
                aVar.f42032i = aVar2.a();
                d.a.d.m.e.a aVar3 = this.f42003g;
                aVar.j = aVar3.f42010f;
                aVar.f42027d = aVar3.q;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f41998b.q() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f41998b.r() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VideoPasterContentView videoPasterContentView = this.f41998b;
            return videoPasterContentView != null && videoPasterContentView.t();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C();
            InterfaceC0569d interfaceC0569d = this.f42001e;
            if (interfaceC0569d != null) {
                interfaceC0569d.a();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f42002f.f(q());
            C();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f42000d.h();
        }
    }

    public void x() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (videoPasterContentView = this.f41998b) == null) {
            return;
        }
        videoPasterContentView.v();
    }

    public void y() {
        VideoPasterContentView videoPasterContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoPasterContentView = this.f41998b) == null) {
            return;
        }
        videoPasterContentView.w();
    }

    public final void z(d.a.d.m.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) && aVar != null && aVar.r) {
            this.f42002f.d(q());
        }
    }
}
