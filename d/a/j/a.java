package d.a.j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.v0.a;
import d.a.o0.r.q.a;
/* loaded from: classes7.dex */
public abstract class a<T extends d.a.o0.r.q.a> implements q, p<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public l0 f42626e;

    /* renamed from: f  reason: collision with root package name */
    public Context f42627f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f42628g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.a0.b0<T> f42629h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0609a f42630i;

    /* renamed from: d.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0609a {
        void a(d.a.o0.r.q.a aVar);
    }

    public a(Context context) {
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
        this.f42628g = Boolean.FALSE;
        this.f42627f = context;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    public d.a.p0.a0.b0<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42629h : (d.a.p0.a0.b0) invokeV.objValue;
    }

    public final ThreadCardView e(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, view, i2)) == null) {
            if (view == null || view.getParent() == null || i2 == 0) {
                return null;
            }
            if (view.getParent() instanceof ThreadCardView) {
                return (ThreadCardView) view.getParent();
            }
            return e((View) view.getParent(), i2 - 1);
        }
        return (ThreadCardView) invokeLI.objValue;
    }

    public Boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42628g : (Boolean) invokeV.objValue;
    }

    public abstract View g();

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void i(int i2, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, bVar) == null) {
            this.f42626e.m(i2, bVar);
        }
    }

    public void j(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l0Var) == null) {
            this.f42626e = l0Var;
        }
    }

    public void k(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(d.a.p0.a0.b0<T> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b0Var) == null) {
            this.f42629h = b0Var;
        }
    }

    public void m(View view, int i2) {
        ThreadCardView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) || (e2 = e(view, i2)) == null) {
            return;
        }
        d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(e2);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
    }

    public void n(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bool) == null) {
            this.f42628g = bool;
        }
    }
}
