package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalRequestMessage;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qx7 implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qx7() {
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
            if (customMessage == null || !(customMessage instanceof PbPageReadLocalRequestMessage)) {
                return null;
            }
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = (PbPageReadLocalRequestMessage) customMessage;
            byte[] a = wv7.b().a(pbPageReadLocalRequestMessage.getCacheKey(), pbPageReadLocalRequestMessage.isMarkCache());
            PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = new PbPageReadLocalResponseMessage();
            pbPageReadLocalResponseMessage.setPostId(pbPageReadLocalRequestMessage.getPostId());
            pbPageReadLocalResponseMessage.setMarkCache(pbPageReadLocalRequestMessage.isMarkCache());
            pbPageReadLocalResponseMessage.setUpdateType(pbPageReadLocalRequestMessage.getUpdateType());
            try {
                pbPageReadLocalResponseMessage.decodeInBackGround(2004003, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pbPageReadLocalResponseMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
