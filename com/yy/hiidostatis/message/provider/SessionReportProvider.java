package com.yy.hiidostatis.message.provider;

import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.module.sessionreport.SessionReportImpl;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.Provider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class SessionReportProvider implements Provider<SessionReport> {
    public Map<String, SessionReport> report = new ConcurrentHashMap();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yy.hiidostatis.provider.Provider
    public synchronized SessionReport generate(MessageConfig messageConfig) {
        SessionReport sessionReport;
        sessionReport = this.report.get(messageConfig.getAppkey());
        if (sessionReport == null) {
            SessionReportImpl sessionReportImpl = new SessionReportImpl(messageConfig, (Packer) GlobalProvider.instance.get(Packer.class, messageConfig));
            this.report.put(messageConfig.getAppkey(), sessionReportImpl);
            sessionReport = sessionReportImpl;
        }
        return sessionReport;
    }
}
