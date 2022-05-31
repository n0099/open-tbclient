package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class z17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static v85 a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                v85 v85Var = new v85(i, cls.newInstance());
                MessageManager.getInstance().registerTask(v85Var);
                return v85Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (v85) invokeIL.objValue;
    }

    public static w85 b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            w85 w85Var = new w85(i);
            w85Var.setResponsedClass(cls);
            w85Var.h(z);
            w85Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(w85Var);
            return w85Var;
        }
        return (w85) invokeCommon.objValue;
    }
}
