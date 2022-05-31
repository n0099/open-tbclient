package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.SampleResult;
import com.repackage.f29;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class zh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;

    public zh5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        i();
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 1) {
                return d(i);
            }
            int i2 = this.a;
            if (i2 == 1) {
                return c(i);
            }
            if (i2 == 0) {
                return d(i);
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void b(ArrayList<Integer> arrayList, yh5 yh5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, yh5Var) == null) || arrayList == null || yh5Var == null) {
            return;
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            yh5Var.b(intValue, a(intValue));
        }
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            String e = e(i);
            if (ki.isEmpty(e)) {
                return 0;
            }
            SampleResult a = e29.a(e);
            return (a == SampleResult.T1 || a == SampleResult.T2 || a == SampleResult.T3 || a == SampleResult.T4 || a == SampleResult.T5) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            String f = f(i);
            return (!ki.isEmpty(f) && ys4.k().l(f, 0) == 1) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    public final String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == 2) {
                return "46";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i == 1) {
                return "key_card_show_type";
            }
            if (i == 2) {
                return "key_card_abstract_switch";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                try {
                    f29.a aVar = new f29.a();
                    aVar.e(TbadkCoreApplication.getInst());
                    aVar.j(false);
                    aVar.n(30L);
                    aVar.m(1);
                    aVar.l(false);
                    aVar.o(15L);
                    aVar.k(1000);
                    e29.b(aVar.c());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
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
            this.a = ys4.k().l("key_abtest_channel", 0);
            j();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.b && this.a == 1) {
            boolean h = h();
            this.b = h;
            if (h) {
                return;
            }
            this.a = 0;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i == 1 || i == 0) {
                this.a = i;
                ys4.k().w("key_abtest_channel", this.a);
                j();
            }
        }
    }
}
