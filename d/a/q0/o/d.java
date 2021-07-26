package d.a.q0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f61674e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f61675a;

    /* renamed from: b  reason: collision with root package name */
    public a f61676b;

    /* renamed from: c  reason: collision with root package name */
    public c f61677c;

    /* renamed from: d  reason: collision with root package name */
    public List<StatisticItem> f61678d;

    public d() {
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
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f61675a = arrayList;
        arrayList.add(1);
        this.f61675a.add(2);
        c cVar = new c();
        this.f61677c = cVar;
        this.f61676b = new a(cVar, this.f61675a);
        g(d.a.p0.s.d0.b.j().k("key_abtest_channel", 0));
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61674e == null) {
                synchronized (c.class) {
                    if (f61674e == null) {
                        f61674e = new d();
                    }
                }
            }
            return f61674e;
        }
        return (d) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.f61678d == null) {
            this.f61678d = new ArrayList();
        }
        this.f61678d.add(statisticItem);
    }

    public int b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            a aVar = this.f61676b;
            if (aVar == null) {
                return 0;
            }
            return aVar.a(str, i2);
        }
        return invokeLI.intValue;
    }

    public void d(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (k.isEmpty(str) || (cVar = this.f61677c) == null || !cVar.g()) {
                d.a.u0.a.a.d(str);
            }
        }
    }

    public void e(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (k.isEmpty(str) || (cVar = this.f61677c) == null || !cVar.g()) {
                d.a.u0.a.a.e(str);
            }
        }
    }

    public void f(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (aVar = this.f61676b) == null) {
            return;
        }
        aVar.b(str);
    }

    public void g(int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (cVar = this.f61677c) == null) {
            return;
        }
        cVar.k(i2);
    }

    public void h(String str, String str2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || ListUtils.isEmpty(this.f61678d) || (cVar = this.f61677c) == null || !cVar.g()) {
            return;
        }
        int i2 = -1;
        for (StatisticItem statisticItem : this.f61678d) {
            if (statisticItem != null) {
                if (statisticItem.getPosition() == 0) {
                    i(str, str2, statisticItem);
                } else if (i2 != statisticItem.getPosition()) {
                    i2 = statisticItem.getPosition();
                    i(str, str2, statisticItem);
                }
            }
        }
        this.f61678d.clear();
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) || statisticItem == null || (cVar = this.f61677c) == null || !cVar.g()) {
            return;
        }
        HashMap hashMap = new HashMap();
        List<Object> params = statisticItem.getParams();
        if (params != null) {
            int size = params.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                Object obj = params.get(i2);
                String obj2 = obj != null ? obj.toString() : "";
                Object obj3 = params.get(i2 + 1);
                hashMap.put(obj2, obj3 != null ? obj3.toString() : "");
            }
        }
        d.a.u0.a.a.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
