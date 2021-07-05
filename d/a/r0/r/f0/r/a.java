package d.a.r0.r.f0.r;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.f0.r.a;
/* loaded from: classes9.dex */
public abstract class a<T extends a> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f55686h = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f55687a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55688b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f55689c;

    /* renamed from: d  reason: collision with root package name */
    public int f55690d;

    /* renamed from: e  reason: collision with root package name */
    public int f55691e;

    /* renamed from: f  reason: collision with root package name */
    public int f55692f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1255a f55693g;

    /* renamed from: d.a.r0.r.f0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1255a {
        void a(int i2, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1602134541, "Ld/a/r0/r/f0/r/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1602134541, "Ld/a/r0/r/f0/r/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i4 = f55686h;
        f55686h = i4 + 1;
        this.f55687a = i4;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i2, i3, i4) == null) {
            this.f55689c = editable;
            this.f55690d = i2;
            this.f55691e = i3;
            this.f55692f = i4;
        }
    }

    public void b(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.f55688b = t.h();
            this.f55689c = t.g();
            this.f55690d = t.f();
            this.f55691e = t.c();
            this.f55692f = t.d();
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55691e : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55692f : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55687a : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55690d : invokeV.intValue;
    }

    public Editable g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55689c : (Editable) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f55688b : invokeV.booleanValue;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence) == null) || (editable = this.f55689c) == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f55690d, this.f55691e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f55691e = this.f55690d + charSequence.length();
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f55691e = i2;
        }
    }

    public void k(InterfaceC1255a interfaceC1255a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC1255a) == null) {
            this.f55693g = interfaceC1255a;
        }
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048587, this, obj, i2, i3, i4) == null) || (editable = this.f55689c) == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f55690d = i2;
        }
    }

    public void n(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editable) == null) {
            this.f55689c = editable;
        }
    }

    public void o(boolean z) {
        InterfaceC1255a interfaceC1255a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            boolean z2 = this.f55688b;
            this.f55688b = z;
            if (z2 == z || (interfaceC1255a = this.f55693g) == null) {
                return;
            }
            interfaceC1255a.a(this.f55687a, z);
        }
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
