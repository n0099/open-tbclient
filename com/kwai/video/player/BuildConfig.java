package com.kwai.video.player;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final String APPLICATION_ID = "com.kwai.video.player";
    public static final String BUILD_TYPE = "release";
    public static final boolean CONFIG_KS_AUDIOPROCESS = false;
    public static final boolean CONFIG_MARLINDRM = false;
    public static final boolean DEBUG = false;
    public static final String DEPENDENT_FFMPEG_ABI_VERSION = "6214227cd0a1f50c2d7cde0837359bf496afaf3a";
    public static final String DEPENDENT_FFMPEG_BINARY_COMMIT = "936d4c04d5bab532d98037205af2dec252099642";
    public static final String DISTRIBUTED_AUDIOPROCESSOR_BINARY_TAG = "v3.4.0.3";
    public static final String FLAVOR = "noP2pNoApNoMarlin";
    public static final String FLAVOR_ap = "noAp";
    public static final String FLAVOR_marlin = "noMarlin";
    public static final String FLAVOR_p2p = "noP2p";
    public static final String LIBRARY_PACKAGE_NAME = "com.kwai.video.player";
    public static final boolean USE_STATIC_FFMPEG = true;
    public static final boolean USE_STATIC_LIBYUV = true;
    public static final int VERSION_CODE = -1;
    public static final String VERSION_NAME = "";
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
