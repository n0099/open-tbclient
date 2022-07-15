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
public class z85 {
    public static /* synthetic */ Interceptable $ic;
    public static z85 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes7.dex */
    public class a extends w85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(z85 z85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.w85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.w85
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
    public class b extends w85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z85 b;

        public b(z85 z85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z85Var;
        }

        @Override // com.repackage.w85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
        }

        @Override // com.repackage.w85
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755158118, "Lcom/repackage/z85;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755158118, "Lcom/repackage/z85;");
        }
    }

    public z85() {
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

    public static z85 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (z85.class) {
                    if (d == null) {
                        d = new z85();
                    }
                }
            }
            return d;
        }
        return (z85) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return xt4.k().l("page_stay_max_cost", 0);
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
            xt4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, y85 y85Var, w85 w85Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, y85Var, w85Var) == null) || y85Var == null || StringUtils.isNull(y85Var.c())) {
            return;
        }
        if (y85Var.a) {
            if (w85Var == null) {
                w85Var = new a(this);
            }
            if (w85Var.a(y85Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", x85.a(y85Var.h()));
                statisticItem.param("obj_locate", y85Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(y85Var.i)) {
                    statisticItem.param("obj_id", y85Var.i);
                }
                if (y85Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, y85Var.b());
                }
                r85.b(context, statisticItem, y85Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (w85Var == null) {
            w85Var = new b(this);
        }
        if (w85Var.d() && w85Var.a(y85Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", x85.a(y85Var.h()));
            statisticItem2.param("obj_type", y85Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(y85Var.i()));
            if (!StringUtils.isNull(y85Var.n())) {
                statisticItem2.param("topic_id", y85Var.n());
            }
            if (!StringUtils.isNull(y85Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, y85Var.o());
            }
            if (y85Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(y85Var.d()));
            }
            if (y85Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(y85Var.m()));
            }
            if (y85Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(y85Var.l()));
            }
            if (!StringUtils.isNull(y85Var.e())) {
                statisticItem2.param("nid", y85Var.e());
            }
            if (y85Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(y85Var.g()));
            }
            if (!StringUtils.isNull(y85Var.k)) {
                statisticItem2.param("obj_param1", y85Var.k);
            }
            if (!StringUtils.isNull(y85Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, y85Var.l);
            }
            if (!StringUtils.isNull(y85Var.r)) {
                statisticItem2.param("is_dynamic", y85Var.r);
            }
            if (!StringUtils.isNull(y85Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, y85Var.s);
            }
            if (!StringUtils.isNull(y85Var.t)) {
                statisticItem2.param("resource_type", y85Var.t);
            }
            if (!oi.isEmpty(y85Var.j())) {
                statisticItem2.param("task_id", String.valueOf(y85Var.j()));
            }
            if (!oi.isEmpty(y85Var.a())) {
                statisticItem2.param("ab_tag", y85Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(y85Var.i)) {
                    statisticItem2.param("obj_id", y85Var.i);
                }
                if (!StringUtils.isNull(y85Var.j)) {
                    statisticItem2.param("obj_name", y85Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(y85Var.f())) {
                statisticItem2.param("obj_location", y85Var.f());
            }
            if (y85Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, y85Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && y85Var.h() != null && d(y85Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(y85Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            r85.b(context, statisticItem2, y85Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(y85Var.i())).param("obj_source", x85.a(y85Var.h())).param("obj_locate", y85Var.c()).param("obj_param1", ms4.a().b()));
        }
    }
}
