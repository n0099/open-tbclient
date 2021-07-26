package d.a.p0.s.f0.u;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f53100a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f53101b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53102c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53103d;

    /* renamed from: e  reason: collision with root package name */
    public int f53104e;

    /* renamed from: f  reason: collision with root package name */
    public int f53105f;

    /* renamed from: g  reason: collision with root package name */
    public int f53106g;

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
        this.f53104e = 2;
        this.f53105f = 2;
        this.f53106g = 1;
        this.f53100a = list;
        this.f53103d = z;
        this.f53105f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f53102c) {
                int size = this.f53101b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f53106g;
                }
                int i3 = this.f53106g;
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
            List<n> list = this.f53100a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f53102c ? i2 - this.f53106g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f53102c) {
                return this.f53106g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53101b : (List) invokeV.objValue;
    }

    public final List<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<n> list = this.f53100a;
            if (list != null) {
                if (this.f53102c) {
                    if (list.size() > this.f53105f && this.f53100a.size() >= this.f53106g) {
                        arrayList.addAll(this.f53100a.subList(0, this.f53105f));
                        List<n> list2 = this.f53100a;
                        int i2 = this.f53105f;
                        arrayList.addAll(0, list2.subList(i2 - this.f53106g, i2));
                        arrayList.addAll(this.f53100a.subList(0, this.f53106g));
                    } else {
                        arrayList.addAll(this.f53100a);
                        List<n> list3 = this.f53100a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f53106g, this.f53100a.size()));
                        arrayList.addAll(this.f53100a.subList(0, this.f53106g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f53100a.size();
                    int i3 = this.f53106g;
                    if (size >= i3) {
                        arrayList.addAll(this.f53100a.subList(0, i3));
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
            this.f53106g = i2;
            j(this.f53100a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f53105f = i2;
            j(this.f53100a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f53104e = i2;
            j(this.f53100a);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null && list.size() >= this.f53104e && list.size() <= this.f53105f) {
                this.f53102c = true;
            } else if (list.size() > this.f53105f && this.f53103d) {
                this.f53102c = true;
            } else {
                this.f53102c = false;
            }
            this.f53101b = f();
        }
    }
}
