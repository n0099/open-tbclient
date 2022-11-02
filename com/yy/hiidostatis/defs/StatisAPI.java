package com.yy.hiidostatis.defs;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.MetricsWorker;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.config.ABNameDefine;
import com.yy.hiidostatis.config.ABTestHandler;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.MessageConfigFactory;
import java.util.Date;
import java.util.Map;
/* loaded from: classes8.dex */
public class StatisAPI implements IStatisAPI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IStatisApi sApi;

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (IStatisAPI) invokeV.objValue;
    }

    public StatisAPI() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sApi = new StatisAPINull();
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.sApi.exit();
        }
    }

    public void generateSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.sApi.generateSession();
        }
    }

    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.sApi.getAdditionParamsDelegate();
        }
        return (HiidoSdkAdditionDelegate) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.sApi.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.sApi.getLaunchTime();
        }
        return (Long) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.sApi.getOption();
        }
        return (StatisOption) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.sApi.getSession();
        }
        return (String) invokeV.objValue;
    }

    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
            this.sApi.addActAdditionListener(actListener);
        }
    }

    public void removeActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, actListener) == null) {
            this.sApi.addActAdditionListener(actListener);
        }
    }

    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.sApi.reportAppsflyer(str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048604, this, j)) == null) {
            return this.sApi.reportDevice(j);
        }
        return invokeJ.booleanValue;
    }

    public void reportDo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            this.sApi.reportDo(j);
        }
    }

    public void reportDo5(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            this.sApi.reportDo5(j);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
            return this.sApi.reportInstall(i);
        }
        return invokeI.booleanValue;
    }

    public void reportLogin(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            this.sApi.reportLogin(j);
        }
    }

    public void reportRun(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            this.sApi.reportRun(j);
        }
    }

    public void setAbroad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.sApi.setAbroad(z);
        }
    }

    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, hiidoSdkAdditionDelegate) == null) {
            this.sApi.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
        }
    }

    public void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.sApi.setBusinessType(i);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.sApi.setSession(str);
        }
    }

    public void setTestServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.sApi.setTestServer(str);
        }
    }

    public MetricsWorker addMetricsWorker(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            return this.sApi.addMetricsWorker(str, j);
        }
        return (MetricsWorker) invokeLJ.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048599, this, j, str) == null) {
            this.sApi.reportCrash(j, str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048601, this, j, th) == null) {
            this.sApi.reportCrashInner(j, th);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j, StatisContent statisContent) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048605, this, j, statisContent)) == null) {
            return this.sApi.reportDevice(j, statisContent);
        }
        return invokeJL.booleanValue;
    }

    public void reportDoShort(long j, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048608, this, j, map) == null) {
            this.sApi.reportDoShort(j, map);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048610, this, j, str) == null) {
            this.sApi.reportEvent(j, str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048614, this, i, reportResult) == null) {
            this.sApi.reportInstall(i, reportResult);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048620, this, j, str) == null) {
            this.sApi.reportPage(j, str);
        }
    }

    public void reportPushToken(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048622, this, j, str) == null) {
            this.sApi.reportPushToken(j, str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048628, this, j, str) == null) {
            this.sApi.reportSdkList(j, str);
        }
    }

    public void reportTimesEvent(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048638, this, j, str) == null) {
            this.sApi.reportTimesEvent(j, str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, statisOption) == null) {
            ABTestHandler.initInstance(context);
            if (ABTestHandler.getAbBoolean(ABNameDefine.NEW_PACKER_MODULE)) {
                MessageConfig generate = MessageConfigFactory.generate(context, statisOption.getAppkey());
                generate.setFrom(statisOption.getFrom());
                generate.setAppId(statisOption.getAppId());
                generate.setVer(statisOption.getVer());
                StatisAPINew statisAPINew = new StatisAPINew(generate);
                statisAPINew.onInitSuccess();
                this.sApi = statisAPINew;
                return;
            }
            StatisAPIOld statisAPIOld = new StatisAPIOld();
            this.sApi = statisAPIOld;
            statisAPIOld.init(context, statisOption);
        }
    }

    public void reportAction(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
            this.sApi.reportAction(j, str, str2, str3);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
            this.sApi.reportAppList(j, str, str2, str3);
        }
    }

    public void reportError(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
            this.sApi.reportError(j, str, str2, str3);
        }
    }

    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048624, this, str, str2, str3, map) == null) {
            this.sApi.reportReg(str, str2, str3, map);
        }
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.sApi.reportStatisticContent(str, statisContent, z, z2);
        }
    }

    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.sApi.reportStatisticContentTemporary(str, statisContent, z, z2);
        }
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) {
            this.sApi.reportStatisticContentWithNoComm(context, str, statisContent, z);
        }
    }

    public void reportTimesEvent(long j, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Long.valueOf(j), str, str2, property}) == null) {
            this.sApi.reportTimesEvent(j, str, str2, property);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            this.sApi.reportAppList(j, str, str2);
        }
    }

    public void reportCountEvent(long j, String str, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d)}) == null) {
            this.sApi.reportCountEvent(j, str, d);
        }
    }

    public void reportCustomContent(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            this.sApi.reportCustomContent(j, str, str2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j), statisContent, reportResult}) == null) {
            this.sApi.reportDevice(j, statisContent, reportResult);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j), str, statisContent}) == null) {
            this.sApi.reportLanuch(j, str, statisContent);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Long.valueOf(j), str, Long.valueOf(j2)}) == null) {
            this.sApi.reportPageState(j, str, j2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            this.sApi.reportRecentAppList(j, str, str2);
        }
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048635, this, context, str, statisContent) == null) {
            this.sApi.reportStatisticContentWithNoComm(context, str, statisContent);
        }
    }

    public void reportTimesEvent(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            this.sApi.reportTimesEvent(j, str, str2);
        }
    }

    public void reportCount(int i, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j)}) == null) {
            this.sApi.reportCount(i, str, str2, j);
        }
    }

    public void reportCountEvent(long j, String str, double d, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d), str2}) == null) {
            this.sApi.reportCountEvent(j, str, d, str2);
        }
    }

    public void reportCount(int i, String str, String str2, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.sApi.reportCount(i, str, str2, j, i2);
        }
    }

    public void reportCountEvent(long j, String str, double d, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), str, Double.valueOf(d), str2, property}) == null) {
            this.sApi.reportCountEvent(j, str, d, str2, property);
        }
    }

    public void reportLocation(long j, double d, double d2, double d3, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), reportResult}) == null) {
            this.sApi.reportLocation(j, d, d2, d3, reportResult);
        }
    }

    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), str2, map}) == null) {
            this.sApi.reportReturnCode(i, str, j, str2, map);
        }
    }

    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i), str, str2, Long.valueOf(j), map}) == null) {
            this.sApi.reportSrcData(i, str, str2, j, map);
        }
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.sApi.reportStatisticContent(str, statisContent, z, z2, z3);
        }
    }

    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2), str3}) == null) {
            this.sApi.reportSuccess(j, str, str2, j2, str3);
        }
    }

    public void reportUrlScheme(String str, String str2, int i, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4}) == null) {
            this.sApi.reportUrlScheme(str, str2, i, str3, str4);
        }
    }

    public void reportCount(String str, int i, String str2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j)}) == null) {
            this.sApi.reportCount(str, i, str2, str3, j);
        }
    }

    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.sApi.reportCount(str, i, str2, str3, j, i2);
        }
    }

    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j), str, str2, str3, str4, str5}) == null) {
            this.sApi.reportFailure(j, str, str2, str3, str4, str5);
        }
    }

    public void reportFeedback(long j, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j), str, str2, str3, str4, reportResult}) == null) {
            this.sApi.reportFeedback(j, str, str2, str3, str4, reportResult);
        }
    }

    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j), str3, map}) == null) {
            this.sApi.reportReturnCode(str, i, str2, j, str3, map);
        }
    }

    public void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), map}) == null) {
            this.sApi.reportSrcData(str, i, str2, str3, j, map);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048600, this, j, th) == null) {
            this.sApi.reportCrash(j, th);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i, Packer.OnSavedListener onSavedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048615, this, i, onSavedListener) == null) {
            this.sApi.reportInstall(i, onSavedListener);
        }
    }

    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i), str5}) == null) {
            this.sApi.reportIM(str, str2, str3, date, date2, str4, i, str5);
        }
    }

    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{str, Integer.valueOf(i), str2, shareType, str3, str4, str5}) == null) {
            this.sApi.reportShare(str, i, str2, shareType, str3, str4, str5);
        }
    }
}
