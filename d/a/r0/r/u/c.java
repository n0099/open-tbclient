package d.a.r0.r.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f56251a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f56252b;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56253e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f56254f;

        public a(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56254f = cVar;
            this.f56253e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f56254f;
                cVar.f56252b = d.a.r0.r.u.a.A(cVar.f56252b, this.f56253e, this.f56254f.f56251a.getMeasuredHeight());
                this.f56254f.f56251a.setBackgroundDrawable(this.f56254f.f56252b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56255e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56256f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f56257g;

        public b(c cVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56257g = cVar;
            this.f56255e = i2;
            this.f56256f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f56257g;
                cVar.f56252b = d.a.r0.r.u.a.B(cVar.f56252b, this.f56255e, this.f56256f, this.f56257g.f56251a.getMeasuredHeight());
                this.f56257g.f56251a.setBackgroundDrawable(this.f56257g.f56252b);
            }
        }
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56251a = view;
        this.f56252b = d.a.r0.r.u.a.d(view);
    }

    public static c d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, view)) == null) ? new c(view) : (c) invokeL.objValue;
    }

    public c e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f56251a == null) {
                return this;
            }
            this.f56252b = d.a.r0.r.u.a.b(this.f56252b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void f(int i2) {
        Drawable i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f56251a == null || (i3 = d.a.r0.r.u.a.i(this.f56252b, i2)) == null) {
            return;
        }
        this.f56252b = i3;
        this.f56251a.setBackgroundDrawable(i3);
    }

    public void g(int i2) {
        Drawable u;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f56251a == null || (u = d.a.r0.r.u.a.u(this.f56252b, i2)) == null) {
            return;
        }
        this.f56252b = u;
        this.f56251a.setBackgroundDrawable(u);
    }

    public void h(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (view = this.f56251a) == null) {
            return;
        }
        view.post(new a(this, i2));
    }

    public void i(int i2, int i3) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (view = this.f56251a) == null) {
            return;
        }
        view.post(new b(this, i2, i3));
    }

    public c j(int i2) {
        InterceptResult invokeI;
        Drawable e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f56251a == null || (e2 = d.a.r0.r.u.a.e(this.f56252b, i2)) == null) {
                return this;
            }
            this.f56252b = e2;
            this.f56251a.setBackgroundDrawable(e2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c k(int i2) {
        InterceptResult invokeI;
        Drawable f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f56251a == null || (f2 = d.a.r0.r.u.a.f(this.f56252b, i2)) == null) {
                return this;
            }
            this.f56252b = f2;
            this.f56251a.setBackgroundDrawable(f2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (this.f56251a == null) {
                return this;
            }
            this.f56252b = d.a.r0.r.u.a.g(this.f56252b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (this.f56251a == null) {
                return this;
            }
            this.f56252b = d.a.r0.r.u.a.l(this.f56252b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f56251a == null) {
                return this;
            }
            this.f56252b = d.a.r0.r.u.a.k(this.f56252b, i2);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, iArr) == null) || this.f56251a == null || (o = d.a.r0.r.u.a.o(this.f56252b, iArr)) == null) {
            return;
        }
        this.f56252b = o;
        this.f56251a.setBackgroundDrawable(o);
    }

    public c p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            View view = this.f56251a;
            if (view == null) {
                return this;
            }
            view.setLayerType(i2, null);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            View view = this.f56251a;
            if (view instanceof TextView) {
                ((TextView) view).setLinkTextColor(d.a.r0.r.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void r(int i2) {
        Drawable s;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || this.f56251a == null || (s = d.a.r0.r.u.a.s(this.f56252b, d.a.r0.r.u.a.D(i2))) == null) {
            return;
        }
        this.f56252b = s;
        this.f56251a.setBackgroundDrawable(s);
    }

    public c s(int i2) {
        InterceptResult invokeI;
        Drawable y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            View view = this.f56251a;
            if (view == null || (y = d.a.r0.r.u.a.y(view, this.f56252b, d.a.r0.r.u.a.D(i2))) == null) {
                return this;
            }
            this.f56252b = y;
            this.f56251a.setBackgroundDrawable(y);
            p(1);
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            View view = this.f56251a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(d.a.r0.r.u.a.h(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            View view = this.f56251a;
            if (view instanceof EMTextView) {
                ((EMTextView) view).setLineSpacing(d.a.r0.r.u.a.m(i2), ((EMTextView) this.f56251a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (c) invokeI.objValue;
    }

    public c v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            View view = this.f56251a;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(d.a.r0.r.u.a.E(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (this.f56251a instanceof TextView) {
                float[] z = d.a.r0.r.u.a.z(i2);
                ((TextView) this.f56251a).setShadowLayer(z[1], z[2], z[3], (int) z[0]);
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            View view = this.f56251a;
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(0, d.a.r0.r.u.a.m(i2));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            View view = this.f56251a;
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(d.a.r0.r.u.a.F(d.a.r0.r.u.a.C(i2)));
                return this;
            }
            return this;
        }
        return (c) invokeI.objValue;
    }
}
