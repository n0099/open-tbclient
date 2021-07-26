package d.a.q0.u0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b2> f63203a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63204b;

    /* renamed from: c  reason: collision with root package name */
    public w0 f63205c;

    /* renamed from: d  reason: collision with root package name */
    public AntiData f63206d;

    /* renamed from: e  reason: collision with root package name */
    public String f63207e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63208f;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.u0.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1668b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static b f63209a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(664606756, "Ld/a/q0/u0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(664606756, "Ld/a/q0/u0/b$b;");
                    return;
                }
            }
            f63209a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1668b.f63209a : (b) invokeV.objValue;
    }

    public boolean a(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2Var)) == null) {
            if (b2Var == null) {
                return false;
            }
            if (this.f63203a.size() > 29) {
                w0 w0Var = this.f63205c;
                if (w0Var != null) {
                    w0Var.b(1);
                }
                return false;
            }
            this.f63203a.add(b2Var);
            w0 w0Var2 = this.f63205c;
            if (w0Var2 != null) {
                w0Var2.c(this.f63203a.size(), 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<b2> it = this.f63203a.iterator();
            while (it.hasNext()) {
                b2 next = it.next();
                if (next != null) {
                    next.N3(false);
                }
            }
            this.f63203a.clear();
            w0 w0Var = this.f63205c;
            if (w0Var != null) {
                w0Var.c(0, 1);
            }
        }
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63206d : (AntiData) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63207e : (String) invokeV.objValue;
    }

    public List<b2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63203a : (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f63204b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f63208f : invokeV.booleanValue;
    }

    public void i(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || ListUtils.isEmpty(list) || ListUtils.isEmpty(this.f63203a)) {
            return;
        }
        Iterator<b2> it = this.f63203a.iterator();
        while (it.hasNext()) {
            b2 next = it.next();
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (StringHelper.equals(list.get(i2), next.d0())) {
                    it.remove();
                    break;
                } else {
                    i2++;
                }
            }
        }
        w0 w0Var = this.f63205c;
        if (w0Var != null) {
            w0Var.c(this.f63203a.size(), 1);
        }
    }

    public void j(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b2Var) == null) {
            this.f63203a.remove(b2Var);
            w0 w0Var = this.f63205c;
            if (w0Var != null) {
                w0Var.c(this.f63203a.size(), 1);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m(false, false);
            b();
        }
    }

    public void l(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, antiData) == null) {
            this.f63206d = antiData;
        }
    }

    public void m(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f63204b = z;
            w0 w0Var = this.f63205c;
            if (w0Var != null) {
                w0Var.a(z, z2, 1);
            }
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f63207e = str;
        }
    }

    public void o(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, w0Var) == null) {
            this.f63205c = w0Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f63208f = z;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63204b = false;
        this.f63203a = new ArrayList<>();
    }
}
