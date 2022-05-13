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
/* loaded from: classes6.dex */
public class gj5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gj5 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;
    public dj5 b;
    public fj5 c;
    public List<StatisticItem> d;

    public gj5() {
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
        fj5 fj5Var = new fj5();
        this.c = fj5Var;
        this.b = new dj5(fj5Var, this.a);
        g(iu4.k().l("key_abtest_channel", 0));
    }

    public static gj5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (fj5.class) {
                    if (e == null) {
                        e = new gj5();
                    }
                }
            }
            return e;
        }
        return (gj5) invokeV.objValue;
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
            dj5 dj5Var = this.b;
            if (dj5Var == null) {
                return 0;
            }
            return dj5Var.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void d(String str) {
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (li.isEmpty(str) || (fj5Var = this.c) == null || !fj5Var.g()) {
                b59.d(str);
            }
        }
    }

    public void e(String str) {
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (li.isEmpty(str) || (fj5Var = this.c) == null || !fj5Var.g()) {
                b59.e(str);
            }
        }
    }

    public void f(String str) {
        dj5 dj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (dj5Var = this.b) == null) {
            return;
        }
        dj5Var.b(str);
    }

    public void g(int i) {
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (fj5Var = this.c) == null) {
            return;
        }
        fj5Var.k(i);
    }

    public void h(String str, String str2) {
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || ListUtils.isEmpty(this.d) || (fj5Var = this.c) == null || !fj5Var.g()) {
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
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) || statisticItem == null || (fj5Var = this.c) == null || !fj5Var.g()) {
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
        b59.c(str2 + statisticItem.getKey(), str, "", hashMap);
    }
}
