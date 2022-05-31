package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes5.dex */
public class dm5 implements kj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dm5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.kj2
    public boolean a(Context context, String str, ab3 ab3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, ab3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", sk5.l().p() == null ? "" : sk5.l().p());
            statisticItem.param("obj_param1", ab3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, ab3Var.e());
            TiebaStatic.log(statisticItem);
            if (ab3Var.j() == 10 && ab3Var.h() == 1013) {
                b(context, ab3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, ab3 ab3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ab3Var) == null) {
            hz2 a0 = hz2.a0();
            if (context == null || a0 == null) {
                return;
            }
            String i = m83.i(uk2.U().M(), a0.X().G());
            long h = ab3Var.h();
            String r = ab3Var.r();
            if (!(1020 == h && !TextUtils.isEmpty(r))) {
                r = db4.b().a(h);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(a0.V(), r, "v" + bd3.D() + "/" + i + "/" + ab3Var.a());
            forbiddenInfo.enableSlidingFlag = -1;
            bk2.l(context, SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK, ab3Var, forbiddenInfo, a0.X().D());
        }
    }
}
