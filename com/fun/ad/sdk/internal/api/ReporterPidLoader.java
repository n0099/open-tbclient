package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class ReporterPidLoader<A> extends BasePidLoader<A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AdReporter<A> mReporter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReporterPidLoader(FunAdType funAdType, Ssp.Pid pid) {
        this(funAdType, pid, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReporterPidLoader(FunAdType funAdType, Ssp.Pid pid, boolean z) {
        this(funAdType, pid, z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReporterPidLoader(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2) {
        this(funAdType, pid, z, z2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReporterPidLoader(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2, boolean z3) {
        super(funAdType, pid, z, z2, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mReporter = createAdReporter();
    }

    public static Activity checkOrLoadErr(ReporterPidLoader<?> reporterPidLoader, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, reporterPidLoader, context)) == null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            reporterPidLoader.onError("NoA");
            return null;
        }
        return (Activity) invokeLL.objValue;
    }

    public final String a(Map<String, String> map) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) ? (map == null || (str = map.get("tid")) == null) ? "" : str : (String) invokeL.objValue;
    }

    public AdReporter<A> createAdReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Ssp.Pid pid = this.mPid;
            return new AdReporter<>(pid.pid, pid.type, pid.ssp.type);
        }
        return (AdReporter) invokeV.objValue;
    }

    public Object getErrInfo(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str)) == null) ? Integer.valueOf(i) : invokeIL.objValue;
    }

    public void onAdClicked(A a, boolean z, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{a, Boolean.valueOf(z), map}) == null) {
            super.onAdClicked(a, map);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnClicked(a, z, getLid(session), getShowMeta(a, session), Flavors.CALL_BACK_AWARE.needRipper() ? this.mAdRipper.getRippedAd(a, false) : null, a(map));
        }
    }

    public void onAdClicked(A a, boolean z, String... strArr) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{a, Boolean.valueOf(z), strArr}) == null) {
            if (strArr == null || strArr.length == 0) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                hashMap.put("tid", strArr[0]);
            }
            onAdClicked((ReporterPidLoader<A>) a, z, (Map<String, String>) hashMap);
        }
    }

    public void onAdClose(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, a) == null) {
            onAdClose((ReporterPidLoader<A>) a, (Map<String, String>) new HashMap());
        }
    }

    public void onAdClose(A a, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, a, str) == null) {
            super.onAdClose((ReporterPidLoader<A>) a, (Map<String, String>) null);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnClosed(a, getLid(session), getShowMeta(a, session), str);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onAdClose(A a, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, a, map) == null) {
            super.onAdClose((ReporterPidLoader<A>) a, map);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnClosed(a, getLid(session), getShowMeta(a, session));
        }
    }

    public void onAdClose(A a, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a, map, str) == null) {
            super.onAdClose((ReporterPidLoader<A>) a, map);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnClosed(a, getLid(session), getShowMeta(a, session), str);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onAdError(A a, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, a, i, str) == null) {
            super.onAdError(a, i, str);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowFailed(a, Integer.valueOf(i), getLid(session), getShowMeta(a, session));
        }
    }

    public void onAdError(A a, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048586, this, a, i, str, str2) == null) {
            super.onAdError(a, i, str);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowFailed(a, Integer.valueOf(i), getLid(session), getShowMeta(a, session), str2);
        }
    }

    public void onAdError(A a, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, a, str) == null) {
            super.onAdError(a, 0, str);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowFailed(a, str, getLid(session), getShowMeta(a, session));
        }
    }

    public void onAdShow(A a, boolean z, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{a, Boolean.valueOf(z), map}) == null) {
            super.onAdShow(a, map);
            PidLoaderSession<A> session = getSession(a);
            SidSessionMeta showMeta = getShowMeta(a, session);
            long lid = getLid(session);
            this.mReporter.recordShowSucceed(a, z, lid, showMeta, Flavors.CALL_BACK_AWARE.needRipper() ? this.mAdRipper.getRippedAd(a, false) : null, a(map));
            this.mAdRipper.report(a, showMeta.sid, lid);
        }
    }

    public void onAdShow(A a, boolean z, String... strArr) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{a, Boolean.valueOf(z), strArr}) == null) {
            if (strArr == null || strArr.length == 0) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                hashMap.put("tid", strArr[0]);
            }
            onAdShow((ReporterPidLoader<A>) a, z, (Map<String, String>) hashMap);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            onError((ReporterPidLoader<A>) null, i, str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public void onError(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048591, this, i, str, str2) == null) {
            super.onError(i, str);
            PidLoaderSession<A> lastSession = getLastSession();
            SidSessionMeta loadMeta = getLoadMeta(lastSession);
            AdReporter<A> adReporter = this.mReporter;
            String str3 = str;
            if (i != -975312468) {
                str3 = getErrInfo(i, str);
            }
            adReporter.recordLoadFailed((AdReporter<A>) null, str3, getLid(lastSession), loadMeta, str2);
        }
    }

    public void onError(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            onError(null, i, str, z);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onError(A a, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048593, this, a, i, str) == null) {
            onError(a, i, str, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public void onError(A a, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{a, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            super.onError(i, str);
            PidLoaderSession<A> lastSession = getLastSession();
            SidSessionMeta loadMeta = getLoadMeta(lastSession);
            AdReporter<A> adReporter = this.mReporter;
            if (z) {
                adReporter.recordLoadFailed((AdReporter<A>) a, getErrInfo(i, str), str, getLid(lastSession), loadMeta);
                return;
            }
            String str2 = str;
            if (i != -975312468) {
                str2 = getErrInfo(i, str);
            }
            adReporter.recordLoadFailed(a, str2, getLid(lastSession), loadMeta);
        }
    }

    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            onError(-975312468, str, str2);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onLoadStart(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, funAdSlot) == null) {
            super.onLoadStart(funAdSlot);
            PidLoaderSession<A> lastSession = getLastSession();
            this.mReporter.recordLoadStart(getLid(lastSession), getLoadMeta(lastSession));
        }
    }

    public void onLoadStart(FunAdSlot funAdSlot, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, funAdSlot, str) == null) {
            super.onLoadStart(funAdSlot);
            PidLoaderSession<A> lastSession = getLastSession();
            this.mReporter.recordLoadStart(getLid(lastSession), getLoadMeta(lastSession), str);
        }
    }

    public void onLoaded(A a, PidLoaderSession<A> pidLoaderSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, a, pidLoaderSession) == null) {
            onLoaded(a, pidLoaderSession, "");
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onLoaded(A a, PidLoaderSession<A> pidLoaderSession, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, a, pidLoaderSession, strArr) == null) {
            super.onLoaded(a, pidLoaderSession, new String[0]);
            SidSessionMeta loadMeta = getLoadMeta(pidLoaderSession);
            if (strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) {
                this.mReporter.recordLoadSucceed(a, getLid(pidLoaderSession), loadMeta);
            } else {
                this.mReporter.recordLoadSucceed(a, getLid(pidLoaderSession), loadMeta, strArr[0]);
            }
        }
    }

    public void onPaidEvent(A a, double d, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{a, Double.valueOf(d), str, Integer.valueOf(i)}) == null) {
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnPaidEvent(a, getLid(session), getShowMeta(a, session), d, str, i);
        }
    }

    public void onRewardedVideo(A a, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, a, map) == null) {
            onRewardedVideo(a, true, 0, map);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onRewardedVideo(A a, boolean z, int i, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{a, Boolean.valueOf(z), Integer.valueOf(i), map}) == null) {
            super.onRewardedVideo(a, z, i, map);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordReward(a, z, getLid(session), getShowMeta(a, session), i, Flavors.CALL_BACK_AWARE.needRipper() ? this.mAdRipper.getRippedAd(a, false) : null, a(map));
        }
    }

    public void onRewardedVideo(A a, boolean z, String... strArr) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{a, Boolean.valueOf(z), strArr}) == null) {
            if (strArr == null || strArr.length == 0) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                hashMap.put("tid", strArr[0]);
            }
            onRewardedVideo(a, z, 0, hashMap);
        }
    }

    public void onRewardedVideo(A a, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, a, strArr) == null) {
            onRewardedVideo(a, true, strArr);
        }
    }

    public void onShowStart(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, a) == null) {
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowStart(a, getLid(session), getShowMeta(a, session));
        }
    }

    public void onShowStart(A a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, a, z) == null) {
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowStart(a, z, getLid(session), getShowMeta(a, session));
        }
    }
}
