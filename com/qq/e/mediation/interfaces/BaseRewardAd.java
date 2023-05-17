package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
/* loaded from: classes9.dex */
public abstract class BaseRewardAd {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_PRIORITY = -1;
    public static final int EVENT_TYPE_ON_AD_CLICK = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
    public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
    public static final int EVENT_TYPE_ON_AD_LOADED = 1;
    public static final int EVENT_TYPE_ON_AD_SHOW = 3;
    public static final int EVENT_TYPE_ON_ERROR = 9;
    public static final int EVENT_TYPE_ON_REWARD = 5;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
    public transient /* synthetic */ FieldHolder $fh;
    public LoadAdParams a;

    public BaseRewardAd(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public int getAdapterPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract long getExpireTimestamp();

    public LoadAdParams getLoadAdParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (LoadAdParams) invokeV.objValue;
    }

    public int getRewardAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract int getVideoDuration();

    public abstract boolean hasShown();

    public abstract void loadAD();

    public abstract void setAdListener(ADListener aDListener);

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, loadAdParams) == null) {
            this.a = loadAdParams;
        }
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVolumeOn(boolean z);

    public abstract void showAD();

    public void showAD(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            showAD();
        }
    }
}
