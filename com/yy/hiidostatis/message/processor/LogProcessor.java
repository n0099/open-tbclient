package com.yy.hiidostatis.message.processor;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.MessageProcessor;
import com.yy.hiidostatis.message.bean.Message;
/* loaded from: classes8.dex */
public class LogProcessor implements MessageProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LogProcessor() {
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

    @Override // com.yy.hiidostatis.message.MessageProcessor
    public Message process(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            try {
                L.debug(message, "id:%s \n urlParams:%s \n content:%s \n", message.getMsgId(), message.getUrlParams(), new String(message.getContent(), IMAudioTransRequest.CHARSET));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return message;
        }
        return (Message) invokeL.objValue;
    }
}
