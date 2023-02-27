package com.yy.hiidostatis.defs;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.MetricsWorker;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.handler.MetricsHandler;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.defs.listener.ActAdditionListenerController;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.monitor.ScreenMonitor;
import com.yy.hiidostatis.defs.monitor.TrafficMonitor;
import com.yy.hiidostatis.defs.obj.Act;
import com.yy.hiidostatis.defs.obj.EventElementInfo;
import com.yy.hiidostatis.defs.obj.EventInfo;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.StringUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.log.TraceLog;
import com.yy.hiidostatis.message.utils.KVIO;
import com.yy.hiidostatis.pref.HdStatisConfig;
import com.yy.hiidostatis.provider.DefaultProviderLoader;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.MessageConfigFactory;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes8.dex */
public class StatisAPINew implements IStatisApi {
    public static final String DEFAULT_METRICS_NAME = "DEFAULT_METRICS";
    public static final int MAX_EVENT_FIELD_BYTES = 256;
    public MessageConfig config;
    public Context mContext;
    public MetricsHandler metricsHandler;
    public Packer packer;
    public ActAdditionListenerController mActListernerController = new ActAdditionListenerController();
    public Long launchTime = null;

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        return this;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo5(long j) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDoShort(long j, Map<String, String> map) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j, String str, String str2) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAbroad(boolean z) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setBusinessType(int i) {
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setTestServer(String str) {
    }

    public StatisAPINew(MessageConfig messageConfig) {
        this.metricsHandler = null;
        this.config = messageConfig;
        KVIO.initialize(messageConfig.getApplicationContext());
        DefaultProviderLoader.init();
        TraceLog.initLog(messageConfig.getApplicationContext());
        init();
        this.metricsHandler = new MetricsHandler(messageConfig.getApplicationContext(), messageConfig.getAppkey(), messageConfig.getVer(), HiidoSDK.instance().getOptions().getDefaultMetricsExpire());
    }

    private String getErrorInfo(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String obj = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return obj;
        } catch (Throwable th2) {
            L.debug("StatisAPINew", "SDK Get Crash Error Info Exception!" + th2, new Object[0]);
            return "SDK Get Crash Error Info Exception!" + th2;
        }
    }

    private String getPropString(Map<String, String> map) {
        String str = null;
        if (map != null && map.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append(",");
                } catch (Throwable th) {
                    L.debug(this, th.getMessage(), new Object[0]);
                }
            }
            if (stringBuffer.length() > 0) {
                str = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
            stringBuffer.setLength(0);
        }
        return str;
    }

    private void init() {
        this.packer = (Packer) GlobalProvider.instance.get(Packer.class, this.config);
        this.mContext = this.config.getApplicationContext();
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void exit() {
        this.config.setSessionId(null);
        this.launchTime = null;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void generateSession() {
        try {
            this.config.setSessionId(Coder.encryptMD5(StringUtil.geneGuid()).substring(0, 20));
        } catch (Throwable th) {
            L.debug(this, "generateSession exception:%s", th);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        return this.mActListernerController.getHiidoSdkAdditionDelegate();
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        return this.launchTime;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        StatisOption statisOption = new StatisOption();
        MessageConfig messageConfig = this.config;
        if (messageConfig != null) {
            statisOption.setVer(messageConfig.getVer());
            statisOption.setFrom(this.config.getFrom());
            statisOption.setAppkey(this.config.getAppkey());
            statisOption.setAppId(this.config.getAppId());
        }
        return statisOption;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        return this.config.getSessionId();
    }

    public void onInitSuccess() {
        this.packer.onInited(true);
    }

    private boolean reportStatisticContentAll(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3, Packer.OnSavedListener onSavedListener) {
        if (this.mContext != null && !Util.empty(str) && !Util.empty(statisContent)) {
            statisContent.setAct(str);
            statisContent.setCover(z3);
            statisContent.setFillCommon(z);
            statisContent.setFillConcrete(z2);
            return this.packer.addMessage(statisContent, onSavedListener);
        }
        L.error("StatisAPINew", "Input error! context is null || act is null || content is null ", new Object[0]);
        return false;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
        if (this.mContext == null) {
            L.warn("StatisAPINew", "Input context is null!", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("actionid", str);
        statisContent.put("type", str2);
        statisContent.put("failcode", str3);
        statisContent.put("failmsg", str4);
        statisContent.put("parm", str5);
        reportStatisticContentInner(Act.MBSDK_FAILURE, statisContent, true, true, false);
    }

    private boolean reportStatisticContentInner(Act act, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        return reportStatisticContentInner(act, statisContent, z, z2, z3, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i, String str2, String str3, long j) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        this.metricsHandler.reportCount(str, i, str2, str3, j);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        reportStatisticContentAll(str, statisContent, z, z, z2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportUrlScheme(String str, String str2, int i, String str3, String str4) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("scheme", str);
        statisContent.put("host", str2);
        statisContent.put(ClientCookie.PORT_ATTR, i);
        statisContent.put("path", str3);
        statisContent.put("query", str4);
        reportStatisticContentInner(Act.MBSDK_URL_SCHEME, statisContent, true, true, false);
    }

    private boolean reportStatisticContentInner(Act act, StatisContent statisContent, boolean z, boolean z2, boolean z3, Packer.OnSavedListener onSavedListener) {
        StatisContent.Priority priority;
        StatisContent actAddition = this.mActListernerController.getActAddition(act, this.mActListernerController.getListerner(act));
        if (actAddition != null) {
            statisContent.putContent(actAddition, false);
        }
        if (z3) {
            priority = StatisContent.Priority.PRIORITY_HIGH;
        } else {
            priority = StatisContent.Priority.PRIORITY_NORMAL;
        }
        statisContent.setPriority(priority);
        return reportStatisticContentAll(act.toString(), statisContent, z, z2, false, onSavedListener);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        this.metricsHandler.reportCount(str, i, str2, str3, j, i2);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        this.metricsHandler.reportReturnCode(str, i, str2, j, str3, map);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        this.metricsHandler.reportSrcData(str, i, str2, str3, j, map);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void addActAdditionListener(ActListener actListener) {
        this.mActListernerController.add(actListener);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void removeActAdditionListener(ActListener actListener) {
        this.mActListernerController.remove(actListener);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAppsflyer(String str) {
        this.config.setAppsflyer(str);
        StatisContent statisContent = new StatisContent();
        statisContent.put(BaseStatisContent.MDSR, str);
        reportStatisticContentInner(Act.MBSDK_APPSFLYER, statisContent, true, true, false, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j) {
        reportDevice(j, null, null);
        return true;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo(long j) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        reportStatisticContentInner(Act.MBSDK_DO, statisContent, true, true, true, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i) {
        reportInstall(i, (Packer.OnSavedListener) null);
        return true;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLogin(long j) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        reportStatisticContentInner(Act.MBSDK_LOGIN, statisContent, true, true, false, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportRun(long j) {
        this.launchTime = Long.valueOf(System.currentTimeMillis());
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        reportStatisticContentInner(Act.MBSDK_RUN, statisContent, true, true, true, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        this.mActListernerController.setHiidoSdkAdditionDelegate(hiidoSdkAdditionDelegate);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        if (str != null && !str.isEmpty()) {
            this.config.setSessionId(str);
        } else {
            generateSession();
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public MetricsWorker addMetricsWorker(String str, long j) {
        if (this.mContext == null && this.metricsHandler == null) {
            return null;
        }
        return this.metricsHandler.addMetricsWorker(str, j);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, Throwable th) {
        reportCrash(j, getErrorInfo(th));
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j, StatisContent statisContent) {
        reportDevice(j, statisContent, null);
        return true;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, IStatisAPI.ReportResult reportResult) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("new", i);
        boolean reportStatisticContentInner = reportStatisticContentInner(Act.MBSDK_INSTALL, statisContent, true, true, true, null);
        if (reportResult != null) {
            reportResult.onReportResult(reportStatisticContentInner);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j, String str) {
        if (Util.empty(str)) {
            L.debug("StatisAPINew", "Input page is null ", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("page", str);
        reportStatisticContentInner(Act.MBSDK_PAGE, statisContent, true, true, true);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportPushToken(long j, String str) {
        if (this.mContext != null && !Util.empty(str)) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            statisContent.put("pushtoken", str);
            reportStatisticContentInner(Act.MBSDK_PUSH, statisContent, true, true, false);
            return;
        }
        L.warn("StatisAPINew", "Input context is null||token is null", new Object[0]);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str) {
        reportTimesEvent(j, str, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
        MessageConfig generate = MessageConfigFactory.generate(context, statisOption.getAppkey());
        generate.setFrom(statisOption.getFrom());
        generate.setAppId(statisOption.getAppId());
        generate.setVer(statisOption.getVer());
        this.config = generate;
        KVIO.initialize(generate.getApplicationContext());
        TraceLog.initLog(generate.getApplicationContext());
        init();
        onInitSuccess();
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j, String str) {
        if (Util.empty(str)) {
            L.debug("StatisAPINew", "Input event is null ", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("event", str);
        L.debug(this, "add mbsdkevent %s", str);
        reportStatisticContentInner(Act.MBSDK_EVENT, statisContent, true, true, false);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAction(long j, String str, String str2, String str3) {
        if (Util.empty(str) && Util.empty(str2) && Util.empty(str3)) {
            L.debug("StatisAPINew", "Input appa is null && page is null && event is null ", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("appa", str);
        statisContent.put("page", str2);
        statisContent.put("even", str3);
        reportStatisticContentInner(Act.MBSDK_ACTION, statisContent, true, true, false);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2) {
        reportAppList(j, str, str2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d) {
        reportCountEvent(j, str, d, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j, String str, long j2) {
        if (Util.empty(str)) {
            L.debug("StatisAPINew", "Input page is null ", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("page", str);
        statisContent.put("duration", j2);
        reportStatisticContentInner(Act.MBSDK_PAGE_STATE, statisContent, true, true, true);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        reportStatisticContentAll(str, statisContent, false, false, false, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str, String str2) {
        reportTimesEvent(j, str, str2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2, String str3) {
        if ((str2 != null && str2.length() != 0) || (str3 != null && str3.length() != 0)) {
            StatisContent statisContent = new StatisContent();
            try {
                statisContent.put("uid", j);
                statisContent.put("type", str);
                statisContent.put("applist", str2);
                statisContent.put("applist2", str3);
                reportStatisticContentInner(Act.MBSDK_APPLIST, statisContent, true, true, false);
                return;
            } catch (Throwable th) {
                L.debug("StatisAPINew", "encrypt exception %s", th);
                return;
            }
        }
        L.debug("StatisAPINew", "applist is empty，no report applist !", new Object[0]);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i, String str, String str2, long j) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d, String str2) {
        reportCountEvent(j, str, d, str2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportError(long j, String str, String str2, String str3) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("eid", str);
        statisContent.put("emsg", str2);
        statisContent.put("parm", str3);
        reportStatisticContentInner(Act.MBSDK_ERROR, statisContent, true, true, false);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", str);
        statisContent.put("acc", str);
        statisContent.put("name", str2);
        statisContent.put("type", str3);
        statisContent.put("prop", getPropString(map));
        reportStatisticContentInner(Act.MBSDK_REG, statisContent, true, true, false);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
        reportStatisticContentAll(str, statisContent, z, z, z2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
        if (this.mContext != null && !Util.empty(str) && !Util.empty(statisContent)) {
            statisContent.setNotSave(true);
            reportStatisticContent(str, statisContent, z, z2);
            return;
        }
        L.error("StatisAPINew", "Input error! context is null || act is null || content is null ", new Object[0]);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        reportStatisticContentAll(str, statisContent, false, false, false, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i, String str, String str2, long j, int i2) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j, i2);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportReturnCode("DEFAULT_METRICS", i, str, j, str2, map);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
        if (this.mContext == null && this.metricsHandler == null) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportSrcData("DEFAULT_METRICS", i, str, str2, j, map);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
        if (this.mContext == null) {
            L.warn("StatisAPINew", "Input context is null!", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("actionid", str);
        statisContent.put("type", str2);
        statisContent.put("duration", j2);
        statisContent.put("parm", str3);
        reportStatisticContentInner(Act.MBSDK_SUCCESS, statisContent, true, true, false);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d, String str2, Property property) {
        Property copy;
        if (property == null) {
            copy = null;
        } else {
            copy = property.copy();
        }
        if (Util.empty(str)) {
            L.debug(this, "eid is not allow null.", new Object[0]);
            return;
        }
        if (str.getBytes().length > 256) {
            L.debug(this, "eid[%s] bytes[%d] must under %d bytes.", str, Integer.valueOf(str.getBytes().length), 256);
        }
        if (!Util.empty(str2) && str2.getBytes().length > 256) {
            L.debug(this, "label[%s] bytes[%d] must under %d bytes.", str2, Integer.valueOf(str2.getBytes().length), 256);
        }
        EventInfo eventInfo = new EventInfo();
        EventElementInfo eventElementInfo = new EventElementInfo(str, String.valueOf(d));
        eventElementInfo.addParam(str2);
        eventElementInfo.setProperty(copy);
        eventInfo.addElem(eventElementInfo);
        reportEvent(j, eventInfo.getResult());
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLocation(long j, double d, double d2, double d3, IStatisAPI.ReportResult reportResult) {
        if (this.mContext == null) {
            L.warn("StatisAPINew", "Input context is null", new Object[0]);
            if (reportResult != null) {
                reportResult.onReportResult(false);
            }
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("lon", d);
        statisContent.put(SuggestAddrField.KEY_LAT, d2);
        statisContent.put("alt", d3);
        CellLocation cellId = ArdUtil.getCellId(this.mContext);
        if (cellId != null) {
            if (cellId instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellId;
                statisContent.put("ceid", gsmCellLocation.getCid());
                statisContent.put("lac", gsmCellLocation.getLac());
            } else if (cellId instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellId;
                statisContent.put("ceid", cdmaCellLocation.getBaseStationId());
                statisContent.put("lac", cdmaCellLocation.getNetworkId());
            }
        }
        WifiInfo wifiInfo = ArdUtil.getWifiInfo(this.mContext);
        if (wifiInfo != null) {
            statisContent.put("bssid", wifiInfo.getBSSID());
            statisContent.put(YyLiveRoomConfig.KEY_SSID, wifiInfo.getSSID());
            statisContent.put("rssi", wifiInfo.getRssi());
        }
        boolean reportStatisticContentInner = reportStatisticContentInner(Act.MBSDK_LOCATION, statisContent, true, true, false);
        if (reportResult != null) {
            reportResult.onReportResult(reportStatisticContentInner);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, String str) {
        if (this.mContext == null) {
            L.warn("StatisAPINew", "Input context is null", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("crashmsg", str);
        statisContent.put("rtyp", 2);
        statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
        statisContent.put("tram", ArdUtil.getTotalMemory(this.mContext));
        statisContent.put("trom", ArdUtil.getTotalInternalStorgeSize());
        statisContent.put("tsd", 0);
        statisContent.put("aram", ArdUtil.getAvailMemory(this.mContext));
        statisContent.put("arom", ArdUtil.getAvailInternalStorgeSize());
        statisContent.put("asd", 0);
        statisContent.put("ctyp", "1");
        statisContent.put("crashid", UUID.randomUUID().toString());
        if (this.launchTime != null) {
            statisContent.put("ltime", (System.currentTimeMillis() - this.launchTime.longValue()) / 1000);
        }
        statisContent.put("cpage", DefaultPreference.getPreference().getPrefString(this.mContext, HdStatisConfig.PREF_CPAGE, null));
        statisContent.put("cpkg", ArdUtil.getPackageName(this.mContext));
        statisContent.put("cthread", ProcessUtil.getCurProcessName(this.mContext) + "#" + Process.myTid());
        reportStatisticContentInner(Act.MBSDK_CRASH, statisContent, true, true, false);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j, Throwable th) {
        if (this.mContext == null) {
            L.warn("StatisAPINew", "Input context is null", new Object[0]);
            return;
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("crashmsg", getErrorInfo(th));
        statisContent.put("rtyp", 1);
        statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
        statisContent.put("tram", ArdUtil.getTotalMemory(this.mContext));
        statisContent.put("trom", ArdUtil.getTotalInternalStorgeSize());
        statisContent.put("tsd", 0);
        statisContent.put("aram", ArdUtil.getAvailMemory(this.mContext));
        statisContent.put("arom", ArdUtil.getAvailInternalStorgeSize());
        statisContent.put("asd", 0);
        statisContent.put("ctyp", "1");
        statisContent.put("crashid", UUID.randomUUID().toString());
        if (this.launchTime != null) {
            statisContent.put("ltime", (System.currentTimeMillis() - this.launchTime.longValue()) / 1000);
        }
        statisContent.put("cpage", DefaultPreference.getPreference().getPrefString(this.mContext, HdStatisConfig.PREF_CPAGE, null));
        statisContent.put("cpkg", ArdUtil.getPackageName(this.mContext));
        statisContent.put("cthread", ProcessUtil.getCurProcessName(this.mContext) + "#" + Process.myTid());
        reportStatisticContentInner(Act.MBSDK_CRASH, statisContent, true, true, false);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCustomContent(long j, String str, String str2) {
        if (this.mContext != null && str2 != null && str2.length() != 0) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            statisContent.put("type", str);
            statisContent.put("content", str2);
            reportStatisticContentInner(Act.MBSDK_REPORT, statisContent, true, true, false);
            return;
        }
        L.warn("StatisAPINew", "Input context is null || content is null", new Object[0]);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
        if (this.mContext == null) {
            L.warn("StatisAPINew", "Input context is null", new Object[0]);
            if (reportResult != null) {
                reportResult.onReportResult(false);
            }
        }
        StatisContent statisContent2 = new StatisContent();
        statisContent2.put("uid", j);
        statisContent2.put("cpunum", ArdUtil.getCpuNum());
        statisContent2.put("cpu", ArdUtil.getMaxCpuFreq());
        statisContent2.put("memory", ArdUtil.getTotalMemory(this.mContext));
        statisContent2.put("rot", ArdUtil.isRoot() ? 1 : 0);
        if (statisContent != null) {
            statisContent2.putContent(statisContent, true);
        }
        boolean reportStatisticContentInner = reportStatisticContentInner(Act.MBSDK_SDKDEVICE, statisContent2, true, true, false);
        if (reportResult != null) {
            reportResult.onReportResult(reportStatisticContentInner);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFeedback(long j, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
        if (this.mContext == null || Util.empty(str2)) {
            L.warn("StatisAPINew", "Input context is null||cont is null", new Object[0]);
            if (reportResult != null) {
                reportResult.onReportResult(false);
            }
        }
        StatisContent statisContent = new StatisContent();
        statisContent.put("uid", j);
        statisContent.put("fbid", str);
        statisContent.put("cont", str2);
        statisContent.put("link", str3);
        statisContent.put("remk", str4);
        boolean reportStatisticContentInner = reportStatisticContentInner(Act.MBSDK_FBACK, statisContent, true, true, false);
        if (reportResult != null) {
            reportResult.onReportResult(reportStatisticContentInner);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("sender", str);
        statisContent.put(SocialConstants.PARAM_RECEIVER, str2);
        statisContent.put("content", str3);
        statisContent.put("edit_time", date.getTime() / 1000);
        statisContent.put("send_time", date2.getTime() / 1000);
        statisContent.put("errormsg", str4);
        statisContent.put("mediatype", i);
        statisContent.put("userdata", str5);
        reportStatisticContentInner(Act.MBSDK_IM, statisContent, true, true, false, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, Packer.OnSavedListener onSavedListener) {
        StatisContent statisContent = new StatisContent();
        statisContent.put("new", i);
        reportStatisticContentInner(Act.MBSDK_INSTALL, statisContent, true, true, true, onSavedListener);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j, String str, StatisContent statisContent) {
        int i;
        int i2;
        if (Util.empty(str)) {
            L.debug("StatisAPINew", "Input appa is null ", new Object[0]);
            return;
        }
        StatisContent statisContent2 = new StatisContent();
        statisContent2.put("uid", j);
        statisContent2.put("appa", str);
        statisContent2.putContent(statisContent, true);
        try {
            statisContent2.put("alr", TrafficMonitor.instance.getAlr());
            statisContent2.put("als", TrafficMonitor.instance.getAls());
            statisContent2.put("apr", TrafficMonitor.instance.getApr());
            statisContent2.put("aps", TrafficMonitor.instance.getAps());
            if (ScreenMonitor.instance.getClick() < 4) {
                i = 0;
            } else {
                i = 2;
            }
            if (ScreenMonitor.instance.getSlide() < 3) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            statisContent2.put("cht", i | i2);
            statisContent2.put("pan", ScreenMonitor.instance.getSlide());
            statisContent2.put("tap", ScreenMonitor.instance.getClick());
        } catch (Throwable th) {
            L.debug(this, "reportLanuch exception=%s", th);
        }
        reportStatisticContentInner(Act.MBSDK_LAUNCH, statisContent2, true, true, true);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j, String str) {
        if (this.mContext != null && str != null && str.length() != 0) {
            try {
                str = Base64Util.encode(str.getBytes("UTF-8"));
            } catch (Throwable th) {
                L.debug("StatisAPINew", "encrypt exception %s", th);
            }
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            statisContent.put("sdklist", str);
            reportStatisticContentInner(Act.MBSDK_SDKLIST, statisContent, true, true, false);
            return;
        }
        L.warn("StatisAPINew", "Input context is null || sdkList is null", new Object[0]);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
        StatisContent statisContent = new StatisContent();
        statisContent.put(Constants.PARAM_PLATFORM, str);
        statisContent.put("mediatype", i);
        statisContent.put("content", str2);
        statisContent.put("stype", shareType.ordinal());
        statisContent.put("errmsg", str3);
        statisContent.put("screen", str4);
        statisContent.put("userdata", str5);
        reportStatisticContentInner(Act.MBSDK_SHARE, statisContent, true, true, false, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str, String str2, Property property) {
        if (Util.empty(str)) {
            L.debug(this, "eid is not allow null.", new Object[0]);
            return;
        }
        if (str.getBytes().length > 256) {
            L.debug(this, "eid[%s] bytes[%d] must under %d bytes.", str, Integer.valueOf(str.getBytes().length), 256);
        }
        if (!Util.empty(str2) && str2.getBytes().length > 256) {
            L.debug(this, "label[%s] bytes[%d] must under %d bytes.", str2, Integer.valueOf(str2.getBytes().length), 256);
        }
        EventInfo eventInfo = new EventInfo();
        EventElementInfo eventElementInfo = new EventElementInfo(str, 1);
        eventElementInfo.addParam(str2);
        eventElementInfo.setProperty(property);
        eventInfo.addElem(eventElementInfo);
        reportEvent(j, eventInfo.getResult());
    }
}
