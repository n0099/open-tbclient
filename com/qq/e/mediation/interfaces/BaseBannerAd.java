package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
/* loaded from: classes8.dex */
public abstract class BaseBannerAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void destroy();

    public abstract View getAdView();

    public abstract int getECPM();

    public abstract void loadAD();

    public abstract void setAdListener(UnifiedBannerADListener unifiedBannerADListener);

    public abstract void setAdSize(int i2, int i3);
}
