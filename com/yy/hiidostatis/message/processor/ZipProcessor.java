package com.yy.hiidostatis.message.processor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hiido.snappy.Snappy;
import com.yy.hiidostatis.message.MessageProcessor;
import com.yy.hiidostatis.message.bean.Message;
import java.io.IOException;
/* loaded from: classes3.dex */
public class ZipProcessor implements MessageProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ZipProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (message.isSingle()) {
                return message;
            }
            try {
                System.currentTimeMillis();
                byte[] compress = Snappy.compress(message.getContent());
                message.setContent(compress);
                message.setLength(compress.length);
                return message;
            } catch (IOException unused) {
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }
}
