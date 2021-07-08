package d.a.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42668a;

    /* renamed from: b  reason: collision with root package name */
    public int f42669b;

    /* renamed from: c  reason: collision with root package name */
    public int f42670c;

    /* renamed from: d  reason: collision with root package name */
    public int f42671d;

    /* renamed from: e  reason: collision with root package name */
    public int f42672e;

    /* renamed from: f  reason: collision with root package name */
    public int f42673f;

    /* renamed from: g  reason: collision with root package name */
    public int f42674g;

    /* renamed from: h  reason: collision with root package name */
    public int f42675h;

    /* renamed from: i  reason: collision with root package name */
    public int f42676i;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-465756306, "Ld/a/j/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-465756306, "Ld/a/j/m0;");
                return;
            }
        }
        k = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        l = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        m = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        n = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        o = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
        p = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0);
        q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public m0() {
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
        this.f42668a = false;
        this.f42669b = n;
        this.f42670c = p;
        this.f42671d = k;
        this.f42672e = 0;
        this.f42673f = l;
        this.f42674g = m;
        this.f42675h = R.color.CAM_X0205;
        this.f42676i = q;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f42675h = i2;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f42672e = i2;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f42676i = i2;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f42673f = i2;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f42674g = i2;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f42669b = i2;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f42671d = i2;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }
}
