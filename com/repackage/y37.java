package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static la5 a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                la5 la5Var = new la5(i, cls.newInstance());
                MessageManager.getInstance().registerTask(la5Var);
                return la5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (la5) invokeIL.objValue;
    }

    public static ma5 b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            ma5 ma5Var = new ma5(i);
            ma5Var.setResponsedClass(cls);
            ma5Var.h(z);
            ma5Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(ma5Var);
            return ma5Var;
        }
        return (ma5) invokeCommon.objValue;
    }
}
