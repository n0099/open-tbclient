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
/* loaded from: classes5.dex */
public class a95 {
    public static /* synthetic */ Interceptable $ic;
    public static a95 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a extends x85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(a95 a95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.x85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.x85
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends x85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a95 b;

        public b(a95 a95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a95Var;
        }

        @Override // com.repackage.x85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
        }

        @Override // com.repackage.x85
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755901932, "Lcom/repackage/a95;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755901932, "Lcom/repackage/a95;");
        }
    }

    public a95() {
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

    public static a95 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (a95.class) {
                    if (d == null) {
                        d = new a95();
                    }
                }
            }
            return d;
        }
        return (a95) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return yt4.k().l("page_stay_max_cost", 0);
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
            yt4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, z85 z85Var, x85 x85Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, z85Var, x85Var) == null) || z85Var == null || StringUtils.isNull(z85Var.c())) {
            return;
        }
        if (z85Var.a) {
            if (x85Var == null) {
                x85Var = new a(this);
            }
            if (x85Var.a(z85Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", y85.a(z85Var.h()));
                statisticItem.param("obj_locate", z85Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(z85Var.i)) {
                    statisticItem.param("obj_id", z85Var.i);
                }
                if (z85Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, z85Var.b());
                }
                s85.b(context, statisticItem, z85Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (x85Var == null) {
            x85Var = new b(this);
        }
        if (x85Var.d() && x85Var.a(z85Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", y85.a(z85Var.h()));
            statisticItem2.param("obj_type", z85Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(z85Var.i()));
            if (!StringUtils.isNull(z85Var.n())) {
                statisticItem2.param("topic_id", z85Var.n());
            }
            if (!StringUtils.isNull(z85Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, z85Var.o());
            }
            if (z85Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(z85Var.d()));
            }
            if (z85Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(z85Var.m()));
            }
            if (z85Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(z85Var.l()));
            }
            if (!StringUtils.isNull(z85Var.e())) {
                statisticItem2.param("nid", z85Var.e());
            }
            if (z85Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(z85Var.g()));
            }
            if (!StringUtils.isNull(z85Var.k)) {
                statisticItem2.param("obj_param1", z85Var.k);
            }
            if (!StringUtils.isNull(z85Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, z85Var.l);
            }
            if (!StringUtils.isNull(z85Var.r)) {
                statisticItem2.param("is_dynamic", z85Var.r);
            }
            if (!StringUtils.isNull(z85Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, z85Var.s);
            }
            if (!StringUtils.isNull(z85Var.t)) {
                statisticItem2.param("resource_type", z85Var.t);
            }
            if (!oi.isEmpty(z85Var.j())) {
                statisticItem2.param("task_id", String.valueOf(z85Var.j()));
            }
            if (!oi.isEmpty(z85Var.a())) {
                statisticItem2.param("ab_tag", z85Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(z85Var.i)) {
                    statisticItem2.param("obj_id", z85Var.i);
                }
                if (!StringUtils.isNull(z85Var.j)) {
                    statisticItem2.param("obj_name", z85Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(z85Var.f())) {
                statisticItem2.param("obj_location", z85Var.f());
            }
            if (z85Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, z85Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && z85Var.h() != null && d(z85Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(z85Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            s85.b(context, statisticItem2, z85Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(z85Var.i())).param("obj_source", y85.a(z85Var.h())).param("obj_locate", z85Var.c()).param("obj_param1", ns4.a().b()));
        }
    }
}
