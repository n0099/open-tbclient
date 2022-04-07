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
/* loaded from: classes6.dex */
public class hn5 implements mk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hn5() {
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

    @Override // com.repackage.mk2
    public boolean a(Context context, String str, cc3 cc3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, cc3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", xl5.l().p() == null ? "" : xl5.l().p());
            statisticItem.param("obj_param1", cc3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, cc3Var.e());
            TiebaStatic.log(statisticItem);
            if (cc3Var.j() == 10 && cc3Var.h() == 1013) {
                b(context, cc3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cc3Var) == null) {
            j03 a0 = j03.a0();
            if (context == null || a0 == null) {
                return;
            }
            String i = o93.i(wl2.U().M(), a0.X().G());
            long h = cc3Var.h();
            String r = cc3Var.r();
            if (!(1020 == h && !TextUtils.isEmpty(r))) {
                r = gc4.b().a(h);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(a0.V(), r, "v" + de3.D() + "/" + i + "/" + cc3Var.a());
            forbiddenInfo.enableSlidingFlag = -1;
            dl2.l(context, SwanAppErrorActivity.TYPE_NEED_UPDATE_SDK, cc3Var, forbiddenInfo, a0.X().D());
        }
    }
}
