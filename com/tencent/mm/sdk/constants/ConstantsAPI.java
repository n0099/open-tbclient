package com.tencent.mm.sdk.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface ConstantsAPI {
    public static final String ACTION_HANDLE_APP_REGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
    public static final String ACTION_HANDLE_APP_UNREGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
    public static final String ACTION_REFRESH_WXAPP = "com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP";
    public static final String APP_PACKAGE = "_mmessage_appPackage";
    public static final String CHECK_SUM = "_mmessage_checksum";
    public static final int COMMAND_GETMESSAGE_FROM_WX = 3;
    public static final int COMMAND_LAUNCH_BY_WX = 6;
    public static final int COMMAND_PAY_BY_WX = 5;
    public static final int COMMAND_SENDAUTH = 1;
    public static final int COMMAND_SENDMESSAGE_TO_WX = 2;
    public static final int COMMAND_SHOWMESSAGE_FROM_WX = 4;
    public static final int COMMAND_UNKNOWN = 0;
    public static final String CONTENT = "_mmessage_content";
    public static final String SDK_VERSION = "_mmessage_sdkVersion";

    /* loaded from: classes8.dex */
    public static final class Token {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String WX_TOKEN_JUMP_ARG = "wx_jump_arg";
        public static final String WX_TOKEN_KEY = "wx_token_key";
        public static final String WX_TOKEN_PLATFORMID_KEY = "platformId";
        public static final String WX_TOKEN_PLATFORMID_VALUE = "wechat";
        public static final String WX_TOKEN_VALUE_MSG = "com.tencent.mm.openapi.token";
        public transient /* synthetic */ FieldHolder $fh;

        public Token() {
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
    public static final class WXApp {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String WXAPP_BROADCAST_PERMISSION = "com.tencent.mm.permission.MM_MESSAGE";
        public static final String WXAPP_MSG_ENTRY_CLASSNAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
        public static final String WXAPP_PACKAGE_NAME = "com.tencent.mm";
        public transient /* synthetic */ FieldHolder $fh;

        public WXApp() {
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
}
