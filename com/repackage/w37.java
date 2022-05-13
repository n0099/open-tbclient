package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class w37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ba5 a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                ba5 ba5Var = new ba5(i, cls.newInstance());
                MessageManager.getInstance().registerTask(ba5Var);
                return ba5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (ba5) invokeIL.objValue;
    }

    public static ca5 b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            ca5 ca5Var = new ca5(i);
            ca5Var.setResponsedClass(cls);
            ca5Var.h(z);
            ca5Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(ca5Var);
            return ca5Var;
        }
        return (ca5) invokeCommon.objValue;
    }
}
