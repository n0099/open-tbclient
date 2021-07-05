package d.a.s0.l0.k.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f62959e;

    /* renamed from: f  reason: collision with root package name */
    public int f62960f;

    /* renamed from: g  reason: collision with root package name */
    public int f62961g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f62962h;

    /* renamed from: i  reason: collision with root package name */
    public List<c> f62963i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1649805659, "Ld/a/s0/l0/k/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1649805659, "Ld/a/s0/l0/k/c/d;");
                return;
            }
        }
        j = BdUniqueId.gen();
    }

    public d() {
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
        this.f62961g = 0;
    }

    public final c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d().size() <= 0) {
                return null;
            }
            b e2 = e();
            b e3 = e();
            if (e2 == null && e3 == null) {
                return null;
            }
            c cVar = new c();
            cVar.c(e2);
            cVar.d(e3);
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public List<b> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62962h : (List) invokeV.objValue;
    }

    public final b e() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f62961g < d().size()) {
                bVar = d().get(this.f62961g);
            } else if (this.f62960f >= d().size()) {
                return null;
            } else {
                this.f62961g = 0;
                bVar = d().get(this.f62961g);
            }
            this.f62961g++;
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62959e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? j : (BdUniqueId) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62960f : invokeV.intValue;
    }

    public List<c> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f62963i : (List) invokeV.objValue;
    }

    public List<c> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (d().size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.f62960f == 2) {
                if (c() != null) {
                    arrayList.add(c());
                }
            } else {
                c c2 = c();
                c c3 = c();
                if (c2 != null) {
                    arrayList.add(c2);
                }
                if (c3 != null) {
                    arrayList.add(c3);
                }
            }
            t(arrayList);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void p(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f62962h = list;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f62960f = i2;
        }
    }

    public final void t(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f62963i = list;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f62959e = str;
        }
    }
}
