package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import android.os.Build;
import androidx.annotation.Keep;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
@Keep
/* loaded from: classes6.dex */
public class Common {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @c(a = "app_version")
    public String appVersion;
    @c(a = "device_id")
    public String deviceId;
    @c(a = "device_model")
    public String deviceModel;
    @c(a = IAdRequestParam.OS)
    public int os;
    @c(a = "region")
    public String region;
    @c(a = ZeusInitConfigUtils.PREF_KEY_SDK_VERSION)
    public String sdkVersion;

    public Common() {
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
        this.sdkVersion = "2.0.3-rc.9-pangle";
        this.deviceModel = Build.MODEL;
        this.os = 0;
    }
}
