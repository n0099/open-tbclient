package com.yy.hiidostatis.defs;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public class StatisAPI implements IStatisAPI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IStatisApi sApi;

    public StatisAPI() {
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
        this.sApi = new StatisAPINull();
    }

    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
            this.sApi.addActAdditionListener(actListener);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (IStatisAPI) invokeV.objValue;
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.sApi.exit();
        }
    }

    public void generateSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.sApi.generateSession();
        }
    }

    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sApi.getAdditionParamsDelegate() : (HiidoSdkAdditionDelegate) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sApi.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sApi.getLaunchTime() : (Long) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sApi.getOption() : (StatisOption) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.sApi.getSession() : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, statisOption) == null) {
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

    public void removeActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, actListener) == null) {
            this.sApi.addActAdditionListener(actListener);
        }
    }

    public void reportAction(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
            this.sApi.reportAction(j2, str, str2, str3);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.sApi.reportAppList(j2, str, str2);
        }
    }

    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.sApi.reportAppsflyer(str);
        }
    }

    public void reportCountEvent(long j2, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2)}) == null) {
            this.sApi.reportCountEvent(j2, str, d2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048594, this, j2, str) == null) {
            this.sApi.reportCrash(j2, str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048596, this, j2, th) == null) {
            this.sApi.reportCrashInner(j2, th);
        }
    }

    public void reportCustomContent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.sApi.reportCustomContent(j2, str, str2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j2, StatisContent statisContent) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048600, this, j2, statisContent)) == null) ? this.sApi.reportDevice(j2, statisContent) : invokeJL.booleanValue;
    }

    public void reportDo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            this.sApi.reportDo(j2);
        }
    }

    public void reportDo5(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
            this.sApi.reportDo5(j2);
        }
    }

    public void reportDoShort(long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048603, this, j2, map) == null) {
            this.sApi.reportDoShort(j2, map);
        }
    }

    public void reportError(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
            this.sApi.reportError(j2, str, str2, str3);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048605, this, j2, str) == null) {
            this.sApi.reportEvent(j2, str);
        }
    }

    public void reportFailure(long j2, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, str5}) == null) {
            this.sApi.reportFailure(j2, str, str2, str3, str4, str5);
        }
    }

    public void reportFeedback(long j2, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, reportResult}) == null) {
            this.sApi.reportFeedback(j2, str, str2, str3, str4, reportResult);
        }
    }

    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i2), str5}) == null) {
            this.sApi.reportIM(str, str2, str3, date, date2, str4, i2, str5);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i2, reportResult) == null) {
            this.sApi.reportInstall(i2, reportResult);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j2, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j2), str, statisContent}) == null) {
            this.sApi.reportLanuch(j2, str, statisContent);
        }
    }

    public void reportLocation(long j2, double d2, double d3, double d4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), reportResult}) == null) {
            this.sApi.reportLocation(j2, d2, d3, d4, reportResult);
        }
    }

    public void reportLogin(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048614, this, j2) == null) {
            this.sApi.reportLogin(j2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048615, this, j2, str) == null) {
            this.sApi.reportPage(j2, str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3)}) == null) {
            this.sApi.reportPageState(j2, str, j3);
        }
    }

    public void reportPushToken(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048617, this, j2, str) == null) {
            this.sApi.reportPushToken(j2, str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.sApi.reportRecentAppList(j2, str, str2);
        }
    }

    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048619, this, str, str2, str3, map) == null) {
            this.sApi.reportReg(str, str2, str3, map);
        }
    }

    public void reportRun(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) {
            this.sApi.reportRun(j2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048621, this, j2, str) == null) {
            this.sApi.reportSdkList(j2, str);
        }
    }

    public void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{str, Integer.valueOf(i2), str2, shareType, str3, str4, str5}) == null) {
            this.sApi.reportShare(str, i2, str2, shareType, str3, str4, str5);
        }
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.sApi.reportStatisticContent(str, statisContent, z, z2);
        }
    }

    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.sApi.reportStatisticContentTemporary(str, statisContent, z, z2);
        }
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048626, this, context, str, statisContent) == null) {
            this.sApi.reportStatisticContentWithNoComm(context, str, statisContent);
        }
    }

    public void reportSuccess(long j2, String str, String str2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3), str3}) == null) {
            this.sApi.reportSuccess(j2, str, str2, j3, str3);
        }
    }

    public void reportTimesEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048629, this, j2, str) == null) {
            this.sApi.reportTimesEvent(j2, str);
        }
    }

    public void reportUrlScheme(String str, String str2, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4}) == null) {
            this.sApi.reportUrlScheme(str, str2, i2, str3, str4);
        }
    }

    public void setAbroad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.sApi.setAbroad(z);
        }
    }

    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, hiidoSdkAdditionDelegate) == null) {
            this.sApi.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
        }
    }

    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.sApi.setBusinessType(i2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.sApi.setSession(str);
        }
    }

    public void setTestServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.sApi.setTestServer(str);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
            this.sApi.reportAppList(j2, str, str2, str3);
        }
    }

    public void reportCountEvent(long j2, String str, double d2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2}) == null) {
            this.sApi.reportCountEvent(j2, str, d2, str2);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048595, this, j2, th) == null) {
            this.sApi.reportCrash(j2, th);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) ? this.sApi.reportDevice(j2) : invokeJ.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, Packer.OnSavedListener onSavedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i2, onSavedListener) == null) {
            this.sApi.reportInstall(i2, onSavedListener);
        }
    }

    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.sApi.reportStatisticContent(str, statisContent, z, z2, z3);
        }
    }

    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) {
            this.sApi.reportStatisticContentWithNoComm(context, str, statisContent, z);
        }
    }

    public void reportTimesEvent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            this.sApi.reportTimesEvent(j2, str, str2);
        }
    }

    public void reportCountEvent(long j2, String str, double d2, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2, property}) == null) {
            this.sApi.reportCountEvent(j2, str, d2, str2, property);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j2, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j2), statisContent, reportResult}) == null) {
            this.sApi.reportDevice(j2, statisContent, reportResult);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) ? this.sApi.reportInstall(i2) : invokeI.booleanValue;
    }

    public void reportTimesEvent(long j2, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Long.valueOf(j2), str, str2, property}) == null) {
            this.sApi.reportTimesEvent(j2, str, str2, property);
        }
    }
}
