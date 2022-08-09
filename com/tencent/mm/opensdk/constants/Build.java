package com.tencent.mm.opensdk.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class Build {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECK_TOKEN_SDK_INT = 620824064;
    public static final int CHOOSE_INVOICE_TILE_SUPPORT_SDK_INT = 620822528;
    public static final int EMOJI_SUPPORTED_SDK_INT = 553844737;
    public static final int FAVORITE_SUPPPORTED_SDK_INT = 570425345;
    public static final int INVOICE_AUTH_INSERT_SDK_INT = 620823552;
    public static final int LAUNCH_MINIPROGRAM_SUPPORTED_SDK_INT = 620757000;
    public static final int LAUNCH_MINIPROGRAM_WITH_TOKEN_SUPPORTED_SDK_INT = 621086464;
    public static final int MESSAGE_ACTION_SUPPPORTED_SDK_INT = 570490883;
    public static final int MINIPROGRAM_SUPPORTED_SDK_INT = 620756993;
    public static final int MIN_SDK_INT = 553713665;
    public static final int MUSIC_DATA_URL_SUPPORTED_SDK_INT = 553910273;
    public static final int NON_TAX_PAY_SDK_INT = 620823552;
    public static final int OFFLINE_PAY_SDK_INT = 620823808;
    public static final int OPENID_SUPPORTED_SDK_INT = 570425345;
    public static final int OPEN_BUSINESS_VIEW_SDK_INT = 620889344;
    public static final int OPEN_BUSINESS_WEBVIEW_SDK_INT = 620824064;
    public static final int PAY_INSURANCE_SDK_INT = 620823552;
    public static final int PAY_SUPPORTED_SDK_INT = 570425345;
    public static final int SCAN_QRCODE_AUTH_SUPPORTED_SDK_INT = 587268097;
    public static final int SDK_INT = 637928448;
    public static final String SDK_VERSION_NAME = "android 6.6.4";
    public static final int SEND_25M_IMAGE_SDK_INT = 620889088;
    public static final int SEND_AUTH_SCOPE_SNSAPI_WXAAPP_INFO_SUPPORTED_SDK_INT = 621086464;
    public static final int SEND_BUSINESS_CARD_SDK_INT = 620889344;
    public static final int SEND_TO_SPECIFIED_CONTACT_SDK_INT = 620824064;
    public static final int SUBSCRIBE_MESSAGE_SUPPORTED_SDK_INT = 620756998;
    public static final int SUBSCRIBE_MINI_PROGRAM_MSG_SUPPORTED_SDK_INT = 620823808;
    public static final int SUPPORTED_JOINT_PAY = 621021440;
    public static final int SUPPORTED_PRELOAD_MINI_PROGRAM = 621085952;
    public static final int SUPPORTED_SEND_WX_WEWORK_OBJECT = 620954624;
    public static final int TIMELINE_SUPPORTED_SDK_INT = 553779201;
    public static final int VIDEO_FILE_SUPPORTED_SDK_INT = 620756996;
    public static final int WEISHI_MINIPROGRAM_SUPPORTED_SDK_INT = 620953856;
    public transient /* synthetic */ FieldHolder $fh;

    public Build() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException(Build.class.getSimpleName() + " should not be instantiated");
    }

    public static int getMajorVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return 6;
        }
        return invokeV.intValue;
    }

    public static int getMinorVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return 6;
        }
        return invokeV.intValue;
    }
}
