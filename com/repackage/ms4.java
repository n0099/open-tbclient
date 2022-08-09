package com.repackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ms4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public Drawable b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ms4 b;

        public a(ms4 ms4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ms4Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ms4 ms4Var = this.b;
                ms4Var.b = ks4.C(ms4Var.b, this.a, this.b.a.getMeasuredHeight());
                this.b.a.setBackgroundDrawable(this.b.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ms4 c;

        public b(ms4 ms4Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ms4Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ms4 ms4Var = this.c;
                ms4Var.b = ks4.D(ms4Var.b, this.a, this.b, this.c.a.getMeasuredHeight());
                this.c.a.setBackgroundDrawable(this.c.b);
            }
        }
    }

    public ms4(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = ks4.d(view2);
    }

    public static ms4 d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) ? new ms4(view2) : (ms4) invokeL.objValue;
    }

    public ms4 A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTypeface(ks4.H(ks4.E(i)));
                return this;
            }
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ks4.b(this.b, i);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public void f(int i) {
        Drawable i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == null || (i2 = ks4.i(this.b, i)) == null) {
            return;
        }
        this.b = i2;
        this.a.setBackgroundDrawable(i2);
    }

    public void g(int i) {
        Drawable w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a == null || (w = ks4.w(this.b, i)) == null) {
            return;
        }
        this.b = w;
        this.a.setBackgroundDrawable(w);
    }

    public void h(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new a(this, i));
    }

    public void i(int i, int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new b(this, i, i2));
    }

    public ms4 j(int i) {
        InterceptResult invokeI;
        Drawable e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a == null || (e = ks4.e(this.b, i)) == null) {
                return this;
            }
            this.b = e;
            this.a.setBackgroundDrawable(e);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 k(int i) {
        InterceptResult invokeI;
        Drawable f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.a == null || (f = ks4.f(this.b, i)) == null) {
                return this;
            }
            this.b = f;
            this.a.setBackgroundDrawable(f);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ks4.g(this.b, i);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ks4.l(this.b, i);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ks4.k(this.b, i);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) || this.a == null || (p = ks4.p(this.b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.b = p;
        this.a.setBackgroundDrawable(p);
    }

    public void p(int[] iArr, Direction direction) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, iArr, direction) == null) || this.a == null || (p = ks4.p(this.b, direction, iArr)) == null) {
            return;
        }
        this.b = p;
        this.a.setBackgroundDrawable(p);
    }

    public ms4 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null) {
                return this;
            }
            view2.setLayerType(i, null);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setLinkTextColor(ks4.h(i));
                return this;
            }
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public void s(int i) {
        Drawable t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || this.a == null || (t = ks4.t(this.b, ks4.F(i))) == null) {
            return;
        }
        this.b = t;
        this.a.setBackgroundDrawable(t);
    }

    public ms4 t(int i) {
        InterceptResult invokeI;
        Drawable v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (this.a == null || (v = ks4.v(this.b, i)) == null) {
                return this;
            }
            this.b = v;
            this.a.setBackgroundDrawable(v);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 u(int i) {
        InterceptResult invokeI;
        Drawable A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null || (A = ks4.A(view2, this.b, ks4.F(i))) == null) {
                return this;
            }
            this.b = A;
            this.a.setBackgroundDrawable(A);
            q(1);
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTextColor(ks4.h(i));
                return this;
            }
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof EMTextView) {
                ((EMTextView) view2).setLineSpacing(ks4.m(i), ((EMTextView) this.a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTextColor(ks4.G(i));
                return this;
            }
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (this.a instanceof TextView) {
                float[] B = ks4.B(i);
                ((TextView) this.a).setShadowLayer(B[1], B[2], B[3], (int) B[0]);
                return this;
            }
            return this;
        }
        return (ms4) invokeI.objValue;
    }

    public ms4 z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTextSize(0, ks4.m(i));
                return this;
            }
            return this;
        }
        return (ms4) invokeI.objValue;
    }
}
