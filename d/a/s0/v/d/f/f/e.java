package d.a.s0.v.d.f.f;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67791a;

    /* renamed from: b  reason: collision with root package name */
    public a f67792b;

    /* renamed from: c  reason: collision with root package name */
    public int f67793c;

    public e(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67793c = -1;
        this.f67791a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.a(viewGroup);
    }

    public void b(d.a.s0.v.d.f.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            if (aVar == null) {
                this.f67793c = -1;
                this.f67792b = new b(this.f67791a);
            } else if (z) {
                int i2 = aVar.f67731d;
                this.f67793c = i2;
                if (i2 == 1) {
                    this.f67792b = new d(this.f67791a);
                } else if (i2 == 2) {
                    this.f67792b = new f(this.f67791a);
                } else if (i2 != 3) {
                    this.f67792b = new b(this.f67791a);
                } else {
                    this.f67792b = new c(this.f67791a);
                }
            }
            if (this.f67792b.f(aVar)) {
                if (z) {
                    this.f67792b.d();
                }
                this.f67792b.b(aVar);
                return;
            }
            this.f67793c = -1;
            b bVar = new b(this.f67791a);
            this.f67792b = bVar;
            if (z) {
                bVar.d();
            }
            this.f67792b.b(aVar);
        }
    }

    public boolean c(d.a.s0.v.d.f.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? aVar == null || this.f67793c != aVar.f67731d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.g(z);
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.h();
    }

    public void f(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.i(i2);
    }

    public void g() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.j();
    }

    public void h() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.k();
    }

    public void i() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.l();
    }

    public void j() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.m();
    }

    public void k() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.f67792b) == null) {
            return;
        }
        aVar.n();
    }
}
