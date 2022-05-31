package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, jn jnVar) {
        InterceptResult invokeLL;
        rw5 rw5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, jnVar)) == null) {
            if (!(jnVar instanceof rw5) || (threadData = (rw5Var = (rw5) jnVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(rw5Var.a.getVoiceRoomData().room_name) || rw5Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((j45) ServiceManager.getService(j45.a.a())).a(tbPageContext, rw5Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
