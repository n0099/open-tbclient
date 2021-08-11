package com.yy.hiidostatis.defs;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.controller.OaidController;
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
/* loaded from: classes10.dex */
public class StatisAPIOld implements IStatisApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_MAGIC = "HiidoData";
    public static final int MAX_EVENT_FIELD_BYTES = 256;
    public static final long PRIORITY_INNER = -2;
    public static final long PRIORITY_INNER_SECOND = -1;
    public static final long PRIORITY_OUTER = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String appsflyer;
    public int businessType;
    public boolean isAbroad;
    public Long launchTime;
    public AbstractConfig mAbstractConfig;
    public ActAdditionListenerController mActListernerController;
    public Context mContext;
    public GeneralStatisTool mGeneralStatisTool;
    public boolean mIsInit;
    public StatisOption mOption;
    public String sessionId;
    public String testServer;

    public StatisAPIOld() {
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
        this.mIsInit = false;
        this.sessionId = null;
        this.mActListernerController = new ActAdditionListenerController();
        this.launchTime = null;
        this.isAbroad = false;
        this.businessType = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StatisContent fillBusinessComm(StatisContent statisContent, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65557, this, statisContent, z)) == null) {
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
        return (StatisContent) invokeLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorInfo(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, th)) == null) {
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
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPropString(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, map)) == null) {
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
                r1 = stringBuffer.length() > 0 ? stringBuffer.toString().substring(0, stringBuffer.length() - 1) : null;
                stringBuffer.setLength(0);
            }
            return r1;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reportStatisticContentAll(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3, boolean z4, Long l) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), l})) == null) {
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
        return invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reportStatisticContentInner(Act act, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, this, new Object[]{act, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
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
        return invokeCommon.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
            this.mActListernerController.add(actListener);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (IStatisAPI) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.sessionId = null;
            this.launchTime = null;
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void generateSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                String substring = Coder.encryptMD5(StringUtil.geneGuid()).substring(0, 20);
                this.sessionId = substring;
                L.brief("generate new session:%s", substring);
            } catch (Throwable th) {
                L.debug(this, "generateSession exception:%s", th);
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mActListernerController.getHiidoSdkAdditionDelegate() : (HiidoSdkAdditionDelegate) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.launchTime : (Long) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mOption : (StatisOption) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.sessionId : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, statisOption) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, statisOption, context) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ StatisOption val$option;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, statisOption, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$option = statisOption;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisAPIOld statisAPIOld = this.this$0;
                        StatisOption statisOption2 = this.val$option;
                        statisAPIOld.mAbstractConfig = HdStatisConfig.getConfig(statisOption2 == null ? null : statisOption2.getAppkey());
                        StatisAPIOld statisAPIOld2 = this.this$0;
                        statisAPIOld2.setTestServer(statisAPIOld2.testServer);
                        StatisAPIOld statisAPIOld3 = this.this$0;
                        statisAPIOld3.setAbroad(statisAPIOld3.isAbroad);
                        StatisAPIOld statisAPIOld4 = this.this$0;
                        statisAPIOld4.setBusinessType(statisAPIOld4.businessType);
                        if (!this.this$0.mIsInit) {
                            Context context2 = this.val$context;
                            if (context2 != null) {
                                StatisAPIOld statisAPIOld5 = this.this$0;
                                if (!(context2 instanceof Application)) {
                                    context2 = context2.getApplicationContext();
                                }
                                statisAPIOld5.mContext = context2;
                            }
                            this.this$0.mOption = this.val$option;
                            if (this.this$0.mContext != null && this.this$0.mOption != null && !Util.empty(this.this$0.mOption.getAppkey())) {
                                StatisAPIOld statisAPIOld6 = this.this$0;
                                statisAPIOld6.mGeneralStatisTool = GeneralProxy.getGeneralStatisInstance(statisAPIOld6.mContext, this.this$0.mAbstractConfig);
                                L.debug(this, "init finish! appId:%s; appkey:%s; from:%s; ver:%s; sdkver:%s", this.this$0.mOption.getAppId(), this.this$0.mOption.getAppkey(), this.this$0.mOption.getFrom(), this.this$0.mOption.getVer(), this.this$0.mAbstractConfig.getSdkVer());
                            } else {
                                L.error(this, "init incorrect! Input context is null || mOption is null || Appkey is null", new Object[0]);
                            }
                            this.this$0.mIsInit = true;
                            return;
                        }
                        L.warnOn(this, "statisAPI only be init once", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void removeActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, actListener) == null) {
            this.mActListernerController.remove(actListener);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAction(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, str2, str3, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$appa;
                public final /* synthetic */ String val$event;
                public final /* synthetic */ String val$page;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, str3, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$appa = str;
                    this.val$page = str2;
                    this.val$event = str3;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Util.empty(this.val$appa) && Util.empty(this.val$page) && Util.empty(this.val$event)) {
                            L.debug("StatisAPIOld", "Input appa is null && page is null && event is null ", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("appa", this.val$appa);
                        statisContent.put("page", this.val$page);
                        statisContent.put("even", this.val$event);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_ACTION, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            reportAppList(j2, str, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$data;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$data = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.appsflyer = this.val$data;
                        StatisContent statisContent = new StatisContent();
                        statisContent.put(BaseStatisContent.MDSR, this.val$data);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_APPSFLYER, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j2, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2)}) == null) {
            reportCountEvent(j2, str, d2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048594, this, j2, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2, str) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$crashMsg;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                    this.val$crashMsg = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null) {
                            L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("crashmsg", this.val$crashMsg);
                        statisContent.put("rtyp", 2);
                        statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
                        statisContent.put("tram", ArdUtil.getTotalMemory(this.this$0.mContext));
                        statisContent.put("trom", ArdUtil.getTotalInternalStorgeSize());
                        statisContent.put("tsd", 0);
                        statisContent.put("aram", ArdUtil.getAvailMemory(this.this$0.mContext));
                        statisContent.put("arom", ArdUtil.getAvailInternalStorgeSize());
                        statisContent.put("asd", 0);
                        statisContent.put("ctyp", "1");
                        statisContent.put("crashid", UUID.randomUUID().toString());
                        if (this.this$0.launchTime != null) {
                            statisContent.put("ltime", (System.currentTimeMillis() - this.this$0.launchTime.longValue()) / 1000);
                        }
                        statisContent.put("cpage", DefaultPreference.getPreference().getPrefString(this.this$0.mContext, HdStatisConfig.PREF_CPAGE, null));
                        statisContent.put("cpkg", ArdUtil.getPackageName(this.this$0.mContext));
                        statisContent.put("cthread", ProcessUtil.getCurProcessName(this.this$0.mContext) + "#" + Process.myTid());
                        this.this$0.reportStatisticContentInner(Act.MBSDK_CRASH, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048596, this, j2, th) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2, th) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ Throwable val$throwable;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), th};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                    this.val$throwable = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null) {
                            L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("crashmsg", this.this$0.getErrorInfo(this.val$throwable));
                        statisContent.put("rtyp", 1);
                        statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
                        statisContent.put("tram", ArdUtil.getTotalMemory(this.this$0.mContext));
                        statisContent.put("trom", ArdUtil.getTotalInternalStorgeSize());
                        statisContent.put("tsd", 0);
                        statisContent.put("aram", ArdUtil.getAvailMemory(this.this$0.mContext));
                        statisContent.put("arom", ArdUtil.getAvailInternalStorgeSize());
                        statisContent.put("asd", 0);
                        statisContent.put("ctyp", "1");
                        statisContent.put("crashid", UUID.randomUUID().toString());
                        if (this.this$0.launchTime != null) {
                            statisContent.put("ltime", (System.currentTimeMillis() - this.this$0.launchTime.longValue()) / 1000);
                        }
                        statisContent.put("cpage", DefaultPreference.getPreference().getPrefString(this.this$0.mContext, HdStatisConfig.PREF_CPAGE, null));
                        statisContent.put("cpkg", ArdUtil.getPackageName(this.this$0.mContext));
                        statisContent.put("cthread", ProcessUtil.getCurProcessName(this.this$0.mContext) + "#" + Process.myTid());
                        this.this$0.reportStatisticContentInner(Act.MBSDK_CRASH, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCustomContent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str2, j2, str) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$content;
                public final /* synthetic */ String val$type;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, Long.valueOf(j2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$content = str2;
                    this.val$uid = j2;
                    this.val$type = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext != null && (str3 = this.val$content) != null && str3.length() != 0) {
                            StatisContent statisContent = new StatisContent();
                            statisContent.put("uid", this.val$uid);
                            statisContent.put("type", this.val$type);
                            statisContent.put("content", this.val$content);
                            this.this$0.reportStatisticContentInner(Act.MBSDK_REPORT, statisContent, true, true, false);
                            return;
                        }
                        L.warn("StatisAPIOld", "Input context is null || content is null", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j2, StatisContent statisContent) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048600, this, j2, statisContent)) == null) {
            reportDevice(j2, statisContent, null);
            return true;
        }
        return invokeJL.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("htype", DeviceProxy.getType(this.this$0.mContext));
                        statisContent.put("hfrom", DeviceProxy.getHFrom(this.this$0.mContext));
                        statisContent.put("htime", DeviceProxy.getCreateTime(this.this$0.mContext));
                        statisContent.put("sdpm", DeviceProxy.getSdPermission(this.this$0.mContext));
                        try {
                            statisContent.put("srvtm", GeneralProxy.getGeneralConfigInstance(this.this$0.mContext, this.this$0.mAbstractConfig).getSrvTime());
                        } catch (Throwable th) {
                            L.debug(this, "get srvtm error,%s", th);
                        }
                        this.this$0.reportStatisticContentInner(Act.MBSDK_DO, statisContent, true, true, true);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo5(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_DO5, statisContent, true, true, true);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDoShort(long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048603, this, j2, map) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2, map) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ Map val$prop;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                    this.val$prop = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("sid", (String) this.val$prop.get("sid"));
                        statisContent.put("subsid", (String) this.val$prop.get("subsid"));
                        statisContent.put("auid", (String) this.val$prop.get("auid"));
                        if (this.this$0.launchTime != null) {
                            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.this$0.launchTime.longValue());
                            if (valueOf.longValue() > 0) {
                                statisContent.put("dur", valueOf.longValue());
                            }
                        }
                        statisContent.put("prop", this.this$0.getPropString(this.val$prop));
                        this.this$0.reportStatisticContentInner(Act.MBSDK_DO1, statisContent, true, true, true);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportError(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2, str, str2, str3) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$eid;
                public final /* synthetic */ String val$emsg;
                public final /* synthetic */ String val$param;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), str, str2, str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                    this.val$eid = str;
                    this.val$emsg = str2;
                    this.val$param = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("eid", this.val$eid);
                        statisContent.put("emsg", this.val$emsg);
                        statisContent.put("parm", this.val$param);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_ERROR, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048605, this, j2, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$event;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$event = str;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Util.empty(this.val$event)) {
                            L.debug("StatisAPIOld", "Input event is null ", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("event", this.val$event);
                        try {
                            statisContent.put("srvtm", GeneralProxy.getGeneralConfigInstance(this.this$0.mContext, this.this$0.mAbstractConfig).getSrvTime());
                        } catch (Throwable th) {
                            L.debug(this, "get srvtm error,%s", th);
                        }
                        L.debug(this, "add mbsdkevent %s", this.val$event);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_EVENT, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFailure(long j2, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, str5}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2, str, str2, str3, str4, str5) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$aid;
                public final /* synthetic */ String val$failCode;
                public final /* synthetic */ String val$failMsg;
                public final /* synthetic */ String val$parm;
                public final /* synthetic */ String val$type;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), str, str2, str3, str4, str5};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                    this.val$aid = str;
                    this.val$type = str2;
                    this.val$failCode = str3;
                    this.val$failMsg = str4;
                    this.val$parm = str5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null) {
                            L.warn("StatisAPIOld", "Input context is null!", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("actionid", this.val$aid);
                        statisContent.put("type", this.val$type);
                        statisContent.put("failcode", this.val$failCode);
                        statisContent.put("failmsg", this.val$failMsg);
                        statisContent.put("parm", this.val$parm);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_FAILURE, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFeedback(long j2, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, reportResult}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str2, reportResult, j2, str, str3, str4) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.36
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$cont;
                public final /* synthetic */ String val$fbId;
                public final /* synthetic */ String val$link;
                public final /* synthetic */ String val$remk;
                public final /* synthetic */ IStatisAPI.ReportResult val$resultReceiver;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, reportResult, Long.valueOf(j2), str, str3, str4};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$cont = str2;
                    this.val$resultReceiver = reportResult;
                    this.val$uid = j2;
                    this.val$fbId = str;
                    this.val$link = str3;
                    this.val$remk = str4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null || Util.empty(this.val$cont)) {
                            L.warn("StatisAPIOld", "Input context is null||cont is null", new Object[0]);
                            IStatisAPI.ReportResult reportResult2 = this.val$resultReceiver;
                            if (reportResult2 != null) {
                                reportResult2.onReportResult(false);
                            }
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("fbid", this.val$fbId);
                        statisContent.put("cont", this.val$cont);
                        statisContent.put("link", this.val$link);
                        statisContent.put("remk", this.val$remk);
                        boolean reportStatisticContentInner = this.this$0.reportStatisticContentInner(Act.MBSDK_FBACK, statisContent, true, true, false);
                        IStatisAPI.ReportResult reportResult3 = this.val$resultReceiver;
                        if (reportResult3 != null) {
                            reportResult3.onReportResult(reportStatisticContentInner);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i2), str5}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, str2, str3, date, date2, str4, i2, str5) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$content;
                public final /* synthetic */ Date val$editTime;
                public final /* synthetic */ String val$errormsg;
                public final /* synthetic */ int val$mediaType;
                public final /* synthetic */ String val$receiver;
                public final /* synthetic */ Date val$sendTime;
                public final /* synthetic */ String val$sender;
                public final /* synthetic */ String val$userData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, str3, date, date2, str4, Integer.valueOf(i2), str5};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$sender = str;
                    this.val$receiver = str2;
                    this.val$content = str3;
                    this.val$editTime = date;
                    this.val$sendTime = date2;
                    this.val$errormsg = str4;
                    this.val$mediaType = i2;
                    this.val$userData = str5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("sender", this.val$sender);
                        statisContent.put(SocialConstants.PARAM_RECEIVER, this.val$receiver);
                        statisContent.put("content", this.val$content);
                        statisContent.put("edit_time", this.val$editTime.getTime() / 1000);
                        statisContent.put("send_time", this.val$sendTime.getTime() / 1000);
                        statisContent.put("errormsg", this.val$errormsg);
                        statisContent.put("mediatype", this.val$mediaType);
                        statisContent.put("userdata", this.val$userData);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_IM, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i2, reportResult) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, reportResult, i2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ IStatisAPI.ReportResult val$resultReceiver;
                public final /* synthetic */ int val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, reportResult, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$resultReceiver = reportResult;
                    this.val$type = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null) {
                            L.debug("StatisAPI", "Input context is null", new Object[0]);
                            IStatisAPI.ReportResult reportResult2 = this.val$resultReceiver;
                            if (reportResult2 != null) {
                                reportResult2.onReportResult(false);
                            }
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("new", this.val$type);
                        statisContent.put("htype", DeviceProxy.getType(this.this$0.mContext));
                        statisContent.put("hfrom", DeviceProxy.getHFrom(this.this$0.mContext));
                        statisContent.put("htime", DeviceProxy.getCreateTime(this.this$0.mContext));
                        statisContent.put("sdpm", DeviceProxy.getSdPermission(this.this$0.mContext));
                        boolean reportStatisticContentInner = this.this$0.reportStatisticContentInner(Act.MBSDK_INSTALL, statisContent, true, true, true);
                        IStatisAPI.ReportResult reportResult3 = this.val$resultReceiver;
                        if (reportResult3 != null) {
                            reportResult3.onReportResult(reportStatisticContentInner);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j2, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j2), str, statisContent}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, j2, statisContent) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$appa;
                public final /* synthetic */ StatisContent val$sensor;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2), statisContent};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$appa = str;
                    this.val$uid = j2;
                    this.val$sensor = statisContent;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Util.empty(this.val$appa)) {
                            L.debug("StatisAPIOld", "Input appa is null ", new Object[0]);
                            return;
                        }
                        StatisContent statisContent2 = new StatisContent();
                        statisContent2.put("uid", this.val$uid);
                        statisContent2.put("appa", this.val$appa);
                        statisContent2.putContent(this.val$sensor, true);
                        try {
                            statisContent2.put("alr", TrafficMonitor.instance.getAlr());
                            statisContent2.put("als", TrafficMonitor.instance.getAls());
                            statisContent2.put("apr", TrafficMonitor.instance.getApr());
                            statisContent2.put("aps", TrafficMonitor.instance.getAps());
                            statisContent2.put("cht", (ScreenMonitor.instance.getClick() < 4 ? 0 : 2) | (ScreenMonitor.instance.getSlide() < 3 ? 0 : 1));
                            statisContent2.put("pan", ScreenMonitor.instance.getSlide());
                            statisContent2.put("tap", ScreenMonitor.instance.getClick());
                        } catch (Throwable th) {
                            L.debug(this, "reportLanuch exception=%s", th);
                        }
                        this.this$0.reportStatisticContentInner(Act.MBSDK_LAUNCH, statisContent2, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLocation(long j2, double d2, double d3, double d4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), reportResult}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, reportResult, j2, d2, d3, d4) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ double val$altitude;
                public final /* synthetic */ double val$latitude;
                public final /* synthetic */ double val$longitude;
                public final /* synthetic */ IStatisAPI.ReportResult val$resultReceiver;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, reportResult, Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$resultReceiver = reportResult;
                    this.val$uid = j2;
                    this.val$longitude = d2;
                    this.val$latitude = d3;
                    this.val$altitude = d4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null) {
                            L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                            IStatisAPI.ReportResult reportResult2 = this.val$resultReceiver;
                            if (reportResult2 != null) {
                                reportResult2.onReportResult(false);
                            }
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("lon", this.val$longitude);
                        statisContent.put(SuggestAddrField.KEY_LAT, this.val$latitude);
                        statisContent.put("alt", this.val$altitude);
                        CellLocation cellId = ArdUtil.getCellId(this.this$0.mContext);
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
                        WifiInfo wifiInfo = ArdUtil.getWifiInfo(this.this$0.mContext);
                        if (wifiInfo != null) {
                            statisContent.put("bssid", wifiInfo.getBSSID());
                            statisContent.put("ssid", wifiInfo.getSSID());
                            statisContent.put("rssi", wifiInfo.getRssi());
                        }
                        boolean reportStatisticContentInner = this.this$0.reportStatisticContentInner(Act.MBSDK_LOCATION, statisContent, true, true, false);
                        IStatisAPI.ReportResult reportResult3 = this.val$resultReceiver;
                        if (reportResult3 != null) {
                            reportResult3.onReportResult(reportStatisticContentInner);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLogin(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048614, this, j2) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_LOGIN, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048615, this, j2, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$page;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$page = str;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Util.empty(this.val$page)) {
                            L.debug("StatisAPIOld", "Input page is null ", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("page", this.val$page);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_PAGE, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3)}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, j2, j3) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ long val$duration;
                public final /* synthetic */ String val$page;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2), Long.valueOf(j3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$page = str;
                    this.val$uid = j2;
                    this.val$duration = j3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Util.empty(this.val$page)) {
                            L.debug("StatisAPIOld", "Input page is null ", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("page", this.val$page);
                        statisContent.put("duration", this.val$duration);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_PAGE_STATE, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportPushToken(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048617, this, j2, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$token;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$token = str;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext != null && !Util.empty(this.val$token)) {
                            StatisContent statisContent = new StatisContent();
                            statisContent.put("uid", this.val$uid);
                            statisContent.put("pushtoken", this.val$token);
                            this.this$0.reportStatisticContentInner(Act.MBSDK_PUSH, statisContent, true, true, false);
                            return;
                        }
                        L.warn("StatisAPIOld", "Input context is null||token is null", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, str2, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.38
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$systemApp;
                public final /* synthetic */ long val$uid;
                public final /* synthetic */ String val$userApp;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$userApp = str;
                    this.val$systemApp = str2;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str4 = this.val$userApp;
                        if ((str4 != null && str4.length() != 0) || ((str3 = this.val$systemApp) != null && str3.length() != 0)) {
                            StatisContent statisContent = new StatisContent();
                            try {
                                CommonFiller.fillCommonNew(this.this$0.mContext, statisContent, Act.MBSDK_RECENT_APPLIST.toString(), this.this$0.mAbstractConfig.getSdkVer());
                                CommonFiller.fillConcreteInfoNew(this.this$0.mContext, statisContent);
                                String substring = Coder.encryptMD5(statisContent.get("act") + statisContent.get("time") + "HiidoData").toLowerCase().substring(0, 8);
                                L.verbose("StatisAPI", "des key is %s", substring);
                                statisContent.put("uid", this.val$uid);
                                String str5 = "";
                                String encryptDES = Coder.encryptDES(this.val$userApp == null ? "" : this.val$userApp, substring);
                                statisContent.put("userapp", encryptDES);
                                if (this.val$systemApp != null) {
                                    str5 = this.val$systemApp;
                                }
                                statisContent.put("systemapp", Coder.encryptDES(str5, substring));
                                L.verbose("StatisAPI", "applist length is %d", Integer.valueOf(encryptDES.length()));
                                this.this$0.reportStatisticContentInner(Act.MBSDK_RECENT_APPLIST, statisContent, false, false, true);
                                return;
                            } catch (Throwable th) {
                                L.debug("StatisAPI", "encrypt exception %s", th);
                                return;
                            }
                        }
                        L.debug("StatisAPI", "applist is empty，no report applist !", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048619, this, str, str2, str3, map) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, str2, str3, map) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$name;
                public final /* synthetic */ Map val$prop;
                public final /* synthetic */ String val$type;
                public final /* synthetic */ String val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, str3, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = str;
                    this.val$name = str2;
                    this.val$type = str3;
                    this.val$prop = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("acc", this.val$uid);
                        statisContent.put("name", this.val$name);
                        statisContent.put("type", this.val$type);
                        statisContent.put("prop", this.this$0.getPropString(this.val$prop));
                        this.this$0.reportStatisticContentInner(Act.MBSDK_REG, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportRun(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.launchTime = Long.valueOf(System.currentTimeMillis());
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("rot", ArdUtil.isRoot() ? 1 : 0);
                        WifiInfo wifiInfo = ArdUtil.getWifiInfo(this.this$0.mContext);
                        if (wifiInfo != null) {
                            statisContent.put("bssid", wifiInfo.getBSSID());
                            statisContent.put("ssid", wifiInfo.getSSID());
                            statisContent.put("rssi", wifiInfo.getRssi());
                        }
                        this.this$0.reportStatisticContentInner(Act.MBSDK_RUN, statisContent, true, true, true);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048621, this, j2, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$sdkList;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$sdkList = str;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext != null && (str2 = this.val$sdkList) != null && str2.length() != 0) {
                            String str3 = this.val$sdkList;
                            try {
                                str3 = Base64Util.encode(str3.getBytes("UTF-8"));
                            } catch (Throwable th) {
                                L.debug("StatisAPIOld", "encrypt exception %s", th);
                            }
                            StatisContent statisContent = new StatisContent();
                            statisContent.put("uid", this.val$uid);
                            statisContent.put("sdklist", str3);
                            this.this$0.reportStatisticContentInner(Act.MBSDK_SDKLIST, statisContent, true, true, false);
                            return;
                        }
                        L.warn("StatisAPIOld", "Input context is null || sdkList is null", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{str, Integer.valueOf(i2), str2, shareType, str3, str4, str5}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, i2, str2, shareType, str3, str4, str5) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$content;
                public final /* synthetic */ String val$errmsg;
                public final /* synthetic */ int val$mediaType;
                public final /* synthetic */ String val$platform;
                public final /* synthetic */ String val$screen;
                public final /* synthetic */ ShareType val$stype;
                public final /* synthetic */ String val$userData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), str2, shareType, str3, str4, str5};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$platform = str;
                    this.val$mediaType = i2;
                    this.val$content = str2;
                    this.val$stype = shareType;
                    this.val$errmsg = str3;
                    this.val$screen = str4;
                    this.val$userData = str5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, this.val$platform);
                        statisContent.put("mediatype", this.val$mediaType);
                        statisContent.put("content", this.val$content);
                        statisContent.put("stype", this.val$stype.ordinal());
                        statisContent.put("errmsg", this.val$errmsg);
                        statisContent.put("screen", this.val$screen);
                        statisContent.put("userdata", this.val$userData);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_SHARE, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, z, statisContent, str, z2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$act;
                public final /* synthetic */ StatisContent val$content;
                public final /* synthetic */ boolean val$fillCommon;
                public final /* synthetic */ boolean val$isCover;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), statisContent, str, Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fillCommon = z;
                    this.val$content = statisContent;
                    this.val$act = str;
                    this.val$isCover = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.val$fillCommon) {
                            CommonFiller.fillKey(this.val$content, this.val$act);
                        }
                        StatisAPIOld statisAPIOld = this.this$0;
                        String str2 = this.val$act;
                        StatisContent statisContent2 = this.val$content;
                        boolean z3 = this.val$fillCommon;
                        statisAPIOld.reportStatisticContentAll(str2, statisContent2, true, z3, z3, this.val$isCover, null);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, statisContent, z, z2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$act;
                public final /* synthetic */ StatisContent val$content;
                public final /* synthetic */ boolean val$fillCommon;
                public final /* synthetic */ boolean val$isCover;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$act = str;
                    this.val$content = statisContent;
                    this.val$fillCommon = z;
                    this.val$isCover = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext != null && !Util.empty(this.val$act) && !Util.empty(this.val$content)) {
                            try {
                                if (!this.val$fillCommon) {
                                    CommonFiller.fillKey(this.val$content, this.val$act);
                                }
                                this.this$0.mGeneralStatisTool.reportCustomTemporary(this.this$0.mContext, this.val$act, this.this$0.fillBusinessComm(this.val$content, false), this.val$fillCommon, this.val$fillCommon, this.val$isCover);
                                return;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return;
                            }
                        }
                        L.error("StatisAPI", "Input error! context is null || act is null || content is null ", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048626, this, context, str, statisContent) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, statisContent) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$act;
                public final /* synthetic */ StatisContent val$content;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, statisContent};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$act = str;
                    this.val$content = statisContent;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!Util.empty(this.val$act) && !Util.empty(this.val$content)) {
                            StatisContent copy = this.val$content.copy();
                            CommonFiller.fillKey(copy, this.val$act);
                            this.this$0.reportStatisticContentAll(this.val$act, copy, false, false, false, false, null);
                            return;
                        }
                        L.debug("StatisAPI", "Input error! act is null || content is null ", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSuccess(long j2, String str, String str2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3), str3}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, j2, str, str2, j3, str3) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$aid;
                public final /* synthetic */ long val$duration;
                public final /* synthetic */ String val$parm;
                public final /* synthetic */ String val$type;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), str, str2, Long.valueOf(j3), str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$uid = j2;
                    this.val$aid = str;
                    this.val$type = str2;
                    this.val$duration = j3;
                    this.val$parm = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null) {
                            L.warn("StatisAPIOld", "Input context is null!", new Object[0]);
                            return;
                        }
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("uid", this.val$uid);
                        statisContent.put("actionid", this.val$aid);
                        statisContent.put("type", this.val$type);
                        statisContent.put("duration", this.val$duration);
                        statisContent.put("parm", this.val$parm);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_SUCCESS, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048629, this, j2, str) == null) {
            reportTimesEvent(j2, str, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportUrlScheme(String str, String str2, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, str2, i2, str3, str4) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$host;
                public final /* synthetic */ String val$path;
                public final /* synthetic */ int val$port;
                public final /* synthetic */ String val$query;
                public final /* synthetic */ String val$scheme;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, Integer.valueOf(i2), str3, str4};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$scheme = str;
                    this.val$host = str2;
                    this.val$port = i2;
                    this.val$path = str3;
                    this.val$query = str4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        StatisContent statisContent = new StatisContent();
                        statisContent.put("scheme", this.val$scheme);
                        statisContent.put("host", this.val$host);
                        statisContent.put(ClientCookie.PORT_ATTR, this.val$port);
                        statisContent.put("path", this.val$path);
                        statisContent.put("query", this.val$query);
                        this.this$0.reportStatisticContentInner(Act.MBSDK_URL_SCHEME, statisContent, true, true, false);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAbroad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.isAbroad = z;
            AbstractConfig abstractConfig = this.mAbstractConfig;
            if (abstractConfig != null) {
                abstractConfig.setAbroad(z);
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, hiidoSdkAdditionDelegate) == null) {
            this.mActListernerController.setHiidoSdkAdditionDelegate(hiidoSdkAdditionDelegate);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.businessType = i2;
            AbstractConfig abstractConfig = this.mAbstractConfig;
            if (abstractConfig != null) {
                abstractConfig.setBusinessType(i2);
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            if (str != null && !str.isEmpty()) {
                this.sessionId = str;
            } else {
                generateSession();
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setTestServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.testServer = str;
            AbstractConfig abstractConfig = this.mAbstractConfig;
            if (abstractConfig != null) {
                ((HdStatisConfig) abstractConfig).setTestServer(str);
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str2, str3, j2, str) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$applist;
                public final /* synthetic */ String val$applist2;
                public final /* synthetic */ String val$type;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str3, Long.valueOf(j2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$applist = str2;
                    this.val$applist2 = str3;
                    this.val$uid = j2;
                    this.val$type = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str5 = this.val$applist;
                        if ((str5 != null && str5.length() != 0) || ((str4 = this.val$applist2) != null && str4.length() != 0)) {
                            StatisContent statisContent = new StatisContent();
                            try {
                                CommonFiller.fillCommonNew(this.this$0.mContext, statisContent, Act.MBSDK_APPLIST.toString(), this.this$0.mAbstractConfig.getSdkVer());
                                CommonFiller.fillConcreteInfoNew(this.this$0.mContext, statisContent);
                                String substring = Coder.encryptMD5(statisContent.get("act") + statisContent.get("time") + "HiidoData").toLowerCase().substring(0, 8);
                                L.verbose("StatisAPIOld", "des key is %s", substring);
                                String encryptDES = Coder.encryptDES(this.val$applist, substring);
                                L.verbose("StatisAPIOld", "applist length is %d", Integer.valueOf(encryptDES.length()));
                                statisContent.put("uid", this.val$uid);
                                statisContent.put("type", this.val$type);
                                statisContent.put("applist", encryptDES);
                                statisContent.put("applist2", this.val$applist2);
                                this.this$0.reportStatisticContentInner(Act.MBSDK_APPLIST, statisContent, false, false, true);
                                return;
                            } catch (Throwable th) {
                                L.debug("StatisAPIOld", "encrypt exception %s", th);
                                return;
                            }
                        }
                        L.debug("StatisAPIOld", "applist is empty，no report applist !", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j2, String str, double d2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2}) == null) {
            reportCountEvent(j2, str, d2, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048595, this, j2, th) == null) {
            reportCrash(j2, getErrorInfo(th));
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) {
            reportDevice(j2, null, null);
            return true;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, Packer.OnSavedListener onSavedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i2, onSavedListener) == null) {
            reportInstall(i2, new IStatisAPI.ReportResult(this, onSavedListener) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ Packer.OnSavedListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onSavedListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = onSavedListener;
                }

                @Override // com.yy.hiidostatis.defs.interf.IStatisAPI.ReportResult
                public void onReportResult(boolean z) {
                    Packer.OnSavedListener onSavedListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) || (onSavedListener2 = this.val$listener) == null) {
                        return;
                    }
                    onSavedListener2.onSaved(z);
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, z, statisContent, str, z2, z3) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$act;
                public final /* synthetic */ StatisContent val$content;
                public final /* synthetic */ boolean val$fillCommon;
                public final /* synthetic */ boolean val$isCover;
                public final /* synthetic */ boolean val$isPriority;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), statisContent, str, Boolean.valueOf(z2), Boolean.valueOf(z3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fillCommon = z;
                    this.val$content = statisContent;
                    this.val$act = str;
                    this.val$isCover = z2;
                    this.val$isPriority = z3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.val$fillCommon) {
                            CommonFiller.fillKey(this.val$content, this.val$act);
                        }
                        StatisAPIOld statisAPIOld = this.this$0;
                        String str2 = this.val$act;
                        StatisContent statisContent2 = this.val$content;
                        boolean z4 = this.val$fillCommon;
                        statisAPIOld.reportStatisticContentAll(str2, statisContent2, true, z4, z4, this.val$isCover, this.val$isPriority ? 0L : null);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, statisContent, z) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$act;
                public final /* synthetic */ StatisContent val$content;
                public final /* synthetic */ boolean val$isPriority;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, statisContent, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$act = str;
                    this.val$content = statisContent;
                    this.val$isPriority = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!Util.empty(this.val$act) && !Util.empty(this.val$content)) {
                            StatisContent copy = this.val$content.copy();
                            CommonFiller.fillKey(copy, this.val$act);
                            this.this$0.reportStatisticContentAll(this.val$act, copy, false, false, false, false, this.val$isPriority ? 0L : null);
                            return;
                        }
                        L.debug("StatisAPI", "Input error! act is null || content is null ", new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            reportTimesEvent(j2, str, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j2, String str, double d2, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2, property}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, str2, d2, property == null ? null : property.copy(), j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$eid;
                public final /* synthetic */ double val$evalue;
                public final /* synthetic */ String val$label;
                public final /* synthetic */ Property val$pro;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, Double.valueOf(d2), r11, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$eid = str;
                    this.val$label = str2;
                    this.val$evalue = d2;
                    this.val$pro = r11;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Util.empty(this.val$eid)) {
                            L.debug(this, "eid is not allow null.", new Object[0]);
                            return;
                        }
                        if (this.val$eid.getBytes().length > 256) {
                            String str3 = this.val$eid;
                            L.debug(this, "eid[%s] bytes[%d] must under %d bytes.", str3, Integer.valueOf(str3.getBytes().length), 256);
                        }
                        if (!Util.empty(this.val$label) && this.val$label.getBytes().length > 256) {
                            String str4 = this.val$label;
                            L.debug(this, "label[%s] bytes[%d] must under %d bytes.", str4, Integer.valueOf(str4.getBytes().length), 256);
                        }
                        EventInfo eventInfo = new EventInfo();
                        EventElementInfo eventElementInfo = new EventElementInfo(this.val$eid, String.valueOf(this.val$evalue));
                        eventElementInfo.addParam(this.val$label);
                        eventElementInfo.setProperty(this.val$pro);
                        eventInfo.addElem(eventElementInfo);
                        this.this$0.reportEvent(this.val$uid, eventInfo.getResult());
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j2, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j2), statisContent, reportResult}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, reportResult, j2, statisContent) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.34
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ StatisContent val$extra;
                public final /* synthetic */ IStatisAPI.ReportResult val$resultReceiver;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, reportResult, Long.valueOf(j2), statisContent};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$resultReceiver = reportResult;
                    this.val$uid = j2;
                    this.val$extra = statisContent;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mContext == null) {
                            L.warn("StatisAPIOld", "Input context is null", new Object[0]);
                            IStatisAPI.ReportResult reportResult2 = this.val$resultReceiver;
                            if (reportResult2 != null) {
                                reportResult2.onReportResult(false);
                            }
                        }
                        StatisContent statisContent2 = new StatisContent();
                        statisContent2.put("uid", this.val$uid);
                        statisContent2.put("cpunum", ArdUtil.getCpuNum());
                        statisContent2.put("cpu", ArdUtil.getMaxCpuFreq());
                        statisContent2.put("memory", ArdUtil.getTotalMemory(this.this$0.mContext));
                        statisContent2.put("rot", ArdUtil.isRoot() ? 1 : 0);
                        StatisContent statisContent3 = this.val$extra;
                        if (statisContent3 != null) {
                            statisContent2.putContent(statisContent3, true);
                        }
                        boolean reportStatisticContentInner = this.this$0.reportStatisticContentInner(Act.MBSDK_SDKDEVICE, statisContent2, true, true, false);
                        IStatisAPI.ReportResult reportResult3 = this.val$resultReceiver;
                        if (reportResult3 != null) {
                            reportResult3.onReportResult(reportStatisticContentInner);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            reportInstall(i2, (IStatisAPI.ReportResult) null);
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j2, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Long.valueOf(j2), str, str2, property}) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, str2, property == null ? null : property.copy(), j2) { // from class: com.yy.hiidostatis.defs.StatisAPIOld.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ StatisAPIOld this$0;
                public final /* synthetic */ String val$eid;
                public final /* synthetic */ String val$label;
                public final /* synthetic */ Property val$pro;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, r9, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$eid = str;
                    this.val$label = str2;
                    this.val$pro = r9;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Util.empty(this.val$eid)) {
                            L.debug(this, "eid is not allow null.", new Object[0]);
                            return;
                        }
                        if (this.val$eid.getBytes().length > 256) {
                            String str3 = this.val$eid;
                            L.debug(this, "eid[%s] bytes[%d] must under %d bytes.", str3, Integer.valueOf(str3.getBytes().length), 256);
                        }
                        if (!Util.empty(this.val$label) && this.val$label.getBytes().length > 256) {
                            String str4 = this.val$label;
                            L.debug(this, "label[%s] bytes[%d] must under %d bytes.", str4, Integer.valueOf(str4.getBytes().length), 256);
                        }
                        EventInfo eventInfo = new EventInfo();
                        EventElementInfo eventElementInfo = new EventElementInfo(this.val$eid, 1);
                        eventElementInfo.addParam(this.val$label);
                        eventElementInfo.setProperty(this.val$pro);
                        eventInfo.addElem(eventElementInfo);
                        this.this$0.reportEvent(this.val$uid, eventInfo.getResult());
                    }
                }
            });
        }
    }
}
