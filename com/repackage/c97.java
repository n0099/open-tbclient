package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes5.dex */
public class c97 implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c97() {
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
            UserInfoBigVip userInfoBigVip = null;
            if (customMessage != null && (customMessage.getData() instanceof Long)) {
                long longValue = ((Long) customMessage.getData()).longValue();
                tr4.f();
                ue<byte[]> d = tr4.d("tb.im_recommend_detail");
                if (d == null) {
                    return new CustomResponsedMessage<>(2001306, null);
                }
                byte[] bArr = d.get(longValue + "");
                if (bArr == null) {
                    return new CustomResponsedMessage<>(2001306, null);
                }
                try {
                    userInfoBigVip = ((BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class)).data.user_info;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                return new CustomResponsedMessage<>(2001306, userInfoBigVip);
            }
            return new CustomResponsedMessage<>(2001306, null);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
