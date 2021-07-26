package d.a.k;

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
import d.a.k.v0.a;
import d.a.p0.s.q.a;
/* loaded from: classes7.dex */
public abstract class a<T extends d.a.p0.s.q.a> implements q, p<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public l0 f43130e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43131f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f43132g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.a0.b0<T> f43133h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0618a f43134i;

    /* renamed from: d.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0618a {
        void a(d.a.p0.s.q.a aVar);
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
        this.f43132g = Boolean.FALSE;
        this.f43131f = context;
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

    public d.a.q0.a0.b0<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43133h : (d.a.q0.a0.b0) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43132g : (Boolean) invokeV.objValue;
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
            this.f43130e.m(i2, bVar);
        }
    }

    public void j(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l0Var) == null) {
            this.f43130e = l0Var;
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

    public void l(d.a.q0.a0.b0<T> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b0Var) == null) {
            this.f43133h = b0Var;
        }
    }

    public void m(View view, int i2) {
        ThreadCardView e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) || (e2 = e(view, i2)) == null) {
            return;
        }
        d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(e2);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
    }

    public void n(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bool) == null) {
            this.f43132g = bool;
        }
    }
}
