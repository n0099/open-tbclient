package com.yy.hiidostatis.defs;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.MetricsWorker;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.controller.OaidController;
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
import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.GeneralProxy;
import com.yy.hiidostatis.inner.GeneralStatisTool;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.StringUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.hdid.GAIDClient;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes9.dex */
public class StatisAPIOld implements IStatisApi {
    public static final String DEFAULT_METRICS_NAME = "DEFAULT_METRICS";
    public static final String KEY_MAGIC = "HiidoData";
    public static final int MAX_EVENT_FIELD_BYTES = 256;
    public static final long PRIORITY_INNER = -2;
    public static final long PRIORITY_INNER_SECOND = -1;
    public static final long PRIORITY_OUTER = 0;
    public String appsflyer;
    public AbstractConfig mAbstractConfig;
    public Context mContext;
    public GeneralStatisTool mGeneralStatisTool;
    public StatisOption mOption;
    public String testServer;
    public boolean mIsInit = false;
    public String sessionId = null;
    public ActAdditionListenerController mActListernerController = new ActAdditionListenerController();
    public Long launchTime = null;
    public boolean isAbroad = false;
    public int businessType = 100;
    public MetricsHandler metricsHandler = null;

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        return this;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void exit() {
        this.sessionId = null;
        this.launchTime = null;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void generateSession() {
        try {
            String substring = Coder.encryptMD5(StringUtil.geneGuid()).substring(0, 20);
            this.sessionId = substring;
            L.brief("generate new session:%s", substring);
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
        return this.mOption;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        return this.sessionId;
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
    public void reportAppsflyer(final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.13
            @Override // java.lang.Runnable
            public void run() {
                StatisAPIOld.this.appsflyer = str;
                StatisContent statisContent = new StatisContent();
                statisContent.put(BaseStatisContent.MDSR, str);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_APPSFLYER, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j) {
        reportDevice(j, null, null);
        return true;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo(final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.9
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("htype", DeviceProxy.getType(StatisAPIOld.this.mContext));
                statisContent.put("hfrom", DeviceProxy.getHFrom(StatisAPIOld.this.mContext));
                statisContent.put("htime", DeviceProxy.getCreateTime(StatisAPIOld.this.mContext));
                statisContent.put("sdpm", DeviceProxy.getSdPermission(StatisAPIOld.this.mContext));
                try {
                    statisContent.put("srvtm", GeneralProxy.getGeneralConfigInstance(StatisAPIOld.this.mContext, StatisAPIOld.this.mAbstractConfig).getSrvTime());
                } catch (Throwable th) {
                    L.debug(this, "get srvtm error,%s", th);
                }
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_DO, statisContent, true, true, true);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo5(final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.10
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_DO5, statisContent, true, true, true);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i) {
        reportInstall(i, (IStatisAPI.ReportResult) null);
        return true;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLogin(final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.12
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_LOGIN, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportRun(final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.8
            @Override // java.lang.Runnable
            public void run() {
                StatisAPIOld.this.launchTime = Long.valueOf(System.currentTimeMillis());
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
                WifiInfo wifiInfo = ArdUtil.getWifiInfo(StatisAPIOld.this.mContext);
                if (wifiInfo != null) {
                    statisContent.put("bssid", wifiInfo.getBSSID());
                    statisContent.put(YyLiveRoomConfig.KEY_SSID, wifiInfo.getSSID());
                    statisContent.put("rssi", wifiInfo.getRssi());
                }
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_RUN, statisContent, true, true, true);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAbroad(boolean z) {
        this.isAbroad = z;
        AbstractConfig abstractConfig = this.mAbstractConfig;
        if (abstractConfig != null) {
            abstractConfig.setAbroad(z);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        this.mActListernerController.setHiidoSdkAdditionDelegate(hiidoSdkAdditionDelegate);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setBusinessType(int i) {
        this.businessType = i;
        AbstractConfig abstractConfig = this.mAbstractConfig;
        if (abstractConfig != null) {
            abstractConfig.setBusinessType(i);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        if (str != null && !str.isEmpty()) {
            this.sessionId = str;
        } else {
            generateSession();
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setTestServer(String str) {
        this.testServer = str;
        AbstractConfig abstractConfig = this.mAbstractConfig;
        if (abstractConfig != null) {
            ((HdStatisConfig) abstractConfig).setTestServer(str);
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
    public void init(final Context context, final StatisOption statisOption) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.1
            @Override // java.lang.Runnable
            public void run() {
                String appkey;
                StatisAPIOld statisAPIOld = StatisAPIOld.this;
                StatisOption statisOption2 = statisOption;
                if (statisOption2 == null) {
                    appkey = null;
                } else {
                    appkey = statisOption2.getAppkey();
                }
                statisAPIOld.mAbstractConfig = HdStatisConfig.getConfig(appkey);
                StatisAPIOld statisAPIOld2 = StatisAPIOld.this;
                statisAPIOld2.setTestServer(statisAPIOld2.testServer);
                StatisAPIOld statisAPIOld3 = StatisAPIOld.this;
                statisAPIOld3.setAbroad(statisAPIOld3.isAbroad);
                StatisAPIOld statisAPIOld4 = StatisAPIOld.this;
                statisAPIOld4.setBusinessType(statisAPIOld4.businessType);
                if (!StatisAPIOld.this.mIsInit) {
                    Context context2 = context;
                    if (context2 != null) {
                        StatisAPIOld statisAPIOld5 = StatisAPIOld.this;
                        if (!(context2 instanceof Application)) {
                            context2 = context2.getApplicationContext();
                        }
                        statisAPIOld5.mContext = context2;
                    }
                    StatisAPIOld.this.mOption = statisOption;
                    if (StatisAPIOld.this.mContext != null && StatisAPIOld.this.mOption != null && !Util.empty(StatisAPIOld.this.mOption.getAppkey())) {
                        StatisAPIOld statisAPIOld6 = StatisAPIOld.this;
                        statisAPIOld6.mGeneralStatisTool = GeneralProxy.getGeneralStatisInstance(statisAPIOld6.mContext, StatisAPIOld.this.mAbstractConfig);
                        StatisAPIOld statisAPIOld7 = StatisAPIOld.this;
                        statisAPIOld7.metricsHandler = new MetricsHandler(statisAPIOld7.mContext, statisOption.getAppkey(), statisOption.getVer(), HiidoSDK.instance().getOptions().getDefaultMetricsExpire());
                        L.debug(this, "init finish! appId:%s; appkey:%s; from:%s; ver:%s; sdkver:%s", StatisAPIOld.this.mOption.getAppId(), StatisAPIOld.this.mOption.getAppkey(), StatisAPIOld.this.mOption.getFrom(), StatisAPIOld.this.mOption.getVer(), StatisAPIOld.this.mAbstractConfig.getSdkVer());
                    } else {
                        L.error(this, "init incorrect! Input context is null || mOption is null || Appkey is null", new Object[0]);
                    }
                    StatisAPIOld.this.mIsInit = true;
                    return;
                }
                L.warnOn(this, "statisAPI only be init once", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(final long j, final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.24
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null) {
                    L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("crashmsg", str);
                statisContent.put("rtyp", 2);
                statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
                statisContent.put("tram", ArdUtil.getTotalMemory(StatisAPIOld.this.mContext));
                statisContent.put("trom", ArdUtil.getTotalInternalStorgeSize());
                statisContent.put("tsd", 0);
                statisContent.put("aram", ArdUtil.getAvailMemory(StatisAPIOld.this.mContext));
                statisContent.put("arom", ArdUtil.getAvailInternalStorgeSize());
                statisContent.put("asd", 0);
                statisContent.put("ctyp", "1");
                statisContent.put("crashid", UUID.randomUUID().toString());
                if (StatisAPIOld.this.launchTime != null) {
                    statisContent.put("ltime", (System.currentTimeMillis() - StatisAPIOld.this.launchTime.longValue()) / 1000);
                }
                statisContent.put("cpage", DefaultPreference.getPreference().getPrefString(StatisAPIOld.this.mContext, HdStatisConfig.PREF_CPAGE, null));
                statisContent.put("cpkg", ArdUtil.getPackageName(StatisAPIOld.this.mContext));
                statisContent.put("cthread", ProcessUtil.getCurProcessName(StatisAPIOld.this.mContext) + "#" + Process.myTid());
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_CRASH, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(final long j, final Throwable th) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.25
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null) {
                    L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("crashmsg", StatisAPIOld.this.getErrorInfo(th));
                statisContent.put("rtyp", 1);
                statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
                statisContent.put("tram", ArdUtil.getTotalMemory(StatisAPIOld.this.mContext));
                statisContent.put("trom", ArdUtil.getTotalInternalStorgeSize());
                statisContent.put("tsd", 0);
                statisContent.put("aram", ArdUtil.getAvailMemory(StatisAPIOld.this.mContext));
                statisContent.put("arom", ArdUtil.getAvailInternalStorgeSize());
                statisContent.put("asd", 0);
                statisContent.put("ctyp", "1");
                statisContent.put("crashid", UUID.randomUUID().toString());
                if (StatisAPIOld.this.launchTime != null) {
                    statisContent.put("ltime", (System.currentTimeMillis() - StatisAPIOld.this.launchTime.longValue()) / 1000);
                }
                statisContent.put("cpage", DefaultPreference.getPreference().getPrefString(StatisAPIOld.this.mContext, HdStatisConfig.PREF_CPAGE, null));
                statisContent.put("cpkg", ArdUtil.getPackageName(StatisAPIOld.this.mContext));
                statisContent.put("cthread", ProcessUtil.getCurProcessName(StatisAPIOld.this.mContext) + "#" + Process.myTid());
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_CRASH, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j, StatisContent statisContent) {
        reportDevice(j, statisContent, null);
        return true;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDoShort(final long j, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.11
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("sid", (String) map.get("sid"));
                statisContent.put("subsid", (String) map.get("subsid"));
                statisContent.put("auid", (String) map.get("auid"));
                if (StatisAPIOld.this.launchTime != null) {
                    Long valueOf = Long.valueOf(System.currentTimeMillis() - StatisAPIOld.this.launchTime.longValue());
                    if (valueOf.longValue() > 0) {
                        statisContent.put("dur", valueOf.longValue());
                    }
                }
                statisContent.put("prop", StatisAPIOld.this.getPropString(map));
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_DO1, statisContent, true, true, true);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(final long j, final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.22
            @Override // java.lang.Runnable
            public void run() {
                if (Util.empty(str)) {
                    L.debug("StatisAPIOld", "Input event is null ", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("event", str);
                try {
                    statisContent.put("srvtm", GeneralProxy.getGeneralConfigInstance(StatisAPIOld.this.mContext, StatisAPIOld.this.mAbstractConfig).getSrvTime());
                } catch (Throwable th) {
                    L.debug(this, "get srvtm error,%s", th);
                }
                L.debug(this, "add mbsdkevent %s", str);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_EVENT, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(final int i, final IStatisAPI.ReportResult reportResult) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.7
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null) {
                    L.debug("StatisAPI", "Input context is null", new Object[0]);
                    IStatisAPI.ReportResult reportResult2 = reportResult;
                    if (reportResult2 != null) {
                        reportResult2.onReportResult(false);
                    }
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("new", i);
                statisContent.put("htype", DeviceProxy.getType(StatisAPIOld.this.mContext));
                statisContent.put("hfrom", DeviceProxy.getHFrom(StatisAPIOld.this.mContext));
                statisContent.put("htime", DeviceProxy.getCreateTime(StatisAPIOld.this.mContext));
                statisContent.put("sdpm", DeviceProxy.getSdPermission(StatisAPIOld.this.mContext));
                boolean reportStatisticContentInner = StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_INSTALL, statisContent, true, true, true);
                IStatisAPI.ReportResult reportResult3 = reportResult;
                if (reportResult3 != null) {
                    reportResult3.onReportResult(reportStatisticContentInner);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(final long j, final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.20
            @Override // java.lang.Runnable
            public void run() {
                if (Util.empty(str)) {
                    L.debug("StatisAPIOld", "Input page is null ", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("page", str);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_PAGE, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportPushToken(final long j, final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.37
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext != null && !Util.empty(str)) {
                    StatisContent statisContent = new StatisContent();
                    statisContent.put("uid", j);
                    statisContent.put("pushtoken", str);
                    StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_PUSH, statisContent, true, true, false);
                    return;
                }
                L.warn("StatisAPIOld", "Input context is null||token is null", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(final long j, final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.33
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (StatisAPIOld.this.mContext != null && (str2 = str) != null && str2.length() != 0) {
                    String str3 = str;
                    try {
                        str3 = Base64Util.encode(str3.getBytes("UTF-8"));
                    } catch (Throwable th) {
                        L.debug("StatisAPIOld", "encrypt exception %s", th);
                    }
                    StatisContent statisContent = new StatisContent();
                    statisContent.put("uid", j);
                    statisContent.put("sdklist", str3);
                    StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_SDKLIST, statisContent, true, true, false);
                    return;
                }
                L.warn("StatisAPIOld", "Input context is null || sdkList is null", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str) {
        reportTimesEvent(j, str, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2) {
        reportAppList(j, str, str2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d) {
        reportCountEvent(j, str, d, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCustomContent(final long j, final String str, final String str2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.29
            @Override // java.lang.Runnable
            public void run() {
                String str3;
                if (StatisAPIOld.this.mContext != null && (str3 = str2) != null && str3.length() != 0) {
                    StatisContent statisContent = new StatisContent();
                    statisContent.put("uid", j);
                    statisContent.put("type", str);
                    statisContent.put("content", str2);
                    StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_REPORT, statisContent, true, true, false);
                    return;
                }
                L.warn("StatisAPIOld", "Input context is null || content is null", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(final long j, final StatisContent statisContent, final IStatisAPI.ReportResult reportResult) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.34
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null) {
                    L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                    IStatisAPI.ReportResult reportResult2 = reportResult;
                    if (reportResult2 != null) {
                        reportResult2.onReportResult(false);
                    }
                }
                StatisContent statisContent2 = new StatisContent();
                statisContent2.put("uid", j);
                statisContent2.put("cpunum", ArdUtil.getCpuNum());
                statisContent2.put("cpu", ArdUtil.getMaxCpuFreq());
                statisContent2.put("memory", ArdUtil.getTotalMemory(StatisAPIOld.this.mContext));
                statisContent2.put("rot", ArdUtil.isRoot() ? 1 : 0);
                StatisContent statisContent3 = statisContent;
                if (statisContent3 != null) {
                    statisContent2.putContent(statisContent3, true);
                }
                boolean reportStatisticContentInner = StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_SDKDEVICE, statisContent2, true, true, false);
                IStatisAPI.ReportResult reportResult3 = reportResult;
                if (reportResult3 != null) {
                    reportResult3.onReportResult(reportStatisticContentInner);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(final long j, final String str, final StatisContent statisContent) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.19
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2;
                if (Util.empty(str)) {
                    L.debug("StatisAPIOld", "Input appa is null ", new Object[0]);
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
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_LAUNCH, statisContent2, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(final long j, final String str, final long j2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.21
            @Override // java.lang.Runnable
            public void run() {
                if (Util.empty(str)) {
                    L.debug("StatisAPIOld", "Input page is null ", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("page", str);
                statisContent.put("duration", j2);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_PAGE_STATE, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(final long j, final String str, final String str2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.46
            @Override // java.lang.Runnable
            public void run() {
                String str3;
                String str4;
                String str5 = str;
                if ((str5 != null && str5.length() != 0) || ((str3 = str2) != null && str3.length() != 0)) {
                    StatisContent statisContent = new StatisContent();
                    try {
                        CommonFiller.fillCommonNew(StatisAPIOld.this.mContext, statisContent, Act.MBSDK_RECENT_APPLIST.toString(), StatisAPIOld.this.mAbstractConfig.getSdkVer());
                        CommonFiller.fillConcreteInfoNew(StatisAPIOld.this.mContext, statisContent);
                        String substring = Coder.encryptMD5(statisContent.get("act") + statisContent.get("time") + "HiidoData").toLowerCase().substring(0, 8);
                        L.verbose("StatisAPI", "des key is %s", substring);
                        statisContent.put("uid", j);
                        String str6 = "";
                        if (str == null) {
                            str4 = "";
                        } else {
                            str4 = str;
                        }
                        String encryptDES = Coder.encryptDES(str4, substring);
                        statisContent.put("userapp", encryptDES);
                        if (str2 != null) {
                            str6 = str2;
                        }
                        statisContent.put("systemapp", Coder.encryptDES(str6, substring));
                        L.verbose("StatisAPI", "applist length is %d", Integer.valueOf(encryptDES.length()));
                        StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_RECENT_APPLIST, statisContent, false, false, true);
                        return;
                    } catch (Throwable th) {
                        L.debug("StatisAPI", "encrypt exception %s", th);
                        return;
                    }
                }
                L.debug("StatisAPI", "applist is empty，no report applist !", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, final String str, final StatisContent statisContent) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.5
            @Override // java.lang.Runnable
            public void run() {
                if (!Util.empty(str) && !Util.empty(statisContent)) {
                    StatisContent copy = statisContent.copy();
                    CommonFiller.fillKey(copy, str);
                    StatisAPIOld.this.reportStatisticContentAll(str, copy, false, false, false, false, null);
                    return;
                }
                L.debug("StatisAPI", "Input error! act is null || content is null ", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str, String str2) {
        reportTimesEvent(j, str, str2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportIM(final String str, final String str2, final String str3, final Date date, final Date date2, final String str4, final int i, final String str5) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.15
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("sender", str);
                statisContent.put(SocialConstants.PARAM_RECEIVER, str2);
                statisContent.put("content", str3);
                statisContent.put("edit_time", date.getTime() / 1000);
                statisContent.put("send_time", date2.getTime() / 1000);
                statisContent.put("errormsg", str4);
                statisContent.put("mediatype", i);
                statisContent.put("userdata", str5);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_IM, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(final String str, final int i, final String str2, final String str3, final long j, final int i2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.43
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                StatisAPIOld.this.metricsHandler.reportCount(str, i, str2, str3, j, i2);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFailure(final long j, final String str, final String str2, final String str3, final String str4, final String str5) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.28
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null) {
                    L.warn("StatisAPIOld", "Input context is null!", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("actionid", str);
                statisContent.put("type", str2);
                statisContent.put("failcode", str3);
                statisContent.put("failmsg", str4);
                statisContent.put("parm", str5);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_FAILURE, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFeedback(final long j, final String str, final String str2, final String str3, final String str4, final IStatisAPI.ReportResult reportResult) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.36
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null || Util.empty(str2)) {
                    L.warn("StatisAPIOld", "Input context is null||cont is null", new Object[0]);
                    IStatisAPI.ReportResult reportResult2 = reportResult;
                    if (reportResult2 != null) {
                        reportResult2.onReportResult(false);
                    }
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("fbid", str);
                statisContent.put("cont", str2);
                statisContent.put("link", str3);
                statisContent.put("remk", str4);
                boolean reportStatisticContentInner = StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_FBACK, statisContent, true, true, false);
                IStatisAPI.ReportResult reportResult3 = reportResult;
                if (reportResult3 != null) {
                    reportResult3.onReportResult(reportStatisticContentInner);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(final String str, final int i, final String str2, final long j, final String str3, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.41
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                StatisAPIOld.this.metricsHandler.reportReturnCode(str, i, str2, j, str3, map);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(final String str, final int i, final String str2, final String str3, final long j, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.45
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                StatisAPIOld.this.metricsHandler.reportSrcData(str, i, str2, str3, j, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StatisContent fillBusinessComm(StatisContent statisContent, boolean z) {
        if (z) {
            statisContent = statisContent.copy();
        }
        StatisOption option = getOption();
        if (option != null) {
            statisContent.put("app", option.getAppId());
            statisContent.put("appkey", option.getAppkey());
            statisContent.put("from", option.getFrom());
            statisContent.put("ver", option.getVer());
        }
        String str = this.sessionId;
        if (str != null) {
            statisContent.put(BaseStatisContent.SESSIONID, str);
        }
        String str2 = this.appsflyer;
        if (str2 != null) {
            statisContent.put(BaseStatisContent.MDSR, str2);
        }
        statisContent.put(BaseStatisContent.TIMEZONE, ArdUtil.getTimeZone());
        statisContent.put("oaid", OaidController.INSTANCE.oaid());
        statisContent.put(BaseStatisContent.BDCUID, HiidoSDK.instance().getOptions().getBdCuid());
        AbstractConfig abstractConfig = this.mAbstractConfig;
        if (abstractConfig != null && abstractConfig.isAbroad()) {
            statisContent.put(Config.GAID, GAIDClient.getGAID(this.mContext));
        }
        return statisContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorInfo(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String obj = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return obj;
        } catch (Throwable th2) {
            L.debug("StatisAPIOld", "SDK Get Crash Error Info Exception!" + th2, new Object[0]);
            return "SDK Get Crash Error Info Exception!" + th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPropString(Map<String, String> map) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reportStatisticContentAll(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3, boolean z4, Long l) {
        if (this.mContext != null && !Util.empty(str) && !Util.empty(statisContent)) {
            try {
                return this.mGeneralStatisTool.reportCustom(this.mContext, str, fillBusinessComm(statisContent, z), z2, z3, z4, l);
            } catch (Throwable th) {
                L.debug(this, "reportStatisticContentAll exception .%s", th);
                return false;
            }
        }
        L.error("StatisAPI", "Input error! context is null || act is null || content is null ", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reportStatisticContentInner(Act act, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        try {
            StatisContent actAddition = this.mActListernerController.getActAddition(act, this.mActListernerController.getListerner(act));
            if (actAddition != null) {
                statisContent.putContent(actAddition, false);
            }
            Long l = null;
            if (z3) {
                l = -2L;
                if (Act.MBSDK_APPLIST == act) {
                    l = -1L;
                }
            }
            return reportStatisticContentAll(act.toString(), statisContent, false, z, z2, false, l);
        } catch (Throwable th) {
            L.debug("StatisAPI", "reportStatisticContentInner act:%s ,exception:%s", act.toString(), th);
            return false;
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAction(final long j, final String str, final String str2, final String str3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.18
            @Override // java.lang.Runnable
            public void run() {
                if (Util.empty(str) && Util.empty(str2) && Util.empty(str3)) {
                    L.debug("StatisAPIOld", "Input appa is null && page is null && event is null ", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("appa", str);
                statisContent.put("page", str2);
                statisContent.put("even", str3);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_ACTION, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(final long j, final String str, final String str2, final String str3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.30
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                String str5 = str2;
                if ((str5 != null && str5.length() != 0) || ((str4 = str3) != null && str4.length() != 0)) {
                    StatisContent statisContent = new StatisContent();
                    try {
                        CommonFiller.fillCommonNew(StatisAPIOld.this.mContext, statisContent, Act.MBSDK_APPLIST.toString(), StatisAPIOld.this.mAbstractConfig.getSdkVer());
                        CommonFiller.fillConcreteInfoNew(StatisAPIOld.this.mContext, statisContent);
                        String substring = Coder.encryptMD5(statisContent.get("act") + statisContent.get("time") + "HiidoData").toLowerCase().substring(0, 8);
                        L.verbose("StatisAPIOld", "des key is %s", substring);
                        String encryptDES = Coder.encryptDES(str2, substring);
                        L.verbose("StatisAPIOld", "applist length is %d", Integer.valueOf(encryptDES.length()));
                        statisContent.put("uid", j);
                        statisContent.put("type", str);
                        statisContent.put("applist", encryptDES);
                        statisContent.put("applist2", str3);
                        StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_APPLIST, statisContent, false, false, true);
                        return;
                    } catch (Throwable th) {
                        L.debug("StatisAPIOld", "encrypt exception %s", th);
                        return;
                    }
                }
                L.debug("StatisAPIOld", "applist is empty，no report applist !", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(final int i, final String str, final String str2, final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.39
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                if (!StatisAPIOld.this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                    StatisAPIOld.this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
                }
                StatisAPIOld.this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d, String str2) {
        reportCountEvent(j, str, d, str2, null);
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportError(final long j, final String str, final String str2, final String str3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.23
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("eid", str);
                statisContent.put("emsg", str2);
                statisContent.put("parm", str3);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_ERROR, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReg(final String str, final String str2, final String str3, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.17
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", str);
                statisContent.put("acc", str);
                statisContent.put("name", str2);
                statisContent.put("type", str3);
                statisContent.put("prop", StatisAPIOld.this.getPropString(map));
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_REG, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(final String str, final StatisContent statisContent, final boolean z, final boolean z2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.3
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    CommonFiller.fillKey(statisContent, str);
                }
                StatisAPIOld statisAPIOld = StatisAPIOld.this;
                String str2 = str;
                StatisContent statisContent2 = statisContent;
                boolean z3 = z;
                statisAPIOld.reportStatisticContentAll(str2, statisContent2, true, z3, z3, z2, null);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentTemporary(final String str, final StatisContent statisContent, final boolean z, final boolean z2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.2
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext != null && !Util.empty(str) && !Util.empty(statisContent)) {
                    try {
                        if (!z) {
                            CommonFiller.fillKey(statisContent, str);
                        }
                        StatisAPIOld.this.mGeneralStatisTool.reportCustomTemporary(StatisAPIOld.this.mContext, str, StatisAPIOld.this.fillBusinessComm(statisContent, false), z, z, z2);
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                L.error("StatisAPI", "Input error! context is null || act is null || content is null ", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, final String str, final StatisContent statisContent, final boolean z) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.6
            @Override // java.lang.Runnable
            public void run() {
                Long l;
                if (!Util.empty(str) && !Util.empty(statisContent)) {
                    StatisContent copy = statisContent.copy();
                    CommonFiller.fillKey(copy, str);
                    StatisAPIOld statisAPIOld = StatisAPIOld.this;
                    String str2 = str;
                    if (z) {
                        l = 0L;
                    } else {
                        l = null;
                    }
                    statisAPIOld.reportStatisticContentAll(str2, copy, false, false, false, false, l);
                    return;
                }
                L.debug("StatisAPI", "Input error! act is null || content is null ", new Object[0]);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(final long j, final String str, final String str2, Property property) {
        Property copy;
        if (property == null) {
            copy = null;
        } else {
            copy = property.copy();
        }
        final Property property2 = copy;
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.31
            @Override // java.lang.Runnable
            public void run() {
                if (Util.empty(str)) {
                    L.debug(this, "eid is not allow null.", new Object[0]);
                    return;
                }
                if (str.getBytes().length > 256) {
                    String str3 = str;
                    L.debug(this, "eid[%s] bytes[%d] must under %d bytes.", str3, Integer.valueOf(str3.getBytes().length), 256);
                }
                if (!Util.empty(str2) && str2.getBytes().length > 256) {
                    String str4 = str2;
                    L.debug(this, "label[%s] bytes[%d] must under %d bytes.", str4, Integer.valueOf(str4.getBytes().length), 256);
                }
                EventInfo eventInfo = new EventInfo();
                EventElementInfo eventElementInfo = new EventElementInfo(str, 1);
                eventElementInfo.addParam(str2);
                eventElementInfo.setProperty(property2);
                eventInfo.addElem(eventElementInfo);
                StatisAPIOld.this.reportEvent(j, eventInfo.getResult());
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(final int i, final String str, final String str2, final long j, final int i2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.40
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                if (!StatisAPIOld.this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                    StatisAPIOld.this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
                }
                StatisAPIOld.this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j, i2);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(final long j, final String str, final double d, final String str2, Property property) {
        Property copy;
        if (property == null) {
            copy = null;
        } else {
            copy = property.copy();
        }
        final Property property2 = copy;
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.32
            @Override // java.lang.Runnable
            public void run() {
                if (Util.empty(str)) {
                    L.debug(this, "eid is not allow null.", new Object[0]);
                    return;
                }
                if (str.getBytes().length > 256) {
                    String str3 = str;
                    L.debug(this, "eid[%s] bytes[%d] must under %d bytes.", str3, Integer.valueOf(str3.getBytes().length), 256);
                }
                if (!Util.empty(str2) && str2.getBytes().length > 256) {
                    String str4 = str2;
                    L.debug(this, "label[%s] bytes[%d] must under %d bytes.", str4, Integer.valueOf(str4.getBytes().length), 256);
                }
                EventInfo eventInfo = new EventInfo();
                EventElementInfo eventElementInfo = new EventElementInfo(str, String.valueOf(d));
                eventElementInfo.addParam(str2);
                eventElementInfo.setProperty(property2);
                eventInfo.addElem(eventElementInfo);
                StatisAPIOld.this.reportEvent(j, eventInfo.getResult());
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLocation(final long j, final double d, final double d2, final double d3, final IStatisAPI.ReportResult reportResult) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.35
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null) {
                    L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                    IStatisAPI.ReportResult reportResult2 = reportResult;
                    if (reportResult2 != null) {
                        reportResult2.onReportResult(false);
                    }
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("lon", d);
                statisContent.put(SuggestAddrField.KEY_LAT, d2);
                statisContent.put("alt", d3);
                CellLocation cellId = ArdUtil.getCellId(StatisAPIOld.this.mContext);
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
                WifiInfo wifiInfo = ArdUtil.getWifiInfo(StatisAPIOld.this.mContext);
                if (wifiInfo != null) {
                    statisContent.put("bssid", wifiInfo.getBSSID());
                    statisContent.put(YyLiveRoomConfig.KEY_SSID, wifiInfo.getSSID());
                    statisContent.put("rssi", wifiInfo.getRssi());
                }
                boolean reportStatisticContentInner = StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_LOCATION, statisContent, true, true, false);
                IStatisAPI.ReportResult reportResult3 = reportResult;
                if (reportResult3 != null) {
                    reportResult3.onReportResult(reportStatisticContentInner);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(final int i, final String str, final long j, final String str2, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.38
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                if (!StatisAPIOld.this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                    StatisAPIOld.this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
                }
                StatisAPIOld.this.metricsHandler.reportReturnCode("DEFAULT_METRICS", i, str, j, str2, map);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(final int i, final String str, final String str2, final long j, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.44
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                if (!StatisAPIOld.this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                    StatisAPIOld.this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
                }
                StatisAPIOld.this.metricsHandler.reportSrcData("DEFAULT_METRICS", i, str, str2, j, map);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(final String str, final StatisContent statisContent, final boolean z, final boolean z2, final boolean z3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.4
            @Override // java.lang.Runnable
            public void run() {
                Long l;
                if (!z) {
                    CommonFiller.fillKey(statisContent, str);
                }
                StatisAPIOld statisAPIOld = StatisAPIOld.this;
                String str2 = str;
                StatisContent statisContent2 = statisContent;
                boolean z4 = z;
                boolean z5 = z2;
                if (z3) {
                    l = 0L;
                } else {
                    l = null;
                }
                statisAPIOld.reportStatisticContentAll(str2, statisContent2, true, z4, z4, z5, l);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSuccess(final long j, final String str, final String str2, final long j2, final String str3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.27
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null) {
                    L.warn("StatisAPIOld", "Input context is null!", new Object[0]);
                    return;
                }
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("actionid", str);
                statisContent.put("type", str2);
                statisContent.put("duration", j2);
                statisContent.put("parm", str3);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_SUCCESS, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportUrlScheme(final String str, final String str2, final int i, final String str3, final String str4) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.16
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put("scheme", str);
                statisContent.put("host", str2);
                statisContent.put(ClientCookie.PORT_ATTR, i);
                statisContent.put("path", str3);
                statisContent.put("query", str4);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_URL_SCHEME, statisContent, true, true, false);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(final String str, final int i, final String str2, final String str3, final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.42
            @Override // java.lang.Runnable
            public void run() {
                if (StatisAPIOld.this.mContext == null && StatisAPIOld.this.metricsHandler == null) {
                    return;
                }
                StatisAPIOld.this.metricsHandler.reportCount(str, i, str2, str3, j);
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, Throwable th) {
        reportCrash(j, getErrorInfo(th));
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, final Packer.OnSavedListener onSavedListener) {
        reportInstall(i, new IStatisAPI.ReportResult() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.26
            @Override // com.yy.hiidostatis.defs.interf.IStatisAPI.ReportResult
            public void onReportResult(boolean z) {
                Packer.OnSavedListener onSavedListener2 = onSavedListener;
                if (onSavedListener2 != null) {
                    onSavedListener2.onSaved(z);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportShare(final String str, final int i, final String str2, final ShareType shareType, final String str3, final String str4, final String str5) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.StatisAPIOld.14
            @Override // java.lang.Runnable
            public void run() {
                StatisContent statisContent = new StatisContent();
                statisContent.put(Constants.PARAM_PLATFORM, str);
                statisContent.put("mediatype", i);
                statisContent.put("content", str2);
                statisContent.put("stype", shareType.ordinal());
                statisContent.put("errmsg", str3);
                statisContent.put("screen", str4);
                statisContent.put("userdata", str5);
                StatisAPIOld.this.reportStatisticContentInner(Act.MBSDK_SHARE, statisContent, true, true, false);
            }
        });
    }
}
