package com.repackage;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.repackage.r16;
/* loaded from: classes7.dex */
public class o16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    @Nullable
    public r16.c M;
    public Runnable N;
    public Runnable O;
    public Handler a;
    public gf b;
    public TbPageContext c;
    public View d;
    public boolean e;
    public String f;
    public String g;
    public boolean h;
    public int i;
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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o16 a;

        /* renamed from: com.repackage.o16$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0545a implements ff {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0545a(a aVar) {
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

            @Override // com.repackage.ff
            public int a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a.w : invokeV.intValue;
            }

            @Override // com.repackage.ff
            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a.v : invokeV.intValue;
            }

            @Override // com.repackage.ff
            public View c(LayoutInflater layoutInflater) {
                InterceptResult invokeL;
                Drawable drawable;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                    TextView textView = new TextView(this.a.a.c.getPageActivity());
                    textView.setText(this.a.a.f);
                    if (this.a.a.H != 0) {
                        textView.setGravity(this.a.a.H);
                    } else {
                        textView.setGravity(17);
                    }
                    int i = this.a.a.F;
                    int i2 = R.color.CAM_X0101;
                    if (i != 0) {
                        SkinManager.setViewTextColor(textView, this.a.a.F);
                    } else {
                        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                    }
                    textView.setTextSize(0, this.a.a.G != 0 ? this.a.a.c.getResources().getDimensionPixelSize(this.a.a.G) : this.a.a.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
                    if (this.a.a.B != 0) {
                        textView.setHeight(this.a.a.B);
                    } else {
                        textView.setHeight(this.a.a.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
                    }
                    if (this.a.a.C != 0) {
                        o16.s0(textView, 0, this.a.a.C);
                    }
                    if (this.a.a.D != 0) {
                        textView.setWidth(this.a.a.D);
                    }
                    textView.setPadding(this.a.a.r, this.a.a.s, this.a.a.t, this.a.a.u);
                    textView.setLines(this.a.a.A);
                    if (this.a.a.E) {
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    if (this.a.a.I != 0) {
                        if (this.a.a.J) {
                            if (this.a.a.F != 0) {
                                i2 = this.a.a.F;
                            }
                            drawable = WebPManager.getPureDrawable(this.a.a.I, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL);
                        } else {
                            drawable = SkinManager.getDrawable(this.a.a.I);
                        }
                        int f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                        drawable.setBounds(0, 0, f, f);
                        textView.setCompoundDrawablePadding(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                        textView.setCompoundDrawables(drawable, null, null, null);
                    }
                    SkinManager.setBackgroundResource(textView, this.a.a.i);
                    if (this.a.a.x != null) {
                        textView.setOnClickListener(this.a.a.x);
                    }
                    return textView;
                }
                return (View) invokeL.objValue;
            }

            @Override // com.repackage.ff
            public int getXOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.a.p : invokeV.intValue;
            }

            @Override // com.repackage.ff
            public int getYOffset() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.a.q : invokeV.intValue;
            }
        }

        public a(o16 o16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o16Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b == null && !StringUtils.isNull(this.a.f)) {
                if (!this.a.y || this.a.M()) {
                    hf hfVar = new hf();
                    hfVar.k(this.a.d);
                    hfVar.c(0);
                    hfVar.j(true);
                    hfVar.i(true);
                    hfVar.d(this.a.K);
                    hfVar.g(this.a.L);
                    hfVar.a(new C0545a(this));
                    this.a.b = hfVar.b();
                    this.a.b.k(false);
                    this.a.b.l(this.a.z);
                    this.a.b.n(this.a.c.getPageActivity(), this.a.o);
                    this.a.e = true;
                    this.a.P();
                    this.a.h = true;
                    this.a.a.postDelayed(this.a.O, this.a.n);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o16 a;

        public b(o16 o16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o16Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N();
            }
        }
    }

    public o16(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.i = R.drawable.pic_sign_tip;
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
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = true;
        this.N = new a(this);
        this.O = new b(this);
        this.c = tbPageContext;
        this.d = view2;
        this.r = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.s = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.t = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.u = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230);
    }

    public static void s0(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65567, null, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ru4.k().l(this.g, 0) < this.l : invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.d;
            return view2 != null && view2.getVisibility() == 0 && ((double) this.d.getAlpha()) >= 0.4d;
        }
        return invokeV.booleanValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gf gfVar = this.b;
            if (gfVar != null) {
                gfVar.d();
                this.b = null;
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacks(this.N);
                this.a.removeCallbacks(this.O);
            }
            r16.c cVar = this.M;
            if (cVar != null && this.h) {
                cVar.onDismiss();
            }
            this.h = false;
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k) {
            return;
        }
        ru4.k().w(this.g, this.j + 1);
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.w = i;
        }
    }

    public void R(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || i <= 0) {
            return;
        }
        this.n = i;
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.v = i;
        }
    }

    public void U(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.B = this.c.getResources().getDimensionPixelSize(i);
        }
    }

    public void V(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.C = this.c.getResources().getDimensionPixelSize(i);
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.E = z;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.K = z;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.L = z;
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.J = z;
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.A = i;
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || i <= 0) {
            return;
        }
        this.l = i;
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.y = z;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.o = z;
        }
    }

    public void e0(@Nullable r16.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.M = cVar;
        }
    }

    public void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.g = str;
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || i <= 0) {
            return;
        }
        this.m = i;
    }

    public void h0(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.F = i;
        }
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.I = i;
        }
    }

    public void j0(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) {
            this.r = i;
            this.s = i2;
            this.t = i3;
            this.u = i4;
        }
    }

    public void k0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.u = i;
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.r = i;
        }
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.t = i;
        }
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.s = i;
        }
    }

    public void o0(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.G = i;
        }
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.H = i;
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i) == null) || i <= 0) {
            return;
        }
        this.i = i;
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.z = z;
        }
    }

    public void t0(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.D = this.c.getResources().getDimensionPixelSize(i);
        }
    }

    public void u0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.p = i;
        }
    }

    public void v0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.q = i;
        }
    }

    public void w0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f = str;
        if (this.a == null) {
            this.a = new Handler();
        }
        this.a.postDelayed(this.N, this.m);
    }

    public void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            y0(str, str2, false);
        }
    }

    public boolean y0(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048614, this, str, str2, z)) == null) ? z0(str, str2, z, false) : invokeLLZ.booleanValue;
    }

    public boolean z0(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view2 = this.d) == null || view2.getVisibility() != 0) {
                return false;
            }
            this.f = str;
            this.g = str2;
            this.k = z2;
            int l = ru4.k().l(str2, 0);
            this.j = l;
            if (l < this.l || this.k) {
                if (z) {
                    P();
                    this.e = true;
                }
                if (this.a == null) {
                    this.a = new Handler();
                }
                this.a.postDelayed(this.N, this.m);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
