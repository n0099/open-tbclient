package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, uo uoVar) {
        InterceptResult invokeLL;
        xx5 xx5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, uoVar)) == null) {
            if (!(uoVar instanceof xx5) || (threadData = (xx5Var = (xx5) uoVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(xx5Var.a.getVoiceRoomData().room_name) || xx5Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((x45) ServiceManager.getService(x45.a.a())).a(tbPageContext, xx5Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
