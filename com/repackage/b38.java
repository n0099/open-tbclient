package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personExtra.PersonFriendByUidLocalMessage;
import com.baidu.tieba.personExtra.ResponsePersonFriendByUidLocalMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b38 implements CustomMessageTask.CustomRunnable<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b38() {
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
            if (customMessage == null || !(customMessage instanceof PersonFriendByUidLocalMessage)) {
                return null;
            }
            String str = "personal_myfollow_" + (TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "");
            cr4.f();
            String str2 = cr4.g("tb.my_pages").get(str);
            ResponsePersonFriendByUidLocalMessage responsePersonFriendByUidLocalMessage = new ResponsePersonFriendByUidLocalMessage();
            if (str2 != null) {
                try {
                    responsePersonFriendByUidLocalMessage.decodeInBackGround(2001182, str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return responsePersonFriendByUidLocalMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
