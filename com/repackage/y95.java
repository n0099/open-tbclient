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
public class y95 {
    public static /* synthetic */ Interceptable $ic;
    public static y95 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes7.dex */
    public class a extends v95 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(y95 y95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.v95
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.v95
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
    public class b extends v95 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y95 b;

        public b(y95 y95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y95Var;
        }

        @Override // com.repackage.v95
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
        }

        @Override // com.repackage.v95
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755186948, "Lcom/repackage/y95;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755186948, "Lcom/repackage/y95;");
        }
    }

    public y95() {
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

    public static y95 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (y95.class) {
                    if (d == null) {
                        d = new y95();
                    }
                }
            }
            return d;
        }
        return (y95) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return ru4.k().l("page_stay_max_cost", 0);
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
            ru4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, x95 x95Var, v95 v95Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, x95Var, v95Var) == null) || x95Var == null || StringUtils.isNull(x95Var.c())) {
            return;
        }
        if (x95Var.a) {
            if (v95Var == null) {
                v95Var = new a(this);
            }
            if (v95Var.a(x95Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", w95.a(x95Var.h()));
                statisticItem.param("obj_locate", x95Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(x95Var.i)) {
                    statisticItem.param("obj_id", x95Var.i);
                }
                if (x95Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, x95Var.b());
                }
                q95.b(context, statisticItem, x95Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (v95Var == null) {
            v95Var = new b(this);
        }
        if (v95Var.d() && v95Var.a(x95Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", w95.a(x95Var.h()));
            statisticItem2.param("obj_type", x95Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(x95Var.i()));
            if (!StringUtils.isNull(x95Var.n())) {
                statisticItem2.param("topic_id", x95Var.n());
            }
            if (!StringUtils.isNull(x95Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, x95Var.o());
            }
            if (x95Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(x95Var.d()));
            }
            if (x95Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(x95Var.m()));
            }
            if (x95Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(x95Var.l()));
            }
            if (!StringUtils.isNull(x95Var.e())) {
                statisticItem2.param("nid", x95Var.e());
            }
            if (x95Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(x95Var.g()));
            }
            if (!StringUtils.isNull(x95Var.k)) {
                statisticItem2.param("obj_param1", x95Var.k);
            }
            if (!StringUtils.isNull(x95Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, x95Var.l);
            }
            if (!StringUtils.isNull(x95Var.r)) {
                statisticItem2.param("is_dynamic", x95Var.r);
            }
            if (!StringUtils.isNull(x95Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, x95Var.s);
            }
            if (!StringUtils.isNull(x95Var.t)) {
                statisticItem2.param("resource_type", x95Var.t);
            }
            if (!pi.isEmpty(x95Var.j())) {
                statisticItem2.param("task_id", String.valueOf(x95Var.j()));
            }
            if (!pi.isEmpty(x95Var.a())) {
                statisticItem2.param("ab_tag", x95Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(x95Var.i)) {
                    statisticItem2.param("obj_id", x95Var.i);
                }
                if (!StringUtils.isNull(x95Var.j)) {
                    statisticItem2.param("obj_name", x95Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(x95Var.f())) {
                statisticItem2.param("obj_location", x95Var.f());
            }
            if (x95Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, x95Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && x95Var.h() != null && d(x95Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(x95Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            q95.b(context, statisticItem2, x95Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(x95Var.i())).param("obj_source", w95.a(x95Var.h())).param("obj_locate", x95Var.c()).param("obj_param1", et4.a().b()));
        }
    }
}
