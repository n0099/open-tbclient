package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, nn nnVar) {
        InterceptResult invokeLL;
        ny5 ny5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, nnVar)) == null) {
            if (!(nnVar instanceof ny5) || (threadData = (ny5Var = (ny5) nnVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(ny5Var.a.getVoiceRoomData().room_name) || ny5Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((a65) ServiceManager.getService(a65.a.a())).a(tbPageContext, ny5Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
