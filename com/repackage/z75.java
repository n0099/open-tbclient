package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class z75 {
    public static /* synthetic */ Interceptable $ic;
    public static z75 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes7.dex */
    public class a extends w75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(z75 z75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.w75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.w75
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends w75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z75 b;

        public b(z75 z75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z75Var;
        }

        @Override // com.repackage.w75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
        }

        @Override // com.repackage.w75
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755159079, "Lcom/repackage/z75;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755159079, "Lcom/repackage/z75;");
        }
    }

    public z75() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = false;
    }

    public static z75 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (z75.class) {
                    if (d == null) {
                        d = new z75();
                    }
                }
            }
            return d;
        }
        return (z75) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return wt4.k().l("page_stay_max_cost", 0);
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public final boolean d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            return "a026".equals(list.get(list.size() - 1)) || e(list);
        }
        return invokeL.booleanValue;
    }

    public final boolean e(List<String> list) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) ? !ListUtils.isEmpty(list) && (size = list.size()) >= 2 && "a026".equals(list.get(size - 2)) : invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b = i;
            wt4.k().w("page_stay_max_cost", this.b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a = z;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public void k(Context context, y75 y75Var, w75 w75Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, y75Var, w75Var) == null) || y75Var == null || StringUtils.isNull(y75Var.c())) {
            return;
        }
        if (y75Var.a) {
            if (w75Var == null) {
                w75Var = new a(this);
            }
            if (w75Var.a(y75Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", x75.a(y75Var.h()));
                statisticItem.param("obj_locate", y75Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(y75Var.i)) {
                    statisticItem.param("obj_id", y75Var.i);
                }
                if (y75Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, y75Var.b());
                }
                r75.b(context, statisticItem, y75Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (w75Var == null) {
            w75Var = new b(this);
        }
        if (w75Var.d() && w75Var.a(y75Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", x75.a(y75Var.h()));
            statisticItem2.param("obj_type", y75Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(y75Var.i()));
            if (!StringUtils.isNull(y75Var.n())) {
                statisticItem2.param("topic_id", y75Var.n());
            }
            if (!StringUtils.isNull(y75Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, y75Var.o());
            }
            if (y75Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(y75Var.d()));
            }
            if (y75Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(y75Var.m()));
            }
            if (y75Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(y75Var.l()));
            }
            if (!StringUtils.isNull(y75Var.e())) {
                statisticItem2.param("nid", y75Var.e());
            }
            if (y75Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(y75Var.g()));
            }
            if (!StringUtils.isNull(y75Var.k)) {
                statisticItem2.param("obj_param1", y75Var.k);
            }
            if (!StringUtils.isNull(y75Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, y75Var.l);
            }
            if (!StringUtils.isNull(y75Var.r)) {
                statisticItem2.param("is_dynamic", y75Var.r);
            }
            if (!StringUtils.isNull(y75Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, y75Var.s);
            }
            if (!StringUtils.isNull(y75Var.t)) {
                statisticItem2.param("resource_type", y75Var.t);
            }
            if (!ni.isEmpty(y75Var.j())) {
                statisticItem2.param("task_id", String.valueOf(y75Var.j()));
            }
            if (!ni.isEmpty(y75Var.a())) {
                statisticItem2.param("ab_tag", y75Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(y75Var.i)) {
                    statisticItem2.param("obj_id", y75Var.i);
                }
                if (!StringUtils.isNull(y75Var.j)) {
                    statisticItem2.param("obj_name", y75Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(y75Var.f())) {
                statisticItem2.param("obj_location", y75Var.f());
            }
            if (y75Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, y75Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && y75Var.h() != null && d(y75Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(y75Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            r75.b(context, statisticItem2, y75Var);
            TiebaStatic.log(statisticItem2);
        }
    }
}
