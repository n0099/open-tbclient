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
public class ai5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ai5 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;
    public xh5 b;
    public zh5 c;
    public List<StatisticItem> d;

    public ai5() {
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
        zh5 zh5Var = new zh5();
        this.c = zh5Var;
        this.b = new xh5(zh5Var, this.a);
        g(ys4.k().l("key_abtest_channel", 0));
    }

    public static ai5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (zh5.class) {
                    if (e == null) {
                        e = new ai5();
                    }
                }
            }
            return e;
        }
        return (ai5) invokeV.objValue;
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
            xh5 xh5Var = this.b;
            if (xh5Var == null) {
                return 0;
            }
            return xh5Var.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void d(String str) {
        zh5 zh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (ki.isEmpty(str) || (zh5Var = this.c) == null || !zh5Var.g()) {
                e29.d(str);
            }
        }
    }

    public void e(String str) {
        zh5 zh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (ki.isEmpty(str) || (zh5Var = this.c) == null || !zh5Var.g()) {
                e29.e(str);
            }
        }
    }

    public void f(String str) {
        xh5 xh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (xh5Var = this.b) == null) {
            return;
        }
        xh5Var.b(str);
    }

    public void g(int i) {
        zh5 zh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (zh5Var = this.c) == null) {
            return;
        }
        zh5Var.k(i);
    }

    public void h(String str, String str2) {
        zh5 zh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || ListUtils.isEmpty(this.d) || (zh5Var = this.c) == null || !zh5Var.g()) {
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
        zh5 zh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) || statisticItem == null || (zh5Var = this.c) == null || !zh5Var.g()) {
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
        e29.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
