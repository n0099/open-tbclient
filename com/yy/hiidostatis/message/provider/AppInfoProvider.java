package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.message.sender.AppInfoManager;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
/* loaded from: classes8.dex */
public class AppInfoProvider implements Provider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfo appInfo;

    public AppInfoProvider() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.provider.Provider
    public AppInfo generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
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
        return (AppInfo) invokeL.objValue;
    }
}
