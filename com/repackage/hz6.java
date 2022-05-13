package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext<?> tbPageContext, ro roVar) {
        InterceptResult invokeLL;
        yx5 yx5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, roVar)) == null) {
            if (!(roVar instanceof yx5) || (threadData = (yx5Var = (yx5) roVar).a) == null || threadData.getVoiceRoomData() == null || StringUtils.isNull(yx5Var.a.getVoiceRoomData().room_name) || yx5Var.a.getVoiceRoomData().room_id.longValue() <= 0) {
                return false;
            }
            ((n55) ServiceManager.getService(n55.a.a())).a(tbPageContext, yx5Var.a.getVoiceRoomData().room_id.longValue());
            return true;
        }
        return invokeLL.booleanValue;
    }
}
