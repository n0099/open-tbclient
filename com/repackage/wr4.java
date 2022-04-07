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
/* loaded from: classes7.dex */
public class wr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public Drawable b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ wr4 b;

        public a(wr4 wr4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr4Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wr4 wr4Var = this.b;
                wr4Var.b = ur4.C(wr4Var.b, this.a, this.b.a.getMeasuredHeight());
                this.b.a.setBackgroundDrawable(this.b.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ wr4 c;

        public b(wr4 wr4Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wr4Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wr4 wr4Var = this.c;
                wr4Var.b = ur4.D(wr4Var.b, this.a, this.b, this.c.a.getMeasuredHeight());
                this.c.a.setBackgroundDrawable(this.c.b);
            }
        }
    }

    public wr4(View view2) {
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
        this.b = ur4.d(view2);
    }

    public static wr4 d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) ? new wr4(view2) : (wr4) invokeL.objValue;
    }

    public wr4 A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTypeface(ur4.H(ur4.E(i)));
                return this;
            }
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ur4.b(this.b, i);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public void f(int i) {
        Drawable i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == null || (i2 = ur4.i(this.b, i)) == null) {
            return;
        }
        this.b = i2;
        this.a.setBackgroundDrawable(i2);
    }

    public void g(int i) {
        Drawable w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a == null || (w = ur4.w(this.b, i)) == null) {
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

    public wr4 j(int i) {
        InterceptResult invokeI;
        Drawable e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a == null || (e = ur4.e(this.b, i)) == null) {
                return this;
            }
            this.b = e;
            this.a.setBackgroundDrawable(e);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 k(int i) {
        InterceptResult invokeI;
        Drawable f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.a == null || (f = ur4.f(this.b, i)) == null) {
                return this;
            }
            this.b = f;
            this.a.setBackgroundDrawable(f);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ur4.g(this.b, i);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ur4.l(this.b, i);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = ur4.k(this.b, i);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) || this.a == null || (p = ur4.p(this.b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.b = p;
        this.a.setBackgroundDrawable(p);
    }

    public void p(int[] iArr, Direction direction) {
        Drawable p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, iArr, direction) == null) || this.a == null || (p = ur4.p(this.b, direction, iArr)) == null) {
            return;
        }
        this.b = p;
        this.a.setBackgroundDrawable(p);
    }

    public wr4 q(int i) {
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
        return (wr4) invokeI.objValue;
    }

    public wr4 r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setLinkTextColor(ur4.h(i));
                return this;
            }
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public void s(int i) {
        Drawable t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || this.a == null || (t = ur4.t(this.b, ur4.F(i))) == null) {
            return;
        }
        this.b = t;
        this.a.setBackgroundDrawable(t);
    }

    public wr4 t(int i) {
        InterceptResult invokeI;
        Drawable v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (this.a == null || (v = ur4.v(this.b, i)) == null) {
                return this;
            }
            this.b = v;
            this.a.setBackgroundDrawable(v);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 u(int i) {
        InterceptResult invokeI;
        Drawable A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null || (A = ur4.A(view2, this.b, ur4.F(i))) == null) {
                return this;
            }
            this.b = A;
            this.a.setBackgroundDrawable(A);
            q(1);
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTextColor(ur4.h(i));
                return this;
            }
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof EMTextView) {
                ((EMTextView) view2).setLineSpacing(ur4.m(i), ((EMTextView) this.a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTextColor(ur4.G(i));
                return this;
            }
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (this.a instanceof TextView) {
                float[] B = ur4.B(i);
                ((TextView) this.a).setShadowLayer(B[1], B[2], B[3], (int) B[0]);
                return this;
            }
            return this;
        }
        return (wr4) invokeI.objValue;
    }

    public wr4 z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof TextView) {
                ((TextView) view2).setTextSize(0, ur4.m(i));
                return this;
            }
            return this;
        }
        return (wr4) invokeI.objValue;
    }
}
