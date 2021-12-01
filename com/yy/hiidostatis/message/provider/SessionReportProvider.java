package com.yy.hiidostatis.message.provider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.module.sessionreport.SessionReportImpl;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class SessionReportProvider implements Provider<SessionReport> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, SessionReport> report;

    public SessionReportProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.report = new ConcurrentHashMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public synchronized SessionReport generate(MessageConfig messageConfig) {
        InterceptResult invokeL;
        SessionReport sessionReport;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, messageConfig)) == null) {
            synchronized (this) {
                sessionReport = this.report.get(messageConfig.getAppkey());
                if (sessionReport == null) {
                    SessionReportImpl sessionReportImpl = new SessionReportImpl(messageConfig, (Packer) GlobalProvider.instance.get(Packer.class, messageConfig));
                    this.report.put(messageConfig.getAppkey(), sessionReportImpl);
                    sessionReport = sessionReportImpl;
                }
            }
            return sessionReport;
        }
        return (SessionReport) invokeL.objValue;
    }
}
