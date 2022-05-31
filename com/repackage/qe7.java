package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.FollowStatusService;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qe7 implements FollowStatusService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qe7() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.FollowStatusService
    public void saveFollowStatus(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
            aVar.a = true;
            aVar.c = str;
            aVar.d = z;
            aVar.e = true;
            MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
        }
    }
}
