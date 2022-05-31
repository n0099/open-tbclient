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
/* loaded from: classes6.dex */
public class j75 {
    public static /* synthetic */ Interceptable $ic;
    public static j75 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a extends g75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(j75 j75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.g75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.g75
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends g75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j75 b;

        public b(j75 j75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j75Var;
        }

        @Override // com.repackage.g75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.b : invokeV.intValue;
        }

        @Override // com.repackage.g75
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755635735, "Lcom/repackage/j75;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755635735, "Lcom/repackage/j75;");
        }
    }

    public j75() {
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

    public static j75 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (j75.class) {
                    if (d == null) {
                        d = new j75();
                    }
                }
            }
            return d;
        }
        return (j75) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return ys4.k().l("page_stay_max_cost", 0);
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
            ys4.k().w("page_stay_max_cost", this.b);
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

    public void k(Context context, i75 i75Var, g75 g75Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, i75Var, g75Var) == null) || i75Var == null || StringUtils.isNull(i75Var.c())) {
            return;
        }
        if (i75Var.a) {
            if (g75Var == null) {
                g75Var = new a(this);
            }
            if (g75Var.a(i75Var)) {
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", h75.a(i75Var.h()));
                statisticItem.param("obj_locate", i75Var.c());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(i75Var.i)) {
                    statisticItem.param("obj_id", i75Var.i);
                }
                if (i75Var.b() != 0) {
                    statisticItem.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, i75Var.b());
                }
                b75.b(context, statisticItem, i75Var);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        if (g75Var == null) {
            g75Var = new b(this);
        }
        if (g75Var.d() && g75Var.a(i75Var)) {
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", h75.a(i75Var.h()));
            statisticItem2.param("obj_type", i75Var.c());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(i75Var.i()));
            if (!StringUtils.isNull(i75Var.n())) {
                statisticItem2.param("topic_id", i75Var.n());
            }
            if (!StringUtils.isNull(i75Var.o())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, i75Var.o());
            }
            if (i75Var.d() > 0) {
                statisticItem2.param("fid", String.valueOf(i75Var.d()));
            }
            if (i75Var.m() > 0) {
                statisticItem2.param("tid", String.valueOf(i75Var.m()));
            }
            if (i75Var.l() > 0) {
                statisticItem2.param("thread_type", String.valueOf(i75Var.l()));
            }
            if (!StringUtils.isNull(i75Var.e())) {
                statisticItem2.param("nid", i75Var.e());
            }
            if (i75Var.g() > 0) {
                statisticItem2.param("pid", String.valueOf(i75Var.g()));
            }
            if (!StringUtils.isNull(i75Var.k)) {
                statisticItem2.param("obj_param1", i75Var.k);
            }
            if (!StringUtils.isNull(i75Var.l)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, i75Var.l);
            }
            if (!StringUtils.isNull(i75Var.r)) {
                statisticItem2.param("is_dynamic", i75Var.r);
            }
            if (!StringUtils.isNull(i75Var.s)) {
                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, i75Var.s);
            }
            if (!StringUtils.isNull(i75Var.t)) {
                statisticItem2.param("resource_type", i75Var.t);
            }
            if (!ki.isEmpty(i75Var.j())) {
                statisticItem2.param("task_id", String.valueOf(i75Var.j()));
            }
            if (!ki.isEmpty(i75Var.a())) {
                statisticItem2.param("ab_tag", i75Var.a());
            }
            if (g()) {
                if (!StringUtils.isNull(i75Var.i)) {
                    statisticItem2.param("obj_id", i75Var.i);
                }
                if (!StringUtils.isNull(i75Var.j)) {
                    statisticItem2.param("obj_name", i75Var.j);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(i75Var.f())) {
                statisticItem2.param("obj_location", i75Var.f());
            }
            if (i75Var.b() != 0) {
                statisticItem2.param(TiebaStatic.Params.T_PLUS_AD_SOURCE, i75Var.b());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && i75Var.h() != null && d(i75Var.h())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (e(i75Var.h())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            b75.b(context, statisticItem2, i75Var);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(i75Var.i())).param("obj_source", h75.a(i75Var.h())).param("obj_locate", i75Var.c()).param("obj_param1", or4.a().b()));
        }
    }
}
