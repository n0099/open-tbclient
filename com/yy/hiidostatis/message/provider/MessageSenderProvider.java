package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.MessageSender;
import com.yy.hiidostatis.message.sender.OKSender;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes8.dex */
public class MessageSenderProvider implements Provider<MessageSender> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageSender sender;

    public MessageSenderProvider() {
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
    public MessageSender generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            MessageSender messageSender = this.sender;
            if (messageSender != null) {
                return messageSender;
            }
            synchronized (this) {
                if (this.sender != null) {
                    return this.sender;
                }
                OKSender oKSender = new OKSender((HostManager) GlobalProvider.instance.get(HostManager.class, messageConfig), (AppInfo) GlobalProvider.instance.get(AppInfo.class, messageConfig));
                this.sender = oKSender;
                return oKSender;
            }
        }
        return (MessageSender) invokeL.objValue;
    }
}
