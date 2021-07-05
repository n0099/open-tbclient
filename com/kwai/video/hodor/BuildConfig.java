package com.kwai.video.hodor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final String APPLICATION_ID = "com.kwai.video.hodor";
    public static final String BUILD_TYPE = "release";
    public static final boolean CONFIG_LIBCURL = false;
    public static final boolean CONFIG_LIVE_P2SP = false;
    public static final boolean CONFIG_VOD_P2SP = false;
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "noP2p";
    public static final String LIBRARY_PACKAGE_NAME = "com.kwai.video.hodor";
    public static final boolean USE_STATIC_FFMPEG = true;
    public static final int VERSION_CODE = 1000;
    public static final String VERSION_NAME = "r1.0.0.0";
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
