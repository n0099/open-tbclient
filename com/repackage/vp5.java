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
/* loaded from: classes7.dex */
public class vp5 implements cl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vp5() {
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

    @Override // com.repackage.cl2
    public boolean a(Context context, String str, sc3 sc3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, sc3Var)) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_START_FAIL);
            statisticItem.param("uid", ko5.l().p() == null ? "" : ko5.l().p());
            statisticItem.param("obj_param1", sc3Var.h());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, sc3Var.e());
            TiebaStatic.log(statisticItem);
            if (sc3Var.j() == 10 && sc3Var.h() == 1013) {
                b(context, sc3Var);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void b(Context context, sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sc3Var) == null) {
            z03 b0 = z03.b0();
            if (context == null || b0 == null) {
                return;
            }
            String i = ea3.i(mm2.U().M(), b0.Y().G());
            long h = sc3Var.h();
            String r = sc3Var.r();
            if (!(1020 == h && !TextUtils.isEmpty(r))) {
                r = vc4.b().a(h);
            }
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(b0.W(), r, "v" + te3.D() + "/" + i + "/" + sc3Var.a());
            forbiddenInfo.enableSlidingFlag = -1;
            tl2.l(context, "type_need_update_sdk", sc3Var, forbiddenInfo, b0.Y().D());
        }
    }
}
