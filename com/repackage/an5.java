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
public class an5 implements vj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public an5() {
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

    @Override // com.repackage.vj2
    public boolean a(Context context, String str, lb3 lb3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, lb3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", pl5.l().p() == null ? "" : pl5.l().p());
            statisticItem.param("obj_param1", lb3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, lb3Var.e());
            TiebaStatic.log(statisticItem);
            if (lb3Var.j() == 10 && lb3Var.h() == 1013) {
                b(context, lb3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, lb3 lb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lb3Var) == null) {
            sz2 b0 = sz2.b0();
            if (context == null || b0 == null) {
                return;
            }
            String i = x83.i(fl2.U().M(), b0.Y().G());
            long h = lb3Var.h();
            String r = lb3Var.r();
            if (!(1020 == h && !TextUtils.isEmpty(r))) {
                r = ob4.b().a(h);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + md3.D() + "/" + i + "/" + lb3Var.a());
            forbiddenInfo.enableSlidingFlag = -1;
            mk2.l(context, "type_need_update_sdk", lb3Var, forbiddenInfo, b0.Y().D());
        }
    }
}
