package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.MessageSender;
import com.yy.hiidostatis.message.MessageSupplier;
import com.yy.hiidostatis.message.Task;
import com.yy.hiidostatis.message.processor.Base64Processor;
import com.yy.hiidostatis.message.processor.EncryptProcessor;
import com.yy.hiidostatis.message.processor.LogProcessor;
import com.yy.hiidostatis.message.processor.ZipProcessor;
import com.yy.hiidostatis.message.sender.SendMsgDispatcher;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SendDispatchTaskProvider implements Provider<Task> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SendMsgDispatcher dispatcher;

    public SendDispatchTaskProvider() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public Task generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            if (this.dispatcher == null) {
                synchronized (this) {
                    if (this.dispatcher == null) {
                        ZipProcessor zipProcessor = new ZipProcessor();
                        EncryptProcessor encryptProcessor = new EncryptProcessor();
                        LogProcessor logProcessor = new LogProcessor();
                        Base64Processor base64Processor = new Base64Processor();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(logProcessor);
                        arrayList.add(zipProcessor);
                        arrayList.add(encryptProcessor);
                        arrayList.add(base64Processor);
                        arrayList.add(logProcessor);
                        this.dispatcher = new SendMsgDispatcher((MessageSupplier) GlobalProvider.instance.get(MessageSupplier.class, messageConfig), (MessageSender) GlobalProvider.instance.get(MessageSender.class, messageConfig), arrayList);
                    }
                }
            }
            if (messageConfig.isMainConfig()) {
                this.dispatcher.setMainConfig(messageConfig);
            }
            return this.dispatcher;
        }
        return (Task) invokeL.objValue;
    }
}
