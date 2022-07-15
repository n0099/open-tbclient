package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
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
public class do5 implements kk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public do5() {
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

    @Override // com.repackage.kk2
    public boolean a(Context context, String str, ac3 ac3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, ac3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", sm5.l().p() == null ? "" : sm5.l().p());
            statisticItem.param("obj_param1", ac3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, ac3Var.e());
            TiebaStatic.log(statisticItem);
            if (ac3Var.j() == 10 && ac3Var.h() == 1013) {
                b(context, ac3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ac3Var) == null) {
            h03 b0 = h03.b0();
            if (context == null || b0 == null) {
                return;
            }
            String i = m93.i(ul2.U().M(), b0.Y().G());
            long h = ac3Var.h();
            String r = ac3Var.r();
            if (!(1020 == h && !TextUtils.isEmpty(r))) {
                r = dc4.b().a(h);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + be3.D() + "/" + i + "/" + ac3Var.a());
            forbiddenInfo.enableSlidingFlag = -1;
            bl2.l(context, "type_need_update_sdk", ac3Var, forbiddenInfo, b0.Y().D());
        }
    }
}
