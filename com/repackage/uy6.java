package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, nn nnVar) {
        InterceptResult invokeLL;
        qx5 qx5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, nnVar)) == null) {
            if (!(nnVar instanceof qx5) || (threadData = (qx5Var = (qx5) nnVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(qx5Var.a.getVoiceRoomData().room_name) || qx5Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((y45) ServiceManager.getService(y45.a.a())).a(tbPageContext, qx5Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
