package d.a.s0.o;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.SampleResult;
import d.a.c.e.p.k;
import d.a.w0.a.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64292a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64293b;

    public c() {
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
        this.f64293b = false;
        i();
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 1) {
                return d(i2);
            }
            int i3 = this.f64292a;
            if (i3 == 1) {
                return c(i2);
            }
            if (i3 == 0) {
                return d(i2);
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void b(ArrayList<Integer> arrayList, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, bVar) == null) || arrayList == null || bVar == null) {
            return;
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            bVar.b(intValue, a(intValue));
        }
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            String e2 = e(i2);
            if (k.isEmpty(e2)) {
                return 0;
            }
            SampleResult a2 = d.a.w0.a.a.a(e2);
            return (a2 == SampleResult.T1 || a2 == SampleResult.T2 || a2 == SampleResult.T3 || a2 == SampleResult.T4 || a2 == SampleResult.T5) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            String f2 = f(i2);
            return (!k.isEmpty(f2) && d.a.r0.r.d0.b.j().k(f2, 0) == 1) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    public final String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 == 2) {
                return "46";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final String f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 == 1) {
                return "key_card_show_type";
            }
            if (i2 == 2) {
                return "key_card_abstract_switch";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64293b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                try {
                    b.a aVar = new b.a();
                    aVar.e(TbadkCoreApplication.getInst());
                    aVar.j(false);
                    aVar.n(30L);
                    aVar.m(1);
                    aVar.l(false);
                    aVar.o(15L);
                    aVar.k(1000);
                    d.a.w0.a.a.b(aVar.c());
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f64292a = d.a.r0.r.d0.b.j().k("key_abtest_channel", 0);
            j();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.f64293b && this.f64292a == 1) {
            boolean h2 = h();
            this.f64293b = h2;
            if (h2) {
                return;
            }
            this.f64292a = 0;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 == 1 || i2 == 0) {
                this.f64292a = i2;
                d.a.r0.r.d0.b.j().v("key_abtest_channel", this.f64292a);
                j();
            }
        }
    }
}
