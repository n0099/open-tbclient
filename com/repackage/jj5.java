package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class jj5 implements CustomMessageTask.CustomRunnable<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jj5() {
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
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof GetContactListRequestMessage)) {
                return null;
            }
            List<px4> e = mj5.f().e();
            if (e != null) {
                Iterator<px4> it = e.iterator();
                while (it.hasNext()) {
                    px4 next = it.next();
                    if ((ki.isEmpty(next.e()) && ki.isEmpty(next.f())) || next.h() == 1) {
                        it.remove();
                    }
                }
            }
            GetContactListResponsedMessage getContactListResponsedMessage = new GetContactListResponsedMessage();
            getContactListResponsedMessage.setContacts(e);
            return getContactListResponsedMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
