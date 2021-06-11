package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.message.sender.AppInfoManager;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes7.dex */
public class AppInfoProvider implements Provider<AppInfo> {
    public AppInfo appInfo;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public AppInfo generate(MessageConfig messageConfig) {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo;
        }
        synchronized (this) {
            if (this.appInfo != null) {
                return this.appInfo;
            }
            AppInfoManager appInfoManager = new AppInfoManager(messageConfig.getApplicationContext());
            this.appInfo = appInfoManager;
            return appInfoManager;
        }
    }
}
