package com.yy.hiidostatis.provider;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.MessageSender;
import com.yy.hiidostatis.message.MessageStore;
import com.yy.hiidostatis.message.MessageSupplier;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.SessionReportWrapper;
import com.yy.hiidostatis.message.provider.AppInfoProvider;
import com.yy.hiidostatis.message.provider.CacheManagerProvider;
import com.yy.hiidostatis.message.provider.HostManagerProvider;
import com.yy.hiidostatis.message.provider.MessageMonitorProvider;
import com.yy.hiidostatis.message.provider.MessageSenderProvider;
import com.yy.hiidostatis.message.provider.MessageStoreProvider;
import com.yy.hiidostatis.message.provider.MessageSupplierProvider;
import com.yy.hiidostatis.message.provider.PackerProvider;
import com.yy.hiidostatis.message.provider.SendDispatchTaskProvider;
import com.yy.hiidostatis.message.provider.SessionReportProvider;
import com.yy.hiidostatis.message.provider.SessionReportWrapperProvider;
/* loaded from: classes10.dex */
public class DefaultProviderLoader {
    public static /* synthetic */ Interceptable $ic;
    public static boolean init;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-615124927, "Lcom/yy/hiidostatis/provider/DefaultProviderLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-615124927, "Lcom/yy/hiidostatis/provider/DefaultProviderLoader;");
        }
    }

    public DefaultProviderLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (DefaultProviderLoader.class) {
                if (init) {
                    return;
                }
                GlobalProvider.instance.registerProvider(MessageSupplier.class, new MessageSupplierProvider());
                GlobalProvider.instance.registerProvider(MessageSender.class, new MessageSenderProvider());
                GlobalProvider.instance.registerProvider(TaskDataSqLiteCacheManager.class, new CacheManagerProvider());
                GlobalProvider.instance.registerProvider(NamedProvider.SEND_MODULE_TASK, new SendDispatchTaskProvider());
                GlobalProvider.instance.registerProvider(HostManager.class, new HostManagerProvider());
                GlobalProvider.instance.registerProvider(Packer.class, new PackerProvider());
                GlobalProvider.instance.registerProvider(MessageStore.class, new MessageStoreProvider());
                GlobalProvider.instance.registerProvider(MessageMonitor.class, new MessageMonitorProvider());
                GlobalProvider.instance.registerProvider(SessionReport.class, new SessionReportProvider());
                GlobalProvider.instance.registerProvider(SessionReportWrapper.class, new SessionReportWrapperProvider());
                GlobalProvider.instance.registerProvider(AppInfo.class, new AppInfoProvider());
                init = true;
            }
        }
    }
}
