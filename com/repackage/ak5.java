package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class ak5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ak5 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;
    public xj5 b;
    public zj5 c;
    public List<StatisticItem> d;

    public ak5() {
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
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.a = arrayList;
        arrayList.add(1);
        this.a.add(2);
        zj5 zj5Var = new zj5();
        this.c = zj5Var;
        this.b = new xj5(zj5Var, this.a);
        g(yt4.k().l("key_abtest_channel", 0));
    }

    public static ak5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (zj5.class) {
                    if (e == null) {
                        e = new ak5();
                    }
                }
            }
            return e;
        }
        return (ak5) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(statisticItem);
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            xj5 xj5Var = this.b;
            if (xj5Var == null) {
                return 0;
            }
            return xj5Var.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void d(String str) {
        zj5 zj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (oi.isEmpty(str) || (zj5Var = this.c) == null || !zj5Var.g()) {
                l39.d(str);
            }
        }
    }

    public void e(String str) {
        zj5 zj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (oi.isEmpty(str) || (zj5Var = this.c) == null || !zj5Var.g()) {
                l39.e(str);
            }
        }
    }

    public void f(String str) {
        xj5 xj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (xj5Var = this.b) == null) {
            return;
        }
        xj5Var.b(str);
    }

    public void g(int i) {
        zj5 zj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (zj5Var = this.c) == null) {
            return;
        }
        zj5Var.k(i);
    }

    public void h(String str, String str2) {
        zj5 zj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || ListUtils.isEmpty(this.d) || (zj5Var = this.c) == null || !zj5Var.g()) {
            return;
        }
        int i = -1;
        for (StatisticItem statisticItem : this.d) {
            if (statisticItem != null) {
                if (statisticItem.getPosition() == 0) {
                    i(str, str2, statisticItem);
                } else if (i != statisticItem.getPosition()) {
                    i = statisticItem.getPosition();
                    i(str, str2, statisticItem);
                }
            }
        }
        this.d.clear();
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        zj5 zj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) || statisticItem == null || (zj5Var = this.c) == null || !zj5Var.g()) {
            return;
        }
        HashMap hashMap = new HashMap();
        List<Object> params = statisticItem.getParams();
        if (params != null) {
            int size = params.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = params.get(i);
                String obj2 = obj != null ? obj.toString() : "";
                Object obj3 = params.get(i + 1);
                hashMap.put(obj2, obj3 != null ? obj3.toString() : "");
            }
        }
        l39.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
