package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class e17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, on onVar) {
        InterceptResult invokeLL;
        f06 f06Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, onVar)) == null) {
            if (!(onVar instanceof f06) || (threadData = (f06Var = (f06) onVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(f06Var.a.getVoiceRoomData().room_name) || f06Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((x65) ServiceManager.getService(x65.a.a())).a(tbPageContext, f06Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
