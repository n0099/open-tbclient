package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
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
import com.fun.ad.sdk.internal.api.utils.AdReporter;
/* loaded from: classes4.dex */
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

    public AdReporter<A> createAdReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Ssp.Pid pid = this.mPid;
            return new AdReporter<>(pid.pid, pid.type, pid.ssp.type);
        }
        return (AdReporter) invokeV.objValue;
    }

    public void onAdClicked(A a, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{a, Boolean.valueOf(z), strArr}) == null) {
            super.onAdClicked(a, strArr);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnClicked(a, z, getLid(session), getShowMeta(a, session), strArr);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onAdClose(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a) == null) {
            super.onAdClose(a);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnClosed(a, getLid(session), getShowMeta(a, session));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onAdError(A a, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, a, i, str) == null) {
            super.onAdError(a, i, str);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowFailed(a, Integer.valueOf(i), getLid(session), getShowMeta(a, session));
        }
    }

    public void onAdError(A a, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, a, str) == null) {
            super.onAdError(a, 0, str);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowFailed(a, str, getLid(session), getShowMeta(a, session));
        }
    }

    public void onAdShow(A a, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{a, Boolean.valueOf(z), strArr}) == null) {
            super.onAdShow(a, strArr);
            PidLoaderSession<A> session = getSession(a);
            SidSessionMeta showMeta = getShowMeta(a, session);
            long lid = getLid(session);
            this.mReporter.recordShowSucceed(a, z, lid, showMeta, strArr);
            this.mAdRipper.report(a, showMeta.sid, lid);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) {
            super.onError(i, str);
            PidLoaderSession<A> lastSession = getLastSession();
            SidSessionMeta loadMeta = getLoadMeta(lastSession);
            AdReporter<A> adReporter = this.mReporter;
            Object obj = str;
            if (i != -975312468) {
                obj = Integer.valueOf(i);
            }
            adReporter.recordLoadFailed(obj, getLid(lastSession), loadMeta);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onLoadStart(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, funAdSlot) == null) {
            super.onLoadStart(funAdSlot);
            PidLoaderSession<A> lastSession = getLastSession();
            this.mReporter.recordLoadStart(getLid(lastSession), getLoadMeta(lastSession));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onLoaded(A a, PidLoaderSession<A> pidLoaderSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a, pidLoaderSession) == null) {
            super.onLoaded(a, pidLoaderSession);
            this.mReporter.recordLoadSucceed(a, getLid(pidLoaderSession), getLoadMeta(pidLoaderSession));
        }
    }

    public void onPaidEvent(A a, double d, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{a, Double.valueOf(d), str}) == null) {
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordOnPaidEvent(a, getLid(session), getShowMeta(a, session), d, str);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void onRewardedVideo(A a, boolean z, int i, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{a, Boolean.valueOf(z), Integer.valueOf(i), strArr}) == null) {
            super.onRewardedVideo(a, z, i, strArr);
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordReward(a, z, getLid(session), getShowMeta(a, session), i, strArr);
        }
    }

    public void onRewardedVideo(A a, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{a, Boolean.valueOf(z), strArr}) == null) {
            onRewardedVideo(a, z, 0, strArr);
        }
    }

    public void onRewardedVideo(A a, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, a, strArr) == null) {
            onRewardedVideo(a, true, strArr);
        }
    }

    public void onShowStart(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, a) == null) {
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowStart(a, getLid(session), getShowMeta(a, session));
        }
    }

    public void onShowStart(A a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, a, z) == null) {
            PidLoaderSession<A> session = getSession(a);
            this.mReporter.recordShowStart(a, z, getLid(session), getShowMeta(a, session));
        }
    }
}
