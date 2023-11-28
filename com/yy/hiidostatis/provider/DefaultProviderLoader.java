package com.yy.hiidostatis.provider;

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
/* loaded from: classes2.dex */
public class DefaultProviderLoader {
    public static boolean init;

    public static synchronized void init() {
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
