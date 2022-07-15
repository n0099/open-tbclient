package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.mainentrance.RequestSearchPersonHistoryWriteMessage;
import com.baidu.tieba.mainentrance.ResponseSearchPersonHistoryWriteMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hf7 implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hf7() {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof RequestSearchPersonHistoryWriteMessage)) {
                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = (RequestSearchPersonHistoryWriteMessage) customMessage;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                br4.f();
                te<String> h = br4.h("tb.searchperson_history", currentAccount);
                if (requestSearchPersonHistoryWriteMessage.isClear()) {
                    BdCacheService.k().j(h);
                } else {
                    Object data = requestSearchPersonHistoryWriteMessage.getData();
                    if (data != null && (data instanceof String)) {
                        h.g((String) data, null);
                    }
                }
                return new ResponseSearchPersonHistoryWriteMessage();
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
