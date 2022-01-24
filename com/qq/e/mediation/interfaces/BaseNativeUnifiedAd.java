package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseNativeUnifiedAd {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CALLBACK_CLICK = 3;
    public static final int CALLBACK_IMPRESSION = 4;
    public static final int CALLBACK_LOADED = 1;
    public static final int CALLBACK_NO_AD = 2;
    public static final int DEFAULT_PRIORITY = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseNativeUnifiedAd(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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

    public abstract void loadData(int i2);

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setBrowserType(int i2);

    public abstract void setCategories(List<String> list);

    public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    public abstract void setECPMLevel(String str);

    public abstract void setMaxVideoDuration(int i2);

    public abstract void setMinVideoDuration(int i2);
}
