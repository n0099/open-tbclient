package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kj5 implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kj5() {
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

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        InterceptResult invokeL;
        boolean d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null) {
                return null;
            }
            int cmd = customMessage.getCmd();
            if (customMessage.getData() != null && (cmd == 2001179 || cmd == 2001180)) {
                px4 px4Var = (px4) customMessage.getData();
                if (cmd == 2001179) {
                    d = mj5.f().a(px4Var);
                } else {
                    d = mj5.f().d(px4Var.d());
                }
                if (!d) {
                    ys4 k = ys4.k();
                    k.u("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
