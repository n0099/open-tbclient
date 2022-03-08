package com.qq.e.comm.managers.setting;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
/* loaded from: classes8.dex */
public class c extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            a(Constants.KEYS.SDKServerGetADReportSamplingRate, 1);
            a(Constants.KEYS.SDKServerExpReportSamplingRate, 1);
            a(Constants.KEYS.SDKServerClickReportSamplingRate, 100);
            a(Constants.KEYS.RequireWindowFocus, 1);
            a(Constants.KEYS.SHOW_LOGO, 1);
            a(Constants.KEYS.INNER_BROWSER_SCHEME, "weixin,tel,openapp.jdmobile");
            a(Constants.KEYS.FLOW_CONTROL, 1);
            a(Constants.KEYS.GDT_SDK_IDENTITY, 1);
            a(Constants.KEYS.GDT_SDK_CHANNEL, 1);
            a(Constants.KEYS.GDT_SDK_EX1, "");
            a(Constants.KEYS.GDT_SDK_EX2, "");
            a(Constants.KEYS.Banner_RF, 30000);
            a(Constants.KEYS.SPLASH_LOADTIMEOUT, 3000);
            a(Constants.KEYS.SPLASH_EXPOSURE_TIME, 5000);
            a(Constants.KEYS.SPLASH_NETWORK_PERMISION, 26);
            a(Constants.KEYS.SPLASH_MAX_REQUEST_NUM, 100);
            a(Constants.KEYS.FORCE_EXPOSURE, 1);
        }
    }
}
