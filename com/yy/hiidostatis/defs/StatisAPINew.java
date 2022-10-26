package com.yy.hiidostatis.defs;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_METRICS_NAME = "DEFAULT_METRICS";
    public static final int MAX_EVENT_FIELD_BYTES = 256;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageConfig config;
    public Long launchTime;
    public ActAdditionListenerController mActListernerController;
    public Context mContext;
    public MetricsHandler metricsHandler;
    public Packer packer;

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (IStatisAPI) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo5(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDoShort(long j, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048609, this, j, map) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAbroad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setTestServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
        }
    }

    public StatisAPINew(MessageConfig messageConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActListernerController = new ActAdditionListenerController();
        this.launchTime = null;
        this.metricsHandler = null;
        this.config = messageConfig;
        KVIO.initialize(messageConfig.getApplicationContext());
        DefaultProviderLoader.init();
        TraceLog.initLog(messageConfig.getApplicationContext());
        init();
        this.metricsHandler = new MetricsHandler(messageConfig.getApplicationContext(), messageConfig.getAppkey(), messageConfig.getVer(), HiidoSDK.instance().getOptions().getDefaultMetricsExpire());
    }

    private String getPropString(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, map)) == null) {
            String str = null;
            if (map != null && map.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry entry : map.entrySet()) {
                    try {
                        stringBuffer.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                        stringBuffer.append("=");
                        stringBuffer.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
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
        return (String) invokeL.objValue;
    }

    private String getErrorInfo(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, th)) == null) {
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
        return (String) invokeL.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.packer = (Packer) GlobalProvider.instance.get(Packer.class, this.config);
            this.mContext = this.config.getApplicationContext();
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.config.setSessionId(null);
            this.launchTime = null;
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void generateSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.config.setSessionId(Coder.encryptMD5(StringUtil.geneGuid()).substring(0, 20));
            } catch (Throwable th) {
                L.debug(this, "generateSession exception:%s", th);
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mActListernerController.getHiidoSdkAdditionDelegate();
        }
        return (HiidoSdkAdditionDelegate) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.launchTime;
        }
        return (Long) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.config.getSessionId();
        }
        return (String) invokeV.objValue;
    }

    public void onInitSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.packer.onInited(true);
        }
    }

    private boolean reportStatisticContentAll(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3, Packer.OnSavedListener onSavedListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), onSavedListener})) == null) {
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
        return invokeCommon.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j), str, str2, str3, str4, str5}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFeedback(long j, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j), str, str2, str3, str4, reportResult}) == null) {
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
    }

    private boolean reportStatisticContentInner(Act act, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{act, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            return reportStatisticContentInner(act, statisContent, z, z2, z3, null);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i, String str2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j)}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            this.metricsHandler.reportCount(str, i, str2, str3, j);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            reportStatisticContentAll(str, statisContent, z, z, z2, null);
        }
    }

    private boolean reportStatisticContentInner(Act act, StatisContent statisContent, boolean z, boolean z2, boolean z3, Packer.OnSavedListener onSavedListener) {
        InterceptResult invokeCommon;
        StatisContent.Priority priority;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{act, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), onSavedListener})) == null) {
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
        return invokeCommon.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            this.metricsHandler.reportCount(str, i, str2, str3, j, i2);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j), str3, map}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            this.metricsHandler.reportReturnCode(str, i, str2, j, str3, map);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(String str, int i, String str2, String str3, long j, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), map}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            this.metricsHandler.reportSrcData(str, i, str2, str3, j, map);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
            this.mActListernerController.add(actListener);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void removeActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, actListener) == null) {
            this.mActListernerController.remove(actListener);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.config.setAppsflyer(str);
            StatisContent statisContent = new StatisContent();
            statisContent.put(BaseStatisContent.MDSR, str);
            reportStatisticContentInner(Act.MBSDK_APPSFLYER, statisContent, true, true, false, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048605, this, j)) == null) {
            reportDevice(j, null, null);
            return true;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            reportStatisticContentInner(Act.MBSDK_DO, statisContent, true, true, true, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) {
            reportInstall(i, (Packer.OnSavedListener) null);
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLogin(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            reportStatisticContentInner(Act.MBSDK_LOGIN, statisContent, true, true, false, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportRun(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j) == null) {
            this.launchTime = Long.valueOf(System.currentTimeMillis());
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            reportStatisticContentInner(Act.MBSDK_RUN, statisContent, true, true, true, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, hiidoSdkAdditionDelegate) == null) {
            this.mActListernerController.setHiidoSdkAdditionDelegate(hiidoSdkAdditionDelegate);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            if (str != null && !str.isEmpty()) {
                this.config.setSessionId(str);
            } else {
                generateSession();
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public MetricsWorker addMetricsWorker(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return null;
            }
            return this.metricsHandler.addMetricsWorker(str, j);
        }
        return (MetricsWorker) invokeLJ.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048601, this, j, th) == null) {
            reportCrash(j, getErrorInfo(th));
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j, StatisContent statisContent) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048606, this, j, statisContent)) == null) {
            reportDevice(j, statisContent, null);
            return true;
        }
        return invokeJL.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048615, this, i, reportResult) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("new", i);
            boolean reportStatisticContentInner = reportStatisticContentInner(Act.MBSDK_INSTALL, statisContent, true, true, true, null);
            if (reportResult != null) {
                reportResult.onReportResult(reportStatisticContentInner);
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048639, this, j, str) == null) {
            reportTimesEvent(j, str, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (StatisOption) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, statisOption) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048611, this, j, str) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048621, this, j, str) == null) {
            if (Util.empty(str)) {
                L.debug("StatisAPINew", "Input page is null ", new Object[0]);
                return;
            }
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            statisContent.put("page", str);
            reportStatisticContentInner(Act.MBSDK_PAGE, statisContent, true, true, true);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportPushToken(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048623, this, j, str) == null) {
            if (this.mContext != null && !Util.empty(str)) {
                StatisContent statisContent = new StatisContent();
                statisContent.put("uid", j);
                statisContent.put("pushtoken", str);
                reportStatisticContentInner(Act.MBSDK_PUSH, statisContent, true, true, false);
                return;
            }
            L.warn("StatisAPINew", "Input context is null||token is null", new Object[0]);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAction(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            reportAppList(j, str, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d)}) == null) {
            reportCountEvent(j, str, d, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048636, this, context, str, statisContent) == null) {
            reportStatisticContentAll(str, statisContent, false, false, false, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            reportTimesEvent(j, str, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j)}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportError(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", j);
            statisContent.put("eid", str);
            statisContent.put("emsg", str2);
            statisContent.put("parm", str3);
            reportStatisticContentInner(Act.MBSDK_ERROR, statisContent, true, true, false);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.mContext != null && !Util.empty(str) && !Util.empty(statisContent)) {
                statisContent.setNotSave(true);
                reportStatisticContent(str, statisContent, z, z2);
                return;
            }
            L.error("StatisAPINew", "Input error! context is null || act is null || content is null ", new Object[0]);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i, String str, String str2, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j, i2);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2), str3}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d), str2}) == null) {
            reportCountEvent(j, str, d, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReg(String str, String str2, String str3, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048625, this, str, str2, str3, map) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("uid", str);
            statisContent.put("acc", str);
            statisContent.put("name", str2);
            statisContent.put("type", str3);
            statisContent.put("prop", getPropString(map));
            reportStatisticContentInner(Act.MBSDK_REG, statisContent, true, true, false);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            reportStatisticContentAll(str, statisContent, z, z, z2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j, String str, double d, String str2, Property property) {
        Property copy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d), str2, property}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048600, this, j, str) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048602, this, j, th) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCustomContent(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Long.valueOf(j), str, Long.valueOf(j2)}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j), statisContent, reportResult}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i), str5}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, Packer.OnSavedListener onSavedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048616, this, i, onSavedListener) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("new", i);
            reportStatisticContentInner(Act.MBSDK_INSTALL, statisContent, true, true, true, onSavedListener);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j, String str, StatisContent statisContent) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j), str, statisContent}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLocation(long j, double d, double d2, double d3, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Long.valueOf(j), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), reportResult}) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(int i, String str, long j, String str2, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), str2, map}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportReturnCode("DEFAULT_METRICS", i, str, j, str2, map);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(int i, String str, String str2, long j, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), map}) == null) {
            if (this.mContext == null && this.metricsHandler == null) {
                return;
            }
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportSrcData("DEFAULT_METRICS", i, str, str2, j, map);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportUrlScheme(String str, String str2, int i, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4}) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put("scheme", str);
            statisContent.put("host", str2);
            statisContent.put(ClientCookie.PORT_ATTR, i);
            statisContent.put("path", str3);
            statisContent.put("query", str4);
            reportStatisticContentInner(Act.MBSDK_URL_SCHEME, statisContent, true, true, false);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048629, this, j, str) == null) {
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
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{str, Integer.valueOf(i), str2, shareType, str3, str4, str5}) == null) {
            StatisContent statisContent = new StatisContent();
            statisContent.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, str);
            statisContent.put("mediatype", i);
            statisContent.put("content", str2);
            statisContent.put("stype", shareType.ordinal());
            statisContent.put("errmsg", str3);
            statisContent.put("screen", str4);
            statisContent.put("userdata", str5);
            reportStatisticContentInner(Act.MBSDK_SHARE, statisContent, true, true, false, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) {
            reportStatisticContentAll(str, statisContent, false, false, false, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Long.valueOf(j), str, str2, property}) == null) {
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
}
