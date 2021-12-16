package com.dxmpay.walletsdk.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "standard";
    public static final boolean IS_BUSINESS_VERSION = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.dxmpay.walletsdk.core";
    public static final int VERSION_CODE = -1;
    public static final String VERSION_NAME = "9.5.0.114";
    public static final boolean hasBankCardDetection = true;
    public static final boolean hasFaceEntry = false;
    public static final boolean hasLivenessDetect = false;
    public static final boolean hasNfcKyc = false;
    public static final boolean hasOcrDetect = false;
    public static final boolean hasSdkAsPlugin = false;
    public static final boolean isFaceSDKindependent = false;
    public static final boolean isImmersive = true;
    public static final String sChannelId = "tieba";
    public static final boolean sDebugStatus = false;
    public static final boolean sMtjDbg = false;
    public static final String sSdkVersion = "9.5.0.114";
    public transient /* synthetic */ FieldHolder $fh;

    public BuildConfig() {
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
