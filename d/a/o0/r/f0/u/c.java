package d.a.o0.r.f0.u;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f52436a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f52437b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52438c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52439d;

    /* renamed from: e  reason: collision with root package name */
    public int f52440e;

    /* renamed from: f  reason: collision with root package name */
    public int f52441f;

    /* renamed from: g  reason: collision with root package name */
    public int f52442g;

    public c(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52440e = 2;
        this.f52441f = 2;
        this.f52442g = 1;
        this.f52436a = list;
        this.f52439d = z;
        this.f52441f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f52438c) {
                int size = this.f52437b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f52442g;
                }
                int i3 = this.f52442g;
                return i2 == size - i3 ? i3 : i2;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<n> list = this.f52436a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f52438c ? i2 - this.f52442g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f52438c) {
                return this.f52442g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52437b : (List) invokeV.objValue;
    }

    public final List<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<n> list = this.f52436a;
            if (list != null) {
                if (this.f52438c) {
                    if (list.size() > this.f52441f && this.f52436a.size() >= this.f52442g) {
                        arrayList.addAll(this.f52436a.subList(0, this.f52441f));
                        List<n> list2 = this.f52436a;
                        int i2 = this.f52441f;
                        arrayList.addAll(0, list2.subList(i2 - this.f52442g, i2));
                        arrayList.addAll(this.f52436a.subList(0, this.f52442g));
                    } else {
                        arrayList.addAll(this.f52436a);
                        List<n> list3 = this.f52436a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f52442g, this.f52436a.size()));
                        arrayList.addAll(this.f52436a.subList(0, this.f52442g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f52436a.size();
                    int i3 = this.f52442g;
                    if (size >= i3) {
                        arrayList.addAll(this.f52436a.subList(0, i3));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f52442g = i2;
            j(this.f52436a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f52441f = i2;
            j(this.f52436a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f52440e = i2;
            j(this.f52436a);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null && list.size() >= this.f52440e && list.size() <= this.f52441f) {
                this.f52438c = true;
            } else if (list.size() > this.f52441f && this.f52439d) {
                this.f52438c = true;
            } else {
                this.f52438c = false;
            }
            this.f52437b = f();
        }
    }
}
