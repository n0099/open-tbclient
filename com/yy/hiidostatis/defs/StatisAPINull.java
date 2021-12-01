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
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.message.Packer;
import java.util.Date;
import java.util.Map;
/* loaded from: classes3.dex */
public class StatisAPINull implements IStatisApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StatisAPINull() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public MetricsWorker addMetricsWorker(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2)) == null) {
            return null;
        }
        return (MetricsWorker) invokeLJ.objValue;
    }

    @Override // com.yy.hiidostatis.defs.interf.IStatisAPI
    public IStatisAPI create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (IStatisAPI) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void generateSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public HiidoSdkAdditionDelegate getAdditionParamsDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (HiidoSdkAdditionDelegate) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public Long getLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (Long) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public StatisOption getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (StatisOption) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public String getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void init(Context context, StatisOption statisOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, statisOption) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void removeActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, actListener) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAction(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportAppList(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i2, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(int i2, String str, String str2, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i2, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCount(String str, int i2, String str2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j2, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j2, String str, double d2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCountEvent(long j2, String str, double d2, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2, property}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048599, this, j2, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrash(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048600, this, j2, th) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportCrashInner(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048601, this, j2, th) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportCustomContent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportDevice(long j2, StatisContent statisContent, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j2), statisContent, reportResult}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048604, this, j2)) == null) {
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportDevice(long j2, StatisContent statisContent) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048605, this, j2, statisContent)) == null) {
            return false;
        }
        return invokeJL.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j2) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDo5(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j2) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportDoShort(long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048608, this, j2, map) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportError(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048610, this, j2, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFailure(long j2, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, str5}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportFeedback(long j2, String str, String str2, String str3, String str4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, reportResult}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i2), str5}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048614, this, i2, reportResult) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportInstall(int i2, Packer.OnSavedListener onSavedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048615, this, i2, onSavedListener) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public boolean reportInstall(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportLanuch(long j2, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j2), str, statisContent}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLocation(long j2, double d2, double d3, double d4, IStatisAPI.ReportResult reportResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), reportResult}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportLogin(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j2) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPage(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048620, this, j2, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportPageState(long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportPushToken(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048622, this, j2, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportRecentAppList(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048624, this, str, str2, str3, map) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(int i2, String str, long j2, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), str2, map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportReturnCode(String str, int i2, String str2, long j2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), str3, map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportRun(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j2) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void reportSdkList(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048628, this, j2, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{str, Integer.valueOf(i2), str2, shareType, str3, str4, str5}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(int i2, String str, String str2, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2), map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSrcData(String str, int i2, String str2, String str3, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), map}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{str, statisContent, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048635, this, context, str, statisContent) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportSuccess(long j2, String str, String str2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3), str3}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048638, this, j2, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportTimesEvent(long j2, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Long.valueOf(j2), str, str2, property}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void reportUrlScheme(String str, String str2, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4}) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAbroad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, hiidoSdkAdditionDelegate) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi, com.yy.hiidostatis.defs.interf.IStatisAPI
    public void setSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
        }
    }

    @Override // com.yy.hiidostatis.defs.IStatisApi
    public void setTestServer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
        }
    }
}
