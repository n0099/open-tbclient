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
public class x75 {
    public static /* synthetic */ Interceptable $ic;
    public static x75 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes7.dex */
    public class a extends u75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(x75 x75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.u75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.u75
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
    public class b extends u75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x75 b;

        public b(x75 x75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x75Var;
        }

        @Override // com.repackage.u75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
        }

        @Override // com.repackage.u75
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755218661, "Lcom/repackage/x75;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755218661, "Lcom/repackage/x75;");
        }
    }

    public x75() {
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

    public static x75 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (x75.class) {
                    if (d == null) {
                        d = new x75();
                    }
                }
            }
            return d;
        }
        return (x75) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return ht4.k().l("page_stay_max_cost", 0);
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
            ht4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, w75 w75Var, u75 u75Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, w75Var, u75Var) == null) || w75Var == null || StringUtils.isNull(w75Var.c())) {
            return;
        }
        if (w75Var.a) {
            if (u75Var == null) {
                u75Var = new a(this);
            }
            if (u75Var.a(w75Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", v75.a(w75Var.h()));
                statisticItem.param("obj_locate", w75Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(w75Var.i)) {
                    statisticItem.param("obj_id", w75Var.i);
                }
                if (w75Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, w75Var.b());
                }
                p75.b(context, statisticItem, w75Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (u75Var == null) {
            u75Var = new b(this);
        }
        if (u75Var.d() && u75Var.a(w75Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", v75.a(w75Var.h()));
            statisticItem2.param("obj_type", w75Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(w75Var.i()));
            if (!StringUtils.isNull(w75Var.n())) {
                statisticItem2.param("topic_id", w75Var.n());
            }
            if (!StringUtils.isNull(w75Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, w75Var.o());
            }
            if (w75Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(w75Var.d()));
            }
            if (w75Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(w75Var.m()));
            }
            if (w75Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(w75Var.l()));
            }
            if (!StringUtils.isNull(w75Var.e())) {
                statisticItem2.param("nid", w75Var.e());
            }
            if (w75Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(w75Var.g()));
            }
            if (!StringUtils.isNull(w75Var.k)) {
                statisticItem2.param("obj_param1", w75Var.k);
            }
            if (!StringUtils.isNull(w75Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, w75Var.l);
            }
            if (!StringUtils.isNull(w75Var.r)) {
                statisticItem2.param("is_dynamic", w75Var.r);
            }
            if (!StringUtils.isNull(w75Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, w75Var.s);
            }
            if (!StringUtils.isNull(w75Var.t)) {
                statisticItem2.param("resource_type", w75Var.t);
            }
            if (!oi.isEmpty(w75Var.j())) {
                statisticItem2.param("task_id", String.valueOf(w75Var.j()));
            }
            if (!oi.isEmpty(w75Var.a())) {
                statisticItem2.param("ab_tag", w75Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(w75Var.i)) {
                    statisticItem2.param("obj_id", w75Var.i);
                }
                if (!StringUtils.isNull(w75Var.j)) {
                    statisticItem2.param("obj_name", w75Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(w75Var.f())) {
                statisticItem2.param("obj_location", w75Var.f());
            }
            if (w75Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, w75Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && w75Var.h() != null && d(w75Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(w75Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            p75.b(context, statisticItem2, w75Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(w75Var.i())).param("obj_source", v75.a(w75Var.h())).param("obj_locate", w75Var.c()).param("obj_param1", xr4.a().b()));
        }
    }
}
