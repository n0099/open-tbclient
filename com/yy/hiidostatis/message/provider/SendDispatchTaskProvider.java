package com.yy.hiidostatis.message.provider;

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
/* loaded from: classes7.dex */
public class SendDispatchTaskProvider implements Provider<Task> {
    public SendMsgDispatcher dispatcher;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public Task generate(MessageConfig messageConfig) {
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
}
