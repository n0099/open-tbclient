package com.qq.e.comm.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LANDSCAPE = "l";
    public static final int NONE_ECPM = -1;
    public static final String PORTRAIT = "p";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class KEYS {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String AD_INFO = "adinfo";
        public static final String AD_NEGATIVE_FEEDBACK_INFO = "negative_feedback_url";
        public static final String AD_TAGS = "ad_tags";
        public static final String BIZ = "biz";
        public static final String BannerAutoShow = "bannerAutoShow";
        public static final String BannerShowCloseBtn = "showCloseBtn";
        public static final String Banner_RF = "rf";
        public static final String EXPOSED_CLICK_URL_KEY = "clickUrl";
        public static final String FLOW_CONTROL = "flow_control";
        public static final String FORCE_EXPOSURE = "force_exp";
        public static final String GDT_SDK_CHANNEL = "getSdkChannel";
        public static final String GDT_SDK_EX1 = "getSdkEX1";
        public static final String GDT_SDK_EX2 = "getSdkEX2";
        public static final String GDT_SDK_IDENTITY = "gdtSdkIdentity";
        public static final String INNER_BROWSER_SCHEME = "innerBrowserScheme";
        public static final String MINI_CARD_LIST = "miniCardList";
        public static final String MINI_CARD_REF = "miniCardRef";
        public static final String MINI_CARD_SUPPORT = "miniCardSupport";
        public static final String PLACEMENTS = "ps";
        public static final String PLCINFO = "plc";
        public static final String PLUGIN_VERSION = "plugin_version";
        public static final String RET = "ret";
        public static final String RequireWindowFocus = "require_window_focus";
        public static final String SDKServerClickReportSamplingRate = "clkad_report_sampling_rate";
        public static final String SDKServerExpReportSamplingRate = "expad_report_sampling_rate";
        public static final String SDKServerGetADReportSamplingRate = "getad_report_sampling_rate";
        public static final String SHOW_LOGO = "show_logo";
        public static final String SPLASH_EXPOSURE_TIME = "spl_exptime";
        public static final String SPLASH_LOADTIMEOUT = "spl_ltime";
        public static final String SPLASH_LOADTIMEOUT_MIN = "spl_ltime_min";
        public static final String SPLASH_MAX_REQUEST_NUM = "spl_maxrn";
        public static final String SPLASH_NETWORK_PERMISION = "spl_conn";
        public static final int THROUGH_MAX_TIPS = 512;
        public transient /* synthetic */ FieldHolder $fh;

        public KEYS() {
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
    }

    /* loaded from: classes8.dex */
    public static final class PLUGIN {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ASSET_PLUGIN_VERSION = 1292;
        public transient /* synthetic */ FieldHolder $fh;

        public PLUGIN() {
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
    }

    public Constants() {
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
}
