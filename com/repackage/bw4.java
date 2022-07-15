package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nn> a;
    public List<nn> b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;

    public bw4(List<nn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 2;
        this.f = 2;
        this.g = 1;
        this.a = list;
        this.d = z;
        this.f = i;
        j(list);
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.c) {
                int size = this.b.size();
                if (i == 0) {
                    return (size - 1) - this.g;
                }
                int i2 = this.g;
                return i == size - i2 ? i2 : i;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<nn> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.c ? i - this.g : i : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c) {
                return this.g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<nn> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final List<nn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<nn> list = this.a;
            if (list != null) {
                if (this.c) {
                    if (list.size() > this.f && this.a.size() >= this.g) {
                        arrayList.addAll(this.a.subList(0, this.f));
                        List<nn> list2 = this.a;
                        int i = this.f;
                        arrayList.addAll(0, list2.subList(i - this.g, i));
                        arrayList.addAll(this.a.subList(0, this.g));
                    } else {
                        arrayList.addAll(this.a);
                        List<nn> list3 = this.a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.g, this.a.size()));
                        arrayList.addAll(this.a.subList(0, this.g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.a.size();
                    int i2 = this.g;
                    if (size >= i2) {
                        arrayList.addAll(this.a.subList(0, i2));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g = i;
            j(this.a);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f = i;
            j(this.a);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = i;
            j(this.a);
        }
    }

    public void j(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null && list.size() >= this.e && list.size() <= this.f) {
                this.c = true;
            } else if (list.size() > this.f && this.d) {
                this.c = true;
            } else {
                this.c = false;
            }
            this.b = f();
        }
    }
}
