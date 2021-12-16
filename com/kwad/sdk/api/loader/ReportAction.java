package com.kwad.sdk.api.loader;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class ReportAction {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final int ACT_DYNAMIC_DOWNLOAD_FAIL = 62;
    @Keep
    public static final int ACT_DYNAMIC_DOWNLOAD_SUCCESS = 61;
    @Keep
    public static final int ACT_DYNAMIC_INSTALL_START = 63;
    @Keep
    public static final int ACT_DYNAMIC_INSTALL_SUCCESS = 64;
    @Keep
    public static final int ACT_DYNAMIIC_DOWNLOADSTART = 60;
    @Keep
    public static final String KEY_DOWNLOAD_DURATION = "downloadDuration";
    public transient /* synthetic */ FieldHolder $fh;

    public ReportAction() {
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
