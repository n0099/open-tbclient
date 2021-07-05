package d.a.s0.v.i.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<b2> f68013a;

    /* renamed from: b  reason: collision with root package name */
    public List<b2> f68014b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68015c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68016d;

    /* renamed from: e  reason: collision with root package name */
    public int f68017e;

    /* renamed from: f  reason: collision with root package name */
    public int f68018f;

    /* renamed from: g  reason: collision with root package name */
    public int f68019g;

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
        this.f68017e = 2;
        this.f68018f = 2;
        this.f68019g = 1;
        this.f68016d = z;
        this.f68018f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f68015c) {
                int size = this.f68014b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f68019g;
                }
                int i3 = this.f68019g;
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
            List<b2> list = this.f68013a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f68015c ? i2 - this.f68019g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f68015c) {
                return this.f68019g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<b2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68014b : (List) invokeV.objValue;
    }

    public final List<b2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<b2> list = this.f68013a;
            if (list != null) {
                if (this.f68015c) {
                    if (list.size() > this.f68018f && this.f68013a.size() >= this.f68019g) {
                        arrayList.addAll(this.f68013a.subList(0, this.f68018f));
                        List<b2> list2 = this.f68013a;
                        int i2 = this.f68018f;
                        arrayList.addAll(0, list2.subList(i2 - this.f68019g, i2));
                        arrayList.addAll(this.f68013a.subList(0, this.f68019g));
                    } else {
                        arrayList.addAll(this.f68013a);
                        List<b2> list3 = this.f68013a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f68019g, this.f68013a.size()));
                        arrayList.addAll(this.f68013a.subList(0, this.f68019g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f68013a.size();
                    int i3 = this.f68019g;
                    if (size >= i3) {
                        arrayList.addAll(this.f68013a.subList(0, i3));
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
            this.f68019g = i2;
            j(this.f68013a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f68018f = i2;
            j(this.f68013a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f68017e = i2;
            j(this.f68013a);
        }
    }

    public void j(List<b2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.f68013a = list;
        if (list != null && list.size() >= this.f68017e && list.size() <= this.f68018f) {
            this.f68015c = true;
        } else if (list.size() > this.f68018f && this.f68016d) {
            this.f68015c = true;
        } else {
            this.f68015c = false;
        }
        this.f68014b = f();
    }
}
