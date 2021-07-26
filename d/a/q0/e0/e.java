package d.a.q0.e0;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public Runnable J;
    public Runnable K;

    /* renamed from: a  reason: collision with root package name */
    public Handler f55576a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d.e.g.c f55577b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f55578c;

    /* renamed from: d  reason: collision with root package name */
    public View f55579d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55580e;

    /* renamed from: f  reason: collision with root package name */
    public String f55581f;

    /* renamed from: g  reason: collision with root package name */
    public String f55582g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55583h;

    /* renamed from: i  reason: collision with root package name */
    public int f55584i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f55585e;

        /* renamed from: d.a.q0.e0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1332a implements d.a.d.e.g.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f55586a;

            public C1332a(a aVar) {
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
                this.f55586a = aVar;
            }

            @Override // d.a.d.e.g.b
            public int a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55586a.f55585e.w : invokeV.intValue;
            }

            @Override // d.a.d.e.g.b
            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55586a.f55585e.v : invokeV.intValue;
            }

            @Override // d.a.d.e.g.b
            public View c(LayoutInflater layoutInflater) {
                InterceptResult invokeL;
                Drawable drawable;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                    TextView textView = new TextView(this.f55586a.f55585e.f55578c.getPageActivity());
                    textView.setText(this.f55586a.f55585e.f55581f);
                    if (this.f55586a.f55585e.G != 0) {
                        textView.setGravity(this.f55586a.f55585e.G);
                    } else {
                        textView.setGravity(17);
                    }
                    if (this.f55586a.f55585e.E != 0) {
                        SkinManager.setViewTextColor(textView, this.f55586a.f55585e.E);
                    } else {
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                    }
                    textView.setTextSize(0, this.f55586a.f55585e.F != 0 ? this.f55586a.f55585e.f55578c.getResources().getDimensionPixelSize(this.f55586a.f55585e.F) : this.f55586a.f55585e.f55578c.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                    if (this.f55586a.f55585e.B != 0) {
                        textView.setHeight(this.f55586a.f55585e.B);
                    } else {
                        textView.setHeight(this.f55586a.f55585e.f55578c.getResources().getDimensionPixelSize(R.dimen.ds76));
                    }
                    if (this.f55586a.f55585e.C != 0) {
                        textView.setWidth(this.f55586a.f55585e.C);
                    }
                    textView.setPadding(this.f55586a.f55585e.r, this.f55586a.f55585e.s, this.f55586a.f55585e.t, this.f55586a.f55585e.u);
                    textView.setLines(this.f55586a.f55585e.A);
                    if (this.f55586a.f55585e.D) {
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    if (this.f55586a.f55585e.H != 0) {
                        if (this.f55586a.f55585e.I) {
                            if (this.f55586a.f55585e.E != 0) {
                                i2 = this.f55586a.f55585e.E;
                            } else {
                                i2 = R.color.CAM_X0101;
                            }
                            drawable = WebPManager.getPureDrawable(this.f55586a.f55585e.H, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL);
                        } else {
                            drawable = SkinManager.getDrawable(this.f55586a.f55585e.H);
                        }
                        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                        drawable.setBounds(0, 0, g2, g2);
                        textView.setCompoundDrawablePadding(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                        textView.setCompoundDrawables(drawable, null, null, null);
                    }
                    SkinManager.setBackgroundResource(textView, this.f55586a.f55585e.f55584i);
                    if (this.f55586a.f55585e.x != null) {
                        textView.setOnClickListener(this.f55586a.f55585e.x);
                    }
                    return textView;
                }
                return (View) invokeL.objValue;
            }

            @Override // d.a.d.e.g.b
            public int getXOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55586a.f55585e.p : invokeV.intValue;
            }

            @Override // d.a.d.e.g.b
            public int getYOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55586a.f55585e.q : invokeV.intValue;
            }
        }

        public a(e eVar) {
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
            this.f55585e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f55585e.f55577b == null && !StringUtils.isNull(this.f55585e.f55581f)) {
                if (!this.f55585e.y || this.f55585e.H()) {
                    d.a.d.e.g.d dVar = new d.a.d.e.g.d();
                    dVar.j(this.f55585e.f55579d);
                    dVar.c(0);
                    dVar.i(true);
                    dVar.h(true);
                    dVar.a(new C1332a(this));
                    this.f55585e.f55577b = dVar.b();
                    this.f55585e.f55577b.k(false);
                    this.f55585e.f55577b.l(this.f55585e.z);
                    this.f55585e.f55577b.n(this.f55585e.f55578c.getPageActivity(), this.f55585e.o);
                    this.f55585e.f55580e = true;
                    this.f55585e.K();
                    this.f55585e.f55583h = true;
                    this.f55585e.f55576a.postDelayed(this.f55585e.K, this.f55585e.n);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f55587e;

        public b(e eVar) {
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
            this.f55587e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55587e.I();
            }
        }
    }

    public e(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55576a = null;
        this.f55577b = null;
        this.f55584i = R.drawable.pic_sign_tip;
        this.j = 0;
        this.k = false;
        this.l = 1;
        this.m = 1000;
        this.n = 3000;
        this.o = true;
        this.p = 5;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 48;
        this.w = 4;
        this.z = false;
        this.A = 1;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = false;
        this.J = new a(this);
        this.K = new b(this);
        this.f55578c = tbPageContext;
        this.f55579d = view;
        this.r = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.s = this.f55578c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.t = this.f55578c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.u = this.f55578c.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View view = this.f55579d;
            return view != null && view.getVisibility() == 0 && ((double) this.f55579d.getAlpha()) >= 0.4d;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.d.e.g.c cVar = this.f55577b;
            if (cVar != null) {
                cVar.d();
                this.f55577b = null;
            }
            Handler handler = this.f55576a;
            if (handler != null) {
                handler.removeCallbacks(this.J);
                this.f55576a.removeCallbacks(this.K);
            }
            this.f55583h = false;
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55583h : invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k) {
            return;
        }
        d.a.p0.s.d0.b.j().v(this.f55582g, this.j + 1);
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.w = i2;
        }
    }

    public void M(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.n = i2;
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.v = i2;
        }
    }

    public void P(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.B = this.f55578c.getResources().getDimensionPixelSize(i2);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.D = z;
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.I = z;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.A = i2;
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.l = i2;
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.y = z;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.o = z;
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.m = i2;
    }

    public void X(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.E = i2;
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.H = i2;
        }
    }

    public void Z(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048594, this, i2, i3, i4, i5) == null) {
            this.r = i2;
            this.s = i3;
            this.t = i4;
            this.u = i5;
        }
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.u = i2;
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.r = i2;
        }
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.t = i2;
        }
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.s = i2;
        }
    }

    public void e0(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.F = i2;
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.G = i2;
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f55584i = i2;
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.z = z;
        }
    }

    public void i0(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.C = this.f55578c.getResources().getDimensionPixelSize(i2);
        }
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.p = i2;
        }
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.q = i2;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f55581f = str;
        if (this.f55576a == null) {
            this.f55576a = new Handler();
        }
        this.f55576a.postDelayed(this.J, this.m);
    }

    public void m0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, str2) == null) {
            n0(str, str2, false);
        }
    }

    public boolean n0(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048608, this, str, str2, z)) == null) ? o0(str, str2, z, false) : invokeLLZ.booleanValue;
    }

    public boolean o0(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f55580e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view = this.f55579d) == null || view.getVisibility() != 0) {
                return false;
            }
            this.f55581f = str;
            this.f55582g = str2;
            this.k = z2;
            int k = d.a.p0.s.d0.b.j().k(str2, 0);
            this.j = k;
            if (k < this.l || this.k) {
                if (z) {
                    K();
                    this.f55580e = true;
                }
                if (this.f55576a == null) {
                    this.f55576a = new Handler();
                }
                this.f55576a.postDelayed(this.J, this.m);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
