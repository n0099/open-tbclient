package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.SessionReportWrapper;
import com.yy.hiidostatis.message.module.sessionreport.SessionReportWrapperImpl;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class SessionReportWrapperProvider implements Provider<SessionReportWrapper> {
    public Map<String, SessionReportWrapper> report = new ConcurrentHashMap();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public SessionReportWrapper generate(MessageConfig messageConfig) {
        SessionReportWrapper sessionReportWrapper = this.report.get(messageConfig.getAppkey());
        if (sessionReportWrapper == null) {
            SessionReportWrapperImpl sessionReportWrapperImpl = new SessionReportWrapperImpl((SessionReport) GlobalProvider.instance.get(SessionReport.class, messageConfig));
            this.report.put(messageConfig.getAppkey(), sessionReportWrapperImpl);
            return sessionReportWrapperImpl;
        }
        return sessionReportWrapper;
    }
}
