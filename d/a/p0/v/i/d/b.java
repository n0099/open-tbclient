package d.a.p0.v.i.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b2> f64795a;

    /* renamed from: b  reason: collision with root package name */
    public List<b2> f64796b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64797c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64798d;

    /* renamed from: e  reason: collision with root package name */
    public int f64799e;

    /* renamed from: f  reason: collision with root package name */
    public int f64800f;

    /* renamed from: g  reason: collision with root package name */
    public int f64801g;

    public b(List<b2> list, boolean z, int i2) {
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
        this.f64799e = 2;
        this.f64800f = 2;
        this.f64801g = 1;
        this.f64798d = z;
        this.f64800f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f64797c) {
                int size = this.f64796b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f64801g;
                }
                int i3 = this.f64801g;
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
            List<b2> list = this.f64795a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f64797c ? i2 - this.f64801g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f64797c) {
                return this.f64801g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<b2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64796b : (List) invokeV.objValue;
    }

    public final List<b2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<b2> list = this.f64795a;
            if (list != null) {
                if (this.f64797c) {
                    if (list.size() > this.f64800f && this.f64795a.size() >= this.f64801g) {
                        arrayList.addAll(this.f64795a.subList(0, this.f64800f));
                        List<b2> list2 = this.f64795a;
                        int i2 = this.f64800f;
                        arrayList.addAll(0, list2.subList(i2 - this.f64801g, i2));
                        arrayList.addAll(this.f64795a.subList(0, this.f64801g));
                    } else {
                        arrayList.addAll(this.f64795a);
                        List<b2> list3 = this.f64795a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f64801g, this.f64795a.size()));
                        arrayList.addAll(this.f64795a.subList(0, this.f64801g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f64795a.size();
                    int i3 = this.f64801g;
                    if (size >= i3) {
                        arrayList.addAll(this.f64795a.subList(0, i3));
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
            this.f64801g = i2;
            j(this.f64795a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f64800f = i2;
            j(this.f64795a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f64799e = i2;
            j(this.f64795a);
        }
    }

    public void j(List<b2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.f64795a = list;
        if (list != null && list.size() >= this.f64799e && list.size() <= this.f64800f) {
            this.f64797c = true;
        } else if (list.size() > this.f64800f && this.f64798d) {
            this.f64797c = true;
        } else {
            this.f64797c = false;
        }
        this.f64796b = f();
    }
}
